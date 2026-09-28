package com.google.android.gms.internal.measurement;

import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzll extends zzky {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f37079b = Logger.getLogger(zzll.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f37080c = zzoo.f37198e;

    /* renamed from: a, reason: collision with root package name */
    public zzlm f37081a;

    public static int a(long j2) {
        return (640 - (Long.numberOfLeadingZeros(j2) * 9)) >>> 6;
    }

    public static int b(String str) {
        int length;
        try {
            length = zzor.b(str);
        } catch (zzoq unused) {
            length = str.getBytes(zzmo.f37112a).length;
        }
        return w(length) + length;
    }

    public static int c(zznl zznlVar) {
        int iA = zznlVar.a();
        return w(iA) + iA;
    }

    public static int w(int i2) {
        return (352 - (Integer.numberOfLeadingZeros(i2) * 9)) >>> 6;
    }

    public abstract void d(int i2, int i3);

    public abstract void e(int i2, int i3);

    public abstract void f(int i2, int i3);

    public abstract void g(int i2, int i3);

    public abstract void h(int i2, long j2);

    public abstract void i(int i2, long j2);

    public abstract void j(int i2, boolean z);

    public abstract void k(int i2, String str);

    public abstract void l(int i2, zzlg zzlgVar);

    public abstract void m(zzlg zzlgVar);

    public abstract void n(zznl zznlVar);

    public abstract void o(byte b2);

    public abstract void p(int i2);

    public abstract void q(int i2);

    public abstract void r(int i2);

    public abstract void s(long j2);

    public abstract void t(long j2);

    public abstract void u(String str);

    public abstract int v();
}
