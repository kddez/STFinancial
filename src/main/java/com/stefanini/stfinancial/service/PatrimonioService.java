package com.stefanini.stfinancial.service;

import com.stefanini.stfinancial.model.FaturamentoId;
import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.model.StatusPatrimonio;
import com.stefanini.stfinancial.repository.PatrimonioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatrimonioService {

    @Autowired
    private final PatrimonioRepository repo;

    public Patrimonio findByIdPatrimonio(Long id){
        return repo.findById(id).get();
    }

    public Patrimonio inserirPatrimonio(Patrimonio patrimonio){

        Patrimonio pat = repo.findByNumeroDeSerie(patrimonio.getNumeroDeSerie());
        if (pat != null){
            throw new RuntimeException("Este produto já consta no sistema");
        }else if (patrimonio.getNumeroDeSerie().length() < 5){
            throw new RuntimeException("Número de série inserido é inválido");
        }
        return repo.save(patrimonio);
    }


    public List<Patrimonio> listarPatrimonios(){
        return repo.findAll();
    }

    public List<Patrimonio> findAllDisponiveis() {
        return repo.findAllByStatusPatrimonio(StatusPatrimonio.DISPONIVEL);
    }

    public Patrimonio alterarPatrimonio(Patrimonio patrimonio){
        return repo.save(patrimonio);
    }


    public String deletarPatrimonio(Long idPatrimonio) {

        Optional <Patrimonio> optPatri = repo.findById(idPatrimonio);
        if(optPatri.isPresent() && optPatri.get().getStatusPatrimonio() != StatusPatrimonio.EM_USO ){
            Patrimonio patrimonio = optPatri.get();
            patrimonio.setStatusPatrimonio(StatusPatrimonio.DESCARTADO);
            repo.save(patrimonio);
        } else {
            throw new RuntimeException("O patrimônio de id: " + idPatrimonio + " não foi encontrado ou está em uso");
        }
        return "Patrimônio deletado";
    }
}
