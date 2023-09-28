/*
clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación
 */
package Entidades;

import java.sql.Time;

/**
 *
 * @author Rafael
 */
public class Pelicula {
    
    private String titulo;
    private String director;
    private Time duracion;
    
    public Pelicula(){
        
    }
    
    public Pelicula(String titulo, String director, Time duracion){
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }
    
    public String getTitulo(){
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public Time getDuracion() {
        return duracion;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", director=" + director + ", duracion=" + duracion + '}';
    }

    
}


