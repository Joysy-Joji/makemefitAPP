package com.example.app_makemefit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;*/

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private static int SPLASH_SCREEN = 5000;
    Animation topanim, bottomanim;
    ImageView thozhilpic, logo;
    TextView appname;
    // String mobile_id,password_id,check_ID,check_Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        thozhilpic = findViewById(R.id.imageView);
        logo = findViewById(R.id.imageView2);
        appname = findViewById(R.id.textView);
        thozhilpic.setAnimation(topanim);
        logo.setAnimation(bottomanim);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
                finish();


            }
        },SPLASH_SCREEN);



    }
}