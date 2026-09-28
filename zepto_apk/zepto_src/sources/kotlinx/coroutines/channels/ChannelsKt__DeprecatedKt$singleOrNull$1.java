package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {179, 182}, m = "singleOrNull")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$singleOrNull$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ReceiveChannel f54381a;

    /* renamed from: b, reason: collision with root package name */
    public Object f54382b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54383c;

    /* renamed from: d, reason: collision with root package name */
    public int f54384d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        ReceiveChannel receiveChannel;
        this.f54383c = obj;
        int i2 = (this.f54384d | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54384d = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ReceiveChannel receiveChannel2 = null;
        if (i2 != 0) {
            if (i2 == 1) {
                ChannelIterator channelIterator = (ChannelIterator) this.f54382b;
                ReceiveChannel receiveChannel3 = this.f54381a;
                try {
                    ResultKt.b(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        receiveChannel3.e(null);
                        return null;
                    }
                    Object next = channelIterator.next();
                    this.f54381a = receiveChannel3;
                    this.f54382b = next;
                    this.f54384d = 2;
                    Object objB = channelIterator.b(this);
                    if (objB == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj2 = next;
                    obj = objB;
                    receiveChannel = receiveChannel3;
                } catch (Throwable th) {
                    th = th;
                    receiveChannel2 = receiveChannel3;
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.f54382b;
                receiveChannel = this.f54381a;
                try {
                    ResultKt.b(obj);
                } catch (Throwable th2) {
                    th = th2;
                    receiveChannel2 = receiveChannel;
                }
            }
            if (((Boolean) obj).booleanValue()) {
                receiveChannel.e(null);
                return null;
            }
            receiveChannel.e(null);
            return obj2;
        }
        ResultKt.b(obj);
        try {
            throw null;
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            throw th;
        } catch (Throwable th4) {
            ChannelsKt.a(receiveChannel2, th);
            throw th4;
        }
    }
}
