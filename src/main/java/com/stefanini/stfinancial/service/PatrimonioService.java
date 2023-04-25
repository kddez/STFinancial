package com.stefanini.stfinancial.service;

import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.repository.PatrimonioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatrimonioService {

    @Autowired
    private final PatrimonioRepository repo;

    public Patrimonio findByIdPatrimonio(Long id){
        return repo.findById(id).get();
    }

    public Patrimonio inserirPatrimonio(Patrimonio patrimonio){
        return repo.save(patrimonio);
    }

    public List<Patrimonio> listarPatrimonios(){
        return repo.findAll();
    }

    public Patrimonio alterarPatrimonio(Patrimonio patrimonio){
        return repo.save(patrimonio);
    }

}
