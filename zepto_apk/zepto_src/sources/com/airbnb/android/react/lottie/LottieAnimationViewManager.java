package com.airbnb.android.react.lottie;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class LottieAnimationViewManager extends SimpleViewManager<LottieAnimationView> {

    @NotNull
    private final WeakHashMap<LottieAnimationView, LottieAnimationViewPropertyManager> propManagersMap = new WeakHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createViewInstance$lambda$0(LottieAnimationView view, Throwable error) {
        Intrinsics.c(error);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(error, "error");
        Context context = view.getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ThemedReactContext themedReactContext = (ThemedReactContext) context;
        EventDispatcher eventDispatcherB = UIManagerHelper.b(themedReactContext, view.getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new OnAnimationFailureEvent(themedReactContext.f19481c, view.getId(), error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createViewInstance$lambda$1(LottieAnimationView view, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ThemedReactContext themedReactContext = (ThemedReactContext) context;
        EventDispatcher eventDispatcherB = UIManagerHelper.b(themedReactContext, view.getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new OnAnimationLoadedEvent(themedReactContext.f19481c, view.getId()));
        }
    }

    private final LottieAnimationViewPropertyManager getOrCreatePropertyManager(LottieAnimationView lottieAnimationView) {
        LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager = this.propManagersMap.get(lottieAnimationView);
        if (lottieAnimationViewPropertyManager != null) {
            return lottieAnimationViewPropertyManager;
        }
        LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager2 = new LottieAnimationViewPropertyManager(lottieAnimationView);
        this.propManagersMap.put(lottieAnimationView, lottieAnimationViewPropertyManager2);
        return lottieAnimationViewPropertyManager2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.airbnb.android.react.lottie.LottieAnimationViewManager$createViewInstance$3] */
    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public LottieAnimationView createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        final LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        lottieAnimationView.setFailureListener(new LottieListener() { // from class: com.airbnb.android.react.lottie.a
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                LottieAnimationViewManager.createViewInstance$lambda$0(lottieAnimationView, (Throwable) obj);
            }
        });
        LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener = new LottieOnCompositionLoadedListener() { // from class: com.airbnb.android.react.lottie.b
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void a(LottieComposition lottieComposition) {
                LottieAnimationViewManager.createViewInstance$lambda$1(lottieAnimationView, lottieComposition);
            }
        };
        LottieComposition composition = lottieAnimationView.getComposition();
        if (composition != null) {
            lottieOnCompositionLoadedListener.a(composition);
        }
        lottieAnimationView.o.add(lottieOnCompositionLoadedListener);
        lottieAnimationView.f14113h.a(new Animator.AnimatorListener() { // from class: com.airbnb.android.react.lottie.LottieAnimationViewManager.createViewInstance.3
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                LottieAnimationViewManagerImpl.a(lottieAnimationView, true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                LottieAnimationViewManagerImpl.a(lottieAnimationView, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        return lottieAnimationView;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        HashMap mapE = MapBuilder.e("topAnimationFinish", MapBuilder.c("registrationName", "onAnimationFinish"), "topAnimationFailure", MapBuilder.c("registrationName", "onAnimationFailure"), "topAnimationLoaded", MapBuilder.c("registrationName", "onAnimationLoaded"));
        Intrinsics.checkNotNullExpressionValue(mapE, "of(...)");
        return mapE;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedViewConstants() {
        MapBuilder.Builder builderA = MapBuilder.a();
        builderA.b("VERSION", 1);
        HashMap mapA = builderA.a();
        Intrinsics.checkNotNullExpressionValue(mapA, "build(...)");
        return mapA;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "LottieAnimationView";
    }

    @ReactProp(name = "autoPlay")
    public final void setAutoPlay(@NotNull LottieAnimationView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.q = Boolean.valueOf(z);
    }

    @ReactProp(name = "cacheComposition")
    public final void setCacheComposition(@Nullable LottieAnimationView view, boolean z) {
        Intrinsics.c(view);
        Intrinsics.checkNotNullParameter(view, "view");
        view.setCacheComposition(z);
    }

    @ReactProp(name = "colorFilters")
    public final void setColorFilters(@NotNull LottieAnimationView view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.f14086h = readableArray;
    }

    @ReactProp(name = "enableMergePathsAndroidForKitKatAndAbove")
    public final void setEnableMergePaths(@NotNull LottieAnimationView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.f14084f = Boolean.valueOf(z);
    }

    @ReactProp(name = "enableSafeModeAndroid")
    public final void setEnableSafeMode(@NotNull LottieAnimationView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.f14085g = Boolean.valueOf(z);
    }

    @ReactProp(name = "hardwareAccelerationAndroid")
    public final void setHardwareAccelerationAndroid(@NotNull LottieAnimationView view, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.c(bool);
        boolean zBooleanValue = bool.booleanValue();
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.f14089k = zBooleanValue ? 2 : 1;
    }

    @ReactProp(name = "imageAssetsFolder")
    public final void setImageAssetsFolder(@NotNull LottieAnimationView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.f14083e = str;
    }

    @ReactProp(name = "loop")
    public final void setLoop(@NotNull LottieAnimationView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.p = Boolean.valueOf(z);
    }

    @ReactProp(name = ReactProgressBarViewManager.PROP_PROGRESS)
    public final void setProgress(@NotNull LottieAnimationView view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.o = Float.valueOf(f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "renderMode")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setRenderMode(@org.jetbrains.annotations.NotNull com.airbnb.lottie.LottieAnimationView r3, @org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.airbnb.android.react.lottie.LottieAnimationViewPropertyManager r3 = r2.getOrCreatePropertyManager(r3)
            java.lang.String r0 = "viewManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 == 0) goto L48
            int r0 = r4.hashCode()
            r1 = 165298699(0x9da420b, float:5.2543697E-33)
            if (r0 == r1) goto L3c
            r1 = 899536360(0x359dd5e8, float:1.1759666E-6)
            if (r0 == r1) goto L30
            r1 = 2101957031(0x7d4951a7, float:1.6724924E37)
            if (r0 == r1) goto L24
            goto L48
        L24:
            java.lang.String r0 = "SOFTWARE"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L2d
            goto L48
        L2d:
            com.airbnb.lottie.RenderMode r4 = com.airbnb.lottie.RenderMode.f14204c
            goto L49
        L30:
            java.lang.String r0 = "HARDWARE"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L39
            goto L48
        L39:
            com.airbnb.lottie.RenderMode r4 = com.airbnb.lottie.RenderMode.f14203b
            goto L49
        L3c:
            java.lang.String r0 = "AUTOMATIC"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L45
            goto L48
        L45:
            com.airbnb.lottie.RenderMode r4 = com.airbnb.lottie.RenderMode.f14202a
            goto L49
        L48:
            r4 = 0
        L49:
            r3.f14088j = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.android.react.lottie.LottieAnimationViewManager.setRenderMode(com.airbnb.lottie.LottieAnimationView, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "resizeMode")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setResizeMode(@org.jetbrains.annotations.NotNull com.airbnb.lottie.LottieAnimationView r3, @org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.airbnb.android.react.lottie.LottieAnimationViewPropertyManager r3 = r2.getOrCreatePropertyManager(r3)
            java.lang.String r0 = "viewManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 == 0) goto L48
            int r0 = r4.hashCode()
            r1 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            if (r0 == r1) goto L3c
            r1 = 94852023(0x5a753b7, float:1.5735357E-35)
            if (r0 == r1) goto L30
            r1 = 951526612(0x38b724d4, float:8.73298E-5)
            if (r0 == r1) goto L24
            goto L48
        L24:
            java.lang.String r0 = "contain"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L2d
            goto L48
        L2d:
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.FIT_CENTER
            goto L49
        L30:
            java.lang.String r0 = "cover"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L39
            goto L48
        L39:
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_CROP
            goto L49
        L3c:
            java.lang.String r0 = "center"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L45
            goto L48
        L45:
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE
            goto L49
        L48:
            r4 = 0
        L49:
            r3.f14082d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.android.react.lottie.LottieAnimationViewManager.setResizeMode(com.airbnb.lottie.LottieAnimationView, java.lang.String):void");
    }

    @ReactProp(name = "sourceDotLottieURI")
    public final void setSourceDotLottie(@NotNull LottieAnimationView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.n = str;
        viewManager.a();
    }

    @ReactProp(name = "sourceJson")
    public final void setSourceJson(@NotNull LottieAnimationView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.f14090l = str;
        viewManager.a();
    }

    @ReactProp(name = "sourceName")
    public final void setSourceName(@NotNull LottieAnimationView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        if (str != null && !StringsKt.n(str, CLConstants.DOT_SALT_DELIMETER, false)) {
            str = str.concat(".json");
        }
        viewManager.f14081c = str;
        viewManager.f14080b = true;
        viewManager.a();
    }

    @ReactProp(name = "sourceURL")
    public final void setSourceURL(@NotNull LottieAnimationView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.f14091m = str;
        viewManager.a();
    }

    @ReactProp(name = "speed")
    public final void setSpeed(@NotNull LottieAnimationView view, double d2) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.r = Float.valueOf((float) d2);
    }

    @ReactProp(name = "textFiltersAndroid")
    public final void setTextFilters(@NotNull LottieAnimationView view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        LottieAnimationViewPropertyManager viewManager = getOrCreatePropertyManager(view);
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        viewManager.f14087i = readableArray;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull LottieAnimationView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction((LottieAnimationViewManager) view);
        getOrCreatePropertyManager(view).a();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NotNull final LottieAnimationView view, @NotNull String commandName, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(commandName, "commandName");
        switch (commandName.hashCode()) {
            case -934426579:
                if (commandName.equals("resume")) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    final int i2 = 1;
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.airbnb.android.react.lottie.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            LottieAnimationView lottieAnimationView = view;
                            switch (i2) {
                                case 0:
                                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                                    if (lottieAnimationView.isAttachedToWindow()) {
                                        lottieAnimationView.c();
                                        lottieAnimationView.setProgress(0.0f);
                                        break;
                                    }
                                    break;
                                case 1:
                                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                                    if (lottieAnimationView.isAttachedToWindow()) {
                                        lottieAnimationView.g();
                                        break;
                                    }
                                    break;
                                default:
                                    WeakHashMap weakHashMap3 = ViewCompat.f3080a;
                                    if (lottieAnimationView.isAttachedToWindow()) {
                                        lottieAnimationView.f14117l = false;
                                        lottieAnimationView.f14113h.F();
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                    break;
                }
                break;
            case 3443508:
                if (commandName.equals("play")) {
                    final boolean z = false;
                    final int i3 = readableArray != null ? readableArray.getInt(0) : -1;
                    final int i4 = readableArray != null ? readableArray.getInt(1) : -1;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (i3 != -1 && i4 != -1) {
                        z = true;
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.airbnb.android.react.lottie.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            final boolean z2 = z;
                            final LottieAnimationView lottieAnimationView = view;
                            if (z2) {
                                int i5 = i3;
                                int i6 = i4;
                                if (i5 > i6) {
                                    lottieAnimationView.f14113h.a0(i6, i5);
                                    if (lottieAnimationView.getSpeed() > 0.0f) {
                                        lottieAnimationView.f14113h.J();
                                    }
                                } else {
                                    lottieAnimationView.f14113h.a0(i5, i6);
                                    if (lottieAnimationView.getSpeed() < 0.0f) {
                                        lottieAnimationView.f14113h.J();
                                    }
                                }
                            } else {
                                LottieComposition composition = lottieAnimationView.getComposition();
                                Integer numValueOf = composition != null ? Integer.valueOf((int) composition.f14146l) : null;
                                LottieComposition composition2 = lottieAnimationView.getComposition();
                                Integer numValueOf2 = composition2 != null ? Integer.valueOf((int) composition2.f14147m) : null;
                                int minFrame = (int) lottieAnimationView.getMinFrame();
                                int maxFrame = (int) lottieAnimationView.getMaxFrame();
                                if (numValueOf != null && numValueOf2 != null && (minFrame != numValueOf.intValue() || maxFrame != numValueOf2.intValue())) {
                                    lottieAnimationView.f14113h.a0(numValueOf.intValue(), numValueOf2.intValue());
                                }
                            }
                            WeakHashMap weakHashMap = ViewCompat.f3080a;
                            if (!lottieAnimationView.isAttachedToWindow()) {
                                lottieAnimationView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.airbnb.android.react.lottie.LottieAnimationViewManagerImpl$play$1$1
                                    @Override // android.view.View.OnAttachStateChangeListener
                                    public final void onViewAttachedToWindow(View v) {
                                        Intrinsics.checkNotNullParameter(v, "v");
                                        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) v;
                                        boolean z3 = z2;
                                        LottieAnimationView lottieAnimationView3 = lottieAnimationView;
                                        if (z3) {
                                            lottieAnimationView3.f();
                                        } else {
                                            lottieAnimationView3.g();
                                        }
                                        lottieAnimationView2.removeOnAttachStateChangeListener(this);
                                    }

                                    @Override // android.view.View.OnAttachStateChangeListener
                                    public final void onViewDetachedFromWindow(View v) {
                                        Intrinsics.checkNotNullParameter(v, "v");
                                        ((LottieAnimationView) v).removeOnAttachStateChangeListener(this);
                                    }
                                });
                            } else if (z2) {
                                lottieAnimationView.f();
                            } else {
                                lottieAnimationView.g();
                            }
                        }
                    });
                    break;
                }
                break;
            case 106440182:
                if (commandName.equals(CLConstants.CRED_SUB_TYPE_MANDATE_PAUSE)) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    final int i5 = 2;
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.airbnb.android.react.lottie.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            LottieAnimationView lottieAnimationView = view;
                            switch (i5) {
                                case 0:
                                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                                    if (lottieAnimationView.isAttachedToWindow()) {
                                        lottieAnimationView.c();
                                        lottieAnimationView.setProgress(0.0f);
                                        break;
                                    }
                                    break;
                                case 1:
                                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                                    if (lottieAnimationView.isAttachedToWindow()) {
                                        lottieAnimationView.g();
                                        break;
                                    }
                                    break;
                                default:
                                    WeakHashMap weakHashMap3 = ViewCompat.f3080a;
                                    if (lottieAnimationView.isAttachedToWindow()) {
                                        lottieAnimationView.f14117l = false;
                                        lottieAnimationView.f14113h.F();
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                    break;
                }
                break;
            case 108404047:
                if (commandName.equals("reset")) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    final int i6 = 0;
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.airbnb.android.react.lottie.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            LottieAnimationView lottieAnimationView = view;
                            switch (i6) {
                                case 0:
                                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                                    if (lottieAnimationView.isAttachedToWindow()) {
                                        lottieAnimationView.c();
                                        lottieAnimationView.setProgress(0.0f);
                                        break;
                                    }
                                    break;
                                case 1:
                                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                                    if (lottieAnimationView.isAttachedToWindow()) {
                                        lottieAnimationView.g();
                                        break;
                                    }
                                    break;
                                default:
                                    WeakHashMap weakHashMap3 = ViewCompat.f3080a;
                                    if (lottieAnimationView.isAttachedToWindow()) {
                                        lottieAnimationView.f14117l = false;
                                        lottieAnimationView.f14113h.F();
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                    break;
                }
                break;
        }
    }
}
