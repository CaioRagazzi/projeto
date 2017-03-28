/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoteste.bean;

import br.com.projetoteste.Usuario;
import br.com.projetoteste.dao.UsuariosDao;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Caio Ragazzi
 */
@ManagedBean
@SessionScoped
public class UsuariosBean {
    
    private Usuario usuario = new Usuario();
    private UsuariosDao usuariosdao = new UsuariosDao();
    
    public UsuariosBean(){
        
    }
    
    public String addUsuario(){
        
        usuariosdao.addUsuario(usuario);
        usuario.setNome("");
        usuario.setEmail("");
        usuario.setSenha("");
        return "login";
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuariosBean other = (UsuariosBean) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
   
    
    public String novoLogin(){
        return "criarlogin";
    }
    
}
