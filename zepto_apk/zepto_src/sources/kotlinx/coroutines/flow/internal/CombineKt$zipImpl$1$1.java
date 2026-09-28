package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", l = {WKSRecord.Service.NTP}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public JobImpl f55007a;

    /* renamed from: b, reason: collision with root package name */
    public int f55008b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f55009c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f55010d;

    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", l = {124}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f55012a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CoroutineContext f55013b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f55014c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ReceiveChannel f55015d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f55016e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ JobImpl f55017f;

        @Metadata
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        final class AnonymousClass1<T> implements FlowCollector {

            @Metadata
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", l = {126, WKSRecord.Service.PWDGEN, WKSRecord.Service.PWDGEN}, m = "invokeSuspend")
            @SourceDebugExtension
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            final class C00641 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public FlowCollector f55018a;

                /* renamed from: b, reason: collision with root package name */
                public int f55019b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ ReceiveChannel f55020c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ FlowCollector f55021d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ Object f55022e;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ JobImpl f55023f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00641(ReceiveChannel receiveChannel, FlowCollector flowCollector, Object obj, JobImpl jobImpl, Continuation continuation) {
                    super(2, continuation);
                    this.f55020c = receiveChannel;
                    this.f55021d = flowCollector;
                    this.f55022e = obj;
                    this.f55023f = jobImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new C00641(this.f55020c, this.f55021d, this.f55022e, this.f55023f, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ((C00641) create((Unit) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
                
                    if (r1.a(r6, r5) == r0) goto L19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
                
                    if (r6 == r0) goto L19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
                
                    return r0;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                        int r1 = r5.f55019b
                        r2 = 0
                        r3 = 2
                        r4 = 1
                        if (r1 == 0) goto L37
                        if (r1 == r4) goto L2f
                        r4 = 3
                        if (r1 == r3) goto L1c
                        if (r1 != r4) goto L14
                        kotlin.ResultKt.b(r6)
                        goto L2c
                    L14:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r0)
                        throw r6
                    L1c:
                        kotlinx.coroutines.flow.FlowCollector r1 = r5.f55018a
                        kotlin.ResultKt.b(r6)
                        r5.f55018a = r2
                        r5.f55019b = r4
                        java.lang.Object r6 = r1.a(r6, r5)
                        if (r6 != r0) goto L2c
                        goto L46
                    L2c:
                        kotlin.Unit r6 = kotlin.Unit.f53572a
                        return r6
                    L2f:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.channels.ChannelResult r6 = (kotlinx.coroutines.channels.ChannelResult) r6
                        java.lang.Object r6 = r6.f54255a
                        goto L47
                    L37:
                        kotlin.ResultKt.b(r6)
                        r5.f55019b = r4
                        kotlinx.coroutines.channels.ReceiveChannel r6 = r5.f55020c
                        kotlinx.coroutines.channels.ChannelCoroutine r6 = (kotlinx.coroutines.channels.ChannelCoroutine) r6
                        java.lang.Object r6 = r6.g(r5)
                        if (r6 != r0) goto L47
                    L46:
                        return r0
                    L47:
                        boolean r0 = r6 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
                        if (r0 == 0) goto L59
                        java.lang.Throwable r6 = kotlinx.coroutines.channels.ChannelResult.a(r6)
                        if (r6 != 0) goto L58
                        kotlinx.coroutines.flow.internal.AbortFlowException r6 = new kotlinx.coroutines.flow.internal.AbortFlowException
                        kotlinx.coroutines.JobImpl r0 = r5.f55023f
                        r6.<init>(r0)
                    L58:
                        throw r6
                    L59:
                        kotlinx.coroutines.flow.FlowCollector r6 = r5.f55021d
                        r5.f55018a = r6
                        r5.f55019b = r3
                        throw r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C00641.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r12
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1) r0
                    int r1 = r0.f55026c
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f55026c = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    r0.<init>(r10, r12)
                L18:
                    java.lang.Object r12 = r0.f55024a
                    kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                    int r2 = r0.f55026c
                    r3 = 1
                    if (r2 == 0) goto L2f
                    if (r2 != r3) goto L27
                    kotlin.ResultKt.b(r12)
                    goto L49
                L27:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L2f:
                    kotlin.ResultKt.b(r12)
                    kotlin.Unit r12 = kotlin.Unit.f53572a
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1
                    r8 = 0
                    r5 = 0
                    r6 = 0
                    r9 = 0
                    r7 = r11
                    r4.<init>(r5, r6, r7, r8, r9)
                    r0.f55026c = r3
                    r11 = 0
                    r2 = 0
                    java.lang.Object r11 = kotlinx.coroutines.flow.internal.ChannelFlowKt.a(r11, r12, r2, r4, r0)
                    if (r11 != r1) goto L49
                    return r1
                L49:
                    kotlin.Unit r11 = kotlin.Unit.f53572a
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CoroutineContext coroutineContext, Object obj, ReceiveChannel receiveChannel, FlowCollector flowCollector, JobImpl jobImpl, Continuation continuation) {
            super(2, continuation);
            this.f55013b = coroutineContext;
            this.f55014c = obj;
            this.f55015d = receiveChannel;
            this.f55016e = flowCollector;
            this.f55017f = jobImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f55013b, this.f55014c, this.f55015d, this.f55016e, this.f55017f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((Unit) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f55012a;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f55012a = 1;
                throw null;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f53572a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$zipImpl$1$1(FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f55010d = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.f55010d, continuation);
        combineKt$zipImpl$1$1.f55009c = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$zipImpl$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089 A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0015, blocks: (B:6:0x0011, B:26:0x0081, B:31:0x0089), top: B:34:0x0006 }] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r3v2 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r13.f55008b
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 != r3) goto L1c
            kotlinx.coroutines.JobImpl r1 = r13.f55007a
            java.lang.Object r0 = r13.f55009c
            r3 = r0
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            kotlin.ResultKt.b(r14)     // Catch: java.lang.Throwable -> L15 kotlinx.coroutines.flow.internal.AbortFlowException -> L19
            goto L72
        L15:
            r0 = move-exception
            r14 = r0
            goto L8a
        L19:
            r0 = move-exception
            r14 = r0
            goto L81
        L1c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L24:
            kotlin.ResultKt.b(r14)
            java.lang.Object r14 = r13.f55009c
            kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1 r1 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1
            r4 = 2
            r1.<init>(r4, r2)
            r4 = 3
            r5 = 0
            kotlinx.coroutines.channels.ReceiveChannel r9 = kotlinx.coroutines.channels.ProduceKt.c(r14, r5, r1, r4)
            kotlinx.coroutines.JobImpl r11 = kotlinx.coroutines.JobKt.a()
            r1 = r9
            kotlinx.coroutines.channels.SendChannel r1 = (kotlinx.coroutines.channels.SendChannel) r1
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1
            r4.<init>()
            r1.h(r4)
            kotlin.coroutines.CoroutineContext r7 = r14.r()     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            java.lang.Object r8 = kotlinx.coroutines.internal.ThreadContextKt.b(r7)     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            kotlin.coroutines.CoroutineContext r14 = r14.r()     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            kotlin.coroutines.CoroutineContext r14 = r14.plus(r11)     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            kotlin.Unit r1 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 r6 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            kotlinx.coroutines.flow.FlowCollector r10 = r13.f55010d     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            r12 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            r13.f55009c = r9     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            r13.f55007a = r11     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            r13.f55008b = r3     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.b(r14)     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            java.lang.Object r14 = kotlinx.coroutines.flow.internal.ChannelFlowKt.a(r14, r1, r3, r6, r13)     // Catch: java.lang.Throwable -> L7b kotlinx.coroutines.flow.internal.AbortFlowException -> L7e
            if (r14 != r0) goto L71
            return r0
        L71:
            r3 = r9
        L72:
            r3.e(r2)
            goto L86
        L76:
            r3 = r9
            goto L8a
        L78:
            r3 = r9
            r1 = r11
            goto L81
        L7b:
            r0 = move-exception
            r14 = r0
            goto L76
        L7e:
            r0 = move-exception
            r14 = r0
            goto L78
        L81:
            java.lang.Object r0 = r14.f54937a     // Catch: java.lang.Throwable -> L15
            if (r0 != r1) goto L89
            goto L72
        L86:
            kotlin.Unit r14 = kotlin.Unit.f53572a
            return r14
        L89:
            throw r14     // Catch: java.lang.Throwable -> L15
        L8a:
            r3.e(r2)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
