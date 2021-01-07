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
	        implementation 'com.github.youseewaht:mUtils:1.0.2'
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
/**
     * 获取当前时间
     * @param type eg: "yyyy-MM-dd" "yyyy-MM-dd HH:mm:ss"
     * @return
     */
Utils.getCurrentTime("yyyy-MM-dd HH:mm:ss");
/**
     * 毫秒值转换
     * @param time
     * @param type  eg: "yyyy-MM-dd" "yyyy-MM-dd HH:mm:ss"
     * @return
     */
Utils.timeMillisFormat(1609988254);
/**
     *  年份增加
     * @param year 增加的年数
     * @param date 起始时间
     * @param type 返回类型 eg："yyyy-MM-dd" "yyyy-MM-dd HH:mm:ss"
     * @return
     */
Utils.getDurationYear(1,new Date(),"yyyy-MM-dd");
/**
     * 月份增加
     * @param month 增加的月数 eg： 1  2  3
     * @param date 起始时间
     * @param type 返回类型 eg："yyyy-MM-dd" "yyyy-MM-dd HH:mm:ss"
     * @return
     */
Utils.getDurationMonth(1,new Date(),"yyyy-MM-dd");
/**
     * 天数增加
     * @param day 增加的天数 eg： 1  2  3
     * @param date 起始时间
     * @param type 返回类型 eg："yyyy-MM-dd" "yyyy-MM-dd HH:mm:ss"
     * @return
     */
Utils.getDurationDay(1,new Date(),"yyyy-MM-dd");
/**
     * 根据屏幕的分辨率从 dp 的单位 转成为 px(像素)
     * @param context
     * @param dpValue
     * @return
     */
Utils.dip2px(context,15f);
/**
     * 是否包含特殊符号
     * @param string
     * @return true:不包含特殊字符
     */
Utils.isConSpeCharacters("");
/**
     * 将double格式化为指定小数位的String，不足小数位用0补全
     * @param v     需要格式化的数字
     * @param scale 小数点后保留几位
     * @return
     */
Utils.roundByScale(2.1,3)
/**
     * 判断文件是否存在
     * @param path 文件的路径
     * @return
     */
Utils.isExists("文件路径");
/**
     * 转换文件大小
     * @param fileS 文件大小
     * @return
     */
Utils.formatFileSize(56231212);
/**
     * 获得屏幕高度
     * @param context
     * @return
     */
Utils.getScreenWidth(context);
/**
     * 获得屏幕宽度
     * @param context
     * @return
     */
Utils.getScreenHeight(context);
```

