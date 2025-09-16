/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgfp.web.controller;

import com.sgfp.web.data.DespesaEntity;
import com.sgfp.web.service.DespesaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduardo
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/despesas")
public class DespesasRestController {
    @Autowired
    DespesaService despesaService;
    
    @GetMapping("/listar")
    public ResponseEntity<List> buscarTodasDespesas() {
        List<DespesaEntity> despesas = despesaService.listarTodasDespesas();
        return new ResponseEntity<>(despesas, HttpStatus.OK);
    }
    
    @PostMapping("/adicionar")
    public ResponseEntity<DespesaEntity> adicionarDespesa(@RequestBody DespesaEntity despesa) {
        var novaDespesa = despesaService.criarDespesa(despesa);
        return new ResponseEntity<>(novaDespesa, HttpStatus.CREATED);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<DespesaEntity> atualizarDespesa(@PathVariable Integer id, @RequestBody DespesaEntity despesa) {
        var despesaAtualizada = despesaService.atualizarDespesa(id, despesa);
        return new ResponseEntity<>(despesaAtualizada, HttpStatus.OK);
    }
    
    @GetMapping("/pesquisarPorCategoria/{categoria}")
    public ResponseEntity<List> buscarDespesasPorCategoria(@PathVariable String categoria) {
        List<DespesaEntity> despesas = despesaService.listarDespesasPorCategoria(categoria);
        return new ResponseEntity<>(despesas, HttpStatus.OK);
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<DespesaEntity> deletarDespesa(@PathVariable int id) {
        despesaService.deletarDespesa(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}