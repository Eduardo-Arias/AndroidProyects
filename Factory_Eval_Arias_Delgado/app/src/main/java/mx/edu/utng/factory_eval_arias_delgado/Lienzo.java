package mx.edu.utng.factory_eval_arias_delgado;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by eduardo on 13/09/2016.
 */
public class Lienzo extends View {
    private Ropa ropa;

    public Lienzo(Context context, Ropa ropa){
        super(context);
        this.ropa = ropa;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (ropa !=null){
            ropa.dibujar(canvas);
        }
    }

    public Ropa getRopa() {
        return ropa;
    }

    public void setRopa(Ropa ropa) {
        this.ropa = ropa;
    }
}
