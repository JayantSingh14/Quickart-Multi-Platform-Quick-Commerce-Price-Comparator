package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {166, 169}, m = "single")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$single$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ReceiveChannel f54377a;

    /* renamed from: b, reason: collision with root package name */
    public Object f54378b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54379c;

    /* renamed from: d, reason: collision with root package name */
    public int f54380d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        ReceiveChannel receiveChannel;
        this.f54379c = obj;
        int i2 = (this.f54380d | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54380d = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ReceiveChannel receiveChannel2 = null;
        if (i2 != 0) {
            if (i2 == 1) {
                ChannelIterator channelIterator = (ChannelIterator) this.f54378b;
                ReceiveChannel receiveChannel3 = this.f54377a;
                try {
                    ResultKt.b(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        throw new NoSuchElementException("ReceiveChannel is empty.");
                    }
                    Object next = channelIterator.next();
                    this.f54377a = receiveChannel3;
                    this.f54378b = next;
                    this.f54380d = 2;
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
                obj2 = this.f54378b;
                receiveChannel = this.f54377a;
                try {
                    ResultKt.b(obj);
                } catch (Throwable th2) {
                    th = th2;
                    receiveChannel2 = receiveChannel;
                }
            }
            if (((Boolean) obj).booleanValue()) {
                throw new IllegalArgumentException("ReceiveChannel has more than one element.");
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
