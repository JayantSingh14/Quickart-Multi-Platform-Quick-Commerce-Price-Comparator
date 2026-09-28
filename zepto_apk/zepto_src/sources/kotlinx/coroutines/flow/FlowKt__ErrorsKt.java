package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final /* synthetic */ class FlowKt__ErrorsKt {
    public static final FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 a(Flow flow, Function3 function3) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(flow, function3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable b(kotlin.coroutines.jvm.internal.ContinuationImpl r5, kotlinx.coroutines.flow.Flow r6, kotlinx.coroutines.flow.FlowCollector r7) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) r0
            int r1 = r0.f54660c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54660c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f54659b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54660c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.jvm.internal.Ref$ObjectRef r6 = r0.f54658a
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L29
            goto L4b
        L29:
            r5 = move-exception
            goto L51
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2     // Catch: java.lang.Throwable -> L4d
            r2.<init>(r7, r5)     // Catch: java.lang.Throwable -> L4d
            r0.f54658a = r5     // Catch: java.lang.Throwable -> L4d
            r0.f54660c = r3     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r5 = r6.c(r2, r0)     // Catch: java.lang.Throwable -> L4d
            if (r5 != r1) goto L4b
            return r1
        L4b:
            r5 = 0
            return r5
        L4d:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L51:
            java.lang.Object r6 = r6.f53801a
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            if (r6 == 0) goto L5d
            boolean r7 = r6.equals(r5)
            if (r7 != 0) goto L7f
        L5d:
            kotlin.coroutines.CoroutineContext r7 = r0.getContext()
            kotlinx.coroutines.Job$Key r0 = kotlinx.coroutines.Job.Key.f54121a
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r0)
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
            if (r7 == 0) goto L80
            boolean r0 = r7.isCancelled()
            if (r0 != 0) goto L72
            goto L80
        L72:
            java.util.concurrent.CancellationException r7 = r7.O()
            if (r7 == 0) goto L80
            boolean r7 = r7.equals(r5)
            if (r7 != 0) goto L7f
            goto L80
        L7f:
            throw r5
        L80:
            if (r6 != 0) goto L83
            return r5
        L83:
            boolean r7 = r5 instanceof java.util.concurrent.CancellationException
            if (r7 == 0) goto L8b
            kotlin.ExceptionsKt.a(r6, r5)
            throw r6
        L8b:
            kotlin.ExceptionsKt.a(r5, r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.b(kotlin.coroutines.jvm.internal.ContinuationImpl, kotlinx.coroutines.flow.Flow, kotlinx.coroutines.flow.FlowCollector):java.io.Serializable");
    }
}
