package isitw.spring.tp1;

import isitw.spring.tp1.dao.CommandeDao;
import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.EtatCommande;
import isitw.spring.tp1.service.constant.EtatCommandeConstant;
import isitw.spring.tp1.service.facade.EtatCommandeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp1Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp1Application.class, args);
    }

    @Bean
    CommandLineRunner init(EtatCommandeService etatCommandeService) {
        return args -> {
            etatCommandeService.save(new EtatCommande(EtatCommandeConstant.New, "Nouveau"));
            etatCommandeService.save(new EtatCommande(EtatCommandeConstant.Pending, "En cours"));
            etatCommandeService.save(new EtatCommande(EtatCommandeConstant.Ok, "Terminé"));
        };
    }

}
