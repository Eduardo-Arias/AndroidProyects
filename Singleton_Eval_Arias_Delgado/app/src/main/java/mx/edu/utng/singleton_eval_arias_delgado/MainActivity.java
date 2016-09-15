package mx.edu.utng.singleton_eval_arias_delgado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtNom;
    private EditText edtEdad;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNom = (EditText)findViewById(R.id.edt_nom);
        edtEdad = (EditText)findViewById(R.id.edt_edad);
        btnGuardar = (Button)findViewById(R.id.btn_guardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intendente intendente = Intendente.getIntendente();
                intendente.setNombre(edtNom.getText().toString());
                intendente.setEdad(Integer.parseInt(edtEdad.getText().toString()));

                Toast.makeText(MainActivity.this,"Intentende"
                        +"\nNombre"+intendente.getNombre()
                        +"\nEdad"+intendente.getEdad(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
