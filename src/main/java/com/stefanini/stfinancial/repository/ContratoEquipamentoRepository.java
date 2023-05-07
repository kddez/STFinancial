package com.stefanini.stfinancial.repository;

import com.stefanini.stfinancial.model.ContratoEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface ContratoEquipamentoRepository extends JpaRepository<ContratoEquipamento, Long> {

    List<ContratoEquipamento> findContratosByIdContratoEquipamento(Long idContratoEquipamento);
    List<ContratoEquipamento> findAllByAtivoTrue();

}
