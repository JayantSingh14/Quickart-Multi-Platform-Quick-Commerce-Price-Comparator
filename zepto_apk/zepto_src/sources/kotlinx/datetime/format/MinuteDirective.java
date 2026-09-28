package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class MinuteDirective extends UnsignedIntFieldFormatDirective<TimeFieldContainer> {

    /* renamed from: e, reason: collision with root package name */
    public final Padding f55464e;

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
    public MinuteDirective() {
        Padding padding = Padding.f55479b;
        Intrinsics.checkNotNullParameter(padding, "padding");
        UnsignedFieldSpec unsignedFieldSpec = TimeFields.f55486b;
        Padding padding2 = Padding.f55478a;
        super(unsignedFieldSpec, 2, null);
        this.f55464e = padding;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MinuteDirective) {
            return this.f55464e == ((MinuteDirective) obj).f55464e;
        }
        return false;
    }

    public final int hashCode() {
        return this.f55464e.hashCode();
    }
}
