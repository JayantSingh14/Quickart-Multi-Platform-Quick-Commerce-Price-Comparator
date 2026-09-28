package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Choreographer;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import com.swmansion.rnscreens.utils.InsetsKtKt;
import com.swmansion.rnscreens.utils.PaddingBundle;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class CustomToolbar extends Toolbar {
    public final ScreenStackHeaderConfig G0;
    public Insets H0;
    public boolean I0;
    public boolean J0;
    public final CustomToolbar$layoutCallback$1 K0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.swmansion.rnscreens.CustomToolbar$layoutCallback$1] */
    public CustomToolbar(ThemedReactContext context, ScreenStackHeaderConfig config) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.G0 = config;
        Insets NONE = Insets.f2807e;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        this.H0 = NONE;
        this.K0 = new Choreographer.FrameCallback() { // from class: com.swmansion.rnscreens.CustomToolbar$layoutCallback$1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                CustomToolbar customToolbar = this.f46919a;
                customToolbar.J0 = false;
                customToolbar.measure(View.MeasureSpec.makeMeasureSpec(customToolbar.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(customToolbar.getHeight(), Integer.MIN_VALUE));
                customToolbar.layout(customToolbar.getLeft(), customToolbar.getTop(), customToolbar.getRight(), customToolbar.getBottom());
            }
        };
    }

    private final boolean getShouldApplyTopInset() {
        return this.G0.t;
    }

    private final boolean getShouldAvoidDisplayCutout() {
        return this.G0.t;
    }

    @NotNull
    public final ScreenStackHeaderConfig getConfig() {
        return this.G0;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets windowInsetsOnApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        WindowInsets rootWindowInsets = getRootWindowInsets();
        Insets insetsA = InsetsKtKt.a(this, 128, rootWindowInsets, false);
        Insets insetsA2 = InsetsKtKt.a(this, 519, rootWindowInsets, false);
        Insets insetsA3 = InsetsKtKt.a(this, 519, rootWindowInsets, true);
        Insets insetsC = Insets.c(insetsA.f2808a + insetsA2.f2808a, 0, insetsA.f2810c + insetsA2.f2810c, 0);
        Intrinsics.checkNotNullExpressionValue(insetsC, "of(...)");
        Insets insetsC2 = Insets.c(0, Math.max(insetsA.f2809b, getShouldApplyTopInset() ? insetsA3.f2809b : 0), 0, Math.max(insetsA.f2811d, 0));
        Intrinsics.checkNotNullExpressionValue(insetsC2, "of(...)");
        Insets insetsC3 = Insets.c(insetsC.f2808a + insetsC2.f2808a, insetsC.f2809b + insetsC2.f2809b, insetsC.f2810c + insetsC2.f2810c, insetsC.f2811d + insetsC2.f2811d);
        Intrinsics.checkNotNullExpressionValue(insetsC3, "add(...)");
        if (!Intrinsics.b(this.H0, insetsC3)) {
            this.H0 = insetsC3;
            this.I0 = getShouldAvoidDisplayCutout();
            setPadding(insetsC3.f2808a, insetsC3.f2809b, insetsC3.f2810c, insetsC3.f2811d);
        }
        return windowInsetsOnApplyWindowInsets;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Object next;
        super.onLayout(z, i2, i3, i4, i5);
        boolean z2 = z || this.I0;
        ScreenStackHeaderConfig screenStackHeaderConfig = this.G0;
        screenStackHeaderConfig.getClass();
        Intrinsics.checkNotNullParameter(this, "toolbar");
        if (z2) {
            int paddingStart = getNavigationIcon() != null ? getPaddingStart() + getCurrentContentInsetStart() : Math.max(getCurrentContentInsetStart(), getPaddingStart());
            Iterator it = screenStackHeaderConfig.f47026e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((ScreenStackHeaderSubview) next).getType() == ScreenStackHeaderSubview.Type.f47038a) {
                        break;
                    }
                }
            }
            ScreenStackHeaderSubview screenStackHeaderSubview = (ScreenStackHeaderSubview) next;
            if (screenStackHeaderSubview != null) {
                paddingStart = screenStackHeaderSubview.getLeft();
            }
            int paddingEnd = getPaddingEnd() + getCurrentContentInsetEnd();
            getWidth();
            int height = getHeight();
            if (Math.abs(screenStackHeaderConfig.f46920a - paddingStart) >= 0.9d || Math.abs(screenStackHeaderConfig.f46921b - paddingEnd) >= 0.9d || Math.abs(screenStackHeaderConfig.f46922c - height) >= 0.9d) {
                screenStackHeaderConfig.f46920a = paddingStart;
                screenStackHeaderConfig.f46921b = paddingEnd;
                screenStackHeaderConfig.f46922c = height;
                Context context = screenStackHeaderConfig.getContext();
                ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
                UIManagerModule uIManagerModule = reactContext != null ? (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class) : null;
                if (uIManagerModule != null) {
                    uIManagerModule.setViewLocalData(screenStackHeaderConfig.getId(), new PaddingBundle(height, paddingStart, paddingEnd));
                }
            }
        }
        this.I0 = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        CustomToolbar$layoutCallback$1 customToolbar$layoutCallback$1;
        Window window;
        WindowManager.LayoutParams attributes;
        super.requestLayout();
        Context context = getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        Activity currentActivity = ((ThemedReactContext) context).f19479a.getCurrentActivity();
        Integer numValueOf = (currentActivity == null || (window = currentActivity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : Integer.valueOf(attributes.softInputMode);
        if (Build.VERSION.SDK_INT > 29 || numValueOf == null || numValueOf.intValue() != 32 || this.J0 || (customToolbar$layoutCallback$1 = this.K0) == null) {
            return;
        }
        this.J0 = true;
        ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19070c, customToolbar$layoutCallback$1);
    }

    public final void z() {
        ScreenStackHeaderConfig screenStackHeaderConfig = this.G0;
        setContentInsetStartWithNavigation(screenStackHeaderConfig.getPreferredContentInsetStartWithNavigation());
        v(screenStackHeaderConfig.getPreferredContentInsetStart(), screenStackHeaderConfig.getPreferredContentInsetEnd());
    }
}
