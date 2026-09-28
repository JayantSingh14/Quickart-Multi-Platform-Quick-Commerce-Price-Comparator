package app.cash.sqldelight.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.AbstractFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FlowQuery$mapToOne$$inlined$map$1 implements Flow<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Flow f13108a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineDispatcher f13109b;

    @Metadata
    @SourceDebugExtension
    /* renamed from: app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1$2, reason: invalid class name */
    public final class AnonymousClass2<T> implements FlowCollector {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f13110a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CoroutineDispatcher f13111b;

        @Metadata
        @DebugMetadata(c = "app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1$2", f = "FlowExtensions.kt", l = {220, 219}, m = "emit")
        @SourceDebugExtension
        /* renamed from: app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1$2$1, reason: invalid class name */
        public final class AnonymousClass1 extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f13112a;

            /* renamed from: b, reason: collision with root package name */
            public int f13113b;

            /* renamed from: c, reason: collision with root package name */
            public FlowCollector f13114c;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f13112a = obj;
                this.f13113b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.a(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, CoroutineDispatcher coroutineDispatcher) {
            this.f13110a = flowCollector;
            this.f13111b = coroutineDispatcher;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x005a, code lost:
        
            if (r7.a(r8, r0) == r1) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r8
                app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1$2$1 r0 = (app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.f13113b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13113b = r1
                goto L18
            L13:
                app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1$2$1 r0 = new app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1$2$1
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f13112a
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r2 = r0.f13113b
                r3 = 0
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L39
                if (r2 == r5) goto L33
                if (r2 != r4) goto L2b
                kotlin.ResultKt.b(r8)
                goto L5d
            L2b:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L33:
                kotlinx.coroutines.flow.FlowCollector r7 = r0.f13114c
                kotlin.ResultKt.b(r8)
                goto L52
            L39:
                kotlin.ResultKt.b(r8)
                app.cash.sqldelight.Query r7 = (app.cash.sqldelight.Query) r7
                app.cash.sqldelight.coroutines.FlowQuery$mapToOne$1$1 r8 = new app.cash.sqldelight.coroutines.FlowQuery$mapToOne$1$1
                r8.<init>(r7, r3)
                kotlinx.coroutines.flow.FlowCollector r7 = r6.f13110a
                r0.f13114c = r7
                r0.f13113b = r5
                kotlinx.coroutines.CoroutineDispatcher r2 = r6.f13111b
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.e(r2, r8, r0)
                if (r8 != r1) goto L52
                goto L5c
            L52:
                r0.f13114c = r3
                r0.f13113b = r4
                java.lang.Object r7 = r7.a(r8, r0)
                if (r7 != r1) goto L5d
            L5c:
                return r1
            L5d:
                kotlin.Unit r7 = kotlin.Unit.f53572a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1.AnonymousClass2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public FlowQuery$mapToOne$$inlined$map$1(Flow flow, CoroutineDispatcher coroutineDispatcher) {
        this.f13108a = flow;
        this.f13109b = coroutineDispatcher;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        Object objC = ((AbstractFlow) this.f13108a).c(new AnonymousClass2(flowCollector, this.f13109b), continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }
}
