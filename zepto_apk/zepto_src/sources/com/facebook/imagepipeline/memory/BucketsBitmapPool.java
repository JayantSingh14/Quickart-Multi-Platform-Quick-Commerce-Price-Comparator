package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@TargetApi(21)
@Nullsafe
/* loaded from: classes.dex */
public class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    public BucketsBitmapPool(NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistry, PoolParams poolParams, NoOpPoolStatsTracker noOpPoolStatsTracker) {
        super(noOpMemoryTrimmableRegistry, poolParams, noOpPoolStatsTracker);
        noOpMemoryTrimmableRegistry.getClass();
        noOpPoolStatsTracker.getClass();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final Object e(int i2) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final void g(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        bitmap.getClass();
        bitmap.recycle();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int i(int i2) {
        return i2;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int j(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        bitmap.getClass();
        return bitmap.getAllocationByteCount();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int k(int i2) {
        return i2;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final Object l(Bucket bucket) {
        Bitmap bitmap = (Bitmap) super.l(bucket);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final boolean n(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        bitmap.getClass();
        return !bitmap.isRecycled() && bitmap.isMutable();
    }
}
