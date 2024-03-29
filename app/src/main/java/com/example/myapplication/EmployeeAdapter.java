package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    List<Employee>List;
   Context context;

   public EmployeeAdapter(Context context,List<Employee> employeeList){
       this.context=context;
        this.List=employeeList;
    }
    public void setEmployee(List<Employee> employeeList){
        this.List=employeeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new EmployeeViewHolder(v);
   }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee emp=List.get(position);
        holder.id.setText(emp.id());
        holder.name.setText(emp.name());
        holder.dob.setText(emp.dob());
        holder.role.setText(emp.Role());
    }
    @Override
    public int getItemCount() {
        return List.size();
    }
    public class EmployeeViewHolder extends RecyclerView.ViewHolder{
       private TextView name;
       private TextView role;
       private TextView dob;
       private TextView id;
       public EmployeeViewHolder(@NonNull View itemView){
           super(itemView);
           id=itemView.findViewById(R.id.first);
           name=itemView.findViewById(R.id.second);
           dob=itemView.findViewById(R.id.third);
           role=itemView.findViewById(R.id.forth);
       }
       public void bind(Employee e){
           id.setText(e.id());
           name.setText(e.name());
           dob.setText(e.dob());
           role.setText(e.Role());
       }
    }
}
