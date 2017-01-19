package utng.edu.mx.da3_u1_jead_operaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarE1(View view) {
        Intent i = new Intent(this, FirstEquationActivity.class );
        startActivity(i);
    }

    public void lanzarE2(View view) {
        Intent i = new Intent(this, SecondEquationActivity.class );
        startActivity(i);
    }
}
