package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbv extends com.google.android.gms.internal.maps.zzb implements zzbw {
    public zzbv() {
        super("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            Bitmap bitmap = (Bitmap) com.google.android.gms.internal.maps.zzc.a(parcel, Bitmap.CREATOR);
            com.google.android.gms.internal.maps.zzc.b(parcel);
            p8(bitmap);
        } else {
            if (i2 != 2) {
                return false;
            }
            IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.b(parcel);
            n6(iObjectWrapperG);
        }
        parcel2.writeNoException();
        return true;
    }
}
