package com.facebook.react.internal.turbomodule.core;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.reactperflogger.NativeModulePerfLogger;
import javax.annotation.Nullable;

@DoNotStrip
@Nullsafe
/* loaded from: classes.dex */
class TurboModulePerfLogger {

    @Nullable
    private static NativeModulePerfLogger sNativeModulePerfLogger;

    static {
        NativeModuleSoLoader.maybeLoadSoLibrary();
    }

    public static void enableLogging(NativeModulePerfLogger nativeModulePerfLogger) {
        if (nativeModulePerfLogger != null) {
            sNativeModulePerfLogger = nativeModulePerfLogger;
            jniEnableCppLogging(nativeModulePerfLogger);
        }
    }

    private static native void jniEnableCppLogging(NativeModulePerfLogger nativeModulePerfLogger);

    public static void moduleCreateCacheHit(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.a();
        }
    }

    public static void moduleCreateConstructEnd(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.b();
        }
    }

    public static void moduleCreateConstructStart(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.c();
        }
    }

    public static void moduleCreateEnd(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.d();
        }
    }

    public static void moduleCreateFail(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.e();
        }
    }

    public static void moduleCreateSetUpEnd(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.f();
        }
    }

    public static void moduleCreateSetUpStart(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.g();
        }
    }

    public static void moduleCreateStart(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.h();
        }
    }

    public static void moduleDataCreateEnd(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.i();
        }
    }

    public static void moduleDataCreateStart(String str, int i2) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.j();
        }
    }
}
