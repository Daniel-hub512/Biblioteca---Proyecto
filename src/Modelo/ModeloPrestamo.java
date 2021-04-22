
package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModeloPrestamo extends Prestamos {
    
    private static ConexionPG con=new ConexionPG();

    public ModeloPrestamo() {
    }

    public ModeloPrestamo(String cod_registro, String cod_ejemplar, String id_usuario) {
        super(cod_registro, cod_ejemplar, id_usuario);
    }

    
    
    
    public ModeloPrestamo(String cod_registro) {
        super(cod_registro);
    }

    public ModeloPrestamo(String cod_registro, Date fecha_prestamo, Date fecha_devolucion) {
        super(cod_registro, fecha_prestamo, fecha_devolucion);
    }

    public ModeloPrestamo(String cod_registro, Date fecha_prestamo, Date fecha_devolucion, String cod_ejemplar, String id_usuario) {
        super(cod_registro, fecha_prestamo, fecha_devolucion, cod_ejemplar, id_usuario);
    }
    
    
public boolean grabar(){
        
   String sql;
   sql="INSERT INTO public.prestamos(\n" +
"	cod_registro, fecha_prestamo, fecha_devolucion, cod_ejemplar, id_usuario)\n" +
"	VALUES ('"+getCod_registro()+"', '"+getFecha_prestamo()+"','"+getFecha_devolucion()+"','"+getCod_ejemplar()+"', '"+getId_usuario()+"');";
   if(con.noQuery(sql)==null){
   return true;
   }else{
   return false;
   }
   } 
   
   
   public boolean actualizar(){
        String nsql;
        nsql ="UPDATE public.prestamos\n" +
"	SET  fecha_prestamo='"+getFecha_prestamo()+"', fecha_devolucion='"+getFecha_devolucion()+"', cod_ejemplar='"+getCod_ejemplar()+"',id_usuario='"+getId_usuario()+"'\n" +
"	WHERE cod_registro='"+getCod_registro()+"';";
               
        if(con.noQuery(nsql) == null){
            return true;
        }else{
            System.out.println("Error");
            return false;
        }
    }
    
   
    public List<Prestamos>listaRegistrosFiltros(){

        try {
            String query="select * from prestamos WHERE ";
            query+="UPPER(cod_registro) LIKE UPPER('%"+getCod_registro()+"%') OR ";
            query+="UPPER(cod_ejemplar) LIKE UPPER('%"+getCod_ejemplar()+"%') OR ";
            query+="UPPER(id_usuario) LIKE UPPER('%"+getId_usuario()+"%') ";
            
            ResultSet rs=con.query(query);
            List<Prestamos> lista = new ArrayList<Prestamos>();
             byte[] bf;
            while(rs.next()){
                Prestamos registros=new Prestamos();
                registros.setCod_registro(rs.getString("cod_registro"));
                registros.setFecha_prestamo(rs.getDate("fecha_prestamo"));
                registros.setFecha_devolucion(rs.getDate("fecha_devolucion"));
                registros.setCod_ejemplar(rs.getString("cod_ejemplar"));
                registros.setId_usuario(rs.getString("id_usuario"));
               
                lista.add(registros);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPrestamo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    public List<Prestamos> fechaBD(){
        try {
            String query="SELECT fecha_prestamo,fecha_devolucion"
                    + " FROM public.prestamos"
                    + "	WHERE cod_registro = '"+getCod_registro()+"'";
            ResultSet rs = con.query(query);
            List<Prestamos> lista = new ArrayList<Prestamos>();
            while(rs.next()){            
                Prestamos p = new Prestamos();            
                p.setFecha_prestamo(rs.getDate("fecha_prestamo")); 
                p.setFecha_devolucion(rs.getDate("fecha_devolucion"));
                lista.add(p);           
            }    
            rs.close();
            return lista;         
        } catch (SQLException ex) {      
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;         
}        
    
    
    
    
    
    
    
    public static List<Prestamos>listaRegistros(){

        try {
            String query="select * from prestamos ";
            
            ResultSet rs=con.query(query);
            List<Prestamos> lista = new ArrayList<Prestamos>();
             byte[] bf;
            while(rs.next()){
                Prestamos registros=new Prestamos();
                registros.setCod_registro(rs.getString("cod_registro"));
                registros.setFecha_prestamo(rs.getDate("fecha_prestamo"));
                registros.setFecha_devolucion(rs.getDate("fecha_devolucion"));
                registros.setCod_ejemplar(rs.getString("cod_ejemplar"));
                registros.setId_usuario(rs.getString("id_usuario"));
               
                lista.add(registros);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPrestamo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    

    
    
     public boolean Eliminar(){
    String sql="Delete from \"prestamos\" "
            + "WHERE cod_registro='"+getCod_registro()+"'; ";
    if(con.noQuery(sql)==null){
     return true;
     }else{
     return false;
     }
    }
    
}


