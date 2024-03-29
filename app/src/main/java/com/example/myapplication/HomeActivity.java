package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
ActivityHomeBinding bin;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(bin.getRoot());
        replaceFragment(new homeFragment());
    bin.bottomNavigationView.setOnItemSelectedListener(item->{
        if(item.getItemId()==R.id.home) {
            replaceFragment(new homeFragment());

        }else if(item.getItemId()==R.id.profile){
                replaceFragment(new profileFragment());

        }
        return true;
    });

    }
    private void replaceFragment(Fragment f){
        FragmentManager fg=getSupportFragmentManager();
        FragmentTransaction ft=fg.beginTransaction();
        ft.replace(R.id.framelayout,f);
        ft.commit();
    }
}