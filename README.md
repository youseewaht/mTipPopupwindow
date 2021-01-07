# mTipPopupwindow   

### 使用   

#### Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {    
   repositories {    
      ...    
      maven { url 'https://jitpack.io' }    
   }    
}    
```

#### Step 2. Add the dependency   
```
dependencies {
	        implementation 'com.github.youseewaht:mTipPopupwindow:1.0.1'
}
```
#### popupwindow使用 
```
/**
     *
     * @param context 上下文
     * @param title 标题
     * @param content 内容
     * @param btnStr 确认按钮文字
     * @param cancelBtn 是否展示取消按钮
     * @param clickListener 右边按钮点击事件
     */
     
     TextShowPopupWindow popupWindow = new TextShowPopupWindow(getApplicationContext(), "温馨提示", "您好，账户余额不足请及时充值", "去充值", false, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //确认按钮点击事件
                //业务处理
            }
        });
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_main,null);
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
```
#### 工具类使用    

```
//手机号判断 true为通过验证
Utils.isMobileNO("13888888888");

/**
     * 判断注册账号 true为通过验证
     * @param str 账号
     * @param min 最小长度
     * @param max 最大长度
     * @return
     * @throws PatternSyntaxException
     */
Utils.isAccount("账号",5,15);
```

