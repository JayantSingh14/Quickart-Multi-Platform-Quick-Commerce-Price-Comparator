package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbya extends zzbcc implements zzbyb {
    public zzbya() {
        super("com.google.android.gms.ads.internal.report.IDynamiteErrorEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        com.google.android.gms.ads.internal.zzt.C.f21684h.d("FlagsAccessedBeforeInitialized", new zzbxy("Flags were accessed before initialized."));
        parcel2.writeNoException();
        return true;
    }
}
