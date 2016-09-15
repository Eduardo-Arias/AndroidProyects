package mx.edu.utng.factory_herrramientas;

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
    private Tienda tienda;
    private TiendaFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPrenda=(EditText)findViewById(R.id.edt_prenda);
        btnBuscar=(Button)findViewById(R.id.btn_buscar);
        layPrincipal=(LinearLayout)findViewById(R.id.lay_principal);

        lienzo = new Lienzo(MainActivity.this,tienda);
        layPrincipal.addView(lienzo);
        factory = new TiendaFactory();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tienda = factory.crearPrenda(edtPrenda.getText().toString());
                lienzo.setTienda(tienda);
                lienzo.invalidate();
            }
        });
    }
}
