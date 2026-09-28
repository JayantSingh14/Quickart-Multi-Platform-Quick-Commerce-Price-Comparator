package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public final class zzeb extends zzbcb implements zzed {
    public zzeb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void D1(zzeg zzegVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzegVar);
        j1(8, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzj() {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzk() {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzm() {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final zzeg zzo() {
        zzeg zzeeVar;
        Parcel parcelZ0 = z0(11, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzeeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            zzeeVar = iInterfaceQueryLocalInterface instanceof zzeg ? (zzeg) iInterfaceQueryLocalInterface : new zzee(strongBinder);
        }
        parcelZ0.recycle();
        return zzeeVar;
    }
}
