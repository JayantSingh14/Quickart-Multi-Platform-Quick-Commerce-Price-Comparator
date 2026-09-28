package com.facebook.react.jscexecutor;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@DoNotStrip
@Metadata
/* loaded from: classes3.dex */
public final class JSCExecutor extends JavaScriptExecutor {

    @Metadata
    public static final class Companion {
    }

    static {
        SoLoader.m("jscexecutor");
    }

    public static final void b() {
        SoLoader.m("jscexecutor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native HybridData initHybrid(ReadableNativeMap readableNativeMap);

    @Override // com.facebook.react.bridge.JavaScriptExecutor
    public final String getName() {
        return "JSCExecutor";
    }
}
