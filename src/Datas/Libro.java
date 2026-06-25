package Datas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Libro implements Serializable {
    String titulo, autor;
    String isbn;
    boolean prestado;

    // Constructor
    public Libro(String titulo, String autor, String isbn, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.prestado = prestado;
    }

    public Libro() {
        this.titulo = null;
        this.autor = null;
        this.isbn = null;
        this.prestado = false;
    }

    // Funciones


    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        String pT;

        if (isPrestado()) {
            pT = "Prestado";
        } else {
            pT = "Disponible";
        }

        return this.titulo + " / Autor: " + this.autor + " / Estado: " + pT;
    }
}