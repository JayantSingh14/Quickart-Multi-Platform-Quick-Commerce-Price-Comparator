package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IGoogleMapDelegate;

/* loaded from: classes4.dex */
final class zzad extends com.google.android.gms.maps.internal.zzas {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnMapReadyCallback f38583a;

    public zzad(OnMapReadyCallback onMapReadyCallback) {
        this.f38583a = onMapReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzat
    public final void D7(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f38583a.b(new GoogleMap(iGoogleMapDelegate));
    }
}
