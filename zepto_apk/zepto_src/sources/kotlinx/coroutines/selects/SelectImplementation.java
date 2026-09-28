package kotlinx.coroutines.selects;

import android.support.v4.media.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes.dex */
public class SelectImplementation<R> implements CancelHandler, SelectBuilder<R>, SelectInstanceInternal<R> {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55183f = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f55184a;

    /* renamed from: c, reason: collision with root package name */
    public Object f55186c;
    private volatile /* synthetic */ Object state$volatile = SelectKt.f55206b;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f55185b = new ArrayList(2);

    /* renamed from: d, reason: collision with root package name */
    public int f55187d = -1;

    /* renamed from: e, reason: collision with root package name */
    public Object f55188e = SelectKt.f55209e;

    @Metadata
    @SourceDebugExtension
    public final class ClauseData {

        /* renamed from: a, reason: collision with root package name */
        public final Object f55189a;

        /* renamed from: b, reason: collision with root package name */
        public final Function3 f55190b;

        /* renamed from: c, reason: collision with root package name */
        public final Function3 f55191c;

        /* renamed from: d, reason: collision with root package name */
        public final Symbol f55192d;

        /* renamed from: e, reason: collision with root package name */
        public final Function f55193e;

        /* renamed from: f, reason: collision with root package name */
        public final Function3 f55194f;

        /* renamed from: g, reason: collision with root package name */
        public Object f55195g;

        /* renamed from: h, reason: collision with root package name */
        public int f55196h = -1;

        public ClauseData(Object obj, Function3 function3, Function3 function32, Symbol symbol, Function function, Function3 function33) {
            this.f55189a = obj;
            this.f55190b = function3;
            this.f55191c = function32;
            this.f55192d = symbol;
            this.f55193e = function;
            this.f55194f = function33;
        }

        public final void a() {
            Object obj = this.f55195g;
            if (obj instanceof Segment) {
                ((Segment) obj).h(this.f55196h, SelectImplementation.this.f55184a);
                return;
            }
            DisposableHandle disposableHandle = obj instanceof DisposableHandle ? (DisposableHandle) obj : null;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        this.f55184a = coroutineContext;
    }

