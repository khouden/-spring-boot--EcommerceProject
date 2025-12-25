package isitw.spring.tp1.dao;

import isitw.spring.tp1.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
    Commande findByRef(String ref);
    @Query("SELECT item FROM Commande item WHERE item.total >= :total")
    List<Commande> findByTotalLessThan(@Param("total") BigDecimal total);
    void deleteByRef(String ref);
}
