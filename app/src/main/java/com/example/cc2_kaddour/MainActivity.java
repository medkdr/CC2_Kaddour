package com.example.cc2_kaddour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Text e1, e2, e3;
        Button b1 ,b2;
        MyDatabase db;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            db = new MyDatabase(this);
            e1 = findViewById(R.id.rais);
            e2 = findViewById(R.id.adress);
            e3 = findViewById(R.id.Capitale);
            b1 = findViewById(R.id.btnsauvgarder);
            b1 = findViewById(R.id.btnannuler);


            ArrayList<Entreprise> ae = MyDatabase.getAllEntreprise(db.getReadableDatabase());


            ArrayList<String> listitems = new ArrayList<>();
            for(Entreprise e : ae)
                listitems.add(e.getRaison_Sociale());


        }

        }
    }
}