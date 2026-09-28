package com.google.firebase.analytics.connector;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: classes.dex */
public interface AnalyticsConnector {

    @KeepForSdk
    public interface AnalyticsConnectorHandle {
    }

    @KeepForSdk
    public interface AnalyticsConnectorListener {
        void a(int i2, Bundle bundle);
    }

    @KeepForSdk
    /* loaded from: classes4.dex */
    public static class ConditionalUserProperty {
    }

    void a(String str, String str2, Bundle bundle);

    void b(String str);

    AnalyticsConnectorHandle c(String str, AnalyticsConnectorListener analyticsConnectorListener);
}
