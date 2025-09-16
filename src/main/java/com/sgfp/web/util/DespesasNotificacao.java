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
public class DespesasNotificacao {
    private DespesaEntity despesa;

    public DespesaEntity getDespesa() {
        return despesa;
    }

    public void setDespesa(DespesaEntity despesa) {
        this.despesa = despesa;
    }
    
    public String getMensagem() {
        return "Você tem a conta " + despesa.getNome() + " de id " + despesa.getId() + " para pagar!";
    }
}