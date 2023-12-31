/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Entidades.Pelicula;
import java.util.Comparator;

/**
 *
 * @author Rafael
 */
public class Comparadores {
    public static Comparator<Pelicula> duracionDescendente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {
          
            return t1.getDuracion().compareTo(t.getDuracion());
       
        }
    };
    
    public static Comparator<Pelicula> duracionAscendente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {
            
          return t.getDuracion().compareTo(t1.getDuracion());
        }
    };
    
    public static Comparator<Pelicula> tituloAlafabeticamente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {
            return t.getTitulo().compareTo(t1.getTitulo());
        }
    };
    
    public static Comparator<Pelicula> directorAlfabeticamente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {
           return t.getDirector().compareTo(t1.getDirector());
        }
    };
}
