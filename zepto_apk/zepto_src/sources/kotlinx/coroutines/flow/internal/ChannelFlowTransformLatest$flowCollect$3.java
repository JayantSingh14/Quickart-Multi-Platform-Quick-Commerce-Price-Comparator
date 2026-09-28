package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {23}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f54966a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54967b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ChannelFlowTransformLatest f54968c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f54969d;

    @Metadata
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
    final class AnonymousClass1<T> implements FlowCollector {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f54970a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f54971b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChannelFlowTransformLatest f54972c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f54973d;

        @Metadata
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", l = {30}, m = "invokeSuspend")
        /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
        final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f54974a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ChannelFlowTransformLatest f54975b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f54976c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Object f54977d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector, Object obj, Continuation continuation) {
                super(2, continuation);
                this.f54975b = channelFlowTransformLatest;
                this.f54976c = flowCollector;
                this.f54977d = obj;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass2(this.f54975b, this.f54976c, this.f54977d, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
            }

            /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
                int i2 = this.f54974a;
                if (i2 == 0) {
                    ResultKt.b(obj);
                    ?? r4 = this.f54975b.f54965e;
                    this.f54974a = 1;
                    if (r4.invoke(this.f54976c, this.f54977d, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f53572a;
            }
        }

        public AnonymousClass1(Ref.ObjectRef objectRef, CoroutineScope coroutineScope, ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector) {
            this.f54970a = objectRef;
            this.f54971b = coroutineScope;
            this.f54972c = channelFlowTransformLatest;
            this.f54973d = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                if (r0 == 0) goto L13
                r0 = r8
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
                int r1 = r0.f54983f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f54983f = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f54981d
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r2 = r0.f54983f
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r7 = r0.f54979b
                java.lang.Object r0 = r0.f54978a
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1) r0
                kotlin.ResultKt.b(r8)
                goto L58
            L2d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L35:
                kotlin.ResultKt.b(r8)
                kotlin.jvm.internal.Ref$ObjectRef r8 = r6.f54970a
                java.lang.Object r8 = r8.f53801a
                kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
                if (r8 == 0) goto L57
                kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                r2.<init>()
                r8.e(r2)
                r0.f54978a = r6
                r0.f54979b = r7
                r0.f54980c = r8
                r0.f54983f = r3
                java.lang.Object r8 = r8.T0(r0)
                if (r8 != r1) goto L57
                return r1
            L57:
                r0 = r6
            L58:
                kotlin.jvm.internal.Ref$ObjectRef r8 = r0.f54970a
                kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.f54078a
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r1 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
                kotlinx.coroutines.flow.FlowCollector r2 = r0.f54973d
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest r4 = r0.f54972c
                r5 = 0
                r1.<init>(r4, r2, r7, r5)
                kotlinx.coroutines.CoroutineScope r7 = r0.f54971b
                kotlinx.coroutines.Job r7 = kotlinx.coroutines.BuildersKt.c(r7, r5, r1, r3)
                r8.f53801a = r7
                kotlin.Unit r7 = kotlin.Unit.f53572a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f54968c = channelFlowTransformLatest;
        this.f54969d = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.f54968c, this.f54969d, continuation);
        channelFlowTransformLatest$flowCollect$3.f54967b = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f54966a;
        if (i2 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f54967b;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ChannelFlowTransformLatest channelFlowTransformLatest = this.f54968c;
            Flow flow = channelFlowTransformLatest.f54961d;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef, coroutineScope, channelFlowTransformLatest, this.f54969d);
            this.f54966a = 1;
            if (flow.c(anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
