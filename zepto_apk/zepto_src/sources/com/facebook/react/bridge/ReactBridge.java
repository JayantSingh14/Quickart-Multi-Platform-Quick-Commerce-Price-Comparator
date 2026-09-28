package com.facebook.react.bridge;

import android.os.SystemClock;
import android.os.Trace;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class ReactBridge {
    private static volatile boolean sDidInit = false;
    private static volatile long sLoadEndTime;
    private static volatile long sLoadStartTime;

    public static long getLoadEndTime() {
        return sLoadEndTime;
    }

    public static long getLoadStartTime() {
        return sLoadStartTime;
    }

    public static boolean isInitialized() {
        return sDidInit;
    }

    public static synchronized void staticInit() {
        if (sDidInit) {
            return;
        }
        sLoadStartTime = SystemClock.uptimeMillis();
        Intrinsics.checkNotNullParameter("ReactBridge.staticInit::load:reactnativejni", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("ReactBridge.staticInit::load:reactnativejni"));
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_START);
        SoLoader.m("reactnativejni");
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_END);
        Trace.endSection();
        sLoadEndTime = SystemClock.uptimeMillis();
        sDidInit = true;
    }
}
