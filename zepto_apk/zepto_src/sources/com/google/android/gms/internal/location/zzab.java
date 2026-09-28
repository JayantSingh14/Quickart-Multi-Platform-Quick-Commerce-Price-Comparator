package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzab implements RemoteCall {
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        int i2 = zzag.f36626a;
        zzaf zzafVar = new zzaf((TaskCompletionSource) obj2);
        Preconditions.checkNotNull(null, "PendingIntent must be specified.");
        Preconditions.checkNotNull(zzafVar, "ResultHolder not provided.");
        ((zzo) ((zzf) obj).getService()).Ma(new StatusCallback(zzafVar));
    }
}
