package com.google.android.gms.internal.auth;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
public abstract class zzj extends zzb implements zzk {
    public zzj() {
        super("com.google.android.gms.auth.account.data.IBundleCallback");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 2) {
            return false;
        }
        Status status = (Status) zzc.a(parcel, Status.CREATOR);
        Bundle bundle = (Bundle) zzc.a(parcel, Bundle.CREATOR);
        zzc.b(parcel);
        W5(status, bundle);
        return true;
    }
}
