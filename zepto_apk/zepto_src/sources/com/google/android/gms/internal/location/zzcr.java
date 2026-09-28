package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.LocationSettingsResult;

/* loaded from: classes4.dex */
final class zzcr extends zzr {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseImplementation.ResultHolder f36652a;

    public zzcr(BaseImplementation.ResultHolder resultHolder) {
        this.f36652a = resultHolder;
    }

    @Override // com.google.android.gms.internal.location.zzs
    public final void E2(LocationSettingsResult locationSettingsResult) {
        this.f36652a.setResult(locationSettingsResult);
    }
}
