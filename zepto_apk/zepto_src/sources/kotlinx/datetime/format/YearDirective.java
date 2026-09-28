package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.GenericFieldSpec;
import kotlinx.datetime.internal.format.SignedIntFieldFormatDirective;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class YearDirective extends SignedIntFieldFormatDirective<DateFieldContainer> {

    /* renamed from: d, reason: collision with root package name */
    public final Padding f55521d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f55522e;

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
    public YearDirective(boolean z) {
        Padding padding = Padding.f55479b;
        Intrinsics.checkNotNullParameter(padding, "padding");
        GenericFieldSpec genericFieldSpec = DateFields.f55373a;
        Padding padding2 = Padding.f55478a;
        super(genericFieldSpec, 4, null);
        this.f55521d = padding;
        this.f55522e = z;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof YearDirective)) {
            return false;
        }
        YearDirective yearDirective = (YearDirective) obj;
        return this.f55521d == yearDirective.f55521d && this.f55522e == yearDirective.f55522e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f55522e) + (this.f55521d.hashCode() * 31);
    }
}
