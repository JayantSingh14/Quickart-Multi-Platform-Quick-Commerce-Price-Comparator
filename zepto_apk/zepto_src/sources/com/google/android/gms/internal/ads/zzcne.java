package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
final class zzcne implements zzfeh {

    /* renamed from: a, reason: collision with root package name */
    public final zzcmv f26660a;

    /* renamed from: b, reason: collision with root package name */
    public Context f26661b;

    /* renamed from: c, reason: collision with root package name */
    public String f26662c;

    /* renamed from: d, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzr f26663d;

    public /* synthetic */ zzcne(zzcmv zzcmvVar) {
        this.f26660a = zzcmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfeh
    public final /* bridge */ /* synthetic */ zzfeh a(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzrVar.getClass();
        this.f26663d = zzrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfeh
    public final /* bridge */ /* synthetic */ zzfeh b(Context context) {
        context.getClass();
        this.f26661b = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfeh
    public final /* bridge */ /* synthetic */ zzfeh o(String str) {
        str.getClass();
        this.f26662c = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfeh
    public final zzfei zza() {
        zzijo.b(Context.class, this.f26661b);
        zzijo.b(String.class, this.f26662c);
        zzijo.b(com.google.android.gms.ads.internal.client.zzr.class, this.f26663d);
        return new zzcnf(this.f26660a, this.f26661b, this.f26662c, this.f26663d);
    }
}
