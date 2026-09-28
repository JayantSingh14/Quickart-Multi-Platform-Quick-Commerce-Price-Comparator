package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzcfl {
    public static final boolean r;

    /* renamed from: a, reason: collision with root package name */
    public final Context f26098a;

    /* renamed from: b, reason: collision with root package name */
    public final String f26099b;

    /* renamed from: c, reason: collision with root package name */
    public final VersionInfoParcel f26100c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbgw f26101d;

    /* renamed from: e, reason: collision with root package name */
    public final zzbgz f26102e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzbf f26103f;

    /* renamed from: g, reason: collision with root package name */
    public final long[] f26104g;

    /* renamed from: h, reason: collision with root package name */
    public final String[] f26105h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f26106i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f26107j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f26108k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f26109l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f26110m;
    public zzceq n;
    public boolean o;
    public boolean p;
    public long q;

    static {
        r = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21146e.nextInt(100) < ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Pd)).intValue();
    }

    public zzcfl(Context context, VersionInfoParcel versionInfoParcel, String str, zzbgz zzbgzVar, zzbgw zzbgwVar) {
        com.google.android.gms.ads.internal.util.zzbe zzbeVar = new com.google.android.gms.ads.internal.util.zzbe();
        zzbeVar.a("min_1", Double.MIN_VALUE, 1.0d);
        zzbeVar.a("1_5", 1.0d, 5.0d);
        zzbeVar.a("5_10", 5.0d, 10.0d);
        zzbeVar.a("10_20", 10.0d, 20.0d);
        zzbeVar.a("20_30", 20.0d, 30.0d);
        zzbeVar.a("30_max", 30.0d, Double.MAX_VALUE);
        this.f26103f = new com.google.android.gms.ads.internal.util.zzbf(zzbeVar);
        this.f26106i = false;
        this.f26107j = false;
        this.f26108k = false;
        this.f26109l = false;
        this.q = -1L;
        this.f26098a = context;
        this.f26100c = versionInfoParcel;
        this.f26099b = str;
        this.f26102e = zzbgzVar;
        this.f26101d = zzbgwVar;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Z);
        if (str2 == null) {
            this.f26105h = new String[0];
            this.f26104g = new long[0];
            return;
        }
        String[] strArrSplit = TextUtils.split(str2, ",");
        int length = strArrSplit.length;
        this.f26105h = new String[length];
        this.f26104g = new long[length];
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            try {
                this.f26104g[i2] = Long.parseLong(strArrSplit[i2]);
            } catch (NumberFormatException e2) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Unable to parse frame hash target time number.", e2);
                this.f26104g[i2] = -1;
            }
        }
    }

    public final void a(zzceq zzceqVar) {
        zzbgz zzbgzVar = this.f26102e;
        zzbgr.a(zzbgzVar, this.f26101d, "vpc2");
        this.f26106i = true;
        zzbgzVar.c("vpn", zzceqVar.h());
        this.n = zzceqVar;
    }

    public final void b() {
        if (!r || this.o) {
            return;
        }
        Bundle bundleI = androidx.fragment.app.e.i("type", "native-player-metrics");
        bundleI.putString("request", this.f26099b);
        bundleI.putString("player", this.n.h());
        com.google.android.gms.ads.internal.util.zzbf zzbfVar = this.f26103f;
        zzbfVar.getClass();
        String[] strArr = zzbfVar.f21525a;
        ArrayList arrayList = new ArrayList(strArr.length);
        int i2 = 0;
        while (i2 < strArr.length) {
            String str = strArr[i2];
            double d2 = zzbfVar.f21527c[i2];
            double d3 = zzbfVar.f21526b[i2];
            int i3 = zzbfVar.f21528d[i2];
            arrayList.add(new com.google.android.gms.ads.internal.util.zzbd(str, d2, d3, i3 / zzbfVar.f21529e, i3));
            i2++;
            strArr = strArr;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.google.android.gms.ads.internal.util.zzbd zzbdVar = (com.google.android.gms.ads.internal.util.zzbd) it.next();
            String str2 = zzbdVar.f21517a;
            bundleI.putString("fps_c_".concat(String.valueOf(str2)), Integer.toString(zzbdVar.f21521e));
            bundleI.putString("fps_p_".concat(String.valueOf(str2)), Double.toString(zzbdVar.f21520d));
        }
        int i4 = 0;
        while (true) {
            long[] jArr = this.f26104g;
            if (i4 >= jArr.length) {
                com.google.android.gms.ads.internal.zzt.C.f21679c.G(this.f26098a, this.f26100c.f21400a, bundleI);
                this.o = true;
                return;
            }
            String str3 = this.f26105h[i4];
            if (str3 != null) {
                Long lValueOf = Long.valueOf(jArr[i4]);
                new StringBuilder(lValueOf.toString().length() + 3);
                bundleI.putString("fh_".concat(lValueOf.toString()), str3);
            }
            i4++;
        }
    }

    public final void c(zzceq zzceqVar) {
        if (this.f26108k && !this.f26109l) {
            if (com.google.android.gms.ads.internal.util.zze.m() && !this.f26109l) {
                com.google.android.gms.ads.internal.util.zze.k("VideoMetricsMixin first frame");
            }
            zzbgr.a(this.f26102e, this.f26101d, "vff2");
            this.f26109l = true;
        }
        long jNanoTime = com.google.android.gms.ads.internal.zzt.C.f21687k.nanoTime();
        if (this.f26110m && this.p && this.q != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L) / (jNanoTime - this.q);
            com.google.android.gms.ads.internal.util.zzbf zzbfVar = this.f26103f;
            zzbfVar.f21529e++;
            int i2 = 0;
            while (true) {
                double[] dArr = zzbfVar.f21527c;
                if (i2 >= dArr.length) {
                    break;
                }
                double d2 = dArr[i2];
                if (d2 <= nanos && nanos < zzbfVar.f21526b[i2]) {
                    int[] iArr = zzbfVar.f21528d;
                    iArr[i2] = iArr[i2] + 1;
                }
                if (nanos < d2) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.p = this.f26110m;
        this.q = jNanoTime;
        long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.a0)).longValue();
        long jP = zzceqVar.p();
        int i3 = 0;
        while (true) {
            String[] strArr = this.f26105h;
            if (i3 >= strArr.length) {
                return;
            }
            if (strArr[i3] == null && jLongValue > Math.abs(jP - this.f26104g[i3])) {
                int i4 = 8;
                Bitmap bitmap = zzceqVar.getBitmap(8, 8);
                long j2 = 63;
                int i5 = 0;
                long j3 = 0;
                while (i5 < i4) {
                    int i6 = 0;
                    while (i6 < i4) {
                        int pixel = bitmap.getPixel(i6, i5);
                        j3 |= (Color.green(pixel) + (Color.red(pixel) + Color.blue(pixel)) > 128 ? 1L : 0L) << ((int) j2);
                        j2--;
                        i6++;
                        i4 = 8;
                    }
                    i5++;
                    i4 = 8;
                }
                strArr[i3] = String.format("%016X", Long.valueOf(j3));
                return;
            }
            i3++;
        }
    }

    public final void d() {
        this.f26110m = true;
        if (!this.f26107j || this.f26108k) {
            return;
        }
        zzbgr.a(this.f26102e, this.f26101d, "vfp2");
        this.f26108k = true;
    }
}
