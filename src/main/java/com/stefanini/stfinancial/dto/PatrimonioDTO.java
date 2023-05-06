package com.stefanini.stfinancial.dto;

import com.stefanini.stfinancial.model.StatusPatrimonio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatrimonioDTO implements Serializable {

    private static final long serialVersionUID = 6017547239678754027L;

    private Long idPatrimonio;
    private String tipoDePatrimonio;
    private String modelo;
    private String fabricante;
    private String numeroDeSerie;
    private LocalDate dataDeRegistro;
    private Date dataDeAquisicao;
    private String notaFiscal;
    private String tempoDeGarantiaMeses;
    private BigDecimal valorDeAquisicao;
    private String estadoAtual;
    private StatusPatrimonio statusPatrimonio;

}
