package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzcd implements RemoteCall {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationSettingsRequest f36640a;

    public /* synthetic */ zzcd(LocationSettingsRequest locationSettingsRequest) {
        this.f36640a = locationSettingsRequest;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        LocationSettingsRequest locationSettingsRequest = this.f36640a;
        Preconditions.checkArgument(true, "locationSettingsRequest can't be null");
        ((zzo) ((zzda) obj).getService()).a6(locationSettingsRequest, new zzcq((TaskCompletionSource) obj2));
    }
}
