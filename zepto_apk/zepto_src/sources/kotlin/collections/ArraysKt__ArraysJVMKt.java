package kotlin.collections;

import android.support.v4.media.b;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
class ArraysKt__ArraysJVMKt {
    public static final void a(int i2, int i3) {
        if (i2 > i3) {
            throw new IndexOutOfBoundsException(b.e(i2, i3, "toIndex (", ") is greater than size (", ")."));
        }
    }
}
