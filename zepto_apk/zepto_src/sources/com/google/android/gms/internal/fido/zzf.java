package com.google.android.gms.internal.fido;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class zzf extends zzb implements zzg {
    public zzf() {
        super("com.google.android.gms.fido.fido2.api.ICredentialListCallback");
    }

    @Override // com.google.android.gms.internal.fido.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            ArrayList arrayList = parcel.readArrayList(zzc.f36612a);
            zzc.b(parcel);
            y2(arrayList);
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
