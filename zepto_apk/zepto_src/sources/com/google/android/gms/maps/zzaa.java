package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
final class zzaa extends com.google.android.gms.maps.internal.zzaq {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleMap.OnMapLongClickListener f38582a;

    public zzaa(GoogleMap.OnMapLongClickListener onMapLongClickListener) {
        this.f38582a = onMapLongClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzar
    public final void D0(LatLng latLng) {
        this.f38582a.a(latLng);
    }
}
