package kotlinx.coroutines.channels;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {514}, m = "toMap")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$toMap$2<K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Map f54403a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54404b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54405c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54406d;

    /* renamed from: e, reason: collision with root package name */
    public int f54407e;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54406d = obj;
        int i2 = (this.f54407e | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54407e = i2;
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
            ChannelIterator channelIterator = this.f54405c;
            ReceiveChannel receiveChannel2 = this.f54404b;
            Map map = this.f54403a;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    Pair pair = (Pair) channelIterator.next();
                    map.put(pair.f53533a, pair.f53534b);
                    this.f54403a = map;
                    this.f54404b = receiveChannel2;
                    this.f54405c = channelIterator;
                    this.f54407e = 1;
                    obj = channelIterator.b(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Unit unit = Unit.f53572a;
                receiveChannel2.e(null);
                return map;
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
