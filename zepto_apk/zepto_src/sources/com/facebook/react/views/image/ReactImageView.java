package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.fresco.ImageCacheControl;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReactImageView extends GenericDraweeView {
    public static final Matrix C = new Matrix();
    public float A;
    public ImageResizeMethod B;

    /* renamed from: h, reason: collision with root package name */
    public final AbstractDraweeControllerBuilder f19952h;

    /* renamed from: i, reason: collision with root package name */
    public final GlobalImageLoadListener f19953i;

    /* renamed from: j, reason: collision with root package name */
    public Object f19954j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f19955k;

    /* renamed from: l, reason: collision with root package name */
    public ImageSource f19956l;

    /* renamed from: m, reason: collision with root package name */
    public ImageSource f19957m;
    public Drawable n;
    public AutoRotateDrawable o;
    public int p;
    public ScalingUtils.ScaleType q;
    public Shader.TileMode r;
    public boolean s;
    public TilePostprocessor t;
    public IterativeBoxBlurPostProcessor u;
    public AnonymousClass1 v;
    public ControllerListener w;
    public int x;
    public boolean y;
    public ReadableMap z;

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final GenericDraweeHierarchy a(ThemedReactContext themedReactContext) {
            Matrix matrix = ReactImageView.C;
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(themedReactContext.getResources());
            RoundingParams roundingParams = new RoundingParams();
            if (roundingParams.f17429c == null) {
                roundingParams.f17429c = new float[8];
            }
            Arrays.fill(roundingParams.f17429c, 0.0f);
            roundingParams.f17434h = true;
            genericDraweeHierarchyBuilder.p = roundingParams;
            GenericDraweeHierarchy genericDraweeHierarchyA = genericDraweeHierarchyBuilder.a();
            Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchyA, "build(...)");
            return genericDraweeHierarchyA;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public final class TilePostprocessor extends BasePostprocessor {
        public TilePostprocessor() {
        }

        @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
        public final CloseableReference c(Bitmap source, PlatformBitmapFactory bitmapFactory) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(bitmapFactory, "bitmapFactory");
            ReactImageView reactImageView = ReactImageView.this;
            Rect rect = new Rect(0, 0, reactImageView.getWidth(), reactImageView.getHeight());
            ScalingUtils.ScaleType scaleType = reactImageView.q;
            Matrix matrix = ReactImageView.C;
            scaleType.a(matrix, rect, source.getWidth(), source.getHeight(), 0.0f, 0.0f);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = reactImageView.r;
            BitmapShader bitmapShader = new BitmapShader(source, tileMode, tileMode);
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            int width = reactImageView.getWidth();
            int height = reactImageView.getHeight();
            bitmapFactory.getClass();
            CloseableReference closeableReferenceA = bitmapFactory.a(width, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(closeableReferenceA, "createBitmap(...)");
            try {
                new Canvas((Bitmap) closeableReferenceA.l()).drawRect(rect, paint);
                CloseableReference closeableReferenceClone = closeableReferenceA.clone();
                Intrinsics.checkNotNullExpressionValue(closeableReferenceClone, "clone(...)");
                closeableReferenceA.close();
                return closeableReferenceClone;
            } catch (Throwable th) {
                CloseableReference.e(closeableReferenceA);
                throw th;
            }
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19959a;

        static {
            int[] iArr = new int[ImageCacheControl.values().length];
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f19959a = iArr;
            int[] iArr2 = new int[ImageResizeMethod.values().length];
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ImageResizeMethod imageResizeMethod = ImageResizeMethod.f19945a;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactImageView(ThemedReactContext context, AbstractDraweeControllerBuilder draweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(draweeControllerBuilder, "draweeControllerBuilder");
        GenericDraweeHierarchy genericDraweeHierarchyA = Companion.a(context);
        setHierarchy(genericDraweeHierarchyA);
        this.f19952h = draweeControllerBuilder;
        this.f19953i = globalImageLoadListener;
        this.f19954j = obj;
        this.f19955k = new ArrayList();
        this.q = ImageResizeMode.b();
        ImageResizeMode.a();
        this.r = Shader.TileMode.CLAMP;
        this.x = -1;
        this.A = 1.0f;
        this.B = ImageResizeMethod.f19945a;
        setLegacyVisibilityHandlingEnabled(true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r1.equals(in.juspay.hypersdk.analytics.LogConstants.DEFAULT_CHANNEL) == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.react.modules.fresco.ImageCacheControl d(java.lang.String r1) {
        /*
            if (r1 == 0) goto L39
            int r0 = r1.hashCode()
            switch(r0) {
                case -1564134880: goto L2b;
                case -934641255: goto L1f;
                case 706834161: goto L13;
                case 1544803905: goto La;
                default: goto L9;
            }
        L9:
            goto L33
        La:
            java.lang.String r0 = "default"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L39
            goto L33
        L13:
            java.lang.String r0 = "only-if-cached"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L1c
            goto L33
        L1c:
            com.facebook.react.modules.fresco.ImageCacheControl r1 = com.facebook.react.modules.fresco.ImageCacheControl.f19115d
            return r1
        L1f:
            java.lang.String r0 = "reload"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L28
            goto L33
        L28:
            com.facebook.react.modules.fresco.ImageCacheControl r1 = com.facebook.react.modules.fresco.ImageCacheControl.f19113b
            return r1
        L2b:
            java.lang.String r0 = "force-cache"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L36
        L33:
            com.facebook.react.modules.fresco.ImageCacheControl r1 = com.facebook.react.modules.fresco.ImageCacheControl.f19112a
            return r1
        L36:
            com.facebook.react.modules.fresco.ImageCacheControl r1 = com.facebook.react.modules.fresco.ImageCacheControl.f19114c
            return r1
        L39:
            com.facebook.react.modules.fresco.ImageCacheControl r1 = com.facebook.react.modules.fresco.ImageCacheControl.f19112a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.image.ReactImageView.d(java.lang.String):com.facebook.react.modules.fresco.ImageCacheControl");
    }

    private final ResizeOptions getResizeOptions() {
        int iRound = Math.round(getWidth() * this.A);
        int iRound2 = Math.round(getHeight() * this.A);
        if (iRound <= 0 || iRound2 <= 0) {
            return null;
        }
        return new ResizeOptions(iRound, iRound2);
    }

    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 595
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.image.ReactImageView.e():void");
    }

    @Nullable
    public final ImageSource getImageSource$ReactAndroid_release() {
        return this.f19956l;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        BackgroundStyleApplicator.a(this, canvas);
        try {
            super.onDraw(canvas);
        } catch (RuntimeException throwable) {
            if (this.v != null) {
                Context context = getContext();
                Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                EventDispatcher eventDispatcherB = UIManagerHelper.b((ReactContext) context, getId());
                if (eventDispatcherB != null) {
                    int iE = UIManagerHelper.e(this);
                    int id = getId();
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    eventDispatcherB.g(new ImageLoadEvent(iE, id, 1, throwable.getMessage(), null, 0, 0, 0, 0));
                }
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        boolean z = true;
        if (!this.s && this.f19955k.size() <= 1 && this.r == Shader.TileMode.CLAMP) {
            z = false;
        }
        this.s = z;
        e();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        BackgroundStyleApplicator.i(this, Integer.valueOf(i2));
    }

    public final void setBlurRadius(float f2) {
        int iB = ((int) PixelUtil.b(f2)) / 2;
        this.u = iB == 0 ? null : new IterativeBoxBlurPostProcessor(iB);
        this.s = true;
    }

    public final void setBorderColor(int i2) {
        BackgroundStyleApplicator.k(this, LogicalEdge.f19899b, Integer.valueOf(i2));
    }

    public final void setBorderRadius(float f2) {
        BackgroundStyleApplicator.l(this, BorderRadiusProp.f19836a, Float.isNaN(f2) ? null : new LengthPercentage(PixelUtil.a(f2), LengthPercentageType.f19394a));
    }

    public final void setBorderWidth(float f2) {
        BackgroundStyleApplicator.n(this, LogicalEdge.f19899b, Float.valueOf(f2));
    }

    @VisibleForTesting
    public final void setControllerListener(@Nullable ControllerListener<ImageInfo> controllerListener) {
        this.w = controllerListener;
        this.s = true;
        e();
    }

    public final void setDefaultSource(@Nullable String str) {
        ResourceDrawableIdHelper resourceDrawableIdHelper = ResourceDrawableIdHelper.f19970b;
        ResourceDrawableIdHelper resourceDrawableIdHelperA = ResourceDrawableIdHelper.Companion.a();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Drawable drawableB = resourceDrawableIdHelperA.b(context, str);
        if (Intrinsics.b(this.n, drawableB)) {
            return;
        }
        this.n = drawableB;
        this.s = true;
    }

    public final void setFadeDuration(int i2) {
        this.x = i2;
    }

    public final void setHeaders(@Nullable ReadableMap readableMap) {
        this.z = readableMap;
    }

    public final void setImageSource$ReactAndroid_release(@Nullable ImageSource imageSource) {
        this.f19956l = imageSource;
    }

    public final void setLoadingIndicatorSource(@Nullable String str) {
        ResourceDrawableIdHelper resourceDrawableIdHelper = ResourceDrawableIdHelper.f19970b;
        ResourceDrawableIdHelper resourceDrawableIdHelperA = ResourceDrawableIdHelper.Companion.a();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Drawable drawableB = resourceDrawableIdHelperA.b(context, str);
        AutoRotateDrawable autoRotateDrawable = drawableB != null ? new AutoRotateDrawable(drawableB, 1000) : null;
        if (Intrinsics.b(this.o, autoRotateDrawable)) {
            return;
        }
        this.o = autoRotateDrawable;
        this.s = true;
    }

    public final void setOverlayColor(int i2) {
        if (this.p != i2) {
            this.p = i2;
            this.s = true;
        }
    }

    public final void setProgressiveRenderingEnabled(boolean z) {
        this.y = z;
    }

    public final void setResizeMethod(@NotNull ImageResizeMethod resizeMethod) {
        Intrinsics.checkNotNullParameter(resizeMethod, "resizeMethod");
        if (this.B != resizeMethod) {
            this.B = resizeMethod;
            this.s = true;
        }
    }

    public final void setResizeMultiplier(float f2) {
        if (Math.abs(this.A - f2) > 9.999999747378752E-5d) {
            this.A = f2;
            this.s = true;
        }
    }

    public final void setScaleType(@NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        if (this.q != scaleType) {
            this.q = scaleType;
            this.s = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.facebook.react.views.image.ReactImageView$setShouldNotifyLoadEvents$1] */
    public final void setShouldNotifyLoadEvents(boolean z) {
        if (z == (this.v != null)) {
            return;
        }
        if (z) {
            Context context = getContext();
            Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            final EventDispatcher eventDispatcherB = UIManagerHelper.b((ReactContext) context, getId());
            this.v = new ReactImageDownloadListener<ImageInfo>() { // from class: com.facebook.react.views.image.ReactImageView.setShouldNotifyLoadEvents.1
                @Override // com.facebook.react.views.image.ReactImageDownloadListener, com.facebook.drawee.controller.ControllerListener
                public final void e(String id, Throwable throwable) {
                    Intrinsics.checkNotNullParameter(id, "id");
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    EventDispatcher eventDispatcher = eventDispatcherB;
                    if (eventDispatcher == null) {
                        return;
                    }
                    ReactImageView reactImageView = this;
                    int iE = UIManagerHelper.e(reactImageView);
                    int id2 = reactImageView.getId();
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    eventDispatcher.g(new ImageLoadEvent(iE, id2, 1, throwable.getMessage(), null, 0, 0, 0, 0));
                }

                @Override // com.facebook.react.views.image.ReactImageDownloadListener, com.facebook.drawee.controller.ControllerListener
                public final void l(String id, Object obj, Animatable animatable) {
                    EventDispatcher eventDispatcher;
                    ImageInfo imageInfo = (ImageInfo) obj;
                    Intrinsics.checkNotNullParameter(id, "id");
                    if (imageInfo != null) {
                        ReactImageView reactImageView = this;
                        if (reactImageView.getImageSource$ReactAndroid_release() == null || (eventDispatcher = eventDispatcherB) == null) {
                            return;
                        }
                        int iE = UIManagerHelper.e(reactImageView);
                        int id2 = reactImageView.getId();
                        ImageSource imageSource$ReactAndroid_release = reactImageView.getImageSource$ReactAndroid_release();
                        eventDispatcher.g(new ImageLoadEvent(iE, id2, 2, null, imageSource$ReactAndroid_release != null ? imageSource$ReactAndroid_release.f19963a : null, imageInfo.getWidth(), imageInfo.getHeight(), 0, 0));
                        eventDispatcher.g(new ImageLoadEvent(UIManagerHelper.e(reactImageView), reactImageView.getId(), 3));
                    }
                }

                @Override // com.facebook.react.views.image.ReactImageDownloadListener, com.facebook.drawee.controller.ControllerListener
                public final void n(Object obj, String id) {
                    Intrinsics.checkNotNullParameter(id, "id");
                    EventDispatcher eventDispatcher = eventDispatcherB;
                    if (eventDispatcher == null) {
                        return;
                    }
                    ReactImageView reactImageView = this;
                    eventDispatcher.g(new ImageLoadEvent(UIManagerHelper.e(reactImageView), reactImageView.getId(), 4));
                }

                @Override // com.facebook.react.views.image.ReactImageDownloadListener
                public final void v(int i2) {
                    EventDispatcher eventDispatcher = eventDispatcherB;
                    if (eventDispatcher != null) {
                        ReactImageView reactImageView = this;
                        if (reactImageView.getImageSource$ReactAndroid_release() == null) {
                            return;
                        }
                        int iE = UIManagerHelper.e(reactImageView);
                        int id = reactImageView.getId();
                        ImageSource imageSource$ReactAndroid_release = reactImageView.getImageSource$ReactAndroid_release();
                        eventDispatcher.g(new ImageLoadEvent(iE, id, 5, null, imageSource$ReactAndroid_release != null ? imageSource$ReactAndroid_release.f19963a : null, 0, 0, i2, 10000));
                    }
                }
            };
        } else {
            this.v = null;
        }
        this.s = true;
    }

    public final void setSource(@Nullable ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        if (readableArray == null || readableArray.size() == 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            arrayList.add(ImageSource.Companion.a(context));
        } else {
            if (readableArray.size() == 1) {
                ReadableMap map = readableArray.getMap(0);
                if (map == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                ImageCacheControl imageCacheControlD = d(map.getString("cache"));
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                ImageSource imageSource = new ImageSource(context2, map.getString("uri"), imageCacheControlD, 12);
                if (Intrinsics.b(Uri.EMPTY, imageSource.b())) {
                    map.getString("uri");
                    Context context3 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                    imageSource = ImageSource.Companion.a(context3);
                }
                arrayList.add(imageSource);
            } else {
                int size = readableArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ReadableMap map2 = readableArray.getMap(i2);
                    if (map2 != null) {
                        ImageCacheControl imageCacheControlD2 = d(map2.getString("cache"));
                        Context context4 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                        ImageSource imageSource2 = new ImageSource(context4, map2.getString("uri"), map2.getDouble(Snapshot.WIDTH), map2.getDouble(Snapshot.HEIGHT), imageCacheControlD2);
                        if (Intrinsics.b(Uri.EMPTY, imageSource2.b())) {
                            map2.getString("uri");
                            Context context5 = getContext();
                            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                            imageSource2 = ImageSource.Companion.a(context5);
                        }
                        arrayList.add(imageSource2);
                    }
                }
            }
        }
        ArrayList arrayList2 = this.f19955k;
        if (Intrinsics.b(arrayList2, arrayList)) {
            return;
        }
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        this.s = true;
    }

    public final void setTileMode(@NotNull Shader.TileMode tileMode) {
        Intrinsics.checkNotNullParameter(tileMode, "tileMode");
        if (this.r != tileMode) {
            this.r = tileMode;
            this.t = tileMode != Shader.TileMode.CLAMP ? new TilePostprocessor() : null;
            this.s = true;
        }
    }
}
