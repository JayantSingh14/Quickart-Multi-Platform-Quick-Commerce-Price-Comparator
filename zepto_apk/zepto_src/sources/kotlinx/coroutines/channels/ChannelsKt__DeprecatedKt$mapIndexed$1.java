package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", l = {374, 375, 375}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$mapIndexed$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public ChannelIterator f54358a;

    /* renamed from: b, reason: collision with root package name */
    public ProducerScope f54359b;

    /* renamed from: c, reason: collision with root package name */
    public int f54360c;

    /* renamed from: d, reason: collision with root package name */
    public int f54361d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f54362e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        if (r10 == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r9.f54361d
            r2 = 0
            if (r1 == 0) goto L7f
            r3 = 1
            r4 = 2
            if (r1 == r3) goto L53
            r5 = 3
            if (r1 == r4) goto L24
            if (r1 != r5) goto L1c
            int r1 = r9.f54360c
            kotlinx.coroutines.channels.ChannelIterator r5 = r9.f54358a
            java.lang.Object r6 = r9.f54362e
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.b(r10)
            goto L44
        L1c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L24:
            int r1 = r9.f54360c
            kotlinx.coroutines.channels.ProducerScope r6 = r9.f54359b
            kotlinx.coroutines.channels.ChannelIterator r7 = r9.f54358a
            java.lang.Object r8 = r9.f54362e
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r10)
            r9.f54362e = r8
            r9.f54358a = r7
            r9.f54359b = r2
            r9.f54360c = r1
            r9.f54361d = r5
            java.lang.Object r10 = r6.o(r10, r9)
            if (r10 != r0) goto L42
            goto L52
        L42:
            r5 = r7
            r6 = r8
        L44:
            r9.f54362e = r6
            r9.f54358a = r5
            r9.f54360c = r1
            r9.f54361d = r3
            java.lang.Object r10 = r5.b(r9)
            if (r10 != r0) goto L5f
        L52:
            return r0
        L53:
            int r1 = r9.f54360c
            kotlinx.coroutines.channels.ChannelIterator r5 = r9.f54358a
            java.lang.Object r0 = r9.f54362e
            r6 = r0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.b(r10)
        L5f:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L6a
            kotlin.Unit r10 = kotlin.Unit.f53572a
            return r10
        L6a:
            r5.next()
            int r10 = r1 + 1
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r1)
            r9.f54362e = r6
            r9.f54358a = r5
            r9.f54359b = r6
            r9.f54360c = r10
            r9.f54361d = r4
            throw r2
        L7f:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.f54362e
            kotlinx.coroutines.channels.ProducerScope r10 = (kotlinx.coroutines.channels.ProducerScope) r10
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
