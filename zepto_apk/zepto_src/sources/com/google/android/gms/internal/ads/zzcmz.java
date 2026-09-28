package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
final class zzcmz implements zzfcu {

    /* renamed from: a, reason: collision with root package name */
    public final zzcmv f26620a;

    /* renamed from: b, reason: collision with root package name */
    public Context f26621b;

    /* renamed from: c, reason: collision with root package name */
    public String f26622c;

    public /* synthetic */ zzcmz(zzcmv zzcmvVar) {
        this.f26620a = zzcmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfcu
    public final /* bridge */ /* synthetic */ zzfcu a(Context context) {
        context.getClass();
        this.f26621b = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfcu
    public final /* bridge */ /* synthetic */ zzfcu b(String str) {
        str.getClass();
        this.f26622c = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfcu
    public final zzfcv zza() {
        zzijo.b(Context.class, this.f26621b);
        zzijo.b(String.class, this.f26622c);
        return new zzcna(this.f26620a, this.f26621b, this.f26622c);
    }
}
