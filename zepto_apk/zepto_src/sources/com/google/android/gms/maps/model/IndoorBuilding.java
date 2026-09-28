package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class IndoorBuilding {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.maps.zzu f38473a;

    public IndoorBuilding(com.google.android.gms.internal.maps.zzu zzuVar) {
        zzh zzhVar = zzh.f38580a;
        this.f38473a = (com.google.android.gms.internal.maps.zzu) Preconditions.checkNotNull(zzuVar, "delegate");
    }

    public final int a() {
        try {
            return this.f38473a.zzd();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final ArrayList b() {
        com.google.android.gms.internal.maps.zzx zzvVar;
        try {
            ArrayList<IBinder> arrayListZzg = this.f38473a.zzg();
            ArrayList arrayList = new ArrayList(arrayListZzg.size());
            for (IBinder iBinder : arrayListZzg) {
                int i2 = com.google.android.gms.internal.maps.zzw.f36743a;
                if (iBinder == null) {
                    zzvVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    zzvVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzx ? (com.google.android.gms.internal.maps.zzx) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzv(iBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                }
                arrayList.add(new IndoorLevel(zzvVar));
            }
            return arrayList;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.f38473a.o9(((IndoorBuilding) obj).f38473a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f38473a.zzf();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
