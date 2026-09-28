package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class AwaitAll<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f54038b = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final Deferred[] f54039a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    @Metadata
    @SourceDebugExtension
    public final class AwaitAllNode extends JobNode {

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f54040h = AtomicReferenceFieldUpdater.newUpdater(AwaitAllNode.class, Object.class, "_disposer$volatile");
        private volatile /* synthetic */ Object _disposer$volatile;

        /* renamed from: e, reason: collision with root package name */
        public final CancellableContinuationImpl f54041e;

        /* renamed from: f, reason: collision with root package name */
        public DisposableHandle f54042f;

        public AwaitAllNode(CancellableContinuationImpl cancellableContinuationImpl) {
            this.f54041e = cancellableContinuationImpl;
        }

        @Override // kotlinx.coroutines.JobNode
        public final boolean l() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public final void m(Throwable th) {
            CancellableContinuationImpl cancellableContinuationImpl = this.f54041e;
            if (th != null) {
                cancellableContinuationImpl.getClass();
                Symbol symbolD = cancellableContinuationImpl.D(new CompletedExceptionally(false, th), null);
                if (symbolD != null) {
                    cancellableContinuationImpl.q(symbolD);
                    DisposeHandlersOnCancel disposeHandlersOnCancel = (DisposeHandlersOnCancel) f54040h.get(this);
                    if (disposeHandlersOnCancel != null) {
                        disposeHandlersOnCancel.a();
                        return;
                    }
                    return;
                }
                return;
            }
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = AwaitAll.f54038b;
            AwaitAll awaitAll = AwaitAll.this;
            if (atomicIntegerFieldUpdater.decrementAndGet(awaitAll) == 0) {
                Deferred[] deferredArr = awaitAll.f54039a;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred deferred : deferredArr) {
                    arrayList.add(deferred.x());
                }
                Result.Companion companion = Result.f53538b;
                cancellableContinuationImpl.resumeWith(arrayList);
            }
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class DisposeHandlersOnCancel implements CancelHandler {

        /* renamed from: a, reason: collision with root package name */
        public final AwaitAllNode[] f54044a;

        public DisposeHandlersOnCancel(AwaitAllNode[] awaitAllNodeArr) {
            this.f54044a = awaitAllNodeArr;
        }

        public final void a() {
            for (AwaitAllNode awaitAllNode : this.f54044a) {
                DisposableHandle disposableHandle = awaitAllNode.f54042f;
                if (disposableHandle == null) {
                    Intrinsics.h("handle");
                    throw null;
                }
                disposableHandle.dispose();
            }
        }

        @Override // kotlinx.coroutines.CancelHandler
        public final void b(Throwable th) {
            a();
        }

        public final String toString() {
            return "DisposeHandlersOnCancel[" + this.f54044a + ']';
        }
    }

    public AwaitAll(Deferred[] deferredArr) {
        this.f54039a = deferredArr;
        this.notCompletedCount$volatile = deferredArr.length;
    }
}
