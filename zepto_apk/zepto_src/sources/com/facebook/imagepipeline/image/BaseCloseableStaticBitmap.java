package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes3.dex */
public class BaseCloseableStaticBitmap extends BaseCloseableImage implements CloseableStaticBitmap {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f17948i = 0;

    /* renamed from: d, reason: collision with root package name */
    public CloseableReference f17949d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Bitmap f17950e;

    /* renamed from: f, reason: collision with root package name */
    public final QualityInfo f17951f;

    /* renamed from: g, reason: collision with root package name */
    public final int f17952g;

    /* renamed from: h, reason: collision with root package name */
    public final int f17953h;

    public BaseCloseableStaticBitmap(Bitmap bitmap, SimpleBitmapReleaser simpleBitmapReleaser, ImmutableQualityInfo immutableQualityInfo) {
        this.f17950e = bitmap;
        Bitmap bitmap2 = this.f17950e;
        simpleBitmapReleaser.getClass();
        this.f17949d = CloseableReference.T(bitmap2, simpleBitmapReleaser, CloseableReference.f17108f);
        this.f17951f = immutableQualityInfo;
        this.f17952g = 0;
        this.f17953h = 0;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public final int B0() {
        return BitmapUtil.d(this.f17950e);
    }

    @Override // com.facebook.imagepipeline.image.CloseableStaticBitmap
    public final synchronized CloseableReference G() {
        return CloseableReference.c(this.f17949d);
    }

    @Override // com.facebook.imagepipeline.image.CloseableStaticBitmap
    public final int H0() {
        return this.f17953h;
    }

    @Override // com.facebook.imagepipeline.image.CloseableStaticBitmap
    public final int X0() {
        return this.f17952g;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        CloseableReference closeableReference;
        synchronized (this) {
            closeableReference = this.f17949d;
            this.f17949d = null;
            this.f17950e = null;
        }
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public final int getHeight() {
        int i2;
        if (this.f17952g % 180 != 0 || (i2 = this.f17953h) == 5 || i2 == 7) {
            Bitmap bitmap = this.f17950e;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getWidth();
        }
        Bitmap bitmap2 = this.f17950e;
        if (bitmap2 == null) {
            return 0;
        }
        return bitmap2.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public final int getWidth() {
        int i2;
        if (this.f17952g % 180 != 0 || (i2 = this.f17953h) == 5 || i2 == 7) {
            Bitmap bitmap = this.f17950e;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight();
        }
        Bitmap bitmap2 = this.f17950e;
        if (bitmap2 == null) {
            return 0;
        }
        return bitmap2.getWidth();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public final synchronized boolean isClosed() {
        return this.f17949d == null;
    }

    @Override // com.facebook.imagepipeline.image.BaseCloseableImage, com.facebook.imagepipeline.image.CloseableImage
    public final QualityInfo q1() {
        return this.f17951f;
    }

    @Override // com.facebook.imagepipeline.image.CloseableBitmap
    public final Bitmap v1() {
        return this.f17950e;
    }

    public BaseCloseableStaticBitmap(CloseableReference closeableReference, QualityInfo qualityInfo, int i2, int i3) {
        CloseableReference closeableReferenceB = closeableReference.b();
        closeableReferenceB.getClass();
        this.f17949d = closeableReferenceB;
        this.f17950e = (Bitmap) closeableReferenceB.l();
        this.f17951f = qualityInfo;
        this.f17952g = i2;
        this.f17953h = i3;
    }
}
