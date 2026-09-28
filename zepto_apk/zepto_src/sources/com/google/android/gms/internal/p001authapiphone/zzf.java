package com.google.android.gms.internal.p001authapiphone;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;

/* loaded from: classes4.dex */
public abstract class zzf extends zzb implements zzg {
    public zzf() {
        super("com.google.android.gms.auth.api.phone.internal.IMissedCallRetrieverCallbacks");
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zzb
    public final boolean g(int i2, Parcel parcel) {
        if (i2 != 1) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) zzc.a(parcel, PendingIntent.CREATOR);
        Status status = (Status) zzc.a(parcel, Status.CREATOR);
        zzc.b(parcel);
        zzo zzoVar = (zzo) this;
        zzp.f36252a.i("InternalMissedCallRetrieverClient#onMissedCallRetrieverResult invoked with status: %s", status != null ? Integer.valueOf(status.getStatusCode()) : null);
        TaskUtil.setResultOrApiException(status, pendingIntent, zzoVar.f36251a);
        return true;
    }
}
