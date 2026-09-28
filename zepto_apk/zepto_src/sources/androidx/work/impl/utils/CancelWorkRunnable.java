package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

@RestrictTo
/* loaded from: classes.dex */
public abstract class CancelWorkRunnable implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final OperationImpl f12958a = new OperationImpl();

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$3, reason: invalid class name */
    class AnonymousClass3 extends CancelWorkRunnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WorkManagerImpl f12963b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f12964c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f12965d;

        public AnonymousClass3(WorkManagerImpl workManagerImpl, String str, boolean z) {
            this.f12963b = workManagerImpl;
            this.f12964c = str;
            this.f12965d = z;
        }

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        public final void e() {
            WorkManagerImpl workManagerImpl = this.f12963b;
            WorkDatabase workDatabase = workManagerImpl.f12655c;
            workDatabase.c();
            try {
                Iterator it = workDatabase.v().h(this.f12964c).iterator();
                while (it.hasNext()) {
                    CancelWorkRunnable.a(workManagerImpl, (String) it.next());
                }
                workDatabase.o();
                workDatabase.j();
                if (this.f12965d) {
                    Schedulers.b(workManagerImpl.f12654b, workManagerImpl.f12655c, workManagerImpl.f12657e);
                }
            } catch (Throwable th) {
                workDatabase.j();
                throw th;
            }
        }
    }

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass4 extends CancelWorkRunnable {
        @Override // androidx.work.impl.utils.CancelWorkRunnable
        public final void e() {
            throw null;
        }
    }

    public static void a(WorkManagerImpl workManagerImpl, String str) {
        WorkerWrapper workerWrapperB;
        WorkDatabase workDatabase = workManagerImpl.f12655c;
        WorkSpecDao workSpecDaoV = workDatabase.v();
        DependencyDao dependencyDaoQ = workDatabase.q();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State stateI = workSpecDaoV.i(str2);
            if (stateI != WorkInfo.State.f12568c && stateI != WorkInfo.State.f12569d) {
                workSpecDaoV.k(str2);
            }
            linkedList.addAll(dependencyDaoQ.b(str2));
        }
        Processor processor = workManagerImpl.f12658f;
        synchronized (processor.f12626k) {
            Logger.e().a(Processor.f12615l, "Processor cancelling " + str);
            processor.f12624i.add(str);
            workerWrapperB = processor.b(str);
        }
        Processor.d(str, workerWrapperB, 1);
        Iterator it = workManagerImpl.f12657e.iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).a(str);
        }
    }

    public static CancelWorkRunnable b(final WorkManagerImpl workManagerImpl, final UUID uuid) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.1
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            public final void e() {
                WorkManagerImpl workManagerImpl2 = workManagerImpl;
                WorkDatabase workDatabase = workManagerImpl2.f12655c;
                workDatabase.c();
                try {
                    CancelWorkRunnable.a(workManagerImpl2, uuid.toString());
                    workDatabase.o();
                    workDatabase.j();
                    Schedulers.b(workManagerImpl2.f12654b, workManagerImpl2.f12655c, workManagerImpl2.f12657e);
                } catch (Throwable th) {
                    workDatabase.j();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable c(WorkManagerImpl workManagerImpl) {
        return new AnonymousClass3(workManagerImpl, "AppConfigWorker", true);
    }

    public static CancelWorkRunnable d(final WorkManagerImpl workManagerImpl, final String str) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.2
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            public final void e() {
                WorkManagerImpl workManagerImpl2 = workManagerImpl;
                WorkDatabase workDatabase = workManagerImpl2.f12655c;
                workDatabase.c();
                try {
                    Iterator it = workDatabase.v().l(str).iterator();
                    while (it.hasNext()) {
                        CancelWorkRunnable.a(workManagerImpl2, (String) it.next());
                    }
                    workDatabase.o();
                    workDatabase.j();
                    Schedulers.b(workManagerImpl2.f12654b, workManagerImpl2.f12655c, workManagerImpl2.f12657e);
                } catch (Throwable th) {
                    workDatabase.j();
                    throw th;
                }
            }
        };
    }

    public abstract void e();

    @Override // java.lang.Runnable
    public final void run() {
        OperationImpl operationImpl = this.f12958a;
        try {
            e();
            operationImpl.b(Operation.f12544a);
        } catch (Throwable th) {
            operationImpl.b(new Operation.State.FAILURE(th));
        }
    }
}
