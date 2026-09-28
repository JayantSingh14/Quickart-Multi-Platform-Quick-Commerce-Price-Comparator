package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class UtcOffsetSecondOfMinuteDirective extends UnsignedIntFieldFormatDirective<UtcOffsetFieldContainer> {

    /* renamed from: e, reason: collision with root package name */
    public final Padding f55517e;

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
    public UtcOffsetSecondOfMinuteDirective() {
        Padding padding = Padding.f55479b;
        Intrinsics.checkNotNullParameter(padding, "padding");
        UnsignedFieldSpec unsignedFieldSpec = OffsetFields.f55472c;
        Padding padding2 = Padding.f55478a;
        super(unsignedFieldSpec, 2, null);
        this.f55517e = padding;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UtcOffsetSecondOfMinuteDirective) {
            return this.f55517e == ((UtcOffsetSecondOfMinuteDirective) obj).f55517e;
        }
        return false;
    }

    public final int hashCode() {
        return this.f55517e.hashCode();
    }
}
