package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.SystemClock;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@RestrictTo
/* loaded from: classes3.dex */
public class WorkerWrapper implements Runnable {
    public static final String s = Logger.g("WorkerWrapper");

    /* renamed from: a, reason: collision with root package name */
    public final Context f12665a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12666b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkerParameters.RuntimeExtras f12667c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkSpec f12668d;

    /* renamed from: e, reason: collision with root package name */
    public ListenableWorker f12669e;

    /* renamed from: f, reason: collision with root package name */
    public final WorkManagerTaskExecutor f12670f;

    /* renamed from: h, reason: collision with root package name */
    public final Configuration f12672h;

    /* renamed from: i, reason: collision with root package name */
    public final SystemClock f12673i;

    /* renamed from: j, reason: collision with root package name */
    public final Processor f12674j;

    /* renamed from: k, reason: collision with root package name */
    public final WorkDatabase f12675k;

    /* renamed from: l, reason: collision with root package name */
    public final WorkSpecDao f12676l;

    /* renamed from: m, reason: collision with root package name */
    public final DependencyDao f12677m;
    public final ArrayList n;
    public String o;

    /* renamed from: g, reason: collision with root package name */
    public ListenableWorker.Result f12671g = new ListenableWorker.Result.Failure();
    public final SettableFuture p = new SettableFuture();
    public final SettableFuture q = new SettableFuture();
    public volatile int r = -256;

    @RestrictTo
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f12682a;

        /* renamed from: b, reason: collision with root package name */
        public final Processor f12683b;

        /* renamed from: c, reason: collision with root package name */
        public final WorkManagerTaskExecutor f12684c;

        /* renamed from: d, reason: collision with root package name */
        public final Configuration f12685d;

        /* renamed from: e, reason: collision with root package name */
        public final WorkDatabase f12686e;

        /* renamed from: f, reason: collision with root package name */
        public final WorkSpec f12687f;

        /* renamed from: g, reason: collision with root package name */
        public final ArrayList f12688g;

        /* renamed from: h, reason: collision with root package name */
        public WorkerParameters.RuntimeExtras f12689h = new WorkerParameters.RuntimeExtras();

        public Builder(Context context, Configuration configuration, WorkManagerTaskExecutor workManagerTaskExecutor, Processor processor, WorkDatabase workDatabase, WorkSpec workSpec, ArrayList arrayList) {
            this.f12682a = context.getApplicationContext();
            this.f12684c = workManagerTaskExecutor;
            this.f12683b = processor;
            this.f12685d = configuration;
            this.f12686e = workDatabase;
            this.f12687f = workSpec;
            this.f12688g = arrayList;
        }

        public final WorkerWrapper a() {
            return new WorkerWrapper(this);
        }

