package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzfnl implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfno f31473a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfne f31474b;

    public zzfnl(zzfno zzfnoVar, zzfne zzfneVar) {
        this.f31473a = zzfnoVar;
        this.f31474b = zzfneVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzfne zzfneVar = this.f31474b;
        zzfneVar.c(th);
        zzfneVar.a(false);
        this.f31473a.a(zzfneVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
    }
}
