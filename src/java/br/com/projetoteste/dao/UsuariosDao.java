/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoteste.dao;

import br.com.projetoteste.Usuario;
import br.com.projetoteste.dao.util.HibernateUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Caio Ragazzi
 */
public class UsuariosDao {

    private Session sessao;
    private Transaction transacao;

    public void addUsuario(Usuario p) {

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            Usuario usuario = new Usuario();
            usuario.setNome(p.getNome());
            usuario.setEmail(p.getEmail());
            usuario.setSenha(p.getSenha());

            sessao.save(usuario);
            transacao.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }



}
