package com.example.billy.lenhcongtac;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import Adapter.MyDatabaseAdapter;
import Model.Command_Collapse;

public class Command_Detail extends AppCompatActivity {
    TextView sdttruongnhom,giamsat,dvyeucau,dkantoan,tungay,denngay,tbthinghiem,phuongtien,sdtlaixe,gioracong,thihanhlenh;
    TextView direct,locate,context;
    TextView bac1,bac2;
    MyDatabaseAdapter myDatabase;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command__detail);
        Addcontrol();
    }

    private void Addcontrol() {
        myDatabase = new MyDatabaseAdapter(this);
        myDatabase.Khoitai();
        database = myDatabase.getMyDatabase();

        dvyeucau=findViewById(R.id.donviyeucau);
        dkantoan=findViewById(R.id.dieukienantoan);
        tungay=findViewById(R.id.tungay);
        denngay=findViewById(R.id.denngay);
        tbthinghiem=findViewById(R.id.dungcu);
        phuongtien=findViewById(R.id.phuongtien);
        sdtlaixe=findViewById(R.id.sdtlaixe);
        gioracong=findViewById(R.id.gioracong);
        thihanhlenh=findViewById(R.id.thihanhlenh);

        locate=findViewById(R.id.noicongtac);
        context=findViewById(R.id.noidungcongtac);

        direct=findViewById(R.id.chihuy);
        giamsat=findViewById(R.id.giamsat);
        bac1=findViewById(R.id.bacchihuy);
        bac2=findViewById(R.id.bacgiamsat);
        sdttruongnhom=findViewById(R.id.sdttruongnhom);

        Command_Collapse command_collapse= (Command_Collapse) getIntent().getSerializableExtra("command");
        dvyeucau.setText("Đơn vị yêu cầu:"+command_collapse.getDvyeucauucau());
        dkantoan.setText("Điều khiện an toàn: "+command_collapse.getDkantoan());
        tungay.setText("Từ ngày: "+command_collapse.getTungay());
        denngay.setText("Đến ngày: "+command_collapse.getDenngay());
        tbthinghiem.setText("Dụng cụ và thiết bị: "+command_collapse.getTbthinghiem());
        phuongtien.setText("Phương tiện di chuyển: "+command_collapse.getPhuongtien());
        sdtlaixe.setText("SDT Lái xe: "+command_collapse.getSdtlaixe());
        gioracong.setText("Giờ ra cổng: "+command_collapse.getGioracong());
        thihanhlenh.setText("Thi hành lệnh: \n"+command_collapse.getThihanhlenh());
        locate.setText("Nơi công tác: "+command_collapse.getLocate());
        context.setText("Nội dung công tác: "+command_collapse.getContext());


//        Cursor cursor=database.rawQuery("select * from nhanvien where id="+command_collapse.getDirect(),null);
//        cursor.moveToFirst();
//        direct.setText("Chỉ huy: "+cursor.getString(1));
//        bac1.setText("Bậc: "+cursor.getString(3));
        sdttruongnhom.setText("SDT Trưởng nhóm: "+command_collapse.getSdt());


        Cursor  cursor=database.rawQuery("select * from nhanvien where id="+command_collapse.getGiamsat(),null);
        cursor.moveToFirst();
        giamsat.setText("Giám sát: "+cursor.getString(1));
        bac2.setText("Bậc : "+cursor.getString(3));

    }



}
