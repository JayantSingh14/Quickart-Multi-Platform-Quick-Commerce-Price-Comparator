package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.views.imagehelper.ImageSource;
import com.horcrux.svg.events.SvgLoadEvent;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class ImageView extends RenderableView {

    /* renamed from: a, reason: collision with root package name */
    public SVGLength f45753a;

    /* renamed from: b, reason: collision with root package name */
    public SVGLength f45754b;

    /* renamed from: c, reason: collision with root package name */
    public SVGLength f45755c;

    /* renamed from: d, reason: collision with root package name */
    public SVGLength f45756d;

    /* renamed from: e, reason: collision with root package name */
    public String f45757e;

    /* renamed from: f, reason: collision with root package name */
    public int f45758f;

    /* renamed from: g, reason: collision with root package name */
    public int f45759g;

    /* renamed from: h, reason: collision with root package name */
    public String f45760h;

    /* renamed from: i, reason: collision with root package name */
    public int f45761i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f45762j;

    public ImageView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f45762j = new AtomicBoolean(false);
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final void draw(Canvas canvas, Paint paint, float f2) {
        boolean z;
        AtomicBoolean atomicBoolean = this.f45762j;
        if (atomicBoolean.get()) {
            return;
        }
        ImagePipeline imagePipelineA = Fresco.a();
        ImageRequest imageRequest = ImageRequest.a(new ImageSource(this.mContext, this.f45757e).b());
        if (imageRequest == null) {
            imagePipelineA.getClass();
            z = false;
        } else {
            CloseableReference closeableReference = imagePipelineA.f17826f.get(imagePipelineA.f17828h.a(imageRequest, null));
            try {
                boolean zA = CloseableReference.A(closeableReference);
                CloseableReference.e(closeableReference);
                z = zA;
            } catch (Throwable th) {
                CloseableReference.e(closeableReference);
                throw th;
            }
        }
        if (!z) {
            atomicBoolean.set(true);
            AbstractDataSource abstractDataSourceB = imagePipelineA.b(imageRequest, this.mContext, null, null, null);
            BaseBitmapDataSubscriber baseBitmapDataSubscriber = new BaseBitmapDataSubscriber() { // from class: com.horcrux.svg.ImageView.1
                @Override // com.facebook.datasource.BaseDataSubscriber
                public final void e(DataSource dataSource) {
                    ImageView.this.f45762j.set(false);
                    FLog.t("ReactNative", dataSource.d(), "RNSVG: fetchDecodedImage failed!", new Object[0]);
                }

                @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
                public final void g(Bitmap bitmap) {
                    ImageView imageView = ImageView.this;
                    UIManagerHelper.b(imageView.mContext, imageView.getId()).g(new SvgLoadEvent(UIManagerHelper.e(imageView), imageView.getId(), imageView.mContext, imageView.f45757e, bitmap.getWidth(), bitmap.getHeight()));
                    imageView.f45762j.set(false);
                    SvgView svgView = imageView.getSvgView();
                    if (svgView != null) {
                        svgView.invalidate();
                    }
                }
            };
            if (UiThreadImmediateExecutorService.f17074b == null) {
                UiThreadImmediateExecutorService.f17074b = new UiThreadImmediateExecutorService(new Handler(Looper.getMainLooper()));
            }
            abstractDataSourceB.g(baseBitmapDataSubscriber, UiThreadImmediateExecutorService.f17074b);
            return;
        }
        float f3 = f2 * this.mOpacity;
        ReactContext reactContext = this.mContext;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
        Intrinsics.checkNotNullParameter(lowestPermittedRequestLevelOnSubmit, "lowestPermittedRequestLevelOnSubmit");
        CancellationException cancellationException = ImagePipeline.n;
        AbstractDataSource abstractDataSourceB2 = imagePipelineA.b(imageRequest, reactContext, lowestPermittedRequestLevelOnSubmit, null, null);
        try {
            try {
                CloseableReference closeableReference2 = (CloseableReference) abstractDataSourceB2.a();
                try {
                    if (closeableReference2 == null) {
                        abstractDataSourceB2.close();
                        return;
                    }
                    try {
                        CloseableImage closeableImage = (CloseableImage) closeableReference2.l();
                        if (!(closeableImage instanceof CloseableBitmap)) {
                            CloseableReference.e(closeableReference2);
                            abstractDataSourceB2.close();
                            return;
                        }
                        Bitmap bitmapV1 = ((CloseableBitmap) closeableImage).v1();
                        if (bitmapV1 == null) {
                            CloseableReference.e(closeableReference2);
                            abstractDataSourceB2.close();
                        } else {
                            j(canvas, paint, bitmapV1, f3);
                            CloseableReference.e(closeableReference2);
                            abstractDataSourceB2.close();
                        }
                    } catch (Exception e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (Throwable th2) {
                    CloseableReference.e(closeableReference2);
                    throw th2;
                }
            } catch (Throwable th3) {
                abstractDataSourceB2.close();
                throw th3;
            }
        } catch (Exception e3) {
            throw new IllegalStateException(e3);
        }
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        this.mPath = path;
        path.addRect(k(), Path.Direction.CW);
        return this.mPath;
    }

    public final void j(Canvas canvas, Paint paint, Bitmap bitmap, float f2) {
        if (this.f45758f == 0 || this.f45759g == 0) {
            this.f45758f = bitmap.getWidth();
            this.f45759g = bitmap.getHeight();
        }
        RectF rectFK = k();
        RectF rectF = new RectF(0.0f, 0.0f, this.f45758f, this.f45759g);
        ViewBox.a(rectF, rectFK, this.f45760h, this.f45761i).mapRect(rectF);
        canvas.clipPath(getPath(canvas, paint));
        Path clipPath = getClipPath(canvas, paint);
        if (clipPath != null) {
            canvas.clipPath(clipPath);
        }
        Paint paint2 = new Paint();
        paint2.setAlpha((int) (f2 * 255.0f));
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint2);
        this.mCTM.mapRect(rectF);
        setClientRect(rectF);
    }

    public final RectF k() {
        double dRelativeOnWidth = relativeOnWidth(this.f45753a);
        double dRelativeOnHeight = relativeOnHeight(this.f45754b);
        double dRelativeOnWidth2 = relativeOnWidth(this.f45755c);
        double dRelativeOnHeight2 = relativeOnHeight(this.f45756d);
        if (dRelativeOnWidth2 == 0.0d) {
            dRelativeOnWidth2 = this.f45758f * this.mScale;
        }
        if (dRelativeOnHeight2 == 0.0d) {
            dRelativeOnHeight2 = this.f45759g * this.mScale;
        }
        return new RectF((float) dRelativeOnWidth, (float) dRelativeOnHeight, (float) (dRelativeOnWidth + dRelativeOnWidth2), (float) (dRelativeOnHeight + dRelativeOnHeight2));
    }
}
