package com.stefanini.stfinancial.controller;

import com.stefanini.stfinancial.mapper.ContratoEquipamentoMapper;
import com.stefanini.stfinancial.model.ContratoEquipamento;
import com.stefanini.stfinancial.repository.ContratoEquipamentoRepository;
import com.stefanini.stfinancial.request.ContratoEquipamentoRequest;
import com.stefanini.stfinancial.service.ContratoEquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(request);
        System.out.println(contrato);
        return ResponseEntity.ok(service.inserirContratoEquipamento(contrato));
    }

}

