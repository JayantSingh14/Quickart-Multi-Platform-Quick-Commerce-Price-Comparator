package com.google.android.gms.internal.appset;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;

/* loaded from: classes4.dex */
public abstract class zze extends zzb implements zzf {
    public zze() {
        attachInterface(this, "com.google.android.gms.appset.internal.IAppSetIdCallback");
    }

    @Override // com.google.android.gms.internal.appset.zzb
    public final boolean g(int i2, Parcel parcel) {
        if (i2 != 1) {
            return false;
        }
        Parcelable.Creator<Status> creator = Status.CREATOR;
        int i3 = zzc.f36009a;
        Status statusCreateFromParcel = parcel.readInt() == 0 ? null : creator.createFromParcel(parcel);
        com.google.android.gms.appset.zzc zzcVarCreateFromParcel = parcel.readInt() == 0 ? null : com.google.android.gms.appset.zzc.CREATOR.createFromParcel(parcel);
        TaskUtil.setResultOrApiException(statusCreateFromParcel, zzcVarCreateFromParcel != null ? new AppSetIdInfo(zzcVarCreateFromParcel.f21998a, zzcVarCreateFromParcel.f21999b) : null, ((zzo) this).f36017a);
        return true;
    }
}
