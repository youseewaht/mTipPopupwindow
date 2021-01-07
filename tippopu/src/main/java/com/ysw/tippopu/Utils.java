package com.ysw.tippopu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static android.view.View.NO_ID;

/**
 * @Author 作  者：created by Administrator
 * 日  期：2021 01 2021/1/7 0007 17
 * 项目名：TipPopu
 * 包  名：com.ysw.tippopu
 * 类  名：Utils
 * 简  述：工具类
 */
public class Utils {

    //手机号判断 true为通过验证
    public static boolean isMobileNO(String str) throws PatternSyntaxException {
        if (str == null) {
            return false;
        }
        if (str.length() != 11) {
            return false;
        }
        String regExp = "((\\+86|0086)?\\s*)((134[0-8]\\d{7})|(((13([0-3]|[5-9]))|(14[5-9])|15([0-3]|[5-9])|(16(2|[5-7]))|17([0-3]|[5-8])|18[0-9]|19(1|[8-9]))\\d{8})|(14(0|1|4)0\\d{7})|(1740([0-5]|[6-9]|[10-12])\\d{7}))";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 判断注册账号 true为通过验证
     * @param str 账号
     * @param min 最小长度
     * @param max 最大长度
     * @return
     * @throws PatternSyntaxException
     */
    public static boolean isAccount(String str,int min,int max) throws PatternSyntaxException {
        if (str == null) {
            return false;
        }
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[A-Za-z_][A-Za-z_0-9]{"+min+","+max+"}$";//(字母开头，允许5-16字节，允许字母数字下划线)    ^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    //判断注册密码 true为通过验证
    public static boolean isPassword(String str) throws PatternSyntaxException {
        if (str == null) {
            return false;
        }
        String regex = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,16}$"; // 数字+字母+特殊字符组合  ^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 获取当前时间
     * @param type "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getCurrentTime(String type) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);

        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     * 毫秒值转换
     * @param time
     * @param type
     * @return
     */
    public static String timeMillisFormat(long time,String type) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
        //获取当前时间
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    /**
     *
     * @param year 增加的年数
     * @param date 起始时间
     * @param type 返回类型 eg："yyyy-MM-dd" "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getDurationYear(int year,Date date,String type){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
        String time = null;
        if (date != null && !type.isEmpty()){
            cal.setTime(date);//设置起时间
            cal.add(Calendar.YEAR, year);//增加一年
            time = simpleDateFormat.format(cal.getTime());
        }
        return time;
    }

    /**
     * 月份增加
     * @param month 增加的月数 eg： 1  2  3
     * @param date 起始时间
     * @param type 返回类型 eg："yyyy-MM-dd" "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getDurationMonth(int month,Date date,String type){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
        String time = null;
        if (date != null && !type.isEmpty()){
            cal.setTime(date);
            cal.add(Calendar.MONTH, month);
            time = simpleDateFormat.format(cal.getTime());
        }
        return time;
    }
    /**
     * 天数增加
     * @param day 增加的天数 eg： 1  2  3
     * @param date 起始时间
     * @param type 返回类型 eg："yyyy-MM-dd" "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getDurationDay(int day,Date date,String type){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
        String time = null;
        if (date != null && !type.isEmpty()){
            cal.setTime(date);//设置起时间
            cal.add(Calendar.DATE, day);
            time = simpleDateFormat.format(cal.getTime());
        }
        return time;
    }

    /**
     * 根据屏幕的分辨率从 dp 的单位 转成为 px(像素)
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 是否包含特殊符号
     * @param string
     * @return
     */
    //判断用户昵称
    public static boolean isConSpeCharacters(String string){
        if(string.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*","").length()==0){
            //不包含特殊字符
            return true;
        }
        return false;
    }

    /**
     *  保留两位小数
     * @param d
     * @return
     */
    public static double getDouble(double d) {
        BigDecimal b = new BigDecimal(d);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 将double格式化为指定小数位的String，不足小数位用0补全
     * @param v     需要格式化的数字
     * @param scale 小数点后保留几位
     * @return
     */
    public static String roundByScale(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "输入位数有误");
        }
        if (scale == 0) {
            return new DecimalFormat("0").format(v);
        }
        String formatStr = "0.";
        for (int i = 0; i < scale; i++) {
            formatStr = formatStr + "0";
        }
        return new DecimalFormat(formatStr).format(v);
    }

    /**
     * if (Utils.isNavigationBarExist(Activity.this)) {
     *             settingPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
     *             settingPopupWindow.showAtLocation(view,
     *                     Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, Utils.getNavigationBarHeight(getApplicationContext()));
     *         } else {
     *             settingPopupWindow.showAtLocation(view,
     *                     Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
     *         }
     */
    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机设备名
     *
     * @return 手机设备名
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    public static int getNavigationBarHeight(Context context) {
        int result = 0;
        if (hasNavBar(context)) {
            Resources res = context.getResources();
            int resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = res.getDimensionPixelSize(resourceId);
            }
        }
        return result;
    }

    /**
     * 判断是否存在虚拟按键兰
     * @param context
     * @return
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static boolean hasNavBar(Context context) {
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("config_showNavigationBar", "bool", "android");
        if (resourceId != 0) {
            boolean hasNav = res.getBoolean(resourceId); // check override flag
            String sNavBarOverride = getNavBarOverride();
            if ("1".equals(sNavBarOverride)) {
                hasNav = false;
            } else if ("0".equals(sNavBarOverride)) {
                hasNav = true;
            }
            return hasNav;
        } else { // fallback
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
    }

    /**
     * 判断虚拟键盘是否重写
     * @return
     */
    private static String getNavBarOverride() {
        String sNavBarOverride = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                Class c = Class.forName("android.os.SystemProperties");
                Method m = c.getDeclaredMethod("get", String.class);
                m.setAccessible(true);
                sNavBarOverride = (String) m.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable e) {
            }
        }
        return sNavBarOverride;
    }

    private static final String NAVIGATION = "navigationBarBackground";

    public static boolean isNavigationBarExist(@NonNull Activity activity) {
        ViewGroup vp = (ViewGroup) activity.getWindow().getDecorView();
        if (vp != null) {
            for (int i = 0; i < vp.getChildCount(); i++) {
                vp.getChildAt(i).getContext().getPackageName();
                if (vp.getChildAt(i).getId() != NO_ID && NAVIGATION.equals(activity.getResources().getResourceEntryName(vp.getChildAt(i).getId()))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断文件是否存在
     * @param path 文件的路径
     * @return
     */
    public static File isExists(String path) {
        File file = new File(path);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    /**
     * 转换文件大小
     * @param fileS 文件大小
     * @return
     */
    public static String formatFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize = "0B";
        if (fileS == 0) {
            return wrongSize;
        }
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }
        return fileSizeString;
    }

    /**
     * 获得屏幕高度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕宽度
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }
}

