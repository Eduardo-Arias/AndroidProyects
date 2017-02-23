package mx.edu.utng.orders;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.orders.adapters.SalaryAdapter;
import mx.edu.utng.orders.model.Product;
import mx.edu.utng.orders.model.Salary;
import mx.edu.utng.orders.sqlite.DBOperations;

public class SalaryActivity extends AppCompatActivity {
    private EditText etEmpNo;
    private EditText etSalary;
    private EditText etFromDate;
    private Button btSaveSalary;
    private DBOperations operations;
    private Salary salary = new Salary();
    private RecyclerView rvSalary;
    private List<Salary> salaries =new ArrayList<Salary>();
    private SalaryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);
        //iniciacion de la instancia
        operations=DBOperations.getDBOperations(getApplicationContext());
        salary.setIdSalary("");


        initComponents();
    }
    private void initComponents(){
        rvSalary =(RecyclerView)findViewById(R.id.rv_salary_list);
        rvSalary.setHasFixedSize(true);
        LinearLayoutManager layoutManeger=new LinearLayoutManager(this);
        rvSalary.setLayoutManager(layoutManeger);
        //
        getSalaries();
        adapter=new SalaryAdapter(salaries);

        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_delete_salary:
                        operations.deleteSalary(salaries.get(rvSalary.getChildPosition((View)v.getParent().getParent())).getIdSalary());
                        getSalaries();
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.bt_edit_salary:
                        Cursor c = operations.getSalaryById(salaries.get(
                                rvSalary.getChildPosition(
                                        (View)v.getParent().getParent())).getIdSalary());
                        if (c!=null){
                            if (c.moveToFirst()){
                                salary = new Salary(c.getString(1),c.getInt(2),c.getInt(3),c.getString(4));
                            }
                            etEmpNo.setText(String.valueOf(salary.getEmpNo()));
                            etSalary.setText(String.valueOf(salary.getSalary()));
                            etFromDate.setText(salary.getFromDate());
                        }else{
                            Toast.makeText(getApplicationContext(),"Registro no encontrado",Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

            }
        });
        rvSalary.setAdapter(adapter);

        etEmpNo =(EditText)findViewById(R.id.et_emp_no);
        etSalary =(EditText)findViewById(R.id.et_salary);
        etFromDate =(EditText)findViewById(R.id.et_date);

        btSaveSalary =(Button)findViewById(R.id.bt_save_salary);

        btSaveSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!salary.getIdSalary().equals("")){
                    salary.setEmpNo(Integer.parseInt(etEmpNo.getText().toString()));
                    salary.setSalary(Integer.parseInt(etSalary.getText().toString()));
                    salary.setFromDate(etFromDate.getText().toString());
                    operations.updateSalary(salary);

                }else {
                    salary = new Salary("", Integer.parseInt(etEmpNo.getText().toString()),
                            Integer.parseInt(etSalary.getText().toString()),
                            etFromDate.getText().toString());
                    operations.insertSalary(salary);
                }
                getSalaries();
                clearData();
                adapter.notifyDataSetChanged();
            }
        });

    }
    private void getSalaries(){
        Cursor c =operations.getSalarys();
        salaries.clear();
        if(c!=null){
            while (c.moveToNext()){
                salaries.add(new Salary(c.getString(1),c.getInt(2),c.getInt(3),c.getString(4)));
            }
        }

    }

    private void clearData(){
        etEmpNo.setText("");
        etSalary.setText("");
        etFromDate.setText("");
        salary =null;
        salary = new Salary();
        salary.setIdSalary("");
    }
}
