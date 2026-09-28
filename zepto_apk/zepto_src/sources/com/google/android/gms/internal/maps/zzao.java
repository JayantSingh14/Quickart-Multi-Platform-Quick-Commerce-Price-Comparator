package com.google.android.gms.internal.maps;

import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

/* loaded from: classes4.dex */
public abstract class zzao extends zzb implements zzap {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f36713a = 0;

    public zzao() {
        super("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        int i3 = parcel.readInt();
        int i4 = parcel.readInt();
        int i5 = parcel.readInt();
        zzc.b(parcel);
        Tile tileO4 = O4(i3, i4, i5);
        parcel2.writeNoException();
        if (tileO4 == null) {
            parcel2.writeInt(0);
            return true;
        }
        parcel2.writeInt(1);
        tileO4.writeToParcel(parcel2, 1);
        return true;
    }
}
