package androidx.collection;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@JvmInline
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class IntIntPair {
    public final boolean equals(Object obj) {
        if (!(obj instanceof IntIntPair)) {
            return false;
        }
        ((IntIntPair) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(0L);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append((int) 0);
        sb.append(", ");
        return b.n(sb, (int) 0, ')');
    }
}
