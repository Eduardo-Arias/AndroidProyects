package mx.edu.utng.factory_eval_arias_delgado;

/**
 * Created by eduardo on 13/09/2016.
 */
public class RopaFactory {
    private Ropa ropa;

    public Ropa crearPrenda(String tipo) {
        if (tipo != null) {
            if (tipo.equalsIgnoreCase("camisa")) {
                ropa = new Camisa();
            } else if (tipo.equalsIgnoreCase("pantalon")) {
                ropa = new Pantalon();
            } else if (tipo.equalsIgnoreCase("zapato")) {
                ropa = new Zapato();
            } else {
                return null;
            }
        }
        return ropa;
    }
}

