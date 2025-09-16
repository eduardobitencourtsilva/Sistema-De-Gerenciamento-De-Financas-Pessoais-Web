/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgfp.web.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduardo
 */
@Repository
public interface DespesaRepository extends JpaRepository<DespesaEntity, Integer> {
    @Query(value="SELECT * FROM despesas WHERE categoria = :categoria", nativeQuery=true)
    List<DespesaEntity> findDespesasByCategoria(@Param("categoria") String categoria);
}