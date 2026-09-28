package com.zeptoconsumerapp.ZeptoImage;

import android.widget.ImageView;
import coil3.util.CoilUtils;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@ReactModule(name = ZeptoImageViewManager.REACT_CLASS)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ZeptoImageViewManager extends SimpleViewManager<ZeptoImageView> implements LifecycleEventListener {

    @NotNull
    public static final String REACT_CLASS = "NativeImageComponent";
    private ZeptoImageView imageView;
    private boolean isAppInBackground;

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final Map<String, ImageView.ScaleType> RESIZE_MODE = MapsKt.h(new Pair("contain", ImageView.ScaleType.FIT_CENTER), new Pair("cover", ImageView.ScaleType.CENTER_CROP), new Pair("stretch", ImageView.ScaleType.FIT_XY), new Pair("center", ImageView.ScaleType.CENTER), new Pair("none", ImageView.ScaleType.MATRIX));

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void loadImage(com.zeptoconsumerapp.ZeptoImage.ZeptoImageView r14) {
        /*
            r13 = this;
            android.content.Context r0 = r14.getContext()
            java.lang.String r1 = "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext"
            kotlin.jvm.internal.Intrinsics.d(r0, r1)
            com.facebook.react.bridge.ReactContext r0 = (com.facebook.react.bridge.ReactContext) r0
            coil3.ImageLoader r1 = coil3.SingletonImageLoader.get(r0)
            com.zeptoconsumerapp.ZeptoImage.ZeptoImageEventListener r2 = new com.zeptoconsumerapp.ZeptoImage.ZeptoImageEventListener
            r2.<init>(r0, r14)
            coil3.memory.MemoryCache$Key r0 = new coil3.memory.MemoryCache$Key
            java.lang.String r3 = r14.getSourceUri()
            r4 = 0
            r5 = 1
            java.lang.String r6 = ""
            if (r3 == 0) goto L50
            boolean r7 = kotlin.text.StringsKt.z(r3)
            if (r7 == 0) goto L27
            goto L50
        L27:
            r7 = 47
            r8 = 6
            int r7 = kotlin.text.StringsKt.B(r3, r7, r4, r8)     // Catch: java.lang.Exception -> L50
            r9 = -1
            if (r7 == r9) goto L50
            int r10 = r3.length()     // Catch: java.lang.Exception -> L50
            int r10 = r10 - r5
            if (r7 != r10) goto L39
            goto L50
        L39:
            int r7 = r7 + r5
            java.lang.String r3 = r3.substring(r7)     // Catch: java.lang.Exception -> L50
            java.lang.String r7 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)     // Catch: java.lang.Exception -> L50
            r7 = 63
            int r7 = kotlin.text.StringsKt.w(r3, r7, r4, r8)     // Catch: java.lang.Exception -> L50
            if (r7 == r9) goto L51
            java.lang.String r3 = kotlin.text.StringsKt.W(r7, r3)     // Catch: java.lang.Exception -> L50
            goto L51
        L50:
            r3 = r6
        L51:
            r7 = 0
            r8 = 2
            r0.<init>(r3, r7, r8, r7)
            coil3.memory.MemoryCache$Key r3 = new coil3.memory.MemoryCache$Key
            java.lang.String r9 = r14.getSourceUri()
            if (r9 == 0) goto L6a
            int r10 = r9.length()
            if (r10 != 0) goto L65
            goto L6a
        L65:
            java.lang.String r9 = com.zeptoconsumerapp.modules.image.ImageUtils.a(r9)
            goto L6b
        L6a:
            r9 = r6
        L6b:
            r3.<init>(r9, r7, r8, r7)
            coil3.memory.MemoryCache r9 = r1.getMemoryCache()
            if (r9 == 0) goto L79
            coil3.memory.MemoryCache$Value r10 = r9.get(r3)
            goto L7a
        L79:
            r10 = r7
        L7a:
            if (r10 == 0) goto L7f
            r0 = r3
        L7d:
            r3 = r7
            goto L8c
        L7f:
            if (r9 == 0) goto L86
            coil3.memory.MemoryCache$Value r9 = r9.get(r0)
            goto L87
        L86:
            r9 = r7
        L87:
            if (r9 == 0) goto L7d
            r12 = r3
            r3 = r0
            r0 = r12
        L8c:
            coil3.request.ImageRequest$Builder r9 = new coil3.request.ImageRequest$Builder
            android.content.Context r10 = r14.getContext()
            java.lang.String r11 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r9.<init>(r10)
            java.lang.String r10 = r14.getSourceUri()
            coil3.request.ImageRequest$Builder r9 = r9.data(r10)
            coil3.request.ImageRequest$Builder r9 = coil3.request.ImageRequests_androidKt.target(r9, r14)
            coil3.size.ViewSizeResolver r7 = coil3.size.ViewSizeResolverKt.ViewSizeResolver$default(r14, r4, r8, r7)
            coil3.request.ImageRequest$Builder r7 = r9.size(r7)
            coil3.request.ImageRequest$Builder r4 = coil3.request.ImageRequests_androidKt.allowHardware(r7, r4)
            java.util.List r7 = r14.getTransformations()
            coil3.request.ImageRequest$Builder r4 = coil3.request.ImageRequests_androidKt.transformations(r4, r7)
            coil3.request.ImageRequest$Builder r4 = coil3.request.ImageRequestsKt.crossfade(r4, r5)
            coil3.request.ImageRequest$Builder r0 = r4.memoryCacheKey(r0)
            coil3.request.ImageRequest$Builder r0 = r0.placeholderMemoryCacheKey(r3)
            java.lang.String r3 = r14.getSourceUri()
            if (r3 == 0) goto Ld7
            int r4 = r3.length()
            if (r4 != 0) goto Ld3
            goto Ld7
        Ld3:
            java.lang.String r6 = com.zeptoconsumerapp.modules.image.ImageUtils.a(r3)
        Ld7:
            coil3.request.ImageRequest$Builder r0 = r0.diskCacheKey(r6)
            android.graphics.drawable.Drawable r14 = r14.getThumbHashDrawable()
            coil3.request.ImageRequest$Builder r14 = coil3.request.ImageRequests_androidKt.placeholder(r0, r14)
            coil3.request.ImageRequest$Builder r14 = r14.listener(r2)
            coil3.request.ImageRequest r14 = r14.build()
            r1.enqueue(r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.ZeptoImage.ZeptoImageViewManager.loadImage(com.zeptoconsumerapp.ZeptoImage.ZeptoImageView):void");
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.h(new Pair("onLoad", MapsKt.g(new Pair("registrationName", "onLoad"))), new Pair("onError", MapsKt.g(new Pair("registrationName", "onError"))), new Pair("onLoadStart", MapsKt.g(new Pair("registrationName", "onLoadStart"))), new Pair("onLoadEnd", MapsKt.g(new Pair("registrationName", "onLoadEnd"))));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        ZeptoImageView zeptoImageView = this.imageView;
        if (zeptoImageView != null) {
            CoilUtils.dispose(zeptoImageView);
        } else {
            Intrinsics.h("imageView");
            throw null;
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        ZeptoImageView zeptoImageView = this.imageView;
        if (zeptoImageView == null) {
            Intrinsics.h("imageView");
            throw null;
        }
        CoilUtils.dispose(zeptoImageView);
        this.isAppInBackground = true;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        if (this.isAppInBackground) {
            ZeptoImageView zeptoImageView = this.imageView;
            if (zeptoImageView == null) {
                Intrinsics.h("imageView");
                throw null;
            }
            loadImage(zeptoImageView);
            this.isAppInBackground = false;
        }
    }

    @ReactProp(name = "resizeMode")
    public final void setResizeMode(@NotNull ZeptoImageView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, ImageView.ScaleType> map = RESIZE_MODE;
        if (str == null) {
            str = "cover";
        }
        view.setScaleType(map.get(str));
    }

    @ReactProp(name = "source")
    public final void setSource(@NotNull ZeptoImageView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSourceUri(str);
    }

    @ReactProp(name = "thumbHash")
    public final void setThumbHashSource(@NotNull ZeptoImageView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setThumbHash(str);
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public final void setTintColor(@NotNull ZeptoImageView view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTintColorValue(num);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ZeptoImageView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        reactContext.addLifecycleEventListener(this);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        ZeptoImageView zeptoImageView = new ZeptoImageView(reactContext, null);
        zeptoImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.imageView = zeptoImageView;
        return zeptoImageView;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull ZeptoImageView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction((ZeptoImageViewManager) view);
        loadImage(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NotNull ZeptoImageView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onDropViewInstance((ZeptoImageViewManager) view);
        CoilUtils.dispose(view);
    }
}
