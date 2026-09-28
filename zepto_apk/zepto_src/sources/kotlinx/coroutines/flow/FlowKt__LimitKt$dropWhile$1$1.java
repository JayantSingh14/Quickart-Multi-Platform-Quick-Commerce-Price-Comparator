package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: classes3.dex */
final class FlowKt__LimitKt$dropWhile$1$1<T> implements FlowCollector {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f54700a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f54701b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f54702c;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef booleanRef, FlowCollector flowCollector, Function2 function2) {
        this.f54700a = booleanRef;
        this.f54701b = flowCollector;
        this.f54702c = (SuspendLambda) function2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        if (r6.f54701b.a(r7, r0) == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        if (r2.f54701b.a(r7, r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v4, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) r0
            int r1 = r0.f54707e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54707e = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f54705c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54707e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L43
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.b(r8)
            goto L86
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.f54704b
            java.lang.Object r2 = r0.f54703a
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1) r2
            kotlin.ResultKt.b(r8)
            goto L6a
        L3f:
            kotlin.ResultKt.b(r8)
            goto L57
        L43:
            kotlin.ResultKt.b(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f54700a
            boolean r8 = r8.f53798a
            if (r8 == 0) goto L5a
            r0.f54707e = r5
            kotlinx.coroutines.flow.FlowCollector r8 = r6.f54701b
            java.lang.Object r7 = r8.a(r7, r0)
            if (r7 != r1) goto L57
            goto L85
        L57:
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L5a:
            r0.f54703a = r6
            r0.f54704b = r7
            r0.f54707e = r4
            kotlin.coroutines.jvm.internal.SuspendLambda r8 = r6.f54702c
            java.lang.Object r8 = r8.invoke(r7, r0)
            if (r8 != r1) goto L69
            goto L85
        L69:
            r2 = r6
        L6a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L89
            kotlin.jvm.internal.Ref$BooleanRef r8 = r2.f54700a
            r8.f53798a = r5
            r8 = 0
            r0.f54703a = r8
            r0.f54704b = r8
            r0.f54707e = r3
            kotlinx.coroutines.flow.FlowCollector r8 = r2.f54701b
            java.lang.Object r7 = r8.a(r7, r0)
            if (r7 != r1) goto L86
        L85:
            return r1
        L86:
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L89:
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
