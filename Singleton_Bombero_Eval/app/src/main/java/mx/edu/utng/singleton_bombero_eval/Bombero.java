package mx.edu.utng.singleton_bombero_eval;

/**
 * Created by eduardo on 09/09/2016.
 */
public class Bombero {
    private String nom;
    private String puesto;

    private static Bombero bombero;

    private Bombero(){
        this.nom="";
        this.puesto="";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public static Bombero getBombero(){
        if (bombero==null){
            bombero = new Bombero();
        }
        return bombero;
    }
}
