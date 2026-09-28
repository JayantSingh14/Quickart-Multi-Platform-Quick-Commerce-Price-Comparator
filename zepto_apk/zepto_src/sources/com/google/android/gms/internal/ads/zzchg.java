package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public final class zzchg extends zzcgx implements zzcfa {

    /* renamed from: d, reason: collision with root package name */
    public zzchz f26243d;

    /* renamed from: e, reason: collision with root package name */
    public String f26244e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f26245f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f26246g;

    /* renamed from: h, reason: collision with root package name */
    public zzcgp f26247h;

    /* renamed from: i, reason: collision with root package name */
    public long f26248i;

    /* renamed from: j, reason: collision with root package name */
    public long f26249j;

    public static final String s(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.d(str, MessageDigestAlgorithms.MD5)));
    }

    public static String t(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(str.length() + 1 + length + 1 + String.valueOf(message).length());
        android.support.v4.media.b.B(sb, str, "/", canonicalName, ":");
        sb.append(message);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void K(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void a(final long j2, final boolean z) {
        final zzcfk zzcfkVar = (zzcfk) this.f26217c.get();
        if (zzcfkVar != null) {
            ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchf
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    boolean z2 = z;
                    zzcfkVar.R(j2, z2);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void b(int i2, int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void c(String str, Exception exc) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.g("Precache error", exc);
        com.google.android.gms.ads.internal.zzt.C.f21684h.e("VideoStreamExoPlayerCache.onError", exc);
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void d(IOException iOException) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.g("Precache exception", iOException);
        com.google.android.gms.ads.internal.zzt.C.f21684h.e("VideoStreamExoPlayerCache.onException", iOException);
    }

    @Override // com.google.android.gms.internal.ads.zzcgx
    public final boolean e(String str) {
        return f(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15, types: [long] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // com.google.android.gms.internal.ads.zzcgx
    public final boolean f(String str, String[] strArr) throws Throwable {
        String str2;
        zzchg zzchgVar;
        Clock clock;
        String str3;
        String str4;
        long j2;
        long j3;
        ?? r4;
        ?? r2;
        long j4;
        long j5;
        long j6;
        long j7;
        boolean z;
        zzchg zzchgVar2 = this;
        String str5 = str;
        zzchgVar2.f26244e = str5;
        String strS = s(str5);
        String str6 = " ms";
        String str7 = "Timeout reached. Limit: ";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                uriArr[i2] = Uri.parse(strArr[i2]);
            }
            zzchgVar2.f26243d.y(uriArr, zzchgVar2.f26216b);
            zzcfk zzcfkVar = (zzcfk) zzchgVar2.f26217c.get();
            if (zzcfkVar != null) {
                zzcfkVar.T(strS, zzchgVar2);
            }
            Clock clock2 = com.google.android.gms.ads.internal.zzt.C.f21687k;
            long jCurrentTimeMillis = clock2.currentTimeMillis();
            zzbgb zzbgbVar = zzbgk.X;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            long jLongValue = ((Long) zzbdVar.f21153c.a(zzbgbVar)).longValue();
            long jLongValue2 = ((Long) zzbdVar.f21153c.a(zzbgk.W)).longValue() * 1000;
            long jIntValue = ((Integer) zzbdVar.f21153c.a(zzbgk.w)).intValue();
            boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgk.l2)).booleanValue();
            long j8 = -1;
            while (true) {
                synchronized (this) {
                    try {
                        if (clock2.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                            String str8 = str7;
                            long j9 = jLongValue2;
                            StringBuilder sb = new StringBuilder(String.valueOf(j9).length() + 27);
                            sb.append(str8);
                            sb.append(j9);
                            sb.append(str6);
                            throw new IOException(sb.toString());
                        }
                        if (zzchgVar2.f26245f) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (zzchgVar2.f26246g) {
                            return true;
                        }
                        if (!zzchgVar2.f26243d.p()) {
                            throw new IOException("ExoPlayer was released during preloading.");
                        }
                        long jC = zzchgVar2.f26243d.f26309i.c();
                        if (jC > 0) {
                            Clock clock3 = clock2;
                            long jE = zzchgVar2.f26243d.f26309i.e();
                            if (jE != j8) {
                                if (jE > 0) {
                                    j7 = jC;
                                    z = true;
                                } else {
                                    j7 = jC;
                                    z = false;
                                }
                                long jT = zBooleanValue ? zzchgVar2.f26243d.t() : -1L;
                                long jU = zBooleanValue ? zzchgVar2.f26243d.u() : -1L;
                                long jV = zBooleanValue ? zzchgVar2.f26243d.v() : -1L;
                                try {
                                    int i3 = zzcfb.f26058a.get();
                                    int i4 = zzcfb.f26059b.get();
                                    zzfxl zzfxlVar = com.google.android.gms.ads.internal.util.client.zzf.f21413b;
                                    str3 = str6;
                                    str4 = str7;
                                    j5 = jLongValue;
                                    j2 = jLongValue2;
                                    clock = clock3;
                                    j3 = jIntValue;
                                    zzcgs zzcgsVar = new zzcgs(zzchgVar2, str5, strS, jE, j7, jT, jU, jV, z, i3, i4);
                                    j6 = jE;
                                    r4 = j7;
                                    zzfxlVar.post(zzcgsVar);
                                    j8 = j6;
                                } catch (Throwable th) {
                                    th = th;
                                    zzchgVar = this;
                                    str2 = strS;
                                    strS = str;
                                }
                            } else {
                                str3 = str6;
                                str4 = str7;
                                j5 = jLongValue;
                                j3 = jIntValue;
                                r4 = jC;
                                j6 = jE;
                                j2 = jLongValue2;
                                clock = clock3;
                            }
                            r2 = (j6 > r4 ? 1 : (j6 == r4 ? 0 : -1));
                            if (r2 >= 0) {
                                com.google.android.gms.ads.internal.util.client.zzf.f21413b.post(new zzcgv(this, str, strS, r4));
                                return true;
                            }
                            try {
                                zzchg zzchgVar3 = this;
                                r4 = strS;
                                strS = str;
                                if (zzchgVar3.f26243d.f26313m >= j3 && j6 > 0) {
                                    return true;
                                }
                                j4 = j5;
                                r2 = zzchgVar3;
                            } catch (Throwable th2) {
                                th = th2;
                                zzchgVar = r2;
                                str2 = r4;
                            }
                        } else {
                            clock = clock2;
                            str3 = str6;
                            str4 = str7;
                            j2 = jLongValue2;
                            j3 = jIntValue;
                            r4 = strS;
                            strS = str5;
                            r2 = zzchgVar2;
                            j4 = jLongValue;
                        }
                        try {
                            r2.wait(j4);
                        } catch (InterruptedException unused) {
                            throw new IOException("Wait interrupted.");
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = strS;
                        strS = str5;
                        zzchgVar = zzchgVar2;
                    }
                }
                try {
                    throw th;
                } catch (Exception e2) {
                    e = e2;
                    String message = e.getMessage();
                    String strN = android.support.v4.media.a.n(new StringBuilder(String.valueOf(strS).length() + 34 + String.valueOf(message).length()), "Failed to preload url ", strS, " Exception: ", message);
                    int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f(strN);
                    com.google.android.gms.ads.internal.zzt.C.f21684h.e("VideoStreamExoPlayerCache.preload", e);
                    zzchgVar.release();
                    zzchgVar.q(strS, str2, "error", t("error", e));
                    return false;
                }
                jLongValue = j4;
                zzchgVar2 = r2;
                str5 = strS;
                strS = r4;
                clock2 = clock;
                jLongValue2 = j2;
                jIntValue = j3;
                str6 = str3;
                str7 = str4;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = strS;
            strS = str5;
            zzchgVar = zzchgVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgx
    public final boolean h(String str, String[] strArr, zzcgp zzcgpVar) {
        this.f26244e = str;
        this.f26247h = zzcgpVar;
        String strS = s(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                uriArr[i2] = Uri.parse(strArr[i2]);
            }
            this.f26243d.y(uriArr, this.f26216b);
            zzcfk zzcfkVar = (zzcfk) this.f26217c.get();
            if (zzcfkVar != null) {
                zzcfkVar.T(strS, this);
            }
            this.f26248i = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
            this.f26249j = -1L;
            com.google.android.gms.ads.internal.util.zzs.f21608l.postDelayed(new zzche(this), 0L);
            return true;
        } catch (Exception e2) {
            String message = e2.getMessage();
            String strN = android.support.v4.media.a.n(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length()), "Failed to preload url ", str, " Exception: ", message);
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f(strN);
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("VideoStreamExoPlayerCache.preload", e2);
            release();
            q(str, strS, "error", t("error", e2));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgx
    public final void i(int i2) {
        this.f26243d.s(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgx
    public final void j(int i2) {
        this.f26243d.r(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void k() {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Precache onRenderedFirstFrame");
    }

    @Override // com.google.android.gms.internal.ads.zzcgx
    public final void n(int i2) {
        this.f26243d.C(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgx
    public final void o(int i2) {
        this.f26243d.D(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgx
    public final void p() {
        synchronized (this) {
            this.f26245f = true;
            notify();
            release();
        }
        String str = this.f26244e;
        if (str != null) {
            q(this.f26244e, s(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgx, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzchz zzchzVar = this.f26243d;
        if (zzchzVar != null) {
            zzchzVar.f26312l = null;
            zzchzVar.A();
        }
    }
}
