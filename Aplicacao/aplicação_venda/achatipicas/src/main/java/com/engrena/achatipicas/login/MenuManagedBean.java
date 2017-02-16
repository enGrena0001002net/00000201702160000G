/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.login;

import com.engrena.achatipicas.entidade.Acao;
import com.engrena.achatipicas.entidade.Grupo;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.swing.Spring;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named(value = "menuManagedBean")
@SessionScoped
public class MenuManagedBean implements Serializable {

//    private MenuModel menu;
//    private String paginaAnterior;
//    private String pagina = "home.xhtml";
//    List<Acao> listAcao;
//
//    public void onClose(CloseEvent event) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
//
//    public void onToggle(ToggleEvent event) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
//
//    public void carregar(String pagina, String acao) {
//        setListAcao(new ArrayList<Acao>());
//        setPagina(pagina);
//        String[] acoes = acao.split("#");
//        int contador = 0;
//        for (String ac : acoes) {
//            Acao obAcao = new Acao();
//            obAcao.getAcaoCod(acoes[contador]);
//
//            getListAcao().add(obAcao);
//            contador++;
//
//        }
//
//    }
//
//    public void novaPagina(String pgina) {
//        setPaginaAnterior(getPagina());
//        setPagina(pgina);
//        System.out.println("_:confPahtPg:_\n"
//                + "paginaAnterior:" + getPaginaAnterior() + "\n"
//                + "pagina        :" + getPagina());
//    }
//
//    public void retornarPagina() {
//        setPagina(getPaginaAnterior());
//        System.out.println("_:confPahtPg:_\n"
//                + "paginaAnterior:" + getPaginaAnterior() + "\n"
//                + "pagina        :" + getPagina());
//    }
//
//    public String habilitarBotao(int acao) {
//        boolean desabilitado = true;
//
//        try {
//
//            for (Acao obj : getListAcao()) {
//
//                if (obj.getAcaoCod().equals(acao)) {
//
//                    desabilitado = false;
//                }
//
//            }
//
//        } catch (Exception e) {
//            System.out.println("erro ao verificar permição");
//            e.printStackTrace();
//
//        }
//        return "" + desabilitado;
//
//    }
//
//    @SuppressWarnings("CallToPrintStackTrace")
//    public MenuModel subSisList(List<Grupo> list) {
//        menu = new DefaultMenuModel();
//
//        //System.out.println("lista " + list.toString());
//        int contSubSistema = 0;
//        DefaultMenuItem itemHome = new DefaultMenuItem("Home");
//        itemHome.setIcon("home_icon");
//        itemHome.setCommand("#{menuManagedBean.setPagina(\"home.xhtml\")}");
//        itemHome.setAjax(false);
//        menu.addElement(itemHome);
//        DefaultSubMenu[] menuSubSis = new DefaultSubMenu[list.size()];
//        try {
//
//            for (SubSistema subSis : list) {
//                String s = subSis.getCdSubsDesc();
//                String[] divido = s.split("-");
//
//                menuSubSis[contSubSistema] = new DefaultSubMenu(comvertUpcase(divido[1]));
//                menuSubSis[contSubSistema].setIcon(subSis.getCdSubs());
//                DefaultSubMenu[] subMenuItem = new DefaultSubMenu[subSis.getModuloLista().size()];
//                try {
//
//                    int contModulo = 0;
//
//                    for (Modulo menuModulo : subSis.getModuloLista()) {
//                        String[] sp = menuModulo.getNmMod().split("-");
//
//                        subMenuItem[contModulo] = new DefaultSubMenu(comvertUpcase(sp[1]));
//
//                        DefaultMenuItem[] itemForm = new DefaultMenuItem[menuModulo.getFormularioLista().size()];
//                        int contFormulario = 0;
//                        for (Formulario menuFormulario : menuModulo.getFormularioLista()) {
//                            StringBuilder acaoString = new StringBuilder();
//                            int size = 0;
//                            for (Acao objAcao : menuFormulario.getAcaoList()) {
//                                if (size > 0) {
//                                    acaoString.append("#");
//                                }
//                                acaoString.append(objAcao.getCdAcao().trim());
//                                size++;
//
//                            }
//
//                            itemForm[contFormulario] = new DefaultMenuItem(comvertUpcase(menuFormulario.getNmTran().trim()));
//                            itemForm[contFormulario].setCommand("#{menuManagedBean.carregar(\"" + menuFormulario.getUrl().toLowerCase() + "\",\"" + acaoString.toString() + "\")}");
//                            itemForm[contFormulario].setId(menuFormulario.getCdTran().trim() + contFormulario);
//                            itemForm[contFormulario].setAjax(false);
//
//                            itemForm[contFormulario].setIcon(menuFormulario.getNmForm().toLowerCase());
//                            itemForm[contFormulario].setStyle("width:auto;");
//                            subMenuItem[contModulo].addElement(itemForm[contFormulario]);
//                            contFormulario++;
//                        }
//                        //adicionar o item dentro SubSis
//                        menuSubSis[contSubSistema].addElement(subMenuItem[contModulo]);
//                        contModulo++;
//
//                    }
//                } catch (Exception e) {
//                    System.out.println("### erro add  SubSis");
//                    e.printStackTrace();
//                }
//                menu.addElement(menuSubSis[contSubSistema]);
//                contSubSistema++;
//            }
//
//        } catch (Exception e) {
//            System.out.println("### erro add  subSistema no menu \n:erro:" + e.getLocalizedMessage());
//            e.printStackTrace();
//        }
//        menu.generateUniqueIds();
//        return menu;
//    }
//
//    public String comvertUpcase(String texto) {
//        StringBuilder palavra = new StringBuilder();
//        try {
//
//            texto = texto.toLowerCase();
//
//            String[] slipt = texto.split(" ");
//
//            int cont = 0;
//
//            for (String slipt1 : slipt) {
//                String primeiraLetra = slipt1.trim();
//
//                if (primeiraLetra != null && !primeiraLetra.equals("")) {
//                    if (primeiraLetra.contains(".")) {
//                        primeiraLetra = estruturadorRefPont(primeiraLetra.toLowerCase());
//                    } else {
//                        if (primeiraLetra.length() >= 5) {
//
//                            primeiraLetra = primeiraLetra.substring(0, 1).toUpperCase().concat(primeiraLetra.substring(1));
//                        }
//                        if (primeiraLetra.equals("tipo")) {
//                            primeiraLetra = primeiraLetra.substring(0, 1).toUpperCase().concat(primeiraLetra.substring(1));
//                        }
//                    }
//                    palavra.append(primeiraLetra);
//                    palavra.append(" ");
//
//                }
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return palavra.toString();
//    }
//
//    /**
//     * Transforama palavras como AP.PA para Ap.Pa
//     *
//     * @param msg String
//     * @return retorna String
//     */
//    public static String estruturadorRefPont(String msg) {
//        String[] palavras = msg.split("\\.");
//        StringBuilder resultado = new StringBuilder();
//        for (String pegPalavra : palavras) {
//            resultado.append(pegPalavra.substring(0, 1).toUpperCase().concat(pegPalavra.substring(1)));
//            resultado.append(".");
//        }
//        return resultado.toString().substring(0, resultado.length() - 1);
//    }
//
//    public List<Acao> getListAcao() {
//        return listAcao;
//    }
//
//    public void setListAcao(List<Acao> listAcao) {
//        this.listAcao = listAcao;
//    }
//
//    public void setPagina(String pg) {
//        pagina = pg;
//    }
//
//    public String getPagina() {
//        return pagina;
//    }
//
//    public String getPaginaAnterior() {
//        return paginaAnterior;
//    }
//
//    public void setPaginaAnterior(String paginaAnterior) {
//        this.paginaAnterior = paginaAnterior;
//    }

}
