package io.ktor.http.content;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class EntityTagVersion implements Version {

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    static {
        Intrinsics.checkNotNullParameter("*", "etag");
        "*".charAt(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntityTagVersion)) {
            return false;
        }
        ((EntityTagVersion) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return 1302;
    }

    public final String toString() {
        return "EntityTagVersion(etag=*, weak=false)";
    }
}
