package isitw.spring.tp1.service.impl;

import isitw.spring.tp1.dao.CommandeDao;
import isitw.spring.tp1.dao.PaiementDao;
import isitw.spring.tp1.entity.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    private CommandeDao dao;

    @Override
    public int save(Commande commande) {
        if (findByRef(commande.getRef()) != null) {
            return -1;
        }else if (commande.getTotalPaye() != null && commande.getTotalPaye().compareTo(commande.getTotal()) > 0) {
            return -2;
        }else {
            dao.save(commande);
            return 1;
        }
    }

    @Override
    public List<Commande> findAll() {
        return dao.findAll();
    }

    @Override
    public Commande findByRef(String ref) {
        return dao.findByRef(ref);
    }
}
