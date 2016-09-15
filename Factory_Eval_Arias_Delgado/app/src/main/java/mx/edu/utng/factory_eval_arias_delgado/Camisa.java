package mx.edu.utng.factory_eval_arias_delgado;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by eduardo on 13/09/2016.
 */
public class Camisa implements Ropa {


    @Override
    public void dibujar(Canvas canvas) {
        Paint paint=new Paint();
        Path path = new Path();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);

        path.moveTo(150,100);
        path.lineTo(250,100);
        path.lineTo(300,150);
        path.lineTo(300,200);
        path.lineTo(250,200);
        path.lineTo(250,300);
        path.lineTo(150,300);
        path.lineTo(150,200);
        path.lineTo(100,200);
        path.lineTo(100,150);
        path.close();

        canvas.drawPath(path,paint);
    }
}
