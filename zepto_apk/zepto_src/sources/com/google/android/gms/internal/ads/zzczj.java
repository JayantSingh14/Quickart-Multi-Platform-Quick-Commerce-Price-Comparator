package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzczj implements com.google.android.gms.ads.internal.overlay.zzr {

    /* renamed from: b, reason: collision with root package name */
    public final zzfic f27465b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfhr f27466c;

    /* renamed from: d, reason: collision with root package name */
    public final Clock f27467d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdxe f27468e;

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f27469f;

    /* renamed from: a, reason: collision with root package name */
    public final Object f27464a = new Object();

    /* renamed from: g, reason: collision with root package name */
    public final zzfoi f27470g = zzfoj.C();

    /* renamed from: h, reason: collision with root package name */
    public boolean f27471h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f27472i = false;

    public zzczj(zzfic zzficVar, zzfhr zzfhrVar, Clock clock, zzdxe zzdxeVar, ScheduledExecutorService scheduledExecutorService) {
        this.f27465b = zzficVar;
        this.f27466c = zzfhrVar;
        this.f27467d = clock;
        this.f27468e = zzdxeVar;
        this.f27469f = scheduledExecutorService;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void A4() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void R6(int i2) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void T7() {
        b(10);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void V2() {
        b(3);
    }

    public final void a() {
        synchronized (this.f27464a) {
            try {
                zzdxe zzdxeVar = this.f27468e;
                String str = this.f27465b.f31194b.f31190b.f31167b;
                String strEncodeToString = Base64.encodeToString(((zzfoj) this.f27470g.l()).g(), 1);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Yd)).booleanValue()) {
                    zzdxd zzdxdVarA = zzdxeVar.a();
                    zzdxdVarA.b("action", "pclma");
                    zzdxdVarA.b("pclmd", strEncodeToString);
                    zzdxdVarA.b("gqi", str);
                    zzdxdVarA.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(int i2) {
        synchronized (this.f27464a) {
            try {
                if (!this.f27472i && this.f27471h) {
                    zzfoi zzfoiVar = this.f27470g;
                    zzfnc zzfncVarC = zzfnd.C();
                    zzfncVarC.j();
                    ((zzfnd) zzfncVarC.f34638b).E(i2);
                    long jCurrentTimeMillis = this.f27467d.currentTimeMillis();
                    zzfncVarC.j();
                    ((zzfnd) zzfncVarC.f34638b).D(jCurrentTimeMillis);
                    zzfnd zzfndVar = (zzfnd) zzfncVarC.l();
                    zzfoiVar.j();
                    ((zzfoj) zzfoiVar.f34638b).D(zzfndVar);
                    if (i2 == 10) {
                        a();
                        this.f27472i = true;
                    }
                }
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void d9() {
        b(6);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void i5() {
        b(7);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void j7() {
        b(9);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w1() {
        b(4);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w8() {
        b(8);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void y3() {
        b(5);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
    }
}
