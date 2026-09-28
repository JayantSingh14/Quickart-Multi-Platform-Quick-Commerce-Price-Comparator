package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import androidx.media3.exoplayer.analytics.l;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsTasks;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.metadata.EventMetadata;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.Settings;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
class CrashlyticsController {
    public static final b s = new b(0);
    public static final Charset t = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final Context f43752a;

    /* renamed from: b, reason: collision with root package name */
    public final DataCollectionArbiter f43753b;

    /* renamed from: c, reason: collision with root package name */
    public final CrashlyticsFileMarker f43754c;

    /* renamed from: d, reason: collision with root package name */
    public final UserMetadata f43755d;

    /* renamed from: e, reason: collision with root package name */
    public final CrashlyticsWorkers f43756e;

    /* renamed from: f, reason: collision with root package name */
    public final IdManager f43757f;

    /* renamed from: g, reason: collision with root package name */
    public final FileStore f43758g;

    /* renamed from: h, reason: collision with root package name */
    public final AppData f43759h;

    /* renamed from: i, reason: collision with root package name */
    public final LogFileManager f43760i;

    /* renamed from: j, reason: collision with root package name */
    public final CrashlyticsNativeComponentDeferredProxy f43761j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.firebase.crashlytics.a f43762k;

    /* renamed from: l, reason: collision with root package name */
    public final CrashlyticsAppQualitySessionsSubscriber f43763l;

    /* renamed from: m, reason: collision with root package name */
    public final SessionReportingCoordinator f43764m;
    public CrashlyticsUncaughtExceptionHandler n;
    public final TaskCompletionSource o = new TaskCompletionSource();
    public final TaskCompletionSource p = new TaskCompletionSource();
    public final TaskCompletionSource q = new TaskCompletionSource();
    public final AtomicBoolean r = new AtomicBoolean(false);

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$1, reason: invalid class name */
    class AnonymousClass1 implements CrashlyticsUncaughtExceptionHandler.CrashListener {
        public AnonymousClass1() {
        }

