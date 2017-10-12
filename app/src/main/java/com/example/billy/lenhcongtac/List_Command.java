package com.example.billy.lenhcongtac;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import Adapter.Command_Collapse_Adapter;
import Adapter.MyDatabaseAdapter;
import Model.Command_Collapse;

public class List_Command extends AppCompatActivity {
    ListView listView;
    Command_Collapse_Adapter adapter;
    ArrayList<Command_Collapse> arrayList;

    MyDatabaseAdapter myDatabase;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__command);
        AddControl();
    }

    private void AddControl() {
        arrayList=new ArrayList<>();
        listView=findViewById(R.id.list_command);
        adapter=new Command_Collapse_Adapter(this,R.layout.item_command,arrayList);
        listView.setAdapter(adapter);

        myDatabase = new MyDatabaseAdapter(this);

        myDatabase.Khoitai();
        database = myDatabase.getMyDatabase();

        Cursor cursor=database.rawQuery("select * from congtac",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            String id=cursor.getString(0);
            String context=cursor.getString(4);
            String direct=cursor.getString(1);
            String locate=cursor.getString(3);
            String giamsat,dvyeucau,dkantoan,tungay,denngay,tbthinghiem,phuongtien,sdtlaixe,gioracong,thihanhlenh;
            giamsat=cursor.getString(2);
            dvyeucau=cursor.getString(5);
            dkantoan=cursor.getString(6);
            tungay=cursor.getString(7);
            denngay=cursor.getString(8);
            tbthinghiem=cursor.getString(9);
            phuongtien=cursor.getString(10);
            sdtlaixe=cursor.getString(11);
            gioracong=cursor.getString(12);
            thihanhlenh=cursor.getString(13);
            Command_Collapse command_collapse=new Command_Collapse(id,direct,locate,context,giamsat,dvyeucau,dkantoan,tungay,denngay,tbthinghiem,phuongtien,sdtlaixe,gioracong,thihanhlenh);
            arrayList.add(command_collapse);
            adapter.notifyDataSetChanged();
            cursor.moveToNext();
        }
    }
}
