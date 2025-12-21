package isitw.spring.tp1.dao;

import isitw.spring.tp1.entity.CommandeItem;
import isitw.spring.tp1.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Long> {

}
