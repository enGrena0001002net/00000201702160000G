/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.negocio;

import com.engrena.entidade.Acao;
import com.engrena.entidade.Endereco;
import com.engrena.regra.AcaoR;
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
public class AcaoN implements Serializable {

    @Inject
    AcaoR objR;
  

    public void salvarAcao(Acao obj) {

        objR.salvar(obj);

    }

  

    public void removerAcao(Acao obj) {

        objR.remover(obj);
    }

    
    public List<Acao> findAll() {

        return objR.findAll();
    }

  

}
