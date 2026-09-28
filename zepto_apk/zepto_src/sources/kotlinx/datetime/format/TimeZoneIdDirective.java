package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.StringFieldFormatDirective;

@Metadata
/* loaded from: classes3.dex */
public final class TimeZoneIdDirective extends StringFieldFormatDirective<DateTimeComponentsContents> {
    public final boolean equals(Object obj) {
        if (!(obj instanceof TimeZoneIdDirective)) {
            return false;
        }
        ((TimeZoneIdDirective) obj).getClass();
        return Intrinsics.b(null, null);
    }

    public final int hashCode() {
        throw null;
    }
}
