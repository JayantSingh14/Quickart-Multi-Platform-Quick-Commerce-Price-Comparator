package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IGoogleMapDelegate;

/* loaded from: classes4.dex */
final class zzau extends com.google.android.gms.maps.internal.zzas {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnMapReadyCallback f38614a;

    public zzau(OnMapReadyCallback onMapReadyCallback) {
        this.f38614a = onMapReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzat
    public final void D7(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f38614a.b(new GoogleMap(iGoogleMapDelegate));
    }
}
