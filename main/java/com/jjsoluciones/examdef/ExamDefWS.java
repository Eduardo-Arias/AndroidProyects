package com.jjsoluciones.examdef;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class ExamDefWS extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etDescription;
    private EditText etMinimum;
    private EditText etDuration;
    private EditText etExam;
    private EditText etQuestion;

    private Button btGuardar;
    private Button btListar;

    private ExamDef examDef = null;
    final String NAMESPACE =
            "http://ws.utng.edu.mx";
    final SoapSerializationEnvelope envelope =
            new SoapSerializationEnvelope(SoapEnvelope.VER11);
    static String URL =
            "http://192.168.24.49:8080/TestingWS/services/ExamDefWS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_def_ws);
        components();
    }

    private void components() {
        etName = (EditText) findViewById(R.id.et_name_exam);
        etDescription = (EditText) findViewById(R.id.et_description);
        etMinimum = (EditText) findViewById(R.id.et_minimum);
        etDuration = (EditText) findViewById(R.id.et_duration);
        etExam = (EditText) findViewById(R.id.et_exam_take);
        etQuestion = (EditText) findViewById(R.id.et_question);

        btGuardar = (Button) findViewById(R.id.bt_save);
        btListar = (Button) findViewById(R.id.bt_list);
        btGuardar.setOnClickListener(this);
        btListar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_consume_w, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String description = etDescription.getText().toString();
        String minimum = etMinimum.getText().toString();
        String duration = etDuration.getText().toString();
        String exam = etExam.getText().toString();
        String question = etQuestion.getText().toString();


        if (v.getId() == btGuardar.getId()) {
            if (name != null && !name.isEmpty() &&
                    //name != null && !description.isEmpty() &&
                    description != null && !description.isEmpty() &&
                    minimum != null && !minimum.isEmpty() &&
                    duration != null && !duration.isEmpty()&&
                    exam != null && !exam.isEmpty() &&
                    question != null && !question.isEmpty()) {
                try {
                    if (getIntent().getExtras().getString("accion")
                            .equals("modificar")) {
                        updateExamDef tarea = new updateExamDef();
                        tarea.execute();
                    }

                } catch (Exception e) {
                    //Cuando no se haya mandado una accion por defecto es insertar.
                    InsertExamDef tarea = new InsertExamDef();
                    tarea.execute();
                }
            } else {
                Toast.makeText(this, "llenar todos los campos", Toast.LENGTH_LONG).show();
            }

        }
        if (btListar.getId() == v.getId()) {
            startActivity(new Intent(ExamDefWS.this, ListExamDef.class));
        }
    }//fin conClick

    private void cleanEditTex() {
        etName.setText("");
        etDescription.setText("");
        etMinimum.setText("");
        etDuration.setText("");
        etExam.setText("");
        etQuestion.setText("");
    }


    private class InsertExamDef extends
            AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            boolean result = true;
            final String METHOD_NAME = "addExam";
            final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;

            SoapObject request =
                    new SoapObject(NAMESPACE, METHOD_NAME);

            examDef = new ExamDef();
            examDef.setProperty(0, 0);
            obtenerDatos();

            PropertyInfo info = new PropertyInfo();
            info.setName("examDef");
            info.setValue(examDef);
            info.setType(examDef.getClass());
            request.addProperty(info);
            envelope.setOutputSoapObject(request);
            envelope.addMapping(NAMESPACE, "ExamDef", ExamDef.class);

            /* Para serializar flotantes y otros tipos no cadenas o enteros*/
            MarshalFloat mf = new MarshalFloat();
            mf.register(envelope);

            HttpTransportSE transporte = new HttpTransportSE(URL);
            try {
                transporte.call(SOAP_ACTION, envelope);
                SoapPrimitive response =
                        (SoapPrimitive) envelope.getResponse();
                String res = response.toString();
                if (!res.equals("1")) {
                    result = false;
                }

            } catch (Exception e) {
                Log.e("Error ", e.getMessage());
                result = false;
            }

            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                cleanEditTex();
                Toast.makeText(getApplicationContext(),
                        "Registro exitoso.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Error al insertar.",
                        Toast.LENGTH_SHORT).show();

            }
            cleanEditTex();
        }
    }//fin tarea insertar

    private class updateExamDef extends
            AsyncTask<String, Integer, Boolean> {

        protected Boolean doInBackground(String... params) {

            boolean result = true;

            final String METHOD_NAME = "editExam";
            final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            examDef = new ExamDef();
            examDef.setProperty(0, getIntent().getExtras().getString("valor0"));
            obtenerDatos();

            PropertyInfo info = new PropertyInfo();
            info.setName("examDef");
            info.setValue(examDef);
            info.setType(examDef.getClass());

            request.addProperty(info);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);

            envelope.setOutputSoapObject(request);

            envelope.addMapping(NAMESPACE, "ExamDef", examDef.getClass());

            MarshalFloat mf = new MarshalFloat();
            mf.register(envelope);

            HttpTransportSE transporte = new HttpTransportSE(URL);

            try {
                transporte.call(SOAP_ACTION, envelope);

                SoapPrimitive resultado_xml = (SoapPrimitive) envelope
                        .getResponse();
                String res = resultado_xml.toString();

                if (!res.equals("1")) {
                    result = false;
                }

            } catch (HttpResponseException e) {
                Log.e("Error HTTP", e.toString());
            } catch (IOException e) {
                Log.e("Error IO", e.toString());
            } catch (XmlPullParserException e) {
                Log.e("Error XmlPullParser", e.toString());
            }

            return result;

        }

        protected void onPostExecute(Boolean result) {

            if (result) {
                Toast.makeText(getApplicationContext(), "Actualizado OK",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Error al actualizar",
                        Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void obtenerDatos() {
        examDef.setProperty(1, etName.getText().toString());
        examDef.setProperty(2, etDescription.getText().toString());
        examDef.setProperty(3, Integer.parseInt(etMinimum.getText().toString()));
        examDef.setProperty(4, Integer.parseInt(etDuration.getText().toString()));
        examDef.setProperty(5, etExam.getText().toString());
        examDef.setProperty(6, etQuestion.getText().toString());

    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle datosRegreso = this.getIntent().getExtras();
        try {

            etName.setText(datosRegreso.getString("valor1"));
            etDescription.setText(datosRegreso.getString("valor2"));
            etMinimum.setText(datosRegreso.getString("valor3"));
            etDuration.setText(datosRegreso.getString("valor4"));
            etExam.setText(datosRegreso.getString("valor5"));
            etQuestion.setText(datosRegreso.getString("valor6"));
        } catch (Exception e) {
            Log.e("Error al Recargar", e.toString());
        }

    }
}
