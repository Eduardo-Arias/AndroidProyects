package mx.edu.utng.factory_eval_arias_delgado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private EditText edtPrenda;
    private Button btnBuscar;
    private LinearLayout layPrincipal;
    private Lienzo lienzo;
    private Ropa ropa;
    private RopaFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPrenda=(EditText)findViewById(R.id.edt_prenda);
        btnBuscar=(Button)findViewById(R.id.btn_buscar);
        layPrincipal=(LinearLayout)findViewById(R.id.lay_principal);

        lienzo = new Lienzo(MainActivity.this, ropa);
        layPrincipal.addView(lienzo);
        factory = new RopaFactory();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ropa = factory.crearPrenda(edtPrenda.getText().toString());
                lienzo.setRopa(ropa);
                lienzo.invalidate();
            }
        });
    }
}
