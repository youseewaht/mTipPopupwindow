package com.ysw.tippopu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
    private String mBtnStr;
    private boolean mCancelBtn = false;
    private View.OnClickListener mListener;
    private boolean touchWinDismiss = true;

    private String titleColoe = "#414141";
    private float titleSiz = 16;
    private String contentColor = "#5C6373";
    private float contentSize = 14;

    private String confirmBtnTextColor = "#FFFFFF";
    private float confirmSize = 14;
    private String confirmBgColoe = "#3EBDFF";
    private float confirmBtnRadius = 10;

    private String cancleBtnTextColoe = "#333333";
    private float cancleBtnSize = 14;
    private String cancleBgColor = "#3EBDFF";
    private float cancleRadiusSize = 10;

    /**
     *
     * @param context 上下文
     * @param title 标题
     * @param content 内容
     * @param btnStr 确认按钮文字
     * @param cancelBtn 是否展示取消按钮
     * @param clickListener 右边按钮点击事件
     */
    public TextShowPopupWindow(Context context, String title, String content, String btnStr, boolean cancelBtn, View.OnClickListener clickListener) {
        super(context);
        this.mContext = context;
        this.mTitle = title;
        this.mContent = content;
        this.mBtnStr = btnStr;
        this.mListener = clickListener;
        this.mCancelBtn = cancelBtn;

    }

    /**
     *
     * @param context 上下文
     * @param title 标题
     * @param content 内容
     * @param btnStr 确认按钮文字
     * @param cancelBtn 是否展示取消按钮
     * @param touchWinDismiss 点击弹窗以外是否关闭弹窗 默认为true
     * @param clickListener 右边按钮点击事件
     */
    public TextShowPopupWindow(Context context, String title, String content, String btnStr,boolean cancelBtn, boolean touchWinDismiss, View.OnClickListener clickListener) {
        super(context);
        this.mContext = context;
        this.mTitle = title;
        this.mContent = content;
        this.mBtnStr = btnStr;
        this.mCancelBtn = cancelBtn;
        this.touchWinDismiss = touchWinDismiss;
        this.mListener = clickListener;

    }

    public void start(){
        init();
    }

    /**
     * 设置布局以及点击事件
     */
    private void init() {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.text_show_popu, null);
        //title
        TextView popu_title_tv = mView.findViewById(R.id.popu_title_tv);
        popu_title_tv.setText(mTitle);
        popu_title_tv.setTextColor(Color.parseColor(titleColoe));
        popu_title_tv.setTextSize(titleSiz);
        //content
        TextView popu_content_tv = mView.findViewById(R.id.popu_content_tv);
        popu_content_tv.setText(mContent);
        popu_content_tv.setTextSize(contentSize);
        popu_content_tv.setTextColor(Color.parseColor(contentColor));
        //confirm
        Button btn_select = (Button) mView.findViewById(R.id.popu_btn_sub);
        btn_select.setText(mBtnStr);
        btn_select.setTextColor(Color.parseColor(confirmBtnTextColor));
        btn_select.setTextSize(confirmSize);
        GradientDrawable drawable1=new GradientDrawable();
        drawable1.setColor(Color.parseColor(confirmBgColoe));
        drawable1.setCornerRadius(confirmBtnRadius);
        btn_select.setBackground(drawable1);

        //cancle
        Button btn_cancel = (Button) mView.findViewById(R.id.popu_btn_cancle);
        btn_cancel.setTextSize(cancleBtnSize);
        btn_cancel.setTextColor(Color.parseColor(cancleBtnTextColoe));
        GradientDrawable drawable=new GradientDrawable();
        drawable.setColor(Color.parseColor(cancleBgColor));
        drawable.setCornerRadius(cancleRadiusSize);
        btn_cancel.setBackground(drawable);

        if (mCancelBtn){
            btn_cancel.setVisibility(View.VISIBLE);
        }else{
            btn_cancel.setVisibility(View.GONE);
        }


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
        this.setFocusable(touchWinDismiss);
        ColorDrawable dw = new ColorDrawable(0x0000000);
        this.setBackgroundDrawable(dw);
        this.setClippingEnabled(false);
        // 单击弹出窗以外处 关闭弹出窗
        mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (touchWinDismiss){
                    int height = mView.findViewById(R.id.ll_pop).getTop();
                    int y = (int) event.getY();
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        if (y < height) {
                            dismiss();
                        }
                    }
                }
                return true;
            }
        });
    }

    public void setTitleColoe(String titleColoe) {
        this.titleColoe = titleColoe;
    }

    public void setTitleSiz(float titleSiz) {
        this.titleSiz = titleSiz;
    }

    public void setContentColor(String contentColor) {
        this.contentColor = contentColor;
    }

    public void setContentSize(float contentSize) {
        this.contentSize = contentSize;
    }

    public void setConfirmBtnTextColor(String confirmBtnTextColor) {
        this.confirmBtnTextColor = confirmBtnTextColor;
    }

    public void setConfirmSize(float confirmSize) {
        this.confirmSize = confirmSize;
    }

    public void setConfirmBgColoe(String confirmBgColoe) {
        this.confirmBgColoe = confirmBgColoe;
    }

    public void setConfirmBtnRadius(float confirmBtnRadius) {
        this.confirmBtnRadius = confirmBtnRadius;
    }

    public void setCancleBtnTextColoe(String cancleBtnTextColoe) {
        this.cancleBtnTextColoe = cancleBtnTextColoe;
    }

    public void setCancleBtnSize(float cancleBtnSize) {
        this.cancleBtnSize = cancleBtnSize;
    }

    public void setCancleBgColor(String cancleBgColor) {
        this.cancleBgColor = cancleBgColor;
    }

    public void setCancleRadiusSize(float cancleRadiusSize) {
        this.cancleRadiusSize = cancleRadiusSize;
    }
}
