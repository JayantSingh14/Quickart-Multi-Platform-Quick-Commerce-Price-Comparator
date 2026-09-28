package com.google.android.gms.internal.atv_ads_framework;

import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class zzcv extends zzcd {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f36101b = Logger.getLogger(zzcv.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f36102c = zzfz.f36214e;

    /* renamed from: a, reason: collision with root package name */
    public zzcw f36103a;

    public static int p(int i2, zzeo zzeoVar, zzey zzeyVar) {
        int iA = ((zzca) zzeoVar).a(zzeyVar);
        int iS = s(i2 << 3);
        return iS + iS + iA;
    }

    public static int q(int i2) {
        if (i2 >= 0) {
            return s(i2);
        }
        return 10;
    }

    public static int r(String str) {
        int length;
        try {
            length = zzgd.c(str);
        } catch (zzgc unused) {
            length = str.getBytes(zzdp.f36125a).length;
        }
        return s(length) + length;
    }

    public static int s(int i2) {
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

    public static int t(long j2) {
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
            j2 >>>= 14;
            i2 += 2;
        }
        return (j2 & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public abstract void a(byte b2);

    public abstract void b(int i2, boolean z);

    public abstract void c(int i2, zzcn zzcnVar);

    public abstract void d(int i2, int i3);

    public abstract void e(int i2);

    public abstract void f(int i2, long j2);

    public abstract void g(long j2);

    public abstract void h(int i2, int i3);

    public abstract void i(int i2);

    public abstract void j(int i2, String str);

    public abstract void k(int i2, int i3);

    public abstract void l(int i2, int i3);

    public abstract void m(int i2);

    public abstract void n(int i2, long j2);

    public abstract void o(long j2);
}
