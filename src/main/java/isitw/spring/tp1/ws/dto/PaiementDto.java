package isitw.spring.tp1.ws.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaiementDto {
    private String code;
    private BigDecimal montant;
    private LocalDateTime datePaiement;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

}
