package mx.edu.utng.orders.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mx.edu.utng.orders.R;
import mx.edu.utng.orders.model.Salary;

/**
 * Created by eduardo on 23/02/2017.
 */

public class SalaryAdapter extends RecyclerView.Adapter<SalaryAdapter.SalaryViewHolder>
        implements View.OnClickListener{
    List<Salary> salaries;
    View.OnClickListener listener;
    //Constructor
    public SalaryAdapter(List<Salary> salaries){
        this.salaries = salaries;
    }
    //getter and setter de listener
    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public SalaryAdapter.SalaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //se inflael cardview al reciclerview
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_salary_layout,parent,false);
        SalaryAdapter.SalaryViewHolder holder=new SalaryAdapter.SalaryViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(SalaryViewHolder holder, int position) {
        holder.tvEmpNo.setText( String.valueOf( salaries.get(position).getEmpNo()));
        holder.tvSalary.setText(String.valueOf( salaries.get(position).getSalary()));
        holder.tvFromDate.setText(salaries.get(position).getFromDate());
        holder.iv_Salary.setImageResource(R.mipmap.ic_launcher);
        holder.setListener(this);
    }

    @Override
    public int getItemCount() {
        return salaries.size();
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    public static class SalaryViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cvSalary;
        TextView tvEmpNo;
        TextView tvSalary;
        TextView tvFromDate;
        ImageView iv_Salary;
        ImageButton btEditSalary;
        ImageButton btDeleteSalary;
        View.OnClickListener listener;

        public SalaryViewHolder(View itemView) {
            super(itemView);
            cvSalary =(CardView)itemView.findViewById(R.id.cv_salary);
            iv_Salary =(ImageView)itemView.findViewById(R.id.iv_salary);
            tvEmpNo =(TextView)itemView.findViewById(R.id.tv_salary_no_emp);
            tvSalary =(TextView)itemView.findViewById(R.id.tv_salary);
            tvFromDate =(TextView)itemView.findViewById(R.id.tv_salary_from_date);
            btEditSalary =(ImageButton) itemView.findViewById(R.id.bt_edit_salary);
            btDeleteSalary =(ImageButton) itemView.findViewById(R.id.bt_delete_salary);
            btEditSalary.setOnClickListener(this);
            btDeleteSalary.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener!=null){
                listener.onClick(v);
            }
        }

        public void setListener(View.OnClickListener listener){
            this.listener=listener;

        }
    }
}
