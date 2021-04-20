
package modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;
import org.postgresql.util.Base64;


public class ModeloLibro extends Libro {
    private static ConexionPG con = new ConexionPG();

    public ModeloLibro() {
    }
    
    public ModeloLibro(String cod_libro) {
        super(cod_libro);
    }

    public ModeloLibro(String cod_libro, String titulo, String sinopsis, String categoria, String editorial, String estado, String año_publicacion) {
        super(cod_libro, titulo, sinopsis, categoria, editorial, estado, año_publicacion);
    }

    public ModeloLibro(String cod_libro, String titulo, String categoria, String editorial, String estado) {
        super(cod_libro, titulo, categoria, editorial, estado);
    }
    
    
    
    public ModeloLibro(String cod_libro, String titulo, String sinopsis, String categoria, String editorial, String estado, Image foto) {
        super(cod_libro, titulo, sinopsis, categoria, editorial, estado, foto);
    } 
    
    public ModeloLibro(String cod_libro, String titulo, String sinopsis, String categoria, String editorial, String estado) {
        super(cod_libro, titulo, sinopsis, categoria, editorial, estado);
    } 
    
    public boolean grabar(){
        
        String foto64 = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        try {
        BufferedImage bi = imgBimage(getFoto());
        
        ImageIO.write(bi,"PNG", bos);
      
        byte[] imgb = bos.toByteArray();
        foto64 = org.postgresql.util.Base64.encodeBytes(imgb);
          } catch (IOException ex) {
            System.out.println(ex.getMessage());;
        }
   String sql;
   sql="INSERT INTO public.libro(\n" +
"	cod_libro, titulo, sinopsis, categoria, editorial, estado, \"año_publicacion\", foto)\n" +
"	VALUES ('"+getCod_libro()+"', '"+getTitulo()+"', '"+getSinopsis()+"', '"+getCategoria()+"', '"+getEditorial()+"', '"+getEstado()+"', '"+getAño_publicacion()+"', '"+foto64+"');";
   if(con.noQuery(sql)==null){
   return true;
   }else{
   return false;
   }
   } 
    
    private BufferedImage imgBimage(Image img){
        
        if (img instanceof BufferedImage){
            return (BufferedImage)img;
        }
        BufferedImage bi = new BufferedImage(
                img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_ARGB
        );
        
        Graphics2D bGR = bi.createGraphics();
        bGR.drawImage(img, 0, 0,null);
        bGR.dispose();
        return bi;        
    }
   
   
   public boolean editar(){
       
        String foto64 = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        try {
        BufferedImage bi = imgBimage(getFoto());
        
        ImageIO.write(bi,"PNG", bos);
      
        byte[] imgb = bos.toByteArray();
        foto64 = Base64.encodeBytes(imgb);
          } catch (IOException ex) {
            System.out.println(ex.getMessage());;
        }
        
        String nsql;
        nsql ="UPDATE public.libro\n" +
"	SET titulo='"+getTitulo()+"', sinopsis='"+getSinopsis()+"', categoria='"+getCategoria()+"',"
                + " editorial='"+getEditorial()+"', estado='"+getEstado()+"', \"año_publicacion\"='"+getAño_publicacion()+"',"
                + " foto='"+foto64+"'\n" +
"	WHERE cod_libro='"+getCod_libro()+"';";
               
        if(con.noQuery(nsql) == null){
            return true;
        }else{
            System.out.println("Error");
            return false;
        }
    }
 
    
    public static List<Libro> listarLibros(){
        try {
            String query="SELECT * FROM libro";
            ResultSet rs= con.query(query);
            List<Libro> lista = new ArrayList<Libro>();
            byte[] bf;
            while(rs.next()){
                Libro p = new Libro();
                p.setCod_libro(rs.getString("cod_libro"));
                p.setTitulo(rs.getString("titulo"));
                p.setSinopsis(rs.getString("sinopsis"));
                p.setCategoria(rs.getString("categoria"));
                p.setEditorial(rs.getString("editorial"));
                p.setEstado(rs.getString("estado"));
                p.setAño_publicacion(rs.getString("año_publicacion"));
                      
                bf=rs.getBytes("foto");
                
                if(bf!=null){
                    bf=Base64.decode(bf,0,bf.length);
                    try {
                        
                        p.setFoto(obtenImagen(bf));
                    } catch (IOException ex) {
                        p.setFoto(null);
                        Logger.getLogger(ModeloLibro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                 p.setFoto(null);
                }
                lista.add(p);
            }        
            rs.close();
            return lista;           
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLibro.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }   
}
           
    
    
    public  List<Libro> ListaLibrosFiltros(){
        try {
            String query="SELECT *"
                    + " FROM libro"
                    + " WHERE UPPER(cod_libro) LIKE UPPER('%"+getCod_libro()+"%') "
                    + "OR UPPER(titulo) LIKE UPPER('%"+getTitulo()+"%') "
                    + "OR UPPER(categoria) LIKE UPPER('%"+getCategoria()+"%') "
                    + "OR UPPER(editorial) LIKE UPPER('%"+getEditorial()+"%') "
                    + "OR UPPER(estado) LIKE UPPER('%"+getEstado()+"%') ";
            
            ResultSet rs= con.query(query);
            List<Libro> lista = new ArrayList<Libro>();
            byte[] bf;
            while(rs.next()){
                Libro lb = new Libro();
                lb.setCod_libro(rs.getString("cod_libro"));
                lb.setTitulo(rs.getString("titulo"));
                lb.setSinopsis(rs.getString("sinopsis"));
                lb.setCategoria(rs.getString("categoria"));
                lb.setEditorial(rs.getString("editorial"));
                lb.setEstado(rs.getString("estado"));
                lb.setAño_publicacion(rs.getString("año_publicacion"));
    
                bf=rs.getBytes("foto");
                
                if(bf!=null){
                    bf=Base64.decode(bf,0,bf.length);
                    try {
                        
                        lb.setFoto(obtenImagen(bf));
                    } catch (IOException ex) {
                        lb.setFoto(null);
                        Logger.getLogger(ModeloLibro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                 lb.setFoto(null);
                }
                
                lista.add(lb);
            
           }        
            rs.close();
           return lista;
           
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLibro.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }  
}
    


   

    
    
    
     public boolean eliminar(){
    String sql="Delete from libro "
            + "WHERE cod_libro='"+getCod_libro()+"'; ";
    if(con.noQuery(sql)==null){
     return true;
     }else{
     return false;
     }
    }
    
     
     
    public static Image obtenImagen(byte[] bytes)throws IOException{
        ByteArrayInputStream bis= new ByteArrayInputStream(bytes);
        Iterator it= ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader)it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis,true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0,param);
    }

}
