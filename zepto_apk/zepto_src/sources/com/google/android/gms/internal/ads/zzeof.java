package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeof implements zzdbt {

    /* renamed from: a, reason: collision with root package name */
    public boolean f29948a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzejj f29949b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzcdt f29950c;

    public zzeof(zzeoi zzeoiVar, zzejj zzejjVar, zzcdt zzcdtVar) {
        this.f29949b = zzejjVar;
        this.f29950c = zzcdtVar;
        Objects.requireNonNull(zzeoiVar);
        this.f29948a = false;
    }

    public final synchronized void a(com.google.android.gms.ads.internal.client.zze zzeVar) {
        int i2 = 1;
        if (true == ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.k6)).booleanValue()) {
            i2 = 3;
        }
        this.f29950c.c(new zzejk(i2, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final synchronized void zza() {
        this.f29950c.b(null);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final synchronized void zzb(int i2) {
        if (this.f29948a) {
            return;
        }
        this.f29948a = true;
        a(new com.google.android.gms.ads.internal.client.zze(i2, zzeoi.c(i2, this.f29949b.f29462a), "undefined", null, null));
    }
}
