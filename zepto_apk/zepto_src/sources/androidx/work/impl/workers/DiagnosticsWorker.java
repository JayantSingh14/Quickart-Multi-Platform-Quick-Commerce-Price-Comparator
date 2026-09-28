package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(@NotNull Context context, @NotNull WorkerParameters parameters) {
        super(context, parameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        WorkManagerImpl workManagerImplF = WorkManagerImpl.f(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(workManagerImplF, "getInstance(applicationContext)");
        WorkDatabase workDatabase = workManagerImplF.f12655c;
        Intrinsics.checkNotNullExpressionValue(workDatabase, "workManager.workDatabase");
        WorkSpecDao workSpecDaoV = workDatabase.v();
        WorkNameDao workNameDaoT = workDatabase.t();
        WorkTagDao workTagDaoW = workDatabase.w();
        SystemIdInfoDao systemIdInfoDaoS = workDatabase.s();
        workManagerImplF.f12654b.f12476c.getClass();
        ArrayList arrayListD = workSpecDaoV.d(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        ArrayList arrayListU = workSpecDaoV.u();
        ArrayList arrayListO = workSpecDaoV.o();
        if (!arrayListD.isEmpty()) {
            Logger loggerE = Logger.e();
            String str = DiagnosticsWorkerKt.f13072a;
            loggerE.f(str, "Recently completed work:\n\n");
            Logger.e().f(str, DiagnosticsWorkerKt.a(workNameDaoT, workTagDaoW, systemIdInfoDaoS, arrayListD));
        }
        if (!arrayListU.isEmpty()) {
            Logger loggerE2 = Logger.e();
            String str2 = DiagnosticsWorkerKt.f13072a;
            loggerE2.f(str2, "Running work:\n\n");
            Logger.e().f(str2, DiagnosticsWorkerKt.a(workNameDaoT, workTagDaoW, systemIdInfoDaoS, arrayListU));
        }
        if (!arrayListO.isEmpty()) {
            Logger loggerE3 = Logger.e();
            String str3 = DiagnosticsWorkerKt.f13072a;
            loggerE3.f(str3, "Enqueued work:\n\n");
            Logger.e().f(str3, DiagnosticsWorkerKt.a(workNameDaoT, workTagDaoW, systemIdInfoDaoS, arrayListO));
        }
        ListenableWorker.Result.Success success = new ListenableWorker.Result.Success();
        Intrinsics.checkNotNullExpressionValue(success, "success()");
        return success;
    }
}
