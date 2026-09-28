package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzbr extends zzbu {
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        zzda zzdaVar = (zzda) anyClient;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.f39750a.addOnCompleteListener(new zzbq(this));
        zzdaVar.getClass();
        Preconditions.checkNotNull(null, "geofencingRequest can't be null.");
        Preconditions.checkNotNull(null, "PendingIntent must be specified.");
        ((zzo) zzdaVar.getService()).x6(new zzci(taskCompletionSource));
    }
}
