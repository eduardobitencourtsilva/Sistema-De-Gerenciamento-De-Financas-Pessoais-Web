/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgfp.web.controller;

import com.sgfp.web.data.LoginEntity;
import com.sgfp.web.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduardo
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginRestController {
    @Autowired
    LoginService loginService;
    
    @GetMapping("/listar")
    public ResponseEntity<List> listarLogin() {
        List<LoginEntity> users = loginService.listarTodosLogins();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}