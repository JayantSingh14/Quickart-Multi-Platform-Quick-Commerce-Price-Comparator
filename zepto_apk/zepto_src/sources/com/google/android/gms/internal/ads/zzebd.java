package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzebd implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzebh f28993a;

    public zzebd(zzebh zzebhVar) {
        Objects.requireNonNull(zzebhVar);
        this.f28993a = zzebhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        ((zzdzy) obj).n = true;
        this.f28993a.f29001d.c();
    }
}
