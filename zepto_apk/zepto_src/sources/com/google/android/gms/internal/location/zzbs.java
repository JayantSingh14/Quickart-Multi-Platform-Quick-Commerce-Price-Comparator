package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzbs extends zzbu {
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        zzda zzdaVar = (zzda) anyClient;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.f39750a.addOnCompleteListener(new zzbq(this));
        zzdaVar.getClass();
        Preconditions.checkNotNull(null, "PendingIntent must be specified.");
        ((zzo) zzdaVar.getService()).P5(new zzci(taskCompletionSource), zzdaVar.getContext().getPackageName());
    }
}
