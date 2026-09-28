package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: classes4.dex */
final class zzw extends com.google.android.gms.maps.internal.zzs {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleMap.OnCameraMoveListener f38644a;

    public zzw(GoogleMap.OnCameraMoveListener onCameraMoveListener) {
        this.f38644a = onCameraMoveListener;
    }

    @Override // com.google.android.gms.maps.internal.zzt
    public final void zzb() {
        this.f38644a.a();
    }
}
