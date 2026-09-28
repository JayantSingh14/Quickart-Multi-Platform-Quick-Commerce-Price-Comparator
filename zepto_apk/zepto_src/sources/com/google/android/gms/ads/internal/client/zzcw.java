package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbsz;

/* loaded from: classes4.dex */
public final class zzcw extends zzbcb implements zzcy {
    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final zzbsz getAdapterCreator() {
        Parcel parcelZ0 = z0(2, g());
        zzbsz zzbszVarXb = zzbsy.Xb(parcelZ0.readStrongBinder());
        parcelZ0.recycle();
        return zzbszVarXb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final zzfc getLiteSdkVersion() {
        Parcel parcelZ0 = z0(1, g());
        zzfc zzfcVar = (zzfc) zzbcd.b(parcelZ0, zzfc.CREATOR);
        parcelZ0.recycle();
        return zzfcVar;
    }
}
