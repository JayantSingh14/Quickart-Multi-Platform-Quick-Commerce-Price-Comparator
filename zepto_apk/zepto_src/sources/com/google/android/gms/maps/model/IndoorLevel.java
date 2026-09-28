package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class IndoorLevel {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.maps.zzx f38474a;

    public IndoorLevel(com.google.android.gms.internal.maps.zzx zzxVar) {
        this.f38474a = (com.google.android.gms.internal.maps.zzx) Preconditions.checkNotNull(zzxVar);
    }

    public final void a() {
        try {
            this.f38474a.zzg();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final String b() {
        try {
            return this.f38474a.zze();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final String c() {
        try {
            return this.f38474a.zzf();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.f38474a.Ha(((IndoorLevel) obj).f38474a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f38474a.zzd();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
