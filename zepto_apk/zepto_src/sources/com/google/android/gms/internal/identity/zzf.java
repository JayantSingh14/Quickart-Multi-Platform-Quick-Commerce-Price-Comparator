package com.google.android.gms.internal.identity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public abstract class zzf extends zzb implements zzg {
    public zzf() {
        attachInterface(this, "com.google.android.gms.identity.intents.internal.IAddressCallbacks");
    }

    @Override // com.google.android.gms.internal.identity.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 2) {
            return false;
        }
        int i3 = parcel.readInt();
        Parcelable.Creator creator = Bundle.CREATOR;
        int i4 = zzc.f36617a;
        ((zzd) this).z0(i3, (Bundle) (parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel)));
        parcel2.writeNoException();
        return true;
    }
}
