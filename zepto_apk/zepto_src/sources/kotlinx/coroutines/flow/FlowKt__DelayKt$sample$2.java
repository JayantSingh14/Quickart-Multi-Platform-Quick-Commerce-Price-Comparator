package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectImplementation;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", l = {412}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54585a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54586b;

    /* renamed from: c, reason: collision with root package name */
    public int f54587c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54588d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f54589e;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f54587c;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ReceiveChannel receiveChannel = this.f54586b;
        Ref.ObjectRef objectRef = this.f54585a;
        ReceiveChannel receiveChannel2 = (ReceiveChannel) this.f54589e;
        FlowCollector flowCollector = (FlowCollector) this.f54588d;
        ResultKt.b(obj);
        while (objectRef.f53801a != NullSurrogateKt.f55043c) {
            SelectImplementation selectImplementation = new SelectImplementation(getContext());
            selectImplementation.k(receiveChannel2.k(), new FlowKt__DelayKt$sample$2$1$1(objectRef, receiveChannel, null));
            selectImplementation.k(receiveChannel.j(), new FlowKt__DelayKt$sample$2$1$2(null, objectRef, flowCollector));
            this.f54588d = flowCollector;
            this.f54589e = receiveChannel2;
            this.f54585a = objectRef;
            this.f54586b = receiveChannel;
            this.f54587c = 1;
            if (selectImplementation.g(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.f53572a;
    }
}
