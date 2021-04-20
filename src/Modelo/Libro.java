
package modelo;

import java.awt.Image;

public class Libro {
    private String cod_libro; 
    private String titulo; 
    private String sinopsis; 
    private String categoria; 
    private String editorial; 
    private String estado; 
    private String año_publicacion;
    private Image foto;
    
public Libro(){
        
    }




    public Libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }

    public Libro(String cod_libro, String titulo, String sinopsis, String categoria, String editorial, String estado, String año_publicacion) {
        this.cod_libro = cod_libro;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.categoria = categoria;
        this.editorial = editorial;
        this.estado = estado;
        this.año_publicacion = año_publicacion;
    }

    public Libro(String cod_libro, String titulo, String categoria, String editorial, String estado) {
        this.cod_libro = cod_libro;
        this.titulo = titulo;
        this.categoria = categoria;
        this.editorial = editorial;
        this.estado = estado;
    }

    
    
    
    public Libro(String cod_libro, String titulo, String sinopsis, String categoria, String editorial, String estado, Image foto) {
        this.cod_libro = cod_libro;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.categoria = categoria;
        this.editorial = editorial;
        this.estado = estado;
        this.foto = foto;
    }

    public Libro(String cod_libro, String titulo, String sinopsis, String categoria, String editorial, String estado) {
        this.cod_libro = cod_libro;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.categoria = categoria;
        this.editorial = editorial;
        this.estado = estado;
    }    

    public String getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getAño_publicacion() {
        return año_publicacion;
    }

    public void setAño_publicacion(String año_publicacion) {
        this.año_publicacion = año_publicacion;
    }
    
}
    

