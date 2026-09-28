package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdqc implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdwm f28225a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdqf f28226b;

    public zzdqc(zzdqf zzdqfVar, zzdwm zzdwmVar) {
        this.f28225a = zzdwmVar;
        Objects.requireNonNull(zzdqfVar);
        this.f28226b = zzdqfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        this.f28226b.f28246d.f28716e.putLong(this.f28225a.f28699a, com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
    }
}
