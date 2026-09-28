package com.google.firebase.crashlytics.internal.common;

import android.app.Activity;
import android.view.View;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.metadata.EventMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.unistyles.Platform;

/* loaded from: classes4.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43864a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f43865b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f43866c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f43867d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f43868e;

    public /* synthetic */ k(SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsReport.Session.Event event, EventMetadata eventMetadata, boolean z) {
        this.f43866c = sessionReportingCoordinator;
        this.f43867d = event;
        this.f43868e = eventMetadata;
        this.f43865b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f43864a) {
            case 0:
                SessionReportingCoordinator sessionReportingCoordinator = (SessionReportingCoordinator) this.f43866c;
                sessionReportingCoordinator.getClass();
                Logger.f43705a.b("disk worker: log non-fatal event to persistence", null);
                CrashlyticsReportPersistence crashlyticsReportPersistence = sessionReportingCoordinator.f43836b;
                EventMetadata eventMetadata = (EventMetadata) this.f43868e;
                crashlyticsReportPersistence.d((CrashlyticsReport.Session.Event) this.f43867d, eventMetadata.f43894a, this.f43865b);
                break;
            default:
                WindowInsetsControllerCompat windowInsetsControllerCompat = (WindowInsetsControllerCompat) this.f43867d;
                Activity activity = (Activity) this.f43868e;
                Platform.onSetNavigationBarHidden$lambda$7$lambda$6$lambda$5$lambda$4(this.f43865b, (View) this.f43866c, windowInsetsControllerCompat, activity);
                break;
        }
    }

    public /* synthetic */ k(boolean z, View view, WindowInsetsControllerCompat windowInsetsControllerCompat, Activity activity) {
        this.f43865b = z;
        this.f43866c = view;
        this.f43867d = windowInsetsControllerCompat;
        this.f43868e = activity;
    }
}
