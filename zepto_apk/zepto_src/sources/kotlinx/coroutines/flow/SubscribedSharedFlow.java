package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class SubscribedSharedFlow<T> implements SharedFlow<T> {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlinx.coroutines.flow.FlowCollector r4, kotlin.coroutines.Continuation r5) {
        /*
            r3 = this;
            boolean r4 = r5 instanceof kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1
            if (r4 == 0) goto L13
            r4 = r5
            kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1 r4 = (kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1) r4
            int r0 = r4.f54934c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.f54934c = r0
            goto L18
        L13:
            kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1 r4 = new kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1
            r4.<init>(r3, r5)
        L18:
            java.lang.Object r5 = r4.f54932a
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r0 = r4.f54934c
            r1 = 1
            if (r0 == 0) goto L34
            if (r0 == r1) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            kotlin.ResultKt.b(r5)
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        L34:
            kotlin.ResultKt.b(r5)
            r4.f54934c = r1
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedSharedFlow.c(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
