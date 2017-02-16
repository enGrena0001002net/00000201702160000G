/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "util")
@RequestScoped
public class util implements Serializable {

    public String retornaSimNao(Boolean b) {
        return b ? "Sim" : "Não";
    }

}
