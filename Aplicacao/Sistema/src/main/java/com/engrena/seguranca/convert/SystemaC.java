/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.engrena.seguranca.convert;

import com.engrena.entidade.Systema;
import com.engrena.fachada.SystemaFacade;

import com.engrena.util.CDILookupGenerico;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


/**
 *
 * @author mpsilva
 */
@FacesConverter(forClass=com.engrena.entidade.Systema.class)
public class SystemaC extends CDILookupGenerico implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null){
//            Integer valueOf = Integer.valueOf(value);
          SystemaFacade facade = getFacadeWithJNDI(SystemaFacade.class);
           Systema obj = facade.find(value);
            return obj;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value != null) {
           Systema obj = (Systema)value;
            return obj.getCodSys();
            //throw new UnsupportedOperationException("getAsString "+value);
        }
        return null;
    }
}
