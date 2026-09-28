package com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzba;

/* loaded from: classes4.dex */
final class zzg extends zzba {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleMap.OnMyLocationChangeListener f38632a;

    public zzg(GoogleMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.f38632a = onMyLocationChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbb
    public final void N(IObjectWrapper iObjectWrapper) {
        this.f38632a.a((Location) ObjectWrapper.z0(iObjectWrapper));
    }
}
