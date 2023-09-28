
package Servicios;

import Entidades.Alumnos;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class AlumnosServicio {

    private Scanner leer = new Scanner(System.in);
    
//    En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
//toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
//pregunta al usuario si quiere crear otro Alumno o no.

    public ArrayList<Alumnos> CrearObjeto() {
        ArrayList<Alumnos> alumnos = new ArrayList();
        int i = 0;
        boolean respuesta = true;
        while (respuesta) {
            
            Alumnos a1 = new Alumnos();
            System.out.println("-----CARGA DE DATOS DEL ALUMNO-----" + "\n\n"
                    + "Alumno " + (i + 1));

            while (true) {
                System.out.println("\nIngrese nombre del alumno: ");
                a1.setNombre(leer.next());

                if (!a1.getNombre().matches("^[a-zA-Z]+")) {
                    System.out.println("ERROR: Ingrese una raza valida.");
                } else {
                    break;
                }
            }
            System.out.println("");

            for (int j = 0; j < 3; j++) {
                 boolean entradaValida = false;

                while (!entradaValida) {
                    
                    System.out.println("Ingrese la nota " + (j + 1));

                    if (leer.hasNextInt()) {
                        a1.getNotas().add(leer.nextInt());
                        entradaValida = true;
                      
                    } else {
                        System.out.println("\nEntrada no valida. intentelo de nuevo:");
                        leer.next();
                    }

                }
                
            }
            alumnos.add(a1);

            i++;
            
            System.out.println("\nDesea agregar otro alumno?: ");
            String rp = leer.next();
            
            if (rp.equalsIgnoreCase("no")) {
                respuesta = false;   
            }
        }
        
        return alumnos;
        
        
    }
/*
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.*/
   
    public void notaFinal(){
        
       ArrayList<Alumnos> alumnos =  CrearObjeto();
        
        String nombre;
        System.out.println("");
        while (true) {
                System.out.println("\nIngrese nombre del alumno: ");
                nombre = leer.next();

                if (!nombre.matches("^[a-zA-Z]+")) {
                    System.out.println("ERROR: Ingrese una raza valida.");
                } else {
                    break;
                }
            }
            System.out.println("");
            
            int suma = 0;
            boolean match = false;
            for (int i = 0; i < alumnos.size(); i++) {
                if (alumnos.get(i).getNombre().equalsIgnoreCase(nombre)){
                    for (int j = 0; j < alumnos.get(i).getNotas().size(); j++) {
                       suma += alumnos.get(i).getNotas().get(j);
                    }
                }else{
                    match = true;
                }
            
        }
        if (!match) {
            System.out.println("\nLa nota final del alumno " + nombre + " es: " + (suma / 3));
            System.out.println("");
        }else{
            System.out.println("El nombre no se encuntra en la lista");
        }
          
    }

}
