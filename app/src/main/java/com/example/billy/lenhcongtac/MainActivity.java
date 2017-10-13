package com.example.billy.lenhcongtac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout lnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
Addcontrol();
    }

    private void Addcontrol() {

        lnAdd=findViewById(R.id.lnAdd);
        View item = LayoutInflater.from(this).inflate(R.layout.add_member, null);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        item.setLayoutParams(param);
        lnAdd.addView(item);
    }
}
