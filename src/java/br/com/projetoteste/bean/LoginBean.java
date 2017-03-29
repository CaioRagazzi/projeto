/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoteste.bean;

import br.com.projetoteste.Usuario;
import br.com.projetoteste.dao.LoginDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Caio Ragazzi
 */

@ManagedBean
@SessionScoped
public class LoginBean {
    
    private Usuario usuario = new Usuario();
    private LoginDao logindao = new LoginDao();
    
    public String login(){
        
        logindao.login(usuario);
        return "login";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
