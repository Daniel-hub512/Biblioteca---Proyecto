
package modelo;

public class Autor {
    private String id_autor; 
    private String nombre_autor; 
    private String nacionalidad; 
    private String cod_libro; 
   
    
public Autor() {
    
}

    public Autor(String id_autor) {
        this.id_autor = id_autor;
    }

    public Autor(String id_autor, String nombre_autor, String nacionalidad) {
        this.id_autor = id_autor;
        this.nombre_autor = nombre_autor;
        this.nacionalidad = nacionalidad;
    }

public Autor(String id_autor, String nombre_autor, String nacionalidad, String cod_libro) {
    this.id_autor = id_autor;
    this.nombre_autor =  nombre_autor;
    this.nacionalidad = nacionalidad;
    this.cod_libro = cod_libro;  
}


    public String getId_autor() {
        return id_autor;
    }

    public void setId_autor(String id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }
        
}
