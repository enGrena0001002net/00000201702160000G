/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.engrena.achatipicas.convert;



import com.engrena.achatipicas.entidade.Loja;
import com.engrena.achatipicas.fachada.LojaFacade;
import com.engrena.achatipicas.util.CDILookupGenerico;

import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


/**
 *
 * @author mpsilva
 */
@FacesConverter(forClass= com.engrena.achatipicas.entidade.Loja.class)
public class LojaC extends CDILookupGenerico implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null){
            Integer valueOf = Integer.valueOf(value);
          LojaFacade facade = getFacadeWithJNDI(LojaFacade.class);
           Loja obj = facade.find(valueOf);
            return obj;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value != null) {
           Loja obj = (Loja)value;
            return obj.getLojaCod().toString();
            //throw new UnsupportedOperationException("getAsString "+value);
        }
        return null;
    }
}
