package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbww extends zzbcb implements zzbwy {
    public zzbww(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void B() {
        j1(8, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void J(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(13, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void Q2(int i2, int i3, Intent intent) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        parcelG.writeInt(i3);
        zzbcd.c(parcelG, intent);
        j1(12, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void R7(int i2, String[] strArr, int[] iArr) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        parcelG.writeStringArray(strArr);
        parcelG.writeIntArray(iArr);
        j1(15, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void e1() {
        j1(7, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void n0(Bundle bundle) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, bundle);
        Parcel parcelZ0 = z0(6, parcelG);
        if (parcelZ0.readInt() != 0) {
            bundle.readFromParcel(parcelZ0);
        }
        parcelZ0.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void t6(Bundle bundle) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, bundle);
        j1(1, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zze() {
        j1(10, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzf() {
        j1(14, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final boolean zzg() {
        Parcel parcelZ0 = z0(11, g());
        ClassLoader classLoader = zzbcd.f24690a;
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzi() {
        j1(2, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzj() {
        j1(3, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzk() {
        j1(4, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzl() {
        j1(5, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzs() {
        j1(9, g());
    }
}
