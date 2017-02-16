/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.seguranca.visao;

import com.engrena.entidade.Systema;
import com.engrena.entidade.Endereco;
import com.engrena.negocio.SystemaN;
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
@Named(value = "systemaCadastroV")
@SessionScoped
public class SystemaCadastroV implements Serializable {

    @Inject
    SystemaN systemaN;

    Systema frmSystema;
    Endereco frmEndereco;
    List<Systema> listSystema;

    public void novo() {
        setFrmSystema(new Systema());
        setFrmEndereco(new Endereco());

    }

    public void limparForm() {

        setFrmSystema(null);
        setFrmEndereco(null);
    }

    public void cancelarPesquisa() {

        setListSystema(null);
    }

    public void salvarSystema() {

        if (getFrmSystema().getDtInsSys() == null) {
            systemaN.salvarSystema(getFrmSystema());
        } else {

            systemaN.alterarSystema(getFrmSystema());
        }

    }

    public void removerEmresa(Systema frmSystema) {

        systemaN.removerSystema(frmSystema);
    }

    public void pesquisarEmresa() {
        setListSystema(systemaN.findAll());
    }

    public Systema getFrmSystema() {
        return frmSystema;
    }

    public void setFrmSystema(Systema frmSystema) {
        this.frmSystema = frmSystema;
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

    public List<Systema> getListSystema() {
        return listSystema;
    }

    public void setListSystema(List<Systema> listSystema) {
        this.listSystema = listSystema;
    }

    public void pesquisarNoGrid() {
        setListSystema(systemaN.findAll());
    }

}
