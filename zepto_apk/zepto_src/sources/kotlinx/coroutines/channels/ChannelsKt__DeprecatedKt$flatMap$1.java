package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", l = {351, 352, 352}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public ChannelIterator f54328a;

    /* renamed from: b, reason: collision with root package name */
    public int f54329b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54330c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        if (r8 == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r7.f54329b
            r2 = 0
            if (r1 == 0) goto L67
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L48
            r5 = 3
            if (r1 == r3) goto L22
            if (r1 != r5) goto L1a
            kotlinx.coroutines.channels.ChannelIterator r1 = r7.f54328a
            java.lang.Object r5 = r7.f54330c
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r8)
            goto L3b
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L22:
            kotlinx.coroutines.channels.ChannelIterator r1 = r7.f54328a
            java.lang.Object r6 = r7.f54330c
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            r7.f54330c = r6
            r7.f54328a = r1
            r7.f54329b = r5
            java.lang.Object r8 = kotlinx.coroutines.channels.ChannelsKt.b(r8, r6, r7)
            if (r8 != r0) goto L3a
            goto L47
        L3a:
            r5 = r6
        L3b:
            r7.f54330c = r5
            r7.f54328a = r1
            r7.f54329b = r4
            java.lang.Object r8 = r1.b(r7)
            if (r8 != r0) goto L52
        L47:
            return r0
        L48:
            kotlinx.coroutines.channels.ChannelIterator r1 = r7.f54328a
            java.lang.Object r0 = r7.f54330c
            r5 = r0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r8)
        L52:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L5d
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        L5d:
            r1.next()
            r7.f54330c = r5
            r7.f54328a = r1
            r7.f54329b = r3
            throw r2
        L67:
            kotlin.ResultKt.b(r8)
            java.lang.Object r8 = r7.f54330c
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
