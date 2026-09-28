package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzs implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzp zzpVar = (zzp) ((zzi) obj).getService();
        zzw zzwVar = new zzw((TaskCompletionSource) obj2);
        Parcel parcelG = zzpVar.g();
        zzc.d(parcelG, zzwVar);
        parcelG.writeInt(0);
        parcelG.writeString(null);
        parcelG.writeInt(0);
        zzpVar.z0(1, parcelG);
    }
}
