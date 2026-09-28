package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeqw implements zzere {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzeqx f30118a;

    public zzeqw(zzeqx zzeqxVar) {
        Objects.requireNonNull(zzeqxVar);
        this.f30118a = zzeqxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final /* synthetic */ void a(zzcvk zzcvkVar) {
        zzeqx zzeqxVar = this.f30118a;
        zzdjs zzdjsVar = (zzdjs) zzcvkVar;
        synchronized (zzeqxVar) {
            zzeqxVar.f30128j = zzdjsVar;
            zzdjsVar.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void zza() {
        zzeqx zzeqxVar = this.f30118a;
        synchronized (zzeqxVar) {
            zzeqxVar.f30128j = null;
        }
    }
}
