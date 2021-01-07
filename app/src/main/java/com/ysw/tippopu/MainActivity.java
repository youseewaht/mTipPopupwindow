package com.ysw.tippopu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        TextShowPopupWindow popupWindow = new TextShowPopupWindow(getApplicationContext(), "温馨提示", "您好，账户余额不足请及时充值", "去充值", false, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //确认按钮点击事件
                //业务处理
            }
        });
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_main,null);
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
    }
}