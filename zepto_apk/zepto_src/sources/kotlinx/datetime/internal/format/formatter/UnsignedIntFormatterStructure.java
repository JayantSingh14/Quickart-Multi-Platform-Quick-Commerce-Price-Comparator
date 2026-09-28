package kotlinx.datetime.internal.format.formatter;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UnsignedIntFormatterStructure<T> implements FormatterStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f55581a;

    public UnsignedIntFormatterStructure(int i2, Function1 number) {
        Intrinsics.checkNotNullParameter(number, "number");
        this.f55581a = number;
        if (i2 < 0) {
            throw new IllegalArgumentException(b.g(i2, "The minimum number of digits (", ") is negative").toString());
        }
        if (i2 > 9) {
            throw new IllegalArgumentException(b.g(i2, "The minimum number of digits (", ") exceeds the length of an Int").toString());
        }
    }
}
