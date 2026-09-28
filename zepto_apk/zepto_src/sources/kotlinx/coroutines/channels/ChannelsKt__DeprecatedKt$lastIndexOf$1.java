package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {514}, m = "lastIndexOf")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$lastIndexOf$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.IntRef f54341a;

    /* renamed from: b, reason: collision with root package name */
    public Ref.IntRef f54342b;

    /* renamed from: c, reason: collision with root package name */
    public ReceiveChannel f54343c;

    /* renamed from: d, reason: collision with root package name */
    public ChannelIterator f54344d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f54345e;

    /* renamed from: f, reason: collision with root package name */
    public int f54346f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54345e = obj;
        int i2 = (this.f54346f | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54346f = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ReceiveChannel receiveChannel = null;
        if (i2 == 0) {
            ResultKt.b(obj);
            new Ref.IntRef().f53799a = -1;
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
            ChannelIterator channelIterator = this.f54344d;
            ReceiveChannel receiveChannel2 = this.f54343c;
            Ref.IntRef intRef = this.f54342b;
            Ref.IntRef intRef2 = this.f54341a;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    if (Intrinsics.b(null, channelIterator.next())) {
                        intRef2.f53799a = intRef.f53799a;
                    }
                    intRef.f53799a++;
                    this.f54341a = intRef2;
                    this.f54342b = intRef;
                    this.f54343c = receiveChannel2;
                    this.f54344d = channelIterator;
                    this.f54346f = 1;
                    obj = channelIterator.b(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Unit unit = Unit.f53572a;
                receiveChannel2.e(null);
                return new Integer(intRef2.f53799a);
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
