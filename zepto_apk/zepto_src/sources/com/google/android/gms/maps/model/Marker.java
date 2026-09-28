package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public class Marker {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.maps.zzad f38485a;

    public Marker(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f38485a = (com.google.android.gms.internal.maps.zzad) Preconditions.checkNotNull(zzadVar);
    }

    public final LatLng a() {
        try {
            return this.f38485a.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final String b() {
        try {
            return this.f38485a.zzm();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void c() {
        try {
            this.f38485a.zzn();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void d(float f2) {
        try {
            this.f38485a.mb(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void e(float f2, float f3) {
        try {
            this.f38485a.A9(f2, f3);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        try {
            return this.f38485a.ab(((Marker) obj).f38485a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void f(boolean z) {
        try {
            this.f38485a.h1(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void g(boolean z) {
        try {
            this.f38485a.k3(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void h(BitmapDescriptor bitmapDescriptor) {
        com.google.android.gms.internal.maps.zzad zzadVar = this.f38485a;
        try {
            if (bitmapDescriptor == null) {
                zzadVar.S(null);
            } else {
                zzadVar.S(bitmapDescriptor.f38433a);
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f38485a.zzg();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void i(float f2, float f3) {
        try {
            this.f38485a.L1(f2, f3);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void j(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        try {
            this.f38485a.w2(latLng);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void k(float f2) {
        try {
            this.f38485a.Q(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void l(String str) {
        try {
            this.f38485a.U9(str);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void m(String str) {
        try {
            this.f38485a.P0(str);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void n(float f2) {
        try {
            this.f38485a.j0(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void o() {
        try {
            this.f38485a.k();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
