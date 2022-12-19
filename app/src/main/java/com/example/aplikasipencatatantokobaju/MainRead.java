package com.example.aplikasipencatatantokobaju;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DatabaseManager db;
    private List<ModalBarang> ListFashion = new ArrayList<ModalBarang>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        db = new DatabaseManager(this);

        adapter_off = new CustomListAdapter(this, ListFashion );
        mListView = (ListView) findViewById(R.id.list_barang);

        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListFashion.clear();

        List<ModalBarang> contacts = db.ReadFashion();
        for (ModalBarang cn : contacts) {
            ModalBarang judulModel = new ModalBarang();
            judulModel.set_id(cn.get_id());
            judulModel.set_namabarang(cn.get_namabarang());
            judulModel.set_merk(cn.get_merk());
            judulModel.set_ukuran(cn.get_ukuran());
            judulModel.set_harga(cn.get_harga());
            ListFashion.add(judulModel);

            if ((ListFashion.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
            }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        ModalBarang obj_itemDetails = (ModalBarang) o;

        String Sid = obj_itemDetails.get_id();
        String Snamabarang = obj_itemDetails.get_namabarang();
        String Smerk = obj_itemDetails.get_merk();
        String Sukuran = obj_itemDetails.get_ukuran();
        String Sharga = obj_itemDetails.get_harga();

        Intent goUpdel = new Intent(MainRead.this, MainUpDel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snamabarang);
        goUpdel.putExtra("Imerk", Smerk);
        goUpdel.putExtra("Iukuran", Sukuran);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }

    //agar data langsung terupdate/terhapus
    @Override
    protected void onResume() {
        super.onResume();
        ListFashion.clear();
        mListView.setAdapter(adapter_off);

        List<ModalBarang> contacts = db.ReadFashion();
        for (ModalBarang cn : contacts) {
            ModalBarang judulModel = new ModalBarang();
            judulModel.set_id(cn.get_id());
            judulModel.set_namabarang(cn.get_namabarang());
            judulModel.set_merk(cn.get_merk());
            judulModel.set_ukuran(cn.get_ukuran());
            judulModel.set_harga(cn.get_harga());
            ListFashion.add(judulModel);

            if ((ListFashion.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
