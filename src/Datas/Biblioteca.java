package Datas;

import java.io.Serializable;
import java.util.ArrayList;

public class Biblioteca implements Serializable {
    private ArrayList<Libro> coleccion;
    private ArrayList<Usuario> listaUsuarios;

    // Constructor
    public Biblioteca() {
        coleccion = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
    }

    // Funciones

    public void agregarYeliminarLibros(Libro nuevoLibro, int d) {
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
                System.out.println("No hay libros en este momento.");
            }

        } else if (d == 1) {
            for (Libro libro : coleccion) {
                if (libro.isPrestado()) {
                    System.out.println(contador + ". " + libro.getTitulo() + " // Autor: " + libro.getAutor());
                    contador++;
                }
            }
            if (contador == 1) {
                System.out.println("No hay libros prestados en este momento.");
            }

        } else if (d == 2) {
            for (Usuario usuario : listaUsuarios) {
                System.out.println(contador + ". " + usuario);
                contador++;
            }
            if (contador == 1) {
                System.out.println("No existen usuarios en este momento.");
            }
        }
    }

    public void crearYeliminarUsuarios(Usuario nuevoUsuario, int d) {
        if (d == 0) {
            for (Usuario usuario : listaUsuarios) {
                if (nuevoUsuario.getCodigoCarnet().equalsIgnoreCase(usuario.getCodigoCarnet()) || nuevoUsuario.getDni().equalsIgnoreCase(usuario.getDni())) {
                    System.out.println("Este usuario ya está registrado.");
                    return;
                }
            }
            listaUsuarios.add(nuevoUsuario);
            System.out.println("El usuario ha sido creado con éxito.");

        } else if (d == 1) {
            for (Usuario usuario : listaUsuarios) {
                if (nuevoUsuario.getCodigoCarnet().equalsIgnoreCase(usuario.getCodigoCarnet()) || nuevoUsuario.getDni().equalsIgnoreCase(usuario.getDni())) {
                    listaUsuarios.remove(usuario);
                    System.out.println("El usuario se ha eliminado con éxito.");
                    return;
                }
            }
            System.out.println("Este usuario no está registrado.");
        }
    }

    public Usuario devolverUsuario(String cc) {
        for (Usuario usuario : listaUsuarios) {
            if (cc.equalsIgnoreCase(usuario.getCodigoCarnet())) {
                return usuario;
            }
        }
        return null;
    }

    public ArrayList<Libro> recorrerColeccion() {
        return getColeccion();
    }

    public ArrayList<Usuario> recorrerListaUsuarios() {
        return getListaUsuarios();
    }

    // Getters y Setters

    private ArrayList<Libro> getColeccion() {
        return coleccion;
    }

    private void setColeccion(ArrayList<Libro> coleccion) {
        this.coleccion = coleccion;
    }

    private ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    private void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}