package kotlinx.coroutines.channels;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {209}, m = "toList")
/* loaded from: classes3.dex */
final class ChannelsKt__Channels_commonKt$toList$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public List f54269a;

    /* renamed from: b, reason: collision with root package name */
    public List f54270b;

    /* renamed from: c, reason: collision with root package name */
    public ReceiveChannel f54271c;

    /* renamed from: d, reason: collision with root package name */
    public ChannelIterator f54272d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f54273e;

    /* renamed from: f, reason: collision with root package name */
    public int f54274f;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54273e = obj;
        int i2 = (this.f54274f | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54274f = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ReceiveChannel receiveChannel = null;
        if (i2 == 0) {
            ResultKt.b(obj);
            CollectionsKt.u();
            try {
                throw null;
            } catch (Throwable th) {
                th = th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ChannelIterator channelIterator = this.f54272d;
            ReceiveChannel receiveChannel2 = this.f54271c;
            List list = this.f54270b;
            List builder = this.f54269a;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    list.add(channelIterator.next());
                    this.f54269a = builder;
                    this.f54270b = list;
                    this.f54271c = receiveChannel2;
                    this.f54272d = channelIterator;
                    this.f54274f = 1;
                    obj = channelIterator.b(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Unit unit = Unit.f53572a;
                receiveChannel2.e(null);
                Intrinsics.checkNotNullParameter(builder, "builder");
                return ((ListBuilder) builder).j();
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
