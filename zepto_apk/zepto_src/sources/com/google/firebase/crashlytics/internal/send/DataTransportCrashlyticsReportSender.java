package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.send.ReportQueue.ReportRunnable;
import com.google.firebase.crashlytics.internal.settings.SettingsController;

/* loaded from: classes.dex */
public class DataTransportCrashlyticsReportSender {

    /* renamed from: b, reason: collision with root package name */
    public static final CrashlyticsReportJsonTransform f44394b = new CrashlyticsReportJsonTransform();

    /* renamed from: c, reason: collision with root package name */
    public static final String f44395c = c("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: d, reason: collision with root package name */
    public static final String f44396d = c("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.work.impl.model.a f44397e = new androidx.work.impl.model.a(11);

    /* renamed from: a, reason: collision with root package name */
    public final ReportQueue f44398a;

    public DataTransportCrashlyticsReportSender(ReportQueue reportQueue, androidx.work.impl.model.a aVar) {
        this.f44398a = reportQueue;
    }

    public static DataTransportCrashlyticsReportSender a(Context context, SettingsController settingsController, OnDemandCounter onDemandCounter) {
        TransportRuntime.b(context);
        TransportFactory transportFactoryC = TransportRuntime.a().c(new CCTDestination(f44395c, f44396d));
        Encoding encoding = new Encoding("json");
        androidx.work.impl.model.a aVar = f44397e;
        return new DataTransportCrashlyticsReportSender(new ReportQueue(transportFactoryC.a("FIREBASE_CRASHLYTICS_REPORT", encoding, aVar), settingsController.d(), onDemandCounter), aVar);
    }

    public static String c(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.charAt(i2));
            if (str2.length() > i2) {
                sb.append(str2.charAt(i2));
            }
        }
        return sb.toString();
    }

    public final Task b(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z) {
        TaskCompletionSource taskCompletionSource;
        ReportQueue reportQueue = this.f44398a;
        synchronized (reportQueue.f44404f) {
            try {
                taskCompletionSource = new TaskCompletionSource();
                if (z) {
                    reportQueue.f44407i.f43833a.getAndIncrement();
                    if (reportQueue.f44404f.size() < reportQueue.f44403e) {
                        Logger logger = Logger.f43705a;
                        logger.b("Enqueueing report: " + crashlyticsReportWithSessionId.d(), null);
                        logger.b("Queue size: " + reportQueue.f44404f.size(), null);
                        reportQueue.f44405g.execute(reportQueue.new ReportRunnable(crashlyticsReportWithSessionId, taskCompletionSource));
                        logger.b("Closing task for report: " + crashlyticsReportWithSessionId.d(), null);
                        taskCompletionSource.d(crashlyticsReportWithSessionId);
                    } else {
                        reportQueue.a();
                        Logger.f43705a.b("Dropping report due to queue being full: " + crashlyticsReportWithSessionId.d(), null);
                        reportQueue.f44407i.f43834b.getAndIncrement();
                        taskCompletionSource.d(crashlyticsReportWithSessionId);
                    }
                } else {
                    reportQueue.b(crashlyticsReportWithSessionId, taskCompletionSource);
                }
            } finally {
            }
        }
        return taskCompletionSource.f39750a;
    }
}
