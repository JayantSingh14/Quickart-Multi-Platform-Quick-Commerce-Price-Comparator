package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class DayOfYearDirective extends UnsignedIntFieldFormatDirective<DateFieldContainer> {

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Padding.values().length];
            try {
                Padding padding = Padding.f55478a;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DayOfYearDirective)) {
            return false;
        }
        ((DayOfYearDirective) obj).getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }
}
