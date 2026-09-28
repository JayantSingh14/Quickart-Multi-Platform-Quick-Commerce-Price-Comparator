package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IGoogleMapDelegate;

/* loaded from: classes4.dex */
final class zzag extends com.google.android.gms.maps.internal.zzas {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnMapReadyCallback f38590a;

    public zzag(OnMapReadyCallback onMapReadyCallback) {
        this.f38590a = onMapReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzat
    public final void D7(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f38590a.b(new GoogleMap(iGoogleMapDelegate));
    }
}
