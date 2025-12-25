package isitw.spring.tp1.dao;

import isitw.spring.tp1.entity.Paiement;
import isitw.spring.tp1.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {
        Paiement findByCode(String code);
        List<Paiement> findByCommandeRef(String ref);

        int deleteByCommandeRef(String ref);
}
