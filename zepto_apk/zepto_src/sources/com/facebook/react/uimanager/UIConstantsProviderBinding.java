package com.facebook.react.uimanager;

import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStripAny
@Metadata
/* loaded from: classes3.dex */
public final class UIConstantsProviderBinding {

    @NotNull
    public static final UIConstantsProviderBinding INSTANCE = new UIConstantsProviderBinding();

    @DoNotStripAny
    @Metadata
    public interface ConstantsForViewManagerProvider {
        @Nullable
        NativeMap getConstantsForViewManager(@NotNull String str);
    }

    @DoNotStripAny
    @Metadata
    public interface ConstantsProvider {
        @NotNull
        NativeMap getConstants();
    }

    @DoNotStripAny
    @Metadata
    public interface DefaultEventTypesProvider {
        @NotNull
        NativeMap getDefaultEventTypes();
    }

    static {
        SoLoader.m("uimanagerjni");
    }

    private UIConstantsProviderBinding() {
    }

    @JvmStatic
    public static final native void install(@NotNull RuntimeExecutor runtimeExecutor, @NotNull DefaultEventTypesProvider defaultEventTypesProvider, @NotNull ConstantsForViewManagerProvider constantsForViewManagerProvider, @NotNull ConstantsProvider constantsProvider);
}
