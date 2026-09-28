package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {83}, m = "elementAtOrNull")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$elementAtOrNull$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f54298a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54299b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54300c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54301d;

    /* renamed from: e, reason: collision with root package name */
    public int f54302e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54301d = obj;
        int i2 = (this.f54302e | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54302e = i2;
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
            int i3 = this.f54298a;
            ChannelIterator channelIterator = this.f54300c;
            ReceiveChannel receiveChannel2 = this.f54299b;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    int i4 = i3 + 1;
                    if (i3 == 0) {
                        receiveChannel2.e(null);
                        return next;
                    }
                    this.f54299b = receiveChannel2;
                    this.f54300c = channelIterator;
                    this.f54298a = i4;
                    this.f54302e = 1;
                    obj = channelIterator.b(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    i3 = i4;
                }
                receiveChannel2.e(null);
                return null;
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
