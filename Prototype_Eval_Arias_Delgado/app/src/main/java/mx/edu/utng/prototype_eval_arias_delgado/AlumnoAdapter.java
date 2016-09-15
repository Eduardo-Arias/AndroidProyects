package mx.edu.utng.prototype_eval_arias_delgado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by eduardo on 13/09/2016.
 */
public class AlumnoAdapter extends ArrayAdapter<Alumno> {

    public AlumnoAdapter(Context context, ArrayList<Alumno> alumnos){
        super(context,0,alumnos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            Alumno alumno = getItem(position);
        if (convertView==null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.alumno,parent,false);
        }
        TextView txvAlumno = (TextView)
                convertView.findViewById(R.id.txv_alumno);
        txvAlumno.setText(alumno.getNombre()+" "+ alumno.getApellido());

        return convertView;
    }
}
