
package modelo;

import java.sql.Date;

public class Prestamos {
    private String cod_registro;
    private Date fecha_prestamo;
    private Date fecha_devolucion;
    private String cod_ejemplar;
    private String id_usuario;
    
public Prestamos() {
    
}

    public Prestamos(String cod_registro) {
        this.cod_registro = cod_registro;
    }

    public Prestamos(String cod_registro, Date fecha_prestamo, Date fecha_devolucion) {
        this.cod_registro = cod_registro;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }

    public Prestamos(String cod_registro, String cod_ejemplar, String id_usuario) {
        this.cod_registro = cod_registro;
        this.cod_ejemplar = cod_ejemplar;
        this.id_usuario = id_usuario;
    }

    
    
    
    
    public Prestamos(String cod_registro, Date fecha_prestamo, Date fecha_devolucion, String cod_ejemplar, String id_usuario) {
        this.cod_registro = cod_registro;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.cod_ejemplar = cod_ejemplar;
        this.id_usuario = id_usuario;
    }

    public String getCod_registro() {
        return cod_registro;
    }

    public void setCod_registro(String cod_registro) {
        this.cod_registro = cod_registro;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getCod_ejemplar() {
        return cod_ejemplar;
    }

    public void setCod_ejemplar(String cod_ejemplar) {
        this.cod_ejemplar = cod_ejemplar;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

}
