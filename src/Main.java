import Datas.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca1 = cargarDatosBiblioteca();

        Scanner sc = new Scanner(System.in);
        int opcion;
        int d;

        do {
            System.out.println("\n****** GESTIÓN DE BIBLIOTECA ******");
            System.out.println("1. Añadir o eliminar libros");
            System.out.println("2. Mostrar listas de libros");
            System.out.println("3. Prestar o devolver libros");
            System.out.println("0. Guardar y Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    Libro nuevoLibro = new Libro();
                    System.out.println("¿Qué acción quieres realizar? (0. Agregar libro // 1. Eliminar libro");
                    d = sc.nextInt();
                    sc.nextLine();

                    if (d == 0) {
                        System.out.print("Ingresa los datos del libro que quieres agregar:\nTítulo -> ");
                        String t = sc.nextLine();
                        System.out.print("Autor -> ");
                        String a = sc.nextLine();
                        System.out.print("ISBN -> ");
                        String i = sc.nextLine();
                        nuevoLibro = new Libro(t, a, i, false);

                    } else if (d == 1) {
                        if (!biblioteca1.recorrerColeccion().isEmpty()) {
                            System.out.print("Título del libro -> ");
                            String t = sc.nextLine();
                            nuevoLibro = new Libro(t, null, null, false);
                        } else {
                            System.out.println("No hay libros en la biblioteca. Intenta añadir alguno.");
                            break;
                        }
                    }

                    biblioteca1.modificarLibro(nuevoLibro, d);

                    guardarDatosBiblioteca(biblioteca1);
                    break;
                case 2:
                    System.out.println("¿Qué lista quieres ver? (0. Lista completa // 1. Lista de prestamos)");
                    d = sc.nextInt();

                    if (d == 0) {
                        System.out.println("\n*** Lista de libros ***");
                        biblioteca1.mostrarLista(d);

                    } else if (d == 1) {
                        System.out.println("\n*** Libros prestados ***");
                        biblioteca1.mostrarLista(d);

                    }

                    break;
                case 3:
                    System.out.println("\n¿Qué acción quieres realizar? (0. Prestar libro // 1. Devolver libro");
                    d = sc.nextInt();
                    System.out.print("Título del libro -> ");
                    String t = sc.nextLine();

                    if (d == 0) {
                        biblioteca1.prestarYdevolver(t, d);

                    } else if (d == 1) {
                        biblioteca1.prestarYdevolver(t, d);

                    }

                    break;
                case 0:
                    guardarDatosBiblioteca(biblioteca1);

                    System.out.println("Datos guardados correctamente. Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Vuelva a intentarlo.");
            }

        } while (opcion != 0);
    }
    // Funciones
    public static Biblioteca cargarDatosBiblioteca() {
        // "try-with-resources", inserta la clase dentro del parentesis del try, lo que cierra el flujo automaticamente cuando termina.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Biblioteca.dat"))) {
            return (Biblioteca) ois.readObject();
        } catch (Exception e) {
            System.out.println("No se han podido cargar los datos. Se devolverá una biblioteca vacía.");
            return new Biblioteca();
        }
    }

    public static void guardarDatosBiblioteca(Biblioteca biblioteca) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Biblioteca.dat"))) {
            oos.writeObject(biblioteca);
        } catch (Exception e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}