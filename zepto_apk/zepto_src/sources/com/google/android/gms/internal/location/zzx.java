package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzx implements RemoteCall {
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        int i2 = zzag.f36626a;
        zzaf zzafVar = new zzaf((TaskCompletionSource) obj2);
        Preconditions.checkNotNull(zzafVar, "ResultHolder not provided.");
        ((zzo) ((zzf) obj).getService()).I8(new StatusCallback(zzafVar));
    }
}
