package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzfwc extends zzbcb implements zzfwe {
    @Override // com.google.android.gms.internal.ads.zzfwe
    public final void F5() {
        Parcel parcelG = g();
        parcelG.writeIntArray(null);
        j1(4, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzfwe
    public final void V3(ObjectWrapper objectWrapper, String str) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, objectWrapper);
        parcelG.writeString(str);
        parcelG.writeString(null);
        j1(8, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzfwe
    public final void r4(byte[] bArr) {
        Parcel parcelG = g();
        parcelG.writeByteArray(bArr);
        j1(5, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzfwe
    public final void zze() {
        j1(3, g());
    }

    @Override // com.google.android.gms.internal.ads.zzfwe
    public final void zzh(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(6, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzfwe
    public final void zzi(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(7, parcelG);
    }
}
