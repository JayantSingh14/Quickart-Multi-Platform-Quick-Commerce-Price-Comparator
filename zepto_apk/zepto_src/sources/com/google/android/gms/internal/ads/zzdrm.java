package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdrm {

    /* renamed from: a, reason: collision with root package name */
    public final zzfik f28342a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f28343b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdua f28344c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdsv f28345d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f28346e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdxe f28347f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfpi f28348g;

    /* renamed from: h, reason: collision with root package name */
    public final zzehu f28349h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdwy f28350i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdyh f28351j;

    public zzdrm(zzfik zzfikVar, Executor executor, zzdua zzduaVar, Context context, zzdxe zzdxeVar, zzfpi zzfpiVar, zzehu zzehuVar, zzdsv zzdsvVar, zzdwy zzdwyVar, zzdyh zzdyhVar) {
        this.f28342a = zzfikVar;
        this.f28343b = executor;
        this.f28344c = zzduaVar;
        this.f28346e = context;
        this.f28347f = zzdxeVar;
        this.f28348g = zzfpiVar;
        this.f28349h = zzehuVar;
        this.f28345d = zzdsvVar;
        this.f28350i = zzdwyVar;
        this.f28351j = zzdyhVar;
    }

    public static final void b(zzcir zzcirVar) {
        zzcirVar.k0("/videoClicked", zzbnm.f25344h);
        zzcjc zzcjcVarE0 = zzcirVar.e0();
        synchronized (zzcjcVarE0.f26372d) {
            zzcjcVarE0.r = true;
        }
        zzcirVar.k0("/getNativeAdViewSignals", zzbnm.s);
        zzcirVar.k0("/getNativeClickMeta", zzbnm.t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(zzcir zzcirVar, com.google.android.gms.ads.internal.zzb zzbVar, zzcbf zzcbfVar) {
        zzdyh zzdyhVar;
        b(zzcirVar);
        zzcirVar.k0("/video", zzbnm.f25348l);
        zzcirVar.k0("/videoMeta", zzbnm.f25349m);
        zzcirVar.k0("/precache", new zzcgy());
        zzcirVar.k0("/delayPageLoaded", zzbnm.p);
        zzcirVar.k0("/instrument", zzbnm.n);
        zzcirVar.k0("/log", zzbnm.f25343g);
        zzcirVar.k0("/click", new zzbnh(null, 0 == true ? 1 : 0));
        if (this.f28342a.f31214b != null) {
            zzcirVar.e0().m(true);
            zzcirVar.k0("/open", new zzboa(true != ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Oe)).booleanValue() ? null : zzbVar, null, null, null, null, null));
        } else {
            zzcirVar.e0().m(false);
        }
        if (com.google.android.gms.ads.internal.zzt.C.y.a(zzcirVar.getContext())) {
            HashMap map = new HashMap();
            if (zzcirVar.v() != null) {
                map = zzcirVar.v().w0;
            }
            zzcirVar.k0("/logScionEvent", new zzbnt(zzcirVar.getContext(), map));
        }
        zzbgb zzbgbVar = zzbgk.Oe;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzcirVar.e0().w = zzbVar;
            zzcirVar.e0().y = zzcbfVar;
        }
        if (!((Boolean) zzbdVar.f21153c.a(zzbgk.B8)).booleanValue() || (zzdyhVar = this.f28351j) == null) {
            return;
        }
        zzcirVar.k0("/onDeviceStorageEvent", new zzbnv(zzdyhVar));
    }
}
