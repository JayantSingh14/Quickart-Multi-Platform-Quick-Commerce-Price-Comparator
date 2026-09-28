package com.google.android.gms.internal.pal;

import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class zzach extends zzabo {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f37380b = Logger.getLogger(zzach.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f37381c = zzafs.f37502e;

    /* renamed from: a, reason: collision with root package name */
    public zzaci f37382a;

    public static int a(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int b(long j2) {
        int i2;
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if (((-34359738368L) & j2) != 0) {
            j2 >>>= 28;
            i2 = 6;
        } else {
            i2 = 2;
        }
        if (((-2097152) & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public static int r(int i2, zzaef zzaefVar, zzaer zzaerVar) {
        int iA = a(i2 << 3);
        int i3 = iA + iA;
        zzabi zzabiVar = (zzabi) zzaefVar;
        int iB = zzabiVar.b();
        if (iB == -1) {
            iB = zzaerVar.zza(zzabiVar);
            zzabiVar.c(iB);
        }
        return i3 + iB;
    }

    public static int s(int i2) {
        if (i2 >= 0) {
            return a(i2);
        }
        return 10;
    }

    public static int t(String str) {
        int length;
        try {
            length = zzafx.c(str);
        } catch (zzafw unused) {
            length = str.getBytes(zzadg.f37410a).length;
        }
        return a(length) + length;
    }

    public static int u(int i2) {
        return a(i2 << 3);
    }

    public abstract void c(byte b2);

    public abstract void d(int i2, boolean z);

    public abstract void e(int i2, zzaby zzabyVar);

    public abstract void f(int i2, int i3);

    public abstract void g(int i2);

    public abstract void h(int i2, long j2);

    public abstract void i(long j2);

    public abstract void j(int i2, int i3);

    public abstract void k(int i2);

    public abstract void l(int i2, String str);

    public abstract void m(int i2, int i3);

    public abstract void n(int i2, int i3);

    public abstract void o(int i2);

    public abstract void p(int i2, long j2);

    public abstract void q(long j2);
}
