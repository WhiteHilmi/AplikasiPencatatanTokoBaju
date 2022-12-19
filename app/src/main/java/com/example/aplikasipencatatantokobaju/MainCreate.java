package com.example.aplikasipencatatantokobaju;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private DatabaseManager db;
    private EditText Enamabarang, Emerk, Eukuran, Eharga;
    private String Snamabarang, Smerk, Sukuran, Sharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = new DatabaseManager(this);

        Enamabarang = (EditText) findViewById(R.id.create_nama);
        Emerk = (EditText) findViewById(R.id.create_merk);
        Eukuran = (EditText) findViewById(R.id.create_ukuran);
        Eharga = (EditText) findViewById(R.id.create_harga);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snamabarang = String.valueOf(Enamabarang.getText());
                Smerk = String.valueOf(Emerk.getText());
                Sukuran = String.valueOf(Eukuran.getText());
                Sharga = String.valueOf(Eharga.getText());

                if (Snamabarang.equals("")){
                    Enamabarang.requestFocus();
                    Toast.makeText(MainCreate.this, "Masukkan nama barang", Toast.LENGTH_SHORT).show();
                } else if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainCreate.this, "Masukkan merk", Toast.LENGTH_SHORT).show();
                } else if (Sukuran.equals("")){
                    Eukuran.requestFocus();
                    Toast.makeText(MainCreate.this, "Masukkan ukuran", Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Masukkan harga", Toast.LENGTH_SHORT).show();
                } else{
                    Enamabarang.setText("");
                    Emerk.setText("");
                    Eukuran.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data Ditambahkan", Toast.LENGTH_SHORT).show();
                    db.CreateBarang(new ModalBarang(null, Snamabarang, Smerk, Sukuran, Sharga));

                }
            }
        });
    }
}