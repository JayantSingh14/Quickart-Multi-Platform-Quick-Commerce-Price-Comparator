package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class GroundOverlay {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.maps.zzr f38460a;

    public GroundOverlay(com.google.android.gms.internal.maps.zzr zzrVar) {
        this.f38460a = (com.google.android.gms.internal.maps.zzr) Preconditions.checkNotNull(zzrVar);
    }

    public final void a(float f2) {
        try {
            this.f38460a.Ka(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(boolean z) {
        try {
            this.f38460a.f0(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void c(BitmapDescriptor bitmapDescriptor) {
        Preconditions.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        try {
            this.f38460a.x4(bitmapDescriptor.f38433a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void d(LatLngBounds latLngBounds) {
        try {
            this.f38460a.G1(latLngBounds);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void e(float f2) {
        try {
            this.f38460a.P2(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.f38460a.X7(((GroundOverlay) obj).f38460a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void f(boolean z) {
        try {
            this.f38460a.L0(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void g(float f2) {
        try {
            this.f38460a.z6(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f38460a.zzi();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
