package com.zeal.mystation3.application;

import android.app.Application;

import com.apkfuns.logutils.LogUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.zeal.mystation3.utils.CrashHandler;
import com.zeal.mystation3.utils.LogInit;


public class MyApplication extends Application {

    private CrashHandler mCrashHandler;
    // File Directory in sd card
    public static final String DIRECTORY_NAME = "MyStation";

    @Override
    public void onCreate() {
        super.onCreate();

        //崩溃处理器，会将错误信息存入MtStation/log.txt
        mCrashHandler = CrashHandler.getInstance();
        mCrashHandler.init(getApplicationContext(), getClass());

        // 保存日志的工具，使用参照
        //LogInit.init(this);


        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }
}
