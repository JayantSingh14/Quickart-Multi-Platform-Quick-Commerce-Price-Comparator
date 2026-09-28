package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@JvmInline
@SourceDebugExtension
/* loaded from: classes.dex */
public final class InlineList<E> {
    public static final Object a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof InlineList)) {
            return false;
        }
        ((InlineList) obj).getClass();
        return Intrinsics.b(null, null);
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "InlineList(holder=null)";
    }
}
