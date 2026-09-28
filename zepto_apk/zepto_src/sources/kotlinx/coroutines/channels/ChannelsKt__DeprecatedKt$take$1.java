package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", l = {284, 285}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public ChannelIterator f54385a;

    /* renamed from: b, reason: collision with root package name */
    public int f54386b;

    /* renamed from: c, reason: collision with root package name */
    public int f54387c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54388d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$take$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0043 -> B:16:0x0046). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r6.f54387c
            if (r1 == 0) goto L5f
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            int r1 = r6.f54386b
            kotlinx.coroutines.channels.ChannelIterator r4 = r6.f54385a
            java.lang.Object r5 = r6.f54388d
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r7)
            goto L46
        L18:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L20:
            int r1 = r6.f54386b
            kotlinx.coroutines.channels.ChannelIterator r4 = r6.f54385a
            java.lang.Object r5 = r6.f54388d
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r7)
        L2b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L5c
            java.lang.Object r7 = r4.next()
            r6.f54388d = r5
            r6.f54385a = r4
            r6.f54386b = r1
            r6.f54387c = r2
            java.lang.Object r7 = r5.o(r7, r6)
            if (r7 != r0) goto L46
            goto L5b
        L46:
            int r1 = r1 + (-1)
            if (r1 != 0) goto L4d
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L4d:
            r6.f54388d = r5
            r6.f54385a = r4
            r6.f54386b = r1
            r6.f54387c = r3
            java.lang.Object r7 = r4.b(r6)
            if (r7 != r0) goto L2b
        L5b:
            return r0
        L5c:
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L5f:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = r6.f54388d
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            r7 = 0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
