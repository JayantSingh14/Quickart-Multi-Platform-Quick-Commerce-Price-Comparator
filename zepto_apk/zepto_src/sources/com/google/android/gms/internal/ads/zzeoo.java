package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzeoo implements com.google.android.gms.ads.internal.zzg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdai f29980a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdbc f29981b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdit f29982c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdil f29983d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcrx f29984e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f29985f = new AtomicBoolean(false);

    public zzeoo(zzdai zzdaiVar, zzdbc zzdbcVar, zzdit zzditVar, zzdil zzdilVar, zzcrx zzcrxVar) {
        this.f29980a = zzdaiVar;
        this.f29981b = zzdbcVar;
        this.f29982c = zzditVar;
        this.f29983d = zzdilVar;
        this.f29984e = zzcrxVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zza(View view) {
        if (this.f29985f.compareAndSet(false, true)) {
            this.f29984e.f();
            this.f29983d.w0(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        if (this.f29985f.get()) {
            this.f29980a.h();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        if (this.f29985f.get()) {
            this.f29981b.g();
            zzdit zzditVar = this.f29982c;
            synchronized (zzditVar) {
                zzditVar.v0(zzdis.f27796a);
            }
        }
    }
}
