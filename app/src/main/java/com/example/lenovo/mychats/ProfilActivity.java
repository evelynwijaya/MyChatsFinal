package com.example.lenovo.mychats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {

    TextView tv_namaprofile, tv_emailprofile,tv_nohlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        tv_namaprofile = (TextView) findViewById(R.id.tv_namaprofil);
        tv_emailprofile = (TextView) findViewById(R.id.tv_emailprofile);
        tv_nohlp = (TextView)findViewById(R.id.tv_notlp);


    }
}
