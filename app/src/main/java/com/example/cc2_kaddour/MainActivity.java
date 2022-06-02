package com.example.cc2_kaddour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1, b2, b3;
        MyDatabase db;
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            public void precedent(View view) {
                Intent i = new Intent();
                i.putExtra("Retour1","OK 1");
                i.putExtra("Retour2","OK 2");
                setResult(1,i);
                finish();
            }

            public void acces (View Thread view;
            view){
                Intent i = null;
                switch ((int) view.getId()) {
                    case R.id.b1:
                        i = new Intent(MainActivity.this, MainActivity.class);
                        break;
                    case R.id.b2:
                        i = new Intent(MainActivity.this, editeenreprise.class);
                        break;
                    case R.id.b3:
                        i = new Intent(MainActivity.this, addentreprise.class);
                        break;
                }
                startActivity(i);

            }
        }
    }
}