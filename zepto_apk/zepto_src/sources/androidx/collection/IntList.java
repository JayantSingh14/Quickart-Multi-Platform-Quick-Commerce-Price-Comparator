package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class IntList {

    /* renamed from: a, reason: collision with root package name */
    public int[] f1442a;

    public final boolean equals(Object obj) {
        if (!(obj instanceof IntList)) {
            return false;
        }
        IntList intList = (IntList) obj;
        intList.getClass();
        int[] iArr = intList.f1442a;
        IntRange intRangeF = RangesKt.f(0, 0);
        int i2 = intRangeF.f53838a;
        int i3 = intRangeF.f53839b;
        if (i2 > i3) {
            return true;
        }
        while (this.f1442a[i2] == iArr[i2]) {
            if (i2 == i3) {
                return true;
            }
            i2++;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        Intrinsics.checkNotNullParameter(", ", "separator");
        Intrinsics.checkNotNullParameter("[", "prefix");
        Intrinsics.checkNotNullParameter("]", "postfix");
        Intrinsics.checkNotNullParameter("...", "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        sb.append((CharSequence) "]");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
