package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

/* loaded from: classes4.dex */
public final class Projection {

    /* renamed from: a, reason: collision with root package name */
    public final IProjectionDelegate f38417a;

    public Projection(IProjectionDelegate iProjectionDelegate) {
        this.f38417a = iProjectionDelegate;
    }

    public final LatLng a(Point point) {
        Preconditions.checkNotNull(point);
        try {
            return this.f38417a.S9(new ObjectWrapper(point));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final VisibleRegion b() {
        try {
            return this.f38417a.t3();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final Point c(LatLng latLng) {
        Preconditions.checkNotNull(latLng);
        try {
            return (Point) ObjectWrapper.z0(this.f38417a.W2(latLng));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
