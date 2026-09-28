package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzebc implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzebh f28992a;

    public zzebc(zzebh zzebhVar) {
        Objects.requireNonNull(zzebhVar);
        this.f28992a = zzebhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        ((zzdzy) obj).f28901m = true;
        this.f28992a.f29001d.c();
    }
}
