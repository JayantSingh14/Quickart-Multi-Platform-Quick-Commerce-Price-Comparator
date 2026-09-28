package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zze implements zza {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f43546a;

    /* renamed from: b, reason: collision with root package name */
    public final AnalyticsConnector.AnalyticsConnectorListener f43547b;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f43547b = analyticsConnectorListener;
        appMeasurementSdk.f38652a.o(new zzd(this));
        this.f43546a = new HashSet();
    }
}
