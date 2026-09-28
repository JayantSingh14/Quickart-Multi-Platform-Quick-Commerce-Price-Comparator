package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzcoa implements com.google.android.gms.ads.nonagon.signalgeneration.zzab {

    /* renamed from: a, reason: collision with root package name */
    public final zzcmv f26782a;

    /* renamed from: b, reason: collision with root package name */
    public zzczt f26783b;

    /* renamed from: c, reason: collision with root package name */
    public com.google.android.gms.ads.nonagon.signalgeneration.zzay f26784c;

    public /* synthetic */ zzcoa(zzcmv zzcmvVar) {
        this.f26782a = zzcmvVar;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzab a(zzczt zzcztVar) {
        this.f26783b = zzcztVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzab b(com.google.android.gms.ads.nonagon.signalgeneration.zzay zzayVar) {
        this.f26784c = zzayVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzac zza() {
        zzijo.b(zzczt.class, this.f26783b);
        zzijo.b(com.google.android.gms.ads.nonagon.signalgeneration.zzay.class, this.f26784c);
        com.google.android.gms.ads.nonagon.signalgeneration.zzay zzayVar = this.f26784c;
        new zzcwq();
        new zzcyr();
        new zzdxt();
        return new zzcob(this.f26782a, zzayVar, this.f26783b);
    }
}
