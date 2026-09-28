package com.google.android.gms.maps;

import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.MarkerManager;

/* loaded from: classes4.dex */
final class zzb extends com.google.android.gms.maps.internal.zzaw {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarkerManager f38628a;

    public zzb(MarkerManager markerManager) {
        this.f38628a = markerManager;
    }

    @Override // com.google.android.gms.maps.internal.zzax
    public final void d(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f38628a.l(new Marker(zzadVar));
    }

    @Override // com.google.android.gms.maps.internal.zzax
    public final void q0(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f38628a.m(new Marker(zzadVar));
    }

    @Override // com.google.android.gms.maps.internal.zzax
    public final void sa(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f38628a.n(new Marker(zzadVar));
    }
}
