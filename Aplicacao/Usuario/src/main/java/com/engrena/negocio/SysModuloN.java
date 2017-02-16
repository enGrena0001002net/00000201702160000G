/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.negocio;

import com.engrena.entidade.SysModulo;
import com.engrena.entidade.Endereco;
import com.engrena.entidade.SysModuloPK;
import com.engrena.entidade.SysMultePK;
import com.engrena.regra.SysModuloR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class SysModuloN implements Serializable {
    
    @Inject
    SysModuloR sysModuloR;
    
    public void salvarSysModulo(SysModulo obj, SysModuloPK pk) {
        
        sysModuloR.salvar(obj, pk);
        
    }
    
    public void removerSysModulo(SysModulo obj) {
        
        sysModuloR.remover(obj);
    }
    
    public List<SysModulo> findAll(SysMultePK obj) {
        
        return sysModuloR.findAll(obj);
    }
    
}
