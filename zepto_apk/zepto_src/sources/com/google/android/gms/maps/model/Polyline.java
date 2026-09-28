package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzaj;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class Polyline {

    /* renamed from: a, reason: collision with root package name */
    public final zzaj f38523a;

    public Polyline(zzaj zzajVar) {
        this.f38523a = (zzaj) Preconditions.checkNotNull(zzajVar);
    }

    public final void a(boolean z) {
        try {
            this.f38523a.M9(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(int i2) {
        try {
            this.f38523a.f1(i2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void c(Cap cap) {
        Preconditions.checkNotNull(cap, "endCap must not be null");
        try {
            this.f38523a.r1(cap);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void d(boolean z) {
        try {
            this.f38523a.T3(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void e(ArrayList arrayList) {
        try {
            this.f38523a.O9(arrayList);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.f38523a.x5(((Polyline) obj).f38523a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void f(ArrayList arrayList) {
        Preconditions.checkNotNull(arrayList, "points must not be null");
        try {
            this.f38523a.i1(arrayList);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void g(Cap cap) {
        Preconditions.checkNotNull(cap, "startCap must not be null");
        try {
            this.f38523a.y8(cap);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void h(float f2) {
        try {
            this.f38523a.u1(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f38523a.zzh();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void i(float f2) {
        try {
            this.f38523a.j0(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
