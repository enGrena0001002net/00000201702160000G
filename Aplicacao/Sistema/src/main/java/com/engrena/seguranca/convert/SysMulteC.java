/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.seguranca.convert;

import com.engrena.entidade.SysMulte;
import com.engrena.fachada.SysMulteFacade;

import com.engrena.util.CDILookupGenerico;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author mpsilva
 */
@FacesConverter(forClass = com.engrena.entidade.SysMulte.class)
public class SysMulteC extends CDILookupGenerico implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
//            Integer valueOf = Integer.valueOf(value);
            SysMulteFacade facade = getFacadeWithJNDI(SysMulteFacade.class);
            System.out.println("#####  "+value);
            SysMulte obj = facade.findCod(value);
            return obj;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            SysMulte obj = (SysMulte) value;
            return obj.getSysMultePK().getCodMut();
            //throw new UnsupportedOperationException("getAsString "+value);
        }
        return null;
    }
}
