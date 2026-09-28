package com.google.android.gms.internal.ads;

import android.os.Parcel;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbxl extends zzbcb implements zzbxn {
    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void J0(List list) {
        Parcel parcelG = g();
        parcelG.writeTypedList(list);
        j1(1, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void c0(String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        j1(2, parcelG);
    }
}
