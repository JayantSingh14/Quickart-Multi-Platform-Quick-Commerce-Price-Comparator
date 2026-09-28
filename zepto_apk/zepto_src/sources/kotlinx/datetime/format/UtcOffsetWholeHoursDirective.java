package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UtcOffsetWholeHoursDirective extends UnsignedIntFieldFormatDirective<UtcOffsetFieldContainer> {

    /* renamed from: e, reason: collision with root package name */
    public final Padding f55518e;

    /* JADX WARN: Illegal instructions before constructor call */
    public UtcOffsetWholeHoursDirective() {
        Padding padding = Padding.f55479b;
        Intrinsics.checkNotNullParameter(padding, "padding");
        UnsignedFieldSpec unsignedFieldSpec = OffsetFields.f55470a;
        Padding padding2 = Padding.f55478a;
        super(unsignedFieldSpec, 2, null);
        this.f55518e = padding;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UtcOffsetWholeHoursDirective) {
            return this.f55518e == ((UtcOffsetWholeHoursDirective) obj).f55518e;
        }
        return false;
    }

    public final int hashCode() {
        return this.f55518e.hashCode();
    }
}
