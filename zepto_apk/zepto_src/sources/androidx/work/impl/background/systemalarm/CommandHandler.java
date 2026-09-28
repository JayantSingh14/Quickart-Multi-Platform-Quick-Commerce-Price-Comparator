package androidx.work.impl.background.systemalarm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.SystemClock;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RestrictTo
/* loaded from: classes3.dex */
public class CommandHandler implements ExecutionListener {

    /* renamed from: f, reason: collision with root package name */
    public static final String f12726f = Logger.g("CommandHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f12727a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f12728b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Object f12729c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final SystemClock f12730d;

    /* renamed from: e, reason: collision with root package name */
    public final StartStopTokens f12731e;

    public CommandHandler(Context context, SystemClock systemClock, StartStopTokens startStopTokens) {
        this.f12727a = context;
        this.f12730d = systemClock;
        this.f12731e = startStopTokens;
    }

    public static WorkGenerationalId b(Intent intent) {
        return new WorkGenerationalId(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void d(Intent intent, WorkGenerationalId workGenerationalId) {
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.f12893a);
        intent.putExtra("KEY_WORKSPEC_GENERATION", workGenerationalId.f12894b);
    }

    public final void a(int i2, Intent intent, SystemAlarmDispatcher systemAlarmDispatcher) {
        List<StartStopToken> listC;
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            Logger.e().a(f12726f, "Handling constraints changed " + intent);
            ConstraintsCommandHandler constraintsCommandHandler = new ConstraintsCommandHandler(this.f12727a, this.f12730d, i2, systemAlarmDispatcher);
            ArrayList arrayListG = systemAlarmDispatcher.f12761e.f12655c.v().g();
            String str = ConstraintProxy.f12732a;
            Iterator it = arrayListG.iterator();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            while (it.hasNext()) {
                Constraints constraints = ((WorkSpec) it.next()).f12914j;
                z |= constraints.f12490d;
                z2 |= constraints.f12488b;
                z3 |= constraints.f12491e;
                z4 |= constraints.f12487a != NetworkType.f12536a;
                if (z && z2 && z3 && z4) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.f12733a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            Context context = constraintsCommandHandler.f12738a;
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z4);
            context.sendBroadcast(intent2);
            ArrayList arrayList = new ArrayList(arrayListG.size());
            constraintsCommandHandler.f12739b.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it2 = arrayListG.iterator();
            while (it2.hasNext()) {
                WorkSpec workSpec = (WorkSpec) it2.next();
                if (jCurrentTimeMillis >= workSpec.a() && (!workSpec.b() || constraintsCommandHandler.f12741d.a(workSpec))) {
                    arrayList.add(workSpec);
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                WorkSpec workSpec2 = (WorkSpec) it3.next();
                String str3 = workSpec2.f12905a;
                WorkGenerationalId workGenerationalIdA = WorkSpecKt.a(workSpec2);
                Intent intent3 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent3.setAction("ACTION_DELAY_MET");
                d(intent3, workGenerationalIdA);
                Logger.e().a(ConstraintsCommandHandler.f12737e, b.D("Creating a delay_met command for workSpec with id (", str3, ")"));
                systemAlarmDispatcher.f12758b.f13064d.execute(new SystemAlarmDispatcher.AddRunnable(constraintsCommandHandler.f12740c, intent3, systemAlarmDispatcher));
            }
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            Logger.e().a(f12726f, "Handling reschedule " + intent + ", " + i2);
            systemAlarmDispatcher.f12761e.i();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            Logger.e().c(f12726f, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            WorkGenerationalId workGenerationalIdB = b(intent);
            String str4 = f12726f;
            Logger.e().a(str4, "Handling schedule work for " + workGenerationalIdB);
            WorkDatabase workDatabase = systemAlarmDispatcher.f12761e.f12655c;
            workDatabase.c();
            try {
                WorkSpec workSpecJ = workDatabase.v().j(workGenerationalIdB.f12893a);
                if (workSpecJ == null) {
                    Logger.e().h(str4, "Skipping scheduling " + workGenerationalIdB + " because it's no longer in the DB");
                    return;
                }
                if (workSpecJ.f12906b.a()) {
                    Logger.e().h(str4, "Skipping scheduling " + workGenerationalIdB + "because it is finished.");
                    return;
                }
                long jA = workSpecJ.a();
                boolean zB = workSpecJ.b();
                Context context2 = this.f12727a;
                if (zB) {
                    Logger.e().a(str4, "Opportunistically setting an alarm for " + workGenerationalIdB + "at " + jA);
                    Alarms.b(context2, workDatabase, workGenerationalIdB, jA);
                    Intent intent4 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                    intent4.setAction("ACTION_CONSTRAINTS_CHANGED");
                    systemAlarmDispatcher.f12758b.f13064d.execute(new SystemAlarmDispatcher.AddRunnable(i2, intent4, systemAlarmDispatcher));
                } else {
                    Logger.e().a(str4, "Setting up Alarms for " + workGenerationalIdB + "at " + jA);
                    Alarms.b(context2, workDatabase, workGenerationalIdB, jA);
                }
                workDatabase.o();
                return;
            } finally {
                workDatabase.j();
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            synchronized (this.f12729c) {
                try {
                    WorkGenerationalId workGenerationalIdB2 = b(intent);
                    Logger loggerE = Logger.e();
                    String str5 = f12726f;
                    loggerE.a(str5, "Handing delay met for " + workGenerationalIdB2);
                    if (this.f12728b.containsKey(workGenerationalIdB2)) {
                        Logger.e().a(str5, "WorkSpec " + workGenerationalIdB2 + " is is already being handled for ACTION_DELAY_MET");
                    } else {
                        DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.f12727a, i2, systemAlarmDispatcher, this.f12731e.d(workGenerationalIdB2));
                        this.f12728b.put(workGenerationalIdB2, delayMetCommandHandler);
                        delayMetCommandHandler.f();
                    }
                } finally {
                }
            }
            return;
        }
        if (!"ACTION_STOP_WORK".equals(action)) {
            if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                Logger.e().h(f12726f, "Ignoring intent " + intent);
                return;
            }
            WorkGenerationalId workGenerationalIdB3 = b(intent);
            boolean z5 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
            Logger.e().a(f12726f, "Handling onExecutionCompleted " + intent + ", " + i2);
            c(workGenerationalIdB3, z5);
            return;
        }
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString("KEY_WORKSPEC_ID");
        boolean zContainsKey = extras2.containsKey("KEY_WORKSPEC_GENERATION");
        StartStopTokens startStopTokens = this.f12731e;
        if (zContainsKey) {
            int i3 = extras2.getInt("KEY_WORKSPEC_GENERATION");
            ArrayList arrayList2 = new ArrayList(1);
            StartStopToken startStopTokenB = startStopTokens.b(new WorkGenerationalId(string, i3));
            listC = arrayList2;
            if (startStopTokenB != null) {
                arrayList2.add(startStopTokenB);
                listC = arrayList2;
            }
        } else {
            listC = startStopTokens.c(string);
        }
        for (StartStopToken startStopToken : listC) {
            Logger.e().a(f12726f, b.C("Handing stopWork work for ", string));
            systemAlarmDispatcher.f12766j.d(startStopToken);
            WorkDatabase workDatabase2 = systemAlarmDispatcher.f12761e.f12655c;
            WorkGenerationalId workGenerationalId = startStopToken.f12629a;
            String str6 = Alarms.f12725a;
            SystemIdInfoDao systemIdInfoDaoS = workDatabase2.s();
            SystemIdInfo systemIdInfoC = systemIdInfoDaoS.c(workGenerationalId);
            if (systemIdInfoC != null) {
                Alarms.a(this.f12727a, workGenerationalId, systemIdInfoC.f12888c);
                Logger.e().a(Alarms.f12725a, "Removing SystemIdInfo for workSpecId (" + workGenerationalId + ")");
                systemIdInfoDaoS.e(workGenerationalId);
            }
            systemAlarmDispatcher.c(startStopToken.f12629a, false);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void c(WorkGenerationalId workGenerationalId, boolean z) {
        synchronized (this.f12729c) {
            try {
                DelayMetCommandHandler delayMetCommandHandler = (DelayMetCommandHandler) this.f12728b.remove(workGenerationalId);
                this.f12731e.b(workGenerationalId);
                if (delayMetCommandHandler != null) {
                    delayMetCommandHandler.g(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
