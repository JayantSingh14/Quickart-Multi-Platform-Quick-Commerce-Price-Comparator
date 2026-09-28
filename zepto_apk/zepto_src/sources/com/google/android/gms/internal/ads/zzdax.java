package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzdax extends zzdgi implements zzdao {

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f27572b;

    /* renamed from: c, reason: collision with root package name */
    public ScheduledFuture f27573c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f27574d;

    public zzdax(zzdat zzdatVar, Set set, zzgyw zzgywVar, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.f27574d = false;
        this.f27572b = scheduledExecutorService;
        t0(zzdatVar, zzgywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdao
    public final void j(final zzdlg zzdlgVar) {
        if (this.f27574d) {
            return;
        }
        ScheduledFuture scheduledFuture = this.f27573c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzdau
            @Override // com.google.android.gms.internal.ads.zzdgh
            public final /* synthetic */ void zza(Object obj) {
                ((zzdao) obj).j(zzdlgVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdao
    public final void k1(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzdaw
            @Override // com.google.android.gms.internal.ads.zzdgh
            public final /* synthetic */ void zza(Object obj) {
                ((zzdao) obj).k1(zzeVar);
            }
        });
    }

    public final void w0() {
        this.f27573c = this.f27572b.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdav
            @Override // java.lang.Runnable
            public final void run() {
                zzdax zzdaxVar = this.f27570a;
                synchronized (zzdaxVar) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.c("Timeout waiting for show call succeed to be called.");
                    zzdaxVar.j(new zzdlg("Timeout for show call succeed."));
                    zzdaxVar.f27574d = true;
                }
            }
        }, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Pb)).intValue(), TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.internal.ads.zzdao
    public final void zze() {
        v0(zzdap.f27565a);
    }
}
