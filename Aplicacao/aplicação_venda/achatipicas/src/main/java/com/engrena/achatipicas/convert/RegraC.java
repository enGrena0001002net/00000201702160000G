/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.engrena.achatipicas.convert;



import com.engrena.achatipicas.entidade.Regra;
import com.engrena.achatipicas.fachada.RegraFacade;
import com.engrena.achatipicas.util.CDILookupGenerico;

import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


/**
 *
 * @author mpsilva
 */
@FacesConverter(forClass= com.engrena.achatipicas.entidade.Regra.class)
public class RegraC extends CDILookupGenerico implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null){
            Integer valueOf = Integer.valueOf(value);
          RegraFacade facade = getFacadeWithJNDI(RegraFacade.class);
           Regra obj = facade.find(valueOf);
            return obj;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value != null) {
           Regra obj = (Regra)value;
            return obj.getRegrasCod().toString();
            //throw new UnsupportedOperationException("getAsString "+value);
        }
        return null;
    }
}
