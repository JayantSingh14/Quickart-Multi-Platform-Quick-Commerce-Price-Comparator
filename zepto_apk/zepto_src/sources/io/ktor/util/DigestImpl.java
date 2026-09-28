package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JvmInline
/* loaded from: classes3.dex */
final class DigestImpl implements Digest {
    public final boolean equals(Object obj) {
        if (!(obj instanceof DigestImpl)) {
            return false;
        }
        ((DigestImpl) obj).getClass();
        return Intrinsics.b(null, null);
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "DigestImpl(delegate=null)";
    }
}
