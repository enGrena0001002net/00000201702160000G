/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.seguranca.visao;

import com.engrena.entidade.Empresa;
import com.engrena.entidade.Endereco;
import com.engrena.negocio.EmpresaN;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "empresaCadastroV")
@SessionScoped
public class EmpresaCadastroV implements Serializable {

    @Inject
    EmpresaN empresaN;

    Empresa frmEmpresa;
    Endereco frmEndereco;
    List<Empresa> listEmpresa;

    public void novo() {
        setFrmEmpresa(new Empresa());
        setFrmEndereco(new Endereco());

    }

    public void limparForm() {

        setFrmEmpresa(null);
        setFrmEndereco(null);
    }

    public void cancelarPesquisa() {

        setListEmpresa(null);
    }

    public void salvarEmpresa() {

        getFrmEmpresa().setCodUsu(1);

        empresaN.salvarEmpresa(getFrmEmpresa());

    }

    public void recebeEndereco(Empresa empresa) {

        setFrmEmpresa(empresa);
        if (getFrmEmpresa().getCodEnd() != null) {

            setFrmEndereco(getFrmEmpresa().getCodEnd());
        } else {
            setFrmEndereco(new Endereco());
        }

    }

    public void salvarEndereco() {
        try {
            empresaN.salvarEndereco(getFrmEndereco());
            getFrmEmpresa().setCodEnd(getFrmEndereco());
            empresaN.salvarEmpresa(getFrmEmpresa());
        } catch (Exception e) {
            System.out.println("erro salvarEndereco() \n");
            e.printStackTrace();
        }

    }

    public void pesquisarEmresa() {
        setListEmpresa(empresaN.findAll());
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
        return listEmpresa;
    }

    public void setListEmpresa(List<Empresa> listEmpresa) {
        this.listEmpresa = listEmpresa;
    }

}
