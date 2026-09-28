package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata
/* loaded from: classes.dex */
public final class BufferedChannelKt {

    /* renamed from: a, reason: collision with root package name */
    public static final ChannelSegment f54235a = new ChannelSegment(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f54236b = SystemPropsKt.d(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");

    /* renamed from: c, reason: collision with root package name */
    public static final int f54237c = SystemPropsKt.d(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");

    /* renamed from: d, reason: collision with root package name */
    public static final Symbol f54238d = new Symbol("BUFFERED");

    /* renamed from: e, reason: collision with root package name */
    public static final Symbol f54239e = new Symbol("SHOULD_BUFFER");

    /* renamed from: f, reason: collision with root package name */
    public static final Symbol f54240f = new Symbol("S_RESUMING_BY_RCV");

    /* renamed from: g, reason: collision with root package name */
    public static final Symbol f54241g = new Symbol("RESUMING_BY_EB");

    /* renamed from: h, reason: collision with root package name */
    public static final Symbol f54242h = new Symbol("POISONED");

    /* renamed from: i, reason: collision with root package name */
    public static final Symbol f54243i = new Symbol("DONE_RCV");

    /* renamed from: j, reason: collision with root package name */
    public static final Symbol f54244j = new Symbol("INTERRUPTED_SEND");

    /* renamed from: k, reason: collision with root package name */
    public static final Symbol f54245k = new Symbol("INTERRUPTED_RCV");

    /* renamed from: l, reason: collision with root package name */
    public static final Symbol f54246l = new Symbol("CHANNEL_CLOSED");

    /* renamed from: m, reason: collision with root package name */
    public static final Symbol f54247m = new Symbol("SUSPEND");
    public static final Symbol n = new Symbol("SUSPEND_NO_WAITER");
    public static final Symbol o = new Symbol("FAILED");
    public static final Symbol p = new Symbol("NO_RECEIVE_RESULT");
    public static final Symbol q = new Symbol("CLOSE_HANDLER_CLOSED");
    public static final Symbol r = new Symbol("CLOSE_HANDLER_INVOKED");
    public static final Symbol s = new Symbol("NO_CLOSE_CAUSE");

    public static final boolean a(CancellableContinuation cancellableContinuation, Object obj, Function3 function3) {
        Symbol symbolF = cancellableContinuation.f(obj, function3);
        if (symbolF == null) {
            return false;
        }
        cancellableContinuation.q(symbolF);
        return true;
    }
}
