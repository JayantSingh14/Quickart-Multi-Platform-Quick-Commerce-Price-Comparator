package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.jni.annotations.DoNotStripAny;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@DoNotStripAny
@Metadata
/* loaded from: classes3.dex */
public final class JSCInstance extends JSRuntimeFactory {

    @NotNull
    private static final Companion Companion = new Companion();

    @Metadata
    public static final class Companion {
        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        @DoNotStrip
        public final HybridData initHybrid() {
            return JSCInstance.initHybrid();
        }
    }

    static {
        SoLoader.m("jscinstance");
    }

    public JSCInstance() {
        super(Companion.initHybrid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    @DoNotStrip
    public static final native HybridData initHybrid();
}
