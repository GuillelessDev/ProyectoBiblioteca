package Datas;

import java.util.ArrayList;

public class Usuario extends Persona {
    String codigoCarnet;
    ArrayList<Libro> prestados;

    // Constructor
    public Usuario(String nombre, String apellido, String dni, String codigoCarnet) {
        super(nombre, apellido, dni);
        this.codigoCarnet = codigoCarnet;
        prestados = new ArrayList<>();
    }

    // Funciones

    public void prestarYdevolver(ArrayList<Libro> coleccion, Usuario usuTemporal, String t, int d) {
        if (d == 0) {
            for (Libro libro : coleccion) {
                if (libro.getTitulo().equalsIgnoreCase(t)) {
                    if (!libro.isPrestado()) {
                        libro.setPrestado(true);

                        usuTemporal.prestados.add(libro);

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

                        usuTemporal.prestados.remove(libro);

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

    // Getters y Setters
    public String getCodigoCarnet() {
        return codigoCarnet;
    }

    public void setCodigoCarnet(String codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }

    public ArrayList<Libro> getPrestados() {
        return prestados;
    }

    public void setPrestados(ArrayList<Libro> prestados) {
        this.prestados = prestados;
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + " / DNI: " + this.dni + " / Código Carnet: " + codigoCarnet;
    }
}
