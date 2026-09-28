package androidx.room.util;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public final class ViewInfo {

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        viewInfo.getClass();
        viewInfo.getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "ViewInfo{name='null', sql='null'}";
    }
}
