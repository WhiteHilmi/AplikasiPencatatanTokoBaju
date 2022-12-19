package com.example.aplikasipencatatantokobaju;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpDel extends AppCompatActivity {
    private DatabaseManager db;
    private EditText Enamabarang, Emerk, Eukuran, Eharga;
    private String Sid, Snamabarang, Smerk, Sukuran, Sharga;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedelete);

        db = new DatabaseManager(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snamabarang = i.getStringExtra("Inama");
        Smerk = i.getStringExtra("Imerk");
        Sukuran = i.getStringExtra("Iukuran");
        Sharga = i.getStringExtra("Iharga");

        Enamabarang = (EditText) findViewById(R.id.updel_nama);
        Emerk = (EditText) findViewById(R.id.updel_merk);
        Eukuran = (EditText) findViewById(R.id.updel_ukuran);
        Eharga = (EditText) findViewById(R.id.updel_harga);

        Enamabarang.setText(Snamabarang);
        Emerk.setText(Smerk);

        Button btnUpdate = (Button) findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snamabarang = String.valueOf(Enamabarang.getText());
                Smerk = String.valueOf(Emerk.getText());
                Sukuran = String.valueOf(Eukuran.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snamabarang.equals("")){
                    Enamabarang.requestFocus();
                    Toast.makeText(MainUpDel.this, "Masukkan Nama Barang", Toast.LENGTH_SHORT).show();
                }else if(Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainUpDel.this, "Masukkan Merk", Toast.LENGTH_SHORT).show();
                }else if(Sukuran.equals("")){
                    Eukuran.requestFocus();
                    Toast.makeText(MainUpDel.this, "Masukkan Ukuran", Toast.LENGTH_SHORT).show();
                }else if(Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpDel.this, "Masukkan Harga", Toast.LENGTH_SHORT).show();
                }else{
                    db.UpdateFashion (new ModalBarang(Sid, Snamabarang, Smerk, Sukuran, Sharga));
                    Toast.makeText(MainUpDel.this, "Data Telah Diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteFashion(new ModalBarang(Sid, Snamabarang, Smerk, Sukuran, Sharga));
                Toast.makeText(MainUpDel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

}