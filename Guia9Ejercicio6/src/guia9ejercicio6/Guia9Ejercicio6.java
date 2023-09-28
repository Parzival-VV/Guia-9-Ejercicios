/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
productos que venderemos y el precio que tendrán. Además, se necesita que la
aplicación cuente con las funciones básicas.
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package guia9ejercicio6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class Guia9Ejercicio6 {

    /**
     * @param args the command line arguments INVENTARIO.
     */
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        HashMap<String, Double> producto = new HashMap();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n----------INVENTARIO----------\n"
                    + "\n" + "Elija una de las siguientes opciones: " + "\n"
                    + "\n1 - INTRODUCIR PRODUCTO." + "\n"
                    + "2 - MODIFICAR PRECIO." + "\n"
                    + "3 - ELIMINAR PRODUCTO." + "\n"
                    + "4 - MOSTRAR INVENTARIO." + "\n"
                    + "5 - SALIR" + "\n");
            int opc = leer.nextInt();

            switch (opc) {

                case 1:

                    boolean match = true;

                    while (match) {

                        System.out.println("\n----------INTRODUCIR PRODUCTO----------");

                        String nombre = null;
                        Double precio = 0.00;

                        while (true) {
                            System.out.println("\nIngrese el nombre del producto: ");
                            nombre = leer.next();

                            if (!nombre.matches("^[a-zA-Z]+$")) {
                                System.out.println("\nINGRESE UN DATO VALIDO.");
                            } else {
                                break;
                            }
                        }

                        boolean entradaValida = true;

                        while (entradaValida) {
                            System.out.println("\nIngrese el precio del preoducto: ");

                            if (leer.hasNextDouble()) {
                                precio = leer.nextDouble();
                                entradaValida = false;

                            } else {
                                System.out.println("\nINGRESE UN DATO VALIDO.");
                            }
                        }
                        producto.put(nombre, precio);

                        String respuesta;

                        while (true) {

                            System.out.println("\nDesea agregar otro producto?");
                            respuesta = leer.next();

                            if (!respuesta.matches("^[a-zA-Z]+$")) {

                                System.out.println("\nERROR DATO NO VALIDO.");

                            } else {
                                break;
                            }
                        }

                        if (!respuesta.equalsIgnoreCase("si")) {
                            match = false;
                        }

                    }
                    break;
                    
                case 2:
                    
                    System.out.println("\n----------MODIFICAR PRECIO PRODUCTO----------");
                    String nombre;
                    Double precio = null;

                    while (true) {
                        System.out.println("\nIngrese el nombre del producto a modificar: ");
                        nombre = leer.next();

                        if (!nombre.matches("^[a-zA-Z]+$")) {
                            System.out.println("\nERROR DATO NO VALIDO.");
                        } else {
                            break;
                        }
                    }

                        if (producto.containsKey(nombre)) {
                            
                            boolean entradaValida = true;

                            while (entradaValida) {
                                System.out.println("\nIngrese el precio del preoducto: ");

                                if (leer.hasNextDouble()) {
                                    precio = leer.nextDouble();
                                    entradaValida = false;

                                } else {
                                    System.out.println("\nINGRESE UN DATO VALIDO.");
                                }
                            }

                            producto.put(nombre, precio);

                        } else {
                            System.out.println("\nEl producto ingresado no existe.");
                        }

                    

                    break;
                    
                case 3:

                    String nombreAux;

                    System.out.println("\n----------ELIMINAR PRODUCTO----------");

                    while (true) {
                        System.out.println("\nIngrese el nombre del producto a eliminar: ");
                        nombreAux = leer.next();

                        if (!nombreAux.matches("^[a-zA-Z]+$")) {
                            System.out.println("\nERROR DATO NO VALIDO.");
                        } else {
                            break;
                        }
                    }

                        if (producto.containsKey(nombreAux)) {
                            producto.remove(nombreAux);

                        } else {
                            System.out.println("\nEl producto ingresado no existe.");
                        }

                    break;
                    
                case 4:

                    System.out.println("\n----------MOSTRAR PRODUCTO----------\n");

                    for (Map.Entry<String, Double> entry : producto.entrySet()) {
                        String key = entry.getKey();
                        Double value = entry.getValue();

                        System.out.println("Producto: " + key + "\n"
                                + "Precio: " + value + "\n");

                    }

                    break;
                case 5:
                    String respuesta;

                    while (true) {

                        System.out.println("\nDesea salir del programa? ");
                        respuesta = leer.next();

                        if (!respuesta.matches("^[a-zA-Z]+$")) {
                            System.out.println("\nERROR INGRESE DATO VALIDO.");

                        } else {
                            break;
                        }

                    }
                    if (!respuesta.equalsIgnoreCase("no")) {
                        salir = true;
                    }
                    break;
                default:
                    System.out.println("\nLA OPCION NGRESADA NO ES VALIDA.");
                    break;
            }

            System.out.println("");

        }

    }

}
