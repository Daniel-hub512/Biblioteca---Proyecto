/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Bibliotecario;
import modelo.ModeloBibliotecario;
import vistas.VistaLogin;
import vistas.VistaMenuPrincipalBiblioteca;

/**
 *
 * @author ASUS
 */
public class ControlLogin {
    
    private VistaLogin view;
    private ModeloBibliotecario mb;
    
    
    public ControlLogin(){
    }

    public ControlLogin(VistaLogin view, ModeloBibliotecario mb) {
        this.view = view;
        this.mb = mb;
        
        view.setVisible(true);
        view.setTitle("GESTION DE USUARIO");
        view.setLocationRelativeTo(null);
    }
   

    
    public void IncioControl(){
    
       view.getBtningresar().addActionListener(l->Validacion());
       view.getBtnsalir().addActionListener(l->Salir());
       
    
    }
    
       
    public void Validacion(){
    

            
      
        String usuario = view.getTxtuser().getText();
        String contraseña = view.getTxtpass().getText();
        
        VistaMenuPrincipalBiblioteca mp = new VistaMenuPrincipalBiblioteca();
    
        if(usuario.isEmpty() && contraseña.isEmpty()) {
            
            JOptionPane.showMessageDialog(view, "Campos incorrectos, Intentelo de nuevo");
        }else{
            
            ModeloBibliotecario b = new ModeloBibliotecario();
                
            List<Bibliotecario> lista = b.DatosBibliotecario();
            
            String user;
            String pass;
            
                for (int i = 0; i < lista.size(); i++) {
                
                   Bibliotecario p = lista.get(i);
                   user = p.getNombre();
                   pass = p.getId_bibliotecario();
                                     
                    System.out.println(user);
                    System.out.println(pass);
        
                if(usuario.equals(user) && contraseña.equalsIgnoreCase(pass)){}
                
                     view.dispose();
                     
                     ControlPrincipal cp = new ControlPrincipal(mp);
                     
                     cp.InicioControl();
                     
                     
                
                }
        }
        

    
    }
    
    
    public void Salir(){
    
        view.dispose();
    }
    
}