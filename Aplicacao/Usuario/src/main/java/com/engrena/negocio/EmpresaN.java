/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.negocio;

import com.engrena.entidade.Empresa;
import com.engrena.entidade.Endereco;
import com.engrena.regra.EmpresaR;
import com.engrena.regra.EnderecoR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class EmpresaN implements Serializable {

    @Inject
    EmpresaR empresaR;
    @Inject
    EnderecoR enderecoR;

    public void salvarEmpresa(Empresa obj) {

        empresaR.salvar(obj);

    }

    public void salvarEndereco(Endereco obj) {

        enderecoR.salvar(obj);

    }

    public void removerEmpresa(Empresa obj) {

        empresaR.remover(obj);
    }

    public void removerEndereco(Endereco obj) {

        enderecoR.remover(obj);
    }

    public List<Empresa> findAll() {

        return empresaR.findAll();
    }

    public Empresa find(Empresa obj) {

        return empresaR.find(obj);
    }

}
