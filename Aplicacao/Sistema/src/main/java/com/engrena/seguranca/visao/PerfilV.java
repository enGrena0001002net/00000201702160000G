/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.seguranca.visao;

import com.engrena.entidade.Acao;
import com.engrena.entidade.Perfil;
import com.engrena.entidade.PerfilProcesso;
import com.engrena.entidade.PerfilProcessoPK;
import com.engrena.entidade.Processo;
import com.engrena.entidade.SysModulo;
import com.engrena.entidade.SysModuloPK;
import com.engrena.entidade.SysMulte;
import com.engrena.entidade.SysMultePK;
import com.engrena.entidade.Systema;
import com.engrena.negocio.AcaoN;
import com.engrena.negocio.PerfilN;
import com.engrena.negocio.PerfilProcessoN;
import com.engrena.negocio.SystemaN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "perfilV")
@SessionScoped
public class PerfilV implements Serializable {

    @Inject
    AcaoN acaoN;
    @Inject
    PerfilN perfilN;
    @Inject
    PerfilProcessoN perfilProcessoN;
    @Inject
    SystemaN systemaN;

    Acao frmAcao;
    Perfil frmPerfil;
    PerfilProcesso frmPerfilProcesso;
    PerfilProcessoPK perfilProcessoPK;

    Systema frmSystema;
    SysMulte frmSysMulte;
    SysModulo frmModulo;
    Processo frmProcesso;

    List<Perfil> listPerfil;

    public void pesquisarPerfil() {

        setListPerfil(perfilN.findAll());
    }

    public void salvarPerfilProcesso() {

        perfilProcessoN.salvar(getFrmPerfilProcesso(), getPerfilProcessoPK());
        getFrmPerfilProcesso().setPerfilProcessoPK(getPerfilProcessoPK());
        getFrmPerfil().getPerfilProcessoList().add(getFrmPerfilProcesso());
        salvarPerfil();
    }

    public void novo() {
        setFrmPerfil(new Perfil());

    }

    public void recebePerfil(Perfil obj) {

        setFrmPerfil(obj);

    }

    public void addAcao(Acao acao) {
        if (getFrmPerfilProcesso().getAcaoList().isEmpty()) {
            getFrmPerfilProcesso().setAcaoList(new ArrayList<Acao>());
        }

        getFrmPerfilProcesso().getAcaoList().add(acao);
        perfilProcessoN.salvar(getFrmPerfilProcesso(), null);

    }

    public void removAcao(Acao acao) {

        getFrmPerfilProcesso().getAcaoList().remove(acao);
        perfilProcessoN.salvar(getFrmPerfilProcesso(), null);

    }

    public void novoPerfilProcesso(Perfil item) {
        setFrmPerfil(item);
        setFrmPerfilProcesso(new PerfilProcesso());
        getFrmPerfilProcesso().setPerfil(getFrmPerfil());
        setPerfilProcessoPK(new PerfilProcessoPK());
        getPerfilProcessoPK().setCodPfl(getFrmPerfil().getCodPfl());

    }

    public void limparForm() {

        setFrmPerfil(null);
        setFrmPerfilProcesso(null);

    }

    public void limparFormPerfilProcesso() {

        setFrmPerfil(null);
        setFrmPerfilProcesso(null);
        setFrmSystema(null);
        setFrmSysMulte(null);
        setFrmModulo(null);
        setFrmProcesso(null);

    }

    public void limparGrid() {
        setListPerfil(null);
    }

    public void salvarPerfil() {

        perfilN.salvarPerfil(getFrmPerfil());

    }

    public void remover(Perfil obj) {
        perfilN.removerPerfil(obj);

    }

    public void removerPerfilProcesso(PerfilProcesso item) {

        perfilProcessoN.remover(item);
    }

    public Perfil getFrmPerfil() {
        return frmPerfil;
    }

    public void setFrmPerfil(Perfil frmPerfil) {
        this.frmPerfil = frmPerfil;
    }

    public PerfilProcesso getFrmPerfilProcesso() {
        return frmPerfilProcesso;
    }

    public void setFrmPerfilProcesso(PerfilProcesso frmPerfilProcesso) {
        this.frmPerfilProcesso = frmPerfilProcesso;
    }

    public List<Perfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<Perfil> listPerfil) {
        this.listPerfil = listPerfil;
    }

    public PerfilProcessoPK getPerfilProcessoPK() {
        return perfilProcessoPK;
    }

    public void setPerfilProcessoPK(PerfilProcessoPK perfilProcessoPK) {
        this.perfilProcessoPK = perfilProcessoPK;
    }

    public Acao getFrmAcao() {
        return frmAcao;
    }

    public void setFrmAcao(Acao frmAcao) {
        this.frmAcao = frmAcao;
    }

    public Systema getFrmSystema() {
        if (frmSystema == null) {
            frmSystema = new Systema();
        }
        return frmSystema;
    }

    public void setFrmSystema(Systema frmSystema) {
        this.frmSystema = frmSystema;
    }

    public SysMulte getFrmSysMulte() {
        if (frmSysMulte == null) {
            frmSysMulte = new SysMulte();
            frmSysMulte.setSysMultePK(new SysMultePK());
        }
        return frmSysMulte;
    }

    public void setFrmSysMulte(SysMulte frmSysMulte) {
        this.frmSysMulte = frmSysMulte;
    }

    public SysModulo getFrmModulo() {
        if (frmModulo == null) {
            frmModulo = new SysModulo();
            frmModulo.setSysModuloPK(new SysModuloPK());
        }

        return frmModulo;
    }

    public void setFrmModulo(SysModulo frmModulo) {
        this.frmModulo = frmModulo;
    }

    public List<Systema> listarSistema() {

        return systemaN.findAll();
    }

    public List<Acao> listarAcao() {

        return acaoN.findAll();
    }

    public Processo getFrmProcesso() {
        if (frmProcesso == null) {
            frmProcesso = new Processo();

        }
        return frmProcesso;
    }

    public void setFrmProcesso(Processo frmProcesso) {
        this.frmProcesso = frmProcesso;
    }

}
