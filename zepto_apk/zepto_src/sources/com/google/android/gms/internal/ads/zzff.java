package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzff {

    /* renamed from: a, reason: collision with root package name */
    public long[] f30996a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f30997b;

    /* renamed from: c, reason: collision with root package name */
    public int f30998c;

    /* renamed from: d, reason: collision with root package name */
    public int f30999d;

    public zzff() {
        throw null;
    }

    public final synchronized void a(long j2, Object obj) {
        try {
            if (this.f30999d > 0) {
                if (j2 <= this.f30996a[((this.f30998c + r0) - 1) % this.f30997b.length]) {
                    synchronized (this) {
                        this.f30998c = 0;
                        this.f30999d = 0;
                        Arrays.fill(this.f30997b, (Object) null);
                    }
                }
            }
            int length = this.f30997b.length;
            if (this.f30999d >= length) {
                int i2 = length + length;
                long[] jArr = new long[i2];
                Object[] objArr = new Object[i2];
                int i3 = this.f30998c;
                int i4 = length - i3;
                System.arraycopy(this.f30996a, i3, jArr, 0, i4);
                System.arraycopy(this.f30997b, this.f30998c, objArr, 0, i4);
                int i5 = this.f30998c;
                if (i5 > 0) {
                    System.arraycopy(this.f30996a, 0, jArr, i4, i5);
                    System.arraycopy(this.f30997b, 0, objArr, i4, this.f30998c);
                }
                this.f30996a = jArr;
                this.f30997b = objArr;
                this.f30998c = 0;
            }
            int i6 = this.f30998c;
            int i7 = this.f30999d;
            Object[] objArr2 = this.f30997b;
            int length2 = (i6 + i7) % objArr2.length;
            this.f30996a[length2] = j2;
            objArr2[length2] = obj;
            this.f30999d = i7 + 1;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized int b() {
        return this.f30999d;
    }

    public final synchronized Object c() {
        if (this.f30999d == 0) {
            return null;
        }
        return e();
    }

    public final synchronized Object d(long j2) {
        Object objE;
        objE = null;
        while (this.f30999d > 0 && j2 - this.f30996a[this.f30998c] >= 0) {
            objE = e();
        }
        return objE;
    }

    public final Object e() {
        zzgqa.f(this.f30999d > 0);
        Object[] objArr = this.f30997b;
        int i2 = this.f30998c;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f30998c = (i2 + 1) % objArr.length;
        this.f30999d--;
        return obj;
    }

    public zzff(int i2) {
        this.f30996a = new long[10];
        this.f30997b = new Object[10];
    }
}
