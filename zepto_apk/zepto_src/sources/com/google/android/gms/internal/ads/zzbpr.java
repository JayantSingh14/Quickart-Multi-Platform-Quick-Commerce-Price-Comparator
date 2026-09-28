package com.google.android.gms.internal.ads;

import android.os.Parcel;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbpr extends zzbcb implements zzbpt {
    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void r5(List list) {
        Parcel parcelG = g();
        parcelG.writeTypedList(list);
        j1(1, parcelG);
    }
}
