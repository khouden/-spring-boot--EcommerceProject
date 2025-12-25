
package isitw.spring.tp1.service.impl;

import isitw.spring.tp1.dao.CommandeDao;
import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.CommandeItem;
import isitw.spring.tp1.service.facade.CommandeService;
import isitw.spring.tp1.service.facade.EtatCommandeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {


    @Override
    public int save(Commande commande) {
        List<CommandeItem> commandeItems = commande.getCommandeItems();
        if (findByRef(commande.getRef()) != null) {
            return -1;
        } else if (commande.getTotalPaye() != null && commande.getTotalPaye().compareTo(commande.getTotal()) > 0) {
            return -2;
        } else {
            prepareEtatCommande(commande);
            dao.save(commande);
            if (commande.getCommandeItems() != null) {
                for (CommandeItem commandeItem : commandeItems) {
                    commandeItem.setCommande(commande);
                }
            }
            return 1;
        }
    }

    private void prepareEtatCommande(Commande commande) {
        if (commande.getTotalPaye().compareTo(BigDecimal.ZERO) == 0) {
            commande.setEtatCommande(etatCommandeService.findNew());
        } else if (commande.getTotalPaye().compareTo(commande.getTotal()) == 0) {
            commande.setEtatCommande(etatCommandeService.findOk());
        } else {
            commande.setEtatCommande(etatCommandeService.findEncours());
        }
    }

    @Override
    public List<Commande> findAll() {
        return dao.findAll();
    }

    @Override
    public Commande findByRef(String ref) {
        return dao.findByRef(ref);
    }

    @Override
    public int payer(String ref, BigDecimal montant) {
        Commande commande = findByRef(ref);
        if (commande == null) {
            return -1;
        } else if (commande.getTotalPaye().add(montant).compareTo(commande.getTotal()) > 0) {
            return -2;
        } else {
            BigDecimal nvTotalPaye = commande.getTotalPaye().add(montant);
            commande.setTotalPaye(nvTotalPaye);
            prepareEtatCommande(commande);
            dao.save(commande);
            return 1;   
        }
    }

    @Transactional
    @Override
    public int deleteByRef(String ref) {
        Commande commande = findByRef(ref);
        if (commande == null) {
            return -1;
        } else if (commande.getTotalPaye().compareTo(BigDecimal.ZERO) > 0) {
            return -2;
        } else {
            paiementService.deleteByCommandeRef(commande.getRef());
            dao.deleteByRef(commande.getRef());
            return 1;
        }
    }

    public CommandeServiceImpl(CommandeDao dao, EtatCommandeService etatCommandeService) {
        this.dao = dao;
        this.etatCommandeService = etatCommandeService;
    }

    private CommandeDao dao;
    private EtatCommandeService etatCommandeService;
    private PaiementServiceImpl paiementService;
}
