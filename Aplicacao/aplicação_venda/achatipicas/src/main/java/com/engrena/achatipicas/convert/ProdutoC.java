/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.convert;

import com.engrena.achatipicas.entidade.Produto;
import com.engrena.achatipicas.entidade.ProdutoPK;
import com.engrena.achatipicas.fachada.ProdutoFacade;
import com.engrena.achatipicas.util.CDILookupGenerico;

import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author mpsilva
 */
@FacesConverter(forClass = com.engrena.achatipicas.entidade.Produto.class)
public class ProdutoC extends CDILookupGenerico implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            String[] pk = value.split("#");
            
            ProdutoPK valueOf = new ProdutoPK();
            valueOf.setLojaCod(Integer.parseInt(pk[0]));
            valueOf.setLojaCod(Integer.parseInt(pk[1]));
            
            ProdutoFacade facade = getFacadeWithJNDI(ProdutoFacade.class);
            Produto obj = facade.find(valueOf);
            return obj;
        }
        return null;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Produto obj = (Produto) value;
            return Integer.toString(obj.getProdutoPK().getProdutoCod()) + "#" + Integer.toString(obj.getProdutoPK().getLojaCod());
            //throw new UnsupportedOperationException("getAsString "+value);
        }
        return null;
    }
}
