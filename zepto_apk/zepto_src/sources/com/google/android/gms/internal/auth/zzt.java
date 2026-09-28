package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzt implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzp zzpVar = (zzp) ((zzi) obj).getService();
        zzx zzxVar = new zzx((TaskCompletionSource) obj2);
        Parcel parcelG = zzpVar.g();
        zzc.d(parcelG, zzxVar);
        parcelG.writeInt(0);
        zzpVar.z0(2, parcelG);
    }
}
