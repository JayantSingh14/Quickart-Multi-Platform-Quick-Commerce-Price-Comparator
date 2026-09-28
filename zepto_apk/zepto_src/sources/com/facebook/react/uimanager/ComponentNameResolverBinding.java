package com.facebook.react.uimanager;

import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@DoNotStripAny
@Metadata
/* loaded from: classes3.dex */
public final class ComponentNameResolverBinding {

    @NotNull
    public static final ComponentNameResolverBinding INSTANCE = new ComponentNameResolverBinding();

    static {
        SoLoader.m("uimanagerjni");
    }

    private ComponentNameResolverBinding() {
    }

    @JvmStatic
    public static final native void install(@NotNull RuntimeExecutor runtimeExecutor, @NotNull Object obj);
}
