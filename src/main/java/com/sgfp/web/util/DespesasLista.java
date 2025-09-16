/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgfp.web.util;

import com.sgfp.web.data.DespesaEntity;
import com.sgfp.web.data.DespesaRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class DespesasLista {
    private static List<DespesaEntity> lista = new ArrayList();

    public static List<DespesaEntity> listar() {
        return lista;
    }

    public static void atualizar() { 

    }

    public static void adicionar(DespesaEntity d) { 
        lista.add(d);
    }

    public static void remover(DespesaEntity d) { 
        lista.remove(d);
    }

    public static void organizar() {
        Collections.sort(lista, new DespesasComparator());
    }
}
