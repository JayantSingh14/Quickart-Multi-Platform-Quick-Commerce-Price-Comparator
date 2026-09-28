package com.google.android.play.core.splitinstall.internal;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzbm extends zzk implements zzbo {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.core.splitinstall.internal.zzbo
    public final void E3(String str, zzbq zzbqVar) {
        Parcel parcelG = zzk.g();
        parcelG.writeString(str);
        int i2 = zzm.f41986a;
        parcelG.writeStrongBinder(zzbqVar);
        z0(6, parcelG);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.core.splitinstall.internal.zzbo
    public final void V7(String str, ArrayList arrayList, Bundle bundle, zzbq zzbqVar) {
        Parcel parcelG = zzk.g();
        parcelG.writeString(str);
        parcelG.writeTypedList(arrayList);
        int i2 = zzm.f41986a;
        parcelG.writeInt(1);
        bundle.writeToParcel(parcelG, 0);
        parcelG.writeStrongBinder(zzbqVar);
        z0(2, parcelG);
    }
}
