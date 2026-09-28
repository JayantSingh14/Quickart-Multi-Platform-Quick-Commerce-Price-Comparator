package com.google.android.gms.maps;

import com.google.android.gms.maps.model.GroundOverlay;
import com.google.maps.android.collections.GroundOverlayManager;

/* loaded from: classes4.dex */
final class zzm extends com.google.android.gms.maps.internal.zzy {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GroundOverlayManager f38636a;

    public zzm(GroundOverlayManager groundOverlayManager) {
        this.f38636a = groundOverlayManager;
    }

    @Override // com.google.android.gms.maps.internal.zzz
    public final void H3(com.google.android.gms.internal.maps.zzr zzrVar) {
        this.f38636a.d(new GroundOverlay(zzrVar));
    }
}
