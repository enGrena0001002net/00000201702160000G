/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.negocio;

import com.engrena.entidade.SysMulte;
import com.engrena.entidade.SysModulo;
import com.engrena.entidade.SysModuloPK;
import com.engrena.entidade.SysMultePK;
import com.engrena.entidade.Systema;
import com.engrena.regra.SysMulteR;
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
public class SysMulteN implements Serializable {

    @Inject
    SysMulteR multeR;

    @Inject
    SysModuloR sysModuloR;

    public void salvarSysMulte(SysMulte obj, SysMultePK pK) {

        multeR.salvar(obj, pK);

    }

    public void salvarModulo(SysModulo obj, SysModuloPK pk) {

        sysModuloR.salvar(obj, pk);

    }

    public void removerModulo(SysModulo obj) {

        sysModuloR.remover(obj);

    }

    public void removerSysMulte(SysMulte obj) {

        multeR.remover(obj);
    }

    public List<SysMulte> findAll() {

        return multeR.findAll();
    }
    
    

}
