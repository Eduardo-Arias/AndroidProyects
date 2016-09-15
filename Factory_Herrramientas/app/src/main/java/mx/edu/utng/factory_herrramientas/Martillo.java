package mx.edu.utng.factory_herrramientas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by eduardo on 13/09/2016.
 */
public class Martillo implements Tienda{

    @Override
    public void dibujar(Canvas canvas) {
        Paint paint = new Paint();
        Path path = new Path();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        path.moveTo(150,350);
        path.lineTo(150,125);
        path.lineTo(125,150);
        path.lineTo(100,150);
        path.lineTo(150,100);
        path.lineTo(175,100);
        path.lineTo(175,115);
        path.lineTo(200,115);
        path.lineTo(200,100);
        path.lineTo(215,100);
        path.lineTo(215,150);
        path.lineTo(200,150);
        path.lineTo(200,135);
        path.lineTo(175,135);
        path.lineTo(175,350);
        path.lineTo(150,350);
        path.close();

        canvas.drawPath(path,paint);
    }
}
