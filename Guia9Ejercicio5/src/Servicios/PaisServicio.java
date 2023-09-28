/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
los servicios en la clase correspondiente)
Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
cómo se ordena un conjunto.
Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
al usuario.
 */
package Servicios;

import Entidades.Pais;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Rafael
 */
public class PaisServicio {

    private Scanner leer = new Scanner(System.in);

    public HashSet<Pais> crearPais() {

        HashSet<Pais> paises = new HashSet();

        boolean respuesta = true;

        while (respuesta) {

            Pais P1 = new Pais();

            while (true) {

                System.out.println("\nIngrese un pais: ");
                P1.setNombre(leer.next());

                if (!P1.getNombre().matches("^[a-zA-Z]+$")) {
                    System.out.println("ERROR: Ingrese un pais valido.");
                } else {
                    paises.add(P1);
                    break;
                }
            }

            System.out.println("");

            System.out.println("\nDesea agregar otra pais?: ");
            String rp = leer.next();

            if (!rp.equalsIgnoreCase("Si")) {
                respuesta = false;
            }

        }

        return paises;

    }

    public void mostrar(HashSet<Pais> paises) {

        System.out.println("---------- PAISES INGRESADOS ---------");

        paises.forEach((e) -> System.out.println("\nPais:" + e.getNombre()));

    }

    public static Comparator<Pais> ordenSet = new Comparator<Pais>() {
        @Override
        public int compare(Pais t, Pais t1) {
            return t.getNombre().compareTo(t1.getNombre());
        }
    };

    public void mostrarAlfabeticamente(HashSet<Pais> paises) {

        System.out.println("\n----------PAISES ORDENADOS ALFABETICAMENTE----------\n");

        TreeSet<Pais> listaordenada = new TreeSet<>(ordenSet);
        listaordenada.addAll(paises);
        
       
        listaordenada.forEach((e) -> System.out.println("\nPais: " + e.getNombre()));
    }
    
//    Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
//buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
//usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
//al usuario.
    
    public void eliminarPais(HashSet<Pais> paises){
        
        System.out.println("\n----------ELIMINAR PAIS----------\n");
        String aux;
        
        while(true){
            
            System.out.println("\nIngrese el nombre de un pais: ");
            aux = leer.next();
            
            if (!aux.matches("^[a-zA-Z]+$")) {
                System.out.println("ERROR: Ingrese un pais valido.");
            } else {
                break;
            }
        }
        
        Iterator<Pais> iterador = paises.iterator();
        
        boolean match = true;
        
        while (iterador.hasNext()){
            
            Pais P1 = iterador.next();
            
            if (P1.getNombre().equalsIgnoreCase(aux)){
                    iterador.remove();
                    mostrar(paises);
                    match = false;
       
            }    
            
        }
        
        if(match){
            System.out.println("El pais ingresado no se encuentra en la lista.");
        }
    }
}
