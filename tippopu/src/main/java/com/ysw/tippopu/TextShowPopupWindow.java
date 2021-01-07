package com.ysw.tippopu;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class TextShowPopupWindow extends PopupWindow {

    private View mView; // PopupWindow 菜单布局
    private Context mContext; // 上下文参数
    private String mTitle;
    private String mContent;
    private String btnStr;
    private boolean mCancelBtn;
    private View.OnClickListener mListener;

    /**
     *
     * @param context 上下文
     * @param title 标题
     * @param content 内容
     * @param btnStr 右边按钮文字
     * @param cancelBtn 是否展示取消按钮
     * @param clickListener 右边按钮点击事件
     */
    public TextShowPopupWindow(Activity context, String title, String content, String btnStr, boolean cancelBtn, View.OnClickListener clickListener) {
        super(context);
        this.mContext = context;
        this.mTitle = title;
        this.mContent = content;
        this.btnStr = btnStr;
        this.mListener = clickListener;
        this.mCancelBtn = cancelBtn;
        Init();
    }

    /**
     * 设置布局以及点击事件
     */
    private void Init() {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.text_show_popu, null);

        TextView popu_title_tv = mView.findViewById(R.id.popu_title_tv);
        TextView popu_content_tv = mView.findViewById(R.id.popu_content_tv);

        Button btn_cancel = (Button) mView.findViewById(R.id.popu_btn_cancle);
        Button btn_select = (Button) mView.findViewById(R.id.popu_btn_sub);
        if (mCancelBtn){
            btn_cancel.setVisibility(View.VISIBLE);
        }else{
            btn_cancel.setVisibility(View.GONE);
        }
        btn_select.setText(btnStr);
        popu_content_tv.setText(mContent);
        popu_title_tv.setText(mTitle);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btn_select.setOnClickListener(mListener);
        // 导入布局
        this.setContentView(mView);
        // 设置动画效果
        this.setAnimationStyle(R.style.popwindow_anim_style);
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        this.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        // 设置可触
//        this.setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x0000000);
        this.setBackgroundDrawable(dw);
        this.setClippingEnabled(false);
        // 单击弹出窗以外处 关闭弹出窗
//        mView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int height = mView.findViewById(R.id.ll_pop).getTop();
//                int y = (int) event.getY();
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    if (y < height) {
//                        dismiss();
//                    }
//                }
//                return true;
//            }
//        });
    }
}
