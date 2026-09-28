package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
abstract class zzidf {
    public abstract void a(Object obj, int i2, long j2);

    public abstract void b(int i2, int i3, Object obj);

    public abstract void c(Object obj, int i2, long j2);

    public abstract void d(Object obj, int i2, zzhzl zzhzlVar);

    public abstract void e(int i2, Object obj, Object obj2);

    public abstract zzidg f();

    public abstract zzidg g(Object obj);

    public final boolean h(int i2, zzhzr zzhzrVar, Object obj) throws zzibg {
        int i3 = zzhzrVar.f34593b;
        int i4 = i3 >>> 3;
        int i5 = i3 & 7;
        if (i5 == 0) {
            a(obj, i4, zzhzrVar.C());
            return true;
        }
        if (i5 == 1) {
            c(obj, i4, zzhzrVar.E());
            return true;
        }
        if (i5 == 2) {
            d(obj, i4, zzhzrVar.L());
            return true;
        }
        if (i5 != 3) {
            if (i5 == 4) {
                if (i2 != 0) {
                    return false;
                }
                throw new zzibg("Protocol message end-group tag did not match expected tag.");
            }
            if (i5 != 5) {
                throw new zzibf();
            }
            b(i4, zzhzrVar.F(), obj);
            return true;
        }
        zzidg zzidgVarF = f();
        int i6 = i4 << 3;
        int i7 = i2 + 1;
        if (i7 >= 100) {
            throw new zzibg("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzhzrVar.y() != Integer.MAX_VALUE && h(i7, zzhzrVar, zzidgVarF)) {
        }
        if ((i6 | 4) != zzhzrVar.f34593b) {
            throw new zzibg("Protocol message end-group tag did not match expected tag.");
        }
        e(i4, obj, g(zzidgVarF));
        return true;
    }
}
