/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.seguranca.visao;

import com.engrena.entidade.Acao;
import com.engrena.negocio.AcaoN;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "acaoV")
@SessionScoped
public class AcaoV implements Serializable {

    @Inject
    AcaoN acaoN;

    Acao frmAcao;

    List<Acao> listAcao;

    public void novo() {
        setFrmAcao(new Acao());
        getFrmAcao().setAtvAco(true);

    }

    public void limparForm() {

        setFrmAcao(null);

    }

    public void salvarAcao() {

        acaoN.salvarAcao(getFrmAcao());

    }

    public void remover(Acao frmAcao) {
        acaoN.removerAcao(frmAcao);

    }

    public Acao getFrmAcao() {
        if (frmAcao == null) {
            frmAcao = new Acao();
        }
        return frmAcao;
    }

    public void setFrmAcao(Acao frmAcao) {

        this.frmAcao = frmAcao;
    }

    public List<Acao> getListAcao() {

        return acaoN.findAll();
    }

}
