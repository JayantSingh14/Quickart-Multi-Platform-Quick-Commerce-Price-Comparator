package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* loaded from: classes.dex */
final class zzes extends zzcz {

    /* renamed from: a, reason: collision with root package name */
    public final AppMeasurementSdk.OnEventListener f36921a;

    public zzes(AppMeasurementSdk.OnEventListener onEventListener) {
        this.f36921a = onEventListener;
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final void L7(long j2, Bundle bundle, String str, String str2) {
        this.f36921a.a(j2, bundle, str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        return System.identityHashCode(this.f36921a);
    }
}
