/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
salir, se mostrará todos los perros guardados en el ArrayList.
 */
package guia9ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class Guia9Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        ArrayList<String> razas = new ArrayList();
        
        String respuesta;
        
        do{
            
           String raza; 
           
            
           while(true){
               System.out.println("Ingrese una raza: ");
            raza = leer.next();
            
            if(!raza.matches("^[a-zA-Z]+")){
               System.out.println("ERROR: Ingrese una letra valida.");
            }else{
                razas.add(raza);
                break;
            }
            
           }
           
            while(true){
                System.out.println("\nDesea continuar: ");
                respuesta = leer.next();
                
                if (!respuesta.matches("^[a-zA-Z]{2}$")){
                System.out.println("ERROR: Ingrese una letra valida.");
                }else{
                   break; 
                }
                
            }
            
            if (!respuesta.equalsIgnoreCase("si")){
                
                System.out.println("");
                System.out.println("Las razas de la lista son: ");
                
                for (String raza1 : razas) {
                    System.out.println(raza1);
                    
                }
                break;
            }
           
            
        }while(respuesta.equalsIgnoreCase("si"));
        System.out.println("");
        
//        Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
//un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
//está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
//ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
//la lista ordenada.
      
        String raza1;
        while(true){
            
            System.out.println("Ingrese una raza: ");
            raza1 = leer.next();
            
            if(!raza1.matches("^[a-zA-Z]+")){
               System.out.println("ERROR: Ingrese una raza valida.");
            }else{
                break;
            }
        }
        
        Iterator<String> it = razas.iterator();
        
        boolean match = true;
        while(it.hasNext()){
            
            String aux = it.next();
            if (raza1.equalsIgnoreCase(aux)) {
                it.remove();
                match = false;
            }
        }
        
        if (match){
            System.out.println("\nLa raza ingresada no se encuentra en la lista.");
        }
       
       Collections.sort(razas);
       mostrar(razas);
        
    }
    
    public static void mostrar(ArrayList<String> razas){
        Iterator<String> raza = razas.iterator();
        System.out.println("");
        System.out.println("Las razas de su lista son: ");
        while (raza.hasNext()){
            System.out.println(raza.next());
        }
        System.out.println("");
    }
    
}
