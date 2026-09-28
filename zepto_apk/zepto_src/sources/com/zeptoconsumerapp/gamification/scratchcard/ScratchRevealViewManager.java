package com.zeptoconsumerapp.gamification.scratchcard;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import com.zeptoconsumerapp.gamification.constants.AnimationType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ScratchRevealViewManager extends ViewGroupManager<ScratchRevealView> {
    private final int parseColorSafe(String str) {
        try {
            return Color.parseColor(str);
        } catch (IllegalArgumentException unused) {
            return -16777216;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.g(new Pair("onScratchComplete", MapsKt.g(new Pair("registrationName", "onScratchComplete"))));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "ScratchRevealView";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "animationConfig")
    public final void setAnimationConfig(@NotNull ScratchRevealView view, @NotNull ReadableMap config) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        String animationType = config.getString("animationType");
        if (animationType == null) {
            animationType = AnimationType.f47596b.a();
        }
        long j2 = config.hasKey("animationDuration") ? config.getInt("animationDuration") : 800L;
        view.getClass();
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        view.f47609i = animationType;
        view.f47610j = j2;
    }

    @ReactProp(name = "pathConfig")
    public final void setPathConfig(@NotNull ScratchRevealView view, @NotNull ReadableMap config) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        Paint newPaint = new Paint();
        newPaint.setStrokeWidth((float) config.getDouble(Snapshot.WIDTH));
        String string = config.getString("color");
        newPaint.setColor(string != null ? Integer.valueOf(parseColorSafe(string)).intValue() : -16777216);
        newPaint.setStyle(Paint.Style.STROKE);
        String string2 = config.getString("strokeCap");
        newPaint.setStrokeCap(Intrinsics.b(string2, "round") ? Paint.Cap.ROUND : Intrinsics.b(string2, "square") ? Paint.Cap.SQUARE : Paint.Cap.BUTT);
        String string3 = config.getString("strokeJoin");
        newPaint.setStrokeJoin(Intrinsics.b(string3, "round") ? Paint.Join.ROUND : Intrinsics.b(string3, "bevel") ? Paint.Join.BEVEL : Paint.Join.MITER);
        newPaint.setAntiAlias(true);
        if (config.hasKey("blendMode") && Intrinsics.b(config.getString("blendMode"), "clear")) {
            newPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        float f2 = config.hasKey("cutoffArea") ? (float) config.getDouble("cutoffArea") : 30.0f;
        view.getClass();
        Intrinsics.checkNotNullParameter(newPaint, "newPaint");
        float strokeWidth = newPaint.getStrokeWidth();
        view.f47604d = strokeWidth;
        view.f47605e = strokeWidth;
        Paint paint = view.f47611k;
        paint.setStrokeCap(newPaint.getStrokeCap());
        paint.setStrokeJoin(newPaint.getStrokeJoin());
        view.f47606f = f2;
        view.invalidate();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ScratchRevealView createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScratchRevealView(context);
    }
}
