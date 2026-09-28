package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {161}, m = "consumeEach")
/* loaded from: classes3.dex */
final class ChannelsKt__Channels_commonKt$consumeEach$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Function1 f54264a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54265b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54266c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54267d;

    /* renamed from: e, reason: collision with root package name */
    public int f54268e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54267d = obj;
        int i2 = (this.f54268e | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54268e = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ReceiveChannel receiveChannel = null;
        if (i2 == 0) {
            ResultKt.b(obj);
            try {
                throw null;
            } catch (Throwable th) {
                th = th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ChannelIterator channelIterator = this.f54266c;
            ReceiveChannel receiveChannel2 = this.f54265b;
            Function1 function1 = this.f54264a;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    function1.invoke(channelIterator.next());
                    this.f54264a = function1;
                    this.f54265b = receiveChannel2;
                    this.f54266c = channelIterator;
                    this.f54268e = 1;
                    obj = channelIterator.b(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Unit unit = Unit.f53572a;
                receiveChannel2.e(null);
                return Unit.f53572a;
            } catch (Throwable th2) {
                th = th2;
                receiveChannel = receiveChannel2;
            }
        }
        try {
            throw th;
        } catch (Throwable th3) {
            ChannelsKt.a(receiveChannel, th);
            throw th3;
        }
    }
}
