package com.stefanini.stfinancial.repository;

import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {


    List<Patrimonio> findByIdPatrimonio(Long idPatrimonio);


}
