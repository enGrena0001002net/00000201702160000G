/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.seguranca.visao;

import com.engrena.entidade.SysMulte;
import com.engrena.entidade.Endereco;
import com.engrena.entidade.Processo;
import com.engrena.entidade.SysModulo;
import com.engrena.entidade.SysModuloPK;
import com.engrena.entidade.SysMultePK;
import com.engrena.entidade.Systema;
import com.engrena.negocio.ProcessoN;
import com.engrena.negocio.SysModuloN;
import com.engrena.negocio.SysMulteN;
import com.engrena.negocio.SystemaN;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "sysMulteCadastroV")
@SessionScoped
public class SysMulteCadastroV implements Serializable {
    
    @Inject
    SysMulteN sysMulteN;
    @Inject
    SystemaN systemaN;
    @Inject
    SysModuloN sysModuloN;
    @Inject
    ProcessoN processoN;
    
    SysMulte frmSysMulte;
    SysMultePK frmSysMultePK;
    Systema frmSystema;
    SysModulo frmModulo;
    SysModuloPK frmModuloPK;
    Processo frmProcesso;
    
    Endereco frmEndereco;
    List<SysMulte> listSysMulte;
    List<SysModulo> listSysModulo;
    List<Processo> listProcesso;
    
    public void novo() {
        setFrmSysMulte(new SysMulte());
        setFrmEndereco(new Endereco());
        setFrmSysMultePK(new SysMultePK());
        
    }
    
    public void limparForm() {
        
        setFrmSysMulte(null);
        setFrmEndereco(null);
        setFrmSysMultePK(null);
    }
    
    public void cancelarPesquisa() {
        
        setListSysMulte(null);
        setListSysModulo(null);
    }
    
    public void salvarSysMulte() {
        getFrmSysMulte().setSystema(getFrmSystema());
        getFrmSysMultePK().setCodSys(getFrmSystema().getCodSys());
        
        sysMulteN.salvarSysMulte(getFrmSysMulte(), getFrmSysMultePK());
        
    }
    
    public void recebe(SysMulte item) {
        setFrmSysMulte(item);
        setFrmSysMultePK(item.getSysMultePK());
        setFrmSystema(systemaN.find(getFrmSysMultePK().getCodSys()));
        
        setListSysModulo(sysModuloN.findAll(getFrmSysMultePK()));
        
    }
    
    public void recebeModulo(SysModulo modulo) {
        setFrmModulo(modulo);
        setFrmModuloPK(modulo.getSysModuloPK());
        
    }
    
    public void novoModulo(SysMulte item) {
        setFrmSysMulte(item);
        setFrmSysMultePK(item.getSysMultePK());
        setFrmSystema(systemaN.find(getFrmSysMultePK().getCodSys()));
        setFrmModulo(new SysModulo());
        setFrmModuloPK(new SysModuloPK());
        getFrmModuloPK().setCodMut(getFrmSysMultePK().getCodMut());
        getFrmModuloPK().setCodSys(getFrmSystema().getCodSys());
        
    }
    
    public void salvarModulo() {
        
        sysModuloN.salvarSysModulo(getFrmModulo(), getFrmModuloPK());
        
    }
    
    public void limparFrmModulo() {
        
        setFrmModuloPK(null);
        setFrmModulo(null);
    }
    
    public void pesquisarEmresa() {
        setListSysMulte(sysMulteN.findAll());
    }
    
    public SysMulte getFrmSysMulte() {
        return frmSysMulte;
    }
    
    public void setFrmSysMulte(SysMulte frmSysMulte) {
        this.frmSysMulte = frmSysMulte;
    }
    
    public Endereco getFrmEndereco() {
        if (frmEndereco == null) {
            frmEndereco = new Endereco();
            
        }
        
        return frmEndereco;
    }
    
    public void novoProcesso() {
        
        setFrmProcesso(new Processo());
        
    }
    
    public void limparProcesso() {
        
        setFrmProcesso(null);
    }
    
    public void recebeProcesso(Processo item) {
        
        setFrmProcesso(item);
    }

    public void salvarProcesso() {
        
        getFrmProcesso().setSysModulo(getFrmModulo());
        processoN.salvarProcesso(getFrmProcesso());
        
    }
    
    public void setFrmEndereco(Endereco frmEndereco) {
        this.frmEndereco = frmEndereco;
    }
    
    public List<SysMulte> getListSysMulte() {
        return listSysMulte;
    }
    
    public List<Systema> getListSystema() {
        return systemaN.findAll();
    }
    
    public void setListSysMulte(List<SysMulte> listSysMulte) {
        this.listSysMulte = listSysMulte;
    }
    
    public void pesquisarNoGrid() {
        setListSysMulte(sysMulteN.findAll());
    }
    
    public SysMultePK getFrmSysMultePK() {
        return frmSysMultePK;
    }
    
    public void setFrmSysMultePK(SysMultePK frmSysMultePK) {
        this.frmSysMultePK = frmSysMultePK;
    }
    
    public Systema getFrmSystema() {
        return frmSystema;
    }
    
    public void setFrmSystema(Systema frmSystema) {
        this.frmSystema = frmSystema;
    }
    
    public SysModulo getFrmModulo() {
        return frmModulo;
    }
    
    public void setFrmModulo(SysModulo frmModulo) {
        this.frmModulo = frmModulo;
    }
    
    public SysModuloPK getFrmModuloPK() {
        return frmModuloPK;
    }
    
    public void setFrmModuloPK(SysModuloPK frmModuloPK) {
        this.frmModuloPK = frmModuloPK;
    }
    
    public List<SysModulo> getListSysModulo() {
        return listSysModulo;
    }
    
    public void setListSysModulo(List<SysModulo> listSysModulo) {
        this.listSysModulo = listSysModulo;
    }
    
    public Processo getFrmProcesso() {
        return frmProcesso;
    }
    
    public void setFrmProcesso(Processo frmProcesso) {
        this.frmProcesso = frmProcesso;
    }
    
    public List<Processo> getListProcesso() {
        
        return processoN.findAll(getFrmModulo().getSysModuloPK());
    }
    
}
