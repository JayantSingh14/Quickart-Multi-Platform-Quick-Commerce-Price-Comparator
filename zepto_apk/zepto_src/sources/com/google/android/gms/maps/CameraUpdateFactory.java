package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes4.dex */
public final class CameraUpdateFactory {

    /* renamed from: a, reason: collision with root package name */
    public static ICameraUpdateFactoryDelegate f38394a;

    public static CameraUpdate a(CameraPosition cameraPosition) {
        Preconditions.checkNotNull(cameraPosition, "cameraPosition must not be null");
        try {
            return new CameraUpdate(((ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(f38394a, "CameraUpdateFactory is not initialized")).M4(cameraPosition));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate b(LatLngBounds latLngBounds) {
        Preconditions.checkNotNull(latLngBounds, "bounds must not be null");
        try {
            return new CameraUpdate(((ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(f38394a, "CameraUpdateFactory is not initialized")).W3(latLngBounds));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate c(LatLngBounds latLngBounds, int i2, int i3) {
        Preconditions.checkNotNull(latLngBounds, "bounds must not be null");
        try {
            return new CameraUpdate(((ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(f38394a, "CameraUpdateFactory is not initialized")).k7(latLngBounds, i2, i3));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate d(LatLng latLng) {
        Preconditions.checkNotNull(latLng, "latLng must not be null");
        try {
            return new CameraUpdate(((ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(f38394a, "CameraUpdateFactory is not initialized")).r2(latLng));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
