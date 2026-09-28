package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class Polygon {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.maps.zzag f38511a;

    public Polygon(com.google.android.gms.internal.maps.zzag zzagVar) {
        this.f38511a = (com.google.android.gms.internal.maps.zzag) Preconditions.checkNotNull(zzagVar);
    }

    public final void a(boolean z) {
        try {
            this.f38511a.f0(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(int i2) {
        try {
            this.f38511a.a0(i2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void c(boolean z) {
        try {
            this.f38511a.h1(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void d(ArrayList arrayList) {
        try {
            this.f38511a.s2(arrayList);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void e(ArrayList arrayList) {
        try {
            Preconditions.checkNotNull(arrayList, "points must not be null.");
            this.f38511a.a3(arrayList);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        try {
            return this.f38511a.Za(((Polygon) obj).f38511a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void f(int i2) {
        try {
            this.f38511a.y0(i2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void g(ArrayList arrayList) {
        try {
            this.f38511a.i1(arrayList);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void h(float f2) {
        try {
            this.f38511a.Q(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f38511a.zzi();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void i(float f2) {
        try {
            this.f38511a.F3(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
