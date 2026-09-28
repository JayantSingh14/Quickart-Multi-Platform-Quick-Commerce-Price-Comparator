package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzu implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzz zzzVar = new zzz((TaskCompletionSource) obj2);
        zzp zzpVar = (zzp) ((zzi) obj).getService();
        Parcel parcelG = zzpVar.g();
        zzc.d(parcelG, zzzVar);
        parcelG.writeInt(0);
        zzpVar.z0(4, parcelG);
    }
}
