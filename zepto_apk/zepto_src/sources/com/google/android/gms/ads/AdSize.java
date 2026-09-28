package com.google.android.gms.ads;

import android.support.v4.media.a;
import androidx.fragment.app.e;
import com.amazon.identity.auth.device.authorization.RegionUtil;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public final class AdSize {

    /* renamed from: h, reason: collision with root package name */
    public static final AdSize f20998h = new AdSize(320, 50, "320x50_mb");

    /* renamed from: i, reason: collision with root package name */
    public static final AdSize f20999i = new AdSize(468, 60, "468x60_as");

    /* renamed from: j, reason: collision with root package name */
    public static final AdSize f21000j = new AdSize(320, 100, "320x100_as");

    /* renamed from: k, reason: collision with root package name */
    public static final AdSize f21001k = new AdSize(728, 90, "728x90_as");

    /* renamed from: l, reason: collision with root package name */
    public static final AdSize f21002l = new AdSize(300, Type.TSIG, "300x250_as");

    /* renamed from: m, reason: collision with root package name */
    public static final AdSize f21003m = new AdSize(160, 600, "160x600_as");
    public static final AdSize n = new AdSize(-1, -2, "smart_banner");
    public static final AdSize o = new AdSize(-3, -4, "fluid");
    public static final AdSize p = new AdSize(0, 0, "invalid");
    public static final AdSize q = new AdSize(50, 50, "50x50_mb");

    /* renamed from: a, reason: collision with root package name */
    public final int f21004a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21005b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21006c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21007d;

    /* renamed from: e, reason: collision with root package name */
    public int f21008e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21009f;

    /* renamed from: g, reason: collision with root package name */
    public int f21010g;

    static {
        new AdSize(-3, 0, "search_v2");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AdSize(int i2, int i3) {
        String strValueOf = i2 == -1 ? "FULL" : String.valueOf(i2);
        String strValueOf2 = i3 == -2 ? RegionUtil.REGION_STRING_AUTO : String.valueOf(i3);
        this(i2, i3, a.n(new StringBuilder(String.valueOf(strValueOf2).length() + String.valueOf(strValueOf).length() + 1 + 3), strValueOf, "x", strValueOf2, "_as"));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.ads.AdSize a(int r2, android.content.Context r3) {
        /*
            com.google.android.gms.internal.ads.zzfxl r0 = com.google.android.gms.ads.internal.util.client.zzf.f21413b
            r0 = -1
            if (r3 != 0) goto L6
            goto L2d
        L6:
            android.content.Context r1 = r3.getApplicationContext()
            if (r1 == 0) goto L10
            android.content.Context r3 = r3.getApplicationContext()
        L10:
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L2d
            android.util.DisplayMetrics r1 = r3.getDisplayMetrics()
            if (r1 == 0) goto L2d
            android.content.res.Configuration r3 = r3.getConfiguration()
            if (r3 == 0) goto L2d
            int r3 = r1.heightPixels
            float r3 = (float) r3
            float r1 = r1.density
            float r3 = r3 / r1
            int r3 = java.lang.Math.round(r3)
            goto L2e
        L2d:
            r3 = r0
        L2e:
            if (r3 != r0) goto L33
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.p
            return r2
        L33:
            com.google.android.gms.ads.AdSize r0 = new com.google.android.gms.ads.AdSize
            r1 = 0
            r0.<init>(r2, r1)
            r0.f21008e = r3
            r2 = 1
            r0.f21007d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.a(int, android.content.Context):com.google.android.gms.ads.AdSize");
    }

    public final int b() {
        return this.f21005b;
    }

    public final int c() {
        return this.f21004a;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.f21004a == adSize.f21004a && this.f21005b == adSize.f21005b && this.f21006c.equals(adSize.f21006c);
    }

    public final int hashCode() {
        return this.f21006c.hashCode();
    }

    public final String toString() {
        return this.f21006c;
    }

    public AdSize(int i2, int i3, String str) {
        if (i2 < 0 && i2 != -1 && i2 != -3) {
            throw new IllegalArgumentException(e.r(new StringBuilder(String.valueOf(i2).length() + 26), i2, "Invalid width for AdSize: "));
        }
        if (i3 < 0 && i3 != -2 && i3 != -4) {
            throw new IllegalArgumentException(e.r(new StringBuilder(String.valueOf(i3).length() + 27), i3, "Invalid height for AdSize: "));
        }
        this.f21004a = i2;
        this.f21005b = i3;
        this.f21006c = str;
    }
}
