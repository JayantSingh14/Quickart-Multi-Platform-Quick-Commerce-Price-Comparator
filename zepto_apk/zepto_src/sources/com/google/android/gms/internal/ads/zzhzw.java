package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class zzhzw extends zzhzc {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f34603b = Logger.getLogger(zzhzw.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f34604c = zzidm.f34771e;

    /* renamed from: a, reason: collision with root package name */
    public Object f34605a;

    public static int b(int i2) {
        return (352 - (Integer.numberOfLeadingZeros(i2) * 9)) >>> 6;
    }

    public static int c(long j2) {
        return (640 - (Long.numberOfLeadingZeros(j2) * 9)) >>> 6;
    }

    public static int d(String str) {
        int length;
        try {
            length = zzidr.b(str);
        } catch (zzidq unused) {
            length = str.getBytes(zzibe.f34660a).length;
        }
        return b(length) + length;
    }

    public abstract void A(long j2);

    public abstract void B(String str);

    public final void e() {
        if (l() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void f(String str, zzidq zzidqVar) throws zzhzu {
        f34603b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzidqVar);
        byte[] bytes = str.getBytes(zzibe.f34660a);
        try {
            int length = bytes.length;
            x(length);
            a(0, bytes, length);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzhzu(e2);
        }
    }

    public abstract void g(int i2, int i3);

    public abstract void h(int i2, int i3);

    public abstract void i(int i2, int i3);

    public abstract void j(int i2, int i3);

    public abstract void k(int i2, long j2);

    public abstract int l();

    public abstract void m(int i2, long j2);

    public abstract void n(int i2, boolean z);

    public abstract void o(int i2, String str);

    public abstract void p(int i2, zzhzl zzhzlVar);

    public abstract void q(zzhzl zzhzlVar);

    public abstract void r(int i2, byte[] bArr);

    public abstract void s(int i2, zzicc zziccVar);

    public abstract void t(int i2, zzhzl zzhzlVar);

    public abstract void u(zzicc zziccVar);

    public abstract void v(byte b2);

    public abstract void w(int i2);

    public abstract void x(int i2);

    public abstract void y(int i2);

    public abstract void z(long j2);
}
