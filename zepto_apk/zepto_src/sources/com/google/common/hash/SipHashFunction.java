package com.google.common.hash;

import android.support.v4.media.b;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {

    public static final class SipHasher extends AbstractStreamingHasher {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        ((SipHashFunction) obj).getClass();
        return 0 == 0 && 0 == 0;
    }

    public final int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ 0) ^ 0) ^ 0) ^ 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Hashing.sipHash");
        sb.append(0);
        sb.append("");
        sb.append(0);
        sb.append("(");
        sb.append(0L);
        sb.append(", ");
        return b.p(sb, 0L, ")");
    }
}
