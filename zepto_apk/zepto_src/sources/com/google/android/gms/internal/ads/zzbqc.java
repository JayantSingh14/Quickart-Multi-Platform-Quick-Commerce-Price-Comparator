package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbqc extends zzbcb implements zzbqe {
    @Override // com.google.android.gms.internal.ads.zzbqe
    public final void zze() {
        j1(1, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbqe
    public final void zzf(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(2, parcelG);
    }
}
