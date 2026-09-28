package com.google.android.gms.internal.maps;

import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzae extends zza implements zzag {
    @Override // com.google.android.gms.internal.maps.zzag
    public final void C0(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(15, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void F3(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(13, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void Q(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(7, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final boolean Za(zzag zzagVar) {
        Parcel parcelZ0 = z0();
        zzc.d(parcelZ0, zzagVar);
        Parcel parcelG = g(19, parcelZ0);
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void a0(int i2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeInt(i2);
        j1(11, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void a3(ArrayList arrayList) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeTypedList(arrayList);
        j1(3, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void f0(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(21, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void h1(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(17, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void i1(ArrayList arrayList) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeTypedList(arrayList);
        j1(25, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void s2(ArrayList arrayList) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeList(arrayList);
        j1(5, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void y0(int i2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeInt(i2);
        j1(9, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final int zzi() {
        Parcel parcelG = g(20, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.maps.zzag
    public final void zzo() {
        j1(1, z0());
    }
}
