package com.google.android.gms.internal.p001authapiphone;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzaa implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzac zzacVar = new zzac((TaskCompletionSource) obj2);
        zzk zzkVar = (zzk) ((zzaf) obj).getService();
        Parcel parcelG = zzkVar.g();
        int i2 = zzc.f36250a;
        parcelG.writeStrongBinder(zzacVar.asBinder());
        zzkVar.z0(6, parcelG);
    }
}
