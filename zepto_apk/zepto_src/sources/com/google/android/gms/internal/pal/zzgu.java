package com.google.android.gms.internal.pal;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzgu extends zzfj implements zzgw {
    @Override // com.google.android.gms.internal.pal.zzgw
    public final void ia(Bundle bundle, zzgt zzgtVar) {
        Parcel parcelG = g();
        int i2 = zzfl.f37734a;
        parcelG.writeInt(1);
        bundle.writeToParcel(parcelG, 0);
        zzfl.b(parcelG, zzgtVar);
        try {
            this.f37732a.transact(1, parcelG, null, 1);
        } finally {
            parcelG.recycle();
        }
    }
}
