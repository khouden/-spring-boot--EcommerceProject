package isitw.spring.tp1.ws.facade;

import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.EtatCommande;
import isitw.spring.tp1.service.facade.CommandeService;
import isitw.spring.tp1.service.facade.EtatCommandeService;
import isitw.spring.tp1.ws.converter.CommandeConverter;
import isitw.spring.tp1.ws.converter.EtatCommandeConverter;
import isitw.spring.tp1.ws.dto.CommandeDto;
import isitw.spring.tp1.ws.dto.EtatCommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etat_commande/")
public class EtatCommandeWs {

    @Autowired
    private EtatCommandeService service;

    @Autowired
    private EtatCommandeConverter converter;

    @PostMapping
    public int save(@RequestBody EtatCommandeDto etatCommandeDto) {
        EtatCommande item = converter.toItem(etatCommandeDto);
        return service.save(item);
    }

    @GetMapping
    public List<EtatCommandeDto> findAll() {
        List<EtatCommande> etatCommands = service.findAll();
        List<EtatCommandeDto> dtos = converter.toDtos(etatCommands);
        return dtos;
    }

    @GetMapping("code/{code}")
    public EtatCommandeDto findByCode(@PathVariable String code) {
        EtatCommande etatCommande = service.findByCode(code);
        return converter.toDto(etatCommande);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }
}
