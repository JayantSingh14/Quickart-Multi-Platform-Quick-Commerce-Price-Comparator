package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", l = {215, 415}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54563a;

    /* renamed from: b, reason: collision with root package name */
    public Ref.LongRef f54564b;

    /* renamed from: c, reason: collision with root package name */
    public int f54565c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54566d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f54567e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a f54568f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Flow f54569g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1(a aVar, Flow flow, Continuation continuation) {
        super(3, continuation);
        this.f54568f = aVar;
        this.f54569g = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.f54568f, this.f54569g, (Continuation) obj3);
        flowKt__DelayKt$debounceInternal$1.f54566d = (CoroutineScope) obj;
        flowKt__DelayKt$debounceInternal$1.f54567e = (FlowCollector) obj2;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008f, code lost:
    
        if (r7.a(r8, r12) == r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d2, code lost:
    
        if (r7.g(r12) != r0) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094 A[PHI: r1 r5 r6 r7
      0x0094: PHI (r1v3 kotlin.jvm.internal.Ref$LongRef) = (r1v5 kotlin.jvm.internal.Ref$LongRef), (r1v7 kotlin.jvm.internal.Ref$LongRef), (r1v7 kotlin.jvm.internal.Ref$LongRef) binds: [B:25:0x0092, B:15:0x0062, B:18:0x007a] A[DONT_GENERATE, DONT_INLINE]
      0x0094: PHI (r5v2 kotlin.jvm.internal.Ref$ObjectRef) = 
      (r5v4 kotlin.jvm.internal.Ref$ObjectRef)
      (r5v5 kotlin.jvm.internal.Ref$ObjectRef)
      (r5v5 kotlin.jvm.internal.Ref$ObjectRef)
     binds: [B:25:0x0092, B:15:0x0062, B:18:0x007a] A[DONT_GENERATE, DONT_INLINE]
      0x0094: PHI (r6v3 kotlinx.coroutines.channels.ReceiveChannel) = 
      (r6v5 kotlinx.coroutines.channels.ReceiveChannel)
      (r6v6 kotlinx.coroutines.channels.ReceiveChannel)
      (r6v6 kotlinx.coroutines.channels.ReceiveChannel)
     binds: [B:25:0x0092, B:15:0x0062, B:18:0x007a] A[DONT_GENERATE, DONT_INLINE]
      0x0094: PHI (r7v2 kotlinx.coroutines.flow.FlowCollector) = 
      (r7v4 kotlinx.coroutines.flow.FlowCollector)
      (r7v5 kotlinx.coroutines.flow.FlowCollector)
      (r7v5 kotlinx.coroutines.flow.FlowCollector)
     binds: [B:25:0x0092, B:15:0x0062, B:18:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00d2 -> B:7:0x001a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
