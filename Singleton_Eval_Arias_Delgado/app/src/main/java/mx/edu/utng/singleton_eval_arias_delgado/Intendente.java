package mx.edu.utng.singleton_eval_arias_delgado;

/**
 * Created by eduardo on 09/09/2016.
 */
public class Intendente {
    private String nombre;
    private int edad;

    private static Intendente intendente;

    private Intendente() {
        this.nombre = "";
        this.edad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static Intendente getIntendente(){
        if (intendente==null) {
            intendente = new Intendente();
        }
        return intendente;
    }

}
