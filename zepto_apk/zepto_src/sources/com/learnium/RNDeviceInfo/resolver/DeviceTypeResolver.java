package com.learnium.RNDeviceInfo.resolver;

import android.app.UiModeManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.learnium.RNDeviceInfo.DeviceType;

/* loaded from: classes.dex */
public class DeviceTypeResolver {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f45960a;

    public DeviceTypeResolver(ReactApplicationContext reactApplicationContext) {
        this.f45960a = reactApplicationContext;
    }

    public final DeviceType a() {
        UiModeManager uiModeManager;
        ReactApplicationContext reactApplicationContext = this.f45960a;
        boolean zHasSystemFeature = reactApplicationContext.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
        DeviceType deviceType = DeviceType.TV;
        if (zHasSystemFeature || ((uiModeManager = (UiModeManager) reactApplicationContext.getSystemService("uimode")) != null && uiModeManager.getCurrentModeType() == 4)) {
            return deviceType;
        }
        int i2 = reactApplicationContext.getResources().getConfiguration().smallestScreenWidthDp;
        DeviceType deviceType2 = DeviceType.HANDSET;
        DeviceType deviceType3 = DeviceType.TABLET;
        DeviceType deviceType4 = DeviceType.UNKNOWN;
        DeviceType deviceType5 = i2 == 0 ? deviceType4 : i2 >= 600 ? deviceType3 : deviceType2;
        if (deviceType5 != deviceType4) {
            return deviceType5;
        }
        WindowManager windowManager = (WindowManager) reactApplicationContext.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealMetrics(new DisplayMetrics());
            double dSqrt = Math.sqrt(Math.pow(r1.heightPixels / r1.ydpi, 2.0d) + Math.pow(r1.widthPixels / r1.xdpi, 2.0d));
            if (dSqrt >= 3.0d && dSqrt <= 6.9d) {
                return deviceType2;
            }
            if (dSqrt > 6.9d && dSqrt <= 18.0d) {
                return deviceType3;
            }
        }
        return deviceType4;
    }
}
