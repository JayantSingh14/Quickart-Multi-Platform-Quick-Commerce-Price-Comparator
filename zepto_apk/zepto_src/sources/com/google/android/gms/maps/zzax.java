package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzbs;

/* loaded from: classes4.dex */
final class zzax extends zzbs {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnStreetViewPanoramaReadyCallback f38621a;

    public zzax(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.f38621a = onStreetViewPanoramaReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzbt
    public final void g7(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        new StreetViewPanorama(iStreetViewPanoramaDelegate);
        this.f38621a.a();
    }
}
