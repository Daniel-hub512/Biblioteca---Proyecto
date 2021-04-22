


package Controlador;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Libro;
import modelo.ModeloLibro;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vistas.VistaCatalogo;


public class ControlLibro {

    private ModeloLibro modelo;
    private VistaCatalogo vista;
    
    

    public ControlLibro(ModeloLibro modelo, VistaCatalogo vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        
        
        
       
        vista.setClosable(true);
        
        vista.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        vista.setTitle("Informacion - Libros");
        vista.setVisible(true);
        
    }
    
   
    
    
    
    
    public void inicioControl(){
        
      //  vista.getBtnimprimir().addActionListener(l->imprimirReporte());
        vista.getBtnguardar().addActionListener(l->newLibro());  
        vista.getBtnmodificar().addActionListener(l->editarLibro());
        vista.getBtnExaminarP().addActionListener(l->cargarImagen());
        vista.getBtnActualizaL().addActionListener(l->cargalista());
        vista.getBtncrear().addActionListener(l-> muestraDialogo());
        vista.getBtnEditarL().addActionListener(l->muestraDialogoeditar());
        vista.getBtnCancelarP().addActionListener(l->ocultarDialogo());
        vista.getBtnEliminarL().addActionListener(l->eliminarLibro());
       // vista.getBtnsearch().addActionListener(l->search());
        vista.getTxtBuscarL().addKeyListener(new KeyListener() {
            
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
        
        
  }  


    private void search1(){
    
        String texto = vista.getTxtBuscarL().getText();
        
           cargaListafiltros(texto.toUpperCase());
      
    }
    

    private void ocultarDialogo(){
   
    vista.getDlgCatalogo().setVisible(false);
      
  }
  
  
    public void cargalista(){
        
        vista.getTablacatalogo().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTablacatalogo().setRowHeight(100);
        DefaultTableCellRenderer renderer= new DefaultTableCellHeaderRenderer();
        
        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vista.getTablacatalogo().getModel();
        tblModel.setNumRows(0);
        List<Libro> lista = ModeloLibro.listarLibros();
        int ncols=tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1->{
      
           
           tblModel.addRow(new Object[ncols]);
           vista.getTablacatalogo().setValueAt(p1.getCod_libro(), i.value , 0);
            vista.getTablacatalogo().setValueAt(p1.getTitulo(), i.value , 1);
            vista.getTablacatalogo().setValueAt(p1.getSinopsis(), i.value , 2);
            vista.getTablacatalogo().setValueAt(p1.getCategoria(), i.value , 3);
            vista.getTablacatalogo().setValueAt(p1.getEditorial(), i.value , 4);
            vista.getTablacatalogo().setValueAt(p1.getEstado(), i.value , 5);
            vista.getTablacatalogo().setValueAt(p1.getAño_publicacion(), i.value , 6);
        

            
           Image img = p1.getFoto();
           if(img!=null){
                Image newimg = img.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                renderer.setIcon(icon);
                vista.getTablacatalogo().setValueAt(new JLabel(icon), i.value, 7);
           }else{
               vista.getTablacatalogo().setValueAt(null, i.value, 7);
           }
           i.value++; 
          
        });


    }

    private void cargaListafiltros(String opcion){
  
        
        
        vista.getTablacatalogo().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTablacatalogo().setRowHeight(100);
        DefaultTableCellRenderer renderer= new DefaultTableCellHeaderRenderer();
        
        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vista.getTablacatalogo().getModel();
        tblModel.setNumRows(0);
        ModeloLibro md = new ModeloLibro(opcion, opcion, opcion, opcion,opcion);
        List<Libro> lista=md.ListaLibrosFiltros();
        int ncols=tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1->{
   
                      
           tblModel.addRow(new Object[ncols]);
           vista.getTablacatalogo().setValueAt(p1.getCod_libro(), i.value , 0);
            vista.getTablacatalogo().setValueAt(p1.getTitulo(), i.value , 1);
            vista.getTablacatalogo().setValueAt(p1.getSinopsis(), i.value , 2);
            vista.getTablacatalogo().setValueAt(p1.getCategoria(), i.value , 3);
            vista.getTablacatalogo().setValueAt(p1.getEditorial(), i.value , 4);
            vista.getTablacatalogo().setValueAt(p1.getEstado(), i.value , 5);
            vista.getTablacatalogo().setValueAt(p1.getAño_publicacion(), i.value , 6);
        
  
            
           Image img = p1.getFoto();
           if(img!=null){
                Image newimg = img.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                renderer.setIcon(icon);
                vista.getTablacatalogo().setValueAt(new JLabel(icon), i.value, 7);
           }else{
               vista.getTablacatalogo().setValueAt(null, i.value, 7);
           }
           i.value++;
             
        });
        
  }
    

