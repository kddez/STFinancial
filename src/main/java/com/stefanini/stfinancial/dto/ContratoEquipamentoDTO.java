package com.stefanini.stfinancial.dto;

import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.model.Profissional;
import com.stefanini.stfinancial.model.ProfissionalId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoEquipamentoDTO implements Serializable {

    private static final long serialVersionUID = 6017547239678754027L;

    private Patrimonio patrimonio;
    private Long idPatrimonio;
    private String status;
    private Date dataAlocacao;
    private Date dataDevolucao;
    private String detalhesContrato;
    private Long matricula;
    private Date mesComp;
    private ProfissionalId profissionalId;
    private Boolean situacaoContrato;
}
