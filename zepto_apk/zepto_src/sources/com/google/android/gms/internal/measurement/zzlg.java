package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class zzlg implements Iterable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final zzlg f37073b = new zzlf(zzmo.f37113b);

    /* renamed from: a, reason: collision with root package name */
    public int f37074a;

    static {
        int i2 = zzku.f37058a;
    }

    public static zzlg k(int i2, byte[] bArr, int i3) {
        m(i2, i2 + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new zzlf(bArr2);
    }

    public static int m(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(e.u(new StringBuilder(String.valueOf(i2).length() + 21), "Beginning index: ", i2, " < 0"));
        }
        if (i3 < i2) {
            throw new IndexOutOfBoundsException(e.n(i2, i3, "Beginning index larger than ending index: ", ", ", new StringBuilder(String.valueOf(i2).length() + 44 + String.valueOf(i3).length())));
        }
        throw new IndexOutOfBoundsException(e.n(i3, i4, "End index: ", " >= ", new StringBuilder(String.valueOf(i3).length() + 15 + String.valueOf(i4).length())));
    }

    public abstract byte b(int i2);

    public abstract byte d(int i2);

    public abstract boolean equals(Object obj);

    public abstract int f();

    public abstract zzlg g();

    public final int hashCode() {
        int iJ = this.f37074a;
        if (iJ == 0) {
            int iF = f();
            iJ = j(iF, iF);
            if (iJ == 0) {
                iJ = 1;
            }
            this.f37074a = iJ;
        }
        return iJ;
    }

    public abstract void i(zzky zzkyVar);

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzkz(this);
    }

    public abstract int j(int i2, int i3);

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iF = f();
        String strA = f() <= 50 ? zzof.a(this) : zzof.a(g()).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iF);
        sb.append(" contents=\"");
        return b.r(sb, strA, "\">");
    }
}
