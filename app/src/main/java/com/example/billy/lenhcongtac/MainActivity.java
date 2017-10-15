package com.example.billy.lenhcongtac;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import Model.Command_Collapse;
import Model.NhanVien;
//netstat -aon|findstr 5037
public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {
    int mYear,mMonth,mDay,fyear,fmonth,fday, hour,minute,fhour,fminute;

    TextView txttungay,txtdenngay,txtracong,txtch,txtgs,txtct,txtdttruong,txtdtlaixe,txtnd,txtdv,txtdk;
    AutoCompleteTextView txtchihuy, txtgiamsat ;
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

        edtdonvi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) edtdonvi.getLayoutParams();
                if(edtdonvi.hasFocus())
                {
                    txtdv.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtdv.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                edtdonvi.setLayoutParams(mlp);
            }
        });
        edtdieukien.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) edtdieukien.getLayoutParams();
                if(edtdieukien.hasFocus())
                {
                    txtdk.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtdk.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                edtdieukien.setLayoutParams(mlp);
            }
        });

        edtnoidung.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) edtnoidung.getLayoutParams();
                if(edtnoidung.hasFocus())
                {
                    txtnd.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtnd.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                edtnoidung.setLayoutParams(mlp);
            }
        });

        edtdtlaixe.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) edtdtlaixe.getLayoutParams();
                if(edtdtlaixe.hasFocus())
                {
                    txtdtlaixe.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtdtlaixe.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                edtdtlaixe.setLayoutParams(mlp);
            }
        });
        txtchihuy.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) txtchihuy.getLayoutParams();
                if(txtchihuy.hasFocus())
                {
                    txtch.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtch.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                txtchihuy.setLayoutParams(mlp);
            }
        });

        txtgiamsat.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) txtgiamsat.getLayoutParams();
                if(txtgiamsat.hasFocus())
                {
                    txtgs.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtgs.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                txtgiamsat.setLayoutParams(mlp);
            }
        });
        edtnoicongtac.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) edtnoicongtac.getLayoutParams();
                if(edtnoicongtac.hasFocus())
                {
                    txtct.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtct.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                edtnoicongtac.setLayoutParams(mlp);
            }
        });

        edtdtTruong.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams) edtdtTruong.getLayoutParams();
                if(edtdtTruong.hasFocus())
                {
                    txtdttruong.setVisibility(View.VISIBLE);

                    mlp.setMargins(0,-20,0,0);
                }
                else {
                    txtdttruong.setVisibility(View.GONE);


                    mlp.setMargins(0, 0, 0, 0);
                }
                edtdtTruong.setLayoutParams(mlp);
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

        txtgiamsat.setAdapter(adapter);
    }
    Intent intent;
    private void Addcontrol() {
        txtch=findViewById(R.id.txtch);
        txtgs=findViewById(R.id.txtgs);
        txtct=findViewById(R.id.txtct);
        txtdttruong=findViewById(R.id.txtdttruong);
        txtdtlaixe=findViewById(R.id.txtdtlaixe);
        txtdk=findViewById(R.id.txtdk);
        txtnd=findViewById(R.id.txtnd);
        txtdv=findViewById(R.id.txtdv);

        myDatabase = new MyDatabaseAdapter(this);
        myDatabase.Khoitai();
        database = myDatabase.getMyDatabase();
        listMember = new ArrayList<>();
        nhanViens=new ArrayList<>();

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

        intent=getIntent();


        Cursor cursor = database.rawQuery("select  id from NhanVien", null);
        cursor.moveToLast();
        idNhanvien = Integer.parseInt(cursor.getString(0));
        idNhanvien++;
        Cursor cursor2 = database.rawQuery("select  id from CongTac", null);
        cursor2.moveToLast();
        idCongtac = Integer.parseInt(cursor2.getString(0));

    }
    Command_Collapse command;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.done_menu, menu);
        try{
        command= (Command_Collapse) intent.getSerializableExtra("editCommand");

            Cursor cursor = database.rawQuery("select  ten from NhanVien where id=?", new String[]{command.getDirect().toString()});
         cursor.moveToFirst();
            Cursor cursor2 = database.rawQuery("select  ten from NhanVien where id=?", new String[]{command.getGiamsat().toString()});
            cursor2.moveToFirst();
            txtchihuy.setText(cursor.getString(0));
            txtgiamsat.setText(cursor2.getString(0));
            edtnoicongtac.setText(command.getLocate().toString());
           edtnoidung.setText(command.getContext().toString());
           edtdonvi.setText(command.getDvyeucauucau().toString());
           edtdieukien.setText(command.getDkantoan().toString());
           edtphuongtien.setText(command.getPhuongtien().toString());
           txttungay.setText(command.getTungay().toString());
           txtdenngay.setText(command.getDenngay().toString());
           edtdungcu.setText(command.getTbthinghiem().toString());
           edtdtlaixe.setText(command.getSdtlaixe().toString());
          txtracong.setText(command.getGioracong().toString());
          edtthihanh.setText(command.getThihanhlenh().toString());
          edtdtTruong.setText(command.getSdt().toString());
    MenuItem itupdatecommand = menu.findItem(R.id.itupdatecommand);
    itupdatecommand.setVisible(true);
    MenuItem itdonecommand = menu.findItem(R.id.btnDone);
    itdonecommand.setVisible(false);
}catch (Exception e){}
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
            values.put("IDGiamSat", Integer.parseInt(cursor1.getString(0)));
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





            finish();
        }
        else if(item.getItemId() == R.id.itupdatecommand)
        {
            ContentValues values=new ContentValues();
            Cursor cursor = database.rawQuery("select  id from NhanVien where ten=?", new String[]{txtchihuy.getText().toString()});
            cursor.moveToFirst();
            values.put("IDChiHuy", Integer.parseInt(cursor.getString(0)));

            Cursor cursor1 = database.rawQuery("select  id from NhanVien where ten=?", new String[]{txtgiamsat.getText().toString()});
            cursor1.moveToFirst();
            values.put("IDGiamSat", Integer.parseInt(cursor1.getString(0)));
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
            database.updateWithOnConflict("Congtac",values,"id=?",new String[]{command.getId().toString()},SQLiteDatabase.CONFLICT_FAIL);


            finish();
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