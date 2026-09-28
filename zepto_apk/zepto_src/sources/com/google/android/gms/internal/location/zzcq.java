package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzcq extends zzr {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36651a;

    public zzcq(TaskCompletionSource taskCompletionSource) {
        this.f36651a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzs
    public final void E2(LocationSettingsResult locationSettingsResult) {
        TaskUtil.setResultOrApiException(locationSettingsResult.f38344a, new LocationSettingsResponse(locationSettingsResult), this.f36651a);
    }
}
