package com.stefanini.stfinancial.service;

import com.stefanini.stfinancial.model.*;
import com.stefanini.stfinancial.repository.ContratoEquipamentoRepository;
import com.stefanini.stfinancial.repository.PatrimonioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContratoEquipamentoService {

    @Autowired
    private final ContratoEquipamentoRepository repo;

    @Autowired
    private final PatrimonioRepository patrimonioRepository;

    public ContratoEquipamento inserirContratoEquipamento(ContratoEquipamento contratoEquipamento) {

        Patrimonio patrimonio = patrimonioRepository.findById(contratoEquipamento.getPatrimonio().getIdPatrimonio())
                .orElseThrow(() -> new RuntimeException("Patrimonio não encontrado"));
        if (patrimonio.getStatusPatrimonio() != StatusPatrimonio.DISPONIVEL) {
            throw new RuntimeException("O patrimônio não está disponível");
        }
        contratoEquipamento.setAtivo(true);

        contratoEquipamento = repo.save(contratoEquipamento);

        patrimonio.setStatusPatrimonio(StatusPatrimonio.EM_USO);

        patrimonioRepository.save(patrimonio);
        return contratoEquipamento;

    }

    public List<ContratoEquipamento> listarContratos() {
        return repo.findAll();

    }
    public String deletarContratoEquipamento(Long idContratoEquipamento) {

        Optional<ContratoEquipamento> optionalContratoEquipamento = repo.findById(idContratoEquipamento);

        //Verifico se o contrato existe
        if(optionalContratoEquipamento.isPresent()){

            //Obtenho o conteúdo do optional
            ContratoEquipamento contrato = optionalContratoEquipamento.get();
            // insiro o contrato como 67inativo e data do momento da exclusão
            contrato.setAtivo(false);
            contrato.setDataExclusaoContrato(LocalDate.now());
            repo.save(contrato);

            //patrimonio é setado como pendente em todo o sistema.
            Optional<Patrimonio> optionalPatrimonio = patrimonioRepository.findById(contrato.getPatrimonio().getIdPatrimonio());
            Patrimonio patrimonio = optionalPatrimonio.get();
            optionalPatrimonio.get().setStatusPatrimonio(StatusPatrimonio.PENDENTE_DEVOLUCAO);
            patrimonioRepository.save(patrimonio);

        } else {
            throw new RuntimeException("O patrimônio de id: " + idContratoEquipamento + " não foi encontrado");
        }
        return "Contrato  desfeito";
    }

    public List<ContratoEquipamento> findAllAtivos() {
        return repo.findAllByAtivoTrue();
    }

    public List<ContratoEquipamento> findContratosByIdContratoEquipamento(Long idContratoEquipamento) {
        return repo.findContratosByIdContratoEquipamento(idContratoEquipamento);
    }
    public Object alterarContratoEquipamento(ContratoEquipamento contratoEquipamento) {
        return repo.save(contratoEquipamento);
   }


}
