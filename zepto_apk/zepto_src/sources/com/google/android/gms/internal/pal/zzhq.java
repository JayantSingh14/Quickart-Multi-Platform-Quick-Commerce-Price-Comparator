package com.google.android.gms.internal.pal;

import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzhq extends zzfj implements zzhs {
    @Override // com.google.android.gms.internal.pal.zzhs
    public final void g1(ObjectWrapper objectWrapper) {
        Parcel parcelG = g();
        zzfl.b(parcelG, objectWrapper);
        parcelG.writeString("ADSHIELD");
        parcelG.writeString(null);
        j1(8, parcelG);
    }

    @Override // com.google.android.gms.internal.pal.zzhs
    public final void zzf() {
        j1(3, g());
    }

    @Override // com.google.android.gms.internal.pal.zzhs
    public final void zzg(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(7, parcelG);
    }

    @Override // com.google.android.gms.internal.pal.zzhs
    public final void zzh() {
        Parcel parcelG = g();
        parcelG.writeIntArray(null);
        j1(4, parcelG);
    }

    @Override // com.google.android.gms.internal.pal.zzhs
    public final void zzi(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(6, parcelG);
    }

    @Override // com.google.android.gms.internal.pal.zzhs
    public final void zzj(byte[] bArr) {
        Parcel parcelG = g();
        parcelG.writeByteArray(bArr);
        j1(5, parcelG);
    }
}
