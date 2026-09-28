package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* loaded from: classes4.dex */
public final class zzfs extends zzds {

    /* renamed from: a, reason: collision with root package name */
    public final OnPaidEventListener f21238a;

    public zzfs(OnPaidEventListener onPaidEventListener) {
        this.f21238a = onPaidEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final void va(zzt zztVar) {
        OnPaidEventListener onPaidEventListener = this.f21238a;
        if (onPaidEventListener != null) {
            onPaidEventListener.f(new AdValue(zztVar.f21295b, zztVar.f21297d, zztVar.f21296c));
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final boolean zzf() {
        return this.f21238a == null;
    }
}
