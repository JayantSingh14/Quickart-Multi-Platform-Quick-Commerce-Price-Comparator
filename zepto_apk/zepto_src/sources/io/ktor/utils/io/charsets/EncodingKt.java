package io.ktor.utils.io.charsets;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EncodingKt {
    /* JADX WARN: Removed duplicated region for block: B:75:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String a(java.nio.charset.CharsetDecoder r14, io.ktor.utils.io.core.ByteReadPacket r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.EncodingKt.a(java.nio.charset.CharsetDecoder, io.ktor.utils.io.core.ByteReadPacket):java.lang.String");
    }

    public static final ByteReadPacket b(CharsetEncoder charsetEncoder, String input, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(0);
        try {
            c(charsetEncoder, bytePacketBuilder, input, i2, i3);
            return bytePacketBuilder.V();
        } catch (Throwable th) {
            bytePacketBuilder.close();
            throw th;
        }
    }

    public static final void c(CharsetEncoder charsetEncoder, Output destination, CharSequence input, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i2 >= i3) {
            return;
        }
        ChunkBuffer chunkBufferD = UnsafeKt.d(destination, 1, null);
        while (true) {
            try {
                int iB = CharsetJVMKt.b(charsetEncoder, input, i2, i3, chunkBufferD);
                if (iB < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                i2 += iB;
                int i4 = i2 >= i3 ? 0 : iB == 0 ? 8 : 1;
                if (i4 > 0) {
                    chunkBufferD = UnsafeKt.d(destination, i4, chunkBufferD);
                } else {
                    destination.a();
                    ChunkBuffer chunkBufferD2 = UnsafeKt.d(destination, 1, null);
                    int i5 = 1;
                    while (true) {
                        try {
                            i5 = CharsetJVMKt.a(charsetEncoder, chunkBufferD2) ? 0 : i5 + 1;
                            if (i5 <= 0) {
                                return;
                            } else {
                                chunkBufferD2 = UnsafeKt.d(destination, 1, chunkBufferD2);
                            }
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }
}
