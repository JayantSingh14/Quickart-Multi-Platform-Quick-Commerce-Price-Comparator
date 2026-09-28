package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class MonthDirective extends UnsignedIntFieldFormatDirective<DateFieldContainer> {

    /* renamed from: e, reason: collision with root package name */
    public final Padding f55465e;

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

    /* JADX WARN: Illegal instructions before constructor call */
    public MonthDirective() {
        Padding padding = Padding.f55479b;
        Intrinsics.checkNotNullParameter(padding, "padding");
        UnsignedFieldSpec unsignedFieldSpec = DateFields.f55374b;
        Padding padding2 = Padding.f55478a;
        super(unsignedFieldSpec, 2, null);
        this.f55465e = padding;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MonthDirective) {
            return this.f55465e == ((MonthDirective) obj).f55465e;
        }
        return false;
    }

    public final int hashCode() {
        return this.f55465e.hashCode();
    }
}
