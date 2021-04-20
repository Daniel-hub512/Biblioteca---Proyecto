/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLibro;
import vistas.VistaCatalogo;
import vistas.VistaMenuPrincipalBiblioteca;

/**
 *
 * @author ASUS
 */
public class ControlPrincipal {
    
    
    public VistaMenuPrincipalBiblioteca menup;

    public ControlPrincipal(VistaMenuPrincipalBiblioteca menup) {
        this.menup = menup;
        
        
        menup.setVisible(true);
        menup.setTitle("BIBLIOTECA");
        menup.setSize(910,662);
        menup.setLocationRelativeTo(null);
    }

    public VistaMenuPrincipalBiblioteca getMenup() {
        return menup;
    }

    public void setMp(VistaMenuPrincipalBiblioteca menup) {
        this.menup = menup;
    }



    
    public void InicioControl(){
    
        menup.getBtncatalogo().addActionListener(l->ShowBooks());
    
    }
 
    
    
    public void ShowBooks(){
    
    
        ModeloLibro ml = new ModeloLibro();
        VistaCatalogo vc = new VistaCatalogo();
        
        
        menup.getDesktop().add(vc);
        
        ControlLibro cl = new ControlLibro(ml, vc);
        
        cl.inicioControl();
        cl.cargalista();
    }
      
}