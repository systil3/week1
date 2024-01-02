package com.example.a1230;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            setContentView(R.layout.activity_main);

            //page transaction in main page
            Button BackButton = findViewById(R.id.BackButton);

            BackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction transaction2 = fragmentManager.beginTransaction();
                    transaction2.replace(R.id.fragment_container, new Index());
                    transaction2.addToBackStack(null);
                    transaction2.commit();
                }
            });
            transaction.replace(R.id.fragment_container, new Index());
            transaction.commit();

        } catch (Exception e) {e.printStackTrace(); }
    }
}

