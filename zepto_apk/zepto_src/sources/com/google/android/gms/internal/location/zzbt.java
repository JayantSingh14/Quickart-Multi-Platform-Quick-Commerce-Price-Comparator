package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzbt extends zzbu {
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.f39750a.addOnCompleteListener(new zzbq(this));
        ((zzda) anyClient).k(taskCompletionSource);
        throw null;
    }
}
