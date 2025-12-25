package isitw.spring.tp1.service.facade;

import isitw.spring.tp1.entity.Commande;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeService {
    public int save(Commande commande);

    public List<Commande> findAll();

    public Commande findByRef(String ref);

    int payer(String ref, BigDecimal montant);

    int deleteByRef(String ref);
}
