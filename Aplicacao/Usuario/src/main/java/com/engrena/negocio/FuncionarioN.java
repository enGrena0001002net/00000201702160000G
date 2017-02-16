/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.negocio;

import com.engrena.entidade.Funcionario;
import com.engrena.entidade.Endereco;
import com.engrena.regra.EmpresaR;
import com.engrena.regra.FuncionarioR;
import com.engrena.regra.EnderecoR;
import com.engrena.regra.FuncionarioR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class FuncionarioN implements Serializable {

    @Inject
    FuncionarioR funcionarioR;
    @Inject
    EmpresaR empresaR;
    @Inject
    EnderecoR enderecoR;

    public void salvarFuncionario(Funcionario obj) {

        funcionarioR.salvar(obj);

    }

    public void salvarEndereco(Endereco obj) {

        enderecoR.salvar(obj);

    }

    public void removerFuncionario(Funcionario obj) {

        funcionarioR.remover(obj);
    }

 

    public List<Funcionario> findAll() {

        return funcionarioR.findAll();
    }

    public Funcionario find(Funcionario obj) {

        return funcionarioR.find(obj);
    }

}
