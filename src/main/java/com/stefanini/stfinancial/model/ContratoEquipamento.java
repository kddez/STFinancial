package com.stefanini.stfinancial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stefanini.stfinancial.request.ContratoEquipamentoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name= "ContratoEquipamento")
@Table(name= "ContratoEquipamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContratoEquipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContratoEquipamento;
    @Column(name = "status")
    private String status;
    @Column(name = "data_alocacao")
    private Date dataAlocacao;
    @Column(name = "data_devolucao")
    private Date dataDevolucao;
    @Column(name = "detalhes_contrato")
    private String detalhesContrato;

    @Column(name= "situacao_contrato")
    private boolean situacaoContrato;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "matricula", insertable = false, updatable = false),
            @JoinColumn(name = "mesComp", insertable = false, updatable = false)
    })
    private Profissional profissional;

    @Columns(columns = {@Column(name="mesComp"), @Column(name="matricula")})
    private ProfissionalId profissionalId;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPatrimonio", referencedColumnName = "idPatrimonio")
    private Patrimonio patrimonio;


    public String getFormatedDate(Date date) {
        return new SimpleDateFormat("yyyy-MM").format(date);
    }

    public String getFrontFormatedDate(Date date) {
        return new SimpleDateFormat("MM/yyyy").format(date);
    }
}
