package Datas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca implements Serializable {
    private ArrayList<Libro> coleccion;

    // Constructor
    public Biblioteca() {
        coleccion = new ArrayList<>();
    }

    // Funciones
    public void modificarLibro(Libro nuevoLibro, int d) {
        if (d == 0) {
            for (Libro libro : coleccion) {
                if (nuevoLibro.getTitulo().equalsIgnoreCase(libro.getTitulo()) || nuevoLibro.getIsbn().equalsIgnoreCase(libro.getIsbn())) {
                    System.out.println("Este libro ya se encuentra en la lista.");
                    return;
                }
            }
            coleccion.add(nuevoLibro);
            System.out.println("El libro ha sido añadido con éxito.");

        } else if (d == 1) {
            for (Libro libro : coleccion) {
                if (nuevoLibro.getTitulo().equalsIgnoreCase(libro.getTitulo()) || nuevoLibro.getIsbn().equalsIgnoreCase(libro.getIsbn())) {
                    coleccion.remove(libro);
                    System.out.println("El libro se ha eliminado con éxito.");
                    return;
                }
            }
            System.out.println("Este libro no se encuentra en la lista.");

        } else {
            System.out.println("Opción no válida. Vuelva a intentarlo.");
        }
    }

    public void mostrarLista(int d) {
        int contador = 1;

        if (d == 0) {
            for (Libro libro : coleccion) {
                System.out.println(contador + ". " + libro);
                contador++;
            }
            if (contador == 1) {
                System.out.println("No hay libros en este momento");
            }

        } else if (d == 1) {
            for (Libro libro : coleccion) {
                if (libro.isPrestado()) {
                    System.out.println(contador + ". " + libro.getTitulo() + " // Autor: " + libro.getAutor());
                    contador++;
                }
            }
            if (contador == 1) {
                System.out.println("No hay libros prestados en este momento");
            }
        } else {
            System.out.println("Opción no válida. Vuelva a intentarlo.");
        }


    }

    public void prestarYdevolver(String t, int d) {
        if (d == 0) {
            for (Libro libro : coleccion) {
                if (libro.getTitulo().equalsIgnoreCase(t)) {
                    if (!libro.isPrestado()) {
                        libro.setPrestado(true);

                        System.out.println("El libro ha sido prestado con exito.");
                    } else {
                        System.out.println("Este libro ya está prestado.");
                    }
                    return;
                }
            }
            System.out.println("Este libro no se encuentra en la lista.");

        } else if (d == 1) {
            for (Libro libro : coleccion) {
                if (libro.getTitulo().equalsIgnoreCase(t)) {
                    if (libro.isPrestado()) {
                        libro.setPrestado(false);

                        System.out.println("El libro ha sido devuelto con exito.");
                    } else {
                        System.out.println("Este libro no está prestado.");
                    }
                    return;
                }
            }
            System.out.println("Este libro no se encuentra en la lista.");
        }
    }

    public ArrayList<Libro> recorrerColeccion() {
        return getColeccion();
    }

    // Getters y Setters
    private ArrayList<Libro> getColeccion() {
        return coleccion;
    }

    private void setColeccion(ArrayList<Libro> coleccion) {
        this.coleccion = coleccion;
    }

    @Override
    public String toString() {
        return "Lista de libros: " + coleccion;
    }
}