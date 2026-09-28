package com.facebook.react.bridge;

import com.facebook.jni.HybridClassBase;
import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@DoNotStrip
@Metadata
/* loaded from: classes.dex */
public abstract class NativeMap extends HybridClassBase {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        ReactBridge.staticInit();
    }

    @NotNull
    public native String toString();
}
