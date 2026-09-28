package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", l = {29, 29}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class FlowKt__ZipKt$combine$1$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f54866a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ FlowCollector f54867b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f54868c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function3 f54869d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$1$1(Function3 function3, Continuation continuation) {
        super(3, continuation);
        this.f54869d = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.f54869d, (Continuation) obj3);
        flowKt__ZipKt$combine$1$1.f54867b = (FlowCollector) obj;
        flowKt__ZipKt$combine$1$1.f54868c = (Object[]) obj2;
        return flowKt__ZipKt$combine$1$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r1.a(r6, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r5.f54866a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.b(r6)
            goto L43
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L18:
            kotlinx.coroutines.flow.FlowCollector r1 = r5.f54867b
            kotlin.ResultKt.b(r6)
            goto L37
        L1e:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.flow.FlowCollector r1 = r5.f54867b
            java.lang.Object[] r6 = r5.f54868c
            r4 = 0
            r4 = r6[r4]
            r6 = r6[r3]
            r5.f54867b = r1
            r5.f54866a = r3
            kotlin.jvm.functions.Function3 r3 = r5.f54869d
            java.lang.Object r6 = r3.invoke(r4, r6, r5)
            if (r6 != r0) goto L37
            goto L42
        L37:
            r3 = 0
            r5.f54867b = r3
            r5.f54866a = r2
            java.lang.Object r6 = r1.a(r6, r5)
            if (r6 != r0) goto L43
        L42:
            return r0
        L43:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
