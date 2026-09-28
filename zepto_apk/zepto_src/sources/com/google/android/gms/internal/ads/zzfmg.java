package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfmg implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfmb f31392a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfml f31393b;

    public zzfmg(zzfml zzfmlVar, zzfmb zzfmbVar) {
        this.f31392a = zzfmbVar;
        Objects.requireNonNull(zzfmlVar);
        this.f31393b = zzfmlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(final Throwable th) {
        zzfmn zzfmnVar = this.f31393b.f31403f.f31407c;
        final zzfmb zzfmbVar = this.f31392a;
        ((zzfmt) zzfmnVar).v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzfmq
            @Override // com.google.android.gms.internal.ads.zzdgh
            public final void zza(Object obj) {
                zzfmb zzfmbVar2 = zzfmbVar;
                ((zzfmv) obj).j((zzfmo) zzfmbVar2.f31384a, zzfmbVar2.f31385b, th);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzfmn zzfmnVar = this.f31393b.f31403f.f31407c;
        final zzfmb zzfmbVar = this.f31392a;
        ((zzfmt) zzfmnVar).v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzfmr
            @Override // com.google.android.gms.internal.ads.zzdgh
            public final void zza(Object obj2) {
                zzfmb zzfmbVar2 = zzfmbVar;
                ((zzfmv) obj2).t((zzfmo) zzfmbVar2.f31384a, zzfmbVar2.f31385b);
            }
        });
    }
}
