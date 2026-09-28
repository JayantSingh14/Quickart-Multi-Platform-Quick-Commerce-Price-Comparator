package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.media3.common.util.e;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@RestrictTo
/* loaded from: classes.dex */
public class Processor implements ForegroundProcessor {

    /* renamed from: l, reason: collision with root package name */
    public static final String f12615l = Logger.g("Processor");

    /* renamed from: b, reason: collision with root package name */
    public final Context f12617b;

    /* renamed from: c, reason: collision with root package name */
    public final Configuration f12618c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkManagerTaskExecutor f12619d;

    /* renamed from: e, reason: collision with root package name */
    public final WorkDatabase f12620e;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f12622g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f12621f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f12624i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f12625j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f12616a = null;

    /* renamed from: k, reason: collision with root package name */
    public final Object f12626k = new Object();

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f12623h = new HashMap();

    public Processor(Context context, Configuration configuration, WorkManagerTaskExecutor workManagerTaskExecutor, WorkDatabase workDatabase) {
        this.f12617b = context;
        this.f12618c = configuration;
        this.f12619d = workManagerTaskExecutor;
        this.f12620e = workDatabase;
    }

    public static boolean d(String str, WorkerWrapper workerWrapper, int i2) {
        String str2 = f12615l;
        if (workerWrapper == null) {
            Logger.e().a(str2, "WorkerWrapper could not be found for " + str);
            return false;
        }
        workerWrapper.d(i2);
        Logger.e().a(str2, "WorkerWrapper interrupted for " + str);
        return true;
    }

    public final void a(ExecutionListener executionListener) {
        synchronized (this.f12626k) {
            this.f12625j.add(executionListener);
        }
    }

    public final WorkerWrapper b(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.f12621f.remove(str);
        boolean z = workerWrapper != null;
        if (!z) {
            workerWrapper = (WorkerWrapper) this.f12622g.remove(str);
        }
        this.f12623h.remove(str);
        if (z) {
            synchronized (this.f12626k) {
                try {
                    if (this.f12621f.isEmpty()) {
                        try {
                            this.f12617b.startService(SystemForegroundDispatcher.d(this.f12617b));
                        } catch (Throwable th) {
                            Logger.e().d(f12615l, "Unable to stop foreground service", th);
                        }
                        PowerManager.WakeLock wakeLock = this.f12616a;
                        if (wakeLock != null) {
                            wakeLock.release();
                            this.f12616a = null;
                        }
                    }
                } finally {
                }
            }
        }
        return workerWrapper;
    }

    public final WorkerWrapper c(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.f12621f.get(str);
        return workerWrapper == null ? (WorkerWrapper) this.f12622g.get(str) : workerWrapper;
    }

    public final boolean e(String str) {
        boolean z;
        synchronized (this.f12626k) {
            z = c(str) != null;
        }
        return z;
    }

    public final void f(ExecutionListener executionListener) {
        synchronized (this.f12626k) {
            this.f12625j.remove(executionListener);
        }
    }

    public final void g(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.f12626k) {
            try {
                Logger.e().f(f12615l, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper workerWrapper = (WorkerWrapper) this.f12622g.remove(str);
                if (workerWrapper != null) {
                    if (this.f12616a == null) {
                        PowerManager.WakeLock wakeLockB = WakeLocks.b(this.f12617b, "ProcessorForegroundLck");
                        this.f12616a = wakeLockB;
                        wakeLockB.acquire();
                    }
                    this.f12621f.put(str, workerWrapper);
                    ContextCompat.f(this.f12617b, SystemForegroundDispatcher.b(this.f12617b, workerWrapper.b(), foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean h(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) throws Throwable {
        Throwable th;
        WorkGenerationalId workGenerationalIdA = startStopToken.a();
        String str = workGenerationalIdA.f12893a;
        ArrayList arrayList = new ArrayList();
        WorkSpec workSpec = (WorkSpec) this.f12620e.n(new a(this, arrayList, str, 0));
        if (workSpec == null) {
            Logger.e().h(f12615l, "Didn't find WorkSpec for id " + workGenerationalIdA);
            this.f12619d.f13064d.execute(new androidx.constraintlayout.motion.widget.a(10, this, workGenerationalIdA));
            return false;
        }
        synchronized (this.f12626k) {
            try {
                try {
                    try {
                        if (e(str)) {
                            Set set = (Set) this.f12623h.get(str);
                            if (((StartStopToken) set.iterator().next()).a().f12894b == workGenerationalIdA.f12894b) {
                                set.add(startStopToken);
                                Logger.e().a(f12615l, "Work " + workGenerationalIdA + " is already enqueued for processing");
                            } else {
                                this.f12619d.f13064d.execute(new androidx.constraintlayout.motion.widget.a(10, this, workGenerationalIdA));
                            }
                            return false;
                        }
                        if (workSpec.t != workGenerationalIdA.f12894b) {
                            this.f12619d.f13064d.execute(new androidx.constraintlayout.motion.widget.a(10, this, workGenerationalIdA));
                            return false;
                        }
                        WorkerWrapper.Builder builder = new WorkerWrapper.Builder(this.f12617b, this.f12618c, this.f12619d, this, this.f12620e, workSpec, arrayList);
                        builder.b(runtimeExtras);
                        WorkerWrapper workerWrapperA = builder.a();
                        SettableFuture settableFutureA = workerWrapperA.a();
                        settableFutureA.q(new e(this, settableFutureA, workerWrapperA, 6), this.f12619d.f13064d);
                        this.f12622g.put(str, workerWrapperA);
                        HashSet hashSet = new HashSet();
                        hashSet.add(startStopToken);
                        this.f12623h.put(str, hashSet);
                        this.f12619d.f13061a.execute(workerWrapperA);
                        Logger.e().a(f12615l, getClass().getSimpleName() + ": processing " + workGenerationalIdA);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }
}
