package com.stefanini.stfinancial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
    @Column (name = "tipo_de_patrimonio")
    private String tipoDePatrimonio;

    @NotNull
    @Column (name = "modelo")
    private String modelo;

    @NotNull
    @Column(name = "fabricante")
    private String fabricante;

    @NotNull
    @Column(name = "numero_de_serie")
    private String numeroDeSerie;

    @NotNull
    @Column(name = "data_de_registro")
    private Date dataDeRegistro;

    @NotNull
    @Column(name = "valor_de_aquisicao")
    private BigDecimal valorDeAquisicao;

    @NotNull
    @Column(name = "estado_atual")
    private String estadoAtual;


    @OneToMany(mappedBy = "patrimonio")
    @JsonIgnore
    private List<ContratoEquipamento> contratosEquipamentos;
    public String getFormatedDate(Date date){
        return new SimpleDateFormat("yyyy-MM").format(date);

    }

    public String getFrontFormatedDate(Date date){
        return new SimpleDateFormat("MM/yyyy").format(date);
    }


    public void setIdPatrimonio(){

    }

}
