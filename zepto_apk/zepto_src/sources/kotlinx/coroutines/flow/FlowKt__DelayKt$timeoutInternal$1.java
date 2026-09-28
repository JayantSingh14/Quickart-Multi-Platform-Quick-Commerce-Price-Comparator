package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", l = {413}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$timeoutInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public long f54600a;

    /* renamed from: b, reason: collision with root package name */
    public int f54601b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54602c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54603d;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f54601b;
        if (i2 == 0) {
            ResultKt.b(obj);
            Duration.f54014b.getClass();
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long j2 = this.f54600a;
        ReceiveChannel receiveChannel = (ReceiveChannel) this.f54603d;
        FlowCollector flowCollector = (FlowCollector) this.f54602c;
        ResultKt.b(obj);
        while (((Boolean) obj).booleanValue()) {
            SelectImplementation selectImplementation = new SelectImplementation(getContext());
            selectImplementation.k(receiveChannel.k(), new FlowKt__DelayKt$timeoutInternal$1$1$1(flowCollector, null));
            FlowKt__DelayKt$timeoutInternal$1$1$2 flowKt__DelayKt$timeoutInternal$1$1$2 = new FlowKt__DelayKt$timeoutInternal$1$1$2(j2, null);
            Duration.Companion companion = Duration.f54014b;
            long jH = 0;
            boolean z = j2 > 0;
            if (z) {
                long jG = Duration.g(j2, DurationKt.h(999999L, DurationUnit.f54019b));
                jH = ((((int) jG) & 1) != 1 || Duration.e(jG)) ? Duration.h(jG, DurationUnit.f54021d) : jG >> 1;
            } else if (z) {
                throw new NoWhenBranchMatchedException();
            }
            OnTimeoutKt.a(selectImplementation, jH, flowKt__DelayKt$timeoutInternal$1$1$2);
            this.f54602c = flowCollector;
            this.f54603d = receiveChannel;
            this.f54600a = j2;
            this.f54601b = 1;
            obj = selectImplementation.g(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.f53572a;
    }
}
