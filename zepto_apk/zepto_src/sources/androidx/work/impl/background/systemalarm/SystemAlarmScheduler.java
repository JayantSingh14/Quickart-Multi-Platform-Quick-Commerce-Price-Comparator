package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;

@RestrictTo
/* loaded from: classes3.dex */
public class SystemAlarmScheduler implements Scheduler {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12772a = Logger.g("SystemAlarmScheduler");

    @Override // androidx.work.impl.Scheduler
    public final void a(String str) {
        String str2 = CommandHandler.f12726f;
        Intent intent = new Intent((Context) null, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        throw null;
    }

    @Override // androidx.work.impl.Scheduler
    public final void b(WorkSpec... workSpecArr) {
        if (workSpecArr.length <= 0) {
            return;
        }
        WorkSpec workSpec = workSpecArr[0];
        Logger.e().a(f12772a, "Scheduling work with workSpecId " + workSpec.f12905a);
        WorkGenerationalId workGenerationalIdA = WorkSpecKt.a(workSpec);
        String str = CommandHandler.f12726f;
        Intent intent = new Intent((Context) null, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        CommandHandler.d(intent, workGenerationalIdA);
        throw null;
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean d() {
        return true;
    }
}
