package mx.edu.utng.factory_herrramientas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by eduardo on 13/09/2016.
 */
public class Llave implements Tienda {
    @Override
    public void dibujar(Canvas canvas) {
        Paint paint = new Paint();
        Path path = new Path();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);

        path.moveTo(150,100);
        path.lineTo(150,135);
        path.lineTo(175,150);
        path.lineTo(175,300);
        path.lineTo(150,315);
        path.lineTo(150,350);
        path.lineTo(175,350);
        path.lineTo(175,325);
        path.lineTo(200,325);
        path.lineTo(200,350);
        path.lineTo(225,350);
        path.lineTo(225,315);
        path.lineTo(200,300);
        path.lineTo(200,150);
        path.lineTo(225,135);
        path.lineTo(225,100);
        path.lineTo(200,100);
        path.lineTo(200,115);
        path.lineTo(175,115);
        path.lineTo(175,100);
        path.lineTo(150,100);
        path.close();

        canvas.drawPath(path,paint);

    }
}
