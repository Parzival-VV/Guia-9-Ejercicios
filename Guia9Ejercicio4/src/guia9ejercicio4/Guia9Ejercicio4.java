/*
Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:

 */
package guia9ejercicio4;
import Entidades.Pelicula;
import Servicios.PeliculaServicio;
import java.util.ArrayList;
/**
 *
 * @author Rafael
 */
public class Guia9Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PeliculaServicio Ps = new PeliculaServicio();
        ArrayList<Pelicula> peliculas = Ps.crearPelicula();
        
        Ps.mostrarPeliculas(peliculas);
        System.out.println("");
        Ps.mostrarMas1Hora(peliculas);
        System.out.println("");
        Ps.mostrarDescendente(peliculas);
        System.out.println("");
        Ps.mostrarAscendente(peliculas);
        System.out.println("");
        Ps.mostrarTituloAlfabeticamente(peliculas);
        System.out.println("");
    }
    
}
