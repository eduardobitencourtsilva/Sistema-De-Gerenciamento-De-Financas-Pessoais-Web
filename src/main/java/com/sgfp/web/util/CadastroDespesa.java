/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgfp.web.util;

import com.sgfp.web.data.DespesaEntity;

/**
 *
 * @author eduardo
 */
public class CadastroDespesa {
    public static void cadastrarDespesa(String nome, Double valor, String tipo, String categoria, String status) {
        DespesaEntity d = new DespesaEntity();
        
        d.setCategoria(categoria);
        d.setNome(nome);
        d.setStatus(status);
        d.setTipo(tipo);
        d.setValor(valor);
        
        DespesasLista.atualizar();
    }
}