package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzfnk implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfno f31470a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfne f31471b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f31472c;

    public zzfnk(zzfno zzfnoVar, zzfne zzfneVar, boolean z) {
        this.f31470a = zzfnoVar;
        this.f31471b = zzfneVar;
        this.f31472c = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzfne zzfneVar = this.f31471b;
        if (zzfneVar.zzb()) {
            zzfneVar.c(th);
            zzfneVar.a(false);
            zzfno zzfnoVar = this.f31470a;
            zzfnoVar.a(zzfneVar);
            if (this.f31472c) {
                zzfnoVar.h();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzfne zzfneVar = this.f31471b;
        zzfneVar.a(true);
        zzfno zzfnoVar = this.f31470a;
        zzfnoVar.a(zzfneVar);
        if (this.f31472c) {
            zzfnoVar.h();
        }
    }
}
