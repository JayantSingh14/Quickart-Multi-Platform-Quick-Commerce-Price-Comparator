package com.swmansion.gesturehandler.react;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewGroupKt$children$1;
import androidx.core.view.ViewGroupKt$iterator$1;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerDelegate;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = RNGestureHandlerButtonViewManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> implements RNGestureHandlerButtonManagerInterface<ButtonViewGroup> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RNGestureHandlerButton";

    @NotNull
    private final ViewManagerDelegate<ButtonViewGroup> mDelegate = new RNGestureHandlerButtonManagerDelegate(this);

    @Metadata
    @SourceDebugExtension
    public static final class ButtonViewGroup extends ViewGroup implements NativeViewGestureHandler.NativeViewGestureHandlerHook {
        public static ButtonViewGroup u;
        public static ButtonViewGroup v;

        /* renamed from: a, reason: collision with root package name */
        public Integer f46803a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f46804b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f46805c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f46806d;

        /* renamed from: e, reason: collision with root package name */
        public float f46807e;

        /* renamed from: f, reason: collision with root package name */
        public float f46808f;

        /* renamed from: g, reason: collision with root package name */
        public float f46809g;

        /* renamed from: h, reason: collision with root package name */
        public float f46810h;

        /* renamed from: i, reason: collision with root package name */
        public float f46811i;

        /* renamed from: j, reason: collision with root package name */
        public float f46812j;

        /* renamed from: k, reason: collision with root package name */
        public Integer f46813k;

        /* renamed from: l, reason: collision with root package name */
        public String f46814l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f46815m;
        public int n;
        public boolean o;
        public long p;
        public int q;
        public boolean r;
        public boolean s;
        public static final TypedValue t = new TypedValue();
        public static final a w = new View.OnClickListener() { // from class: com.swmansion.gesturehandler.react.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TypedValue typedValue = RNGestureHandlerButtonViewManager.ButtonViewGroup.t;
            }
        };

        @Metadata
        /* loaded from: classes4.dex */
        public static final class Companion {
        }

        private final boolean getHasBorderRadii() {
            return (this.f46807e == 0.0f && this.f46808f == 0.0f && this.f46809g == 0.0f && this.f46810h == 0.0f && this.f46811i == 0.0f) ? false : true;
        }

        public static boolean j(ViewGroupKt$children$1 viewGroupKt$children$1) {
            Iterator it = viewGroupKt$children$1.iterator();
            while (true) {
                ViewGroupKt$iterator$1 viewGroupKt$iterator$1 = (ViewGroupKt$iterator$1) it;
                if (!viewGroupKt$iterator$1.hasNext()) {
                    return false;
                }
                View view = (View) viewGroupKt$iterator$1.next();
                if (view instanceof ButtonViewGroup) {
                    ButtonViewGroup buttonViewGroup = (ButtonViewGroup) view;
                    if (buttonViewGroup.s || buttonViewGroup.isPressed()) {
                        return true;
                    }
                }
                if ((view instanceof ViewGroup) && j(ViewGroupKt.a((ViewGroup) view))) {
                    return true;
                }
            }
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean a() {
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean b(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAction() == 3 || event.getAction() == 1 || event.getActionMasked() == 6) {
                return false;
            }
            boolean zK = k();
            if (zK) {
                this.s = true;
            }
            return zK;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean c() {
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean d(View view) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.a(view);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void dispatchDrawableHotspotChanged(float f2, float f3) {
        }

        @Override // android.view.View
        public final void drawableHotspotChanged(float f2, float f3) {
            ButtonViewGroup buttonViewGroup = u;
            if (buttonViewGroup == null || buttonViewGroup == this) {
                super.drawableHotspotChanged(f2, f3);
            }
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean e(View view, MotionEvent motionEvent) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.c(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void f(MotionEvent motionEvent) {
            NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.b(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean g(GestureHandler gestureHandler) {
            NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.d(gestureHandler);
            return null;
        }

        public final float getBorderBottomLeftRadius() {
            return this.f46810h;
        }

        public final float getBorderBottomRightRadius() {
            return this.f46811i;
        }

        @Nullable
        public final Integer getBorderColor() {
            return this.f46813k;
        }

        public final float getBorderRadius() {
            return this.f46807e;
        }

        @Nullable
        public final String getBorderStyle() {
            return this.f46814l;
        }

        public final float getBorderTopLeftRadius() {
            return this.f46808f;
        }

        public final float getBorderTopRightRadius() {
            return this.f46809g;
        }

        public final float getBorderWidth() {
            return this.f46812j;
        }

        public final boolean getExclusive() {
            return this.f46815m;
        }

        @Nullable
        public final Integer getRippleColor() {
            return this.f46803a;
        }

        @Nullable
        public final Integer getRippleRadius() {
            return this.f46804b;
        }

        public final boolean getUseBorderlessDrawable() {
            return this.f46806d;
        }

        public final boolean getUseDrawableOnForeground() {
            return this.f46805c;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void h(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (u == this) {
                u = null;
                v = this;
            }
            this.s = false;
        }

        public final float[] i() {
            float f2 = this.f46808f;
            float f3 = this.f46809g;
            float f4 = this.f46811i;
            float f5 = this.f46810h;
            float[] fArr = {f2, f2, f3, f3, f4, f4, f5, f5};
            ArrayList arrayList = new ArrayList(8);
            for (int i2 = 0; i2 < 8; i2++) {
                float f6 = fArr[i2];
                if (f6 == 0.0f) {
                    f6 = this.f46807e;
                }
                arrayList.add(Float.valueOf(f6));
            }
            return CollectionsKt.c0(arrayList);
        }

        public final boolean k() {
            if (j(ViewGroupKt.a(this))) {
                return false;
            }
            ButtonViewGroup buttonViewGroup = u;
            if (buttonViewGroup == null) {
                u = this;
                return true;
            }
            if (this.f46815m) {
                if (buttonViewGroup != this) {
                    return false;
                }
            } else if (buttonViewGroup.f46815m) {
                return false;
            }
            return true;
        }

        public final void l() {
            ColorStateList colorStateList;
            RippleDrawable rippleDrawable;
            PathEffect dashPathEffect;
            if (this.o) {
                this.o = false;
                if (this.n == 0) {
                    setBackground(null);
                }
                setForeground(null);
                Integer num = this.f46803a;
                if (num != null && num.intValue() == 0) {
                    rippleDrawable = null;
                } else {
                    int[][] iArr = {new int[]{R.attr.state_enabled}};
                    Integer num2 = this.f46804b;
                    Integer num3 = this.f46803a;
                    if (num3 != null) {
                        colorStateList = new ColorStateList(iArr, new int[]{num3.intValue()});
                    } else {
                        Resources.Theme theme = getContext().getTheme();
                        TypedValue typedValue = t;
                        theme.resolveAttribute(R.attr.colorControlHighlight, typedValue, true);
                        colorStateList = new ColorStateList(iArr, new int[]{typedValue.data});
                    }
                    rippleDrawable = new RippleDrawable(colorStateList, null, this.f46806d ? null : new ShapeDrawable(new RectShape()));
                    if (num2 != null) {
                        rippleDrawable.setRadius((int) PixelUtil.b(num2.intValue()));
                    }
                }
                PaintDrawable paintDrawable = new PaintDrawable(0);
                if (getHasBorderRadii()) {
                    paintDrawable.setCornerRadii(i());
                }
                if (this.f46812j > 0.0f) {
                    Paint paint = paintDrawable.getPaint();
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(this.f46812j);
                    Integer num4 = this.f46813k;
                    paint.setColor(num4 != null ? num4.intValue() : -16777216);
                    String str = this.f46814l;
                    if (Intrinsics.b(str, "dotted")) {
                        float f2 = this.f46812j;
                        dashPathEffect = new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
                    } else if (Intrinsics.b(str, "dashed")) {
                        float f3 = this.f46812j * 3;
                        dashPathEffect = new DashPathEffect(new float[]{f3, f3, f3, f3}, 0.0f);
                    } else {
                        dashPathEffect = null;
                    }
                    paint.setPathEffect(dashPathEffect);
                }
                if (getHasBorderRadii() && rippleDrawable != null) {
                    PaintDrawable paintDrawable2 = new PaintDrawable(-1);
                    paintDrawable2.setCornerRadii(i());
                    rippleDrawable.setDrawableByLayerId(R.id.mask, paintDrawable2);
                }
                if (this.f46805c) {
                    setForeground(rippleDrawable);
                    int i2 = this.n;
                    if (i2 != 0) {
                        m(i2, paintDrawable, null);
                        return;
                    }
                    return;
                }
                int i3 = this.n;
                if (i3 == 0 && this.f46803a == null) {
                    setBackground(new LayerDrawable(new Drawable[]{rippleDrawable, paintDrawable}));
                } else {
                    m(i3, paintDrawable, rippleDrawable);
                }
            }
        }

        public final void m(int i2, PaintDrawable paintDrawable, RippleDrawable rippleDrawable) {
            PaintDrawable paintDrawable2 = new PaintDrawable(i2);
            if (getHasBorderRadii()) {
                paintDrawable2.setCornerRadii(i());
            }
            setBackground(new LayerDrawable(rippleDrawable != null ? new Drawable[]{paintDrawable2, rippleDrawable, paintDrawable} : new Drawable[]{paintDrawable2, paintDrawable}));
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(info);
            Object tag = getTag(com.facebook.react.R.id.react_test_id);
            if (tag instanceof String) {
                info.setViewIdResourceName((String) tag);
            }
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent ev) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            if (super.onInterceptTouchEvent(ev)) {
                return true;
            }
            onTouchEvent(ev);
            return isPressed();
        }

        @Override // android.view.View, android.view.KeyEvent.Callback
        public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
            this.r = true;
            return super.onKeyUp(i2, keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            long eventTime = event.getEventTime();
            int action = event.getAction();
            ButtonViewGroup buttonViewGroup = u;
            if (buttonViewGroup != null && buttonViewGroup != this && buttonViewGroup.f46815m) {
                if (isPressed()) {
                    setPressed(false);
                }
                this.p = eventTime;
                this.q = action;
                return false;
            }
            if (event.getAction() == 3 && u == this) {
                u = null;
                v = this;
            }
            if (this.p == eventTime && this.q == action && action != 3) {
                return false;
            }
            this.p = eventTime;
            this.q = action;
            return super.onTouchEvent(event);
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (!j(ViewGroupKt.a(this))) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                if (ExtensionsKt.c(context)) {
                    RNGestureHandlerRootView rNGestureHandlerRootView = null;
                    for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                        if (parent instanceof RNGestureHandlerRootView) {
                            rNGestureHandlerRootView = (RNGestureHandlerRootView) parent;
                        }
                    }
                    if (rNGestureHandlerRootView != null) {
                        rNGestureHandlerRootView.j(this);
                    }
                } else if (this.r) {
                    RNGestureHandlerRootView rNGestureHandlerRootView2 = null;
                    for (ViewParent parent2 = getParent(); parent2 != null; parent2 = parent2.getParent()) {
                        if (parent2 instanceof RNGestureHandlerRootView) {
                            rNGestureHandlerRootView2 = (RNGestureHandlerRootView) parent2;
                        }
                    }
                    if (rNGestureHandlerRootView2 != null) {
                        rNGestureHandlerRootView2.j(this);
                    }
                    this.r = false;
                }
                if (v == this) {
                    if (u == this) {
                        u = null;
                        v = this;
                    }
                    v = null;
                    return super.performClick();
                }
            }
            return false;
        }

        @Override // android.view.View
        public void setBackgroundColor(int i2) {
            this.n = i2;
            this.o = true;
        }

        public final void setBorderBottomLeftRadius(float f2) {
            this.f46810h = f2 * getResources().getDisplayMetrics().density;
            this.o = true;
        }

        public final void setBorderBottomRightRadius(float f2) {
            this.f46811i = f2 * getResources().getDisplayMetrics().density;
            this.o = true;
        }

        public final void setBorderColor(@Nullable Integer num) {
            this.f46813k = num;
            this.o = true;
        }

        public final void setBorderRadius(float f2) {
            this.f46807e = f2 * getResources().getDisplayMetrics().density;
            this.o = true;
        }

        public final void setBorderStyle(@Nullable String str) {
            this.f46814l = str;
            this.o = true;
        }

        public final void setBorderTopLeftRadius(float f2) {
            this.f46808f = f2 * getResources().getDisplayMetrics().density;
            this.o = true;
        }

        public final void setBorderTopRightRadius(float f2) {
            this.f46809g = f2 * getResources().getDisplayMetrics().density;
            this.o = true;
        }

        public final void setBorderWidth(float f2) {
            this.f46812j = f2 * getResources().getDisplayMetrics().density;
            this.o = true;
        }

        public final void setExclusive(boolean z) {
            this.f46815m = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0024  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setPressed(boolean r4) {
            /*
                r3 = this;
                if (r4 == 0) goto La
                boolean r0 = r3.k()
                if (r0 == 0) goto La
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager.ButtonViewGroup.v = r3
            La:
                boolean r0 = r3.f46815m
                r1 = 0
                if (r0 != 0) goto L24
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r0 = com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager.ButtonViewGroup.u
                r2 = 1
                if (r0 == 0) goto L19
                boolean r0 = r0.f46815m
                if (r0 != r2) goto L19
                goto L24
            L19:
                androidx.core.view.ViewGroupKt$children$1 r0 = androidx.core.view.ViewGroupKt.a(r3)
                boolean r0 = j(r0)
                if (r0 != 0) goto L24
                goto L25
            L24:
                r2 = r1
            L25:
                if (r4 == 0) goto L2d
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r0 = com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager.ButtonViewGroup.u
                if (r0 == r3) goto L2d
                if (r2 == 0) goto L32
            L2d:
                r3.s = r4
                super.setPressed(r4)
            L32:
                if (r4 != 0) goto L3a
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r4 = com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager.ButtonViewGroup.u
                if (r4 != r3) goto L3a
                r3.s = r1
            L3a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager.ButtonViewGroup.setPressed(boolean):void");
        }

        public final void setRippleColor(@Nullable Integer num) {
            this.f46803a = num;
            this.o = true;
        }

        public final void setRippleRadius(@Nullable Integer num) {
            this.f46804b = num;
            this.o = true;
        }

        public final void setTouched(boolean z) {
            this.s = z;
        }

        public final void setUseBorderlessDrawable(boolean z) {
            this.f46806d = z;
        }

        public final void setUseDrawableOnForeground(boolean z) {
            this.f46805c = z;
            this.o = true;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public ViewManagerDelegate<ButtonViewGroup> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ButtonViewGroup createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ButtonViewGroup buttonViewGroup = new ButtonViewGroup(context);
        buttonViewGroup.f46814l = "solid";
        buttonViewGroup.f46815m = true;
        buttonViewGroup.p = -1L;
        buttonViewGroup.q = -1;
        buttonViewGroup.setOnClickListener(ButtonViewGroup.w);
        buttonViewGroup.setClickable(true);
        buttonViewGroup.setFocusable(true);
        buttonViewGroup.o = true;
        buttonViewGroup.setClipChildren(false);
        return buttonViewGroup;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull ButtonViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction((RNGestureHandlerButtonViewManager) view);
        view.l();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(@NotNull ButtonViewGroup view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackgroundColor(i2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = Snapshot.BORDER_BOTTOM_LEFT_RADIUS)
    public void setBorderBottomLeftRadius(@NotNull ButtonViewGroup view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderBottomLeftRadius(f2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = Snapshot.BORDER_BOTTOM_RIGHT_RADIUS)
    public void setBorderBottomRightRadius(@NotNull ButtonViewGroup view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderBottomRightRadius(f2);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "borderColor")
    public void setBorderColor(@NotNull ButtonViewGroup view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderColor(num);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = Snapshot.BORDER_RADIUS)
    public void setBorderRadius(@NotNull ButtonViewGroup view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderRadius(f2);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "borderStyle")
    public void setBorderStyle(@NotNull ButtonViewGroup view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderStyle(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = Snapshot.BORDER_TOP_LEFT_RADIUS)
    public void setBorderTopLeftRadius(@NotNull ButtonViewGroup view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderTopLeftRadius(f2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = Snapshot.BORDER_TOP_RIGHT_RADIUS)
    public void setBorderTopRightRadius(@NotNull ButtonViewGroup view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderTopRightRadius(f2);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "borderWidth")
    public void setBorderWidth(@NotNull ButtonViewGroup view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderWidth(f2);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "borderless")
    public void setBorderless(@NotNull ButtonViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setUseBorderlessDrawable(z);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "enabled")
    public void setEnabled(@NotNull ButtonViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "exclusive")
    public void setExclusive(@NotNull ButtonViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setExclusive(z);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "foreground")
    @TargetApi(23)
    public void setForeground(@NotNull ButtonViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setUseDrawableOnForeground(z);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "rippleColor")
    public void setRippleColor(@NotNull ButtonViewGroup view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRippleColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "rippleRadius")
    public void setRippleRadius(@NotNull ButtonViewGroup view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRippleRadius(Integer.valueOf(i2));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "touchSoundDisabled")
    public void setTouchSoundDisabled(@NotNull ButtonViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSoundEffectsEnabled(!z);
    }
}
