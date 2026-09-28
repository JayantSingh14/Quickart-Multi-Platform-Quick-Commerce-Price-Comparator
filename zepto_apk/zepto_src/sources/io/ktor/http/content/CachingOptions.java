package io.ktor.http.content;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class CachingOptions {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachingOptions)) {
            return false;
        }
        ((CachingOptions) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "CachingOptions(cacheControl=null, expires=null)";
    }
}
