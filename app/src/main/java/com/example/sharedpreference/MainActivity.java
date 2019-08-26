package com.example.sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static final String mypreference = "mypref";
    public static final String Nama = "nama";
    public static final String Alamat = "alamat";
    public static final String Handphone = "hp";
    SharedPreferences sharedpreferences;
    EditText et_nama, et_alamat, et_hp;
    Button bt_simpan, bt_tampil, bt_pindah, bt_hapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nama = (EditText) findViewById(R.id.etName);
        et_alamat = (EditText) findViewById(R.id.etAlamat);
        et_hp = (EditText) findViewById(R.id.etHp);
        bt_simpan = (Button) findViewById(R.id.btnStore);
        bt_tampil = (Button) findViewById(R.id.btnFetch);
        bt_hapus = (Button) findViewById(R.id.btnClear);
        bt_pindah = (Button) findViewById(R.id.btnPindah);

        //Menampilkan data jika ada pada Shared Preferences saat aplikasi dijalankan
        Ambil();

        bt_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Simpan();
            }
        });

        bt_tampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ambil();
            }
        });

        bt_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hapus();
            }
        });

        bt_pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tampil = new Intent(MainActivity.this, TampilActivity.class);
                startActivity(tampil);
            }
        });

    }


    public void Simpan() {
        String strNama = et_nama.getText().toString();
        String strAlamat = et_alamat.getText().toString();
        String strHp = et_hp.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Nama, strNama);
        editor.putString(Alamat, strAlamat);
        editor.putString(Handphone, strHp);
        editor.commit();
        Toast.makeText(getApplicationContext(), "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
    }

    public void Hapus() {
        et_nama.setText("");
        et_alamat.setText("");
        et_hp.setText("");
    }

    public void Ambil() {
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Nama))
            et_nama.setText(sharedpreferences.getString(Nama, ""));
        if (sharedpreferences.contains(Alamat))
            et_alamat.setText(sharedpreferences.getString(Alamat, ""));
        if (sharedpreferences.contains(Handphone))
            et_hp.setText(sharedpreferences.getString(Handphone, ""));
        Toast.makeText(getApplicationContext(), "Data Berhasil Ditampilkan", Toast.LENGTH_SHORT).show();
    }
}