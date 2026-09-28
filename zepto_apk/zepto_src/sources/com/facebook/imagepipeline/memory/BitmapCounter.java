package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class BitmapCounter {

    /* renamed from: a, reason: collision with root package name */
    public int f17993a;

    /* renamed from: b, reason: collision with root package name */
    public long f17994b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17995c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17996d;

    /* renamed from: e, reason: collision with root package name */
    public final ResourceReleaser f17997e;

    public BitmapCounter(int i2, int i3) {
        if (!(i2 > 0)) {
            throw new IllegalArgumentException();
        }
        if (!(i3 > 0)) {
            throw new IllegalArgumentException();
        }
        this.f17995c = i2;
        this.f17996d = i3;
        this.f17997e = new ResourceReleaser<Bitmap>() { // from class: com.facebook.imagepipeline.memory.BitmapCounter.1
            @Override // com.facebook.common.references.ResourceReleaser
            public final void a(Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                try {
                    BitmapCounter.this.a(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public final synchronized void a(Bitmap bitmap) {
        int iD = BitmapUtil.d(bitmap);
        Preconditions.b(this.f17993a > 0, "No bitmaps registered.");
        long j2 = iD;
        Preconditions.c(j2 <= this.f17994b, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(iD), Long.valueOf(this.f17994b));
        this.f17994b -= j2;
        this.f17993a--;
    }

    public final synchronized int b() {
        return this.f17996d;
    }
}
