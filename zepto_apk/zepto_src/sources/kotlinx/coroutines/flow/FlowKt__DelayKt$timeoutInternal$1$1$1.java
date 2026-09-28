package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", l = {395}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$timeoutInternal$1$1$1 extends SuspendLambda implements Function2<ChannelResult<Object>, Continuation<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f54604a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54605b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f54606c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$timeoutInternal$1$1$1(FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f54606c = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 flowKt__DelayKt$timeoutInternal$1$1$1 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.f54606c, continuation);
        flowKt__DelayKt$timeoutInternal$1$1$1.f54605b = obj;
        return flowKt__DelayKt$timeoutInternal$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(new ChannelResult(((ChannelResult) obj).f54255a), (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) throws java.lang.Throwable {
        /*
            r3 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r3.f54604a
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            java.lang.Object r0 = r3.f54605b
            kotlin.ResultKt.b(r4)
            goto L32
        Lf:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L17:
            kotlin.ResultKt.b(r4)
            java.lang.Object r4 = r3.f54605b
            kotlinx.coroutines.channels.ChannelResult r4 = (kotlinx.coroutines.channels.ChannelResult) r4
            java.lang.Object r4 = r4.f54255a
            boolean r1 = r4 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
            if (r1 != 0) goto L33
            r3.f54605b = r4
            r3.f54604a = r2
            kotlinx.coroutines.flow.FlowCollector r1 = r3.f54606c
            java.lang.Object r1 = r1.a(r4, r3)
            if (r1 != r0) goto L31
            return r0
        L31:
            r0 = r4
        L32:
            r4 = r0
        L33:
            boolean r0 = r4 instanceof kotlinx.coroutines.channels.ChannelResult.Closed
            if (r0 == 0) goto L42
            java.lang.Throwable r4 = kotlinx.coroutines.channels.ChannelResult.a(r4)
            if (r4 != 0) goto L41
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L41:
            throw r4
        L42:
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
