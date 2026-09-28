package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzk extends zza {

    /* renamed from: a, reason: collision with root package name */
    public final BaseImplementation.ResultHolder f39699a;

    public zzk(BaseImplementation.ResultHolder resultHolder) {
        this.f39699a = resultHolder;
    }

    @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
    public final void X8(int i2, Bundle bundle) {
        this.f39699a.setResult(new Status(i2, (String) null, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
    }
}
