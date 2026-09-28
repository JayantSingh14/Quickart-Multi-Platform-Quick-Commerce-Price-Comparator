package kotlinx.datetime.internal;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DecimalFraction implements Comparable<DecimalFraction> {

    /* renamed from: a, reason: collision with root package name */
    public final int f55523a;

    /* renamed from: b, reason: collision with root package name */
    public final int f55524b;

    public DecimalFraction(int i2, int i3) {
        this.f55523a = i2;
        this.f55524b = i3;
        if (i3 < 0) {
            throw new IllegalArgumentException(b.f(i3, "Digits must be non-negative, but was ").toString());
        }
    }

    public final int a(int i2) {
        int i3 = this.f55523a;
        int i4 = this.f55524b;
        if (i2 == i4) {
            return i3;
        }
        int[] iArr = MathKt.f55525a;
        return i2 > i4 ? i3 * iArr[i2 - i4] : i3 / iArr[i4 - i2];
    }

    @Override // java.lang.Comparable
    public final int compareTo(DecimalFraction decimalFraction) {
        DecimalFraction other = decimalFraction;
        Intrinsics.checkNotNullParameter(other, "other");
        int iMax = Math.max(this.f55524b, other.f55524b);
        return Intrinsics.e(a(iMax), other.a(iMax));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DecimalFraction)) {
            return false;
        }
        DecimalFraction other = (DecimalFraction) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        int iMax = Math.max(this.f55524b, other.f55524b);
        return Intrinsics.e(a(iMax), other.a(iMax)) == 0;
    }

    public final int hashCode() {
        throw new UnsupportedOperationException("DecimalFraction is not supposed to be used as a hash key");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = MathKt.f55525a[this.f55524b];
        int i3 = this.f55523a;
        sb.append(i3 / i2);
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        sb.append(StringsKt.F(String.valueOf((i3 % i2) + i2), "1"));
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
