package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class LruBitmapPool implements BitmapPool {

    /* renamed from: j, reason: collision with root package name */
    public static final Bitmap.Config f16064j = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    public final SizeConfigStrategy f16065a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f16066b;

    /* renamed from: c, reason: collision with root package name */
    public final NullBitmapTracker f16067c;

    /* renamed from: d, reason: collision with root package name */
    public final long f16068d;

    /* renamed from: e, reason: collision with root package name */
    public long f16069e;

    /* renamed from: f, reason: collision with root package name */
    public int f16070f;

    /* renamed from: g, reason: collision with root package name */
    public int f16071g;

    /* renamed from: h, reason: collision with root package name */
    public int f16072h;

    /* renamed from: i, reason: collision with root package name */
    public int f16073i;

    public interface BitmapTracker {
    }

    public static final class NullBitmapTracker implements BitmapTracker {
    }

    public static class ThrowingBitmapTracker implements BitmapTracker {
    }

    public LruBitmapPool(long j2) {
        SizeConfigStrategy sizeConfigStrategy = new SizeConfigStrategy();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i2 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f16068d = j2;
        this.f16065a = sizeConfigStrategy;
        this.f16066b = setUnmodifiableSet;
        this.f16067c = new NullBitmapTracker();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public final Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapG = g(i2, i3, config);
        if (bitmapG != null) {
            return bitmapG;
        }
        if (config == null) {
            config = f16064j;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public final synchronized void b(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.f16065a.getClass();
                if (Util.c(bitmap) <= this.f16068d && this.f16066b.contains(bitmap.getConfig())) {
                    this.f16065a.getClass();
                    int iC = Util.c(bitmap);
                    this.f16065a.f(bitmap);
                    this.f16067c.getClass();
                    this.f16072h++;
                    this.f16069e += iC;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb = new StringBuilder("Put bitmap in pool=");
                        this.f16065a.getClass();
                        sb.append(SizeConfigStrategy.c(Util.c(bitmap), bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb.toString());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        f();
                    }
                    h(this.f16068d);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder("Reject bitmap from pool, bitmap: ");
                this.f16065a.getClass();
                sb2.append(SizeConfigStrategy.c(Util.c(bitmap), bitmap.getConfig()));
                sb2.append(", is mutable: ");
                sb2.append(bitmap.isMutable());
                sb2.append(", is allowed config: ");
                sb2.append(this.f16066b.contains(bitmap.getConfig()));
                Log.v("LruBitmapPool", sb2.toString());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public final void c(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 40 || i2 >= 20) {
            d();
        } else if (i2 >= 20 || i2 == 15) {
            h(this.f16068d / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public final void d() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        h(0L);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public final Bitmap e(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapG = g(i2, i3, config);
        if (bitmapG != null) {
            bitmapG.eraseColor(0);
            return bitmapG;
        }
        if (config == null) {
            config = f16064j;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    public final void f() {
        Log.v("LruBitmapPool", "Hits=" + this.f16070f + ", misses=" + this.f16071g + ", puts=" + this.f16072h + ", evictions=" + this.f16073i + ", currentSize=" + this.f16069e + ", maxSize=" + this.f16068d + "\nStrategy=" + this.f16065a);
    }

    public final synchronized Bitmap g(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapB;
        try {
            if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
            bitmapB = this.f16065a.b(i2, i3, config != null ? config : f16064j);
            if (bitmapB == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f16065a.e(i2, i3, config));
                }
                this.f16071g++;
            } else {
                this.f16070f++;
                long j2 = this.f16069e;
                this.f16065a.getClass();
                this.f16069e = j2 - Util.c(bitmapB);
                this.f16067c.getClass();
                bitmapB.setHasAlpha(true);
                bitmapB.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f16065a.e(i2, i3, config));
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bitmapB;
    }

    public final synchronized void h(long j2) {
        while (this.f16069e > j2) {
            try {
                SizeConfigStrategy sizeConfigStrategy = this.f16065a;
                Bitmap bitmap = (Bitmap) sizeConfigStrategy.f16080b.c();
                if (bitmap != null) {
                    sizeConfigStrategy.a(Integer.valueOf(Util.c(bitmap)), bitmap);
                }
                if (bitmap == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        f();
                    }
                    this.f16069e = 0L;
                    return;
                }
                this.f16067c.getClass();
                long j3 = this.f16069e;
                this.f16065a.getClass();
                this.f16069e = j3 - Util.c(bitmap);
                this.f16073i++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    this.f16065a.getClass();
                    sb.append(SizeConfigStrategy.c(Util.c(bitmap), bitmap.getConfig()));
                    Log.d("LruBitmapPool", sb.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    f();
                }
                bitmap.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
