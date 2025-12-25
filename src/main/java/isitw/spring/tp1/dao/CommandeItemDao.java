package isitw.spring.tp1.dao;

import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem, Long> {

}
