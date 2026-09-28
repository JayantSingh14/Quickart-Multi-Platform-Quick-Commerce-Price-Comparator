package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: classes4.dex */
final class zzy extends com.google.android.gms.maps.internal.zzo {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleMap.OnCameraIdleListener f38645a;

    public zzy(GoogleMap.OnCameraIdleListener onCameraIdleListener) {
        this.f38645a = onCameraIdleListener;
    }

    @Override // com.google.android.gms.maps.internal.zzp
    public final void zzb() {
        this.f38645a.b();
    }
}
