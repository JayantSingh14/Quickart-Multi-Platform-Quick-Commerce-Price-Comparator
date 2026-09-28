package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class zzfik {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzga f31213a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbpy f31214b;

    /* renamed from: c, reason: collision with root package name */
    public final zzeqp f31215c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzm f31216d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f31217e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzr f31218f;

    /* renamed from: g, reason: collision with root package name */
    public final String f31219g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f31220h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f31221i;

    /* renamed from: j, reason: collision with root package name */
    public final zzbjn f31222j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzx f31223k;

    /* renamed from: l, reason: collision with root package name */
    public final int f31224l;

    /* renamed from: m, reason: collision with root package name */
    public final AdManagerAdViewOptions f31225m;
    public final PublisherAdViewOptions n;
    public final com.google.android.gms.ads.internal.client.zzco o;
    public final zzfhy p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final Bundle t;
    public final AtomicLong u;
    public final boolean v;
    public final com.google.android.gms.ads.internal.client.zzcs w;

    public zzfik(zzfij zzfijVar) {
        this.f31218f = zzfijVar.f31201b;
        this.f31219g = zzfijVar.f31202c;
        this.w = zzfijVar.w;
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfijVar.f31200a;
        this.f31217e = zzmVar.B;
        boolean z = true;
        if (!zzmVar.f21261h && !zzfijVar.f31204e) {
            z = false;
        }
        boolean z2 = z;
        com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzfijVar.f31200a;
        String str = zzmVar2.f21262i;
        int iS = com.google.android.gms.ads.internal.util.zzs.s(zzmVar2.w);
        com.google.android.gms.ads.internal.client.zzm zzmVar3 = zzfijVar.f31200a;
        com.google.android.gms.ads.internal.client.zzm zzmVar4 = new com.google.android.gms.ads.internal.client.zzm(zzmVar.f21254a, zzmVar.f21255b, zzmVar.f21256c, zzmVar.f21257d, zzmVar.f21258e, zzmVar.f21259f, zzmVar.f21260g, z2, str, zzmVar2.f21263j, zzmVar2.f21264k, zzmVar2.f21265l, zzmVar2.f21266m, zzmVar2.n, zzmVar2.o, zzmVar2.p, zzmVar2.q, zzmVar2.r, zzmVar2.s, zzmVar2.t, zzmVar2.u, zzmVar2.v, iS, zzmVar3.x, zzmVar3.y, zzmVar3.z, zzmVar3.A);
        this.f31216d = zzmVar4;
        com.google.android.gms.ads.internal.client.zzga zzgaVar = zzfijVar.f31203d;
        zzbjn zzbjnVar = null;
        if (zzgaVar == null) {
            zzbjn zzbjnVar2 = zzfijVar.f31207h;
            zzgaVar = zzbjnVar2 != null ? zzbjnVar2.f25254f : null;
        }
        this.f31213a = zzgaVar;
        ArrayList arrayList = zzfijVar.f31205f;
        this.f31220h = arrayList;
        this.f31221i = zzfijVar.f31206g;
        if (arrayList != null && (zzbjnVar = zzfijVar.f31207h) == null) {
            zzbjnVar = new zzbjn(new NativeAdOptions(new NativeAdOptions.Builder()));
        }
        this.f31222j = zzbjnVar;
        this.f31223k = zzfijVar.f31208i;
        this.f31224l = zzfijVar.f31212m;
        this.f31225m = zzfijVar.f31209j;
        this.n = zzfijVar.f31210k;
        this.o = zzfijVar.f31211l;
        this.f31214b = zzfijVar.n;
        this.p = new zzfhy(zzfijVar.o);
        this.q = zzfijVar.p;
        this.r = zzfijVar.q;
        this.f31215c = zzfijVar.r;
        this.s = zzfijVar.s;
        this.t = zzfijVar.t;
        long j2 = zzmVar4.A;
        if (j2 != 0) {
            this.u = new AtomicLong(j2);
        } else {
            this.u = zzfijVar.u;
        }
        this.v = zzfijVar.v;
    }

    public final boolean a() {
        return this.f31219g.matches((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P3));
    }
}
