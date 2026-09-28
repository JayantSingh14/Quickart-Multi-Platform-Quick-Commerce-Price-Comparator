package com.google.android.gms.internal.fido;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
public abstract class zzu extends zzb implements zzv {
    public zzu() {
        super("com.google.android.gms.fido.u2f.internal.regular.IU2fAppCallbacks");
    }

    @Override // com.google.android.gms.internal.fido.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        Status status = (Status) zzc.a(parcel, Status.CREATOR);
        PendingIntent pendingIntent = (PendingIntent) zzc.a(parcel, PendingIntent.CREATOR);
        zzc.b(parcel);
        R(status, pendingIntent);
        return true;
    }
}
