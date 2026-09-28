package com.th3rdwave.safeareacontext;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = SafeAreaContextModule.NAME)
@Metadata
/* loaded from: classes.dex */
public final class SafeAreaContextModule extends NativeSafeAreaContextSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "RNCSafeAreaContext";

    @Metadata
    public static final class Companion {
    }

    public SafeAreaContextModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private final Map<String, Object> getInitialWindowMetrics() {
        View viewFindViewById;
        Window window;
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        ViewGroup viewGroup = (ViewGroup) ((currentActivity == null || (window = currentActivity.getWindow()) == null) ? null : window.getDecorView());
        if (viewGroup != null && (viewFindViewById = viewGroup.findViewById(android.R.id.content)) != null) {
            EdgeInsets insets = SafeAreaUtilsKt.b(viewGroup);
            Rect rect = SafeAreaUtilsKt.a(viewFindViewById, viewGroup);
            if (insets != null && rect != null) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                Pair pair = new Pair("insets", MapsKt.h(new Pair("top", Float.valueOf(PixelUtil.a(insets.f47154a))), new Pair("right", Float.valueOf(PixelUtil.a(insets.f47155b))), new Pair("bottom", Float.valueOf(PixelUtil.a(insets.f47156c))), new Pair("left", Float.valueOf(PixelUtil.a(insets.f47157d)))));
                Intrinsics.checkNotNullParameter(rect, "rect");
                return MapsKt.h(pair, new Pair("frame", MapsKt.h(new Pair("x", Float.valueOf(PixelUtil.a(rect.f47160a))), new Pair("y", Float.valueOf(PixelUtil.a(rect.f47161b))), new Pair(Snapshot.WIDTH, Float.valueOf(PixelUtil.a(rect.f47162c))), new Pair(Snapshot.HEIGHT, Float.valueOf(PixelUtil.a(rect.f47163d))))));
            }
        }
        return null;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @Override // com.th3rdwave.safeareacontext.NativeSafeAreaContextSpec
    @NotNull
    public Map<String, Object> getTypedExportedConstants() {
        return MapsKt.g(new Pair("initialWindowMetrics", getInitialWindowMetrics()));
    }
}
