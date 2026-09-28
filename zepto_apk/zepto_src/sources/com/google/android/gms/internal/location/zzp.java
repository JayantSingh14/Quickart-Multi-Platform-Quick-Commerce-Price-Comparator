package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;

/* loaded from: classes4.dex */
public abstract class zzp extends zzb implements zzq {
    public zzp() {
        super("com.google.android.gms.location.internal.ILocationStatusCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean g(int i2, Parcel parcel) {
        if (i2 != 1) {
            return false;
        }
        Status status = (Status) zzc.a(parcel, Status.CREATOR);
        Location location = (Location) zzc.a(parcel, Location.CREATOR);
        zzc.b(parcel);
        TaskUtil.setResultOrApiException(status, location, ((zzcm) this).f36646a);
        return true;
    }
}
