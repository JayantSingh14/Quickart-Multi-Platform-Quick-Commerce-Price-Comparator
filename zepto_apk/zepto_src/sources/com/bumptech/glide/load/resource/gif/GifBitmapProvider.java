package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;

/* loaded from: classes3.dex */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {

    /* renamed from: a, reason: collision with root package name */
    public final BitmapPool f16349a;

    /* renamed from: b, reason: collision with root package name */
    public final LruArrayPool f16350b;

    public GifBitmapProvider(BitmapPool bitmapPool, LruArrayPool lruArrayPool) {
        this.f16349a = bitmapPool;
        this.f16350b = lruArrayPool;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final void a(Bitmap bitmap) {
        this.f16349a.b(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final byte[] b(int i2) {
        LruArrayPool lruArrayPool = this.f16350b;
        return lruArrayPool == null ? new byte[i2] : (byte[]) lruArrayPool.d(byte[].class, i2);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final Bitmap c(int i2, int i3, Bitmap.Config config) {
        return this.f16349a.a(i2, i3, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final int[] d(int i2) {
        LruArrayPool lruArrayPool = this.f16350b;
        return lruArrayPool == null ? new int[i2] : (int[]) lruArrayPool.d(int[].class, i2);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final void e(byte[] bArr) {
        LruArrayPool lruArrayPool = this.f16350b;
        if (lruArrayPool == null) {
            return;
        }
        lruArrayPool.i(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final void f(int[] iArr) {
        LruArrayPool lruArrayPool = this.f16350b;
        if (lruArrayPool == null) {
            return;
        }
        lruArrayPool.i(iArr);
    }
}
