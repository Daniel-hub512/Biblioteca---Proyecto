
package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloPrestamo extends Prestamo {
    private static ConexionPG con=new ConexionPG();

    public ModeloPrestamo() {
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
   sql="INSERT INTO registros(cod_registro, fecha_prestamo, fecha_devolucion, cod_ejemplar, id_usuario)";
   sql +="VALUES('"+getCod_registro()+"','"+getFecha_prestamo()+"','"+getFecha_devolucion()+"','"+getCod_ejemplar()+"','"+getId_usuario()+"')";
   if(con.noQuery(sql)==null){
   return true;
   }else{
   return false;
   }
   } 
   
   
   public boolean actualizar(){
        String nsql;
        nsql ="UPDATE public.registros SET fecha_prestamo='"+getFecha_prestamo()+"', fecha_devolucion='"+getFecha_devolucion()+"', cod_ejemplar='"+getCod_ejemplar()+"', id_usuario='"+getId_usuario()+"' WHERE cod_registro='"+getCod_registro()+"'; ";
               
        if(con.noQuery(nsql) == null){
            return true;
        }else{
            System.out.println("Error");
            return false;
        }
    }
    
    public static List<Prestamo>listaRegistros(String aguja){

        try {
            String query="select *from registros WHERE ";
            query+="UPPER(cod_registros) LIKE UPPER( '%"+aguja+"%') ";
            query+="UPPER(cod_ejemplar) LIKE UPPER('%"+aguja+"%') OR ";
            query+="UPPER(id_usuario) LIKE UPPER('%"+aguja+"%') ";
            
            ResultSet rs=con.query(query);
            List<Prestamo> lista = new ArrayList<Prestamo>();
             byte[] bf;
            while(rs.next()){
                Prestamo registros=new Prestamo();
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
     public boolean Eliminar(String cod){
    String sql="Delete from \"registro\" "
            + "WHERE cod_registro='"+cod+"'; ";
    if(con.noQuery(sql)==null){
     return true;
     }else{
     return false;
     }
    }
    
}

