package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes4.dex */
public final class zzcsw extends zzcvk {

    /* renamed from: l, reason: collision with root package name */
    public final zzcir f27074l;

    /* renamed from: m, reason: collision with root package name */
    public final int f27075m;
    public final Context n;
    public final zzcsk o;
    public final zzdlh p;
    public final zzdhv q;
    public final zzdax r;
    public final boolean s;
    public final zzcdf t;
    public final zzdxe u;
    public boolean v;

    public zzcsw(zzcvj zzcvjVar, Context context, zzcir zzcirVar, int i2, zzcsk zzcskVar, zzdlh zzdlhVar, zzdhv zzdhvVar, zzdax zzdaxVar, zzcdf zzcdfVar, zzdxe zzdxeVar) {
        super(zzcvjVar);
        this.v = false;
        this.f27074l = zzcirVar;
        this.n = context;
        this.f27075m = i2;
        this.o = zzcskVar;
        this.p = zzdlhVar;
        this.q = zzdhvVar;
        this.r = zzdaxVar;
        this.s = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.g6)).booleanValue();
        this.t = zzcdfVar;
        this.u = zzdxeVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v16, types: [android.content.Context] */
    public final void c(Activity activity, boolean z) {
        zzcir zzcirVar;
        zzfhr zzfhrVarV;
        int i2;
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.n;
        }
        zzdhv zzdhvVar = this.q;
        boolean z2 = this.s;
        if (z2) {
            zzdhvVar.v0(zzdhu.f27775a);
        }
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zztVar.f21679c;
        zzdlh zzdlhVar = this.p;
        boolean zM = com.google.android.gms.ads.internal.util.zzs.m(zzdlhVar.zzb());
        zzdax zzdaxVar = this.r;
        if (!zM) {
            zzbgb zzbgbVar = zzbgk.Ke;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs.l(activity2, this.f27228b, this.u);
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.X0)).booleanValue() && com.google.android.gms.ads.internal.util.zzs.g(activity2)) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://goo.gle/admob-interstitial-policies");
                zzdaxVar.zze();
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.Y0)).booleanValue()) {
                    new zzfup(activity2.getApplicationContext(), zztVar.t.a()).a(this.f27227a.f31194b.f31190b.f31167b);
                    return;
                }
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Zc)).booleanValue() && (zzcirVar = this.f27074l) != null && (zzfhrVarV = zzcirVar.v()) != null && zzfhrVarV.r0) {
            zzcdf zzcdfVar = this.t;
            synchronized (zzcdfVar.f25962a) {
                zzcdc zzcdcVar = zzcdfVar.f25965d;
                synchronized (zzcdcVar.f25952f) {
                    i2 = zzcdcVar.f25958l;
                }
            }
            if (zzfhrVarV.s0 != i2) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("The app open consent form has been shown.");
                zzdaxVar.k1(zzfjm.d(12, "The consent form has already been shown.", null));
                return;
            }
        }
        if (this.v) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("App open interstitial ad is already visible.");
            zzdaxVar.k1(zzfjm.d(10, null, null));
        }
        if (this.v) {
            return;
        }
        try {
            zzdlhVar.a(z, activity2, zzdaxVar);
            if (z2) {
                zzdhvVar.v0(zzdht.f27774a);
            }
            this.v = true;
        } catch (zzdlg e2) {
            zzdaxVar.j(e2);
        }
    }

    public final void d() {
        zzdbj zzdbjVar = this.f27229c;
        zzdbjVar.getClass();
        zzdbjVar.v0(new zzdbh(null));
        zzcir zzcirVar = this.f27074l;
        if (zzcirVar != null) {
            zzcirVar.destroy();
        }
    }

    public final void e(int i2, long j2) {
        zzcsk zzcskVar = this.o;
        zzdxd zzdxdVarA = zzcskVar.f27065a.a();
        zzdxdVarA.b("gqi", zzcskVar.f27066b.f31194b.f31190b.f31167b);
        zzdxdVarA.b("action", "ad_closed");
        zzdxdVarA.b("show_time", String.valueOf(j2));
        zzdxdVarA.b("ad_format", "app_open_ad");
        int i3 = i2 - 1;
        zzdxdVarA.b("acr", i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h");
        zzdxdVarA.c();
    }
}
