package com.stefanini.stfinancial.repository;

import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.model.Profissional;
import com.stefanini.stfinancial.model.StatusPatrimonio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {

    List<Patrimonio> findAllByStatusPatrimonio(StatusPatrimonio statusPatrimonio);

    Patrimonio findByNumeroDeSerie(String numeroDeSerie);

}
