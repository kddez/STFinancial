package com.stefanini.stfinancial.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Celula implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	private Long idCelula;
	@Column
	@NotNull
	private String dsCelula;
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "celula")
	@JsonIgnore
	private List<Operacao> operacoes;
}
