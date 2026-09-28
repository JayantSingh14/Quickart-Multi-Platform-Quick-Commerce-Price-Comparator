package com.google.android.gms.internal.auth;

import android.support.v4.media.b;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes4.dex */
public abstract class zzef implements Iterable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final zzef f36336b = new zzec(zzfa.f36356b);

    /* renamed from: a, reason: collision with root package name */
    public int f36337a;

    static {
        int i2 = zzds.f36325a;
    }

    public static int m(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(b.g(i2, "Beginning index: ", " < 0"));
        }
        if (i3 < i2) {
            throw new IndexOutOfBoundsException(b.d(i2, i3, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(b.d(i3, i4, "End index: ", " >= "));
    }

    public static zzef n(int i2, byte[] bArr, int i3) {
        m(i2, i2 + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new zzec(bArr2);
    }

    public abstract byte b(int i2);

    public abstract byte d(int i2);

    public abstract boolean equals(Object obj);

    public abstract int f();

    public abstract int g(int i2, int i3);

    public final int hashCode() {
        int iG = this.f36337a;
        if (iG == 0) {
            int iF = f();
            iG = g(iF, iF);
            if (iG == 0) {
                iG = 1;
            }
            this.f36337a = iG;
        }
        return iG;
    }

    public abstract zzef i();

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzdw(this);
    }

    public abstract String j(Charset charset);

    public abstract boolean k();

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iF = f();
        String strA = f() <= 50 ? zzgx.a(this) : zzgx.a(i()).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iF);
        sb.append(" contents=\"");
        return b.r(sb, strA, "\">");
    }
}
