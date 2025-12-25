package isitw.spring.tp1.service.facade;

import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.CommandeItem;

public interface CommandeItemService {
    public int save(Commande commande);

    int save(CommandeItem commandeItem);
}
