/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.negocio;

import com.engrena.entidade.Processo;
import com.engrena.entidade.SysModuloPK;
import com.engrena.regra.ProcessoR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class ProcessoN implements Serializable {
    
    @Inject
    ProcessoR sysModuloR;
    
    public void salvarProcesso(Processo obj) {
        
        sysModuloR.salvar(obj);
        
    }
    
    public void removerProcesso(Processo obj) {
        
        sysModuloR.remover(obj);
    }
    
    public List<Processo> findAll(SysModuloPK obj) {
        
        return sysModuloR.findAll(obj);
    }
    
}
