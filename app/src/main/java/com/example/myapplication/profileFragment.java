package com.example.myapplication;

import static com.example.myapplication.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class profileFragment extends Fragment {
    private RecyclerView rv;
    private TextView Id, Name, Dob, Role;

    private List<Employee> employeeList = new ArrayList<>();
    private List<Employee> employeefilter;
    private EmployeeAdapter adap;
    private SearchView sv;


private ArrayList<Employee>emplist;
    private String[] txtname;
    private String[] txtdob;
    private String[] txtrole;
    private String[] txtid;
    private RecyclerView recyclerview;

    @SuppressLint("MissingInflatedId")
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize EditText fields

        Id =view.findViewById(R.id.first);
        Name = view.findViewById(R.id.second);
        Dob = view.findViewById(R.id.third);
        Role = view.findViewById(R.id.forth);
//        btnadd = view.findViewById(R.id.btnadd);
        rv = view.findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
//        textsearch = (SearchView) view.findViewById(id.textsearch);
        employeefilter = new ArrayList<>();
        adap = new EmployeeAdapter(getContext(),employeefilter);
        rv.setAdapter(adap);
        sv = (SearchView) view.findViewById(R.id.textsearch);
        sv.clearFocus();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterByname(newText.toString());
                return true;
            }
        });
//            rv=view.findViewById(R.id.recyclerview);
//







return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataIntialize();
        employeefilter.addAll(employeeList);
        recyclerview=view.findViewById(id.recyclerview);
        rv.setHasFixedSize(true);
        EmployeeAdapter ead =new EmployeeAdapter(getContext(),emplist);
    }

    private void dataIntialize() {
        emplist=new ArrayList<>();

        txtid=new String[]{
                getString(R.string.id1),
        getString(R.string.id2),
        getString(R.string.id3),
        getString(R.string.id4),
        getString(R.string.id5),

        };
        txtname=new String[]{
                getString(R.string.name1),
                getString(R.string.name2),
                getString(R.string.name3),
                getString(R.string.name4),
                getString(R.string.name5),
        };
        txtdob=new String[]{
                getString(R.string.dob1),
                getString(R.string.dob2),
                getString(R.string.dob3),
                getString(R.string.dob4),
                getString(R.string.dob5),
        };
        txtrole=new String[]{
                getString(R.string.role1),
                getString(R.string.role2),
                getString(R.string.role3),
                getString(R.string.role4),
                getString(R.string.role5),
        };
        for(int i=0;i<txtid.length;i++){
            Employee emp=new Employee(txtid[i],txtname[i],txtdob[i],txtrole[i]);
            employeeList.add(emp);
        }
    }

    private void filterByname(String name) {
        employeefilter.clear();
        for (Employee info : employeeList) {
            if (info.name().toLowerCase().contains(name.toLowerCase())) {
                employeefilter.add(info);
            }
        }
        if (employeefilter.isEmpty()) {
            Toast.makeText(getContext(), "No data Found", Toast.LENGTH_SHORT).show();
        } else {
            // Set the RecyclerView adapter with the filtered list
            adap.setEmployee(employeefilter);
        }
    }


}
