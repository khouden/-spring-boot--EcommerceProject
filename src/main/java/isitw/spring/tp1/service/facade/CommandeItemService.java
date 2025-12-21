package isitw.spring.tp1.service.facade;

import isitw.spring.tp1.dao.CommandeDao;
import isitw.spring.tp1.entity.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommandeService {
    public int save(Commande commande);

    public List<Commande> findAll();

    public Commande findByRef(String ref);
}
