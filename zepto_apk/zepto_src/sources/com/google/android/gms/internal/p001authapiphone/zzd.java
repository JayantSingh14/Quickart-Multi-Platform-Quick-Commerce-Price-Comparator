package com.google.android.gms.internal.p001authapiphone;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;

/* loaded from: classes4.dex */
public abstract class zzd extends zzb implements zze {
    public zzd() {
        super("com.google.android.gms.auth.api.phone.internal.IAutofillPermissionStateCallback");
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zzb
    public final boolean g(int i2, Parcel parcel) {
        if (i2 != 1) {
            return false;
        }
        Status status = (Status) zzc.a(parcel, Status.CREATOR);
        int i3 = parcel.readInt();
        zzc.b(parcel);
        TaskUtil.setResultOrApiException(status, Integer.valueOf(i3), ((zzx) this).f36254a);
        return true;
    }
}
