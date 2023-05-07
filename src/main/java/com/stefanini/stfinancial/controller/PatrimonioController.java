package com.stefanini.stfinancial.controller;

import com.stefanini.stfinancial.mapper.PatrimonioMapper;
import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.model.StatusPatrimonio;
import com.stefanini.stfinancial.request.PatrimonioRequest;
import com.stefanini.stfinancial.service.PatrimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/stfinancial/patrimonio")

public class PatrimonioController {

    @Autowired
    private PatrimonioService service;

    @Autowired
    PatrimonioMapper mapper;

    @GetMapping("/buscar/{id}")
    public Patrimonio buscarPorId(@PathVariable Long id){
    return service.findByIdPatrimonio(id);
    }

    @RequestMapping(path = "/salvarPatrimonio", method = RequestMethod.POST)
    public ResponseEntity<?> salvarPatrimonio(@RequestBody PatrimonioRequest request){
        Patrimonio patri = mapper.toEntity(request);
        patri.setDataDeRegistro(LocalDate.now());
        return ResponseEntity.ok(service.inserirPatrimonio(patri));
    }

    @RequestMapping(path = "/alterarPatrimonio" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarPatrimonio(@RequestBody PatrimonioRequest request){
        Patrimonio patri = mapper.toEntity(request);
        return ResponseEntity.ok(service.alterarPatrimonio(patri));
    }

    @RequestMapping (path = "/listarPatrimonios", method = RequestMethod.GET)
    public ResponseEntity<?> listar() {return ResponseEntity.ok(service.listarPatrimonios());}

    @RequestMapping (path = "/listarPatrimoniosDisponiveis", method = RequestMethod.GET)
    public ResponseEntity<?> listarDisponiveis() {return ResponseEntity.ok(service.findAllDisponiveis());}

    @RequestMapping (path = "/deletarPatrimonio/{idPatrimonio}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarPatrimonio (@PathVariable Long idPatrimonio) {
        return ResponseEntity.ok(service.deletarPatrimonio(idPatrimonio));
    }




}
