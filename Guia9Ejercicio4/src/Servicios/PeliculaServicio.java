/*
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:
 */
package Servicios;

import Entidades.Pelicula;
import Utilidades.Comparadores;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class PeliculaServicio {

    private Scanner leer = new Scanner(System.in);

    public ArrayList<Pelicula> crearPelicula() {
        ArrayList<Pelicula> pelis = new ArrayList();
        int i = 0;
        boolean respuesta = true;
        while (respuesta) {

            Pelicula P1 = new Pelicula();
            System.out.println("-----CARGA DE DATOS DE PELICULAS-----" + "\n\n"
                    + "PELICULA " + (i + 1) + " :");

            while (true) {
                System.out.println("\nTITULO: ");
                P1.setTitulo(leer.nextLine());

                if (!P1.getTitulo().matches("^[a-zA-Z ]+")) {
                    System.out.println("ERROR: Ingrese un Titulo valido.");
                } else {
                    break;
                }
            }
            System.out.println("");

            while (true) {
                System.out.println("\nDIRECTOR: ");
                P1.setDirector(leer.nextLine());

                if (!P1.getDirector().matches("^[a-zA-Z ]+")) {
                    System.out.println("ERROR: Ingrese un Director valido.");
                } else {
                    break;
                }

            }
            System.out.println("");

            boolean entradaValida1 = false;
            boolean entradaValida2 = false;
            boolean entradaValida3 = false;

            int hora = 0, minutos = 0, segundos = 0;

            while (!entradaValida1) {

                System.out.println("\nIngresela cantidad de horas: ");

                if (leer.hasNextInt()) {
                    hora = leer.nextInt();
                    entradaValida1 = true;

                } else {
                    System.out.println("\nEntrada no valida. intentelo de nuevo:");
                    leer.next();
                }

            }

            while (!entradaValida2) {

                System.out.println("\nIngresela cantidad de minutos: ");

                if (leer.hasNextInt()) {
                    minutos = leer.nextInt();
                    entradaValida2 = true;

                } else {
                    System.out.println("\nEntrada no valida. intentelo de nuevo:");
                    leer.next();
                }
                if (minutos > 60) {
                    System.out.println("\nEntrada no valida. intentelo de nuevo:");
                    entradaValida2 = false;
                }

            }

            while (!entradaValida3) {

                System.out.println("\nIngresela cantidad de segundos: ");

                if (leer.hasNextInt()) {
                    segundos = leer.nextInt();
                    entradaValida3 = true;

                } else {
                    System.out.println("\nEntrada no valida. intentelo de nuevo:");
                    leer.next();
                }
                if (segundos > 60) {
                    System.out.println("\nEntrada no valida. intentelo de nuevo:");
                    entradaValida3 = false;
                }

            }
            Time duracion = new Time(hora, minutos, segundos);
            P1.setDuracion(duracion);

            pelis.add(P1);

            i++;

            System.out.println("\nDesea agregar otra pelicula?: ");
            String rp = leer.next();

            if (!rp.equalsIgnoreCase("Si")) {
                respuesta = false;
            }
            leer.nextLine();
        }
        return pelis;
    }

//       • Mostrar en pantalla todas las películas.
    public void mostrarPeliculas(ArrayList<Pelicula> peliculas) {
        System.out.println("\n----------PELICULAS----------" + "\n");

        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println("Titulo: " + peliculas.get(i).getTitulo() + ". \n"
                    + "Director: " + peliculas.get(i).getDirector() + ". \n"
                    + "Duracion: " + peliculas.get(i).getDuracion());

        }
        System.out.println("");
    }

//    • Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
    public void mostrarMas1Hora(ArrayList<Pelicula> peliculas) {
        System.out.println("----------PELICULAS QUE DURAN MAS DE UNA HORA----------\n\n");

        for (int i = 0; i < peliculas.size(); i++) {

            if (peliculas.get(i).getDuracion().getHours() > 0) {
                System.out.println("Titulo: " + peliculas.get(i).getTitulo() + ". \n"
                        + "Director: " + peliculas.get(i).getDirector() + ". \n"
                        + "Duracion: " + peliculas.get(i).getDuracion());
            }
        }

    }
//    • Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
//pantalla.

    public void mostrarDescendente(ArrayList<Pelicula> peliculas) {

        Collections.sort(peliculas, Comparadores.duracionDescendente);

        System.out.println("----------PELICULAS EN ORDEN DE DURACION DESCENDENTE----------\n\n");

        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println("Titulo: " + peliculas.get(i).getTitulo() + ". \n"
                    + "Director: " + peliculas.get(i).getDirector() + ". \n"
                    + "Duracion: " + peliculas.get(i).getDuracion());

        }
        System.out.println("");

    }
//    • Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
////pantalla.

    public void mostrarAscendente(ArrayList<Pelicula> peliculas) {

        Collections.sort(peliculas, Comparadores.duracionAscendente);

        System.out.println("----------PELICULAS EN ORDEN DE DURACION ASCENDENTE----------\n\n");

        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println("Titulo: " + peliculas.get(i).getTitulo() + ". \n"
                    + "Director: " + peliculas.get(i).getDirector() + ". \n"
                    + "Duracion: " + peliculas.get(i).getDuracion());

        }
        System.out.println("");

    }
//        • Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.

    public void mostrarTituloAlfabeticamente(ArrayList<Pelicula> peliculas) {

        Collections.sort(peliculas, Comparadores.tituloAlafabeticamente);

        System.out.println("----------PELICULAS EN ORDEN POR TITULO LFABETICAMENTE----------\n\n");

        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println("Titulo: " + peliculas.get(i).getTitulo() + ". \n"
                    + "Director: " + peliculas.get(i).getDirector() + ". \n"
                    + "Duracion: " + peliculas.get(i).getDuracion());

        }
        System.out.println("");

    }
//        • Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.

    public void mostrarDirectorAlfabeticamente(ArrayList<Pelicula> peliculas) {

        Collections.sort(peliculas, Comparadores.directorAlfabeticamente);

        System.out.println("----------PELICULAS EN ORDEN POR DIRECTOR LFABETICAMENTE----------\n\n");

        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println("Titulo: " + peliculas.get(i).getTitulo() + ". \n"
                    + "Director: " + peliculas.get(i).getDirector() + ". \n"
                    + "Duracion: " + peliculas.get(i).getDuracion());

        }
        System.out.println("");

    }
}

