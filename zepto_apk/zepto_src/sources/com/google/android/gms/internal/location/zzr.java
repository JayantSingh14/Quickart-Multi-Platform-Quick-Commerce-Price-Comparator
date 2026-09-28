package com.google.android.gms.internal.location;

import android.os.Parcel;
import com.google.android.gms.location.LocationSettingsResult;

/* loaded from: classes4.dex */
public abstract class zzr extends zzb implements zzs {
    public zzr() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean g(int i2, Parcel parcel) {
        if (i2 != 1) {
            return false;
        }
        LocationSettingsResult locationSettingsResult = (LocationSettingsResult) zzc.a(parcel, LocationSettingsResult.CREATOR);
        zzc.b(parcel);
        E2(locationSettingsResult);
        return true;
    }
}
