/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoteste.dao;

import br.com.projetoteste.Pessoas;
import br.com.projetoteste.dao.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Caio Ragazzi
 */
public class PessoasDao {

    private Session sessao;
    private Transaction transacao;
    private List<Pessoas> list;

    public List<Pessoas> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        Criteria cri = sessao.createCriteria(Pessoas.class);
        list = cri.list();
        return list;
    }

    public void addPessoa(Pessoas p) {

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            Pessoas pessoa = new Pessoas();
            pessoa.setNome(p.getNome());
            pessoa.setTelefone(p.getTelefone());
            pessoa.setEmail(p.getEmail());
            pessoa.setCpf(p.getCpf());

            sessao.save(pessoa);
            transacao.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }

    public void removePessoa(Pessoas p) {

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.delete(p);
            transacao.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }
    
    public void updatePessoa(Pessoas p) {

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.update(p);
            transacao.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }

}
