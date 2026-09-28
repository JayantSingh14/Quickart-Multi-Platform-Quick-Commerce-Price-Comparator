package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.UUID;

@RestrictTo
/* loaded from: classes3.dex */
public class WorkForegroundUpdater implements ForegroundUpdater {

    /* renamed from: a, reason: collision with root package name */
    public final WorkManagerTaskExecutor f13008a;

    /* renamed from: b, reason: collision with root package name */
    public final Processor f13009b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkSpecDao f13010c;

    static {
        Logger.g("WMFgUpdater");
    }

    public WorkForegroundUpdater(WorkDatabase workDatabase, Processor processor, WorkManagerTaskExecutor workManagerTaskExecutor) {
        this.f13009b = processor;
        this.f13008a = workManagerTaskExecutor;
        this.f13010c = workDatabase.v();
    }

    public final SettableFuture a(final Context context, final UUID uuid, final ForegroundInfo foregroundInfo) {
        final SettableFuture settableFuture = new SettableFuture();
        this.f13008a.c(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundUpdater.1
            @Override // java.lang.Runnable
            public final void run() {
                Context context2 = context;
                ForegroundInfo foregroundInfo2 = foregroundInfo;
                WorkForegroundUpdater workForegroundUpdater = WorkForegroundUpdater.this;
                SettableFuture settableFuture2 = settableFuture;
                try {
                    if (!settableFuture2.isCancelled()) {
                        String string = uuid.toString();
                        WorkSpec workSpecJ = workForegroundUpdater.f13010c.j(string);
                        if (workSpecJ == null || workSpecJ.f12906b.a()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        workForegroundUpdater.f13009b.g(string, foregroundInfo2);
                        context2.startService(SystemForegroundDispatcher.a(context2, WorkSpecKt.a(workSpecJ), foregroundInfo2));
                    }
                    settableFuture2.i(null);
                } catch (Throwable th) {
                    settableFuture2.j(th);
                }
            }
        });
        return settableFuture;
    }
}
