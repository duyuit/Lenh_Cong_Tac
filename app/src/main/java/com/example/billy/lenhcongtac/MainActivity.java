package com.example.billy.lenhcongtac;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Adapter.MyDatabaseAdapter;
import Adapter.NhanVienAdapter;
import Model.NhanVien;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {
    int mYear,mMonth,mDay,fyear,fmonth,fday, hour,minute,fhour,fminute;
    LinearLayout lnAdd;
    ImageView imgAdd;
    TextView txttungay,txtdenngay,txtracong;
    AutoCompleteTextView txtchihuy, txtgiamsat ,txtaddmember;
    MyDatabaseAdapter myDatabase;
    SQLiteDatabase database;
    List<String> listMember;
    EditText edtnoicongtac, edtdtTruong, edtdtlaixe, edtnoidung, edtdonvi, edtdieukien, edtdungcu, edtphuongtien, edtthihanh;
    int idCongtac = 0, idNhanvien = 0;
List<NhanVien> nhanViens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Addcontrol();
        AddEvent();
    }

    private void AddEvent() {
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final View item = LayoutInflater.from(MainActivity.this).inflate(R.layout.add_member, null);
                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                item.setLayoutParams(param);
                final String Member = txtaddmember.getText().toString();
                listMember.add(Member);
                ImageView img = item.findViewById(R.id.imgCancel);
                TextView txtNameMember = item.findViewById(R.id.txtNameMember);
                txtNameMember.setText(txtaddmember.getText() + "");
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lnAdd.removeView(item);
                        listMember.remove(Member);

                    }
                });
                lnAdd.addView(item);

                txtaddmember.setText("");
            }
        });
txttungay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ik=1;
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,MainActivity.this,mYear,mMonth,mDay);

          datePickerDialog.show();

    }
});

        txtdenngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ik=2;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,MainActivity.this,mYear,mMonth,mDay);

                datePickerDialog.show();
            }
        });

        txtracong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ik=0;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,MainActivity.this,mYear,mMonth,mDay);

                datePickerDialog.show();
            }
        });
        Cursor cursor = database.rawQuery("select  * from NhanVien", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast())
        {
           nhanViens.add(new NhanVien(cursor.getString(1).toString(),cursor.getString(3).toString(),cursor.getString(4).toString()));
           cursor.moveToNext();
        }

        NhanVienAdapter adapter=new NhanVienAdapter(this,R.layout.item_thanhvien,nhanViens);
        txtchihuy.setAdapter(adapter);
       txtaddmember.setAdapter(adapter);
        txtgiamsat.setAdapter(adapter);



    }

    private void Addcontrol() {
        myDatabase = new MyDatabaseAdapter(this);
        myDatabase.Khoitai();
        database = myDatabase.getMyDatabase();
        listMember = new ArrayList<>();
        nhanViens=new ArrayList<>();
        lnAdd = findViewById(R.id.lnAdd);
        imgAdd = findViewById(R.id.imgAdd);
        txtaddmember = findViewById(R.id.txtaddmember);
        txtchihuy = findViewById(R.id.txtchihuy);
        txtgiamsat = findViewById(R.id.txtgiamsat);
        edtnoicongtac = findViewById(R.id.edtnoicongtac);
        edtdtTruong = findViewById(R.id.edtdtTruong);
        edtdtlaixe = findViewById(R.id.edtdtlaixe);
        edtnoidung = findViewById(R.id.edtnoidung);
        edtdonvi = findViewById(R.id.edtdonvi);
        edtdieukien = findViewById(R.id.edtdieukien);
        edtdungcu = findViewById(R.id.edtdungcu);
        edtphuongtien = findViewById(R.id.edtphuongtien);
        edtthihanh = findViewById(R.id.edtthihanh);
        txttungay=findViewById(R.id.txttungay);
        txtdenngay=findViewById(R.id.txtdenngay);
        txtracong=findViewById(R.id.txtracong);
        Cursor cursor = database.rawQuery("select  id from NhanVien", null);
        cursor.moveToLast();
        idNhanvien = Integer.parseInt(cursor.getString(0));
        idNhanvien++;
        Cursor cursor2 = database.rawQuery("select  id from CongTac", null);
        cursor2.moveToLast();
        idCongtac = Integer.parseInt(cursor2.getString(0));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.done_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btnDone) {
            ContentValues values=new ContentValues();

            //Insert Congtac

                idCongtac++;
                values.put("id", idCongtac);
                Cursor cursor = database.rawQuery("select  id from NhanVien where ten=?", new String[]{txtchihuy.getText().toString()});
                cursor.moveToFirst();
                values.put("IDChiHuy", Integer.parseInt(cursor.getString(0)));

                Cursor cursor1 = database.rawQuery("select  id from NhanVien where ten=?", new String[]{txtgiamsat.getText().toString()});
                cursor1.moveToFirst();
                values.put("IDGiamSat", Integer.parseInt(cursor.getString(0)));
                values.put("NoiCongTac", edtnoicongtac.getText().toString());
                values.put("NoiDungCT", edtnoidung.getText().toString());
                values.put("DVYeuCau", edtdonvi.getText().toString());
                values.put("DKANToan", edtdieukien.getText().toString());
                values.put("TuNgay", txttungay.getText().toString());
                values.put("DenNgay", txtdenngay.getText().toString());
                values.put("TBThiNghiem", edtdungcu.getText().toString());
                values.put("PhuongTien", edtphuongtien.getText().toString());
                values.put("SDTLaiXe", edtdtlaixe.getText().toString());
                values.put("GioRaCong", txtracong.getText().toString());
                values.put("ThiHanhLenh", edtthihanh.getText().toString());
                values.put("SDTTruongNhom", edtdtTruong.getText().toString());

                database.insertWithOnConflict("Congtac", null, values, SQLiteDatabase.CONFLICT_FAIL);
for(String a:listMember) {
    values = new ContentValues();
    Cursor cursor2 = database.rawQuery("select  id from NhanVien where Ten=?", new String[]{a});
    cursor.moveToFirst();
   values.put("idThanhVien",Integer.parseInt(cursor.getString(0)));
   values.put("idCongTac",idCongtac);
    database.insertWithOnConflict("NhomCongTac", null, values, SQLiteDatabase.CONFLICT_FAIL);
}
        }
        return super.onOptionsItemSelected(item);
    }


    int ik=0;
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        fyear = i;
        fmonth = i1 + 1;
        fday = i2;
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        if(ik==1){
        txttungay.setText(fyear + "-" + fmonth + "-" + fday);
        }else if(ik==2)
        {
            txtdenngay.setText(fyear + "-" + fmonth + "-" + fday);
        }
        else {
            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, MainActivity.this, hour, minute, android.text.format.DateFormat.is24HourFormat(this));
            timePickerDialog.show();
        }
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        fhour = i;
        fminute = i1;
        txtracong.setText(fyear + "-" + fmonth + "-" + fday + " " + fhour + ":" + fminute);
    }
}