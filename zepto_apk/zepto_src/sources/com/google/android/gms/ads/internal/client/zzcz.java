package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbpt;
import com.google.android.gms.internal.ads.zzbsz;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzcz extends zzbcb implements zzdb {
    public zzcz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void I2(zzfv zzfvVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzfvVar);
        j1(14, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void T1(IObjectWrapper iObjectWrapper, String str) {
        Parcel parcelG = g();
        parcelG.writeString(null);
        zzbcd.e(parcelG, iObjectWrapper);
        j1(6, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void Y0(String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        j1(18, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void d5(zzbsz zzbszVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbszVar);
        j1(11, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void j() {
        j1(19, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void v2(zzbpt zzbptVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbptVar);
        j1(12, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zze() {
        j1(1, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final List zzq() {
        Parcel parcelZ0 = z0(13, g());
        ArrayList arrayListCreateTypedArrayList = parcelZ0.createTypedArrayList(zzbpm.CREATOR);
        parcelZ0.recycle();
        return arrayListCreateTypedArrayList;
    }
}
