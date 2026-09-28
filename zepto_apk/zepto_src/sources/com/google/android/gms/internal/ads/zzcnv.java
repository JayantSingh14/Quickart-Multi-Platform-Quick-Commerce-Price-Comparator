package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
final class zzcnv implements zzfhk {

    /* renamed from: a, reason: collision with root package name */
    public final zzcmv f26745a;

    /* renamed from: b, reason: collision with root package name */
    public Context f26746b;

    /* renamed from: c, reason: collision with root package name */
    public String f26747c;

    public /* synthetic */ zzcnv(zzcmv zzcmvVar) {
        this.f26745a = zzcmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfhk
    public final /* bridge */ /* synthetic */ zzfhk a(Context context) {
        context.getClass();
        this.f26746b = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhk
    public final /* synthetic */ zzfhk b(String str) {
        this.f26747c = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhk
    public final zzfhl zza() {
        zzijo.b(Context.class, this.f26746b);
        return new zzcnw(this.f26745a, this.f26746b, this.f26747c);
    }
}
