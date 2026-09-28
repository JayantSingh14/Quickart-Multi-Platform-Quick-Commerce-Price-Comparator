package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbce extends zzbcb implements zzbcg {
    @Override // com.google.android.gms.internal.ads.zzbcg
    public final void A(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(7, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbcg
    public final void S4(byte[] bArr) {
        Parcel parcelG = g();
        parcelG.writeByteArray(bArr);
        j1(5, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbcg
    public final void g1(ObjectWrapper objectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, objectWrapper);
        parcelG.writeString("GMA_SDK");
        j1(2, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbcg
    public final void g2() {
        Parcel parcelG = g();
        parcelG.writeIntArray(null);
        j1(4, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbcg
    public final void zzf() {
        j1(3, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbcg
    public final void zzi(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(0);
        j1(6, parcelG);
    }
}
