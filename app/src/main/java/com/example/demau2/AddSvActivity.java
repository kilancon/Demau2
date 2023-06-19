package com.example.demau2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSvActivity extends AppCompatActivity {
    private EditText eTen, eYob, eQue, eNamhoc;
    private Button btnThat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sv);
        eTen = findViewById(R.id.eTen);
        eYob = findViewById(R.id.eYob);
        eQue = findViewById(R.id.eQue);
        eNamhoc = findViewById(R.id.eNamhoc);
        btnThat = findViewById(R.id.btnThemThat);
        btnThat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien(-1, eTen.getText().toString(), eYob.getText().toString(), eQue.getText().toString(), eNamhoc.getText().toString());
                DatabaseHelper db = new DatabaseHelper(AddSvActivity.this);
                db.AddSv(sv);
                Toast.makeText(AddSvActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}