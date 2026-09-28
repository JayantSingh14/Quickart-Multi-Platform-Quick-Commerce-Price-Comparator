package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes4.dex */
public abstract class zzcn implements Iterable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final zzcn f36095b = new zzck(zzdp.f36126b);

    /* renamed from: a, reason: collision with root package name */
    public int f36096a;

    static {
        int i2 = zzcc.f36089a;
    }

    public static void n(int i2) {
        if (((i2 - 47) | 47) < 0) {
            throw new IndexOutOfBoundsException(b.f(i2, "End index: 47 >= "));
        }
    }

    public abstract byte b(int i2);

    public abstract byte d(int i2);

    public abstract boolean equals(Object obj);

    public abstract int f();

    public abstract int g(int i2, int i3);

    public final int hashCode() {
        int iG = this.f36096a;
        if (iG == 0) {
            int iF = f();
            iG = g(iF, iF);
            if (iG == 0) {
                iG = 1;
            }
            this.f36096a = iG;
        }
        return iG;
    }

    public abstract zzcn i();

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzce(this);
    }

    public abstract String j(Charset charset);

    public abstract void k(zzcd zzcdVar);

    public abstract boolean m();

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iF = f();
        String strA = f() <= 50 ? zzfn.a(this) : zzfn.a(i()).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iF);
        sb.append(" contents=\"");
        return b.r(sb, strA, "\">");
    }
}
