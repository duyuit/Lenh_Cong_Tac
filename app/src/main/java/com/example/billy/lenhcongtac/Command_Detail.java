package com.example.billy.lenhcongtac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Command_Detail extends AppCompatActivity {
    TextView giamsat,dvyeucau,dkantoan,tungay,denngay,tbthinghiem,phuongtien,sdtlaixe,gioracong,thihanhlenh;
    TextView direct,locate,context;
    TextView bac1,bac2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command__detail);
        Addcontrol();
    }

    private void Addcontrol() {
        giamsat=findViewById(R.id.giamsat);
        dvyeucau=findViewById(R.id.donviyeucau);
        dkantoan=findViewById(R.id.dieukienantoan);
        tungay=findViewById(R.id.tungay);
        denngay=findViewById(R.id.denngay);
        tbthinghiem=findViewById(R.id.dungcu);
        phuongtien=findViewById(R.id.phuongtien);
        sdtlaixe=findViewById(R.id.sdtlaixe);
        gioracong=findViewById(R.id.gioracong);
        thihanhlenh=findViewById(R.id.thihanhlenh);
        direct=findViewById(R.id.chihuy);
        locate=findViewById(R.id.noicongtac);
        context=findViewById(R.id.noidungcongtac);
        bac1=findViewById(R.id.bacchihuy);
        bac2=findViewById(R.id.bacgiamsat);



    }
}
