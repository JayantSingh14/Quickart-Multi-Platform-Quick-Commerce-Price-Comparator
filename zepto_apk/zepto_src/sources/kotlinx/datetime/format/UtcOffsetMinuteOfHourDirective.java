package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class UtcOffsetMinuteOfHourDirective extends UnsignedIntFieldFormatDirective<UtcOffsetFieldContainer> {

    /* renamed from: e, reason: collision with root package name */
    public final Padding f55516e;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Padding.values().length];
            try {
                Padding padding = Padding.f55478a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public UtcOffsetMinuteOfHourDirective() {
        Padding padding = Padding.f55479b;
        Intrinsics.checkNotNullParameter(padding, "padding");
        UnsignedFieldSpec unsignedFieldSpec = OffsetFields.f55471b;
        Padding padding2 = Padding.f55478a;
        super(unsignedFieldSpec, 2, null);
        this.f55516e = padding;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UtcOffsetMinuteOfHourDirective) {
            return this.f55516e == ((UtcOffsetMinuteOfHourDirective) obj).f55516e;
        }
        return false;
    }

    public final int hashCode() {
        return this.f55516e.hashCode();
    }
}
