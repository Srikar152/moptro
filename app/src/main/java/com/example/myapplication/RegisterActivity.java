package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {
EditText edUsername,edEmail,edPassword,edconfirm;
Button btn;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        edUsername = findViewById(R.id.editTextregUsername);
        edEmail = findViewById(R.id.editTextregEmail);
        edPassword = findViewById(R.id.editTextregPassword);
        edconfirm = findViewById(R.id.editTextregConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.ExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edconfirm.getText().toString();
                Database db=new Database(getApplicationContext(),"employee dashboard",null,1);
                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill All the details", Toast.LENGTH_SHORT).show();
                } else {
                    if(isemail(email)) {


                        if (password.compareTo(confirm) == 0) {
                            if (isvalid(password)) {

                                db.register(username, email, password);
                                Toast.makeText(getApplicationContext(), "Sucessfully Registered", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                            } else {
                                Toast.makeText(getApplicationContext(), "Password must contain atleast 8 characters,digit 0-9 and special characters ", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Enter valid email address", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
        public static boolean isvalid(String pass){
            int l=0,n=0,c=0;
            if(pass.length()<8){
                return false;
            }else{
                for(int i=0;i<pass.length();i++){
                    if(Character.isLetter(pass.charAt(i))){
                        l=1;
                    }
                }
                for(int j=0;j<pass.length();j++){
                    if(Character.isDigit(pass.charAt(j))){
                        n=1;
                    }
                }
                for(int k=0;k<pass.length();k++){
                    char ch=pass.charAt(k);
                    if(ch>=33 && ch<=46 || ch==64){
                        c=1;
                    }
                }
                if(l==1 && c==1 && n==1)
                    return true;

                return false;
            }
        }
        public static boolean isemail(String email){
        String em=email.replace("[A-z]","");
        if(em.contains("@")&& em.contains("."))
         return true;
        return false;
        }

}