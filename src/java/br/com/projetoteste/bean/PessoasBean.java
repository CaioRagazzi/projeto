/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoteste.bean;

import br.com.projetoteste.Pessoas;
import br.com.projetoteste.dao.PessoasDao;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Caio Ragazzi
 */
@ManagedBean
@SessionScoped
public class PessoasBean {

    private Pessoas pessoa = new Pessoas();
    private PessoasDao pessoaDao = new PessoasDao();
    private List<Pessoas> listaPessoas;

    /**
     * Creates a new instance of PessoasBean
     */
    public PessoasBean() {
    }

    public String adicionarPessoa() {

        pessoaDao.addPessoa(pessoa);
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setTelefone(null);
        pessoa.setCpf(null);
        return "index";
    }

    public String removerPessoa(Pessoas p) {
        this.pessoa = p;
        pessoaDao.removePessoa(pessoa);
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setTelefone(null);
        pessoa.setCpf(null);
        return "index";
    }

    public List listarPessoas() {
        listaPessoas = pessoaDao.getList();

        return this.listaPessoas;
    }
    
    public String carregaPessoa(Pessoas p){
        pessoa = p;
        return "editar";
    }
    
    public String atualizaPessoa(){
        pessoaDao.updatePessoa(pessoa);
        pessoa.setId(null);
        pessoa.setCpf(null);
        pessoa.setEmail(null);
        pessoa.setNome(null);
        pessoa.setTelefone(null);
        
        return "index";
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.pessoa);
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
        final PessoasBean other = (PessoasBean) obj;
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

}