package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {236}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54573a;

    /* renamed from: b, reason: collision with root package name */
    public int f54574b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54575c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f54576d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f54577e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Continuation continuation, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
        super(2, continuation);
        this.f54576d = objectRef;
        this.f54577e = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(continuation, this.f54576d, this.f54577e);
        flowKt__DelayKt$debounceInternal$1$3$2.f54575c = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(new ChannelResult(((ChannelResult) obj).f54255a), (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f54574b;
        if (i2 == 0) {
            ResultKt.b(obj);
            Object obj2 = ((ChannelResult) this.f54575c).f54255a;
            boolean z = obj2 instanceof ChannelResult.Failed;
            objectRef = this.f54576d;
            if (!z) {
                objectRef.f53801a = obj2;
            }
            if (z) {
                Throwable thA = ChannelResult.a(obj2);
                if (thA != null) {
                    throw thA;
                }
                Object obj3 = objectRef.f53801a;
                if (obj3 != null) {
                    if (obj3 == NullSurrogateKt.f55041a) {
                        obj3 = null;
                    }
                    this.f54575c = obj2;
                    this.f54573a = objectRef;
                    this.f54574b = 1;
                    if (this.f54577e.a(obj3, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    objectRef2 = objectRef;
                }
                objectRef.f53801a = NullSurrogateKt.f55043c;
            }
            return Unit.f53572a;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2 = this.f54573a;
        ResultKt.b(obj);
        objectRef = objectRef2;
        objectRef.f53801a = NullSurrogateKt.f55043c;
        return Unit.f53572a;
    }
}
