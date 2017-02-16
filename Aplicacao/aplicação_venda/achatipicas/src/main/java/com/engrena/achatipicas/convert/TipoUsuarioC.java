/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.convert;

import com.engrena.achatipicas.entidade.TipoUsuario;
import com.engrena.achatipicas.fachada.TipoUsuarioFacade;
import com.engrena.achatipicas.util.CDILookupGenerico;

import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author mpsilva
 */
@FacesConverter(forClass = com.engrena.achatipicas.entidade.TipoUsuario.class)
public class TipoUsuarioC extends CDILookupGenerico implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            Integer valueOf = Integer.valueOf(value);
            TipoUsuarioFacade facade = getFacadeWithJNDI(TipoUsuarioFacade.class);
            TipoUsuario obj = facade.find(valueOf);
            return obj;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            TipoUsuario obj = (TipoUsuario) value;
            return obj.getTpCodigo().toString();
            //throw new UnsupportedOperationException("getAsString "+value);
        }
        return null;
    }
}
