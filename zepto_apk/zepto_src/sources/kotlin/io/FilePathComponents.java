package kotlin.io;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class FilePathComponents {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePathComponents)) {
            return false;
        }
        ((FilePathComponents) obj).getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "FilePathComponents(root=null, segments=null)";
    }
}
