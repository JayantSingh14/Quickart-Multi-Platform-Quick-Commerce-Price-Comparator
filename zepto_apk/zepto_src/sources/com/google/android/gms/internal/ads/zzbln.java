package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbln extends zzbcb implements zzblp {
    @Override // com.google.android.gms.internal.ads.zzblp
    public final void q(String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        j1(1, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final void zzf() {
        j1(2, g());
    }
}
