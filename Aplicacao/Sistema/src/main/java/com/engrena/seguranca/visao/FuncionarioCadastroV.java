/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.seguranca.visao;

import com.engrena.entidade.Empresa;
import com.engrena.entidade.Endereco;
import com.engrena.entidade.Funcionario;
import com.engrena.negocio.EmpresaN;
import com.engrena.negocio.FuncionarioN;

import com.engrena.regra.EnderecoR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "funcionarioCadastroV")
@SessionScoped
public class FuncionarioCadastroV implements Serializable {
    
    @Inject
    EmpresaN empresaN;
    @Inject
    FuncionarioN funcionarioN;
    @Inject
    EnderecoR enderecoR;
    
    Empresa frmEmpresa;
    Endereco frmEndereco;
    Funcionario frmFuncionario;
    List<Empresa> listEmpresa;
    List<Funcionario> listFuncionarios;
    
    public void novo() {
        setFrmFuncionario(new Funcionario());
        setFrmEmpresa(new Empresa());
        
    }
    
    public void limparForm() {
        setFrmFuncionario(null);
        setFrmEmpresa(null);
        setFrmEndereco(null);
    }
    
    public void cancelarPesquisa() {
        
    }
    
    public void salvar() {
        
        funcionarioN.salvarFuncionario(getFrmFuncionario());
        
    }
    
    public void addEndereco(Funcionario item) {
        setFrmFuncionario(item);
        
        if (item.getCodEnd() == null) {
            
            setFrmEndereco(new Endereco());
            
        } else {
            setFrmEndereco(item.getCodEnd());
        }
        
    }
    
    public void salvarEnd() {
        
        enderecoR.salvar(getFrmEndereco());
        
        getFrmFuncionario().setCodEnd(getFrmEndereco());
        funcionarioN.salvarFuncionario(getFrmFuncionario());
        
    }
    
    public void salvarFuncionario() {
        try {
            funcionarioN.salvarEndereco(getFrmEndereco());
            getFrmEmpresa().setCodEnd(getFrmEndereco());
            empresaN.salvarEmpresa(getFrmEmpresa());
        } catch (Exception e) {
            System.out.println("erro salvarEndereco() \n");
            e.printStackTrace();
        }
        
    }
    
    public void pesquisarNoGrid() {
        setListFuncionarios(funcionarioN.findAll());
    }
    
    public Empresa getFrmEmpresa() {
        return frmEmpresa;
    }
    
    public void setFrmEmpresa(Empresa frmEmpresa) {
        this.frmEmpresa = frmEmpresa;
    }
    
    public Endereco getFrmEndereco() {
        if (frmEndereco == null) {
            frmEndereco = new Endereco();
            
        }
        
        return frmEndereco;
    }
    
    public void setFrmEndereco(Endereco frmEndereco) {
        this.frmEndereco = frmEndereco;
    }
    
    public List<Empresa> getListEmpresa() {
        listEmpresa = empresaN.findAll();
        
        return listEmpresa;
    }
    
    public void setListEmpresa(List<Empresa> listEmpresa) {
        this.listEmpresa = listEmpresa;
    }
    
    public Funcionario getFrmFuncionario() {
        if (frmFuncionario == null) {
            frmFuncionario = new Funcionario();
        }
        
        return frmFuncionario;
    }
    
    public void setFrmFuncionario(Funcionario frmFuncionario) {
        this.frmFuncionario = frmFuncionario;
    }
    
    public List<Funcionario> getListFuncionarios() {
        return listFuncionarios;
    }
    
    public void setListFuncionarios(List<Funcionario> listFuncionarios) {
        this.listFuncionarios = listFuncionarios;
    }
    
}
