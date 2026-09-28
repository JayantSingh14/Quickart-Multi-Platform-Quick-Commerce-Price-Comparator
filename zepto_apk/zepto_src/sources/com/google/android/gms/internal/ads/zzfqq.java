package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfqq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f31656a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzea f31657b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfqy f31658c;

    public zzfqq(zzfqy zzfqyVar, long j2, com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        this.f31656a = j2;
        this.f31657b = zzeaVar;
        Objects.requireNonNull(zzfqyVar);
        this.f31658c = zzfqyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfqy zzfqyVar = this.f31658c;
        zzfqd zzfqdVar = zzfqyVar.r;
        if (zzfqdVar != null) {
            com.google.android.gms.ads.internal.client.zzea zzeaVar = this.f31657b;
            zzfqdVar.g("paa", "pano_ts", this.f31656a, zzfqyVar.f31671e.f21242d, zzfqyVar.p(), !(zzeaVar instanceof zzdad) ? null : ((zzdad) zzeaVar).f27546d, zzfqyVar.t, zzfqyVar.f());
        }
    }
}
