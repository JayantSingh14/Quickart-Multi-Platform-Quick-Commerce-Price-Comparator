package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzq implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzp zzpVar = (zzp) ((zzi) obj).getService();
        zzy zzyVar = new zzy((TaskCompletionSource) obj2);
        Parcel parcelG = zzpVar.g();
        zzc.d(parcelG, zzyVar);
        parcelG.writeString(null);
        zzpVar.z0(3, parcelG);
    }
}
