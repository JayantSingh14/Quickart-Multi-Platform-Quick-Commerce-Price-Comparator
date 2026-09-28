package com.facebook.hermes.reactexecutor;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.soloader.SoLoader;

/* loaded from: classes.dex */
public class HermesExecutor extends JavaScriptExecutor {

    /* renamed from: a, reason: collision with root package name */
    public static String f17667a;

    static {
        a();
    }

    public HermesExecutor() {
        super(initHybridDefaultConfig(true, ""));
    }

    public static void a() {
        if (f17667a == null) {
            SoLoader.m("hermes");
            SoLoader.m("hermes_executor");
            f17667a = "Release";
        }
    }

    private static native HybridData initHybrid(boolean z, String str, long j2);

    private static native HybridData initHybridDefaultConfig(boolean z, String str);

    @Override // com.facebook.react.bridge.JavaScriptExecutor
    public final String getName() {
        return "HermesExecutor" + f17667a;
    }
}
