package isitw.spring.tp1.ws.dto;

import isitw.spring.tp1.entity.EtatCommande;
import java.math.BigDecimal;


public class CommandeDto {
    private String ref;
    private BigDecimal total;
    private BigDecimal totalPaye;
    private String etatCommande;


    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(BigDecimal totalPaye) {
        this.totalPaye = totalPaye;
    }

    public String getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(String etatCommande) {
        this.etatCommande = etatCommande;
    }
}
