package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzbl implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzbm zzbmVar = new zzbm((TaskCompletionSource) obj2);
        zzbh zzbhVar = (zzbh) ((zzbe) obj).getService();
        Parcel parcelG = zzbhVar.g();
        zzc.d(parcelG, zzbmVar);
        parcelG.writeInt(0);
        zzbhVar.z0(1, parcelG);
    }
}
