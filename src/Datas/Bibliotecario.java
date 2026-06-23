package Datas;

public class Bibliotecario extends Persona {
    String codigoBibliotecario;

    public Bibliotecario(String nombre, String apellido, String dni, String codigoBibliotecario) {
        super(nombre, apellido, dni);
        this.codigoBibliotecario = codigoBibliotecario;
    }

    @Override
    public void presentarse() {
        System.out.println("Hola, soy Guillermo, bibliotecario.");
    }
}
