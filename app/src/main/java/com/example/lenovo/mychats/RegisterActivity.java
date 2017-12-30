package com.example.lenovo.mychats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    User user;
    EditText et_nama, et_nohpregis, et_email;
    Button bt_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_nama = (EditText)findViewById(R.id.et_nama);
        et_nohpregis = (EditText) findViewById(R.id.et_nohpregis);
        et_email = (EditText) findViewById(R.id.et_email);

        bt_regis= (Button) findViewById(R.id.bt_regis);
        bt_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = new User();
                user.setNama(et_nama.getText().toString());
                user.setEmail(et_email.getText().toString());
                user.setTelp(et_nohpregis.getText().toString());
                user.register();
                Toast.makeText(getApplicationContext(),"Sukses",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
