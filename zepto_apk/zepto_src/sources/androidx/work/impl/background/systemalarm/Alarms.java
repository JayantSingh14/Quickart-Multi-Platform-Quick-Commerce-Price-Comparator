package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.c;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.IdGenerator;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo
/* loaded from: classes3.dex */
class Alarms {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12725a = Logger.g("Alarms");

    @RequiresApi
    public static class Api19Impl {
        @DoNotInline
        public static void a(AlarmManager alarmManager, int i2, long j2, PendingIntent pendingIntent) {
            alarmManager.setExact(i2, j2, pendingIntent);
        }
    }

    public static void a(Context context, WorkGenerationalId workGenerationalId, int i2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        String str = CommandHandler.f12726f;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        CommandHandler.d(intent, workGenerationalId);
        PendingIntent service = PendingIntent.getService(context, i2, intent, 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        Logger.e().a(f12725a, "Cancelling existing alarm with (workSpecId, systemId) (" + workGenerationalId + ", " + i2 + ")");
        alarmManager.cancel(service);
    }

    public static void b(Context context, WorkDatabase workDatabase, WorkGenerationalId generationalId, long j2) {
        SystemIdInfoDao systemIdInfoDaoS = workDatabase.s();
        SystemIdInfo systemIdInfoC = systemIdInfoDaoS.c(generationalId);
        if (systemIdInfoC != null) {
            int i2 = systemIdInfoC.f12888c;
            a(context, generationalId, i2);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            String str = CommandHandler.f12726f;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_DELAY_MET");
            CommandHandler.d(intent, generationalId);
            PendingIntent service = PendingIntent.getService(context, i2, intent, 201326592);
            if (alarmManager != null) {
                Api19Impl.a(alarmManager, 0, j2, service);
                return;
            }
            return;
        }
        Object objN = workDatabase.n(new c(new IdGenerator(workDatabase), 2));
        Intrinsics.checkNotNullExpressionValue(objN, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        int iIntValue = ((Number) objN).intValue();
        Intrinsics.checkNotNullParameter(generationalId, "generationalId");
        systemIdInfoDaoS.g(new SystemIdInfo(generationalId.f12893a, generationalId.f12894b, iIntValue));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        String str2 = CommandHandler.f12726f;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_DELAY_MET");
        CommandHandler.d(intent2, generationalId);
        PendingIntent service2 = PendingIntent.getService(context, iIntValue, intent2, 201326592);
        if (alarmManager2 != null) {
            Api19Impl.a(alarmManager2, 0, j2, service2);
        }
    }
}
