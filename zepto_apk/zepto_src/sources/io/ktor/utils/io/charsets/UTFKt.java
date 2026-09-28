package io.ktor.utils.io.charsets;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UTFKt {
    public static final long a(int i2, int i3) {
        return (i3 & 4294967295L) | (i2 << 32);
    }

    public static final IndexOutOfBoundsException b(int i2, int i3) {
        return new IndexOutOfBoundsException(b.e(i2, i3, "0 (offset) + ", " (length) > ", " (array.length)"));
    }

    public static final void c(int i2) {
        throw new IllegalArgumentException("Malformed code-point " + Integer.toHexString(i2) + " found");
    }

    public static final void d(byte b2) {
        StringBuilder sb = new StringBuilder("Unsupported byte code, first byte is 0x");
        String string = Integer.toString(b2 & 255, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        sb.append(kotlin.text.StringsKt.D(2, string));
        throw new IllegalStateException(sb.toString().toString());
    }
}
