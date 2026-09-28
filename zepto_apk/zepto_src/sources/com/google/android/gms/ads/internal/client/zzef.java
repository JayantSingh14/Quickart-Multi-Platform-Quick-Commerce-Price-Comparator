package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public abstract class zzef extends zzbcc implements zzeg {
    public zzef() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            throw null;
        }
        if (i2 != 5) {
            return false;
        }
        zzbcd.a(parcel);
        zzbcd.f(parcel);
        throw null;
    }
}
