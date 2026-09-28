package co.touchlab.kermit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JvmInline
/* loaded from: classes3.dex */
public final class Tag {
    public static void a(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Tag)) {
            return false;
        }
        ((Tag) obj).getClass();
        return Intrinsics.b(null, null);
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "Tag(tag=null)";
    }
}
