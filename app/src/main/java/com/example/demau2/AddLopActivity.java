package com.example.demau2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddLopActivity extends AppCompatActivity {
    private EditText eTen, eMota;
    private Button btnThemXin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lop);
        eTen = findViewById(R.id.eTenLop);
        eMota = findViewById(R.id.eMota);
        btnThemXin = findViewById(R.id.btnThemThat);
        btnThemXin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(AddLopActivity.this);
                db.AddLop(new Lop(-1, eTen.getText().toString(), eMota.getText().toString()));
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}