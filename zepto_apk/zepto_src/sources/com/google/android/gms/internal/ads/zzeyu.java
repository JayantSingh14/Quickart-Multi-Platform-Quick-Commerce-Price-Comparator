package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzeyu implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final String f30608a;

    /* renamed from: b, reason: collision with root package name */
    public final int f30609b;

    public zzeyu(String str, int i2) {
        this.f30608a = str;
        this.f30609b = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return zzgym.a(new zzeyv(this.f30608a, this.f30609b));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 31;
    }
}
