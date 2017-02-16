/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.engrena.achatipicas.convert;



import com.engrena.achatipicas.entidade.Acao;
import com.engrena.achatipicas.fachada.AcaoFacade;
import com.engrena.achatipicas.util.CDILookupGenerico;

import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


/**
 *
 * @author mpsilva
 */
@FacesConverter(forClass= com.engrena.achatipicas.entidade.Acao.class)
public class AcaoC extends CDILookupGenerico implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null){
            Integer valueOf = Integer.valueOf(value);
          AcaoFacade facade = getFacadeWithJNDI(AcaoFacade.class);
           Acao obj = facade.find(valueOf);
            return obj;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value != null) {
           Acao obj = (Acao)value;
            return obj.getAcaoCod().toString();
            //throw new UnsupportedOperationException("getAsString "+value);
        }
        return null;
    }
}
