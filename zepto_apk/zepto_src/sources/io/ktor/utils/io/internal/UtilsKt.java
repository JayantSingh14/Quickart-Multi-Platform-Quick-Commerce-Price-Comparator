package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class UtilsKt {
    public static final int a(int i2, String name) {
        String property;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            property = System.getProperty("io.ktor.utils.io.".concat(name));
        } catch (SecurityException unused) {
            property = null;
        }
        return (property == null || (intOrNull = kotlin.text.StringsKt.toIntOrNull(property)) == null) ? i2 : intOrNull.intValue();
    }

    public static final int b(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(null, "sub");
        throw null;
    }
}
