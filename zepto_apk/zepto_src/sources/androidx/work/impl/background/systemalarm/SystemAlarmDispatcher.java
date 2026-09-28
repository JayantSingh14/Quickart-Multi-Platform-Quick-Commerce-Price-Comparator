package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

@RestrictTo
/* loaded from: classes3.dex */
public class SystemAlarmDispatcher implements ExecutionListener {

    /* renamed from: k, reason: collision with root package name */
    public static final String f12756k = Logger.g("SystemAlarmDispatcher");

    /* renamed from: a, reason: collision with root package name */
    public final Context f12757a;

    /* renamed from: b, reason: collision with root package name */
    public final WorkManagerTaskExecutor f12758b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkTimer f12759c;

    /* renamed from: d, reason: collision with root package name */
    public final Processor f12760d;

    /* renamed from: e, reason: collision with root package name */
    public final WorkManagerImpl f12761e;

    /* renamed from: f, reason: collision with root package name */
    public final CommandHandler f12762f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f12763g;

    /* renamed from: h, reason: collision with root package name */
    public Intent f12764h;

    /* renamed from: i, reason: collision with root package name */
    public SystemAlarmService f12765i;

    /* renamed from: j, reason: collision with root package name */
    public final WorkLauncher f12766j;

    public static class AddRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final SystemAlarmDispatcher f12768a;

        /* renamed from: b, reason: collision with root package name */
        public final Intent f12769b;

        /* renamed from: c, reason: collision with root package name */
        public final int f12770c;

