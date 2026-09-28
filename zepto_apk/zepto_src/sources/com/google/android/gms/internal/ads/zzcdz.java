package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcdz implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcdx f25994a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcdv f25995b;

    public zzcdz(zzcea zzceaVar, zzcdx zzcdxVar, zzcdv zzcdvVar) {
        this.f25994a = zzcdxVar;
        this.f25995b = zzcdvVar;
        Objects.requireNonNull(zzceaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        this.f25995b.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        this.f25994a.zza(obj);
    }
}
