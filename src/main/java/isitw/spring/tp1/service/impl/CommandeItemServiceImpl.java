package isitw.spring.tp1.service.impl;

import isitw.spring.tp1.dao.CommandeItemDao;
import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.CommandeItem;
import isitw.spring.tp1.service.facade.CommandeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeItemServiceImpl implements CommandeItemService {
    @Autowired
    private CommandeItemDao dao;

    @Override
    public int save(Commande commande) {
        return 0;
    }

    @Override
    public int save(CommandeItem commandeItem) {
        dao.save(commandeItem);
        return 1;
    }
}