        public AddRunnable(int i2, Intent intent, SystemAlarmDispatcher systemAlarmDispatcher) {
            this.f12768a = systemAlarmDispatcher;
            this.f12769b = intent;
            this.f12770c = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f12768a.a(this.f12769b, this.f12770c);
        }
    }

    public interface CommandsCompletedListener {
    }

    public static class DequeueAndCheckForCompletion implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final SystemAlarmDispatcher f12771a;

        public DequeueAndCheckForCompletion(SystemAlarmDispatcher systemAlarmDispatcher) {
            this.f12771a = systemAlarmDispatcher;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x009b A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:4:0x0018, B:6:0x001c, B:8:0x0042, B:11:0x0048, B:12:0x004f, B:13:0x0050, B:14:0x0058, B:18:0x0062, B:20:0x006a, B:21:0x006c, B:25:0x0076, B:27:0x0083, B:35:0x00a6, B:31:0x009a, B:32:0x009b, B:34:0x00a3, B:39:0x00aa, B:22:0x006d, B:23:0x0073, B:15:0x0059, B:16:0x005f), top: B:42:0x0018, inners: #1, #2 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                r6 = this;
                androidx.work.impl.background.systemalarm.SystemAlarmDispatcher r0 = r6.f12771a
                r0.getClass()
                java.lang.String r1 = "Removing command "
                androidx.work.Logger r2 = androidx.work.Logger.e()
                java.lang.String r3 = androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.f12756k
                java.lang.String r4 = "Checking if commands are complete."
                r2.a(r3, r4)
                androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.b()
                java.util.ArrayList r2 = r0.f12763g
                monitor-enter(r2)
                android.content.Intent r4 = r0.f12764h     // Catch: java.lang.Throwable -> L46
                if (r4 == 0) goto L50
                androidx.work.Logger r4 = androidx.work.Logger.e()     // Catch: java.lang.Throwable -> L46
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46
                r5.<init>(r1)     // Catch: java.lang.Throwable -> L46
                android.content.Intent r1 = r0.f12764h     // Catch: java.lang.Throwable -> L46
                r5.append(r1)     // Catch: java.lang.Throwable -> L46
                java.lang.String r1 = r5.toString()     // Catch: java.lang.Throwable -> L46
                r4.a(r3, r1)     // Catch: java.lang.Throwable -> L46
                java.util.ArrayList r1 = r0.f12763g     // Catch: java.lang.Throwable -> L46
                r4 = 0
                java.lang.Object r1 = r1.remove(r4)     // Catch: java.lang.Throwable -> L46
                android.content.Intent r1 = (android.content.Intent) r1     // Catch: java.lang.Throwable -> L46
                android.content.Intent r4 = r0.f12764h     // Catch: java.lang.Throwable -> L46
                boolean r1 = r1.equals(r4)     // Catch: java.lang.Throwable -> L46
                if (r1 == 0) goto L48
                r1 = 0
                r0.f12764h = r1     // Catch: java.lang.Throwable -> L46
                goto L50
            L46:
                r0 = move-exception
                goto Lab
            L48:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L46
                java.lang.String r1 = "Dequeue-d command is not the first."
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L46
                throw r0     // Catch: java.lang.Throwable -> L46
            L50:
                androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor r1 = r0.f12758b     // Catch: java.lang.Throwable -> L46
                androidx.work.impl.utils.SerialExecutorImpl r1 = r1.f13061a     // Catch: java.lang.Throwable -> L46
                androidx.work.impl.background.systemalarm.CommandHandler r4 = r0.f12762f     // Catch: java.lang.Throwable -> L46
                java.lang.Object r5 = r4.f12729c     // Catch: java.lang.Throwable -> L46
                monitor-enter(r5)     // Catch: java.lang.Throwable -> L46
                java.util.HashMap r4 = r4.f12728b     // Catch: java.lang.Throwable -> La8
                boolean r4 = r4.isEmpty()     // Catch: java.lang.Throwable -> La8
                monitor-exit(r5)     // Catch: java.lang.Throwable -> La8
                if (r4 == 0) goto L9b
                java.util.ArrayList r4 = r0.f12763g     // Catch: java.lang.Throwable -> L46
                boolean r4 = r4.isEmpty()     // Catch: java.lang.Throwable -> L46
                if (r4 == 0) goto L9b
                java.lang.Object r4 = r1.f12983d     // Catch: java.lang.Throwable -> L46
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L46
                java.util.ArrayDeque r1 = r1.f12980a     // Catch: java.lang.Throwable -> L98
                boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L98
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L98
                if (r1 == 0) goto L9b
                androidx.work.Logger r1 = androidx.work.Logger.e()     // Catch: java.lang.Throwable -> L46
                java.lang.String r4 = "No more commands & intents."
                r1.a(r3, r4)     // Catch: java.lang.Throwable -> L46
                androidx.work.impl.background.systemalarm.SystemAlarmService r0 = r0.f12765i     // Catch: java.lang.Throwable -> L46
                if (r0 == 0) goto La6
                r1 = 1
                r0.f12775c = r1     // Catch: java.lang.Throwable -> L46
                androidx.work.Logger r1 = androidx.work.Logger.e()     // Catch: java.lang.Throwable -> L46
                java.lang.String r3 = androidx.work.impl.background.systemalarm.SystemAlarmService.f12773d     // Catch: java.lang.Throwable -> L46
                java.lang.String r4 = "All commands completed in dispatcher"
                r1.a(r3, r4)     // Catch: java.lang.Throwable -> L46
                androidx.work.impl.utils.WakeLocks.a()     // Catch: java.lang.Throwable -> L46
                r0.stopSelf()     // Catch: java.lang.Throwable -> L46
                goto La6
            L98:
                r0 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L98
                throw r0     // Catch: java.lang.Throwable -> L46
            L9b:
                java.util.ArrayList r1 = r0.f12763g     // Catch: java.lang.Throwable -> L46
                boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L46
                if (r1 != 0) goto La6
                r0.d()     // Catch: java.lang.Throwable -> L46
            La6:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L46
                return
            La8:
                r0 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> La8
                throw r0     // Catch: java.lang.Throwable -> L46
            Lab:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L46
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.DequeueAndCheckForCompletion.run():void");
        }
    }

    public SystemAlarmDispatcher(SystemAlarmService systemAlarmService) {
        Context applicationContext = systemAlarmService.getApplicationContext();
        this.f12757a = applicationContext;
        StartStopTokens startStopTokens = new StartStopTokens();
        WorkManagerImpl workManagerImplF = WorkManagerImpl.f(systemAlarmService);
        this.f12761e = workManagerImplF;
        this.f12762f = new CommandHandler(applicationContext, workManagerImplF.f12654b.f12476c, startStopTokens);
        this.f12759c = new WorkTimer(workManagerImplF.f12654b.f12479f);
        Processor processor = workManagerImplF.f12658f;
        this.f12760d = processor;
        WorkManagerTaskExecutor workManagerTaskExecutor = workManagerImplF.f12656d;
        this.f12758b = workManagerTaskExecutor;
        this.f12766j = new WorkLauncherImpl(processor, workManagerTaskExecutor);
        processor.a(this);
        this.f12763g = new ArrayList();
        this.f12764h = null;
    }

    public static void b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final void a(Intent intent, int i2) {
        Logger loggerE = Logger.e();
        String str = f12756k;
        loggerE.a(str, "Adding command " + intent + " (" + i2 + ")");
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.e().h(str, "Unknown command. Ignoring");
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            b();
            synchronized (this.f12763g) {
                try {
                    Iterator it = this.f12763g.iterator();
                    while (it.hasNext()) {
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) it.next()).getAction())) {
                            return;
                        }
                    }
                } finally {
                }
            }
        }
        intent.putExtra("KEY_START_ID", i2);
        synchronized (this.f12763g) {
            try {
                boolean zIsEmpty = this.f12763g.isEmpty();
                this.f12763g.add(intent);
                if (zIsEmpty) {
                    d();
                }
            } finally {
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void c(WorkGenerationalId workGenerationalId, boolean z) {
        Executor executor = this.f12758b.f13064d;
        String str = CommandHandler.f12726f;
        Intent intent = new Intent(this.f12757a, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        CommandHandler.d(intent, workGenerationalId);
        executor.execute(new AddRunnable(0, intent, this));
    }

    public final void d() {
        b();
        PowerManager.WakeLock wakeLockB = WakeLocks.b(this.f12757a, "ProcessCommand");
        try {
            wakeLockB.acquire();
            this.f12761e.f12656d.c(new Runnable() { // from class: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (SystemAlarmDispatcher.this.f12763g) {
                        SystemAlarmDispatcher systemAlarmDispatcher = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher.f12764h = (Intent) systemAlarmDispatcher.f12763g.get(0);
                    }
                    Intent intent = SystemAlarmDispatcher.this.f12764h;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.f12764h.getIntExtra("KEY_START_ID", 0);
                        Logger loggerE = Logger.e();
                        String str = SystemAlarmDispatcher.f12756k;
                        loggerE.a(str, "Processing command " + SystemAlarmDispatcher.this.f12764h + ", " + intExtra);
                        PowerManager.WakeLock wakeLockB2 = WakeLocks.b(SystemAlarmDispatcher.this.f12757a, action + " (" + intExtra + ")");
                        try {
                            Logger.e().a(str, "Acquiring operation wake lock (" + action + ") " + wakeLockB2);
                            wakeLockB2.acquire();
                            SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher2.f12762f.a(intExtra, systemAlarmDispatcher2.f12764h, systemAlarmDispatcher2);
                            Logger.e().a(str, "Releasing operation wake lock (" + action + ") " + wakeLockB2);
                            wakeLockB2.release();
                            SystemAlarmDispatcher systemAlarmDispatcher3 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher3.f12758b.f13064d.execute(new DequeueAndCheckForCompletion(systemAlarmDispatcher3));
                        } catch (Throwable th) {
                            try {
                                Logger loggerE2 = Logger.e();
                                String str2 = SystemAlarmDispatcher.f12756k;
                                loggerE2.d(str2, "Unexpected error in onHandleIntent", th);
                                Logger.e().a(str2, "Releasing operation wake lock (" + action + ") " + wakeLockB2);
                                wakeLockB2.release();
                                SystemAlarmDispatcher systemAlarmDispatcher4 = SystemAlarmDispatcher.this;
                                systemAlarmDispatcher4.f12758b.f13064d.execute(new DequeueAndCheckForCompletion(systemAlarmDispatcher4));
                            } catch (Throwable th2) {
                                Logger.e().a(SystemAlarmDispatcher.f12756k, "Releasing operation wake lock (" + action + ") " + wakeLockB2);
                                wakeLockB2.release();
                                SystemAlarmDispatcher systemAlarmDispatcher5 = SystemAlarmDispatcher.this;
                                systemAlarmDispatcher5.f12758b.f13064d.execute(new DequeueAndCheckForCompletion(systemAlarmDispatcher5));
                                throw th2;
                            }
                        }
                    }
                }
            });
        } finally {
            wakeLockB.release();
        }
    }
}
