package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.UUID;

@RestrictTo
/* loaded from: classes3.dex */
public class WorkProgressUpdater implements ProgressUpdater {

    /* renamed from: c, reason: collision with root package name */
    public static final String f13016c = Logger.g("WorkProgressUpdater");

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase f13017a;

    /* renamed from: b, reason: collision with root package name */
    public final WorkManagerTaskExecutor f13018b;

    public WorkProgressUpdater(WorkDatabase workDatabase, WorkManagerTaskExecutor workManagerTaskExecutor) {
        this.f13017a = workDatabase;
        this.f13018b = workManagerTaskExecutor;
    }

    public final SettableFuture a(final UUID uuid, final Data data) {
        final SettableFuture settableFuture = new SettableFuture();
        this.f13018b.c(new Runnable() { // from class: androidx.work.impl.utils.WorkProgressUpdater.1
            @Override // java.lang.Runnable
            public final void run() {
                SettableFuture settableFuture2 = settableFuture;
                UUID uuid2 = uuid;
                String string = uuid2.toString();
                Logger loggerE = Logger.e();
                String str = WorkProgressUpdater.f13016c;
                StringBuilder sb = new StringBuilder("Updating progress for ");
                sb.append(uuid2);
                sb.append(" (");
                Data data2 = data;
                sb.append(data2);
                sb.append(")");
                loggerE.a(str, sb.toString());
                WorkProgressUpdater workProgressUpdater = WorkProgressUpdater.this;
                WorkDatabase workDatabase = workProgressUpdater.f13017a;
                WorkDatabase workDatabase2 = workProgressUpdater.f13017a;
                workDatabase.c();
                try {
                    WorkSpec workSpecJ = workDatabase2.v().j(string);
                    if (workSpecJ == null) {
                        throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    if (workSpecJ.f12906b == WorkInfo.State.f12567b) {
                        workDatabase2.u().c(new WorkProgress(string, data2));
                    } else {
                        Logger.e().h(str, "Ignoring setProgressAsync(...). WorkSpec (" + string + ") is not in a RUNNING state.");
                    }
                    settableFuture2.i(null);
                    workDatabase2.o();
                } catch (Throwable th) {
                    try {
                        Logger.e().d(WorkProgressUpdater.f13016c, "Error updating Worker progress", th);
                        settableFuture2.j(th);
                    } finally {
                        workDatabase2.j();
                    }
                }
            }
        });
        return settableFuture;
    }
}
