package androidx.room.util;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@JvmName
@RestrictTo
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class StringUtil {
    public static final void a(int i2, StringBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        for (int i3 = 0; i3 < i2; i3++) {
            builder.append("?");
            if (i3 < i2 - 1) {
                builder.append(",");
            }
        }
    }

    public static final StringBuilder b() {
        return new StringBuilder();
    }
}
