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
            }
        });
        //设置标题颜色
        popupWindow.setTitleColoe("#333333");
        //标题字体大小
        popupWindow.setTitleSiz(16);
        //内容字体大小
        popupWindow.setContentSize(16);
        //内容字体颜色
        popupWindow.setContentColor("#666666");
        //内容字体大小
        popupWindow.setContentSize(14);
        //确认按钮字体大小
        popupWindow.setConfirmSize(14);
        //确认按钮字体颜色
        popupWindow.setConfirmBtnTextColor("#444444");
        //确认按钮背景颜色
        popupWindow.setConfirmBgColoe("#dddddd");
        //确认按钮圆角
        popupWindow.setConfirmBtnRadius(10);
        /**
         * 取消按钮设置方法与确认按钮一样
         * 此处不在演示
         */
        //必须调用start方法 否则无法展示
        popupWindow.start();
        View inflate = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        popupWindow.showAtLocation(inflate, Gravity.CENTER,0,0);
    }
}