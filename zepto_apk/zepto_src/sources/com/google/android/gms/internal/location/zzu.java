package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
final class zzu extends zzv {
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        zzf zzfVar = (zzf) anyClient;
        zzfVar.getClass();
        Preconditions.checkNotNull(null);
        ((zzo) zzfVar.getService()).zzm();
        setResult((zzu) Status.RESULT_SUCCESS);
    }
}
