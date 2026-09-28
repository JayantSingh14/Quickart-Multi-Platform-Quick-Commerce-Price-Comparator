package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ThreadSafe
@Metadata
@TargetApi(21)
/* loaded from: classes.dex */
public final class ArtBitmapFactory extends PlatformBitmapFactory {

    /* renamed from: a, reason: collision with root package name */
    public final BitmapPool f17715a;

    /* renamed from: b, reason: collision with root package name */
    public final CloseableReferenceFactory f17716b;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        this.f17715a = bitmapPool;
        this.f17716b = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public final CloseableReference a(int i2, int i3, Bitmap.Config bitmapConfig) {
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        int iC = BitmapUtil.c(i2, i3, bitmapConfig);
        BitmapPool bitmapPool = this.f17715a;
        Bitmap bitmap = (Bitmap) bitmapPool.get(iC);
        if (bitmap.getAllocationByteCount() < BitmapUtil.b(bitmapConfig) * i2 * i3) {
            throw new IllegalStateException("Check failed.");
        }
        bitmap.reconfigure(i2, i3, bitmapConfig);
        DefaultCloseableReference defaultCloseableReferenceT = CloseableReference.T(bitmap, bitmapPool, this.f17716b.f17793a);
        Intrinsics.checkNotNullExpressionValue(defaultCloseableReferenceT, "create(...)");
        return defaultCloseableReferenceT;
    }
}
