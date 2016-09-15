package mx.edu.utng.factory_eval_arias_delgado;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by eduardo on 13/09/2016.
 */
public class Zapato implements Ropa {
    @Override
    public void dibujar(Canvas canvas) {

        Paint paint = new Paint();
        Path path = new Path();

        path.moveTo(100,100);//1
        path.lineTo(175,100);//2
        path.lineTo(175,200);//3
        path.lineTo(265,215);//4
        path.lineTo(285,265);//5
        path.lineTo(155,250);//6
        path.lineTo(155,260);//7
        path.lineTo(115,260);//8
        path.lineTo(100,250);//9
        path.lineTo(100,100);//10
        path.close();

        canvas.drawPath(path,paint);
    }
}
