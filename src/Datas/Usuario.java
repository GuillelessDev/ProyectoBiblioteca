package Datas;

import java.util.ArrayList;

public class Usuario extends Persona {
    String codigoCarnet;
    ArrayList<Libro> prestados;

    public Usuario(String nombre, String apellido, String dni, String codigoCarnet, ArrayList<Libro> prestados) {
        super(nombre, apellido, dni);
        this.codigoCarnet = codigoCarnet;
        this.prestados = prestados;
    }

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
}
