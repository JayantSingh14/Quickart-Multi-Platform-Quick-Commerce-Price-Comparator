package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {41}, m = "consumeEach")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$consumeEach$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Function1 f54277a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54278b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54279c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54280d;

    /* renamed from: e, reason: collision with root package name */
    public int f54281e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54280d = obj;
        int i2 = (this.f54281e | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54281e = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ChannelIterator channelIterator = this.f54279c;
        ReceiveChannel receiveChannel = this.f54278b;
        Function1 function1 = this.f54277a;
        try {
            ResultKt.b(obj);
            while (((Boolean) obj).booleanValue()) {
                function1.invoke(channelIterator.next());
                this.f54277a = function1;
                this.f54278b = receiveChannel;
                this.f54279c = channelIterator;
                this.f54281e = 1;
                obj = channelIterator.b(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            Unit unit = Unit.f53572a;
            receiveChannel.e(null);
            return Unit.f53572a;
        } catch (Throwable th) {
            receiveChannel.e(null);
            throw th;
        }
    }
}
