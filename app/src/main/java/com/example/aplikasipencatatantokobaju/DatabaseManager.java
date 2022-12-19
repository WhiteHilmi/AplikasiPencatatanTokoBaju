package com.example.aplikasipencatatantokobaju;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_barang";

    private static final String tb_fashion = "tb_fashion";

    private static final String tb_fashion_id = "id";
    private static final String tb_fashion_namabarang = "namabarang";
    private static final String tb_fashion_merk = "merk";
    private static final String tb_fashion_ukuran = "ukuran";
    private static final String tb_fashion_harga = "harga";

    private static final String CREATE_TABEL_FASHION = "CREATE TABLE " + tb_fashion + "("
        + tb_fashion_id + " INTEGER PRIMARY KEY ,"
        + tb_fashion_namabarang + " TEXT ,"
        + tb_fashion_merk + " TEXT ,"
        + tb_fashion_ukuran + " TEXT ,"
        + tb_fashion_harga + " TEXT " + ")";

    public DatabaseManager (Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABEL_FASHION);
    }

    //method jika ada perubahan pada DATABASE_VERSION
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreateBarang (ModalBarang mdNotif){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_fashion_id, mdNotif.get_id());
        values.put(tb_fashion_namabarang, mdNotif.get_namabarang());
        values.put(tb_fashion_merk, mdNotif.get_merk());
        values.put(tb_fashion_ukuran, mdNotif.get_ukuran());
        values.put(tb_fashion_harga, mdNotif.get_harga());
        db.insert(tb_fashion, null, values);
        db.close();
    }
//mengambil semua data yg ada pada database
    public List<ModalBarang> ReadFashion() {
        List<ModalBarang> judulModelList = new ArrayList<ModalBarang>();
        String selectQuery = "SELECT  * FROM " + tb_fashion;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModalBarang mdKontak = new ModalBarang();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_namabarang(cursor.getString(1));
                mdKontak.set_merk(cursor.getString(2));
                mdKontak.set_ukuran(cursor.getString(3));
                mdKontak.set_harga(cursor.getString(4));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    //untuk mengubah data/update
    public int UpdateFashion (ModalBarang mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_fashion_namabarang, mdNotif.get_namabarang());
        values.put(tb_fashion_merk, mdNotif.get_merk());
        values.put(tb_fashion_ukuran, mdNotif.get_ukuran());
        values.put(tb_fashion_harga, mdNotif.get_harga());

        return db.update(tb_fashion, values, tb_fashion_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    //untuk delete/hapus
    public void DeleteFashion (ModalBarang mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_fashion, tb_fashion_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
