package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzcdj {

    /* renamed from: a, reason: collision with root package name */
    public zzgyw f25971a;

    /* renamed from: b, reason: collision with root package name */
    public zzdxe f25972b;

    /* renamed from: c, reason: collision with root package name */
    public Context f25973c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f25974d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f25975e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public long f25976f = -1;

    /* renamed from: g, reason: collision with root package name */
    public long f25977g = -1;

    public final void a(zzgyw zzgywVar, zzdxe zzdxeVar, Context context) {
        if (this.f25974d.getAndSet(true)) {
            return;
        }
        this.f25971a = zzgywVar;
        this.f25972b = zzdxeVar;
        zzbgb zzbgbVar = zzbgk.Ue;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        this.f25976f = ((Long) zzbdVar.f21153c.a(zzbgbVar)).longValue();
        this.f25977g = ((Long) zzbdVar.f21153c.a(zzbgk.Ve)).longValue();
        this.f25973c = context;
    }
}
