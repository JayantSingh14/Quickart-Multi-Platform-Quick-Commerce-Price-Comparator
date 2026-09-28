package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Environment;
import android.os.StatFs;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class CrashlyticsReportDataCapture {

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f43792f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f43793g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f43794a;

    /* renamed from: b, reason: collision with root package name */
    public final IdManager f43795b;

    /* renamed from: c, reason: collision with root package name */
    public final AppData f43796c;

    /* renamed from: d, reason: collision with root package name */
    public final MiddleOutFallbackStrategy f43797d;

    /* renamed from: e, reason: collision with root package name */
    public final SettingsController f43798e;

    static {
        HashMap map = new HashMap();
        f43792f = map;
        android.support.v4.media.b.z(5, map, "armeabi", 6, "armeabi-v7a");
        android.support.v4.media.b.z(9, map, "arm64-v8a", 0, "x86");
        map.put("x86_64", 1);
        Locale locale = Locale.US;
        f43793g = "Crashlytics Android SDK/19.4.4";
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, AppData appData, MiddleOutFallbackStrategy middleOutFallbackStrategy, SettingsController settingsController) {
        this.f43794a = context;
        this.f43795b = idManager;
        this.f43796c = appData;
        this.f43797d = middleOutFallbackStrategy;
        this.f43798e = settingsController;
    }

    public static CrashlyticsReport.Session.Event.Application.Execution.Exception c(TrimmedThrowableData trimmedThrowableData, int i2) {
        String str = trimmedThrowableData.f44461b;
        int i3 = 0;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.f44462c;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f44463d;
        if (i2 >= 8) {
            for (TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2; trimmedThrowableData3 != null; trimmedThrowableData3 = trimmedThrowableData3.f44463d) {
                i3++;
            }
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder builderA = CrashlyticsReport.Session.Event.Application.Execution.Exception.a();
        builderA.f(str);
        builderA.e(trimmedThrowableData.f44460a);
        builderA.c(d(stackTraceElementArr, 4));
        builderA.d(i3);
        if (trimmedThrowableData2 != null && i3 == 0) {
            builderA.b(c(trimmedThrowableData2, i2 + 1));
        }
        return builderA.a();
    }

    public static List d(StackTraceElement[] stackTraceElementArr, int i2) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builderA = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.a();
            builderA.c(i2);
            long lineNumber = 0;
            long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
            String str = stackTraceElement.getClassName() + CLConstants.DOT_SALT_DELIMETER + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                lineNumber = stackTraceElement.getLineNumber();
            }
            builderA.e(jMax);
            builderA.f(str);
            builderA.b(fileName);
            builderA.d(lineNumber);
            arrayList.add(builderA.a());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final List a() {
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder builderA = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.a();
        builderA.b(0L);
        builderA.d(0L);
        AppData appData = this.f43796c;
        builderA.c(appData.f43720e);
        builderA.e(appData.f43717b);
        return Collections.singletonList(builderA.a());
    }

    public final CrashlyticsReport.Session.Event.Device b(int i2) {
        Context context = this.f43794a;
        BatteryState batteryStateA = BatteryState.a(context);
        Float fB = batteryStateA.b();
        Double dValueOf = fB != null ? Double.valueOf(fB.doubleValue()) : null;
        int iC = batteryStateA.c();
        boolean z = false;
        if (!CommonUtils.g() && ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            z = true;
        }
        long jA = CommonUtils.a(context);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        long j2 = jA - memoryInfo.availMem;
        if (j2 <= 0) {
            j2 = 0;
        }
        long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
        CrashlyticsReport.Session.Event.Device.Builder builderA = CrashlyticsReport.Session.Event.Device.a();
        builderA.b(dValueOf);
        builderA.c(iC);
        builderA.f(z);
        builderA.e(i2);
        builderA.g(j2);
        builderA.d((r3.getBlockCount() * blockSize) - (blockSize * r3.getAvailableBlocks()));
        return builderA.a();
    }
}
