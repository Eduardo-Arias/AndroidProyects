package mx.edu.utng.factory_herrramientas;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by eduardo on 13/09/2016.
 */
public class Lienzo extends View {
    private Tienda tienda;

    public Lienzo(Context context, Tienda tienda){
        super(context);
        this.tienda=tienda;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (tienda!=null){
            tienda.dibujar(canvas);
        }
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
