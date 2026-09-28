package androidx.media3.common.util;

import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class TimedValueQueue<V> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f5736a = new long[10];

    /* renamed from: b, reason: collision with root package name */
    public Object[] f5737b = new Object[10];

    /* renamed from: c, reason: collision with root package name */
    public int f5738c;

    /* renamed from: d, reason: collision with root package name */
    public int f5739d;

    public final synchronized void a(long j2, Object obj) {
        if (this.f5739d > 0) {
            if (j2 <= this.f5736a[((this.f5738c + r0) - 1) % this.f5737b.length]) {
                b();
            }
        }
        c();
        int i2 = this.f5738c;
        int i3 = this.f5739d;
        Object[] objArr = this.f5737b;
        int length = (i2 + i3) % objArr.length;
        this.f5736a[length] = j2;
        objArr[length] = obj;
        this.f5739d = i3 + 1;
    }

    public final synchronized void b() {
        this.f5738c = 0;
        this.f5739d = 0;
        Arrays.fill(this.f5737b, (Object) null);
    }

    public final void c() {
        int length = this.f5737b.length;
        if (this.f5739d < length) {
            return;
        }
        int i2 = length * 2;
        long[] jArr = new long[i2];
        Object[] objArr = new Object[i2];
        int i3 = this.f5738c;
        int i4 = length - i3;
        System.arraycopy(this.f5736a, i3, jArr, 0, i4);
        System.arraycopy(this.f5737b, this.f5738c, objArr, 0, i4);
        int i5 = this.f5738c;
        if (i5 > 0) {
            System.arraycopy(this.f5736a, 0, jArr, i4, i5);
            System.arraycopy(this.f5737b, 0, objArr, i4, this.f5738c);
        }
        this.f5736a = jArr;
        this.f5737b = objArr;
        this.f5738c = 0;
    }

    public final Object d(long j2, boolean z) {
        Object objG = null;
        long j3 = Long.MAX_VALUE;
        while (this.f5739d > 0) {
            long j4 = j2 - this.f5736a[this.f5738c];
            if (j4 < 0 && (z || (-j4) >= j3)) {
                break;
            }
            objG = g();
            j3 = j4;
        }
        return objG;
    }

    public final synchronized Object e() {
        return this.f5739d == 0 ? null : g();
    }

    public final synchronized Object f(long j2) {
        return d(j2, true);
    }

    public final Object g() {
        Assertions.g(this.f5739d > 0);
        Object[] objArr = this.f5737b;
        int i2 = this.f5738c;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f5738c = (i2 + 1) % objArr.length;
        this.f5739d--;
        return obj;
    }

    public final synchronized int h() {
        return this.f5739d;
    }
}
