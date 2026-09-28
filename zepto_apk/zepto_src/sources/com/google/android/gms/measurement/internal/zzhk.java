package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurementReceiver;

/* loaded from: classes4.dex */
public final class zzhk {

    /* renamed from: a, reason: collision with root package name */
    public final AppMeasurementReceiver f39038a;

    public interface zza {
    }

    public zzhk(AppMeasurementReceiver appMeasurementReceiver) {
        Preconditions.checkNotNull(appMeasurementReceiver);
        this.f39038a = appMeasurementReceiver;
    }
}
