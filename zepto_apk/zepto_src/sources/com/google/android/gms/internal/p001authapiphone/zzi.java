package com.google.android.gms.internal.p001authapiphone;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;

/* loaded from: classes4.dex */
public abstract class zzi extends zzb implements zzj {
    public zzi() {
        super("com.google.android.gms.auth.api.phone.internal.IOngoingSmsRequestCallback");
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zzb
    public final boolean g(int i2, Parcel parcel) {
        if (i2 != 1) {
            return false;
        }
        Status status = (Status) zzc.a(parcel, Status.CREATOR);
        boolean z = parcel.readInt() != 0;
        zzc.b(parcel);
        TaskUtil.setResultOrApiException(status, Boolean.valueOf(z), ((zzy) this).f36255a);
        return true;
    }
}
