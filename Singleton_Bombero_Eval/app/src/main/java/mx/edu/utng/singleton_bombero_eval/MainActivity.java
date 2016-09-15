package mx.edu.utng.singleton_bombero_eval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtNombre;
    private EditText edtPuesto;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText)findViewById(R.id.edt_nom);
        edtPuesto = (EditText)findViewById(R.id.edt_pusto);
        btnGuardar = (Button)findViewById(R.id.btn_guardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bombero bombero = Bombero.getBombero();
                bombero.setNom(edtNombre.getText().toString());
                bombero.setPuesto(edtPuesto.getText().toString());

                Toast.makeText(MainActivity.this,"Datos ingresados"+"" +
                        "\nNombre: "+bombero.getNom()+"\nPuesto: "+bombero.getPuesto(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
