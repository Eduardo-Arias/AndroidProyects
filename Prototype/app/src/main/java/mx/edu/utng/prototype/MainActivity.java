package mx.edu.utng.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtRaza;
    private EditText edtEdad;
    private EditText edtColor;
    private Button btnClonar;
    private GridView grvPerro;

    private ArrayList<Perro> perros;
    private Perro perro;
    private PerroAdapter perroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtRaza = (EditText)findViewById(R.id.edt_raza);
        edtEdad = (EditText)findViewById(R.id.edt_edad);
        edtColor = (EditText)findViewById(R.id.edt_Color);
        grvPerro = (GridView)findViewById(R.id.grv_perro);

        perros = new ArrayList<Perro>();
        perro = new Perro();

        btnClonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perro.setRaza(edtRaza.getText().toString());
                perro.setEdad(Integer.parseInt(edtEdad.getText().toString()));
                perro.setColor(edtColor.getText().toString());

                Perro clon = (Perro)perro.clonar();
                perros.add(clon);
                perroAdapter = new PerroAdapter(MainActivity.this,perros);
                grvPerro.setAdapter(perroAdapter);
            }
        });
    }
}
