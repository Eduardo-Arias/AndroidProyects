package mx.edu.utng.factory_herrramientas;

/**
 * Created by eduardo on 13/09/2016.
 */
public class TiendaFactory {
    private Tienda tienda;

    public Tienda crearPrenda(String tipo) {
        if (tipo != null) {
            if (tipo.equalsIgnoreCase("martillo")) {
                tienda = new Martillo();
            } else if (tipo.equalsIgnoreCase("llave")) {
                tienda = new Llave();
            } else  {
                return null;
            }
        }
        return tienda;
    }
}

