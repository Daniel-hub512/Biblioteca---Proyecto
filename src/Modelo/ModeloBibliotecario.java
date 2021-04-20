
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModeloBibliotecario extends Bibliotecario {
    
    private static ConexionPG con=new ConexionPG();

    public ModeloBibliotecario() {
    }

    public ModeloBibliotecario(String id_bibliotecario) {
        super(id_bibliotecario);
    }
   
    public ModeloBibliotecario(String id_bibliotecario, String nombre, String apellido, String telefono, String cod_biblioteca) {
        super(id_bibliotecario, nombre, apellido, telefono, cod_biblioteca);
    }
    
    public ModeloBibliotecario(String id_bibliotecario, String nombre, String apellido, String telefono) {
        super(id_bibliotecario, nombre, apellido, telefono);
    }
    
    
    public boolean grabar(){
        
   String sql;
   sql="INSERT INTO bibliotecario(id_bibliotecario, nombre, apellido, telefono, cod_biblioteca)";
   sql +="VALUES('"+getId_bibliotecario()+"','"+getNombre()+"','"+getApellido()+"','"+getTelefono()+"','"+getCod_biblioteca()+"')";
   if(con.noQuery(sql)==null){
   return true;
   }else{
   return false;
   }
   } 
   
   public boolean actualizar(){
        String nsql;
        nsql ="UPDATE public.bibliotecario SET nombre='"+getNombre()+"', apellido='"+getApellido()+"', telefono='"+getTelefono()+"',cod_biblioteca='"+getCod_biblioteca()+"' WHERE id_bibliotecario='"+getId_bibliotecario()+"'; ";
               
        if(con.noQuery(nsql) == null){
            return true;
        }else{
            System.out.println("Error");
            return false;
        }
    }
    
    public static List<Bibliotecario>listaBibliotecario(String aguja){

        try {
            String query="select *from bibliotecario WHERE ";
            query+="UPPER(id_bibliotecario) LIKE UPPER( '%"+aguja+"%') OR ";
            query+="UPPER(nombre) LIKE UPPER('%"+aguja+"%') OR ";
            query+="UPPER(apellido) LIKE UPPER('%"+aguja+"%') ";
            
            ResultSet rs=con.query(query);
            List<Bibliotecario> lista = new ArrayList<Bibliotecario>();
             byte[] bf;
            while(rs.next()){
                Bibliotecario bibliotecario=new Bibliotecario();
                bibliotecario.setId_bibliotecario(rs.getString("id_bibliotecario"));
                bibliotecario.setNombre(rs.getString("nombre"));
                bibliotecario.setApellido(rs.getString("apellido"));
                bibliotecario.setTelefono(rs.getString("telefono"));
                bibliotecario.setCod_biblioteca(rs.getString("cod_biblioteca"));
               
                lista.add(bibliotecario);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloBibliotecario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
     
     
    public static List<Bibliotecario> DatosBibliotecario(){

        try {
            String query="select id_bibliotecario,nombre FROM bibliotecario";
            
            ResultSet rs=con.query(query);
            List<Bibliotecario> lista = new ArrayList<Bibliotecario>();
            
            while(rs.next()){
                Bibliotecario b=new Bibliotecario();
                b.setId_bibliotecario(rs.getString("id_bibliotecario"));
                b.setNombre(rs.getString("nombre"));
              
                lista.add(b);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error");
           
        }
         return null;
    }     
     
     
     
     
     
     
     
}

    

