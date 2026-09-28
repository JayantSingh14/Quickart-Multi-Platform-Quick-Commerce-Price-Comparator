package com.google.android.gms.internal.location;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;

/* loaded from: classes4.dex */
public abstract class zzl extends zzb implements zzm {
    public zzl() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean g(int i2, Parcel parcel) {
        int i3 = 13;
        if (i2 == 1) {
            int i4 = parcel.readInt();
            parcel.createStringArray();
            zzc.b(parcel);
            zzci zzciVar = (zzci) this;
            if (i4 == 0 || (i4 >= 1000 && i4 < 1006)) {
                i3 = i4;
            }
            TaskUtil.setResultOrApiException(new Status(i3), zzciVar.f36641a);
            return true;
        }
        if (i2 == 2) {
            int i5 = parcel.readInt();
            parcel.createStringArray();
            zzc.b(parcel);
            zzci zzciVar2 = (zzci) this;
            if (i5 == 0 || (i5 >= 1000 && i5 < 1006)) {
                i3 = i5;
            }
            TaskUtil.setResultOrApiException(new Status(i3), zzciVar2.f36641a);
            return true;
        }
        if (i2 != 3) {
            return false;
        }
        int i6 = parcel.readInt();
        zzc.b(parcel);
        zzci zzciVar3 = (zzci) this;
        if (i6 == 0 || (i6 >= 1000 && i6 < 1006)) {
            i3 = i6;
        }
        TaskUtil.setResultOrApiException(new Status(i3), zzciVar3.f36641a);
        return true;
    }
}
