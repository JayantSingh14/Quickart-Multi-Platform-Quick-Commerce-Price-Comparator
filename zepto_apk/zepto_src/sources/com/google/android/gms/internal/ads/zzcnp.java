package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
final class zzcnp implements zzffx {

    /* renamed from: a, reason: collision with root package name */
    public final zzcmv f26736a;

    /* renamed from: b, reason: collision with root package name */
    public Context f26737b;

    /* renamed from: c, reason: collision with root package name */
    public String f26738c;

    /* renamed from: d, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzr f26739d;

    public /* synthetic */ zzcnp(zzcmv zzcmvVar) {
        this.f26736a = zzcmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffx
    public final /* bridge */ /* synthetic */ zzffx a(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzrVar.getClass();
        this.f26739d = zzrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzffx
    public final /* bridge */ /* synthetic */ zzffx b(Context context) {
        context.getClass();
        this.f26737b = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzffx
    public final /* bridge */ /* synthetic */ zzffx o(String str) {
        str.getClass();
        this.f26738c = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzffx
    public final zzffy zza() {
        zzijo.b(Context.class, this.f26737b);
        zzijo.b(String.class, this.f26738c);
        zzijo.b(com.google.android.gms.ads.internal.client.zzr.class, this.f26739d);
        return new zzcnq(this.f26736a, this.f26737b, this.f26738c, this.f26739d);
    }
}
