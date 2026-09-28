package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class Crc32cHashFunction extends AbstractHashFunction {

    public static final class Crc32cHasher extends AbstractStreamingHasher {
        static {
            ByteBuffer.allocate(0);
        }
    }

    public final String toString() {
        return "Hashing.crc32c()";
    }
}
