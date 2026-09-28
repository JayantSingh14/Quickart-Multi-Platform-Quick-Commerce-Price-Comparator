package com.google.android.gms.internal.pal;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes4.dex */
public abstract class zzaby implements Iterable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final zzaby f37363b = new zzabv(zzadg.f37411b);

    /* renamed from: a, reason: collision with root package name */
    public int f37364a;

    static {
        int i2 = zzabk.f37351a;
    }

    public static int p(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.g(i2, "Beginning index: ", " < 0"));
        }
        if (i3 < i2) {
            throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, i3, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i3, i4, "End index: ", " >= "));
    }

    public static zzaby q(int i2, byte[] bArr, int i3) {
        p(i2, i2 + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new zzabv(bArr2);
    }

    public abstract byte b(int i2);

    public abstract byte d(int i2);

    public abstract boolean equals(Object obj);

    public abstract int f();

    public abstract void g(int i2, byte[] bArr);

    public final int hashCode() {
        int i2 = this.f37364a;
        if (i2 == 0) {
            int iF = f();
            i2 = i(iF, iF);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f37364a = i2;
        }
        return i2;
    }

    public abstract int i(int i2, int i3);

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzabp(this);
    }

    public abstract zzaby j();

    public abstract zzacc k();

    public abstract String m(Charset charset);

    public abstract void n(zzabo zzaboVar);

    public abstract boolean o();

    public final byte[] r() {
        int iF = f();
        if (iF == 0) {
            return zzadg.f37411b;
        }
        byte[] bArr = new byte[iF];
        g(iF, bArr);
        return bArr;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iF = f();
        String strA = f() <= 50 ? zzafg.a(this) : zzafg.a(j()).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iF);
        sb.append(" contents=\"");
        return android.support.v4.media.b.r(sb, strA, "\">");
    }
}
