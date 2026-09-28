package kotlinx.coroutines.channels;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", l = {417, 418, 420}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public HashSet f54288a;

    /* renamed from: b, reason: collision with root package name */
    public ChannelIterator f54289b;

    /* renamed from: c, reason: collision with root package name */
    public Object f54290c;

    /* renamed from: d, reason: collision with root package name */
    public int f54291d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f54292e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r11 != r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r10.f54291d
            r2 = 0
            if (r1 == 0) goto L8b
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L65
            r5 = 3
            if (r1 == r3) goto L27
            if (r1 != r5) goto L1f
            java.lang.Object r1 = r10.f54290c
            kotlinx.coroutines.channels.ChannelIterator r5 = r10.f54289b
            java.util.HashSet r6 = r10.f54288a
            java.lang.Object r7 = r10.f54292e
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.b(r11)
            r11 = r1
            goto L4e
        L1f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L27:
            java.lang.Object r1 = r10.f54290c
            kotlinx.coroutines.channels.ChannelIterator r6 = r10.f54289b
            java.util.HashSet r7 = r10.f54288a
            java.lang.Object r8 = r10.f54292e
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r11)
            boolean r9 = r7.contains(r11)
            if (r9 != 0) goto L54
            r10.f54292e = r8
            r10.f54288a = r7
            r10.f54289b = r6
            r10.f54290c = r11
            r10.f54291d = r5
            java.lang.Object r1 = r8.o(r1, r10)
            if (r1 != r0) goto L4b
            goto L64
        L4b:
            r5 = r6
            r6 = r7
            r7 = r8
        L4e:
            r6.add(r11)
            r8 = r7
            r7 = r6
            r6 = r5
        L54:
            r10.f54292e = r8
            r10.f54288a = r7
            r10.f54289b = r6
            r10.f54290c = r2
            r10.f54291d = r4
            java.lang.Object r11 = r6.b(r10)
            if (r11 != r0) goto L71
        L64:
            return r0
        L65:
            kotlinx.coroutines.channels.ChannelIterator r6 = r10.f54289b
            java.util.HashSet r7 = r10.f54288a
            java.lang.Object r0 = r10.f54292e
            r8 = r0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r11)
        L71:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L7c
            kotlin.Unit r11 = kotlin.Unit.f53572a
            return r11
        L7c:
            java.lang.Object r11 = r6.next()
            r10.f54292e = r8
            r10.f54288a = r7
            r10.f54289b = r6
            r10.f54290c = r11
            r10.f54291d = r3
            throw r2
        L8b:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.f54292e
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
