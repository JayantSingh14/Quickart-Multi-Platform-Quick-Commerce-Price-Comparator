package com.facebook.react.defaults;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.fabric.ComponentFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@DoNotStrip
@Metadata
/* loaded from: classes3.dex */
public final class DefaultComponentsRegistry {
    static {
        new DefaultComponentsRegistry();
        DefaultSoLoader.f18756a.a();
    }

    private DefaultComponentsRegistry() {
    }

    @JvmStatic
    @DoNotStrip
    public static final native void register(@NotNull ComponentFactory componentFactory);
}
