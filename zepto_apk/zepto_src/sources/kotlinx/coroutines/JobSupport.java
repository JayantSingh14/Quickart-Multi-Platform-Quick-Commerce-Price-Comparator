package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectInstance;

@Deprecated
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class JobSupport implements Job, ChildJob, ParentJob {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54125a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54126b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    @Metadata
    @SourceDebugExtension
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {

        /* renamed from: i, reason: collision with root package name */
        public final JobSupport f54127i;

        public AwaitContinuation(Continuation continuation, JobSupport jobSupport) {
            super(1, continuation);
            this.f54127i = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final Throwable p(JobSupport jobSupport) {
            Throwable thD;
            JobSupport jobSupport2 = this.f54127i;
            jobSupport2.getClass();
            Object obj = JobSupport.f54125a.get(jobSupport2);
            return (!(obj instanceof Finishing) || (thD = ((Finishing) obj).d()) == null) ? obj instanceof CompletedExceptionally ? ((CompletedExceptionally) obj).f54073a : jobSupport.O() : thD;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final String y() {
            return "AwaitContinuation";
        }
    }

    @Metadata
    public static final class ChildCompletion extends JobNode {

        /* renamed from: e, reason: collision with root package name */
        public final JobSupport f54128e;

        /* renamed from: f, reason: collision with root package name */
        public final Finishing f54129f;

        /* renamed from: g, reason: collision with root package name */
        public final ChildHandleNode f54130g;

        /* renamed from: h, reason: collision with root package name */
        public final Object f54131h;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.f54128e = jobSupport;
            this.f54129f = finishing;
            this.f54130g = childHandleNode;
            this.f54131h = obj;
        }

        @Override // kotlinx.coroutines.JobNode
        public final boolean l() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public final void m(Throwable th) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport.f54125a;
            JobSupport jobSupport = this.f54128e;
            jobSupport.getClass();
            ChildHandleNode childHandleNode = this.f54130g;
            ChildHandleNode childHandleNodeC0 = JobSupport.c0(childHandleNode);
            Finishing finishing = this.f54129f;
            Object obj = this.f54131h;
            if (childHandleNodeC0 == null || !jobSupport.q0(finishing, childHandleNodeC0, obj)) {
                finishing.f54135a.e(2);
                ChildHandleNode childHandleNodeC02 = JobSupport.c0(childHandleNode);
                if (childHandleNodeC02 == null || !jobSupport.q0(finishing, childHandleNodeC02, obj)) {
                    jobSupport.t(jobSupport.G(finishing, obj));
                }
            }
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Finishing implements Incomplete {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f54132b = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting$volatile");

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f54133c = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause$volatile");

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f54134d = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder$volatile");
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile = 0;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* renamed from: a, reason: collision with root package name */
        public final NodeList f54135a;

        public Finishing(NodeList nodeList, Throwable th) {
            this.f54135a = nodeList;
            this._rootCause$volatile = th;
        }

        @Override // kotlinx.coroutines.Incomplete
        public final boolean a() {
            return d() == null;
        }

        public final void b(Throwable th) {
            Throwable thD = d();
            if (thD == null) {
                f54133c.set(this, th);
                return;
            }
            if (th == thD) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54134d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th);
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                    return;
                } else {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
            }
            if (th == obj) {
                return;
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(th);
            atomicReferenceFieldUpdater.set(this, arrayList);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final NodeList c() {
            return this.f54135a;
        }

        public final Throwable d() {
            return (Throwable) f54133c.get(this);
        }

        public final boolean e() {
            return d() != null;
        }

        public final ArrayList f(Throwable th) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54134d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayList = (ArrayList) obj;
            }
            Throwable thD = d();
            if (thD != null) {
                arrayList.add(0, thD);
            }
            if (th != null && !th.equals(thD)) {
                arrayList.add(th);
            }
            atomicReferenceFieldUpdater.set(this, JobSupportKt.f54150e);
            return arrayList;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Finishing[cancelling=");
            sb.append(e());
            sb.append(", completing=");
            sb.append(f54132b.get(this) != 0);
            sb.append(", rootCause=");
            sb.append(d());
            sb.append(", exceptions=");
            sb.append(f54134d.get(this));
            sb.append(", list=");
            sb.append(this.f54135a);
            sb.append(']');
            return sb.toString();
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public final class SelectOnAwaitCompletionHandler extends JobNode {

        /* renamed from: e, reason: collision with root package name */
        public final SelectInstance f54136e;

        public SelectOnAwaitCompletionHandler(SelectInstance selectInstance) {
            this.f54136e = selectInstance;
        }

        @Override // kotlinx.coroutines.JobNode
        public final boolean l() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public final void m(Throwable th) {
            JobSupport jobSupport = JobSupport.this;
            jobSupport.getClass();
            Object objA = JobSupport.f54125a.get(jobSupport);
            if (!(objA instanceof CompletedExceptionally)) {
                objA = JobSupportKt.a(objA);
            }
            this.f54136e.e(jobSupport, objA);
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public final class SelectOnJoinCompletionHandler extends JobNode {

        /* renamed from: e, reason: collision with root package name */
        public final SelectInstance f54138e;

        public SelectOnJoinCompletionHandler(SelectInstance selectInstance) {
            this.f54138e = selectInstance;
        }

        @Override // kotlinx.coroutines.JobNode
        public final boolean l() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public final void m(Throwable th) {
            this.f54138e.e(JobSupport.this, Unit.f53572a);
        }
    }

    public JobSupport(boolean z) {
        this._state$volatile = z ? JobSupportKt.f54152g : JobSupportKt.f54151f;
    }

    public static ChildHandleNode c0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.i()) {
            LockFreeLinkedListNode lockFreeLinkedListNodeF = lockFreeLinkedListNode.f();
            if (lockFreeLinkedListNodeF == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode.f55088b;
                Object obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                while (true) {
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    if (!lockFreeLinkedListNode.i()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                }
            } else {
                lockFreeLinkedListNode = lockFreeLinkedListNodeF;
            }
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.h();
            if (!lockFreeLinkedListNode.i()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public static String m0(Object obj) {
        if (!(obj instanceof Finishing)) {
            return obj instanceof Incomplete ? ((Incomplete) obj).a() ? "Active" : "New" : obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        Finishing finishing = (Finishing) obj;
        return finishing.e() ? "Cancelling" : Finishing.f54132b.get(finishing) != 0 ? "Completing" : "Active";
    }

    public static CancellationException o0(JobSupport jobSupport, Throwable th) {
        jobSupport.getClass();
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new JobCancellationException(jobSupport.B(), th, jobSupport) : cancellationException;
    }

    public String B() {
        return "Job was cancelled";
    }

    public boolean C(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return w(th) && K();
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle D(boolean z, boolean z2, Function1 function1) {
        return U(z2, z ? new InvokeOnCancelling(function1) : new InvokeOnCompletion(function1));
    }

    public final void E(Incomplete incomplete, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54126b;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        if (childHandle != null) {
            childHandle.dispose();
            atomicReferenceFieldUpdater.set(this, NonDisposableHandle.f54155a);
        }
        CompletionHandlerException completionHandlerException = null;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.f54073a : null;
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).m(th);
                return;
            } catch (Throwable th2) {
                R(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
                return;
            }
        }
        NodeList nodeListC = incomplete.c();
        if (nodeListC != null) {
            nodeListC.e(1);
            Object obj2 = LockFreeLinkedListNode.f55087a.get(nodeListC);
            Intrinsics.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (LockFreeLinkedListNode lockFreeLinkedListNodeH = (LockFreeLinkedListNode) obj2; !lockFreeLinkedListNodeH.equals(nodeListC); lockFreeLinkedListNodeH = lockFreeLinkedListNodeH.h()) {
                if (lockFreeLinkedListNodeH instanceof JobNode) {
                    try {
                        ((JobNode) lockFreeLinkedListNodeH).m(th);
                    } catch (Throwable th3) {
                        if (completionHandlerException != null) {
                            kotlin.ExceptionsKt.a(completionHandlerException, th3);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNodeH + " for " + this, th3);
                            Unit unit = Unit.f53572a;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                R(completionHandlerException);
            }
        }
    }

    public final Throwable F(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(B(), null, this) : th;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) obj).v0();
    }

    public final Object G(Finishing finishing, Object obj) {
        boolean zE;
        Throwable thJ;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.f54073a : null;
        synchronized (finishing) {
            zE = finishing.e();
            ArrayList<Throwable> arrayListF = finishing.f(th);
            thJ = J(finishing, arrayListF);
            if (thJ != null && arrayListF.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                for (Throwable th2 : arrayListF) {
                    if (th2 != thJ && th2 != thJ && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        kotlin.ExceptionsKt.a(thJ, th2);
                    }
                }
            }
        }
        if (thJ != null && thJ != th) {
            obj = new CompletedExceptionally(false, thJ);
        }
        if (thJ != null && (z(thJ) || Q(thJ))) {
            Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            CompletedExceptionally.f54072b.compareAndSet((CompletedExceptionally) obj, 0, 1);
        }
        if (!zE) {
            e0(thJ);
        }
        f0(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54125a;
        Object incompleteStateBox = obj instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, finishing, incompleteStateBox) && atomicReferenceFieldUpdater.get(this) == finishing) {
        }
        E(finishing, obj);
        return obj;
    }

    public final Sequence H() {
        return SequencesKt.o(new JobSupport$children$1(null, this));
    }

    public final Throwable I() {
        Object obj = f54125a.get(this);
        if (obj instanceof Finishing) {
            Throwable thD = ((Finishing) obj).d();
            if (thD != null) {
                return thD;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (obj instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (obj instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) obj).f54073a;
        }
        return null;
    }

    public final Throwable J(Finishing finishing, ArrayList arrayList) {
        Object next;
        Object obj = null;
        if (arrayList.isEmpty()) {
            if (finishing.e()) {
                return new JobCancellationException(B(), null, this);
            }
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean K() {
        return true;
    }

    public boolean L() {
        return this instanceof CompletableDeferredImpl;
    }

    public final SelectClause0Impl M() {
        JobSupport$onJoin$1 jobSupport$onJoin$1 = JobSupport$onJoin$1.f54145b;
        TypeIntrinsics.b(3, jobSupport$onJoin$1);
        return new SelectClause0Impl(this, jobSupport$onJoin$1);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException O() {
        Object obj = f54125a.get(this);
        if (!(obj instanceof Finishing)) {
            if (!(obj instanceof Incomplete)) {
                return obj instanceof CompletedExceptionally ? o0(this, ((CompletedExceptionally) obj).f54073a) : new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        Throwable thD = ((Finishing) obj).d();
        if (thD == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        CancellationException jobCancellationException = thD instanceof CancellationException ? (CancellationException) thD : null;
        if (jobCancellationException == null) {
            if (strConcat == null) {
                strConcat = B();
            }
            jobCancellationException = new JobCancellationException(strConcat, thD, this);
        }
        return jobCancellationException;
    }

    public final NodeList P(Incomplete incomplete) {
        NodeList nodeListC = incomplete.c();
        if (nodeListC != null) {
            return nodeListC;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            h0((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    public boolean Q(Throwable th) {
        return false;
    }

    public final void S(Job job) {
        NonDisposableHandle nonDisposableHandle = NonDisposableHandle.f54155a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54126b;
        if (job == null) {
            atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
            return;
        }
        job.start();
        ChildHandle childHandleT = job.T(this);
        atomicReferenceFieldUpdater.set(this, childHandleT);
        if (W()) {
            childHandleT.dispose();
            atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlinx.coroutines.InactiveNodeList] */
    @Override // kotlinx.coroutines.Job
    public final ChildHandle T(JobSupport jobSupport) {
        ChildHandleNode childHandleNode = new ChildHandleNode(jobSupport);
        childHandleNode.f54124d = this;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54125a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof Empty) {
                Empty empty = (Empty) obj;
                if (empty.f54096a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, childHandleNode)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                NodeList nodeList = new NodeList();
                if (!empty.f54096a) {
                    nodeList = new InactiveNodeList(nodeList);
                }
                com.google.android.gms.internal.pal.a.j(atomicReferenceFieldUpdater, this, empty, nodeList);
            } else {
                boolean z = obj instanceof Incomplete;
                NonDisposableHandle nonDisposableHandle = NonDisposableHandle.f54155a;
                if (!z) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    CompletedExceptionally completedExceptionally = obj2 instanceof CompletedExceptionally ? (CompletedExceptionally) obj2 : null;
                    childHandleNode.m(completedExceptionally != null ? completedExceptionally.f54073a : null);
                    return nonDisposableHandle;
                }
                NodeList nodeListC = ((Incomplete) obj).c();
                if (nodeListC == null) {
                    Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    h0((JobNode) obj);
                } else if (!nodeListC.d(childHandleNode, 7)) {
                    boolean zD = nodeListC.d(childHandleNode, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof Finishing) {
                        thD = ((Finishing) obj3).d();
                    } else {
                        CompletedExceptionally completedExceptionally2 = obj3 instanceof CompletedExceptionally ? (CompletedExceptionally) obj3 : null;
                        if (completedExceptionally2 != null) {
                            thD = completedExceptionally2.f54073a;
                        }
                    }
                    childHandleNode.m(thD);
                    if (zD) {
                        break loop0;
                    }
                    return nonDisposableHandle;
                }
            }
        }
        return childHandleNode;
    }

    @Override // kotlinx.coroutines.Job
    public final Object T0(Continuation frame) throws Throwable {
        Object obj;
        do {
            obj = f54125a.get(this);
            if (!(obj instanceof Incomplete)) {
                JobKt.d(frame.getContext());
                return Unit.f53572a;
            }
        } while (i0(obj) < 0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        CancellableContinuationKt.a(cancellableContinuationImpl, JobKt.f(this, new ResumeOnCompletion(cancellableContinuationImpl)));
        Object objR = cancellableContinuationImpl.r();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (objR == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        if (objR != coroutineSingletons) {
            objR = Unit.f53572a;
        }
        return objR == coroutineSingletons ? objR : Unit.f53572a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlinx.coroutines.InactiveNodeList] */
    public final DisposableHandle U(boolean z, JobNode jobNode) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        NonDisposableHandle nonDisposableHandle;
        boolean z2;
        boolean zD;
        jobNode.f54124d = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f54125a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z3 = obj instanceof Empty;
            nonDisposableHandle = NonDisposableHandle.f54155a;
            z2 = true;
            if (!z3) {
                if (!(obj instanceof Incomplete)) {
                    z2 = false;
                    break;
                }
                Incomplete incomplete = (Incomplete) obj;
                NodeList nodeListC = incomplete.c();
                if (nodeListC == null) {
                    Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    h0((JobNode) obj);
                } else {
                    if (jobNode.l()) {
                        Finishing finishing = incomplete instanceof Finishing ? (Finishing) incomplete : null;
                        Throwable thD = finishing != null ? finishing.d() : null;
                        if (thD == null) {
                            zD = nodeListC.d(jobNode, 5);
                        } else if (z) {
                            jobNode.m(thD);
                            return nonDisposableHandle;
                        }
                    } else {
                        zD = nodeListC.d(jobNode, 1);
                    }
                    if (zD) {
                        break;
                    }
                }
            } else {
                Empty empty = (Empty) obj;
                if (empty.f54096a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, jobNode)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                NodeList nodeList = new NodeList();
                if (!empty.f54096a) {
                    nodeList = new InactiveNodeList(nodeList);
                }
                com.google.android.gms.internal.pal.a.j(atomicReferenceFieldUpdater, this, empty, nodeList);
            }
        }
        if (z2) {
            return jobNode;
        }
        if (z) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            CompletedExceptionally completedExceptionally = obj2 instanceof CompletedExceptionally ? (CompletedExceptionally) obj2 : null;
            jobNode.m(completedExceptionally != null ? completedExceptionally.f54073a : null);
        }
        return nonDisposableHandle;
    }

    public final boolean W() {
        return !(f54125a.get(this) instanceof Incomplete);
    }

    public boolean X() {
        return this instanceof BlockingCoroutine;
    }

    public final boolean Y(Object obj) {
        Object objP0;
        do {
            objP0 = p0(f54125a.get(this), obj);
            if (objP0 == JobSupportKt.f54146a) {
                return false;
            }
            if (objP0 == JobSupportKt.f54147b) {
                return true;
            }
        } while (objP0 == JobSupportKt.f54148c);
        t(objP0);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public boolean a() {
        Object obj = f54125a.get(this);
        return (obj instanceof Incomplete) && ((Incomplete) obj).a();
    }

    public final Object a0(Object obj) {
        Object objP0;
        do {
            objP0 = p0(f54125a.get(this), obj);
            if (objP0 == JobSupportKt.f54146a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
                throw new IllegalStateException(str, completedExceptionally != null ? completedExceptionally.f54073a : null);
            }
        } while (objP0 == JobSupportKt.f54148c);
        return objP0;
    }

    public String b0() {
        return getClass().getSimpleName();
    }

    public final void d0(NodeList nodeList, Throwable th) {
        e0(th);
        nodeList.e(4);
        Object obj = LockFreeLinkedListNode.f55087a.get(nodeList);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeH = (LockFreeLinkedListNode) obj; !lockFreeLinkedListNodeH.equals(nodeList); lockFreeLinkedListNodeH = lockFreeLinkedListNodeH.h()) {
            if ((lockFreeLinkedListNodeH instanceof JobNode) && ((JobNode) lockFreeLinkedListNodeH).l()) {
                try {
                    ((JobNode) lockFreeLinkedListNodeH).m(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNodeH + " for " + this, th2);
                        Unit unit = Unit.f53572a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            R(completionHandlerException);
        }
        z(th);
    }

    @Override // kotlinx.coroutines.Job
    public void e(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(B(), null, this);
        }
        y(cancellationException);
    }

    public void e0(Throwable th) {
    }

    public void f0(Object obj) {
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(obj, this);
    }

    public void g0() {
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.a(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key.f54121a;
    }

    public final void h0(JobNode jobNode) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        NodeList nodeList = new NodeList();
        jobNode.getClass();
        LockFreeLinkedListNode.f55088b.set(nodeList, jobNode);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = LockFreeLinkedListNode.f55087a;
        atomicReferenceFieldUpdater2.set(nodeList, jobNode);
        loop0: while (true) {
            if (atomicReferenceFieldUpdater2.get(jobNode) == jobNode) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(jobNode, jobNode, nodeList)) {
                    if (atomicReferenceFieldUpdater2.get(jobNode) != jobNode) {
                        break;
                    }
                }
                nodeList.g(jobNode);
                break loop0;
            }
            break;
        }
        LockFreeLinkedListNode lockFreeLinkedListNodeH = jobNode.h();
        do {
            atomicReferenceFieldUpdater = f54125a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, jobNode, lockFreeLinkedListNodeH)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == jobNode);
    }

    public final int i0(Object obj) {
        boolean z = obj instanceof Empty;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54125a;
        if (z) {
            if (((Empty) obj).f54096a) {
                return 0;
            }
            Empty empty = JobSupportKt.f54152g;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, empty)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            g0();
            return 1;
        }
        if (!(obj instanceof InactiveNodeList)) {
            return 0;
        }
        NodeList nodeList = ((InactiveNodeList) obj).f54114a;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nodeList)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        g0();
        return 1;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object obj = f54125a.get(this);
        if (obj instanceof CompletedExceptionally) {
            return true;
        }
        return (obj instanceof Finishing) && ((Finishing) obj).e();
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle j0(Function1 function1) {
        return U(true, new InvokeOnCompletion(function1));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.b(this, key);
    }

    public final Object p0(Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (!(obj instanceof Incomplete)) {
            return JobSupportKt.f54146a;
        }
        if (((obj instanceof Empty) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) {
            Incomplete incomplete = (Incomplete) obj;
            Object incompleteStateBox = obj2 instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = f54125a;
                if (atomicReferenceFieldUpdater.compareAndSet(this, incomplete, incompleteStateBox)) {
                    e0(null);
                    f0(obj2);
                    E(incomplete, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == incomplete);
            return JobSupportKt.f54148c;
        }
        Incomplete incomplete2 = (Incomplete) obj;
        NodeList nodeListP = P(incomplete2);
        if (nodeListP == null) {
            return JobSupportKt.f54148c;
        }
        Finishing finishing = incomplete2 instanceof Finishing ? (Finishing) incomplete2 : null;
        if (finishing == null) {
            finishing = new Finishing(nodeListP, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (finishing) {
            try {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Finishing.f54132b;
                if (atomicIntegerFieldUpdater.get(finishing) != 0) {
                    return JobSupportKt.f54146a;
                }
                atomicIntegerFieldUpdater.set(finishing, 1);
                if (finishing != incomplete2) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f54125a;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, incomplete2, finishing)) {
                        if (atomicReferenceFieldUpdater2.get(this) != incomplete2) {
                            return JobSupportKt.f54148c;
                        }
                    }
                }
                boolean zE = finishing.e();
                CompletedExceptionally completedExceptionally = obj2 instanceof CompletedExceptionally ? (CompletedExceptionally) obj2 : null;
                if (completedExceptionally != null) {
                    finishing.b(completedExceptionally.f54073a);
                }
                Throwable thD = zE ? null : finishing.d();
                objectRef.f53801a = thD;
                Unit unit = Unit.f53572a;
                if (thD != null) {
                    d0(nodeListP, thD);
                }
                ChildHandleNode childHandleNodeC0 = c0(nodeListP);
                if (childHandleNodeC0 != null && q0(finishing, childHandleNodeC0, obj2)) {
                    return JobSupportKt.f54147b;
                }
                nodeListP.e(2);
                ChildHandleNode childHandleNodeC02 = c0(nodeListP);
                return (childHandleNodeC02 == null || !q0(finishing, childHandleNodeC02, obj2)) ? G(finishing, obj2) : JobSupportKt.f54147b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.c(this, coroutineContext);
    }

    public final boolean q0(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        do {
            ChildCompletion childCompletion = new ChildCompletion(this, finishing, childHandleNode, obj);
            JobSupport jobSupport = childHandleNode.f54066e;
            if ((jobSupport != null ? jobSupport.U(false, childCompletion) : jobSupport.D(false, false, new JobKt__JobKt$invokeOnCompletion$1(childCompletion))) != NonDisposableHandle.f54155a) {
                return true;
            }
            childHandleNode = c0(childHandleNode);
        } while (childHandleNode != null);
        return false;
    }

    public boolean r0(Object obj) {
        return Y(obj);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int iI0;
        do {
            iI0 = i0(f54125a.get(this));
            if (iI0 == 0) {
                return false;
            }
        } while (iI0 != 1);
        return true;
    }

    public void t(Object obj) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(b0() + '{' + m0(f54125a.get(this)) + '}');
        sb.append('@');
        sb.append(DebugStringsKt.a(this));
        return sb.toString();
    }

    public void u(Object obj) {
        t(obj);
    }

    public final Object v(ContinuationImpl frame) throws Throwable {
        Object obj;
        do {
            obj = f54125a.get(this);
            if (!(obj instanceof Incomplete)) {
                if (obj instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) obj).f54073a;
                }
                return JobSupportKt.a(obj);
            }
        } while (i0(obj) < 0);
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.b(frame), this);
        awaitContinuation.s();
        CancellableContinuationKt.a(awaitContinuation, JobKt.f(this, new ResumeAwaitOnCompletion(awaitContinuation)));
        Object objR = awaitContinuation.r();
        if (objR == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.ParentJob
    public final CancellationException v0() {
        CancellationException cancellationExceptionD;
        Object obj = f54125a.get(this);
        if (obj instanceof Finishing) {
            cancellationExceptionD = ((Finishing) obj).d();
        } else if (obj instanceof CompletedExceptionally) {
            cancellationExceptionD = ((CompletedExceptionally) obj).f54073a;
        } else {
            if (obj instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj).toString());
            }
            cancellationExceptionD = null;
        }
        CancellationException cancellationException = cancellationExceptionD instanceof CancellationException ? cancellationExceptionD : null;
        return cancellationException == null ? new JobCancellationException("Parent job is ".concat(m0(obj)), cancellationExceptionD, this) : cancellationException;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041 A[PHI: r0
      0x0041: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v13 java.lang.Object) binds: [B:3:0x0008, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean w(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.w(java.lang.Object):boolean");
    }

    public Object x() throws Throwable {
        Object obj = f54125a.get(this);
        if (obj instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (obj instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) obj).f54073a;
        }
        return JobSupportKt.a(obj);
    }

    public void y(CancellationException cancellationException) {
        w(cancellationException);
    }

    public final boolean z(Throwable th) {
        if (!X()) {
            boolean z = th instanceof CancellationException;
            ChildHandle childHandle = (ChildHandle) f54126b.get(this);
            return (childHandle == null || childHandle == NonDisposableHandle.f54155a) ? z : childHandle.b(th) || z;
        }
        return true;
    }

    public void R(CompletionHandlerException completionHandlerException) {
        throw completionHandlerException;
    }
}
