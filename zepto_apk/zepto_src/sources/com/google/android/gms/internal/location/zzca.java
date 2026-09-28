package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
final class zzca extends zzcb {
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        Preconditions.checkArgument(false, "locationSettingsRequest can't be null");
        ((zzo) ((zzda) anyClient).getService()).a6(null, new zzcr(this));
    }
}
