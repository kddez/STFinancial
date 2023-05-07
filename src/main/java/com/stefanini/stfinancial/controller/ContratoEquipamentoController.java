package com.stefanini.stfinancial.controller;

import com.stefanini.stfinancial.mapper.ContratoEquipamentoMapper;
import com.stefanini.stfinancial.model.AlocacaoProfissionais;
import com.stefanini.stfinancial.model.ContratoEquipamento;
import com.stefanini.stfinancial.repository.ContratoEquipamentoRepository;
import com.stefanini.stfinancial.request.ContratoEquipamentoRequest;
import com.stefanini.stfinancial.service.ContratoEquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequestMapping("/stfinancial/contratoEquipamento")
public class ContratoEquipamentoController {

    @Autowired
    private ContratoEquipamentoService service;

    @Autowired
    private ContratoEquipamentoMapper mapper;

    @Autowired
    private ContratoEquipamentoRepository contratoEquipamentoRepository;


    @RequestMapping(path = "/alterarContratoEquipamento", method = RequestMethod.PUT)
    public ResponseEntity<?> alterarControle(@RequestBody ContratoEquipamentoRequest request) {
        ContratoEquipamento contrato = mapper.toEntity(request);
        return ResponseEntity.ok(service.alterarContratoEquipamento(contrato));
    }

    @RequestMapping(path = "/salvarContratoEquipamento", method = RequestMethod.POST)
    public ResponseEntity<?> salvarContratoEquipamento(@RequestBody ContratoEquipamentoRequest request) {
        ContratoEquipamento contrato = mapper.toEntity(request);
        return ResponseEntity.ok(service.inserirContratoEquipamento(contrato));
    }

    @RequestMapping(path = "listarContratoEquipamento", method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listarContratos());
    }

    @RequestMapping(path = "listarContratosPorId/{idContratoEquipamento}", method = RequestMethod.GET)
    public ResponseEntity<?> listarPorId(@PathVariable Long idContratoEquipamento) {
        return ResponseEntity.ok(service.findContratosByIdContratoEquipamento(idContratoEquipamento));}

    @GetMapping("/listarContratosAtivos")
    public ResponseEntity<?> listarContratosAtivos() {
        return ResponseEntity.ok(service.findAllAtivos());
    }
    @RequestMapping (path = "/deletarContratoEquipamento/{idContratoEquipamento}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarContratoEquipamento (@PathVariable Long idContratoEquipamento) {
        return ResponseEntity.ok(service.deletarContratoEquipamento(idContratoEquipamento));
    }

}

