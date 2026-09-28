package androidx.collection;

import android.support.v4.media.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ObjectListKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Object[] f1553a = new Object[0];

    static {
        new MutableObjectList(0);
    }

    public static final void a(int i2, List list) {
        int size = list.size();
        if (i2 < 0 || i2 >= size) {
            throw new IndexOutOfBoundsException(b.e(i2, size, "Index ", " is out of bounds. The list has ", " elements."));
        }
    }

    public static final void b(int i2, int i3, List list) {
        int size = list.size();
        if (i2 > i3) {
            throw new IllegalArgumentException(b.e(i2, i3, "Indices are out of order. fromIndex (", ") is greater than toIndex (", ")."));
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(b.g(i2, "fromIndex (", ") is less than 0."));
        }
        if (i3 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is more than than the list size (" + size + ')');
    }
}
