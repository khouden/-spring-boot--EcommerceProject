package isitw.spring.tp1.ws.converter;

import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.ws.dto.CommandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandeConverter {



    public Commande toItem(CommandeDto dto){
        Commande item  = new Commande();
        BeanUtils.copyProperties(dto, item);
        return item;
    }
    public CommandeDto toDto(Commande item){
        if (item == null) return null;
        CommandeDto dto  = new CommandeDto();
        BeanUtils.copyProperties(item, dto);
        dto.setEtatCommande(item.getEtatCommande().getLibelle());
        return dto;
    }

    public List<CommandeDto> toDtos(List<Commande> commandeList) {
        return commandeList.stream().map(e -> toDto(e)).toList();
    }
}
