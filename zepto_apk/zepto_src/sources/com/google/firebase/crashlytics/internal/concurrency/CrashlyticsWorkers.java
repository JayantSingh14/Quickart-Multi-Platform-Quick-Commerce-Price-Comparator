package com.google.firebase.crashlytics.internal.concurrency;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class CrashlyticsWorkers {

    /* renamed from: d, reason: collision with root package name */
    public static final Companion f43873d = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final CrashlyticsWorker f43874a;

    /* renamed from: b, reason: collision with root package name */
    public final CrashlyticsWorker f43875b;

    /* renamed from: c, reason: collision with root package name */
    public final CrashlyticsWorker f43876c;

    @Metadata
    public static final class Companion {
        public static void a(Function0 function0, Function0 function02) {
            if (((Boolean) function0.invoke()).booleanValue()) {
                return;
            }
            Logger.f43705a.b((String) function02.invoke(), null);
        }

        public static String b() {
            return Thread.currentThread().getName();
        }
    }

    public CrashlyticsWorkers(ExecutorService backgroundExecutorService, ExecutorService blockingExecutorService) {
        Intrinsics.checkNotNullParameter(backgroundExecutorService, "backgroundExecutorService");
        Intrinsics.checkNotNullParameter(blockingExecutorService, "blockingExecutorService");
        this.f43874a = new CrashlyticsWorker(backgroundExecutorService);
        this.f43875b = new CrashlyticsWorker(backgroundExecutorService);
        new CrashlyticsWorker(backgroundExecutorService);
        this.f43876c = new CrashlyticsWorker(blockingExecutorService);
    }

    public static final void a() {
        Companion.a(new CrashlyticsWorkers$Companion$checkBackgroundThread$1(0, f43873d, Companion.class, "isBackgroundThread", "isBackgroundThread()Z", 0), CrashlyticsWorkers$Companion$checkBackgroundThread$2.f43877c);
    }

    public static final void b() {
        Companion.a(new CrashlyticsWorkers$Companion$checkBlockingThread$1(0, f43873d, Companion.class, "isBlockingThread", "isBlockingThread()Z", 0), CrashlyticsWorkers$Companion$checkBlockingThread$2.f43878c);
    }

    public static final void c() {
        Companion.a(new CrashlyticsWorkers$Companion$checkNotMainThread$1(0, f43873d, Companion.class, "isNotMainThread", "isNotMainThread()Z", 0), CrashlyticsWorkers$Companion$checkNotMainThread$2.f43879c);
    }
}
