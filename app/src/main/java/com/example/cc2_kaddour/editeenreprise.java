package com.example.cc2_kaddour;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class editeenreprise extends Activity {
    Spinner sp;
    EditText rais, adre, cap;
    MyDatabase db;
    ArrayList<Entreprise> ent;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editentreprise);

        db = new MyDatabase(this);
        sp= findViewById(R.id.sp);
        rais = findViewById(R.id.rais);
        adre = findViewById(R.id.adress);
        cap = findViewById(R.id.Capitale);

        ent = MyDatabase.getAllEntreprise(db.getReadableDatabase());

        ArrayList<String> entreprise = new ArrayList<>();
        for(Entreprise pp: ent)
            entreprise.add(pp.getId());

        ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,entreprise);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Entreprise E = ent.get(i);
                rais.setText(E.getRaison_Sociale());
                adre.setText(E.getAdresse());
                cap.setText(String.format("%f",E.getCapitale()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void modifier(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(editeenreprise.this);
        alert.setTitle("Modifier entreprise");
        alert.setMessage("Voulez-vous modifier ce entreprise ?");

        alert.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Entreprise E = ent.get(sp.getSelectedItemPosition());

                E.setRaison_Sociale(rais.getText().toString());
                E.setAdresse(adre.getText().toString());
                E.setCapitale(Double.valueOf(cap.getText().toString()));

                if(MyDatabase.UpdateEntreprise(db.getWritableDatabase(),E)==-1)
                    Toast.makeText(editeenreprise.this, "Modification echoue", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(editeenreprise.this, "Modification reussie", Toast.LENGTH_SHORT).show();

            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(editeenreprise.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }

    public void supprimer(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(editeenreprise.this);
        alert.setTitle("Suppression Entreprise");
        alert.setMessage("Voulez-vous supprimer ce Entreprise ?");

        alert.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Entreprise E = ent.get(sp.getSelectedItemPosition());

                if(MyDatabase.DeleteEntreprise(db.getWritableDatabase(),E.getId())==-1)
                    Toast.makeText(editeenreprise.this, "suppression echoue", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(editeenreprise.this, "Suppression reussie", Toast.LENGTH_SHORT).show();
                    ad.remove(E.getId());
                }
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(editeenreprise.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}
