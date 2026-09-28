package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdtz {

    /* renamed from: a, reason: collision with root package name */
    public final zzdai f28542a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdip f28543b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdbr f28544c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdce f28545d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdcv f28546e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdfo f28547f;

    /* renamed from: g, reason: collision with root package name */
    public final Executor f28548g;

    /* renamed from: h, reason: collision with root package name */
    public final zzdil f28549h;

    /* renamed from: i, reason: collision with root package name */
    public final zzcrx f28550i;

    /* renamed from: j, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.zzb f28551j;

    /* renamed from: k, reason: collision with root package name */
    public final zzcbk f28552k;

    /* renamed from: l, reason: collision with root package name */
    public final zzayq f28553l;

    /* renamed from: m, reason: collision with root package name */
    public final zzdff f28554m;
    public final zzehu n;
    public final zzfpi o;
    public final zzdxe p;
    public final zzcra q;
    public final zzduf r;
    public final zzdyh s;
    public final zzczj t;
    public final zzcze u;

    public zzdtz(zzdai zzdaiVar, zzdbr zzdbrVar, zzdce zzdceVar, zzdcv zzdcvVar, zzdfo zzdfoVar, Executor executor, zzdil zzdilVar, zzcrx zzcrxVar, com.google.android.gms.ads.internal.zzb zzbVar, zzcbk zzcbkVar, zzayq zzayqVar, zzdff zzdffVar, zzehu zzehuVar, zzfpi zzfpiVar, zzdxe zzdxeVar, zzdip zzdipVar, zzcra zzcraVar, zzduf zzdufVar, zzdyh zzdyhVar, zzczj zzczjVar, zzcze zzczeVar) {
        this.f28542a = zzdaiVar;
        this.f28544c = zzdbrVar;
        this.f28545d = zzdceVar;
        this.f28546e = zzdcvVar;
        this.f28547f = zzdfoVar;
        this.f28548g = executor;
        this.f28549h = zzdilVar;
        this.f28550i = zzcrxVar;
        this.f28551j = zzbVar;
        this.f28552k = zzcbkVar;
        this.f28553l = zzayqVar;
        this.f28554m = zzdffVar;
        this.n = zzehuVar;
        this.o = zzfpiVar;
        this.p = zzdxeVar;
        this.f28543b = zzdipVar;
        this.q = zzcraVar;
        this.r = zzdufVar;
        this.s = zzdyhVar;
        this.t = zzczjVar;
        this.u = zzczeVar;
    }

    public static final zzcdt b(zzcir zzcirVar, String str, String str2, final Bundle bundle, zzfno zzfnoVar) {
        zzbgb zzbgbVar = zzbgk.C2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            bundle.putLong("rendering-webview-load-html-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
        final zzcdt zzcdtVar = new zzcdt();
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.W9)).booleanValue()) {
            zzfne zzfneVarF = zzfne.f(112, zzcirVar.getContext());
            zzfneVarF.zza();
            zzfnn.c(zzcdtVar, zzfnoVar, zzfneVarF, false);
        }
        zzcirVar.e0().f26375g = new zzckn() { // from class: com.google.android.gms.internal.ads.zzdtx
            @Override // com.google.android.gms.internal.ads.zzckn
            public final void a(String str3, int i2, String str4, boolean z) {
                zzcdt zzcdtVar2 = zzcdtVar;
                if (z) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.C2)).booleanValue()) {
                        bundle.putLong("rendering-webview-load-html-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                    }
                    zzcdtVar2.b(null);
                    return;
                }
                int length = String.valueOf(i2).length();
                StringBuilder sb = new StringBuilder(length + 55 + String.valueOf(str3).length() + 15 + String.valueOf(str4).length());
                sb.append("Ad Web View failed to load. Error code: ");
                sb.append(i2);
                sb.append(", Description: ");
                sb.append(str3);
                zzcdtVar2.c(new Exception(android.support.v4.media.b.r(sb, ", Failing URL: ", str4)));
            }
        };
        zzcirVar.M(str, str2);
        return zzcdtVar;
    }

    public final void a(final zzcir zzcirVar, boolean z, zzbnq zzbnqVar, Bundle bundle) {
        zzayl zzaylVar;
        zzbgb zzbgbVar = zzbgk.C2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            bundle.putLong("rendering-configure-webview-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
        zzcirVar.e0().y(new com.google.android.gms.ads.internal.client.zza() { // from class: com.google.android.gms.internal.ads.zzdty
            @Override // com.google.android.gms.ads.internal.client.zza
            public final /* synthetic */ void h() {
                this.f28541a.f28542a.h();
            }
        }, this.f28545d, this.f28546e, new zzbmf() { // from class: com.google.android.gms.internal.ads.zzdtr
            @Override // com.google.android.gms.internal.ads.zzbmf
            public final /* synthetic */ void p1(String str, String str2) {
                this.f28532a.f28547f.p1(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzad() { // from class: com.google.android.gms.internal.ads.zzdts
            @Override // com.google.android.gms.ads.internal.overlay.zzad
            public final /* synthetic */ void zzl() {
                this.f28533a.f28544c.w0();
            }
        }, z, zzbnqVar, this.f28551j, new zzdtq(this), this.f28552k, this.n, this.o, this.p, null, this.f28543b, null, null, null, this.q, this.s, this.t, this.u);
        zzcirVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.internal.ads.zzdtt
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                zzdtz zzdtzVar = this.f28534a;
                zzdtzVar.getClass();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.hb)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
                    zzdtzVar.r.f28591a = motionEvent;
                }
                zzdtzVar.f28551j.f21624b = true;
                if (view == null) {
                    return false;
                }
                view.performClick();
                return false;
            }
        });
        zzcirVar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzdtu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f28535a.f28551j.f21624b = true;
            }
        });
        zzbgb zzbgbVar2 = zzbgk.f3;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue() && (zzaylVar = this.f28553l.f24512b) != null) {
            zzaylVar.i(zzcirVar.x());
        }
        zzdil zzdilVar = this.f28549h;
        Executor executor = this.f28548g;
        zzdilVar.t0(zzcirVar, executor);
        zzdilVar.t0(new zzbck() { // from class: com.google.android.gms.internal.ads.zzdtv
            @Override // com.google.android.gms.internal.ads.zzbck
            public final /* synthetic */ void u0(zzbcj zzbcjVar) {
                Rect rect = zzbcjVar.f24701d;
                zzcirVar.e0().t(rect.left, rect.top);
            }
        }, executor);
        zzdilVar.w0(zzcirVar.x());
        zzcirVar.k0("/trackActiveViewUnit", new zzbnn() { // from class: com.google.android.gms.internal.ads.zzdtw
            @Override // com.google.android.gms.internal.ads.zzbnn
            public final void a(Object obj, Map map) {
                zzdtz zzdtzVar = this.f28537a;
                zzcir zzcirVar2 = zzcirVar;
                zzcrx zzcrxVar = zzdtzVar.f28550i;
                synchronized (zzcrxVar) {
                    zzcrxVar.f27013c.add(zzcirVar2);
                    zzcrs zzcrsVar = zzcrxVar.f27011a;
                    zzcirVar2.k0("/updateActiveView", zzcrsVar.f26997e);
                    zzcirVar2.k0("/untrackActiveViewUnit", zzcrsVar.f26998f);
                }
            }
        });
        zzcrx zzcrxVar = this.f28550i;
        zzcrxVar.getClass();
        zzcrxVar.f27020j = new WeakReference(zzcirVar);
        if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
            bundle.putLong("rendering-configure-webview-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
    }
}
