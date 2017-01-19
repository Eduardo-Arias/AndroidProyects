package utng.edu.mx.da3_u1_jead_operaciones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by eduardo on 19/01/2017.
 */

public class SecondEquationActivity extends AppCompatActivity {
    private EditText edtA;
    private EditText edtB;
    private Button btnEquation2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_equation_main);

        edtA = (EditText)findViewById(R.id.edt_a);
        edtB = (EditText)findViewById(R.id.edt_b);

        btnEquation2 = (Button)findViewById(R.id.btn_calculate2);

        btnEquation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resul1;
                int resul2;
                int resulFinal;

                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());

                resul1 = ((3*a)-b)*((3*a)-b);
                resul2 = 3*(((a+b)*(a+b)));
                resulFinal = resul1 + resul2;

                Toast.makeText(SecondEquationActivity.this, "" + resulFinal, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
