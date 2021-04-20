
package modelo;

public class Bibliotecario {
    private String id_bibliotecario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String cod_biblioteca;
    
    public Bibliotecario(){
    
    } 

    public Bibliotecario(String id_bibliotecario) {
        this.id_bibliotecario = id_bibliotecario;
    }

    public Bibliotecario(String id_bibliotecario, String nombre, String apellido, String telefono, String cod_biblioteca) {
        this.id_bibliotecario = id_bibliotecario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cod_biblioteca = cod_biblioteca;
    }

    public Bibliotecario(String id_bibliotecario, String nombre, String apellido, String telefono) {
        this.id_bibliotecario = id_bibliotecario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    

    public String getId_bibliotecario() {
        return id_bibliotecario;
    }

    public void setId_bibliotecario(String id_bibliotecario) {
        this.id_bibliotecario = id_bibliotecario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCod_biblioteca() {
        return cod_biblioteca;
    }

    public void setCod_biblioteca(String cod_biblioteca) {
        this.cod_biblioteca = cod_biblioteca;
    }


}





    

    