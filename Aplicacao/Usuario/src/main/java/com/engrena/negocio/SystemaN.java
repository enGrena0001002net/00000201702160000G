/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.negocio;

import com.engrena.entidade.Systema;
import com.engrena.entidade.Endereco;
import com.engrena.regra.SystemaR;
import com.engrena.regra.EnderecoR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class SystemaN implements Serializable {

    @Inject
    SystemaR systemaR;

    public void salvarSystema(Systema obj) {

        systemaR.salvar(obj);

    }

    public void alterarSystema(Systema obj) {

        systemaR.aletarar(obj);

    }

    public void removerSystema(Systema obj) {

        systemaR.remover(obj);
    }

    public List<Systema> findAll() {

        return systemaR.findAll();
    }

    public Systema find(String codSys) {

        return systemaR.find(codSys);

    }

}
