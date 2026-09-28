package io.ktor.utils.io.core;

import android.support.v4.media.b;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.EncodeResult;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.xbill.DNS.TTL;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StringsKt {
    public static final void a(int i2) throws EOFException {
        throw new EOFException(b.g(i2, "Premature end of stream: expected ", " bytes"));
    }

    public static final byte[] b(ByteReadPacket byteReadPacket, int i2) throws Throwable {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (i2 == 0) {
            return UnsafeKt.f51229a;
        }
        byte[] dst = new byte[i2];
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferB = UnsafeKt.b(byteReadPacket, 1);
        if (chunkBufferB != null) {
            int i3 = 0;
            while (true) {
                try {
                    int iMin = Math.min(i2, chunkBufferB.f51182c - chunkBufferB.f51181b);
                    BufferPrimitivesKt.a(chunkBufferB, dst, i3, iMin);
                    i2 -= iMin;
                    i3 += iMin;
                    if (i2 <= 0) {
                        UnsafeKt.a(byteReadPacket, chunkBufferB);
                        break;
                    }
                    try {
                        chunkBufferB = UnsafeKt.c(byteReadPacket, chunkBufferB);
                        if (chunkBufferB == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (z) {
                            UnsafeKt.a(byteReadPacket, chunkBufferB);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        if (i2 <= 0) {
            return dst;
        }
        a(i2);
        throw null;
    }

    public static /* synthetic */ byte[] c(ByteReadPacket byteReadPacket) {
        long jD = byteReadPacket.D();
        if (jD <= TTL.MAX_VALUE) {
            return b(byteReadPacket, (int) jD);
        }
        throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
    }

    public static String d(ByteReadPacket byteReadPacket, Charset charset) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        return EncodingKt.a(charsetDecoderNewDecoder, byteReadPacket);
    }

    public static final void e(Output output, CharSequence text, int i2, int i3, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset != Charsets.UTF_8) {
            CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
            EncodingKt.c(charsetEncoderNewEncoder, output, text, i2, i3);
            return;
        }
        ChunkBuffer chunkBufferD = UnsafeKt.d(output, 1, null);
        int i4 = i2;
        while (true) {
            try {
                CharSequence charSequence = text;
                int i5 = i3;
                int iB = UTF8Kt.b(chunkBufferD.f51180a, charSequence, i4, i5, chunkBufferD.f51182c, chunkBufferD.f51184e);
                int iA = EncodeResult.a(iB) & 65535;
                i4 += iA;
                chunkBufferD.a(EncodeResult.b(iB) & 65535);
                int i6 = (iA != 0 || i4 >= i5) ? i4 < i5 ? 1 : 0 : 8;
                if (i6 <= 0) {
                    return;
                }
                chunkBufferD = UnsafeKt.d(output, i6, chunkBufferD);
                text = charSequence;
                i3 = i5;
            } finally {
                output.a();
            }
        }
    }
}