    private void cargarImagen(){
    
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(null);
        if (estado==JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista.getLblFotoL().getWidth(),
                        vista.getLblFotoL().getHeight(),
                        Image.SCALE_DEFAULT);
                vista.getLblFotoL().setIcon(new ImageIcon(icono));
                vista.getLblFotoL().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(ControlLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }
    
    }
      

  
    private void muestraDialogo(){
        
      
        vista.getBtnguardar().setLocation(430, 410);
        vista.getBtnguardar().setVisible(true);
        vista.getBtnmodificar().setVisible(false);
   
        vista.getTxtCodigo().setEditable(true);
        Refrescar();
        vista.getDlgCatalogo().setLocationRelativeTo(null);
        vista.getDlgCatalogo().setTitle("DATOS DE EL LIBRO");
        vista.getDlgCatalogo().setSize(760, 470);
       
        vista.getDlgCatalogo().setVisible(true);
   
    } 
    
    
    private void muestraDialogoeditar(){
        
        
        vista.getBtnmodificar().setVisible(true);
        vista.getBtnguardar().setVisible(false);
        vista.getBtnmodificar().setSize(760, 470);
       
    
     
        vista.getDlgCatalogo().setLocationRelativeTo(null);
        vista.getDlgCatalogo().setTitle("ACTUALIZAR INFORMACION - LIBRO");
        vista.getDlgCatalogo().setSize(760, 470);
       // vista.getDlgpersona().setSize(484, 635);
        vista.getDlgCatalogo().setVisible(true);
       
        textoLibro();
    
       
    }    
    
  
    private void newLibro(){
   
        try {
            
        String codlibro = vista.getTxtCodigo().getText();
        String titulo = vista.getTxtTitulo().getText();
        String sinopsis = vista.getTxtSinopsis().getText();
        String cateogoria = vista.getTxtCategoria().getText();
        String editorial = vista.getTxtEditorial().getText();
        String estado = vista.getTxtEstado().getText();
        String añopublicacion = vista.getTxtAñopublicacion().getText();
     
        ModeloLibro libro = new ModeloLibro(codlibro, titulo, sinopsis, cateogoria, editorial, estado,añopublicacion);
       
            ImageIcon ic= (ImageIcon)vista.getLblFotoL().getIcon();
            libro.setFoto(ic.getImage());
        
        try {
      
        if(libro.grabar()){
            vista.getDlgCatalogo().setVisible(false);
            cargalista();
            JOptionPane.showMessageDialog(vista,"Libro Guardado Correctamente");
            
            }
            
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(vista,"Error");
            }
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista,"¡Llene todos los campos correctamente para guardar la informacion de Libro!");
        }
    }
    
 
    private void textoLibro(){
    
        
        int fila = vista.getTablacatalogo().getSelectedRow();
        
        if (fila == -1) {
            
            JOptionPane.showMessageDialog(vista,"Libro no seleccionado");
            ocultarDialogo();
        } else {
        
            
            
            try {
            
                vista.getTxtCodigo().setEnabled(false);
                
    
                String codlibro = (String) vista.getTablacatalogo().getValueAt(fila,0);
            
                String titulo = (String)vista.getTablacatalogo().getValueAt(fila, 1);
                String sinopsis = (String)vista.getTablacatalogo().getValueAt(fila, 2);
            
             

            
                String categoria = (String)vista.getTablacatalogo().getValueAt(fila, 3);
                String editorial = String.valueOf(vista.getTablacatalogo().getValueAt(fila,4));
                String estado = String.valueOf(vista.getTablacatalogo().getValueAt(fila,5));
                String añopublicacion = String.valueOf(vista.getTablacatalogo().getValueAt(fila,6));

                vista.getTxtCodigo().setText(codlibro);
                vista.getTxtTitulo().setText(titulo);
                vista.getTxtSinopsis().setText(sinopsis);
            
                vista.getTxtCategoria().setText(categoria);
                vista.getTxtEditorial().setText(editorial);
                vista.getTxtEstado().setText(estado);
                vista.getTxtAñopublicacion().setText(añopublicacion);
    
               
                   
                ImageIcon im1;
                JLabel jl =  (JLabel) vista.getTablacatalogo().getValueAt(fila, 7);
                im1 = (ImageIcon) jl.getIcon();
            
          
                vista.getLblFotoL().setIcon(null);
            
      
                 
                Image im2 = im1.getImage().getScaledInstance(vista.getLblFotoL().getWidth(), vista.getLblFotoL().getHeight(), Image.SCALE_SMOOTH);
  
                ImageIcon im3 = new ImageIcon(im2);  
                 
                vista.getLblFotoL().setIcon(im3);
           
                 } catch (Exception e) {
                     vista.getLblFotoL().setIcon(null);
                     JOptionPane.showMessageDialog(vista,"El Libro no contiene Portada");
                     
                }
            
            } 
        
        }
 
      
    
  
    
    private void Refrescar(){
    
        vista.getTxtCodigo().setText("");
        vista.getTxtTitulo().setText("");
        vista.getTxtSinopsis().setText("");
        vista.getTxtCategoria().setText("");
        vista.getTxtEditorial().setText("");
        vista.getTxtEstado().setText("");
        vista.getTxtAñopublicacion().setText("");
        vista.getLblFotoL().setIcon(null);
    }
    
    
    private void editarLibro(){
   
        String codlibro = vista.getTxtCodigo().getText();
        
        String titulo = vista.getTxtTitulo().getText();
        String sinopsis = vista.getTxtSinopsis().getText();
        String categoria = vista.getTxtCategoria().getText();
        String editorial = vista.getTxtEditorial().getText();
        String estado = vista.getTxtEstado().getText();
        String añopublicacion = vista.getTxtAñopublicacion().getText();
  
   

        ModeloLibro libro = new ModeloLibro(codlibro, titulo, sinopsis, categoria, editorial, estado,añopublicacion);
          
        ImageIcon ic= (ImageIcon)vista.getLblFotoL().getIcon();   
        libro.setFoto(ic.getImage());
        
        try {
            
      
        if(libro.editar()){
            vista.getDlgCatalogo().setVisible(false);
            cargalista();
            JOptionPane.showMessageDialog(vista,"Libro Actualizada Correctamente");
            
        }
           } catch (Exception e) {
                 JOptionPane.showMessageDialog(vista,"Error");   
        }
            
            
            
        } 
            
    

    
    private void eliminarLibro(){
    
        
        int fila = vista.getTablacatalogo().getSelectedRow();
        if(fila==-1){
            
            
            JOptionPane.showMessageDialog(null, "Libro no Seleccionado");         
            
        }else{    
            
            String codlibro = (String) vista.getTablacatalogo().getValueAt(fila,0);
            ModeloLibro ml = new ModeloLibro(codlibro);           
            if(ml.eliminar()){
            vista.getDlgCatalogo().setVisible(false);
            cargalista();
            JOptionPane.showMessageDialog(vista,"Persona Eliminada Correctamente");
          
        }
        }
    }

/*
    private void imprimirReporte(){
        ConexionPG con = new ConexionPG();
        try {
            JasperReport jr = (JasperReport)JRLoader.loadObject(getClass().getResource("/Vista/Reportes/clientes.jasper"));
            //JasperPrint jp = JasperFillManager.fillReport(jr,null,con.getCon());
            String opcion = vista.getTxtbuscar().getText();
            double sueldo = Double.valueOf(vista.getTxtsueldo().getText());    
            Map<String,Object> parametros = new HashMap<String,Object>();
            parametros.put("opcion", "%"+opcion+"%");
            parametros.put("sueldo", sueldo);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros,con.getCon());
            JasperViewer jv = new JasperViewer(jp);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }


*/
}
