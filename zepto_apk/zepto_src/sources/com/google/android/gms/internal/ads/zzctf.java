package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzctf extends zzctc {

    /* renamed from: l, reason: collision with root package name */
    public final Context f27100l;

    /* renamed from: m, reason: collision with root package name */
    public final View f27101m;
    public final zzcir n;
    public final zzfhs o;
    public final zzcvi p;
    public final zzdnw q;
    public final zzdit r;
    public final zzija s;
    public final Executor t;
    public com.google.android.gms.ads.internal.client.zzr u;

    public zzctf(zzcvj zzcvjVar, Context context, zzfhs zzfhsVar, View view, zzcir zzcirVar, zzcvi zzcviVar, zzdnw zzdnwVar, zzdit zzditVar, zzija zzijaVar, Executor executor) {
        super(zzcvjVar);
        this.f27100l = context;
        this.f27101m = view;
        this.n = zzcirVar;
        this.o = zzfhsVar;
        this.p = zzcviVar;
        this.q = zzdnwVar;
        this.r = zzditVar;
        this.s = zzijaVar;
        this.t = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcvk
    public final void a() {
        this.t.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcte
            @Override // java.lang.Runnable
            public final void run() {
                zzctf zzctfVar = this.f27099a;
                zzblj zzbljVar = zzctfVar.q.f28061d;
                if (zzbljVar == null) {
                    return;
                }
                try {
                    zzbljVar.Y1((com.google.android.gms.ads.internal.client.zzbx) zzctfVar.s.zzb(), new ObjectWrapper(zzctfVar.f27100l));
                } catch (RemoteException e2) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("RemoteException when notifyAdLoad is called", e2);
                }
            }
        });
        super.a();
    }

    @Override // com.google.android.gms.internal.ads.zzctc
    public final View c() {
        return this.f27101m;
    }

    @Override // com.google.android.gms.internal.ads.zzctc
    public final void d(FrameLayout frameLayout, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzcir zzcirVar;
        if (frameLayout == null || (zzcirVar = this.n) == null) {
            return;
        }
        zzcirVar.W(zzclb.a(zzrVar));
        frameLayout.setMinimumHeight(zzrVar.f21283c);
        frameLayout.setMinimumWidth(zzrVar.f21286f);
        this.u = zzrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzctc
    public final com.google.android.gms.ads.internal.client.zzed e() {
        try {
            return this.p.zza();
        } catch (zzfir unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzctc
    public final zzfhs f() {
        com.google.android.gms.ads.internal.client.zzr zzrVar = this.u;
        if (zzrVar != null) {
            return zzrVar.f21289i ? new zzfhs(-3, 0, true) : new zzfhs(zzrVar.f21285e, zzrVar.f21282b, false);
        }
        zzfhr zzfhrVar = this.f27228b;
        if (zzfhrVar.c0) {
            for (String str : zzfhrVar.f31149a) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            View view = this.f27101m;
            return new zzfhs(view.getWidth(), view.getHeight(), false);
        }
        return (zzfhs) zzfhrVar.r.get(0);
    }

    @Override // com.google.android.gms.internal.ads.zzctc
    public final zzfhs g() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzctc
    public final int h() {
        zzbgb zzbgbVar = zzbgk.P8;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && this.f27228b.g0) {
            if (!((Boolean) zzbdVar.f21153c.a(zzbgk.Q8)).booleanValue()) {
                return 0;
            }
        }
        return this.f27227a.f31194b.f31190b.f31168c;
    }

    @Override // com.google.android.gms.internal.ads.zzctc
    public final int i() {
        return this.f27227a.f31194b.f31190b.f31169d;
    }

    @Override // com.google.android.gms.internal.ads.zzctc
    public final void j() {
        zzdit zzditVar = this.r;
        synchronized (zzditVar) {
            zzditVar.v0(zzdis.f27796a);
        }
    }
}