    @Override // kotlinx.coroutines.Waiter
    public final void a(Segment segment, int i2) {
        this.f55186c = segment;
        this.f55187d = i2;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public final void b(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55183f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.f55207c) {
                return;
            }
            Symbol symbol = SelectKt.f55208d;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            ArrayList arrayList = this.f55185b;
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ClauseData) it.next()).a();
            }
            this.f55188e = SelectKt.f55209e;
            this.f55185b = null;
            return;
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void c(Object obj) {
        this.f55188e = obj;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void d(DisposableHandle disposableHandle) {
        this.f55186c = disposableHandle;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final boolean e(Object obj, Object obj2) {
        return n(obj, obj2) == 0;
    }

    public final Object f(ContinuationImpl continuationImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55183f;
        Object obj = atomicReferenceFieldUpdater.get(this);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        ClauseData clauseData = (ClauseData) obj;
        Object obj2 = this.f55188e;
        ArrayList arrayList = this.f55185b;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ClauseData clauseData2 = (ClauseData) it.next();
                if (clauseData2 != clauseData) {
                    clauseData2.a();
                }
            }
            atomicReferenceFieldUpdater.set(this, SelectKt.f55207c);
            this.f55188e = SelectKt.f55209e;
            this.f55185b = null;
        }
        Object objInvoke = clauseData.f55191c.invoke(clauseData.f55189a, clauseData.f55192d, obj2);
        clauseData.getClass();
        Symbol symbol = SelectKt.f55210f;
        Function function = clauseData.f55193e;
        return clauseData.f55192d == symbol ? ((Function1) function).invoke(continuationImpl) : ((Function2) function).invoke(objInvoke, continuationImpl);
    }

    public Object g(Continuation continuation) {
        return f55183f.get(this) instanceof ClauseData ? f((ContinuationImpl) continuation) : h((ContinuationImpl) continuation);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final CoroutineContext getContext() {
        return this.f55184a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(kotlin.coroutines.jvm.internal.ContinuationImpl r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.h(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final ClauseData i(Object obj) {
        ArrayList arrayList = this.f55185b;
        Object obj2 = null;
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ClauseData) next).f55189a == obj) {
                obj2 = next;
                break;
            }
        }
        ClauseData clauseData = (ClauseData) obj2;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    public void j(SelectClause0Impl selectClause0Impl, Function1 function1) {
        l(new ClauseData(selectClause0Impl.f55174a, selectClause0Impl.a(), selectClause0Impl.f55176c, SelectKt.f55210f, function1, null), false);
    }

    public void k(SelectClause1 selectClause1, Function2 function2) {
        l(new ClauseData(selectClause1.d(), selectClause1.a(), selectClause1.c(), null, function2, selectClause1.b()), false);
    }

    public final void l(ClauseData clauseData, boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55183f;
        if (atomicReferenceFieldUpdater.get(this) instanceof ClauseData) {
            return;
        }
        Object obj = clauseData.f55189a;
        if (!z) {
            ArrayList arrayList = this.f55185b;
            Intrinsics.c(arrayList);
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((ClauseData) it.next()).f55189a == obj) {
                        throw new IllegalStateException(b.j(obj, "Cannot use select clauses on the same object: ").toString());
                    }
                }
            }
        }
        clauseData.f55190b.invoke(obj, this, clauseData.f55192d);
        if (this.f55188e != SelectKt.f55209e) {
            atomicReferenceFieldUpdater.set(this, clauseData);
            return;
        }
        if (!z) {
            ArrayList arrayList2 = this.f55185b;
            Intrinsics.c(arrayList2);
            arrayList2.add(clauseData);
        }
        clauseData.f55195g = this.f55186c;
        clauseData.f55196h = this.f55187d;
        this.f55186c = null;
        this.f55187d = -1;
    }

    public final TrySelectDetailedResult m(Object obj, Unit unit) {
        int iN = n(obj, unit);
        Function3 function3 = SelectKt.f55205a;
        if (iN == 0) {
            return TrySelectDetailedResult.f55212a;
        }
        if (iN == 1) {
            return TrySelectDetailedResult.f55213b;
        }
        if (iN == 2) {
            return TrySelectDetailedResult.f55214c;
        }
        if (iN == 3) {
            return TrySelectDetailedResult.f55215d;
        }
        throw new IllegalStateException(("Unexpected internal result: " + iN).toString());
    }

    public final int n(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55183f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof CancellableContinuation)) {
                if (Intrinsics.b(obj3, SelectKt.f55207c) || (obj3 instanceof ClauseData)) {
                    return 3;
                }
                if (Intrinsics.b(obj3, SelectKt.f55208d)) {
                    return 2;
                }
                if (Intrinsics.b(obj3, SelectKt.f55206b)) {
                    List listH = CollectionsKt.H(obj);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, listH)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                            break;
                        }
                    }
                    return 1;
                }
                if (!(obj3 instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                }
                ArrayList arrayListK = CollectionsKt.K(obj, (Collection) obj3);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, arrayListK)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        break;
                    }
                }
                return 1;
            }
            ClauseData clauseDataI = i(obj);
            if (clauseDataI != null) {
                Function3 function3 = clauseDataI.f55194f;
                Function3 function32 = function3 != null ? (Function3) function3.invoke(this, clauseDataI.f55192d, obj2) : null;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, clauseDataI)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        break;
                    }
                }
                CancellableContinuation cancellableContinuation = (CancellableContinuation) obj3;
                this.f55188e = obj2;
                Function3 function33 = SelectKt.f55205a;
                Symbol symbolF = cancellableContinuation.f(Unit.f53572a, function32);
                if (symbolF == null) {
                    this.f55188e = SelectKt.f55209e;
                    return 2;
                }
                cancellableContinuation.q(symbolF);
                return 0;
            }
            continue;
        }
    }
}
