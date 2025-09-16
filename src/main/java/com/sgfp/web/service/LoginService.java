/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgfp.web.service;

import com.sgfp.web.data.LoginEntity;
import com.sgfp.web.data.LoginRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduardo
 */
@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;
    
    public LoginEntity criarLogin(LoginEntity login) {
        login.setId(null);
        loginRepository.save(login);
        return login;
    }
    
    public LoginEntity atualizarLogin(Integer loginID, LoginEntity loginRequest) {
        LoginEntity login = getLoginID(loginID);
        
        login.setId(loginRequest.getId());
        login.setTipo(loginRequest.getTipo());
        login.setNome(loginRequest.getNome());
        login.setSenha(loginRequest.getSenha());
        
        loginRepository.save(login);
        return login;
    }
    
    public LoginEntity getLoginID(Integer loginID) {
        return loginRepository.findById(loginID).orElse(null);
    }
    
    public List<LoginEntity> listarTodosLogins() {
        return loginRepository.findAll();
    }
    
    public void deletarLogin(Integer loginID) {
        loginRepository.deleteById(loginID);
    }
}