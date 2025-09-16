/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgfp.web.service;

import com.sgfp.web.data.DespesaEntity;
import com.sgfp.web.data.DespesaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduardo
 */
@Service
public class DespesaService {
    @Autowired
    DespesaRepository despesaRepository;
    
    public DespesaEntity criarDespesa(DespesaEntity despesa) {
        despesa.setId(null);
        despesaRepository.save(despesa);
        return despesa;
    }
    
    public DespesaEntity atualizarDespesa(Integer despesaID, DespesaEntity despesaRequest) {
        DespesaEntity despesa = getDespesaID(despesaID);
        
        String despesaRequestCategoria = despesaRequest.getCategoria();
        String despesaRequestNome = despesaRequest.getNome();
        String despesaRequestTipo = despesaRequest.getTipo();
        String despesaRequestStatus = despesaRequest.getStatus();
        Double despesaRequestValor = despesaRequest.getValor();
       
        if (despesaRequestValor != null)
            despesa.setValor(despesaRequestValor);
          
        else if (despesaRequestNome != null)
            despesa.setNome(despesaRequestNome);
                
        else if (despesaRequestTipo != null)
            despesa.setTipo(despesaRequestTipo);
        
        else if (despesaRequestCategoria != null)
            despesa.setCategoria(despesaRequestCategoria);
         
        else if (despesaRequestStatus != null)
            despesa.setStatus(despesaRequestStatus);
        
        else
            return despesa;
        
        despesaRepository.save(despesa);
        return despesa;
    }
    
    public DespesaEntity getDespesaID(Integer despesaID) {
        return despesaRepository.findById(despesaID).orElse(null);
    }
    
    public List<DespesaEntity> listarTodasDespesas() {
        return despesaRepository.findAll();
    }
    
    public List<DespesaEntity> listarDespesasPorCategoria(String categoria) {
        return despesaRepository.findDespesasByCategoria(categoria);
    }
    
    public void deletarDespesa(Integer despesaID) {
        despesaRepository.deleteById(despesaID);
    }
}