package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import java.util.Locale;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
class CrashlyticsAnalyticsListener implements AnalyticsConnector.AnalyticsConnectorListener {

    /* renamed from: a, reason: collision with root package name */
    public BlockingAnalyticsEventLogger f43690a;

    /* renamed from: b, reason: collision with root package name */
    public BreadcrumbAnalyticsEventReceiver f43691b;

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public final void a(int i2, Bundle bundle) {
        Logger logger = Logger.f43705a;
        Locale locale = Locale.US;
        logger.e("Analytics listener received message. ID: " + i2 + ", Extras: " + bundle);
        String string = bundle.getString(CLConstants.FIELD_PAY_INFO_NAME);
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            AnalyticsEventReceiver analyticsEventReceiver = "clx".equals(bundle2.getString("_o")) ? this.f43690a : this.f43691b;
            if (analyticsEventReceiver == null) {
                return;
            }
            analyticsEventReceiver.b(bundle2, string);
        }
    }
}
