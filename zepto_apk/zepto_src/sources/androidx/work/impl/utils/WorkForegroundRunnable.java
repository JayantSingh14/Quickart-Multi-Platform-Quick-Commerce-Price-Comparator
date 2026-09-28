package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;

@RestrictTo
/* loaded from: classes3.dex */
public class WorkForegroundRunnable implements Runnable {

    /* renamed from: g, reason: collision with root package name */
    public static final String f12999g = Logger.g("WorkForegroundRunnable");

    /* renamed from: a, reason: collision with root package name */
    public final SettableFuture f13000a = new SettableFuture();

    /* renamed from: b, reason: collision with root package name */
    public final Context f13001b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkSpec f13002c;

    /* renamed from: d, reason: collision with root package name */
    public final ListenableWorker f13003d;

    /* renamed from: e, reason: collision with root package name */
    public final WorkForegroundUpdater f13004e;

    /* renamed from: f, reason: collision with root package name */
    public final WorkManagerTaskExecutor f13005f;

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, WorkForegroundUpdater workForegroundUpdater, WorkManagerTaskExecutor workManagerTaskExecutor) {
        this.f13001b = context;
        this.f13002c = workSpec;
        this.f13003d = listenableWorker;
        this.f13004e = workForegroundUpdater;
        this.f13005f = workManagerTaskExecutor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f13002c.q || Build.VERSION.SDK_INT >= 31) {
            this.f13000a.i(null);
            return;
        }
        final SettableFuture settableFuture = new SettableFuture();
        WorkManagerTaskExecutor workManagerTaskExecutor = this.f13005f;
        workManagerTaskExecutor.f13064d.execute(new androidx.constraintlayout.motion.widget.a(14, this, settableFuture));
        settableFuture.q(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundRunnable.1
            @Override // java.lang.Runnable
            public final void run() {
                WorkForegroundRunnable workForegroundRunnable = WorkForegroundRunnable.this;
                SettableFuture settableFuture2 = workForegroundRunnable.f13000a;
                if (settableFuture2.isCancelled()) {
                    return;
                }
                try {
                    ForegroundInfo foregroundInfo = (ForegroundInfo) settableFuture.get();
                    WorkSpec workSpec = workForegroundRunnable.f13002c;
                    if (foregroundInfo == null) {
                        throw new IllegalStateException("Worker was marked important (" + workSpec.f12907c + ") but did not provide ForegroundInfo");
                    }
                    Logger.e().a(WorkForegroundRunnable.f12999g, "Updating notification for " + workSpec.f12907c);
                    settableFuture2.k(workForegroundRunnable.f13004e.a(workForegroundRunnable.f13001b, workForegroundRunnable.f13003d.getId(), foregroundInfo));
                } catch (Throwable th) {
                    settableFuture2.j(th);
                }
            }
        }, workManagerTaskExecutor.f13064d);
    }
}
