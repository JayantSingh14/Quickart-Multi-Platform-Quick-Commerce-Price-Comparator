package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbwp extends zzbcb implements zzbwr {
    public zzbwp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    @Override // com.google.android.gms.internal.ads.zzbwr
    public final void Bb(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzaVar);
        j1(6, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbwr
    public final void X0(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(4, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbwr
    public final void q1(Intent intent) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, intent);
        j1(1, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbwr
    public final void q6(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        parcelG.writeStringArray(strArr);
        parcelG.writeIntArray(iArr);
        zzbcd.e(parcelG, iObjectWrapper);
        j1(5, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbwr
    public final void zzg() {
        j1(3, g());
    }
}
