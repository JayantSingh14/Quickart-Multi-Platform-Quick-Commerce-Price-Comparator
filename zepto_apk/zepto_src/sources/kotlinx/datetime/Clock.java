package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public interface Clock {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    @Metadata
    public static final class System implements Clock {
        public static Instant a() {
            Instant.Companion.getClass();
            j$.time.Instant instant = j$.time.Clock.systemUTC().instant();
            Intrinsics.checkNotNullExpressionValue(instant, "instant(...)");
            return new Instant(instant);
        }
    }
}
