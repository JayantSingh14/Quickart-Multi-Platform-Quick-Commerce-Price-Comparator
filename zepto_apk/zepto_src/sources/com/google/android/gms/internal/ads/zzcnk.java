package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
final class zzcnk implements zzdyv {

    /* renamed from: a, reason: collision with root package name */
    public final zzcmv f26696a;

    /* renamed from: b, reason: collision with root package name */
    public Context f26697b;

    /* renamed from: c, reason: collision with root package name */
    public zzbon f26698c;

    public /* synthetic */ zzcnk(zzcmv zzcmvVar) {
        this.f26696a = zzcmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public final /* bridge */ /* synthetic */ zzdyv a(Context context) {
        context.getClass();
        this.f26697b = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public final /* bridge */ /* synthetic */ zzdyv b(zzbon zzbonVar) {
        zzbonVar.getClass();
        this.f26698c = zzbonVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public final zzdyw zza() {
        zzijo.b(Context.class, this.f26697b);
        zzijo.b(zzbon.class, this.f26698c);
        return new zzcnl(this.f26696a, this.f26697b, this.f26698c);
    }
}
