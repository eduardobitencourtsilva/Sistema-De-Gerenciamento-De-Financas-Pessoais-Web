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
public class DespesasComparator implements java.util.Comparator<DespesaEntity> {
    @Override
    public int compare(DespesaEntity a, DespesaEntity b) {
        return a.getId() - b.getId();
    }
}