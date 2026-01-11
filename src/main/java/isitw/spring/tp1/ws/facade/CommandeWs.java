package isitw.spring.tp1.ws.facade;

import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.service.facade.CommandeService;
import isitw.spring.tp1.ws.converter.CommandeConverter;
import isitw.spring.tp1.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande/")
public class CommandeWs {

    @Autowired
    private CommandeService service;

    @Autowired
    private CommandeConverter converter;

    @PostMapping
    public int save(@RequestBody CommandeDto commandeDto) {
        Commande item = converter.toItem(commandeDto);
        return service.save(item);
    }

    @GetMapping
    public List<CommandeDto> findAll() {
        List<Commande> commands = service.findAll();
        List<CommandeDto> dtos = converter.toDtos(commands);
        return dtos;
    }

    @GetMapping("ref/{ref}")
    public CommandeDto findByRef(@PathVariable String ref) {
        Commande commande = service.findByRef(ref);
        return converter.toDto(commande);
    }

    @GetMapping("etatCode/{code}")
    public List<CommandeDto> findByEtatCommandeCode(@PathVariable String code) {
        List<Commande> commandes = service.findByEtatCommandeCode(code);
        return converter.toDtos(commandes);
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return service.deleteByRef(ref);
    }
}
