package isitw.spring.tp1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class EtatCommande {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String libelle;


    public EtatCommande(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public EtatCommande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
