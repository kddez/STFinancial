package com.stefanini.stfinancial.request;

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
public class ContratoEquipamentoRequest implements Serializable {

    private Patrimonio patrimonio;
    private Long idPatrimonio;
    private String status;
    private Date dataAlocacao;
    private Date dataDevolucao;
    private String detalhesContrato;
    private Long matricula;
    private Date mesComp;
    private ProfissionalId profissionalId;
    private Boolean ativo;
}
