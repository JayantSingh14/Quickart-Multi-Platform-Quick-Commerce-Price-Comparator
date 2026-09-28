package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

@DoNotStrip
@ThreadSafe
@TargetApi(19)
@Nullsafe
/* loaded from: classes3.dex */
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {

    /* renamed from: c, reason: collision with root package name */
    public final FlexByteArrayPool f18079c;

    @DoNotStrip
    public KitKatPurgeableDecoder(FlexByteArrayPool flexByteArrayPool) {
        this.f18079c = flexByteArrayPool;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public final Bitmap c(CloseableReference closeableReference, BitmapFactory.Options options) {
        ((PooledByteBuffer) closeableReference.l()).size();
        this.f18079c.getClass();
        throw null;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public final Bitmap d(CloseableReference closeableReference, int i2, BitmapFactory.Options options) {
        DalvikPurgeableDecoder.e(closeableReference, i2);
        if (!(i2 <= ((PooledByteBuffer) closeableReference.l()).size())) {
            throw new IllegalArgumentException();
        }
        this.f18079c.getClass();
        throw null;
    }
}
