package isitw.spring.tp1.ws.facade;

import isitw.spring.tp1.entity.Paiement;
import isitw.spring.tp1.service.facade.PaiementService;
import isitw.spring.tp1.ws.converter.PaiementConverter;
import isitw.spring.tp1.ws.dto.PaiementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiement/")
public class PaiementWs {

    @Autowired
    private PaiementService service;

    @Autowired
    private PaiementConverter converter;


    @GetMapping("code/{code}")
    public PaiementDto findByCode(@PathVariable String code){
        Paiement paiement = service.findByCode(code);
        return converter.toDto(paiement);
    }

    @PostMapping("cmdRef/{cmdRef}")
    public int payer(@PathVariable String cmdRef, @RequestBody PaiementDto paiementDto){
        Paiement paiement = converter.toItem(paiementDto);
        return service.payer(cmdRef, paiement);
    }

}
