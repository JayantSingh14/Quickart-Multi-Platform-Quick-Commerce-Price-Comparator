package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
final class zzt extends zzv {
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        Preconditions.checkNotNull(null);
        Preconditions.checkArgument(true, "detectionIntervalMillis must be >= 0");
        ((zzo) ((zzf) anyClient).getService()).zzr();
        setResult((zzt) Status.RESULT_SUCCESS);
    }
}
