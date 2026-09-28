package kotlinx.datetime.internal.format.formatter;

import android.support.v4.media.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DecimalFractionFormatterStructure<T> implements FormatterStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f55575a;

    /* renamed from: b, reason: collision with root package name */
    public final List f55576b;

    public DecimalFractionFormatterStructure(Function1 number, int i2, int i3, List zerosToAdd) {
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(zerosToAdd, "zerosToAdd");
        this.f55575a = number;
        this.f55576b = zerosToAdd;
        if (1 > i2 || i2 >= 10) {
            throw new IllegalArgumentException(b.g(i2, "The minimum number of digits (", ") is not in range 1..9").toString());
        }
        if (i2 > i3 || i3 >= 10) {
            throw new IllegalArgumentException(b.e(i3, i2, "The maximum number of digits (", ") is not in range ", "..9").toString());
        }
    }
}
