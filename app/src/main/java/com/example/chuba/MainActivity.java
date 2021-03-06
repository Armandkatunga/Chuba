package com.example.chuba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.chuba.Fragments.AboutusFragment;
import com.example.chuba.Fragments.HomeFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button home_btn,map_btn,about_btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ini();
        events();


    }

   // initialization | attachment
    private void ini() {

        home_btn = findViewById(R.id.home_btn);
        map_btn = findViewById(R.id.map_btn);
        about_btn = findViewById(R.id.about_btn);
        mAuth= FirebaseAuth.getInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.load, new HomeFragment()).commit();



    }
    // event binding
    private void events() {

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().setTitle("Chuba");
                getSupportFragmentManager().beginTransaction().replace(R.id.load, new HomeFragment()).commit();
            }
        });

        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().setTitle("Map");
               getSupportFragmentManager().beginTransaction().replace(R.id.load, new MapFragment()).commit();
            }
        });

        about_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().setTitle("About Us");
                getSupportFragmentManager().beginTransaction().replace(R.id.load, new AboutusFragment()).commit();
            }
        });


    }

    // Notifcatin center
    private void notify(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
    // Redirection
    private  void switchToActivity(){

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
