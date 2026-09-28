package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class zzdte extends zzcvk {

    /* renamed from: l, reason: collision with root package name */
    public final Context f28518l;

    /* renamed from: m, reason: collision with root package name */
    public final WeakReference f28519m;
    public final zzdlh n;
    public final zzdhv o;
    public final zzdax p;
    public final zzdce q;
    public final zzcwf r;
    public final zzcaw s;
    public final zzfup t;
    public final zzfie u;
    public final zzdxe v;
    public boolean w;

    public zzdte(zzcvj zzcvjVar, Context context, zzcir zzcirVar, zzdlh zzdlhVar, zzdhv zzdhvVar, zzdax zzdaxVar, zzdce zzdceVar, zzcwf zzcwfVar, zzfhr zzfhrVar, zzfup zzfupVar, zzfie zzfieVar, zzdxe zzdxeVar) {
        super(zzcvjVar);
        this.w = false;
        this.f28518l = context;
        this.n = zzdlhVar;
        this.f28519m = new WeakReference(zzcirVar);
        this.o = zzdhvVar;
        this.p = zzdaxVar;
        this.q = zzdceVar;
        this.r = zzcwfVar;
        this.t = zzfupVar;
        zzbzy zzbzyVar = zzfhrVar.f31160l;
        this.s = new zzcaw(zzbzyVar != null ? zzbzyVar.f25781a : "", zzbzyVar != null ? zzbzyVar.f25782b : 1);
        this.u = zzfieVar;
        this.v = zzdxeVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Activity activity, boolean z) {
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        zzdlh zzdlhVar = this.n;
        boolean zM = com.google.android.gms.ads.internal.util.zzs.m(zzdlhVar.zzb());
        Context context = this.f28518l;
        zzdax zzdaxVar = this.p;
        if (!zM) {
            zzbgb zzbgbVar = zzbgk.Ke;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs.l(context, this.f27228b, this.v);
            }
            zzbgb zzbgbVar2 = zzbgk.X0;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue() && com.google.android.gms.ads.internal.util.zzs.g(context)) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://goo.gle/admob-interstitial-policies");
                zzdaxVar.zze();
                if (((Boolean) zzbgiVar.a(zzbgk.Y0)).booleanValue()) {
                    this.t.a(this.f27227a.f31194b.f31190b.f31167b);
                    return;
                }
                return;
            }
        }
        if (this.w) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("The rewarded ad have been showed.");
            zzdaxVar.k1(zzfjm.d(10, null, null));
            return;
        }
        this.w = true;
        zzdhu zzdhuVar = zzdhu.f27775a;
        zzdhv zzdhvVar = this.o;
        zzdhvVar.v0(zzdhuVar);
        if (activity == null) {
            activity = context;
        }
        try {
            zzdlhVar.a(z, activity, zzdaxVar);
            zzdhvVar.v0(zzdht.f27774a);
        } catch (zzdlg e2) {
            zzdaxVar.j(e2);
        }
    }

    public final void finalize() throws Throwable {
        try {
            final zzcir zzcirVar = (zzcir) this.f28519m.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q7)).booleanValue()) {
                if (!this.w && zzcirVar != null) {
                    ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdtd
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzcirVar.destroy();
                        }
                    });
                }
            } else if (zzcirVar != null) {
                zzcirVar.destroy();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }
}
