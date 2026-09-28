package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbo extends zzbl implements zzbq {
    @Override // com.google.android.gms.internal.measurement.zzbq
    public final Bundle W(Bundle bundle) {
        Parcel parcelZ0 = z0();
        zzbn.c(parcelZ0, bundle);
        Parcel parcelG = g(1, parcelZ0);
        Bundle bundle2 = (Bundle) zzbn.b(parcelG, Bundle.CREATOR);
        parcelG.recycle();
        return bundle2;
    }
}
