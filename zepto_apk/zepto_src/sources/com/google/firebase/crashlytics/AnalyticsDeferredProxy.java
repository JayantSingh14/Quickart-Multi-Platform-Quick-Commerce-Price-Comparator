package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.inject.Deferred;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AnalyticsDeferredProxy {

    /* renamed from: a, reason: collision with root package name */
    public final Deferred f43686a;

    /* renamed from: b, reason: collision with root package name */
    public volatile AnalyticsEventLogger f43687b;

    /* renamed from: c, reason: collision with root package name */
    public volatile BreadcrumbSource f43688c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f43689d;

    public AnalyticsDeferredProxy(Deferred deferred) {
        DisabledBreadcrumbSource disabledBreadcrumbSource = new DisabledBreadcrumbSource();
        UnavailableAnalyticsEventLogger unavailableAnalyticsEventLogger = new UnavailableAnalyticsEventLogger();
        this.f43686a = deferred;
        this.f43688c = disabledBreadcrumbSource;
        this.f43689d = new ArrayList();
        this.f43687b = unavailableAnalyticsEventLogger;
        deferred.a(new a(this));
    }
}
