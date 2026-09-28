package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzfy extends com.google.android.gms.internal.measurement.zzbl implements zzga {
    public zzfy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void B8(zzr zzrVar, Bundle bundle, zzgd zzgdVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, bundle);
        com.google.android.gms.internal.measurement.zzbn.d(parcelZ0, zzgdVar);
        j1(31, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void C1(zzah zzahVar, zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzahVar);
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(12, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void D5(zzr zzrVar, zzon zzonVar, zzgg zzggVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzonVar);
        com.google.android.gms.internal.measurement.zzbn.d(parcelZ0, zzggVar);
        j1(29, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void J7(long j2, String str, String str2, String str3) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeLong(j2);
        parcelZ0.writeString(str);
        parcelZ0.writeString(str2);
        parcelZ0.writeString(str3);
        j1(10, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void M7(zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(18, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void Nb(zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(20, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final zzao V9(zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        Parcel parcelG = g(21, parcelZ0);
        zzao zzaoVar = (zzao) com.google.android.gms.internal.measurement.zzbn.b(parcelG, zzao.CREATOR);
        parcelG.recycle();
        return zzaoVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void Wa(zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(27, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final List Z2(String str, String str2, String str3) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(null);
        parcelZ0.writeString(str2);
        parcelZ0.writeString(str3);
        Parcel parcelG = g(17, parcelZ0);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(zzah.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void aa(Bundle bundle, zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, bundle);
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(19, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void e4(zzbg zzbgVar, zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzbgVar);
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(1, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final List fb(String str, String str2, boolean z, zzr zzrVar) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeString(str2);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.zzbn.f36803a;
        parcelZ0.writeInt(z ? 1 : 0);
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        Parcel parcelG = g(14, parcelZ0);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(zzpk.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void h4(zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(6, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void h9(zzpk zzpkVar, zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzpkVar);
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(2, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final String j6(zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        Parcel parcelG = g(11, parcelZ0);
        String string = parcelG.readString();
        parcelG.recycle();
        return string;
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void m4(zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(26, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void p3(zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(25, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final List pb(String str, String str2, zzr zzrVar) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeString(str2);
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        Parcel parcelG = g(16, parcelZ0);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(zzah.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final byte[] v4(zzbg zzbgVar, String str) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzbgVar);
        parcelZ0.writeString(str);
        Parcel parcelG = g(9, parcelZ0);
        byte[] bArrCreateByteArray = parcelG.createByteArray();
        parcelG.recycle();
        return bArrCreateByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void y9(zzr zzrVar, zzaf zzafVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzafVar);
        j1(30, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void ya(zzr zzrVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzrVar);
        j1(4, parcelZ0);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final List z1(String str, String str2, String str3, boolean z) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(null);
        parcelZ0.writeString(str2);
        parcelZ0.writeString(str3);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.zzbn.f36803a;
        parcelZ0.writeInt(z ? 1 : 0);
        Parcel parcelG = g(15, parcelZ0);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(zzpk.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }
}
