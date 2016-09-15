package mx.edu.utng.prototype_eval_arias_delgado;

/**
 * Created by eduardo on 12/09/2016.
 */
public class Alumno implements Clonable{
    private String nombre;
    private String apellido;

    public Alumno(){

    }

    @Override
    public Clonable clonar() {
        Alumno clon = new Alumno(apellido, nombre);
        return clon;
    }

    public Alumno(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
