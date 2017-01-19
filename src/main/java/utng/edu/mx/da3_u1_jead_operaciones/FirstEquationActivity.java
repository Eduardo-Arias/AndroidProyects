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

public class FirstEquationActivity extends AppCompatActivity{
    private EditText edt_x;
    private EditText edt_y;
    private Button btn_equation1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_equation_main);

        edt_x = (EditText)findViewById(R.id.edt_x);
        edt_y = (EditText)findViewById(R.id.edt_y);

        btn_equation1 = (Button)findViewById(R.id.btn_calculate1);

        btn_equation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resul1;
                int resul2;
                int resul3;
                int resul4;
                int resulFinal;
                int x = Integer.valueOf(edt_x.getText().toString());
                int y = Integer.valueOf(edt_y.getText().toString());
                
                resul1 = (x + y)* (x + y);
                resul2 = (x - y)* (x - y);
                resul3 = resul1 + resul2;
                resul4 = x * y;
                resulFinal = resul4 * resul3;

                Toast.makeText(FirstEquationActivity.this, "" + resulFinal, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
