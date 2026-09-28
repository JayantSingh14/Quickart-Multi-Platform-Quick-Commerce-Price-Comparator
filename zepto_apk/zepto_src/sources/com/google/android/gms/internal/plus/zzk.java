package com.google.android.gms.internal.plus;

import com.google.android.gms.common.api.Api;

/* loaded from: classes4.dex */
final class zzk extends zzp {
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        setCancelToken(((com.google.android.gms.plus.internal.zzh) anyClient).c(this));
    }
}
