package com.example.app_makemefit;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private FirebaseAuth auth;
    EditText Name,Mobile,Password,Confirmpassword;
    Button register;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        Name =(EditText) findViewById(R.id.name);
        Mobile =(EditText)findViewById(R.id.mobile);
        Password=(EditText) findViewById(R.id.password);
        Confirmpassword=(EditText) findViewById(R.id.confirmpassword);
        register=(Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Name.getText().toString().trim();
                String mob = Mobile.getText().toString().trim();
                String pass = Password.getText().toString().trim();

                if (user.isEmpty()) {
                    Name.setError("Email cannot be empty");
                }
                if (mob.isEmpty()){
                    Mobile.setError("Mobile cannot be empty");
                }
                if (pass.isEmpty()){
                    Password.setError("Password cannot be empty");
                } else{
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(signup.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signup.this, login.class));
                            } else {
                                Toast.makeText(signup.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        login=(TextView)findViewById(R.id.logintext);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(signup.this, login.class);
                startActivity(d);


            }
        });
    }
}