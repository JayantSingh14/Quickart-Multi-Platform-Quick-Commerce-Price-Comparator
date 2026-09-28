package io.ktor.utils.io.core.internal;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CharArraySequence implements CharSequence {
    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        if (i2 < 0) {
            throw null;
        }
        throw new IndexOutOfBoundsException(b.g(i2, "String index out of bounds: ", " > 0"));
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return 0;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "startIndex shouldn't be negative: ").toString());
        }
        if (i2 > 0) {
            throw new IllegalArgumentException(b.g(i2, "startIndex is too large: ", " > 0").toString());
        }
        if (i2 + i3 > 0) {
            throw new IllegalArgumentException(b.g(i3, "endIndex is too large: ", " > 0").toString());
        }
        if (i3 >= i2) {
            throw null;
        }
        throw new IllegalArgumentException(b.d(i2, i3, "endIndex should be greater or equal to startIndex: ", " > ").toString());
    }
}
