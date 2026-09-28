package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T>, CoroutineStackFrame {

    /* renamed from: a, reason: collision with root package name */
    public final FlowCollector f55044a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f55045b;

    /* renamed from: c, reason: collision with root package name */
    public final int f55046c;

    /* renamed from: d, reason: collision with root package name */
    public CoroutineContext f55047d;

    /* renamed from: e, reason: collision with root package name */
    public Continuation f55048e;

    public SafeCollector(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        super(NoOpContinuation.f55039a, EmptyCoroutineContext.f53685a);
        this.f55044a = flowCollector;
        this.f55045b = coroutineContext;
        this.f55046c = ((Number) coroutineContext.fold(0, new kotlin.coroutines.a(4))).intValue();
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object a(Object obj, Continuation frame) {
        try {
            Object objH = h(frame, obj);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            if (objH == coroutineSingletons) {
                Intrinsics.checkNotNullParameter(frame, "frame");
            }
            return objH == coroutineSingletons ? objH : Unit.f53572a;
        } catch (Throwable th) {
            this.f55047d = new DownstreamExceptionContext(frame.getContext(), th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f55048e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.f55047d;
        return coroutineContext == null ? EmptyCoroutineContext.f53685a : coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object h(Continuation continuation, Object obj) {
        CoroutineContext context = continuation.getContext();
        JobKt.d(context);
        CoroutineContext coroutineContext = this.f55047d;
        if (coroutineContext != context) {
            if (coroutineContext instanceof DownstreamExceptionContext) {
                throw new IllegalStateException(StringsKt.e0("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((DownstreamExceptionContext) coroutineContext).f55033b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) context.fold(0, new Function2() { // from class: kotlinx.coroutines.flow.internal.a
                /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
                @Override // kotlin.jvm.functions.Function2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invoke(java.lang.Object r4, java.lang.Object r5) {
                    /*
                        r3 = this;
                        java.lang.Integer r4 = (java.lang.Integer) r4
                        int r4 = r4.intValue()
                        kotlin.coroutines.CoroutineContext$Element r5 = (kotlin.coroutines.CoroutineContext.Element) r5
                        kotlin.coroutines.CoroutineContext$Key r0 = r5.getKey()
                        kotlinx.coroutines.flow.internal.SafeCollector r1 = r3.f55061a
                        kotlin.coroutines.CoroutineContext r1 = r1.f55045b
                        kotlin.coroutines.CoroutineContext$Element r1 = r1.get(r0)
                        kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key.f54121a
                        if (r0 == r2) goto L20
                        if (r5 == r1) goto L1d
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        goto L34
                    L1d:
                        int r4 = r4 + 1
                        goto L34
                    L20:
                        kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
                        kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
                    L24:
                        r0 = 0
                        if (r5 != 0) goto L29
                        r5 = r0
                        goto L30
                    L29:
                        if (r5 != r1) goto L2c
                        goto L30
                    L2c:
                        boolean r2 = r5 instanceof kotlinx.coroutines.internal.ScopeCoroutine
                        if (r2 != 0) goto L5e
                    L30:
                        if (r5 != r1) goto L39
                        if (r1 != 0) goto L1d
                    L34:
                        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                        return r4
                    L39:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        java.lang.String r2 = "Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of "
                        r0.<init>(r2)
                        r0.append(r5)
                        java.lang.String r5 = ", expected child of "
                        r0.append(r5)
                        r0.append(r1)
                        java.lang.String r5 = ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'"
                        r0.append(r5)
                        java.lang.String r5 = r0.toString()
                        java.lang.String r5 = r5.toString()
                        r4.<init>(r5)
                        throw r4
                    L5e:
                        kotlinx.coroutines.internal.ScopeCoroutine r5 = (kotlinx.coroutines.internal.ScopeCoroutine) r5
                        java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = kotlinx.coroutines.JobSupport.f54126b
                        java.lang.Object r5 = r2.get(r5)
                        kotlinx.coroutines.ChildHandle r5 = (kotlinx.coroutines.ChildHandle) r5
                        if (r5 == 0) goto L6f
                        kotlinx.coroutines.Job r5 = r5.getParent()
                        goto L24
                    L6f:
                        r5 = r0
                        goto L24
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
                }
            })).intValue() != this.f55046c) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f55045b + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.f55047d = context;
        }
        this.f55048e = continuation;
        Function3 function3 = SafeCollectorKt.f55049a;
        FlowCollector flowCollector = this.f55044a;
        Intrinsics.d(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        ((SafeCollectorKt$emitFun$1) function3).getClass();
        Object objA = flowCollector.a(obj, this);
        if (!Intrinsics.b(objA, CoroutineSingletons.f53689a)) {
            this.f55048e = null;
        }
        return objA;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable thA = Result.a(obj);
        if (thA != null) {
            this.f55047d = new DownstreamExceptionContext(getContext(), thA);
        }
        Continuation continuation = this.f55048e;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return CoroutineSingletons.f53689a;
    }
}
