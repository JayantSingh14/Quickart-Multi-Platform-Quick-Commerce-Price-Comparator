package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public abstract class zzhzq {

    /* renamed from: a, reason: collision with root package name */
    public int f34589a;

    /* renamed from: b, reason: collision with root package name */
    public int f34590b;

    /* renamed from: c, reason: collision with root package name */
    public Object f34591c;

    public static zzhzq d(int i2, byte[] bArr, int i3) {
        zzhzm zzhzmVar = new zzhzm(bArr, i2, i3);
        try {
            zzhzmVar.B(i3);
            return zzhzmVar;
        } catch (zzibg e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int f(int i2) {
        return (i2 >>> 1) ^ (-(i2 & 1));
    }

    public static long g(long j2) {
        return (j2 >>> 1) ^ (-(1 & j2));
    }

    public abstract long A();

    public abstract int B(int i2);

    public abstract void a(int i2);

    public abstract boolean b();

    public abstract int c();

    public final void e() throws zzibg {
        int iH;
        do {
            iH = h();
            if (iH == 0) {
                return;
            }
            int i2 = this.f34589a;
            int i3 = this.f34590b;
            if (i2 + i3 >= 100) {
                throw new zzibg("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.f34590b = i3 + 1;
            this.f34590b--;
        } while (j(iH));
    }

    public abstract int h();

    public abstract void i(int i2);

    public abstract boolean j(int i2);

    public abstract double k();

    public abstract float l();

    public abstract long m();

    public abstract long n();

    public abstract int o();

    public abstract long p();

    public abstract int q();

    public abstract boolean r();

    public abstract String s();

    public abstract String t();

    public abstract zzhzl u();

    public abstract int v();

    public abstract int w();

    public abstract int x();

    public abstract long y();

    public abstract int z();
}
