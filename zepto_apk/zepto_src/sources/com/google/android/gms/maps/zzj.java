package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: classes4.dex */
final class zzj extends com.google.android.gms.maps.internal.zzao {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleMap.OnMapLoadedCallback f38633a;

    public zzj(GoogleMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.f38633a = onMapLoadedCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzap
    public final void zzb() {
        this.f38633a.a();
    }
}
