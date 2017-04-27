package com.jjsoluciones.examdef;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class ListExamDef extends ListActivity {


    final String NAMESPACE = "http://ws.utng.edu.mx";

    final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
            SoapEnvelope.VER11);

    private ArrayList<ExamDef> examDefs = new ArrayList<ExamDef>();
    private int idSeleccionado;
    private int posicionSeleccionado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Exams query = new Exams();
        query.execute();
        registerForContextMenu(getListView());


    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_modificar:
                ExamDef examDef = examDefs.get(posicionSeleccionado);
                Bundle bundleLibro = new Bundle();
                for (int i = 0; i < examDef.getPropertyCount(); i++) {
                    bundleLibro.putString("valor" + i, examDef.getProperty(i)
                            .toString());
                }
                bundleLibro.putString("accion", "modificar");
                Intent intent = new Intent(ListExamDef.this, ExamDefWS.class);
                intent.putExtras(bundleLibro);
                startActivity(intent);

                return true;
            case R.id.item_eliminar:
                DeleteExam eliminar = new DeleteExam();
                eliminar.execute();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(getApplicationContext());
        menuInflater.inflate(R.menu.menu_back, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_regresar:
                startActivity(new Intent(ListExamDef.this, ExamDefWS.class));
                break;
            default:
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(getListView().getAdapter().getItem(info.position).toString());
        idSeleccionado = (Integer) examDefs.get(info.position).getProperty(0);
        posicionSeleccionado = info.position;
        inflater.inflate(R.menu.menu_options, menu);
    }




    private class Exams extends AsyncTask<String, Integer, Boolean> {

        protected Boolean doInBackground(String... params) {

            boolean result = true;
            final String METHOD_NAME = "getExams";
            final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;
            examDefs.clear();
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            envelope.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(ExamDefWS.URL);
            try {
                transporte.call(SOAP_ACTION, envelope);
                Vector<SoapObject> response = (Vector<SoapObject>) envelope.getResponse();
                if (response != null) {
                    for (SoapObject objSoap : response) {
                        ExamDef examDef = new ExamDef();
                        examDef.setProperty(0, Integer.parseInt(objSoap.getProperty("id").toString()));
                        examDef.setProperty(1, objSoap.getProperty("name").toString());
                        examDef.setProperty(2, objSoap.getProperty("description").toString());
                        examDef.setProperty(3, Integer.parseInt(objSoap.getProperty("mininumCorr").toString()));
                        examDef.setProperty(4, Integer.parseInt(objSoap.getProperty("duration").toString()));
                        examDef.setProperty(5, objSoap.getProperty("examTake").toString());
                        examDef.setProperty(6, objSoap.getProperty("questionDef").toString());
                        examDefs.add(examDef);
                    }
                }

            } catch (XmlPullParserException e) {
                Log.e("Error XMLPullParser", e.toString());
                result = false;
            } catch (HttpResponseException e) {
                Log.e("Error HTTP", e.toString());

                result = false;
            } catch (IOException e) {
                Log.e("Error IO", e.toString());
                result = false;
            } catch (ClassCastException e) {
                try {
                    SoapObject objSoap = (SoapObject) envelope.getResponse();
                    ExamDef examDef = new ExamDef();
                    examDef.setProperty(0, Integer.parseInt(objSoap.getProperty("id").toString()));
                    examDef.setProperty(1, objSoap.getProperty("name").toString());
                    examDef.setProperty(2, objSoap.getProperty("description").toString());
                    examDef.setProperty(3, Integer.parseInt(objSoap.getProperty("mininumCorr").toString()));
                    examDef.setProperty(4, Integer.parseInt(objSoap.getProperty("duration").toString()));
                    examDef.setProperty(5, objSoap.getProperty("examTake").toString());
                    examDef.setProperty(6, objSoap.getProperty("questionDef").toString());
                    examDefs.add(examDef);
                } catch (SoapFault e1) {
                    Log.e("Error SoapFault", e.toString());
                    result = false;
                }
            }
            return result;
        }

        protected void onPostExecute(Boolean result) {

            if (result) {
                final String[] datos = new String[examDefs.size()];
                for (int i = 0; i < examDefs.size(); i++) {
                    datos[i] = examDefs.get(i).getProperty(0) + " - "
                            + examDefs.get(i).getProperty(1)+ " - "
                            + examDefs.get(i).getProperty(2)+ " - "
                            + examDefs.get(i).getProperty(3)+ " - "
                            + examDefs.get(i).getProperty(4)+ " - "
                            + examDefs.get(i).getProperty(5)+ " - "
                            + examDefs.get(i).getProperty(6);
                }

                ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                        ListExamDef.this,
                        android.R.layout.simple_list_item_1, datos);
                setListAdapter(adaptador);
            } else {
                Toast.makeText(getApplicationContext(), "No se encontraron datos.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }









    private class DeleteExam extends AsyncTask<String, Integer, Boolean> {

        protected Boolean doInBackground(String... params) {

            boolean result = true;

            final String METHOD_NAME = "removeExam";
            final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;


            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("id", idSeleccionado);

            envelope.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(ExamDefWS.URL);
            try {
                transporte.call(SOAP_ACTION, envelope);
                SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse();
                String res = resultado_xml.toString();

                if (!res.equals("0")) {
                    result = true;
                }

            } catch (Exception e) {
                Log.e("Error", e.toString());
                result = false;
            }
            return result;
        }

        protected void onPostExecute(Boolean result) {

            if (result) {
                Toast.makeText(getApplicationContext(),
                        "Eliminado", Toast.LENGTH_SHORT).show();
                Exams consulta = new Exams();
                consulta.execute();
            } else {
                Toast.makeText(getApplicationContext(), "Error al eliminar",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

}
