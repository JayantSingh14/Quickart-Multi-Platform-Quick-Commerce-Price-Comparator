package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: classes.dex */
public final class EventLoop_commonKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Symbol f54110a = new Symbol("REMOVED_TASK");

    /* renamed from: b, reason: collision with root package name */
    public static final Symbol f54111b = new Symbol("CLOSED_EMPTY");

    public static final long a(long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        if (j2 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return j2 * 1000000;
    }
}
