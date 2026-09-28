package kotlin.collections;

import android.support.v4.media.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static final List a(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : CollectionsKt.H(list.get(0)) : EmptyList.f53609a;
    }

    public static final void b(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException(b.g(i3, "fromIndex (0) is greater than toIndex (", ")."));
        }
        if (i3 > i2) {
            throw new IndexOutOfBoundsException(b.e(i3, i2, "toIndex (", ") is greater than size (", ")."));
        }
    }
}
