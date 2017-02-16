/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.seguranca.convert;

import com.engrena.entidade.Processo;
import com.engrena.fachada.ProcessoFacade;

import com.engrena.util.CDILookupGenerico;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author mpsilva
 */
@FacesConverter(forClass = com.engrena.entidade.Processo.class)
public class ProcessoC extends CDILookupGenerico implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
//            Integer valueOf = Integer.valueOf(value);
            ProcessoFacade facade = getFacadeWithJNDI(ProcessoFacade.class);
            Processo obj = facade.find(value);
            return obj;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Processo obj = (Processo) value;
            return obj.getCodPco();
            //throw new UnsupportedOperationException("getAsString "+value);
        }
        return null;
    }
}
