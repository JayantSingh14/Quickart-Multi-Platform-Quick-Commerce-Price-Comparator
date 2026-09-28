package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.widget.ImageView;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzcfe {

    /* renamed from: b, reason: collision with root package name */
    public long f26062b;

    /* renamed from: a, reason: collision with root package name */
    public final long f26061a = TimeUnit.MILLISECONDS.toNanos(((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.c0)).longValue());

    /* renamed from: c, reason: collision with root package name */
    public boolean f26063c = true;

    public final void a(SurfaceTexture surfaceTexture, final zzcey zzceyVar) {
        if (zzceyVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (!this.f26063c) {
            long j2 = timestamp - this.f26062b;
            if (Math.abs(j2) < this.f26061a) {
                return;
            }
        }
        this.f26063c = false;
        this.f26062b = timestamp;
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfd
            @Override // java.lang.Runnable
            public final void run() {
                zzcey zzceyVar2 = zzceyVar;
                if (zzceyVar2.f26045h) {
                    ImageView imageView = zzceyVar2.q;
                    if (imageView.getParent() != null) {
                        zzceyVar2.f26039b.removeView(imageView);
                    }
                }
                zzceq zzceqVar = zzceyVar2.f26044g;
                if (zzceqVar == null || zzceyVar2.p == null) {
                    return;
                }
                com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                long jElapsedRealtime = zztVar.f21687k.elapsedRealtime();
                if (zzceqVar.getBitmap(zzceyVar2.p) != null) {
                    zzceyVar2.r = true;
                }
                long jElapsedRealtime2 = zztVar.f21687k.elapsedRealtime() - jElapsedRealtime;
                if (com.google.android.gms.ads.internal.util.zze.m()) {
                    StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime2).length() + 26);
                    sb.append("Spinner frame grab took ");
                    sb.append(jElapsedRealtime2);
                    sb.append("ms");
                    com.google.android.gms.ads.internal.util.zze.k(sb.toString());
                }
                if (jElapsedRealtime2 > zzceyVar2.f26043f) {
                    com.google.android.gms.ads.internal.util.client.zzo.f("Spinner frame grab crossed jank threshold! Suspending spinner.");
                    zzceyVar2.f26048k = false;
                    zzceyVar2.p = null;
                    zzbgz zzbgzVar = zzceyVar2.f26041d;
                    if (zzbgzVar != null) {
                        zzbgzVar.c("spinner_jank", Long.toString(jElapsedRealtime2));
                    }
                }
            }
        });
    }
}
