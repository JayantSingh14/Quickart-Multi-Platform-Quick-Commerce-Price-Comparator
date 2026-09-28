package androidx.work.impl;

import android.content.Context;
import android.content.res.Resources;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.R;
import androidx.work.SystemClock;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SerialExecutorImpl;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class WorkManagerImplExtKt {
    public static final WorkManagerImpl a(Context p0, Configuration p1) throws Resources.NotFoundException {
        RoomDatabase.Builder builderA;
        int i2 = 0;
        Intrinsics.checkNotNullParameter(p0, "context");
        Intrinsics.checkNotNullParameter(p1, "configuration");
        WorkManagerTaskExecutor workTaskExecutor = new WorkManagerTaskExecutor(p1.f12475b);
        Context context = p0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context, "context.applicationContext");
        SerialExecutorImpl executor = workTaskExecutor.f13061a;
        Intrinsics.checkNotNullExpressionValue(executor, "workTaskExecutor.serialTaskExecutor");
        SystemClock clock = p1.f12476c;
        boolean z = p0.getResources().getBoolean(R.bool.workmanager_test_configuration);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executor, "queryExecutor");
        Intrinsics.checkNotNullParameter(clock, "clock");
        if (z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(WorkDatabase.class, "klass");
            builderA = new RoomDatabase.Builder(context, WorkDatabase.class, null);
            builderA.f11818j = true;
        } else {
            builderA = Room.a(context, WorkDatabase.class, "androidx.work.workdb");
            builderA.f11817i = new c(context, i2);
        }
        Intrinsics.checkNotNullParameter(executor, "executor");
        builderA.f11815g = executor;
        CleanupCallback callback = new CleanupCallback(clock);
        Intrinsics.checkNotNullParameter(callback, "callback");
        builderA.f11812d.add(callback);
        builderA.a(Migration_1_2.f12607c);
        builderA.a(new RescheduleMigration(context, 2, 3));
        builderA.a(Migration_3_4.f12608c);
        builderA.a(Migration_4_5.f12609c);
        builderA.a(new RescheduleMigration(context, 5, 6));
        builderA.a(Migration_6_7.f12610c);
        builderA.a(Migration_7_8.f12611c);
        builderA.a(Migration_8_9.f12612c);
        builderA.a(new WorkMigration9To10(context));
        builderA.a(new RescheduleMigration(context, 10, 11));
        builderA.a(Migration_11_12.f12603c);
        builderA.a(Migration_12_13.f12604c);
        builderA.a(Migration_15_16.f12605c);
        builderA.a(Migration_16_17.f12606c);
        builderA.f11820l = false;
        builderA.f11821m = true;
        WorkDatabase p3 = (WorkDatabase) builderA.b();
        Context applicationContext = p0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        Trackers p4 = new Trackers(applicationContext, workTaskExecutor);
        Processor p5 = new Processor(p0.getApplicationContext(), p1, workTaskExecutor, p3);
        WorkManagerImplExtKt$WorkManagerImpl$1 schedulersCreator = WorkManagerImplExtKt$WorkManagerImpl$1.f12663b;
        Intrinsics.checkNotNullParameter(p0, "context");
        Intrinsics.checkNotNullParameter(p1, "configuration");
        Intrinsics.checkNotNullParameter(workTaskExecutor, "workTaskExecutor");
        Intrinsics.checkNotNullParameter(p3, "workDatabase");
        Intrinsics.checkNotNullParameter(p4, "trackers");
        Intrinsics.checkNotNullParameter(p5, "processor");
        Intrinsics.checkNotNullParameter(schedulersCreator, "schedulersCreator");
        schedulersCreator.getClass();
        WorkManagerTaskExecutor p2 = workTaskExecutor;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        Intrinsics.checkNotNullParameter(p5, "p5");
        String str = Schedulers.f12628a;
        SystemJobScheduler systemJobScheduler = new SystemJobScheduler(p0, p3, p1);
        PackageManagerHelper.a(p0, SystemJobService.class, true);
        Logger.e().a(Schedulers.f12628a, "Created SystemJobScheduler and enabled SystemJobService");
        Intrinsics.checkNotNullExpressionValue(systemJobScheduler, "createBestAvailableBackg…kDatabase, configuration)");
        return new WorkManagerImpl(p0.getApplicationContext(), p1, workTaskExecutor, p3, CollectionsKt.I(systemJobScheduler, new GreedyScheduler(p0, p1, p4, p5, new WorkLauncherImpl(p5, p2), p2)), p5, p4);
    }
}
