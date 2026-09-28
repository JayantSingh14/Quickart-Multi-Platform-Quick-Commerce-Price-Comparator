package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata
/* loaded from: classes.dex */
final /* synthetic */ class BufferedChannel$onReceiveCatching$2 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, Object, Object, Object> {

    /* renamed from: b, reason: collision with root package name */
    public static final BufferedChannel$onReceiveCatching$2 f54226b = new BufferedChannel$onReceiveCatching$2(3, BufferedChannel.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        BufferedChannel bufferedChannel = (BufferedChannel) obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = BufferedChannel.f54208b;
        bufferedChannel.getClass();
        if (obj3 == BufferedChannelKt.f54246l) {
            ChannelResult.Failed failed = ChannelResult.f54254b;
            obj3 = ChannelResult.Companion.a(bufferedChannel.x());
        } else {
            ChannelResult.Failed failed2 = ChannelResult.f54254b;
        }
        return new ChannelResult(obj3);
    }
}
