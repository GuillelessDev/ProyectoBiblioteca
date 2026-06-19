import Datas.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca1 = cargarDatosBiblioteca();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n****** GESTOR BIBLIOTECA ******");
            System.out.println("1. Añadir o eliminar libro");
            System.out.println("2. Mostrar catálogo de libros");
            System.out.println("3. Mostrar libros prestados");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("0. Guardar y Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    Libro nuevoLibro = new Libro();
                    System.out.println("¿Qué quieres hacer? (0. Agregar // 1. Eliminar");
                    int d = sc.nextInt();
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
                        System.out.print("Título del libro -> ");
                        String t = sc.nextLine();
                        nuevoLibro = new Libro(t, null, null, false);
                    }

                    biblioteca1.agregarLibro(nuevoLibro, d);

                    guardarDatosBiblioteca(biblioteca1);
                    break;
                case 2:
                    System.out.println("\n*** Lista de libros ***");

                    biblioteca1.mostrarLibros();
                    break;
                case 3:
                    System.out.println("\n*** Libros prestados ***");

                    biblioteca1.mostrarPrestados();
                    break;
                case 4:
                    System.out.print("Título del libro -> ");
                    String tP = sc.nextLine();

                    biblioteca1.prestarLibro(tP);
                    break;
                case 5:
                    System.out.print("Título del libro -> ");
                    String tD = sc.nextLine();

                    biblioteca1.devolverLibro(tD);
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