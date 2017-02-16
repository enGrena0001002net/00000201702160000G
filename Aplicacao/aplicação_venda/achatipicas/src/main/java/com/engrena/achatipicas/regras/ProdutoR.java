/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.regras;

import com.engrena.achatipicas.entidade.Loja;
import com.engrena.achatipicas.entidade.Produto;
import com.engrena.achatipicas.entidade.ProdutoPK;
import com.engrena.achatipicas.entidade.TipoProduto;
import com.engrena.achatipicas.fachada.ProdutoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class ProdutoR implements Serializable {
    
    @EJB
    ProdutoFacade facade;
    Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    Severity msgTypInfo = FacesMessage.SEVERITY_INFO;
    
    public void salvar(Produto obj, ProdutoPK pK) {
        try {
            
            if (obj.getProdutoPK() == null) {
                pK.setProdutoCod(facade.retornaCodProd(pK.getLojaCod()));
                
                obj.setProdutoPK(pK);
                
                facade.create(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Salvos "));
            } else {
                
                facade.edit(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Alterados"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Persistir Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }
        
    }
    
    public void remover(Produto obj) {
        
        try {
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Remover Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }
        
    }
    
    public List< Produto> findAll() {
        
        return facade.findAll();
    }
    
    public List< Produto> pesquisaProduto(String produtoNome, Boolean produtoAtivo, Loja lojaCod, TipoProduto produtoTpCod) {
        
        return facade.pesquisaProduto(produtoNome, produtoAtivo, lojaCod, produtoTpCod);
    }

    public void desativar(Produto obj) {
        
        try {
            obj.setProdutoAtivo(false);
            salvar(obj, null);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Usuário Desativado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Desativar Usuário"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }
        
    }
    
    public void ativar(Produto obj) {
        
        try {
            obj.setProdutoAtivo(true);
            salvar(obj, null);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Usuário Ativado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Ativar Usuário"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }
        
    }
}
