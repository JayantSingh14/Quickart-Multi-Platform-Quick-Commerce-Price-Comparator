package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", l = {299, 300, 301}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$takeWhile$1 extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public ChannelIterator f54389a;

    /* renamed from: b, reason: collision with root package name */
    public Object f54390b;

    /* renamed from: c, reason: collision with root package name */
    public int f54391c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54392d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        if (r9 == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r8.f54391c
            r2 = 0
            if (r1 == 0) goto L78
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L56
            r5 = 3
            if (r1 == r3) goto L22
            if (r1 != r5) goto L1a
            kotlinx.coroutines.channels.ChannelIterator r1 = r8.f54389a
            java.lang.Object r5 = r8.f54392d
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r9)
            goto L49
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L22:
            java.lang.Object r1 = r8.f54390b
            kotlinx.coroutines.channels.ChannelIterator r6 = r8.f54389a
            java.lang.Object r7 = r8.f54392d
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.b(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L38
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        L38:
            r8.f54392d = r7
            r8.f54389a = r6
            r8.f54390b = r2
            r8.f54391c = r5
            java.lang.Object r9 = r7.o(r1, r8)
            if (r9 != r0) goto L47
            goto L55
        L47:
            r1 = r6
            r5 = r7
        L49:
            r8.f54392d = r5
            r8.f54389a = r1
            r8.f54391c = r4
            java.lang.Object r9 = r1.b(r8)
            if (r9 != r0) goto L60
        L55:
            return r0
        L56:
            kotlinx.coroutines.channels.ChannelIterator r1 = r8.f54389a
            java.lang.Object r0 = r8.f54392d
            r5 = r0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r9)
        L60:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L6b
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        L6b:
            java.lang.Object r9 = r1.next()
            r8.f54392d = r5
            r8.f54389a = r1
            r8.f54390b = r9
            r8.f54391c = r3
            throw r2
        L78:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f54392d
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