        public final void b(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.f12689h = runtimeExtras;
            }
        }
    }

    public WorkerWrapper(Builder builder) {
        this.f12665a = builder.f12682a;
        this.f12670f = builder.f12684c;
        this.f12674j = builder.f12683b;
        WorkSpec workSpec = builder.f12687f;
        this.f12668d = workSpec;
        this.f12666b = workSpec.f12905a;
        this.f12667c = builder.f12689h;
        this.f12669e = null;
        Configuration configuration = builder.f12685d;
        this.f12672h = configuration;
        this.f12673i = configuration.f12476c;
        WorkDatabase workDatabase = builder.f12686e;
        this.f12675k = workDatabase;
        this.f12676l = workDatabase.v();
        this.f12677m = workDatabase.q();
        this.n = builder.f12688g;
    }

    public final SettableFuture a() {
        return this.p;
    }

    public final WorkGenerationalId b() {
        return WorkSpecKt.a(this.f12668d);
    }

    public final void c(ListenableWorker.Result result) {
        boolean z = result instanceof ListenableWorker.Result.Success;
        WorkSpec workSpec = this.f12668d;
        String str = s;
        if (!z) {
            if (result instanceof ListenableWorker.Result.Retry) {
                Logger.e().f(str, "Worker result RETRY for " + this.o);
                f();
                return;
            }
            Logger.e().f(str, "Worker result FAILURE for " + this.o);
            if (workSpec.c()) {
                g();
                return;
            } else {
                j();
                return;
            }
        }
        Logger.e().f(str, "Worker result SUCCESS for " + this.o);
        if (workSpec.c()) {
            g();
            return;
        }
        DependencyDao dependencyDao = this.f12677m;
        String str2 = this.f12666b;
        WorkSpecDao workSpecDao = this.f12676l;
        WorkDatabase workDatabase = this.f12675k;
        workDatabase.c();
        try {
            workSpecDao.r(WorkInfo.State.f12568c, str2);
            workSpecDao.t(str2, ((ListenableWorker.Result.Success) this.f12671g).f12532a);
            this.f12673i.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it = dependencyDao.b(str2).iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                if (workSpecDao.i(str3) == WorkInfo.State.f12570e && dependencyDao.c(str3)) {
                    Logger.e().f(str, "Setting status to enqueued for " + str3);
                    workSpecDao.r(WorkInfo.State.f12566a, str3);
                    workSpecDao.s(jCurrentTimeMillis, str3);
                }
            }
            workDatabase.o();
            workDatabase.j();
            h(false);
        } catch (Throwable th) {
            workDatabase.j();
            h(false);
            throw th;
        }
    }

    public final void d(int i2) {
        this.r = i2;
        k();
        this.q.cancel(true);
        if (this.f12669e != null && this.q.isCancelled()) {
            this.f12669e.stop(i2);
            return;
        }
        Logger.e().a(s, "WorkSpec " + this.f12668d + " is already done. Not interrupting.");
    }

    public final void e() {
        if (k()) {
            return;
        }
        this.f12675k.c();
        try {
            WorkInfo.State stateI = this.f12676l.i(this.f12666b);
            this.f12675k.u().a(this.f12666b);
            if (stateI == null) {
                h(false);
            } else if (stateI == WorkInfo.State.f12567b) {
                c(this.f12671g);
            } else if (!stateI.a()) {
                this.r = -512;
                f();
            }
            this.f12675k.o();
            this.f12675k.j();
        } catch (Throwable th) {
            this.f12675k.j();
            throw th;
        }
    }

    public final void f() {
        String str = this.f12666b;
        WorkSpecDao workSpecDao = this.f12676l;
        WorkDatabase workDatabase = this.f12675k;
        workDatabase.c();
        try {
            workSpecDao.r(WorkInfo.State.f12566a, str);
            this.f12673i.getClass();
            workSpecDao.s(System.currentTimeMillis(), str);
            workSpecDao.f(this.f12668d.v, str);
            workSpecDao.c(-1L, str);
            workDatabase.o();
        } finally {
            workDatabase.j();
            h(true);
        }
    }

    public final void g() {
        String str = this.f12666b;
        WorkSpecDao workSpecDao = this.f12676l;
        WorkDatabase workDatabase = this.f12675k;
        workDatabase.c();
        try {
            this.f12673i.getClass();
            workSpecDao.s(System.currentTimeMillis(), str);
            workSpecDao.r(WorkInfo.State.f12566a, str);
            workSpecDao.y(str);
            workSpecDao.f(this.f12668d.v, str);
            workSpecDao.b(str);
            workSpecDao.c(-1L, str);
            workDatabase.o();
        } finally {
            workDatabase.j();
            h(false);
        }
    }

    public final void h(boolean z) {
        this.f12675k.c();
        try {
            if (!this.f12675k.v().w()) {
                PackageManagerHelper.a(this.f12665a, RescheduleReceiver.class, false);
            }
            if (z) {
                this.f12676l.r(WorkInfo.State.f12566a, this.f12666b);
                this.f12676l.v(this.r, this.f12666b);
                this.f12676l.c(-1L, this.f12666b);
            }
            this.f12675k.o();
            this.f12675k.j();
            this.p.i(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.f12675k.j();
            throw th;
        }
    }

    public final void i() {
        WorkSpecDao workSpecDao = this.f12676l;
        String str = this.f12666b;
        WorkInfo.State stateI = workSpecDao.i(str);
        WorkInfo.State state = WorkInfo.State.f12567b;
        String str2 = s;
        if (stateI == state) {
            Logger.e().a(str2, "Status for " + str + " is RUNNING; not doing any work and rescheduling for later execution");
            h(true);
            return;
        }
        Logger.e().a(str2, "Status for " + str + " is " + stateI + " ; not doing any work");
        h(false);
    }

    public final void j() {
        String str = this.f12666b;
        WorkDatabase workDatabase = this.f12675k;
        workDatabase.c();
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            while (true) {
                boolean zIsEmpty = linkedList.isEmpty();
                WorkSpecDao workSpecDao = this.f12676l;
                if (zIsEmpty) {
                    Data data = ((ListenableWorker.Result.Failure) this.f12671g).f12531a;
                    workSpecDao.f(this.f12668d.v, str);
                    workSpecDao.t(str, data);
                    workDatabase.o();
                    return;
                }
                String str2 = (String) linkedList.remove();
                if (workSpecDao.i(str2) != WorkInfo.State.f12571f) {
                    workSpecDao.r(WorkInfo.State.f12569d, str2);
                }
                linkedList.addAll(this.f12677m.b(str2));
            }
        } finally {
            workDatabase.j();
            h(false);
        }
    }

    public final boolean k() {
        if (this.r == -256) {
            return false;
        }
        Logger.e().a(s, "Work interrupted for " + this.o);
        if (this.f12676l.i(this.f12666b) == null) {
            h(false);
            return true;
        }
        h(!r0.a());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0092 A[Catch: all -> 0x007c, TryCatch #1 {all -> 0x007c, blocks: (B:14:0x0050, B:17:0x005a, B:22:0x007f, B:24:0x0085, B:26:0x0089, B:36:0x00c5, B:31:0x0092, B:33:0x00a3), top: B:83:0x0050 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.run():void");
    }
}
