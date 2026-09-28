package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.zzbg;
import com.google.android.gms.maps.model.Polygon;
import com.google.maps.android.collections.PolygonManager;

/* loaded from: classes4.dex */
final class zzo extends zzbg {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PolygonManager f38638a;

    public zzo(PolygonManager polygonManager) {
        this.f38638a = polygonManager;
    }

    @Override // com.google.android.gms.maps.internal.zzbh
    public final void H9(com.google.android.gms.internal.maps.zzag zzagVar) {
        this.f38638a.e(new Polygon(zzagVar));
    }
}
