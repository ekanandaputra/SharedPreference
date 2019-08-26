package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.sharedpreference.MainActivity.Alamat;
import static com.example.sharedpreference.MainActivity.Handphone;
import static com.example.sharedpreference.MainActivity.Nama;
import static com.example.sharedpreference.MainActivity.mypreference;

public class TampilActivity extends AppCompatActivity {

    TextView nama, alamat, handphone;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        nama = (TextView) findViewById(R.id.tvNama);
        alamat = (TextView) findViewById(R.id.tvAlamat);
        handphone = (TextView) findViewById(R.id.tvHandphone);
        Ambil();
    }

    public void Ambil() {
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Nama))
            nama.setText(sharedpreferences.getString(Nama, ""));
        if (sharedpreferences.contains(Alamat))
            alamat.setText(sharedpreferences.getString(Alamat, ""));
        if (sharedpreferences.contains(Handphone))
            handphone.setText(sharedpreferences.getString(Handphone, ""));
        Toast.makeText(getApplicationContext(), "Data Berhasil Ditampilkan", Toast.LENGTH_SHORT).show();
    }
}
