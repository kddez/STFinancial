package com.stefanini.stfinancial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patrimonio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPatrimonio;

    @NotNull
    @Column
    private String tipoDePatrimonio;

    @NotNull
    @Column
    private String modelo;

    @NotNull
    @Column
    private String fabricante;

    @NotNull
    @Column
    private String numeroDeSerie;

    @NotNull
    @Column
    private Date dataDeRegistro;

    @NotNull
    @Column
    private BigDecimal valorDeAquisicao;

    @NotNull
    @Column
    private String estadoAtual;

    public String getFormatedDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public String getFrontFormatedDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataDeRegistro);
    }
    public String getFrontFormatedCurrency(BigDecimal value) {
        return "R$" + String.format("%,.2f", value);
    }

}
