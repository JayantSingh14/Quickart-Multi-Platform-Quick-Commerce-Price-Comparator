package com.google.android.gms.internal.pal;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzfp extends zzfj implements zzfr {
    @Override // com.google.android.gms.internal.pal.zzfr
    public final String zze(IObjectWrapper iObjectWrapper, String str) {
        Parcel parcelG = g();
        zzfl.b(parcelG, iObjectWrapper);
        parcelG.writeString("");
        Parcel parcelZ0 = z0(8, parcelG);
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.pal.zzfr
    public final String zzg(IObjectWrapper iObjectWrapper, byte[] bArr) {
        Parcel parcelG = g();
        zzfl.b(parcelG, iObjectWrapper);
        parcelG.writeByteArray(null);
        Parcel parcelZ0 = z0(12, parcelG);
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.pal.zzfr
    public final String zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel parcelG = g();
        zzfl.b(parcelG, iObjectWrapper);
        zzfl.b(parcelG, iObjectWrapper2);
        zzfl.b(parcelG, iObjectWrapper3);
        Parcel parcelZ0 = z0(14, parcelG);
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.pal.zzfr
    public final void zzl(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzfl.b(parcelG, iObjectWrapper);
        j1(9, parcelG);
    }
}
