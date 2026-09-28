package com.google.android.gms.internal.fido;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
public abstract class zzd extends zzb implements zze {
    public zzd() {
        super("com.google.android.gms.fido.fido2.api.IBooleanCallback");
    }

    @Override // com.google.android.gms.internal.fido.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            ClassLoader classLoader = zzc.f36612a;
            int i3 = parcel.readInt();
            zzc.b(parcel);
            h3(i3 != 0);
        } else {
            if (i2 != 2) {
                return false;
            }
            Status status = (Status) zzc.a(parcel, Status.CREATOR);
            zzc.b(parcel);
            M0(status);
        }
        parcel2.writeNoException();
        return true;
    }
}
