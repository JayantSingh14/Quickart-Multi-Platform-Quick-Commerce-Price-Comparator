package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbe;
import com.google.android.gms.maps.model.PointOfInterest;

/* loaded from: classes4.dex */
final class zzr extends zzbe {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleMap.OnPoiClickListener f38641a;

    public zzr(GoogleMap.OnPoiClickListener onPoiClickListener) {
        this.f38641a = onPoiClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbf
    public final void R1(PointOfInterest pointOfInterest) {
        this.f38641a.a(pointOfInterest);
    }
}
