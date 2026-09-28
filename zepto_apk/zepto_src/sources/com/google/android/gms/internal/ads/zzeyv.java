package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzeyv implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30610a;

    /* renamed from: b, reason: collision with root package name */
    public final int f30611b;

    public zzeyv(String str, int i2) {
        this.f30610a = str;
        this.f30611b = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        bundle.putString("request_id", this.f30610a);
        if (this.f30611b == 2) {
            bundle.putInt("sod", 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzczm) obj).f27482b.putString("request_id", this.f30610a);
    }
}
