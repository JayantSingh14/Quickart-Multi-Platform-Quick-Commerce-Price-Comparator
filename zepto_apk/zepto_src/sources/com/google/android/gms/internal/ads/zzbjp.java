package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzbjp extends zzbcb implements zzbjr {
    public zzbjp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzbjr
    public final String zzb() {
        Parcel parcelZ0 = z0(2, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbjr
    public final ArrayList zzc() {
        Parcel parcelZ0 = z0(3, g());
        ArrayList arrayList = parcelZ0.readArrayList(zzbcd.f24690a);
        parcelZ0.recycle();
        return arrayList;
    }
}
