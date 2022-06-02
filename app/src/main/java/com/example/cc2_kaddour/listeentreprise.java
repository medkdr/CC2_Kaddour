package com.example.cc2_kaddour;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listeentreprise extends Activity {
    MyDatabase db;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listeentreprise);

        db = new MyDatabase(this);
        lst = findViewById(R.id.lst);

        ArrayList<Entreprise> prds = MyDatabase.getAllEntreprise(db.getReadableDatabase());

        ArrayList<String> entreprise = new ArrayList<>();
        for(Entreprise e: prds){
            entreprise.add(e.getId());
            entreprise.add(e.getRaison_Sociale());
            entreprise.add(e.getCapitale());
        }


        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,entreprise);

        lst.setAdapter(ad);
    }
}
