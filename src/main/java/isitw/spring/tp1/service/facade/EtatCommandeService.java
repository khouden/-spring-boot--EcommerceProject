package isitw.spring.tp1.service.facade;

import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.EtatCommande;

import java.util.List;

public interface EtatCommandeService {
    public int save(EtatCommande etatCommande);

    public List<EtatCommande> findAll();

    public EtatCommande findByCode(String ref);

    int deleteByCode(String code);

    EtatCommande findNew();

    EtatCommande findOk();

    EtatCommande findEncours();
}
