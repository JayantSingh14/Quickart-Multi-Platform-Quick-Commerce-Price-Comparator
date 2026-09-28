package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {213, 213}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class FlowKt__MergeKt$mapLatest$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f54724a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ FlowCollector f54725b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54726c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function2 f54727d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MergeKt$mapLatest$1(Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.f54727d = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.f54727d, (Continuation) obj3);
        flowKt__MergeKt$mapLatest$1.f54725b = (FlowCollector) obj;
        flowKt__MergeKt$mapLatest$1.f54726c = obj2;
        return flowKt__MergeKt$mapLatest$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (r1.a(r5, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r4.f54724a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.b(r5)
            goto L40
        L10:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L18:
            kotlinx.coroutines.flow.FlowCollector r1 = r4.f54725b
            kotlin.ResultKt.b(r5)
            goto L34
        L1e:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.flow.FlowCollector r1 = r4.f54725b
            java.lang.Object r5 = r4.f54726c
            r4.f54725b = r1
            r4.f54724a = r3
            kotlin.jvm.functions.Function2 r3 = r4.f54727d
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r3 = (kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.AnonymousClass2) r3
            java.lang.Object r5 = r3.invoke(r5, r4)
            if (r5 != r0) goto L34
            goto L3f
        L34:
            r3 = 0
            r4.f54725b = r3
            r4.f54724a = r2
            java.lang.Object r5 = r1.a(r5, r4)
            if (r5 != r0) goto L40
        L3f:
            return r0
        L40:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
