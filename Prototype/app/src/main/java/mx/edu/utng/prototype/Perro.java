package mx.edu.utng.prototype;

/**
 * Created by eduardo on 08/09/2016.
 */
public class Perro implements Cloneable{
    private String raza;
    private int edad;
    private String color;

    public Perro(){}

    public Perro(String raza, String color, int edad) {
        this.raza = raza;
        this.color = color;
        this.edad = edad;
    }

    public Cloneable clonar(){
        Perro perro_clon = new Perro(raza, color, edad);
        return perro_clon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
