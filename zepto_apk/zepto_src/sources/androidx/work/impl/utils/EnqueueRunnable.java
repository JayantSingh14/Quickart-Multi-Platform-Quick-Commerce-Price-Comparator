package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.HashSet;
import java.util.Iterator;

@RestrictTo
/* loaded from: classes.dex */
public class EnqueueRunnable implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public static final String f12966c = Logger.g("EnqueueRunnable");

    /* renamed from: a, reason: collision with root package name */
    public final WorkContinuationImpl f12967a;

    /* renamed from: b, reason: collision with root package name */
    public final OperationImpl f12968b;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl, OperationImpl operationImpl) {
        this.f12967a = workContinuationImpl;
        this.f12968b = operationImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0196  */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(androidx.work.impl.WorkContinuationImpl r71) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 925
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.a(androidx.work.impl.WorkContinuationImpl):boolean");
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        OperationImpl operationImpl = this.f12968b;
        WorkContinuationImpl workContinuationImpl = this.f12967a;
        try {
            workContinuationImpl.getClass();
            WorkManagerImpl workManagerImpl = workContinuationImpl.f12633a;
            HashSet hashSet = new HashSet();
            hashSet.addAll(workContinuationImpl.f12637e);
            HashSet hashSetB = WorkContinuationImpl.b(workContinuationImpl);
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hashSet.removeAll(workContinuationImpl.f12637e);
                    z = false;
                    break;
                } else if (hashSetB.contains((String) it.next())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                throw new IllegalStateException("WorkContinuation has cycles (" + workContinuationImpl + ")");
            }
            WorkDatabase workDatabase = workManagerImpl.f12655c;
            workDatabase.c();
            try {
                EnqueueUtilsKt.a(workDatabase, workManagerImpl.f12654b, workContinuationImpl);
                boolean zA = a(workContinuationImpl);
                workDatabase.o();
                if (zA) {
                    PackageManagerHelper.a(workManagerImpl.f12653a, RescheduleReceiver.class, true);
                    Schedulers.b(workManagerImpl.f12654b, workManagerImpl.f12655c, workManagerImpl.f12657e);
                }
                operationImpl.b(Operation.f12544a);
            } finally {
                workDatabase.j();
            }
        } catch (Throwable th) {
            operationImpl.b(new Operation.State.FAILURE(th));
        }
    }
}
