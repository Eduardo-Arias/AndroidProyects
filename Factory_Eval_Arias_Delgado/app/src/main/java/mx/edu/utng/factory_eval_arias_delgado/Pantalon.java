package mx.edu.utng.factory_eval_arias_delgado;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by eduardo on 13/09/2016.
 */
public class Pantalon implements Ropa {

    @Override
    public void dibujar(Canvas canvas) {
        Paint paint = new Paint();
        Path path = new Path();
        paint.setStyle(Paint.Style.FILL);

        path.moveTo(125,100);
        path.lineTo(275,100);
        path.lineTo(300,350);
        path.lineTo(225,350);
        path.lineTo(200,200);
        path.lineTo(175,350);
        path.lineTo(100,350);
        path.lineTo(125,100);
        path.close();

        canvas.drawPath(path,paint);
    }
}
