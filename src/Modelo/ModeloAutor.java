
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloAutor extends Autor {
    private static ConexionPG con=new ConexionPG();

    public ModeloAutor() {
    }
    
    public ModeloAutor(String id_autor) {
        super(id_autor);
    }
    
    public ModeloAutor(String id_autor, String nombre_autor, String nacionalidad, String cod_libro) {
        super(id_autor, nombre_autor, nacionalidad, cod_libro);
    }
    
    public ModeloAutor(String id_autor, String nombre_autor, String nacionalidad) {
        super(id_autor, nombre_autor, nacionalidad);
    }
    
    
    public boolean grabar(){
        
   String sql;
   sql="INSERT INTO autor(id_autor, nombre_autor, nacionalidad, cod_libro)";
   sql +="VALUES('"+getId_autor()+"','"+getNombre_autor()+"','"+getNacionalidad()+"','"+getCod_libro()+"')";
   if(con.noQuery(sql)==null){
   return true;
   }else{
   return false;
   }
   } 
   
   public boolean actualizar(){
        String nsql;
        nsql ="UPDATE public.autr SET nombre_autor='"+getNombre_autor()+"', nacionalidad='"+getNacionalidad()+"', ,cod_libro='"+getCod_libro()+"' WHERE id_autor='"+getId_autor()+"'; ";
               
        if(con.noQuery(nsql) == null){
            return true;
        }else{
            System.out.println("Error");
            return false;
        }
    }
    
    public static List<Autor>listaAutor(String aguja){

        try {
            String query="select *from autor WHERE ";
            query+="UPPER(id_autor) LIKE UPPER( '%"+aguja+"%') OR ";
            query+="UPPER(nombre_autor) LIKE UPPER('%"+aguja+"%') OR ";
            query+="UPPER(nacionalidad) LIKE UPPER('%"+aguja+"%') ";
            
            ResultSet rs=con.query(query);
            List<Autor> lista = new ArrayList<Autor>();
             byte[] bf;
            while(rs.next()){
                Autor autor=new Autor();
                autor.setId_autor(rs.getString("id_autor"));
                autor.setNombre_autor(rs.getString("nombre_autor"));
                autor.setNacionalidad(rs.getString("nacionalidad"));
                autor.setCod_libro(rs.getString("cod_libro"));
               
                lista.add(autor);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloBibliotecario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     public boolean Eliminar(String id){
    String sql="Delete from \"autor\" "
            + "WHERE id_autor='"+id+"'; ";
    if(con.noQuery(sql)==null){
     return true;
     }else{
     return false;
     }
    }
    
}
