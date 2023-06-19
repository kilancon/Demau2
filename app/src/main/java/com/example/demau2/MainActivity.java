package com.example.demau2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private Button btnThem, btnNut1, btnDslop, btnDsSv;
    private int state = 1; // 1->danh sach sv ; 2->danh sach lop
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lvSinhVien);
        btnThem = findViewById(R.id.btnThem);
        btnNut1 = findViewById(R.id.btnSo1);
        btnDslop = findViewById(R.id.btnDsLop);
        btnDsSv = findViewById(R.id.btnDsSv);
        TextView tv1 = findViewById(R.id.tv1);
        chien(1);

        Intent intentAddSv = new Intent(this, AddSvActivity.class);
        Intent intentAddLop = new Intent(this, AddLopActivity.class);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(state){
                    case 1: startActivityForResult(intentAddSv, 1); break;
                    case 2: startActivityForResult(intentAddLop, 2); break;
                }
            }
        });

        btnDsSv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = 1;
                tv1.setText("Danh sach sinh vien");
                chien(1);
            }
        });

        btnNut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = 1;
                tv1.setText("Danh sach sinh vien");
                DatabaseHelper db = new DatabaseHelper(MainActivity.this);
                ArrayList<SinhVien> ds = db.getDm("Nam", "nam 2");
                ArrayAdapter<SinhVien> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, ds);
                lv.setAdapter(adapter);
            }
        });

        btnDslop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = 2;
                tv1.setText("Danh sach lop");
                chien(state);
            }
        });
    }

    private void chien(int i){ // de hien danh sach listview
        DatabaseHelper db = new DatabaseHelper(this);
        switch (i){
            case 1:
                ArrayList<SinhVien> ds = db.getAllSv();
                ArrayAdapter<SinhVien> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ds);
                lv.setAdapter(adapter);
                break;
            case 2:
                ArrayList<Lop> ds2 = db.getAllLop();
                ArrayAdapter<Lop> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ds2);
                lv.setAdapter(adapter2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK){
            chien(1);
        }
        if(requestCode==2 && resultCode==RESULT_OK){
            chien(2);
        }
    }
}