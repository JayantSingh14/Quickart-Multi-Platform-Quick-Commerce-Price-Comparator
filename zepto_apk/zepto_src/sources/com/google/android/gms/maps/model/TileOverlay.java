package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzam;

/* loaded from: classes4.dex */
public final class TileOverlay {

    /* renamed from: a, reason: collision with root package name */
    public final zzam f38563a;

    public TileOverlay(zzam zzamVar) {
        this.f38563a = (zzam) Preconditions.checkNotNull(zzamVar);
    }

    public final void a() {
        try {
            this.f38563a.zzh();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b() {
        try {
            this.f38563a.zzi();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void c(float f2) {
        try {
            this.f38563a.r8(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void d(float f2) {
        try {
            this.f38563a.Q0(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.f38563a.Ib(((TileOverlay) obj).f38563a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f38563a.zzf();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
