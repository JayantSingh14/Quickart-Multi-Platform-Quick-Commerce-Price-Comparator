package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzcni implements zzdyo {

    /* renamed from: a, reason: collision with root package name */
    public final zzcmv f26688a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcnl f26689b;

    /* renamed from: c, reason: collision with root package name */
    public Long f26690c;

    /* renamed from: d, reason: collision with root package name */
    public String f26691d;

    public /* synthetic */ zzcni(zzcmv zzcmvVar, zzcnl zzcnlVar) {
        this.f26688a = zzcmvVar;
        this.f26689b = zzcnlVar;
    }

    public final zzdyp a() {
        zzijo.b(Long.class, this.f26690c);
        zzijo.b(String.class, this.f26691d);
        return new zzcnj(this.f26688a, this.f26689b, this.f26690c, this.f26691d);
    }

    public final /* bridge */ /* synthetic */ zzdyo b(String str) {
        str.getClass();
        this.f26691d = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzdyo c(long j2) {
        this.f26690c = Long.valueOf(j2);
        return this;
    }
}
