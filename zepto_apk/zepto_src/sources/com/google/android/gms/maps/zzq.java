package com.google.android.gms.maps;

import android.graphics.Bitmap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbv;

/* loaded from: classes4.dex */
final class zzq extends zzbv {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoogleMap.SnapshotReadyCallback f38640a;

    public zzq(GoogleMap.SnapshotReadyCallback snapshotReadyCallback) {
        this.f38640a = snapshotReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzbw
    public final void n6(IObjectWrapper iObjectWrapper) {
        this.f38640a.a((Bitmap) ObjectWrapper.z0(iObjectWrapper));
    }

    @Override // com.google.android.gms.maps.internal.zzbw
    public final void p8(Bitmap bitmap) {
        this.f38640a.a(bitmap);
    }
}
