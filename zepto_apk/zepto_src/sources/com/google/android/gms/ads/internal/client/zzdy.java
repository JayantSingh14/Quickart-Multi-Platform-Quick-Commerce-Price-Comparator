package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzdy extends zzbcb implements zzea {
    public zzdy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final String zze() {
        Parcel parcelZ0 = z0(1, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final String zzf() {
        Parcel parcelZ0 = z0(2, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final List zzg() {
        Parcel parcelZ0 = z0(3, g());
        ArrayList arrayListCreateTypedArrayList = parcelZ0.createTypedArrayList(zzv.CREATOR);
        parcelZ0.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final zzv zzh() {
        Parcel parcelZ0 = z0(4, g());
        zzv zzvVar = (zzv) zzbcd.b(parcelZ0, zzv.CREATOR);
        parcelZ0.recycle();
        return zzvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final Bundle zzi() {
        Parcel parcelZ0 = z0(5, g());
        Bundle bundle = (Bundle) zzbcd.b(parcelZ0, Bundle.CREATOR);
        parcelZ0.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final String zzj() {
        Parcel parcelZ0 = z0(6, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }
}
