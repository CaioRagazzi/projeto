/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoteste.dao;

import br.com.projetoteste.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author Caio Ragazzi
 */
public class LoginDao {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();
    
    public void login(Usuario user){
            
            EntityTransaction entr = em.getTransaction();
            entr.begin();            
            
            Query query = em.createQuery("select u from Usuario u where u.nome=:arg1");
            query.setParameter("arg1", user.getNome());
            
            List result = query.getResultList();
          
            entr.commit();
            em.close();
    }
    
}
