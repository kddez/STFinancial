package com.stefanini.stfinancial.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatrimonioRequest implements Serializable {

    private static final long serialVersionUID = 6017547239678754027L;

    private String tipoDePatrimonio;
    private String modelo;
    private String fabricante;
    private String numeroDeSerie;
    private Date dataDeRegistro;
    private BigDecimal valorDeAquisicao;
    private String estadoAtual;

}
