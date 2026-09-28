package com.zeptoconsumerapp.performancemode;

import android.app.ActivityManager;
import coil3.d;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.zeptoconsumerapp.performancemode.performanceClasses.BatteryPerformanceResult;
import com.zeptoconsumerapp.performancemode.performanceClasses.InitialPerformanceModeEvaluator;
import com.zeptoconsumerapp.performancemode.performanceClasses.NetworkPerformanceResult;
import in.juspay.hyper.constants.Labels;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class PerformanceModeResults {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f47736a = LazyKt.b(new d(16));

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f47737b = LazyKt.b(new d(17));

    /* renamed from: c, reason: collision with root package name */
    public static final ActivityManager.MemoryInfo f47738c = new ActivityManager.MemoryInfo();

    /* renamed from: d, reason: collision with root package name */
    public static NetworkPerformanceResult f47739d;

    /* renamed from: e, reason: collision with root package name */
    public static BatteryPerformanceResult f47740e;

    @Metadata
    public static final class Companion {
        public static WritableMap a() throws RuntimeException {
            InitialPerformanceModeEvaluator.a();
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap2, "createMap(...)");
            BatteryPerformanceResult batteryPerformanceResult = PerformanceModeResults.f47740e;
            if (batteryPerformanceResult != null) {
                writableMapCreateMap2.putBoolean("isCharging", batteryPerformanceResult.a());
                writableMapCreateMap2.putBoolean("isPowerSaverMode", batteryPerformanceResult.b());
                writableMapCreateMap2.putInt("percentage", batteryPerformanceResult.c());
                writableMapCreateMap2.putBoolean("isFallbackValue", false);
            }
            WritableMap writableMapCreateMap3 = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap3, "createMap(...)");
            NetworkPerformanceResult networkPerformanceResult = PerformanceModeResults.f47739d;
            if (networkPerformanceResult != null) {
                writableMapCreateMap3.putInt("cumulativeExponentialAverageKbps", networkPerformanceResult.b());
                writableMapCreateMap3.putInt("recentExponentialAverageKbps", networkPerformanceResult.f());
                writableMapCreateMap3.putInt("cumulativeArithmeticAverageKbps", networkPerformanceResult.a());
                writableMapCreateMap3.putInt("recentArithmeticAverageKbps", networkPerformanceResult.e());
                writableMapCreateMap3.putString("networkConnectionType", networkPerformanceResult.d().a());
                writableMapCreateMap3.putBoolean("isFallbackValue", networkPerformanceResult.c());
            }
            WritableMap writableMapCreateMap4 = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap4, "createMap(...)");
            Lazy lazy = PerformanceModeResults.f47736a;
            writableMapCreateMap4.putString(CLConstants.FIELD_PAY_INFO_VALUE, ((PerformanceModeVariants) lazy.getValue()).f47746a);
            writableMapCreateMap4.putBoolean("persist", ((PerformanceModeVariants) lazy.getValue()).f47747b);
            WritableMap writableMapCreateMap5 = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap5, "createMap(...)");
            ActivityManager activityManager = (ActivityManager) PerformanceModeResults.f47737b.getValue();
            ActivityManager.MemoryInfo memoryInfo = PerformanceModeResults.f47738c;
            activityManager.getMemoryInfo(memoryInfo);
            writableMapCreateMap5.putLong("totalMemory", memoryInfo.totalMem);
            writableMapCreateMap5.putLong("availableMemory", memoryInfo.availMem);
            writableMapCreateMap.putMap("battery", writableMapCreateMap2);
            writableMapCreateMap.putMap("network", writableMapCreateMap3);
            writableMapCreateMap.putMap("initialPerformanceMode", writableMapCreateMap4);
            writableMapCreateMap.putMap(Labels.Device.MEMORY, writableMapCreateMap5);
            return writableMapCreateMap;
        }
    }
}
