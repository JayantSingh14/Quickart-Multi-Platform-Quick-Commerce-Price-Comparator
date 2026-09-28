package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
final class zzz extends com.google.android.gms.maps.internal.zzam {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleMap.OnMapClickListener f38646a;

    public zzz(GoogleMap.OnMapClickListener onMapClickListener) {
        this.f38646a = onMapClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzan
    public final void D0(LatLng latLng) {
        this.f38646a.a(latLng);
    }
}
