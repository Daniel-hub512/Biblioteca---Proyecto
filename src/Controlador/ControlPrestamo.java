/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Libro;
import modelo.ModeloLibro;
import modelo.ModeloPrestamo;
import modelo.Prestamos;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vistas.VistaPrestamos;

/**
 *
 * @author ASUS
 */
public class ControlPrestamo {
    
    private ModeloPrestamo mp;
    private VistaPrestamos vp;
    
    
    public ControlPrestamo(){
    }

    public ControlPrestamo(ModeloPrestamo mp, VistaPrestamos vp) {
        this.mp = mp;
        this.vp = vp;
      
        
        vp.setResizable(true);
        
        vp.setMaximizable(true);
        vp.setClosable(true);
        
        vp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        vp.setTitle("Prestamos- Libros");
        vp.setVisible(true);
        
        
    }
    
        public void inicioControl(){
        
      //  vista.getBtnimprimir().addActionListener(l->imprimirReporte());
        vp.getBtnguardarp().addActionListener(l->newPrestamo());  
        vp.getBtneditarp().addActionListener(l->editarPrestamo());
        vp.getBtnactualizar().addActionListener(l->Refrescar());
        vp.getBtneliminarp().addActionListener(l->eliminarPrestamo());
       // vista.getBtnsearch().addActionListener(l->search());
        vp.getTxtBuscarP().addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                 search1();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                search1();//To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                search1(); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
       vp.getBtnbuscarp().addActionListener(l->textoRegistro());
        
        
  }  
 
     private void Refrescar(){
    
        vp.getTxtID_usuario().setText("");
        vp.getTxtcodigoP().setText("");
        vp.getTxtcodigoejemplar().setText("");
        vp.getJdcFechaD().setDateFormatString("");
        vp.getJdcFechap().setDateFormatString("");

    }       
        
    private void search1(){
    
        String texto = vp.getTxtBuscarP().getText();
        
           cargaListafiltros(texto.toUpperCase());
      
    }
    
        
        
