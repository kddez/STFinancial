package com.stefanini.stfinancial.service;

import com.stefanini.stfinancial.model.*;
import com.stefanini.stfinancial.repository.ContratoEquipamentoRepository;
import com.stefanini.stfinancial.repository.PatrimonioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratoEquipamentoService {

    @Autowired
    private final ContratoEquipamentoRepository repo;

    @Autowired
    private final PatrimonioRepository patrimonioRepository;

    public ContratoEquipamento inserirContratoEquipamento(ContratoEquipamento contratoEquipamento) {

        //Verifico se o patrimônio que está sendo passado existe;
        Patrimonio patrimonio = patrimonioRepository.findById(contratoEquipamento.getPatrimonio().getIdPatrimonio())
                .orElseThrow(() -> new RuntimeException("Patrimonio não encontrado"));
        //Verifico se o patrimônio que está sendo passado está disponível;
        if (patrimonio.getStatusPatrimonio() != StatusPatrimonio.DISPONIVEL) {
            throw new RuntimeException("O patrimônio não está disponível");
        }
        //Seta o contrato como ativo;
        contratoEquipamento.setAtivo(true);
        //cria o contrato
        contratoEquipamento = repo.save(contratoEquipamento);
        //muda o status do patrimônio de DISPONIVEL para EM_USO após a criação do contrato;
        patrimonio.setStatusPatrimonio(StatusPatrimonio.EM_USO);
        //salva a mudança do patrimônio;
        patrimonioRepository.save(patrimonio);
        return contratoEquipamento;

    }

    public List<ContratoEquipamento> listarContratos() {
        return repo.findAll();

    }

    public List<ContratoEquipamento> findContratosByIdContratoEquipamento(Long idContratoEquipamento) {
        return repo.findContratosByIdContratoEquipamento(idContratoEquipamento);
    }
    public Object alterarContratoEquipamento(ContratoEquipamento contratoEquipamento) {
        return repo.save(contratoEquipamento);
   }


}
