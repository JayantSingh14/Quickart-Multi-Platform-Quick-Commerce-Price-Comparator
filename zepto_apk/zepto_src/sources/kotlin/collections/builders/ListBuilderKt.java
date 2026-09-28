package kotlin.collections.builders;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ListBuilderKt {
    public static final boolean a(Object[] objArr, int i2, int i3, List list) {
        if (i3 == list.size()) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (Intrinsics.b(objArr[i2 + i4], list.get(i4))) {
                }
            }
            return true;
        }
        return false;
    }

    public static final String b(Object[] objArr, int i2, int i3, AbstractMutableList abstractMutableList) {
        StringBuilder sb = new StringBuilder((i3 * 3) + 2);
        sb.append("[");
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i2 + i4];
            if (obj == abstractMutableList) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final void c(Object[] objArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        while (i2 < i3) {
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            objArr[i2] = null;
            i2++;
        }
    }
}
