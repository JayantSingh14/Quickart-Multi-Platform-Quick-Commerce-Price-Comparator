package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.PorterDuff;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.views.image.ImageLoadEvent;
import com.horcrux.svg.events.SvgLoadEvent;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = ReactImageManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class ReactImageManager extends SimpleViewManager<ReactImageView> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String ON_ERROR = "onError";

    @NotNull
    private static final String ON_LOAD = "onLoad";

    @NotNull
    private static final String ON_LOAD_END = "onLoadEnd";

    @NotNull
    private static final String ON_LOAD_START = "onLoadStart";

    @NotNull
    private static final String ON_PROGRESS = "onProgress";

    @NotNull
    public static final String REACT_CLASS = "RCTImageView";

    @NotNull
    private static final String REGISTRATION_NAME = "registrationName";

    @Nullable
    private Object callerContext;

    @Nullable
    private final ReactCallerContextFactory callerContextFactory;

    @Nullable
    private final AbstractDraweeControllerBuilder<?, ?, ?, ?> draweeControllerBuilder;

    @Nullable
    private final GlobalImageLoadListener globalImageLoadListener;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public ReactImageManager() {
        this(null, null, null, 7, null);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new LinkedHashMap<>();
        }
        exportedCustomDirectEventTypeConstants.put(ImageLoadEvent.Companion.a(4), MapsKt.g(new Pair(REGISTRATION_NAME, ON_LOAD_START)));
        exportedCustomDirectEventTypeConstants.put(ImageLoadEvent.Companion.a(5), MapsKt.g(new Pair(REGISTRATION_NAME, ON_PROGRESS)));
        exportedCustomDirectEventTypeConstants.put(SvgLoadEvent.EVENT_NAME, MapsKt.g(new Pair(REGISTRATION_NAME, ON_LOAD)));
        exportedCustomDirectEventTypeConstants.put("topError", MapsKt.g(new Pair(REGISTRATION_NAME, ON_ERROR)));
        exportedCustomDirectEventTypeConstants.put("topLoadEnd", MapsKt.g(new Pair(REGISTRATION_NAME, ON_LOAD_END)));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "accessible")
    public final void setAccessible(@NotNull ReactImageView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFocusable(z);
    }

    @ReactProp(name = "blurRadius")
    public final void setBlurRadius(@NotNull ReactImageView view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBlurRadius(f2);
    }

    @ReactProp(customType = "Color", name = "borderColor")
    public final void setBorderColor(@NotNull ReactImageView view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.k(view, LogicalEdge.f19899b, num);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {Snapshot.BORDER_RADIUS, Snapshot.BORDER_TOP_LEFT_RADIUS, Snapshot.BORDER_TOP_RIGHT_RADIUS, Snapshot.BORDER_BOTTOM_RIGHT_RADIUS, Snapshot.BORDER_BOTTOM_LEFT_RADIUS})
    public final void setBorderRadius(@NotNull ReactImageView view, int i2, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.l(view, BorderRadiusProp.values()[i2], Float.isNaN(f2) ? null : new LengthPercentage(f2, LengthPercentageType.f19394a));
    }

    @ReactProp(name = "borderWidth")
    public final void setBorderWidth(@NotNull ReactImageView view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.n(view, LogicalEdge.f19899b, Float.valueOf(f2));
    }

    @ReactProp(name = "defaultSource")
    public final void setDefaultSource(@NotNull ReactImageView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setDefaultSource(str);
    }

    @ReactProp(name = "fadeDuration")
    public final void setFadeDuration(@NotNull ReactImageView view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFadeDuration(i2);
    }

    @ReactProp(name = "headers")
    public final void setHeaders(@NotNull ReactImageView view, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableMap != null) {
            view.setHeaders(readableMap);
        }
    }

    @ReactProp(name = "internal_analyticTag")
    public final void setInternal_AnalyticsTag(@NotNull ReactImageView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        ReactCallerContextFactory reactCallerContextFactory = this.callerContextFactory;
        if (reactCallerContextFactory != null) {
            Context context = view.getContext();
            Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
            Object objA = reactCallerContextFactory.a();
            if (Intrinsics.b(view.f19954j, objA)) {
                return;
            }
            view.f19954j = objA;
            view.s = true;
        }
    }

    @ReactProp(name = "shouldNotifyLoadEvents")
    public final void setLoadHandlersRegistered(@NotNull ReactImageView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setShouldNotifyLoadEvents(z);
    }

    @ReactProp(name = "loadingIndicatorSrc")
    public final void setLoadingIndicatorSource(@NotNull ReactImageView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLoadingIndicatorSource(str);
    }

    @ReactProp(customType = "Color", name = "overlayColor")
    public final void setOverlayColor(@NotNull ReactImageView view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (num == null) {
            view.setOverlayColor(0);
        } else {
            view.setOverlayColor(num.intValue());
        }
    }

    @ReactProp(name = "progressiveRenderingEnabled")
    public final void setProgressiveRenderingEnabled(@NotNull ReactImageView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setProgressiveRenderingEnabled(z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        if (r3.equals("auto") == false) goto L22;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "resizeMethod")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setResizeMethod(@org.jetbrains.annotations.NotNull com.facebook.react.views.image.ReactImageView r2, @org.jetbrains.annotations.Nullable java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L62
            int r0 = r3.hashCode()
            switch(r0) {
                case -934437708: goto L36;
                case 3005871: goto L2d;
                case 3387192: goto L1e;
                case 109250890: goto Lf;
                default: goto Le;
            }
        Le:
            goto L3e
        Lf:
            java.lang.String r0 = "scale"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L18
            goto L3e
        L18:
            com.facebook.react.views.image.ImageResizeMethod r3 = com.facebook.react.views.image.ImageResizeMethod.f19947c
            r2.setResizeMethod(r3)
            return
        L1e:
            java.lang.String r0 = "none"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L27
            goto L3e
        L27:
            com.facebook.react.views.image.ImageResizeMethod r3 = com.facebook.react.views.image.ImageResizeMethod.f19948d
            r2.setResizeMethod(r3)
            return
        L2d:
            java.lang.String r0 = "auto"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L62
            goto L3e
        L36:
            java.lang.String r0 = "resize"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L5c
        L3e:
            com.facebook.react.views.image.ImageResizeMethod r0 = com.facebook.react.views.image.ImageResizeMethod.f19945a
            r2.setResizeMethod(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid resize method: '"
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r3 = "'"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "ReactNative"
            com.facebook.common.logging.FLog.q(r3, r2)
            return
        L5c:
            com.facebook.react.views.image.ImageResizeMethod r3 = com.facebook.react.views.image.ImageResizeMethod.f19946b
            r2.setResizeMethod(r3)
            return
        L62:
            com.facebook.react.views.image.ImageResizeMethod r3 = com.facebook.react.views.image.ImageResizeMethod.f19945a
            r2.setResizeMethod(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.image.ReactImageManager.setResizeMethod(com.facebook.react.views.image.ReactImageView, java.lang.String):void");
    }

    @ReactProp(name = "resizeMode")
    public final void setResizeMode(@NotNull ReactImageView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScaleType(ImageResizeMode.c(str));
        view.setTileMode(ImageResizeMode.d(str));
    }

    @ReactProp(name = "resizeMultiplier")
    public final void setResizeMultiplier(@NotNull ReactImageView view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (f2 < 0.01f) {
            FLog.q("ReactNative", "Invalid resize multiplier: '" + f2 + "'");
        }
        view.setResizeMultiplier(f2);
    }

    @ReactProp(name = "source")
    public final void setSource(@NotNull ReactImageView view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSource(readableArray);
    }

    @ReactProp(name = "src")
    public final void setSrc(@NotNull ReactImageView view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        setSource(view, readableArray);
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public final void setTintColor(@NotNull ReactImageView view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (num == null) {
            view.clearColorFilter();
        } else {
            view.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @JvmOverloads
    public ReactImageManager(@Nullable AbstractDraweeControllerBuilder<?, ?, ?, ?> abstractDraweeControllerBuilder) {
        this(abstractDraweeControllerBuilder, null, null, 6, null);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactImageView createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object objA = this.callerContext;
        if (objA == null) {
            ReactCallerContextFactory reactCallerContextFactory = this.callerContextFactory;
            if (reactCallerContextFactory != null) {
                String str = context.f19480b;
                objA = reactCallerContextFactory.a();
            } else {
                objA = null;
            }
        }
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.draweeControllerBuilder;
        if (abstractDraweeControllerBuilder == null) {
            abstractDraweeControllerBuilder = Fresco.f17198a.get();
        }
        return new ReactImageView(context, abstractDraweeControllerBuilder, this.globalImageLoadListener, objA);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull ReactImageView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction((ReactImageManager) view);
        view.e();
    }

    @JvmOverloads
    public ReactImageManager(@Nullable AbstractDraweeControllerBuilder<?, ?, ?, ?> abstractDraweeControllerBuilder, @Nullable GlobalImageLoadListener globalImageLoadListener) {
        this(abstractDraweeControllerBuilder, globalImageLoadListener, null, 4, null);
    }

    public /* synthetic */ ReactImageManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, ReactCallerContextFactory reactCallerContextFactory, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((AbstractDraweeControllerBuilder<?, ?, ?, ?>) ((i2 & 1) != 0 ? null : abstractDraweeControllerBuilder), (i2 & 2) != 0 ? null : globalImageLoadListener, (i2 & 4) != 0 ? null : reactCallerContextFactory);
    }

    @JvmOverloads
    public ReactImageManager(@Nullable AbstractDraweeControllerBuilder<?, ?, ?, ?> abstractDraweeControllerBuilder, @Nullable GlobalImageLoadListener globalImageLoadListener, @Nullable ReactCallerContextFactory reactCallerContextFactory) {
        this.draweeControllerBuilder = abstractDraweeControllerBuilder;
        this.globalImageLoadListener = globalImageLoadListener;
        this.callerContextFactory = reactCallerContextFactory;
    }

    @Deprecated
    public ReactImageManager(@Nullable AbstractDraweeControllerBuilder<?, ?, ?, ?> abstractDraweeControllerBuilder, @Nullable Object obj) {
        this(abstractDraweeControllerBuilder, (GlobalImageLoadListener) null, (ReactCallerContextFactory) null);
        this.callerContext = obj;
    }

    @Deprecated
    public ReactImageManager(@Nullable AbstractDraweeControllerBuilder<?, ?, ?, ?> abstractDraweeControllerBuilder, @Nullable GlobalImageLoadListener globalImageLoadListener, @Nullable Object obj) {
        this(abstractDraweeControllerBuilder, globalImageLoadListener, (ReactCallerContextFactory) null);
        this.callerContext = obj;
    }
}
