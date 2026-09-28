package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* loaded from: classes.dex */
public final class zzg implements zza {

    /* renamed from: a, reason: collision with root package name */
    public final AnalyticsConnector.AnalyticsConnectorListener f43549a;

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f43549a = analyticsConnectorListener;
        appMeasurementSdk.f38652a.o(new zzf(this));
    }
}
