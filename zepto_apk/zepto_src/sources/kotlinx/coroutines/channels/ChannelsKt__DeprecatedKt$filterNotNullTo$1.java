package kotlinx.coroutines.channels;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {514}, m = "filterNotNullTo")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$filterNotNullTo$1<E, C extends Collection<? super E>> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Collection f54314a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54315b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54316c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54317d;

    /* renamed from: e, reason: collision with root package name */
    public int f54318e;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54317d = obj;
        int i2 = (this.f54318e | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54318e = i2;
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
            ChannelIterator channelIterator = this.f54316c;
            ReceiveChannel receiveChannel2 = this.f54315b;
            Collection collection = this.f54314a;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    if (next != null) {
                        collection.add(next);
                    }
                    this.f54314a = collection;
                    this.f54315b = receiveChannel2;
                    this.f54316c = channelIterator;
                    this.f54318e = 1;
                    obj = channelIterator.b(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Unit unit = Unit.f53572a;
                receiveChannel2.e(null);
                return collection;
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