     public void cargalista(){
        
         
        
        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vp.getTablaprestamos().getModel();
        tblModel.setNumRows(0);
        List<Prestamos> lista = ModeloPrestamo.listaRegistros();
        int ncols=tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1->{
      
           
           tblModel.addRow(new Object[ncols]);
            vp.getTablaprestamos().setValueAt(p1.getCod_registro(), i.value , 0);
            vp.getTablaprestamos().setValueAt(p1.getFecha_prestamo(), i.value , 1);
            vp.getTablaprestamos().setValueAt(p1.getFecha_devolucion(), i.value , 2);
            vp.getTablaprestamos().setValueAt(p1.getCod_ejemplar(), i.value , 3);
            vp.getTablaprestamos().setValueAt(p1.getId_usuario(), i.value , 4);
 
        

           i.value++; 
          
        });


    }

    private void cargaListafiltros(String opcion){
  
        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vp.getTablaprestamos().getModel();
        tblModel.setNumRows(0);
        ModeloPrestamo mp = new ModeloPrestamo(opcion, opcion,opcion);
        List<Prestamos> lista=mp.listaRegistrosFiltros();
        int ncols=tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1->{
   
                      
            tblModel.addRow(new Object[ncols]);
            vp.getTablaprestamos().setValueAt(p1.getCod_registro(), i.value , 0);
            vp.getTablaprestamos().setValueAt(p1.getFecha_prestamo(), i.value , 1);
            vp.getTablaprestamos().setValueAt(p1.getFecha_devolucion(), i.value , 2);
            vp.getTablaprestamos().setValueAt(p1.getCod_ejemplar(), i.value , 3);
            vp.getTablaprestamos().setValueAt(p1.getId_usuario(), i.value , 4);

        
  
            

           i.value++;
             
        });
        
  }      

        
        private void newPrestamo(){
   
        try {
            
        String codregistro = vp.getTxtcodigoejemplar().getText();
        
                Instant instant_u = vp.getJdcFechap().getDate().toInstant();   
                ZoneId zid_u = ZoneId.of("America/Guayaquil");
                ZonedDateTime zdt_u = ZonedDateTime.ofInstant(instant_u, zid_u);
                Date fechaprestamo = Date.valueOf(zdt_u.toLocalDate());
                  
                Instant instant_d = vp.getJdcFechaD().getDate().toInstant();   
                ZoneId zid_d = ZoneId.of("America/Guayaquil");
                ZonedDateTime zdt_d = ZonedDateTime.ofInstant(instant_d, zid_d);
                Date fechapdevolucion = Date.valueOf(zdt_d.toLocalDate());
            
        String codejemplar = vp.getTxtcodigoP().getText();
        String idusuario = vp.getTxtID_usuario().getText();

        ModeloPrestamo Prestamo = new ModeloPrestamo(codregistro, fechaprestamo, fechapdevolucion, codejemplar, idusuario);
       

        
        try {
      
        if(Prestamo.grabar()){

            cargalista();
            JOptionPane.showMessageDialog(vp,"Prestamo Guardado Correctamente");
            
            }
            
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(vp,"Error");
            }
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vp,"¡Llene todos los campos correctamente para guardar la informacion de Prestamo!");
        }
    }
        
    private void textoRegistro(){
        
        int fila = vp.getTablaprestamos().getSelectedRow();
        
        if (fila == -1) {
            
            JOptionPane.showMessageDialog(vp,"Registo de prestamo NO seleccionado");
            
        } else {

            try {         
                vp.getTxtcodigoejemplar().setEnabled(false);

                String codprestamo = (String) vp.getTablaprestamos().getValueAt(fila,0);
                String codigop = codprestamo;
                
                ModeloPrestamo mop = new ModeloPrestamo(codigop);

                List<Prestamos> lista = mop.fechaBD();
            
                for (int i = 0; i < lista.size(); i++) {
                
                   Prestamos p = lista.get(i);
                   Date fp = p.getFecha_prestamo();
                   Date fd = p.getFecha_devolucion();
                   vp.getJdcFechap().setDate(fp);
                   vp.getJdcFechaD().setDate(fd);
                }
             
  
                String codejemplar = (String)vp.getTablaprestamos().getValueAt(fila, 3);
                String idusuario = (String)vp.getTablaprestamos().getValueAt(fila, 4);
            
             


                vp.getTxtcodigoP().setText(codejemplar);
                vp.getTxtcodigoejemplar().setText(codprestamo);
                vp.getTxtID_usuario().setText(idusuario);
          

               

                

           
                 } catch (Exception e) {
                     
                    JOptionPane.showMessageDialog(vp,"Error");
                     
                }
            
            } 
        
        } 
        
    



    
    private void editarPrestamo(){
        
        try {
            
     
        String codprestamo= vp.getTxtcodigoejemplar().getText();
        
        Instant instant = vp.getJdcFechap().getDate().toInstant();   
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
        Date fechaprestamo = Date.valueOf(zdt.toLocalDate());
        
        Instant instant_u = vp.getJdcFechaD().getDate().toInstant();
        ZoneId zid_u = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt_u= ZonedDateTime.ofInstant(instant_u, zid_u);
        Date fechadevol = Date.valueOf(zdt_u.toLocalDate());
       

        String codejemplar = vp.getTxtcodigoP().getText();
        String editorial = vp.getTxtID_usuario().getText();

   

        ModeloPrestamo Prestamo = new ModeloPrestamo(codprestamo, fechaprestamo, fechadevol, codejemplar, editorial);
          
        
        try {
            
      
        if(Prestamo.actualizar()){  
            Refrescar();
            cargalista();
            JOptionPane.showMessageDialog(vp,"Prestamo Actualizada Correctamente");
            
        }
           } catch (Exception e) {
                 JOptionPane.showMessageDialog(vp,"Error");   
        }
              } catch (Exception e) {
                  
              JOptionPane.showMessageDialog(vp,"Selecciona algun registro para actualizar");    
        }
     
}
    
     
    private void eliminarPrestamo(){
    
        
        int fila = vp.getTablaprestamos().getSelectedRow();
        if(fila==-1){
            
            
            JOptionPane.showMessageDialog(null, "Registro no Seleccionado");         
            
        }else{    
            
            String codprestamo = (String) vp.getTablaprestamos().getValueAt(fila,0);
            ModeloPrestamo md = new ModeloPrestamo(codprestamo);           
            if(md.Eliminar()){

            cargalista();
            JOptionPane.showMessageDialog(vp,"Registro Eliminado Correctamente");
          
        }
        }   
    
}
    
}


