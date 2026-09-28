package com.google.android.gms.internal.maps;

import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

/* loaded from: classes4.dex */
public final class zzan extends zza implements zzap {
    @Override // com.google.android.gms.internal.maps.zzap
    public final Tile O4(int i2, int i3, int i4) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeInt(i2);
        parcelZ0.writeInt(i3);
        parcelZ0.writeInt(i4);
        Parcel parcelG = g(1, parcelZ0);
        Tile tile = (Tile) zzc.a(parcelG, Tile.CREATOR);
        parcelG.recycle();
        return tile;
    }
}
