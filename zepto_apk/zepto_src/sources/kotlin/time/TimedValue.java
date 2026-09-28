package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.time.Duration;

@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public final class TimedValue<T> {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimedValue)) {
            return false;
        }
        ((TimedValue) obj).getClass();
        Duration.Companion companion = Duration.f54014b;
        return true;
    }

    public final int hashCode() {
        Duration.Companion companion = Duration.f54014b;
        return Long.hashCode(0L);
    }

    public final String toString() {
        return "TimedValue(value=null, duration=" + ((Object) Duration.i(0L)) + ')';
    }
}
