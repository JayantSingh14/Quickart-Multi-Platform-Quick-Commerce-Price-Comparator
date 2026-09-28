package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class DayDirective extends UnsignedIntFieldFormatDirective<DateFieldContainer> {

    /* renamed from: e, reason: collision with root package name */
    public final Padding f55411e;

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DayDirective(Padding padding) {
        super(DateFields.f55375c, padding == Padding.f55479b ? 2 : 1, padding == Padding.f55480c ? 2 : null);
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.f55411e = padding;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DayDirective) {
            return this.f55411e == ((DayDirective) obj).f55411e;
        }
        return false;
    }

    public final int hashCode() {
        return this.f55411e.hashCode();
    }
}
