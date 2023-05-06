package com.stefanini.stfinancial.request;

import com.stefanini.stfinancial.model.StatusPatrimonio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.StatementCreatorUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatrimonioRequest implements Serializable {

    private static final long serialVersionUID = 6017547239678754027L;

    private StatusPatrimonio statusPatrimonio;
    private String tipoDePatrimonio;
    private String modelo;
    private String fabricante;
    private String tempoDeGarantiaMeses;
    private String numeroDeSerie;
    private Date dataDeAquisicao;
    private String notaFiscal;
    private BigDecimal valorDeAquisicao;
    private String estadoAtual;

}
