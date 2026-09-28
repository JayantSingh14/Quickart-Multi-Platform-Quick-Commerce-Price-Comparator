package com.google.android.gms.maps;

import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.MarkerManager;

/* loaded from: classes4.dex */
final class zza extends com.google.android.gms.maps.internal.zzau {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarkerManager f38581a;

    public zza(MarkerManager markerManager) {
        this.f38581a = markerManager;
    }

    @Override // com.google.android.gms.maps.internal.zzav
    public final boolean d(com.google.android.gms.internal.maps.zzad zzadVar) {
        return this.f38581a.g(new Marker(zzadVar));
    }
}
