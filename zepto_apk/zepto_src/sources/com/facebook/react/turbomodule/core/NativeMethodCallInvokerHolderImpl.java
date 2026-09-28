package com.facebook.react.turbomodule.core;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.common.annotations.FrameworkAPI;
import com.facebook.react.internal.turbomodule.core.NativeModuleSoLoader;
import com.facebook.react.turbomodule.core.interfaces.NativeMethodCallInvokerHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
@FrameworkAPI
/* loaded from: classes3.dex */
public final class NativeMethodCallInvokerHolderImpl implements NativeMethodCallInvokerHolder {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @DoNotStrip
    @NotNull
    private final HybridData mHybridData;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        NativeModuleSoLoader.Companion.maybeLoadSoLibrary();
    }

    private NativeMethodCallInvokerHolderImpl(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
