package com.stefanini.stfinancial.mapper;


import com.stefanini.stfinancial.dto.ContratoEquipamentoDTO;
import com.stefanini.stfinancial.model.ContratoEquipamento;
import com.stefanini.stfinancial.repository.PatrimonioRepository;
import com.stefanini.stfinancial.repository.ProfissionalRepository;
import com.stefanini.stfinancial.request.ContratoEquipamentoRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContratoEquipamentoMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public ContratoEquipamento toEntity(ContratoEquipamentoRequest contratoEquipamentoRequest){
        ContratoEquipamento contratoEquipamento = modelMapper.map(contratoEquipamentoRequest, ContratoEquipamento.class);
        return contratoEquipamento;
    }

    public ContratoEquipamento toDto(ContratoEquipamentoDTO contratoEquipamentoDTO) {
        return modelMapper.map(contratoEquipamentoDTO, ContratoEquipamento.class);
    }

}
