package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11855a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomTrackingLiveData f11856b;

    public /* synthetic */ a(RoomTrackingLiveData roomTrackingLiveData, int i2) {
        this.f11855a = i2;
        this.f11856b = roomTrackingLiveData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        boolean z;
        InvalidationTracker.ObserverWrapper observerWrapper;
        boolean z2;
        switch (this.f11855a) {
            case 0:
                RoomTrackingLiveData this$0 = this.f11856b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (this$0.r.compareAndSet(false, true)) {
                    InvalidationTracker invalidationTracker = this$0.f11843l.f11801e;
                    invalidationTracker.getClass();
                    RoomTrackingLiveData$observer$1 observer = this$0.o;
                    Intrinsics.checkNotNullParameter(observer, "observer");
                    InvalidationTracker.WeakObserver observer2 = new InvalidationTracker.WeakObserver(invalidationTracker, observer);
                    invalidationTracker.getClass();
                    Intrinsics.checkNotNullParameter(observer2, "observer");
                    String[] strArrC = invalidationTracker.c(observer2.a());
                    ArrayList arrayList = new ArrayList(strArrC.length);
                    for (String str : strArrC) {
                        LinkedHashMap linkedHashMap = invalidationTracker.f11766d;
                        Locale US = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(US, "US");
                        String lowerCase = str.toLowerCase(US);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                        Integer num = (Integer) linkedHashMap.get(lowerCase);
                        if (num == null) {
                            throw new IllegalArgumentException("There is no table with name ".concat(str));
                        }
                        arrayList.add(num);
                    }
                    Intrinsics.checkNotNullParameter(arrayList, "<this>");
                    int size = arrayList.size();
                    int[] iArr = new int[size];
                    Iterator it = arrayList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        iArr[i2] = ((Number) it.next()).intValue();
                        i2++;
                    }
                    InvalidationTracker.ObserverWrapper observerWrapper2 = new InvalidationTracker.ObserverWrapper(observer2, iArr, strArrC);
                    synchronized (invalidationTracker.f11773k) {
                        observerWrapper = (InvalidationTracker.ObserverWrapper) invalidationTracker.f11773k.d(observer2, observerWrapper2);
                    }
                    if (observerWrapper == null) {
                        InvalidationTracker.ObservedTableTracker observedTableTracker = invalidationTracker.f11771i;
                        int[] tableIds = Arrays.copyOf(iArr, size);
                        observedTableTracker.getClass();
                        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
                        synchronized (observedTableTracker) {
                            try {
                                z2 = false;
                                for (int i3 : tableIds) {
                                    long[] jArr = observedTableTracker.f11776a;
                                    long j2 = jArr[i3];
                                    jArr[i3] = 1 + j2;
                                    if (j2 == 0) {
                                        observedTableTracker.f11779d = true;
                                        z2 = true;
                                    }
                                }
                                Unit unit = Unit.f53572a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z2) {
                            RoomDatabase roomDatabase = invalidationTracker.f11763a;
                            if (roomDatabase.l()) {
                                invalidationTracker.e(roomDatabase.g().m1());
                            }
                        }
                    }
                }
                do {
                    AtomicBoolean atomicBoolean2 = this$0.q;
                    boolean zCompareAndSet = atomicBoolean2.compareAndSet(false, true);
                    atomicBoolean = this$0.p;
                    if (zCompareAndSet) {
                        Object objCall = null;
                        z = false;
                        while (atomicBoolean.compareAndSet(true, false)) {
                            try {
                                try {
                                    objCall = this$0.n.call();
                                    z = true;
                                } catch (Exception e2) {
                                    throw new RuntimeException("Exception while computing database live data.", e2);
                                }
                            } finally {
                                atomicBoolean2.set(false);
                            }
                        }
                        if (z) {
                            this$0.i(objCall);
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return;
                    }
                } while (atomicBoolean.get());
                return;
            default:
                RoomTrackingLiveData this$02 = this.f11856b;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                boolean z3 = this$02.f4833c > 0;
                if (this$02.p.compareAndSet(false, true) && z3) {
                    Executor executor = this$02.f11843l.f11798b;
                    if (executor != null) {
                        executor.execute(this$02.s);
                        return;
                    } else {
                        Intrinsics.h("internalQueryExecutor");
                        throw null;
                    }
                }
                return;
        }
    }
}
