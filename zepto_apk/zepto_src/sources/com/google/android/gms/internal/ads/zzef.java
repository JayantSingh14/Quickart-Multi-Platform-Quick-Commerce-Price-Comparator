package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzef {

    /* renamed from: a, reason: collision with root package name */
    public int f29201a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f29202b;

    public zzef() {
        this(32);
    }

    public final void a() {
        int i2 = this.f29201a;
        long[] jArr = this.f29202b;
        if (i2 == jArr.length) {
            this.f29202b = Arrays.copyOf(jArr, i2 + i2);
        }
        long[] jArr2 = this.f29202b;
        int i3 = this.f29201a;
        this.f29201a = i3 + 1;
        jArr2[i3] = 0;
    }

    public final void b(long[] jArr) {
        int i2 = this.f29201a;
        int length = jArr.length;
        int i3 = i2 + length;
        long[] jArr2 = this.f29202b;
        int length2 = jArr2.length;
        if (i3 > length2) {
            this.f29202b = Arrays.copyOf(jArr2, Math.max(length2 + length2, i3));
        }
        System.arraycopy(jArr, 0, this.f29202b, this.f29201a, length);
        this.f29201a = i3;
    }

    public final long c(int i2) {
        if (i2 >= 0 && i2 < this.f29201a) {
            return this.f29202b[i2];
        }
        int i3 = this.f29201a;
        throw new IndexOutOfBoundsException(androidx.fragment.app.e.n(i2, i3, "Invalid index ", ", size is ", new StringBuilder(String.valueOf(i2).length() + 24 + String.valueOf(i3).length())));
    }

    public zzef(int i2) {
        this.f29202b = new long[i2];
    }
}
