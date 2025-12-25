package isitw.spring.tp1.dao;

import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.EtatCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatCommandeDao extends JpaRepository<EtatCommande, Long> {
    EtatCommande findByCode(String code);
    int deleteByCode(String code);
}
