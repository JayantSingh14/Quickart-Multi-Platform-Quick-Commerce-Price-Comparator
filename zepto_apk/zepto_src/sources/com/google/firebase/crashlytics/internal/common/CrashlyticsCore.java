package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class CrashlyticsCore {

    /* renamed from: a, reason: collision with root package name */
    public final Context f43777a;

    /* renamed from: b, reason: collision with root package name */
    public final DataCollectionArbiter f43778b;

    /* renamed from: c, reason: collision with root package name */
    public final OnDemandCounter f43779c;

    /* renamed from: d, reason: collision with root package name */
    public final long f43780d;

    /* renamed from: e, reason: collision with root package name */
    public CrashlyticsFileMarker f43781e;

    /* renamed from: f, reason: collision with root package name */
    public CrashlyticsFileMarker f43782f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f43783g;

    /* renamed from: h, reason: collision with root package name */
    public CrashlyticsController f43784h;

    /* renamed from: i, reason: collision with root package name */
    public final IdManager f43785i;

    /* renamed from: j, reason: collision with root package name */
    public final FileStore f43786j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.firebase.crashlytics.a f43787k;

    /* renamed from: l, reason: collision with root package name */
    public final com.google.firebase.crashlytics.a f43788l;

    /* renamed from: m, reason: collision with root package name */
    public final CrashlyticsAppQualitySessionsSubscriber f43789m;
    public final CrashlyticsNativeComponentDeferredProxy n;
    public final RemoteConfigDeferredProxy o;
    public final CrashlyticsWorkers p;

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager, CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy, DataCollectionArbiter dataCollectionArbiter, com.google.firebase.crashlytics.a aVar, com.google.firebase.crashlytics.a aVar2, FileStore fileStore, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber, RemoteConfigDeferredProxy remoteConfigDeferredProxy, CrashlyticsWorkers crashlyticsWorkers) {
        this.f43778b = dataCollectionArbiter;
        firebaseApp.a();
        this.f43777a = firebaseApp.f43489a;
        this.f43785i = idManager;
        this.n = crashlyticsNativeComponentDeferredProxy;
        this.f43787k = aVar;
        this.f43788l = aVar2;
        this.f43786j = fileStore;
        this.f43789m = crashlyticsAppQualitySessionsSubscriber;
        this.o = remoteConfigDeferredProxy;
        this.p = crashlyticsWorkers;
        this.f43780d = System.currentTimeMillis();
        this.f43779c = new OnDemandCounter();
    }

    public final Task a() {
        CrashlyticsController crashlyticsController = this.f43784h;
        if (crashlyticsController.r.compareAndSet(false, true)) {
            return crashlyticsController.o.f39750a;
        }
        Logger.f43705a.f("checkForUnsentReports should only be called once per execution.", null);
        return Tasks.e(Boolean.FALSE);
    }

    public final void b() {
        CrashlyticsController crashlyticsController = this.f43784h;
        crashlyticsController.p.d(Boolean.FALSE);
        zzw zzwVar = crashlyticsController.q.f39750a;
    }

    public final void c(SettingsController settingsController) throws IOException {
        CrashlyticsWorkers.a();
        CrashlyticsWorkers.a();
        this.f43781e.a();
        Logger logger = Logger.f43705a;
        logger.e("Initialization marker file was created.");
        try {
            try {
                this.f43787k.a(new BreadcrumbHandler() { // from class: com.google.firebase.crashlytics.internal.common.j
                    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler
                    public final void a(String str) {
                        CrashlyticsCore crashlyticsCore = this.f43863a;
                        crashlyticsCore.getClass();
                        crashlyticsCore.p.f43874a.a(new g(crashlyticsCore, System.currentTimeMillis() - crashlyticsCore.f43780d, str));
                    }
                });
                this.f43784h.h();
                if (!settingsController.d().f44422b.f44427a) {
                    logger.b("Collection of crash reports disabled in Crashlytics settings.", null);
                    throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
                }
                if (!this.f43784h.e(settingsController)) {
                    logger.f("Previous sessions could not be finalized.", null);
                }
                this.f43784h.i(settingsController.c());
                e();
            } catch (Exception e2) {
                logger.c("Crashlytics encountered a problem during asynchronous initialization.", e2);
                e();
            }
        } catch (Throwable th) {
            e();
            throw th;
        }
    }

    public final void d(SettingsController settingsController) throws ExecutionException, InterruptedException, TimeoutException {
        Future<?> futureSubmit = this.p.f43874a.f43870a.submit(new d(this, settingsController, 1));
        Logger logger = Logger.f43705a;
        logger.b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.", null);
        try {
            futureSubmit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            logger.c("Crashlytics was interrupted during initialization.", e2);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e3) {
            logger.c("Crashlytics encountered a problem during initialization.", e3);
        } catch (TimeoutException e4) {
            logger.c("Crashlytics timed out during initialization.", e4);
        }
    }

    public final void e() {
        Logger logger = Logger.f43705a;
        CrashlyticsWorkers.a();
        try {
            CrashlyticsFileMarker crashlyticsFileMarker = this.f43781e;
            String str = crashlyticsFileMarker.f43790a;
            FileStore fileStore = crashlyticsFileMarker.f43791b;
            fileStore.getClass();
            if (new File(fileStore.f44386c, str).delete()) {
                return;
            }
            logger.f("Initialization marker file was not properly removed.", null);
        } catch (Exception e2) {
            logger.c("Problem encountered deleting Crashlytics initialization marker.", e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(com.google.firebase.crashlytics.internal.common.AppData r30, com.google.firebase.crashlytics.internal.settings.SettingsController r31) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.f(com.google.firebase.crashlytics.internal.common.AppData, com.google.firebase.crashlytics.internal.settings.SettingsController):boolean");
    }

    public final void g() {
        CrashlyticsController crashlyticsController = this.f43784h;
        crashlyticsController.p.d(Boolean.TRUE);
        zzw zzwVar = crashlyticsController.q.f39750a;
    }

    public final void h(Boolean bool) {
        Boolean boolA;
        DataCollectionArbiter dataCollectionArbiter = this.f43778b;
        synchronized (dataCollectionArbiter) {
            if (bool != null) {
                try {
                    dataCollectionArbiter.f43809f = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bool != null) {
                boolA = bool;
            } else {
                FirebaseApp firebaseApp = dataCollectionArbiter.f43805b;
                firebaseApp.a();
                boolA = dataCollectionArbiter.a(firebaseApp.f43489a);
            }
            dataCollectionArbiter.f43810g = boolA;
            SharedPreferences.Editor editorEdit = dataCollectionArbiter.f43804a.edit();
            if (bool != null) {
                editorEdit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
            } else {
                editorEdit.remove("firebase_crashlytics_collection_enabled");
            }
            editorEdit.apply();
            synchronized (dataCollectionArbiter.f43806c) {
                try {
                    if (dataCollectionArbiter.b()) {
                        if (!dataCollectionArbiter.f43808e) {
                            dataCollectionArbiter.f43807d.d(null);
                            dataCollectionArbiter.f43808e = true;
                        }
                    } else if (dataCollectionArbiter.f43808e) {
                        dataCollectionArbiter.f43807d = new TaskCompletionSource();
                        dataCollectionArbiter.f43808e = false;
                    }
                } finally {
                }
            }
        }
    }

    public final void i(final String str, final String str2) {
        this.p.f43874a.a(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.e
            @Override // java.lang.Runnable
            public final void run() {
                String str3 = str;
                String str4 = str2;
                CrashlyticsController crashlyticsController = this.f43850a.f43784h;
                crashlyticsController.getClass();
                try {
                    crashlyticsController.f43755d.e(str3, str4);
                } catch (IllegalArgumentException e2) {
                    Context context = crashlyticsController.f43752a;
                    if (context != null && (context.getApplicationInfo().flags & 2) != 0) {
                        throw e2;
                    }
                    Logger.f43705a.c("Attempting to set custom attribute with null key, ignoring.", null);
                }
            }
        });
    }
}
