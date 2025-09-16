/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgfp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author eduardo
 */
@Controller
public class PageController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/tabela")
    public String tabela(@CookieValue(name="loginID", defaultValue="0") Integer loginID) {
        if (loginID.equals(0)) {
            return "index";
        }
        return "tabela";
    }
    
    @GetMapping("/cadastro")
    public String cadastro(@CookieValue(name="loginID", defaultValue="0") Integer loginID) {
        if (loginID.equals(0)) {
            return "index";
        }
        return "cadastro";
    }
    
    @GetMapping("/config")
    public String config(@CookieValue(name="loginID", defaultValue="0") Integer loginID) {
        if (loginID.equals(0)) {
            return "index";
        }
        return "config";
    }
}