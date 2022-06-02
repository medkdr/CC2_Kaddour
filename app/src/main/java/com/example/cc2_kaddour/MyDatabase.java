package com.example.cc2_kaddour;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper{
    public static String DB_NAME="enterprises.db";
    public static String TABLE_NAME="Entreprise";
    public static String COL1="ID";
    public static String COL2="Raison_Sociale";
    public static String COL3="Adresse";
    public static String COL4="Capitale";

    public MyDatabase(listeentreprise listeentreprise) {
        super();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TABLE_NAME + "("+COL1+" integer primary key autoincrement,"+COL2+" TEXT,"+COL3+" TEXT,"+COL4+" double)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql= "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public static long AddEntreprise(SQLiteDatabase db, Entreprise e){
        ContentValues cv = new ContentValues();
        cv.put(COL2,e.getRaison_Sociale());
        cv.put(COL3,e.getAdresse());
        cv.put(COL4,e.getCapitale());
        return db.insert(TABLE_NAME,null,cv);
    }

    public static long UpdateEntreprise(SQLiteDatabase db, Entreprise e){
        ContentValues cv = new ContentValues();
        cv.put(COL2,e.getRaison_Sociale());
        cv.put(COL3,e.getAdresse());
        cv.put(COL4,e.getCapitale());
        return db.update(TABLE_NAME,cv,"ID="+e.getId(),null);
    }

    public static long DeleteEntreprise(SQLiteDatabase db, int ID){
        return db.delete(TABLE_NAME,"ID="+ID,null);
    }

    public static ArrayList<Entreprise> getAllEntreprise(SQLiteDatabase db){
        ArrayList<Entreprise> Ent = new ArrayList<>();

        Cursor cur = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);

        while(cur.moveToNext()){
            Entreprise E = new Entreprise();
            E.setId(cur.getInt(0));
            E.setRaison_Sociale(cur.getString(1));
            E.setAdresse(cur.getString(2));
            E.setCapitale(cur.getDouble(3));
            Ent.add(E);
        }

        return Ent;
    }

    public static Entreprise getOneEntreprise(SQLiteDatabase db, int id){
        Entreprise E = null;

        Cursor cur = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id,null);

        if(cur.moveToNext()){
            E = new Entreprise();
            E.setId(cur.getInt(0));
            E.setRaison_Sociale(cur.getString(1));
            E.setAdresse(cur.getString(2));
            E.setCapitale(cur.getDouble(3));
        }

        return E;
    }
}
