package com.ysw.tippopu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextShowPopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
            }
        });
    }

    private void initData() {
        popupWindow = new TextShowPopupWindow(this, "温馨提示", "您好，账户余额不足请及时充值", "去充值", true,false,new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //确认按钮点击事件
                //业务处理
                popupWindow.dismiss();
            }
        });
        popupWindow.start();
        View inflate = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        popupWindow.showAtLocation(inflate, Gravity.CENTER,0,0);
    }
}