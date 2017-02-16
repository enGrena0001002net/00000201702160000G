/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.engrena.seguranca.convert;

import com.engrena.entidade.Empresa;
import com.engrena.fachada.EmpresaFacade;

import com.engrena.util.CDILookupGenerico;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


/**
 *
 * @author mpsilva
 */
@FacesConverter(forClass=com.engrena.entidade.Empresa.class)
public class EmpresaC extends CDILookupGenerico implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null){
            Integer valueOf = Integer.valueOf(value);
          EmpresaFacade facade = getFacadeWithJNDI(EmpresaFacade.class);
           Empresa obj = facade.find(valueOf);
            return obj;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value != null) {
           Empresa obj = (Empresa)value;
            return obj.getCodEmp().toString();
            //throw new UnsupportedOperationException("getAsString "+value);
        }
        return null;
    }
}
