package com.google.android.gms.internal.maps;

import android.os.Parcel;
import com.google.android.gms.maps.model.Cap;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzah extends zza implements zzaj {
    @Override // com.google.android.gms.internal.maps.zzaj
    public final void M9(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(17, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void O9(ArrayList arrayList) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeTypedList(arrayList);
        j1(25, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void T3(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(13, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void f1(int i2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeInt(i2);
        j1(7, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void i1(ArrayList arrayList) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeTypedList(arrayList);
        j1(3, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void j0(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(9, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void r1(Cap cap) {
        Parcel parcelZ0 = z0();
        zzc.c(parcelZ0, cap);
        j1(21, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void u1(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        j1(5, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void w0(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(11, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final boolean x5(zzaj zzajVar) {
        Parcel parcelZ0 = z0();
        zzc.d(parcelZ0, zzajVar);
        Parcel parcelG = g(15, parcelZ0);
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void y8(Cap cap) {
        Parcel parcelZ0 = z0();
        zzc.c(parcelZ0, cap);
        j1(19, parcelZ0);
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final int zzh() {
        Parcel parcelG = g(16, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzp() {
        j1(1, z0());
    }
}
