package com.google.android.gms.maps;

import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.MarkerManager;

/* loaded from: classes4.dex */
final class zzf extends com.google.android.gms.maps.internal.zzh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarkerManager f38631a;

    public zzf(MarkerManager markerManager) {
        this.f38631a = markerManager;
    }

    @Override // com.google.android.gms.maps.internal.zzi
    public final ObjectWrapper d(com.google.android.gms.internal.maps.zzad zzadVar) {
        return new ObjectWrapper(this.f38631a.c(new Marker(zzadVar)));
    }

    @Override // com.google.android.gms.maps.internal.zzi
    public final ObjectWrapper q0(com.google.android.gms.internal.maps.zzad zzadVar) {
        return new ObjectWrapper(this.f38631a.f(new Marker(zzadVar)));
    }
}
