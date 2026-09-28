package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {51, WKSRecord.Service.NETRJS_3, 76}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Channel f54987a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f54988b;

    /* renamed from: c, reason: collision with root package name */
    public int f54989c;

    /* renamed from: d, reason: collision with root package name */
    public int f54990d;

    /* renamed from: e, reason: collision with root package name */
    public int f54991e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f54992f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Flow[] f54993g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function0 f54994h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f54995i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f54996j;

    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {28}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f54997a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Flow[] f54998b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f54999c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f55000d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BufferedChannel f55001e;

        @Metadata
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        final class C00631<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BufferedChannel f55002a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f55003b;

            public C00631(BufferedChannel bufferedChannel, int i2) {
                this.f55002a = bufferedChannel;
                this.f55003b = i2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
            
                if (kotlinx.coroutines.YieldKt.a(r0) == r1) goto L21;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
                    int r1 = r0.f55006c
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f55006c = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    r0.<init>(r5, r7)
                L18:
                    java.lang.Object r7 = r0.f55004a
                    kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                    int r2 = r0.f55006c
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L36
                    if (r2 == r4) goto L32
                    if (r2 != r3) goto L2a
                    kotlin.ResultKt.b(r7)
                    goto L54
                L2a:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L32:
                    kotlin.ResultKt.b(r7)
                    goto L4b
                L36:
                    kotlin.ResultKt.b(r7)
                    kotlin.collections.IndexedValue r7 = new kotlin.collections.IndexedValue
                    int r2 = r5.f55003b
                    r7.<init>(r2, r6)
                    r0.f55006c = r4
                    kotlinx.coroutines.channels.BufferedChannel r6 = r5.f55002a
                    java.lang.Object r6 = r6.o(r7, r0)
                    if (r6 != r1) goto L4b
                    goto L53
                L4b:
                    r0.f55006c = r3
                    java.lang.Object r6 = kotlinx.coroutines.YieldKt.a(r0)
                    if (r6 != r1) goto L54
                L53:
                    return r1
                L54:
                    kotlin.Unit r6 = kotlin.Unit.f53572a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1.C00631.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Flow[] flowArr, int i2, AtomicInteger atomicInteger, BufferedChannel bufferedChannel, Continuation continuation) {
            super(2, continuation);
            this.f54998b = flowArr;
            this.f54999c = i2;
            this.f55000d = atomicInteger;
            this.f55001e = bufferedChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f54998b, this.f54999c, this.f55000d, this.f55001e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f54997a;
            AtomicInteger atomicInteger = this.f55000d;
            BufferedChannel bufferedChannel = this.f55001e;
            try {
                if (i2 == 0) {
                    ResultKt.b(obj);
                    Flow[] flowArr = this.f54998b;
                    int i3 = this.f54999c;
                    Flow flow = flowArr[i3];
                    C00631 c00631 = new C00631(bufferedChannel, i3);
                    this.f54997a = 1;
                    if (flow.c(c00631, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    bufferedChannel.d(null);
                }
                return Unit.f53572a;
            } finally {
                if (atomicInteger.decrementAndGet() == 0) {
                    bufferedChannel.d(null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(Continuation continuation, Function0 function0, Function3 function3, FlowCollector flowCollector, Flow[] flowArr) {
        super(2, continuation);
        this.f54993g = flowArr;
        this.f54994h = function0;
        this.f54995i = (SuspendLambda) function3;
        this.f54996j = flowCollector;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ?? r3 = this.f54995i;
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(continuation, this.f54994h, r3, this.f54996j, this.f54993g);
        combineKt$combineInternal$2.f54992f = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineInternal$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
    
        if (r8 != 0) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:34:0x00c4, B:32:0x00b5], limit reached: 44 */
    /* JADX WARN: Path cross not found for [B:35:0x00c6, B:20:0x0085], limit reached: 44 */
    /* JADX WARN: Path cross not found for [B:37:0x00d4, B:40:0x00e7], limit reached: 44 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a5 A[LOOP:0: B:27:0x00a5->B:45:?, LOOP_START, PHI: r8 r12
      0x00a5: PHI (r8v3 int) = (r8v2 int), (r8v4 int) binds: [B:24:0x00a0, B:45:?] A[DONT_GENERATE, DONT_INLINE]
      0x00a5: PHI (r12v4 kotlin.collections.IndexedValue) = (r12v3 kotlin.collections.IndexedValue), (r12v10 kotlin.collections.IndexedValue) binds: [B:24:0x00a0, B:45:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r13v2, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e4 -> B:20:0x0085). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00fc -> B:20:0x0085). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
