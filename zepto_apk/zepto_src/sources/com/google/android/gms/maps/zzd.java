package com.google.android.gms.maps;

import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.MarkerManager;

/* loaded from: classes4.dex */
final class zzd extends com.google.android.gms.maps.internal.zzag {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarkerManager f38630a;

    public zzd(MarkerManager markerManager) {
        this.f38630a = markerManager;
    }

    @Override // com.google.android.gms.maps.internal.zzah
    public final void d(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f38630a.k(new Marker(zzadVar));
    }
}
