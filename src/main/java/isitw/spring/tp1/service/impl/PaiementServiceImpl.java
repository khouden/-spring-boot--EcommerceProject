package isitw.spring.tp1.service.impl;

import isitw.spring.tp1.dao.PaiementDao;
import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.Paiement;
import isitw.spring.tp1.service.facade.CommandeService;
import isitw.spring.tp1.service.facade.PaiementService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {

    public int payer(String commandeRef, Paiement paiement) {
        Commande commande = commandeService.findByRef(commandeRef);
        if(commande == null){
            return -1;
        } else if(commande.getTotalPaye().add(paiement.getMontant()).compareTo(commande.getTotal()) > 0){
            return -2;
        }else {
            paiement.setCommande(commande);
            paiement.setDatePaiement(LocalDateTime.now());
            dao.save(paiement);
            return commandeService.payer(commande.getRef(), paiement.getMontant());
        }
    }

    public Paiement findByCode(String code){
        return dao.findByCode(code);
    }

    public List<Paiement> findByCommandeRef(String ref){
        Commande commande = commandeService.findByRef(ref);
        return dao.findByCommandeRef(ref);
    }

    @Override
    public int deleteByCommandeRef(String ref) {
        return dao.deleteByCommandeRef(ref);
    }

    @Override
    public List<Paiement> findAll(){
        return dao.findAll();
    }

    public PaiementServiceImpl(PaiementDao dao, CommandeService commandeService){
        this.dao = dao;
        this.commandeService = commandeService;
    }

    private PaiementDao dao;
    private CommandeService commandeService;
}
