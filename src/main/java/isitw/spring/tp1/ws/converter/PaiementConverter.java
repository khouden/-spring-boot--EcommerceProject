package isitw.spring.tp1.ws.converter;

import isitw.spring.tp1.entity.Paiement;
import isitw.spring.tp1.ws.dto.PaiementDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaiementConverter {

    public Paiement toItem(PaiementDto paiementDto){
        Paiement item  = new Paiement();
        BeanUtils.copyProperties(paiementDto, item);
        return item;
    }

    public PaiementDto toDto(Paiement paiement){
        PaiementDto dto = new PaiementDto();
        BeanUtils.copyProperties(paiement, dto);
        dto.setCommandeRef(paiement.getCommande().getRef());
        return dto;
    }

    public List<PaiementDto> toDtos(List<Paiement> paiementList){
        return paiementList.stream().map(e -> toDto(e)).toList();
    }
}
