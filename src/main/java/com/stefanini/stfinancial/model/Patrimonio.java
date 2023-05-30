package com.stefanini.stfinancial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    private String tipoDePatrimonio;

    @NotNull
    private String modelo;

    @NotNull
    private String fabricante;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusPatrimonio statusPatrimonio;

    @NotNull
    private String numeroDeSerie;

    private LocalDate dataDeRegistro;

    @NotNull
    private BigDecimal valorDeAquisicao;

    @NotNull
    private String estadoAtual;

    @NotBlank
    private String notaFiscal;

    @NotNull
    private String tempoDeGarantiaMeses;

    @NotNull
    private Date dataDeAquisicao;

    @OneToMany(mappedBy = "patrimonio")
    @JsonIgnore
    private List<ContratoEquipamento> contratosEquipamentos;


    public String getFormatedDate(Date date){
        return new SimpleDateFormat("yyyy-MM").format(date);

    }
    public String getFrontFormatedDate(Date date){
        return new SimpleDateFormat("MM/yyyy").format(date);
    }

}
