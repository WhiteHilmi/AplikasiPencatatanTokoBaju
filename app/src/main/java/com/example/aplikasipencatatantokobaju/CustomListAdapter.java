package com.example.aplikasipencatatantokobaju;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ModalBarang> movieItems;
//constructor
    public CustomListAdapter(Activity activity, List<ModalBarang> movieItems){
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() { return movieItems.size(); }

    @Override
    public Object getItem(int location) { return movieItems.get(location); }

    @Override
    public long getItemId(int position) {return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.costum_list, null);

        TextView namabarang = (TextView) convertView.findViewById(R.id.text_namabarang);
        TextView merk = (TextView) convertView.findViewById(R.id.text_merk);
        TextView ukuran = (TextView) convertView.findViewById(R.id.text_ukuran);
        TextView harga = (TextView) convertView.findViewById(R.id.text_harga);
        
        // ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        
        ModalBarang m = movieItems.get(position);

        namabarang.setText("Nama : "+ m.get_namabarang());
        merk.setText("Merk : "+ m.get_merk());
        ukuran.setText("Ukuran : "+m.get_ukuran());
        harga.setText("Harga : "+m.get_harga());
        
        return convertView;
    }
}
