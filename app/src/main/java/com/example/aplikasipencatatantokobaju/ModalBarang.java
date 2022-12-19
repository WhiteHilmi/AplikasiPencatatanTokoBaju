package com.example.aplikasipencatatantokobaju;

public class ModalBarang {
    private String _id, _namabarang, _merk, _ukuran, _harga;

    public ModalBarang (String id, String namabarang, String merk, String ukuran, String harga){
        this._id = id;
        this._namabarang = namabarang;
        this._merk = merk;
        this._ukuran = ukuran;
        this._harga = harga;
    }
    public ModalBarang (){

    }

    //untuk mengirim nilai pada halaman ini
    public void set_id(String id){
        this._id = id;
    }
    //untuk mengambil nilai pada halaman ini
    public String get_id(){
        return this._id;
    }

    public void set_namabarang(String namabarang){
        this._namabarang = namabarang;
    }
    public String get_namabarang(){
        return this._namabarang;
    }

    public void set_merk(String merk){
        this._merk = merk;
    }
    public String get_merk(){
        return this._merk;
    }

    public void set_ukuran(String ukuran){
        this._ukuran = ukuran;
    }
    public String get_ukuran(){
        return this._ukuran;
    }

    public void set_harga(String harga){
        this._harga = harga;
    }
    public String get_harga(){
        return this._harga;
    }
}
