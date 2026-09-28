package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes4.dex */
final class zzl implements LocationSource.OnLocationChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.maps.internal.zzaj f38635a;

    public zzl(com.google.android.gms.maps.internal.zzaj zzajVar) {
        this.f38635a = zzajVar;
    }

    @Override // com.google.android.gms.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        try {
            this.f38635a.h0(location);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
