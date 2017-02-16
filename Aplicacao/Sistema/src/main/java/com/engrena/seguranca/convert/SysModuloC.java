/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.seguranca.convert;

import com.engrena.entidade.SysModulo;
import com.engrena.fachada.SysModuloFacade;

import com.engrena.util.CDILookupGenerico;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author mpsilva
 */
@FacesConverter(forClass = com.engrena.entidade.SysModulo.class)
public class SysModuloC extends CDILookupGenerico implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
//            Integer valueOf = Integer.valueOf(value);
            SysModuloFacade facade = getFacadeWithJNDI(SysModuloFacade.class);
            SysModulo obj = facade.findCod(value);
            return obj;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            SysModulo obj = (SysModulo) value;
            return obj.getSysModuloPK().getCodMod();
            //throw new UnsupportedOperationException("getAsString "+value);
        }
        return null;
    }
}
