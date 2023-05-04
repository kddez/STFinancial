package com.stefanini.stfinancial.service;

import com.stefanini.stfinancial.model.ContratoEquipamento;
import com.stefanini.stfinancial.repository.ContratoEquipamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratoEquipamentoService {

    @Autowired
    private final ContratoEquipamentoRepository repo;

    public ContratoEquipamento inserirContratoEquipamento(ContratoEquipamento contratoEquipamento) {

        return repo.save(contratoEquipamento);

    }

    public Object alterarContratoEquipamento(ContratoEquipamento contratoEquipamento) {
        return repo.save(contratoEquipamento);
   }

}
