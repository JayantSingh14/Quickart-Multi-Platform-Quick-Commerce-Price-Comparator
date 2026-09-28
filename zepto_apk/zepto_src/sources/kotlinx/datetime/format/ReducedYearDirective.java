package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.internal.format.ReducedIntFieldDirective;

@Metadata
/* loaded from: classes3.dex */
final class ReducedYearDirective extends ReducedIntFieldDirective<DateFieldContainer> {
    public final boolean equals(Object obj) {
        if (!(obj instanceof ReducedYearDirective)) {
            return false;
        }
        ((ReducedYearDirective) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + (Integer.hashCode(0) * 31);
    }
}
