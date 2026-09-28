package kotlinx.datetime.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.DecimalFractionFieldFormatDirective;

@Metadata
/* loaded from: classes3.dex */
public final class FractionalSecondDirective extends DecimalFractionFieldFormatDirective<TimeFieldContainer> {

    /* renamed from: g, reason: collision with root package name */
    public static final List f55416g = CollectionsKt.I(0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* renamed from: h, reason: collision with root package name */
    public static final List f55417h = CollectionsKt.I(2, 1, 0, 2, 1, 0, 2, 1, 0);

    /* renamed from: e, reason: collision with root package name */
    public final int f55418e;

    /* renamed from: f, reason: collision with root package name */
    public final int f55419f;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FractionalSecondDirective(int i2, int i3) {
        List zerosToAdd = f55416g;
        Intrinsics.checkNotNullParameter(zerosToAdd, "zerosToAdd");
        super(TimeFields.f55488d, i2, i3, zerosToAdd);
        this.f55418e = i2;
        this.f55419f = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FractionalSecondDirective)) {
            return false;
        }
        FractionalSecondDirective fractionalSecondDirective = (FractionalSecondDirective) obj;
        return this.f55418e == fractionalSecondDirective.f55418e && this.f55419f == fractionalSecondDirective.f55419f;
    }

    public final int hashCode() {
        return (this.f55418e * 31) + this.f55419f;
    }
}
