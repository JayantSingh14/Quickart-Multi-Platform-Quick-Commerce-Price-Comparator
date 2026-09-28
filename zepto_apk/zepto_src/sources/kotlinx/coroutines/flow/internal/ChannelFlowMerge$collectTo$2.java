package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreAndMutexImpl;

@Metadata
/* loaded from: classes3.dex */
final class ChannelFlowMerge$collectTo$2<T> implements FlowCollector {

    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", l = {65}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f54952a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Flow f54953b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SendingCollector f54954c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Semaphore f54955d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Flow flow, SendingCollector sendingCollector, Semaphore semaphore, Continuation continuation) {
            super(2, continuation);
            this.f54953b = flow;
            this.f54954c = sendingCollector;
            this.f54955d = semaphore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f54953b, this.f54954c, this.f54955d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [kotlinx.coroutines.sync.Semaphore] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v3, types: [kotlinx.coroutines.sync.SemaphoreAndMutexImpl] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f54952a;
            ?? r2 = this.f54955d;
            try {
                if (i2 == 0) {
                    ResultKt.b(obj);
                    Flow flow = this.f54953b;
                    SendingCollector sendingCollector = this.f54954c;
                    this.f54952a = 1;
                    if (flow.c(sendingCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                r2 = (SemaphoreAndMutexImpl) r2;
                r2.release();
                return Unit.f53572a;
            } catch (Throwable th) {
                ((SemaphoreAndMutexImpl) r2).release();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlinx.coroutines.flow.Flow r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1) r0
            int r1 = r0.f54960e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54960e = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f54958c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r0.f54960e
            r2 = 1
            if (r1 == 0) goto L47
            if (r1 != r2) goto L3f
            kotlinx.coroutines.flow.Flow r5 = r0.f54957b
            java.lang.Object r0 = r0.f54956a
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2) r0
            kotlin.ResultKt.b(r6)
            r6 = 0
            r0.getClass()
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1
            r1 = 0
            r2 = 0
            r3 = 0
            r0.<init>(r5, r2, r1, r3)
            r5 = 3
            kotlinx.coroutines.BuildersKt.c(r6, r3, r0, r5)
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L3f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L47:
            kotlin.ResultKt.b(r6)
            r0.f54956a = r4
            r0.f54957b = r5
            r0.f54960e = r2
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2.a(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
