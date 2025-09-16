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
public class Configuracoes {
    public static void configurar(int id, String categoria) {
        DespesaEntity despesa = null;
        
        for (DespesaEntity d : DespesasLista.listar()) {
            if (d.getId() == id) {
                    despesa = d;
            }
        }

        try {
            if (despesa != null)
                despesa.setCategoria(categoria);
            else
                throw new Exception("Erro de configuração: despesa nula");
        }
        
        catch(Exception e) {
            System.out.println(e);
        }
    }
}