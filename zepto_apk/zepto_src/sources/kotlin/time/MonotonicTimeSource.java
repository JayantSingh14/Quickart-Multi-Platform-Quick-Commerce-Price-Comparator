package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
/* loaded from: classes3.dex */
public final class MonotonicTimeSource implements TimeSource.WithComparableMarks {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MonotonicTimeSource f54029a = new MonotonicTimeSource();

    static {
        System.nanoTime();
    }

    public final String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
