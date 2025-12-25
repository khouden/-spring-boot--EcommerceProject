package isitw.spring.tp1.ws.converter;

import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.EtatCommande;
import isitw.spring.tp1.ws.dto.CommandeDto;
import isitw.spring.tp1.ws.dto.EtatCommandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EtatCommandeConverter {



    public EtatCommande toItem(EtatCommandeDto dto){
        EtatCommande item  = new EtatCommande();
        BeanUtils.copyProperties(dto, item);
        return item;
    }
    public EtatCommandeDto toDto(EtatCommande item){
        EtatCommandeDto dto  = new EtatCommandeDto();
        BeanUtils.copyProperties(item, dto);
        return dto;
    }

    public List<EtatCommandeDto> toDtos(List<EtatCommande> etatCommandeList) {
        return etatCommandeList.stream().map(e -> toDto(e)).toList();
    }
}
