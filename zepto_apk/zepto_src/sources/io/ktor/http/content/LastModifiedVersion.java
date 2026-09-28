package io.ktor.http.content;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class LastModifiedVersion implements Version {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LastModifiedVersion)) {
            return false;
        }
        ((LastModifiedVersion) obj).getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "LastModifiedVersion(lastModified=null)";
    }
}
