package mx.edu.utng.prototype_eval_arias_delgado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtNombre;
    private EditText edtApe;
    private Button btnClonar;
    private GridView grvAlumno;

    private ArrayList<Alumno> alumno;
    private Alumno alu;
    private AlumnoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre=(EditText)findViewById(R.id.edt_nombre);
        edtApe=(EditText)findViewById(R.id.edt_ape);
        btnClonar=(Button)findViewById(R.id.btn_clonar);
        grvAlumno=(GridView)findViewById(R.id.grv_alummno);

        alumno = new ArrayList<Alumno>();
        alu = new Alumno();

        btnClonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alu.setApellido(edtApe.getText().toString());
                alu.setNombre(edtNombre.getText().toString());

                Alumno clon =(Alumno)alu.clonar();
                alumno.add(clon);
                adapter =new AlumnoAdapter(MainActivity.this,alumno);
                grvAlumno.setAdapter(adapter);
            }
        });
    }
}
