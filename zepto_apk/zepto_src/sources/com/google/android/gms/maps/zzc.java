package com.google.android.gms.maps;

import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.MarkerManager;

/* loaded from: classes4.dex */
final class zzc extends com.google.android.gms.maps.internal.zzac {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarkerManager f38629a;

    public zzc(MarkerManager markerManager) {
        this.f38629a = markerManager;
    }

    @Override // com.google.android.gms.maps.internal.zzad
    public final void d(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f38629a.a(new Marker(zzadVar));
    }
}
