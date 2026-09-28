package com.google.android.gms.internal.pal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public abstract class zzgs extends zzfk implements zzgt {
    public zzgs() {
        super("com.google.android.gms.ads.signalsdk.ISignalSdkCallback");
    }

    @Override // com.google.android.gms.internal.pal.zzfk
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            int i3 = parcel.readInt();
            zzfl.a(parcel);
            ((zzhb) this).f37785a.c(new zzgy(i3));
            return true;
        }
        Parcelable.Creator creator = Bundle.CREATOR;
        int i4 = zzfl.f37734a;
        Parcelable parcelable = parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel);
        zzfl.a(parcel);
        ((zzhb) this).f37785a.d(((Bundle) parcelable).getString("newToken"));
        return true;
    }
}
