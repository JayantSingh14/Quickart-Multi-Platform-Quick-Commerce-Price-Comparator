package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {514}, m = "count")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$count$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.IntRef f54282a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54283b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54284c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54285d;

    /* renamed from: e, reason: collision with root package name */
    public int f54286e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54285d = obj;
        int i2 = (this.f54286e | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54286e = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ReceiveChannel receiveChannel = null;
        if (i2 == 0) {
            ResultKt.b(obj);
            new Ref.IntRef();
            try {
                throw null;
            } catch (Throwable th) {
                th = th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ChannelIterator channelIterator = this.f54284c;
            ReceiveChannel receiveChannel2 = this.f54283b;
            Ref.IntRef intRef = this.f54282a;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    channelIterator.next();
                    intRef.f53799a++;
                    this.f54282a = intRef;
                    this.f54283b = receiveChannel2;
                    this.f54284c = channelIterator;
                    this.f54286e = 1;
                    obj = channelIterator.b(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Unit unit = Unit.f53572a;
                receiveChannel2.e(null);
                return new Integer(intRef.f53799a);
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
