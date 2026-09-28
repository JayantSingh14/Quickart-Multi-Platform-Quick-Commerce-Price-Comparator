package com.google.android.gms.internal.p001authapiphone;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzn implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzae clientImpl = (zzae) obj;
        TaskCompletionSource completionSource = (TaskCompletionSource) obj2;
        Logger logger = zzp.f36252a;
        Intrinsics.checkNotNullParameter(clientImpl, "clientImpl");
        Intrinsics.checkNotNullParameter(completionSource, "completionSource");
        zzo zzoVar = new zzo(completionSource);
        zzh zzhVar = (zzh) clientImpl.getService();
        Parcel parcelG = zzhVar.g();
        int i2 = zzc.f36250a;
        parcelG.writeStrongBinder(zzoVar);
        parcelG.writeInt(0);
        zzhVar.z0(1, parcelG);
    }
}
