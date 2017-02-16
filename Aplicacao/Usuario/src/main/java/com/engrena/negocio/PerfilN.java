/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.negocio;

import com.engrena.entidade.Perfil;
import com.engrena.regra.PerfilR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class PerfilN implements Serializable {

    @Inject
    PerfilR objR;
  

    public void salvarPerfil(Perfil obj) {

        objR.salvar(obj);

    }

  

    public void removerPerfil(Perfil obj) {

        objR.remover(obj);
    }

    
    public List<Perfil> findAll() {

        return objR.findAll();
    }

  

}
