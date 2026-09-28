package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import androidx.media3.exoplayer.analytics.l;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.ProcessDetailsProvider;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.metadata.EventMetadata;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.RolloutAssignment;
import com.google.firebase.crashlytics.internal.metadata.RolloutAssignmentList;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes.dex */
public class SessionReportingCoordinator {

    /* renamed from: a, reason: collision with root package name */
    public final CrashlyticsReportDataCapture f43835a;

    /* renamed from: b, reason: collision with root package name */
    public final CrashlyticsReportPersistence f43836b;

    /* renamed from: c, reason: collision with root package name */
    public final DataTransportCrashlyticsReportSender f43837c;

    /* renamed from: d, reason: collision with root package name */
    public final LogFileManager f43838d;

    /* renamed from: e, reason: collision with root package name */
    public final UserMetadata f43839e;

    /* renamed from: f, reason: collision with root package name */
    public final IdManager f43840f;

    /* renamed from: g, reason: collision with root package name */
    public final CrashlyticsWorkers f43841g;

    public SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager, UserMetadata userMetadata, IdManager idManager, CrashlyticsWorkers crashlyticsWorkers) {
        this.f43835a = crashlyticsReportDataCapture;
        this.f43836b = crashlyticsReportPersistence;
        this.f43837c = dataTransportCrashlyticsReportSender;
        this.f43838d = logFileManager;
        this.f43839e = userMetadata;
        this.f43840f = idManager;
        this.f43841g = crashlyticsWorkers;
    }

    public static CrashlyticsReport.Session.Event a(CrashlyticsReport.Session.Event event, LogFileManager logFileManager, UserMetadata userMetadata, Map map) {
        CrashlyticsReport.Session.Event.Builder builderH = event.h();
        String strC = logFileManager.c();
        if (strC != null) {
            CrashlyticsReport.Session.Event.Log.Builder builderA = CrashlyticsReport.Session.Event.Log.a();
            builderA.b(strC);
            builderH.d(builderA.a());
        } else {
            Logger.f43705a.e("No log data to include with this event.");
        }
        List listD = d(userMetadata.a(map));
        List listD2 = d(userMetadata.b());
        if (!listD.isEmpty() || !listD2.isEmpty()) {
            CrashlyticsReport.Session.Event.Application.Builder builderI = event.b().i();
            builderI.e(listD);
            builderI.g(listD2);
            builderH.b(builderI.a());
        }
        return builderH.a();
    }

    public static CrashlyticsReport.Session.Event b(CrashlyticsReport.Session.Event event, UserMetadata userMetadata) {
        List listUnmodifiableList;
        RolloutAssignmentList rolloutAssignmentList = userMetadata.f43935f;
        synchronized (rolloutAssignmentList) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(rolloutAssignmentList.f43928a));
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listUnmodifiableList.size(); i2++) {
            arrayList.add(((RolloutAssignment) listUnmodifiableList.get(i2)).g());
        }
        if (arrayList.isEmpty()) {
            return event;
        }
        CrashlyticsReport.Session.Event.Builder builderH = event.h();
        CrashlyticsReport.Session.Event.RolloutsState.Builder builderA = CrashlyticsReport.Session.Event.RolloutsState.a();
        builderA.b(arrayList);
        builderH.e(builderA.a());
        return builderH.a();
    }

    public static String c(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[KEYRecord.Flags.FLAG2];
                while (true) {
                    int i2 = bufferedInputStream.read(bArr);
                    if (i2 == -1) {
                        String string = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                        byteArrayOutputStream.close();
                        bufferedInputStream.close();
                        return string;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static List d(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            CrashlyticsReport.CustomAttribute.Builder builderA = CrashlyticsReport.CustomAttribute.a();
            builderA.b((String) entry.getKey());
            builderA.c((String) entry.getValue());
            arrayList.add(builderA.a());
        }
        Collections.sort(arrayList, new androidx.media3.datasource.cache.a(1));
        return Collections.unmodifiableList(arrayList);
    }

    public final void e(Throwable th, Thread thread, String str, EventMetadata eventMetadata, boolean z) {
        boolean zEquals = str.equals("crash");
        long jC = eventMetadata.c();
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = this.f43835a;
        Context context = crashlyticsReportDataCapture.f43794a;
        int i2 = context.getResources().getConfiguration().orientation;
        MiddleOutFallbackStrategy middleOutFallbackStrategy = crashlyticsReportDataCapture.f43797d;
        TrimmedThrowableData trimmedThrowableDataA = TrimmedThrowableData.a(th, middleOutFallbackStrategy);
        CrashlyticsReport.Session.Event.Builder builderA = CrashlyticsReport.Session.Event.a();
        builderA.g(str);
        builderA.f(jC);
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetailsC = ProcessDetailsProvider.f43706a.c(context);
        Boolean boolValueOf = processDetailsC.b() > 0 ? Boolean.valueOf(processDetailsC.b() != 100) : null;
        CrashlyticsReport.Session.Event.Application.Builder builderA2 = CrashlyticsReport.Session.Event.Application.a();
        builderA2.c(boolValueOf);
        builderA2.d(processDetailsC);
        builderA2.b(ProcessDetailsProvider.b(context));
        builderA2.h(i2);
        CrashlyticsReport.Session.Event.Application.Execution.Builder builderA3 = CrashlyticsReport.Session.Event.Application.Execution.a();
        ArrayList arrayList = new ArrayList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableDataA.f44462c;
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder builderA4 = CrashlyticsReport.Session.Event.Application.Execution.Thread.a();
        builderA4.d(thread.getName());
        builderA4.c(4);
        builderA4.b(CrashlyticsReportDataCapture.d(stackTraceElementArr, 4));
        arrayList.add(builderA4.a());
        if (z) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    StackTraceElement[] stackTraceElementArrA = middleOutFallbackStrategy.a(entry.getValue());
                    CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder builderA5 = CrashlyticsReport.Session.Event.Application.Execution.Thread.a();
                    builderA5.d(key.getName());
                    builderA5.c(0);
                    builderA5.b(CrashlyticsReportDataCapture.d(stackTraceElementArrA, 0));
                    arrayList.add(builderA5.a());
                }
            }
        }
        builderA3.f(Collections.unmodifiableList(arrayList));
        builderA3.d(CrashlyticsReportDataCapture.c(trimmedThrowableDataA, 0));
        CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder builderA6 = CrashlyticsReport.Session.Event.Application.Execution.Signal.a();
        builderA6.d("0");
        builderA6.c("0");
        builderA6.b(0L);
        builderA3.e(builderA6.a());
        builderA3.c(crashlyticsReportDataCapture.a());
        builderA2.f(builderA3.a());
        builderA.b(builderA2.a());
        builderA.c(crashlyticsReportDataCapture.b(i2));
        CrashlyticsReport.Session.Event eventA = builderA.a();
        Map mapA = eventMetadata.a();
        LogFileManager logFileManager = this.f43838d;
        UserMetadata userMetadata = this.f43839e;
        CrashlyticsReport.Session.Event eventB = b(a(eventA, logFileManager, userMetadata, mapA), userMetadata);
        if (z) {
            this.f43836b.d(eventB, eventMetadata.b(), zEquals);
        } else {
            this.f43841g.f43875b.a(new k(this, eventB, eventMetadata, zEquals));
        }
    }

    public final Task f(String str, Executor executor) {
        ArrayList arrayListB = this.f43836b.b();
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListB.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            try {
                CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = CrashlyticsReportPersistence.f44377g;
                String strE = CrashlyticsReportPersistence.e(file);
                crashlyticsReportJsonTransform.getClass();
                arrayList.add(CrashlyticsReportWithSessionId.a(CrashlyticsReportJsonTransform.i(strE), file.getName(), file));
            } catch (IOException e2) {
                Logger.f43705a.f("Could not load report file " + file + "; deleting", e2);
                file.delete();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CrashlyticsReportWithSessionId crashlyticsReportWithSessionIdA = (CrashlyticsReportWithSessionId) it2.next();
            if (str == null || str.equals(crashlyticsReportWithSessionIdA.d())) {
                if (crashlyticsReportWithSessionIdA.b().g() == null || crashlyticsReportWithSessionIdA.b().f() == null) {
                    FirebaseInstallationId firebaseInstallationIdB = this.f43840f.b(true);
                    CrashlyticsReport.Builder builderN = crashlyticsReportWithSessionIdA.b().n();
                    builderN.g(firebaseInstallationIdB.f43822a);
                    CrashlyticsReport.Builder builderN2 = builderN.a().n();
                    builderN2.f(firebaseInstallationIdB.f43823b);
                    crashlyticsReportWithSessionIdA = CrashlyticsReportWithSessionId.a(builderN2.a(), crashlyticsReportWithSessionIdA.d(), crashlyticsReportWithSessionIdA.c());
                }
                arrayList2.add(this.f43837c.b(crashlyticsReportWithSessionIdA, str != null).h(executor, new l(this, 14)));
            }
        }
        return Tasks.f(arrayList2);
    }
}
