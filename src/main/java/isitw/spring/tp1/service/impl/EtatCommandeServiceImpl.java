package isitw.spring.tp1.service.impl;

import isitw.spring.tp1.dao.CommandeDao;
import isitw.spring.tp1.dao.EtatCommandeDao;
import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.CommandeItem;
import isitw.spring.tp1.service.facade.CommandeService;
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
        }else if (commande.getTotalPaye() != null && commande.getTotalPaye().compareTo(commande.getTotal()) > 0) {
            return -2;
        }else {
            dao.save(commande);
            if (commande.getCommandeItems() != null) {
                for (CommandeItem commandeItem : commandeItems){
                    commandeItem.setCommande(commande);
                }
            }
            return 1;
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
        }  else if (commande.getTotalPaye().add(montant).compareTo(commande.getTotal()) > 0 ){
            return -2;
        } else {
            BigDecimal nvTotalPaye = commande.getTotalPaye().add(montant);
            commande.setTotalPaye(nvTotalPaye);
            dao.save(commande);
            return 1;
        }
    }

    @Override
    public int deleteByRef(String ref){
        Commande commande = findByRef(ref);
        if (commande == null) {
            return -1;
        } else if (commande.getTotalPaye().compareTo(BigDecimal.ZERO) > 0) {
            return -2;
        } else {
            dao.delete(commande);
            return 1;
        }
    }

    public CommandeServiceImpl(CommandeDao dao) {
        this.dao = dao;
    }

    private CommandeDao dao;
}
