package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", l = {228, 229, 229}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$filter$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public ChannelIterator f54303a;

    /* renamed from: b, reason: collision with root package name */
    public Object f54304b;

    /* renamed from: c, reason: collision with root package name */
    public int f54305c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54306d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        if (r9 != r0) goto L23;
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
            int r1 = r8.f54305c
            r2 = 0
            if (r1 == 0) goto L79
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L57
            r5 = 3
            if (r1 == r3) goto L22
            if (r1 != r5) goto L1a
            kotlinx.coroutines.channels.ChannelIterator r1 = r8.f54303a
            java.lang.Object r5 = r8.f54306d
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r9)
            goto L46
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L22:
            java.lang.Object r1 = r8.f54304b
            kotlinx.coroutines.channels.ChannelIterator r6 = r8.f54303a
            java.lang.Object r7 = r8.f54306d
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.b(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L48
            r8.f54306d = r7
            r8.f54303a = r6
            r8.f54304b = r2
            r8.f54305c = r5
            java.lang.Object r9 = r7.o(r1, r8)
            if (r9 != r0) goto L44
            goto L56
        L44:
            r1 = r6
            r5 = r7
        L46:
            r6 = r1
            r7 = r5
        L48:
            r8.f54306d = r7
            r8.f54303a = r6
            r8.f54304b = r2
            r8.f54305c = r4
            java.lang.Object r9 = r6.b(r8)
            if (r9 != r0) goto L61
        L56:
            return r0
        L57:
            kotlinx.coroutines.channels.ChannelIterator r6 = r8.f54303a
            java.lang.Object r0 = r8.f54306d
            r7 = r0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.b(r9)
        L61:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L6c
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        L6c:
            java.lang.Object r9 = r6.next()
            r8.f54306d = r7
            r8.f54303a = r6
            r8.f54304b = r9
            r8.f54305c = r3
            throw r2
        L79:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f54306d
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
