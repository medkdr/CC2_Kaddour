package com.example.cc2_kaddour;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addentreprise extends Activity {
    EditText e1, e2, e3;
    Button b1,b2;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addentreprise);

        db = new MyDatabase(this);

        e1 = findViewById(R.id.rais);
        e2 = findViewById(R.id.adress);
        e3 = findViewById(R.id.Capitale);
    }

    public void ajouterEntreprise(View view) {

        if(e1.getText().toString().isEmpty()){
            Toast.makeText(this, "Raison Social vide", Toast.LENGTH_SHORT).show();
            e1.requestFocus();
            return;
        }
        if(e2.getText().toString().isEmpty()){
            Toast.makeText(this, "Adress vide", Toast.LENGTH_SHORT).show();
            e2.requestFocus();
            return;
        }
        if(e3.getText().toString().isEmpty()){
            Toast.makeText(this, "Capitale vide", Toast.LENGTH_SHORT).show();
            e3.requestFocus();
            return;
        }
        Entreprise E = new Entreprise();

        E.setRaison_Sociale(e1.getText().toString());
        E.setAdresse(e2.getText().toString());
        E.setCapitale(Double.parseDouble(e3.getText().toString()));

        if(MyDatabase.AddEntreprise(db.getWritableDatabase(),E)==-1)
            Toast.makeText(this, "Insertion echoue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insertion reussie", Toast.LENGTH_SHORT).show();


    }
}
