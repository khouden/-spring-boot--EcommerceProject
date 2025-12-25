package isitw.spring.tp1.service.facade;

import isitw.spring.tp1.entity.Paiement;

import java.util.List;

public interface PaiementService {
    public Paiement findByCode(String ref);
    public int payer(String commandeRef, Paiement paiement);
    public List<Paiement> findAll();
    public List<Paiement> findByCommandeRef(String ref);
    int deleteByCommandeRef(String code);
}
