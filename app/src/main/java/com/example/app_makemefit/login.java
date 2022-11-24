package com.example.app_makemefit;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Patterns;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity {
    private FirebaseAuth auth;
    EditText mob, password;
    Button login;
    TextView forgotpswrd, signup, signupsecond;
    String mobile_id, password_id;
    String check_ID, check_Password;
    // private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();

        signup = (TextView) findViewById(R.id.signuptext);
        signupsecond = (TextView) findViewById(R.id.signuptextsecond);





        login=(Button)findViewById(R.id.login);
        forgotpswrd=(TextView)findViewById(R.id.forgotpassword);
        mob=(EditText)findViewById(R.id.number);
        password=(EditText)findViewById(R.id.password);

login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String email = mob.getText().toString();
        String pass = password.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!pass.isEmpty()) {
                auth.signInWithEmailAndPassword(email, pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(login.this, home.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                password.setError("Password cannot be empty");
            }
        } else if(email.isEmpty()) {
            mob.setError("Email cannot be empty");
        } else {
            mob.setError("Please enter valid email");
        }

    }
});



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(login.this, signup.class);
                startActivity(reg);
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent = new Intent(login.this, signup.class);

                startActivity(signupIntent);
            }
        });
        signupsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent1 = new Intent(login.this, signup.class);

                startActivity(signupIntent1);
            }
        });
    }


}