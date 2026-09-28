package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: classes4.dex */
final class zzv extends com.google.android.gms.maps.internal.zzu {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleMap.OnCameraMoveStartedListener f38643a;

    public zzv(GoogleMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.f38643a = onCameraMoveStartedListener;
    }

    @Override // com.google.android.gms.maps.internal.zzv
    public final void zzb(int i2) {
        this.f38643a.a(i2);
    }
}
