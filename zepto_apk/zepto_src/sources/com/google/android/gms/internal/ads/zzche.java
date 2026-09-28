package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzche implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzchg f26239a;

    public /* synthetic */ zzche(zzchg zzchgVar) {
        this.f26239a = zzchgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.client.zzbd zzbdVar;
        long jLongValue;
        long jIntValue;
        boolean zBooleanValue;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar2;
        long j2;
        long j3;
        long j4;
        zzchg zzchgVar = this.f26239a;
        String strS = zzchg.s(zzchgVar.f26244e);
        try {
            zzbgb zzbgbVar = zzbgk.W;
            zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            jLongValue = ((Long) zzbdVar.f21153c.a(zzbgbVar)).longValue() * 1000;
            jIntValue = ((Integer) zzbdVar.f21153c.a(zzbgk.w)).intValue();
            zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgk.l2)).booleanValue();
        } catch (Exception e2) {
            String str = zzchgVar.f26244e;
            String message = e2.getMessage();
            String strN = android.support.v4.media.a.n(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length()), "Failed to preload url ", str, " Exception: ", message);
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f(strN);
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("VideoStreamExoPlayerCache.preload", e2);
            zzchgVar.release();
            zzchgVar.q(zzchgVar.f26244e, strS, "error", zzchg.t("error", e2));
        }
        synchronized (zzchgVar) {
            try {
                if (com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - zzchgVar.f26248i > jLongValue) {
                    StringBuilder sb = new StringBuilder(String.valueOf(jLongValue).length() + 27);
                    sb.append("Timeout reached. Limit: ");
                    sb.append(jLongValue);
                    sb.append(" ms");
                    throw new IOException(sb.toString());
                }
                if (zzchgVar.f26245f) {
                    throw new IOException("Abort requested before buffering finished. ");
                }
                if (!zzchgVar.f26246g) {
                    if (!zzchgVar.f26243d.p()) {
                        throw new IOException("ExoPlayer was released during preloading.");
                    }
                    long jC = zzchgVar.f26243d.f26309i.c();
                    if (jC > 0) {
                        long jE = zzchgVar.f26243d.f26309i.e();
                        if (jE != zzchgVar.f26249j) {
                            j3 = jIntValue;
                            zzbdVar2 = zzbdVar;
                            j4 = jE;
                            j2 = jC;
                            com.google.android.gms.ads.internal.util.client.zzf.f21413b.post(new zzcgs(zzchgVar, zzchgVar.f26244e, strS, jE, jC, zBooleanValue ? zzchgVar.f26243d.t() : -1L, zBooleanValue ? zzchgVar.f26243d.u() : -1L, zBooleanValue ? zzchgVar.f26243d.v() : -1L, jE > 0, zzcfb.f26058a.get(), zzcfb.f26059b.get()));
                            zzchgVar.f26249j = j4;
                        } else {
                            zzbdVar2 = zzbdVar;
                            j2 = jC;
                            j3 = jIntValue;
                            j4 = jE;
                        }
                        if (j4 >= j2) {
                            com.google.android.gms.ads.internal.util.client.zzf.f21413b.post(new zzcgv(zzchgVar, zzchgVar.f26244e, strS, j2));
                        } else if (zzchgVar.f26243d.f26313m >= j3 && j4 > 0) {
                        }
                    } else {
                        zzbdVar2 = zzbdVar;
                    }
                    com.google.android.gms.ads.internal.util.zzs.f21608l.postDelayed(new zzche(zzchgVar), ((Long) zzbdVar2.f21153c.a(zzbgk.X)).longValue());
                    return;
                }
                com.google.android.gms.ads.internal.zzt.C.A.f26175a.remove(zzchgVar.f26247h);
            } finally {
            }
        }
    }
}
