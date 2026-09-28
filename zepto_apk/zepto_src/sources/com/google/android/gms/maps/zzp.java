package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.zzbi;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.collections.PolylineManager;

/* loaded from: classes4.dex */
final class zzp extends zzbi {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PolylineManager f38639a;

    public zzp(PolylineManager polylineManager) {
        this.f38639a = polylineManager;
    }

    @Override // com.google.android.gms.maps.internal.zzbj
    public final void Y7(com.google.android.gms.internal.maps.zzaj zzajVar) {
        this.f38639a.b(new Polyline(zzajVar));
    }
}
