package com.example.billy.lenhcongtac;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.Command_Collapse_Adapter;
import Adapter.MyDatabaseAdapter;
import Adapter.NhanVienAdapter;
import Model.Command_Collapse;
import Model.NhanVien;

public class List_Command extends AppCompatActivity {
    ListView listView;
    Command_Collapse_Adapter adapter;
    ArrayList<Command_Collapse> arrayList;
    public  static Button btnxoa,btnxem,btnThem;
public  static Button btnsua;
LinearLayout ln;
public  static int countCheck=0;
    MyDatabaseAdapter myDatabase;
    SQLiteDatabase database;
    List<String> listMember;
    String id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__command);
        AddControl();
        Cursor cursor=database.rawQuery("select * from NhomCongTac",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
           Log.d("aaa",cursor.getString(1));
           cursor.moveToNext();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        countCheck=0;
        arrayList.clear();
        Cursor cursor=database.rawQuery("select * from congtac",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
String Sdt=cursor.getString(14);
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
            Command_Collapse command_collapse=new Command_Collapse(id,direct,locate,context,giamsat,dvyeucau,dkantoan,tungay,denngay,tbthinghiem,phuongtien,sdtlaixe,gioracong,thihanhlenh,Sdt);
            arrayList.add(command_collapse);
            adapter.notifyDataSetChanged();
            cursor.moveToNext();
        }

        cursor.moveToLast();
        Log.d("abc",cursor.getString(1)+" "+cursor.getString(2));
    }

    private void AddControl() {
        arrayList=new ArrayList<>();
        listView=findViewById(R.id.list_command);
        adapter=new Command_Collapse_Adapter(this,R.layout.item_command,arrayList);
        listView.setAdapter(adapter);
        btnxoa=findViewById(R.id.btnxoa);
        btnsua=findViewById(R.id.btnSua);
ln=findViewById(R.id.ln);
        btnxem=findViewById(R.id.btnxem);
        myDatabase = new MyDatabaseAdapter(this);
        btnThem=findViewById(R.id.btnthem);
        myDatabase.Khoitai();
        database = myDatabase.getMyDatabase();
        listMember=new ArrayList<>();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplication(),Command_Detail.class);
                intent.putExtra("command",arrayList.get(i));
                startActivity(intent);
            }
        });

       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int k, long l) {
               for(int i=0;i<arrayList.size();i++)
               {
                   arrayList.get(i).setCheck(1);
               }
               ln.setVisibility(View.VISIBLE);

               adapter.notifyDataSetChanged();
               return true;
           }
       });


       btnxem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               countCheck=0;
               for(int i=0;i<arrayList.size();i++)
               {
                   arrayList.get(i).setCheck(0);
               }
               ln.setVisibility(View.GONE);

               adapter.notifyDataSetChanged();
           }
       });


       btnxoa.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               for(int i=0;i<arrayList.size();i++)
               {
                   if(arrayList.get(i).isCheck()==2) {
                       database.delete("congtac","id=?",new String[]{arrayList.get(i).getId()});
                     database.delete("NhomCOngTac","IDcongtac=?",new String[]{arrayList.get(i).getId()});
                       arrayList.remove(i);
                       adapter.notifyDataSetChanged();
                       i--;

                   }
               }
           }
       });

btnsua.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent= new Intent(List_Command.this,MainActivity.class);

        for(int i=0;i<arrayList.size();i++)
        {
            if(arrayList.get(i).isCheck()==2) {
                intent.putExtra("editCommand",arrayList.get(i));
                startActivityForResult(intent,1);
                break;
            }

        }


    }
});

btnThem.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final Dialog dialog = new Dialog(List_Command.this); // Context, this, etc.
        dialog.setContentView(R.layout.add_dialog);
        dialog.setTitle("Thêm thành viên công tác ");
        final LinearLayout lnAdd=dialog.findViewById(R.id.lnAdd);
        ImageView imgAdd=dialog.findViewById(R.id.imgAdd);
      Button   btnadd=dialog.findViewById(R.id.btnadd);
        final AutoCompleteTextView txtaddmember=dialog.findViewById(R.id.txtaddmember);
        Cursor cursor = database.rawQuery("select  * from NhanVien", null);
        cursor.moveToFirst();
        List<NhanVien> nhanViens=new ArrayList<>();
        while (!cursor.isAfterLast())
        {
            nhanViens.add(new NhanVien(cursor.getString(1).toString(),cursor.getString(3).toString(),cursor.getString(4).toString()));
            cursor.moveToNext();
        }
        NhanVienAdapter adapter=new NhanVienAdapter(List_Command.this,R.layout.item_thanhvien,nhanViens);
        txtaddmember.setAdapter(adapter);

        for(int i=0;i<arrayList.size();i++)
        {
            if(arrayList.get(i).isCheck()==2) {
                id=arrayList.get(i).getId();
                break;
            }

        }


        cursor = database.rawQuery("select  * from NhomCongTac where IDCongTac=?", new String[]{id});
        cursor.moveToFirst();


        while (!cursor.isAfterLast())
        {
          Cursor  ten = database.rawQuery("select  Ten from NhanVien  where id=?", new String[]{cursor.getString(1)});
            ten.moveToFirst();

            listMember.add(ten.getString(0));
            final View item = LayoutInflater.from(List_Command.this).inflate(R.layout.add_member, null);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            item.setLayoutParams(param);
            TextView txtNameMember = item.findViewById(R.id.txtNameMember);
            txtNameMember.setText(ten.getString(0) + "");
            lnAdd.addView(item);
            cursor.moveToNext();
        }

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final View item = LayoutInflater.from(List_Command.this).inflate(R.layout.add_member, null);
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
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.delete("NhomCongTac","idCongtac=?",new String[]{id});
                for(String a:listMember) {
                    ContentValues   values = new ContentValues();
                    Cursor cursor2 = database.rawQuery("select  id from NhanVien where Ten=?", new String[]{a});
                    cursor2.moveToFirst();
                    values.put("idThanhVien",Integer.parseInt(cursor2.getString(0)));

                    values.put("idCongTac",id);
                    database.insertWithOnConflict("NhomCongTac", null, values, SQLiteDatabase.CONFLICT_FAIL);
                }
                dialog.dismiss();
            }
        });

        dialog.show();
    }
});

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.itaddcommand)
        {
            Intent intent=new Intent(List_Command.this,MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