        public final void a(final SettingsController settingsController, final Thread thread, final Throwable th) {
            Task taskJ;
            final CrashlyticsController crashlyticsController = CrashlyticsController.this;
            synchronized (crashlyticsController) {
                Logger.f43705a.b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName(), null);
                final long jCurrentTimeMillis = System.currentTimeMillis();
                CrashlyticsWorker crashlyticsWorker = crashlyticsController.f43756e.f43874a;
                Callable<Task<Void>> callable = new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2
                    @Override // java.util.concurrent.Callable
                    public final Task<Void> call() throws Throwable {
                        b bVar = CrashlyticsController.s;
                        long j2 = jCurrentTimeMillis;
                        long j3 = j2 / 1000;
                        CrashlyticsController crashlyticsController2 = CrashlyticsController.this;
                        String sessionId = crashlyticsController2.f();
                        Logger logger = Logger.f43705a;
                        if (sessionId == null) {
                            logger.c("Tried to write a fatal exception while no session was open.", null);
                            return Tasks.e(null);
                        }
                        crashlyticsController2.f43754c.a();
                        SessionReportingCoordinator sessionReportingCoordinator = crashlyticsController2.f43764m;
                        sessionReportingCoordinator.getClass();
                        logger.e("Persisting fatal event for session ".concat(sessionId));
                        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                        sessionReportingCoordinator.e(th, thread, "crash", new EventMetadata(sessionId, j3, MapsKt.c()), true);
                        crashlyticsController2.d(j2);
                        SettingsController settingsController2 = settingsController;
                        crashlyticsController2.b(false, settingsController2, false);
                        crashlyticsController2.c(new CLSUUID().f43740a, Boolean.FALSE);
                        return !crashlyticsController2.f43753b.b() ? Tasks.e(null) : settingsController2.c().r(crashlyticsController2.f43756e.f43874a, new SuccessContinuation<Settings, Void>(sessionId) { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2.1
                            @Override // com.google.android.gms.tasks.SuccessContinuation
                            public final Task then(Object obj) {
                                if (((Settings) obj) == null) {
                                    Logger.f43705a.f("Received null app settings, cannot send reports at crash time.", null);
                                    return Tasks.e(null);
                                }
                                CrashlyticsController crashlyticsController3 = CrashlyticsController.this;
                                return Tasks.f(Arrays.asList(CrashlyticsController.a(crashlyticsController3), crashlyticsController3.f43764m.f(null, crashlyticsController3.f43756e.f43874a)));
                            }
                        });
                    }
                };
                synchronized (crashlyticsWorker.f43871b) {
                    taskJ = crashlyticsWorker.f43872c.j(crashlyticsWorker.f43870a, new l(callable, 16));
                    crashlyticsWorker.f43872c = taskJ;
                }
                try {
                    Utils.a(taskJ);
                } catch (TimeoutException unused) {
                    Logger.f43705a.c("Cannot send reports. Timed out while fetching settings.", null);
                } catch (Exception e2) {
                    Logger.f43705a.c("Error handling uncaught exception", e2);
                }
            }
        }
    }

    public CrashlyticsController(Context context, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData, UserMetadata userMetadata, LogFileManager logFileManager, SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy, com.google.firebase.crashlytics.a aVar, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber, CrashlyticsWorkers crashlyticsWorkers) {
        this.f43752a = context;
        this.f43757f = idManager;
        this.f43753b = dataCollectionArbiter;
        this.f43758g = fileStore;
        this.f43754c = crashlyticsFileMarker;
        this.f43759h = appData;
        this.f43755d = userMetadata;
        this.f43760i = logFileManager;
        this.f43761j = crashlyticsNativeComponentDeferredProxy;
        this.f43762k = aVar;
        this.f43763l = crashlyticsAppQualitySessionsSubscriber;
        this.f43764m = sessionReportingCoordinator;
        this.f43756e = crashlyticsWorkers;
    }

    public static Task a(CrashlyticsController crashlyticsController) throws NumberFormatException, ClassNotFoundException {
        Task taskC;
        crashlyticsController.getClass();
        Logger logger = Logger.f43705a;
        ArrayList arrayList = new ArrayList();
        for (File file : FileStore.f(crashlyticsController.f43758g.f44386c.listFiles(s))) {
            try {
                final long j2 = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    logger.f("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists", null);
                    taskC = Tasks.e(null);
                } catch (ClassNotFoundException unused) {
                    logger.b("Logging app exception event to Firebase Analytics", null);
                    taskC = Tasks.c(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.5
                        @Override // java.util.concurrent.Callable
                        public final Void call() {
                            Bundle bundle = new Bundle();
                            bundle.putInt("fatal", 1);
                            bundle.putLong("timestamp", j2);
                            CrashlyticsController.this.f43762k.d(bundle);
                            return null;
                        }
                    }, new ScheduledThreadPoolExecutor(1));
                }
                arrayList.add(taskC);
            } catch (NumberFormatException unused2) {
                logger.f("Could not parse app exception timestamp from file " + file.getName(), null);
            }
            file.delete();
        }
        return Tasks.f(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0180  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.google.firebase.crashlytics.internal.model.CrashlyticsReport] */
    /* JADX WARN: Type inference failed for: r15v28, types: [com.google.firebase.crashlytics.internal.common.FileBackedNativeSessionFile] */
    /* JADX WARN: Type inference failed for: r22v0, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(boolean r22, com.google.firebase.crashlytics.internal.settings.SettingsController r23, boolean r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1795
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CrashlyticsController.b(boolean, com.google.firebase.crashlytics.internal.settings.SettingsController, boolean):void");
    }

    public final void c(String str, Boolean bool) {
        Integer num;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Logger logger = Logger.f43705a;
        logger.b("Opening a new session with ID " + str, null);
        Locale locale = Locale.US;
        IdManager idManager = this.f43757f;
        String str2 = idManager.f43828c;
        AppData appData = this.f43759h;
        StaticSessionData.AppData appDataB = StaticSessionData.AppData.b(str2, appData.f43721f, appData.f43722g, ((AutoValue_InstallIdProvider_InstallIds) idManager.c()).f43727a, (appData.f43719d != null ? DeliveryMechanism.APP_STORE : DeliveryMechanism.DEVELOPER).f43815a, appData.f43723h);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.VERSION.CODENAME;
        StaticSessionData.OsData osDataA = StaticSessionData.OsData.a(CommonUtils.h());
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        CommonUtils.Architecture architecture = CommonUtils.Architecture.f43742a;
        String str5 = Build.CPU_ABI;
        boolean zIsEmpty = TextUtils.isEmpty(str5);
        CommonUtils.Architecture architecture2 = CommonUtils.Architecture.f43742a;
        if (zIsEmpty) {
            logger.e("Architecture#getValue()::Build.CPU_ABI returned null or empty");
        } else {
            CommonUtils.Architecture architecture3 = (CommonUtils.Architecture) CommonUtils.Architecture.f43743b.get(str5.toLowerCase(locale));
            if (architecture3 != null) {
                architecture2 = architecture3;
            }
        }
        int iOrdinal = architecture2.ordinal();
        String str6 = Build.MODEL;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jA = CommonUtils.a(this.f43752a);
        boolean zG = CommonUtils.g();
        int iD = CommonUtils.d();
        String str7 = Build.MANUFACTURER;
        String str8 = Build.PRODUCT;
        this.f43761j.c(str, jCurrentTimeMillis, StaticSessionData.b(appDataB, osDataA, StaticSessionData.DeviceData.c(iOrdinal, iAvailableProcessors, jA, blockCount, zG, iD)));
        if (bool.booleanValue() && str != null) {
            this.f43755d.g(str);
        }
        this.f43760i.d(str);
        this.f43763l.d(str);
        SessionReportingCoordinator sessionReportingCoordinator = this.f43764m;
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = sessionReportingCoordinator.f43835a;
        CrashlyticsReport.Builder builderA = CrashlyticsReport.a();
        builderA.l("19.4.4");
        AppData appData2 = crashlyticsReportDataCapture.f43796c;
        builderA.h(appData2.f43716a);
        IdManager idManager2 = crashlyticsReportDataCapture.f43795b;
        builderA.i(((AutoValue_InstallIdProvider_InstallIds) idManager2.c()).f43727a);
        builderA.g(((AutoValue_InstallIdProvider_InstallIds) idManager2.c()).f43728b);
        builderA.f(((AutoValue_InstallIdProvider_InstallIds) idManager2.c()).f43729c);
        String str9 = appData2.f43721f;
        builderA.d(str9);
        String str10 = appData2.f43722g;
        builderA.e(str10);
        builderA.k(4);
        CrashlyticsReport.Session.Builder builderA2 = CrashlyticsReport.Session.a();
        builderA2.l(jCurrentTimeMillis);
        builderA2.j(str);
        builderA2.h(CrashlyticsReportDataCapture.f43793g);
        CrashlyticsReport.Session.Application.Builder builderA3 = CrashlyticsReport.Session.Application.a();
        builderA3.e(idManager2.f43828c);
        builderA3.g(str9);
        builderA3.d(str10);
        builderA3.f(((AutoValue_InstallIdProvider_InstallIds) idManager2.c()).f43727a);
        DevelopmentPlatformProvider developmentPlatformProvider = appData2.f43723h;
        builderA3.b(developmentPlatformProvider.a());
        builderA3.c(developmentPlatformProvider.b());
        builderA2.b(builderA3.a());
        CrashlyticsReport.Session.OperatingSystem.Builder builderA4 = CrashlyticsReport.Session.OperatingSystem.a();
        builderA4.d(3);
        builderA4.e(str3);
        builderA4.b(str4);
        builderA4.c(CommonUtils.h());
        builderA2.k(builderA4.a());
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        int iIntValue = 7;
        if (!TextUtils.isEmpty(str5) && (num = (Integer) CrashlyticsReportDataCapture.f43792f.get(str5.toLowerCase(locale))) != null) {
            iIntValue = num.intValue();
        }
        int iAvailableProcessors2 = Runtime.getRuntime().availableProcessors();
        long jA2 = CommonUtils.a(crashlyticsReportDataCapture.f43794a);
        long blockCount2 = statFs2.getBlockCount() * statFs2.getBlockSize();
        boolean zG2 = CommonUtils.g();
        int iD2 = CommonUtils.d();
        CrashlyticsReport.Session.Device.Builder builderA5 = CrashlyticsReport.Session.Device.a();
        builderA5.b(iIntValue);
        builderA5.f(str6);
        builderA5.c(iAvailableProcessors2);
        builderA5.h(jA2);
        builderA5.d(blockCount2);
        builderA5.i(zG2);
        builderA5.j(iD2);
        builderA5.e(str7);
        builderA5.g(str8);
        builderA2.e(builderA5.a());
        builderA2.i(3);
        builderA.m(builderA2.a());
        CrashlyticsReport crashlyticsReportA = builderA.a();
        FileStore fileStore = sessionReportingCoordinator.f43836b.f44381b;
        CrashlyticsReport.Session sessionM = crashlyticsReportA.m();
        if (sessionM == null) {
            logger.b("Could not get session for report", null);
            return;
        }
        String strI = sessionM.i();
        try {
            CrashlyticsReportPersistence.f44377g.getClass();
            CrashlyticsReportPersistence.f(fileStore.c(strI, "report"), CrashlyticsReportJsonTransform.f44368a.encode(crashlyticsReportA));
            File fileC = fileStore.c(strI, "start-time");
            long jK = sessionM.k();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileC), CrashlyticsReportPersistence.f44375e);
            try {
                outputStreamWriter.write("");
                fileC.setLastModified(jK * 1000);
                outputStreamWriter.close();
            } finally {
            }
        } catch (IOException e2) {
            logger.b("Could not persist report for session " + strI, e2);
        }
    }

    public final void d(long j2) throws IOException {
        try {
            FileStore fileStore = this.f43758g;
            String str = ".ae" + j2;
            fileStore.getClass();
            if (new File(fileStore.f44386c, str).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e2) {
            Logger.f43705a.f("Could not create app exception marker file.", e2);
        }
    }

    public final boolean e(SettingsController settingsController) throws Throwable {
        CrashlyticsWorkers.a();
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.n;
        boolean z = crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.f43803e.get();
        Logger logger = Logger.f43705a;
        if (z) {
            logger.f("Skipping session finalization because a crash has already occurred.", null);
            return false;
        }
        logger.e("Finalizing previously open sessions.");
        try {
            b(true, settingsController, true);
            logger.e("Closed all previously open sessions.");
            return true;
        } catch (Exception e2) {
            logger.c("Unable to finalize previously open sessions.", e2);
            return false;
        }
    }

    public final String f() {
        NavigableSet navigableSetC = this.f43764m.f43836b.c();
        if (navigableSetC.isEmpty()) {
            return null;
        }
        return (String) navigableSetC.first();
    }

    public final String g() throws Resources.NotFoundException, IOException {
        InputStream resourceAsStream;
        Context context = this.f43752a;
        int iE = CommonUtils.e(context, "com.google.firebase.crashlytics.version_control_info", "string");
        String string = iE == 0 ? null : context.getResources().getString(iE);
        Logger logger = Logger.f43705a;
        if (string != null) {
            logger.b("Read version control info from string resource", null);
            return Base64.encodeToString(string.getBytes(t), 0);
        }
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            logger.f("Couldn't get Class Loader", null);
            resourceAsStream = null;
        } else {
            resourceAsStream = classLoader.getResourceAsStream("META-INF/version-control-info.textproto");
        }
        if (resourceAsStream == null) {
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            logger.d("No version control information found");
            return null;
        }
        try {
            logger.b("Read version control info from file", null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = resourceAsStream.read(bArr);
                    if (i2 == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        String strEncodeToString = Base64.encodeToString(byteArray, 0);
                        resourceAsStream.close();
                        return strEncodeToString;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                resourceAsStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void h() throws Resources.NotFoundException {
        Logger logger = Logger.f43705a;
        try {
            String strG = g();
            if (strG != null) {
                try {
                    this.f43755d.f(strG);
                } catch (IllegalArgumentException e2) {
                    Context context = this.f43752a;
                    if (context != null) {
                        if ((context.getApplicationInfo().flags & 2) != 0) {
                            throw e2;
                        }
                    }
                    logger.c("Attempting to set custom attribute with null key, ignoring.", null);
                }
                logger.d("Saved version control info");
            }
        } catch (IOException e3) {
            logger.f("Unable to save version control info", e3);
        }
    }

    public final void i(final Task task) {
        zzw zzwVar;
        Task taskA;
        FileStore fileStore = this.f43764m.f43836b.f44381b;
        boolean zIsEmpty = FileStore.f(fileStore.f44388e.listFiles()).isEmpty();
        TaskCompletionSource taskCompletionSource = this.o;
        Logger logger = Logger.f43705a;
        if (zIsEmpty && FileStore.f(fileStore.f44389f.listFiles()).isEmpty() && FileStore.f(fileStore.f44390g.listFiles()).isEmpty()) {
            logger.e("No crash reports are available to be sent.");
            taskCompletionSource.d(Boolean.FALSE);
            return;
        }
        logger.e("Crash reports are available to be sent.");
        DataCollectionArbiter dataCollectionArbiter = this.f43753b;
        if (dataCollectionArbiter.b()) {
            logger.b("Automatic data collection is enabled. Allowing upload.", null);
            taskCompletionSource.d(Boolean.FALSE);
            taskA = Tasks.e(Boolean.TRUE);
        } else {
            logger.b("Automatic data collection is disabled.", null);
            logger.e("Notifying that unsent reports are available.");
            taskCompletionSource.d(Boolean.TRUE);
            synchronized (dataCollectionArbiter.f43806c) {
                zzwVar = dataCollectionArbiter.f43807d.f39750a;
            }
            Task taskQ = zzwVar.q(new SuccessContinuation<Void, Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.3
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    return Tasks.e(Boolean.TRUE);
                }
            });
            logger.b("Waiting for send/deleteUnsentReports to be called.", null);
            taskA = CrashlyticsTasks.a(taskQ, this.p.f39750a);
        }
        taskA.r(this.f43756e.f43874a, new SuccessContinuation<Boolean, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Boolean bool = (Boolean) obj;
                boolean zBooleanValue = bool.booleanValue();
                Logger logger2 = Logger.f43705a;
                CrashlyticsController crashlyticsController = CrashlyticsController.this;
                if (zBooleanValue) {
                    logger2.b("Sending cached crash reports...", null);
                    boolean zBooleanValue2 = bool.booleanValue();
                    DataCollectionArbiter dataCollectionArbiter2 = crashlyticsController.f43753b;
                    if (!zBooleanValue2) {
                        dataCollectionArbiter2.getClass();
                        throw new IllegalStateException("An invalid data collection token was used.");
                    }
                    dataCollectionArbiter2.f43811h.d(null);
                    return task.r(crashlyticsController.f43756e.f43874a, new SuccessContinuation<Settings, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4.1
                        @Override // com.google.android.gms.tasks.SuccessContinuation
                        public final Task then(Object obj2) throws NumberFormatException, ClassNotFoundException {
                            if (((Settings) obj2) == null) {
                                Logger.f43705a.f("Received null app settings at app startup. Cannot send cached reports", null);
                                return Tasks.e(null);
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            CrashlyticsController.a(CrashlyticsController.this);
                            CrashlyticsController crashlyticsController2 = CrashlyticsController.this;
                            crashlyticsController2.f43764m.f(null, crashlyticsController2.f43756e.f43874a);
                            crashlyticsController2.q.d(null);
                            return Tasks.e(null);
                        }
                    });
                }
                logger2.e("Deleting cached crash reports...");
                Iterator it = FileStore.f(crashlyticsController.f43758g.f44386c.listFiles(CrashlyticsController.s)).iterator();
                while (it.hasNext()) {
                    ((File) it.next()).delete();
                }
                FileStore fileStore2 = crashlyticsController.f43764m.f43836b.f44381b;
                CrashlyticsReportPersistence.a(FileStore.f(fileStore2.f44388e.listFiles()));
                CrashlyticsReportPersistence.a(FileStore.f(fileStore2.f44389f.listFiles()));
                CrashlyticsReportPersistence.a(FileStore.f(fileStore2.f44390g.listFiles()));
                crashlyticsController.q.d(null);
                return Tasks.e(null);
            }
        });
    }
}
