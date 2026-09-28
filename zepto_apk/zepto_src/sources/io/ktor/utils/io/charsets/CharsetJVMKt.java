package io.ktor.utils.io.charsets;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CharsetJVMKt {

    /* renamed from: a, reason: collision with root package name */
    public static final CharBuffer f51177a = CharBuffer.allocate(0);

    /* renamed from: b, reason: collision with root package name */
    public static final ByteBuffer f51178b;

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        Intrinsics.c(byteBufferAllocate);
        f51178b = byteBufferAllocate;
    }

    public static final boolean a(CharsetEncoder charsetEncoder, ChunkBuffer dst) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int i2 = dst.f51182c;
        int i3 = dst.f51184e - i2;
        ByteBuffer byteBufferC = Memory.c(dst.f51180a, i2, i3);
        CoderResult result = charsetEncoder.encode(f51177a, byteBufferC, true);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            e(result);
        }
        boolean zIsUnderflow = result.isUnderflow();
        if (byteBufferC.limit() != i3) {
            throw new IllegalStateException("Buffer's limit change is not allowed");
        }
        dst.a(byteBufferC.position());
        return zIsUnderflow;
    }

    public static final int b(CharsetEncoder charsetEncoder, CharSequence input, int i2, int i3, ChunkBuffer dst) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        CharBuffer charBufferWrap = CharBuffer.wrap(input, i2, i3);
        int iRemaining = charBufferWrap.remaining();
        int i4 = dst.f51182c;
        int i5 = dst.f51184e - i4;
        ByteBuffer byteBufferC = Memory.c(dst.f51180a, i4, i5);
        CoderResult result = charsetEncoder.encode(charBufferWrap, byteBufferC, false);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            e(result);
        }
        if (byteBufferC.limit() != i5) {
            throw new IllegalStateException("Buffer's limit change is not allowed");
        }
        dst.a(byteBufferC.position());
        return iRemaining - charBufferWrap.remaining();
    }

    public static final byte[] c(CharsetEncoder charsetEncoder, CharSequence input, int i2) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (input instanceof String) {
            if (i2 == ((String) input).length()) {
                byte[] bytes = ((String) input).getBytes(charsetEncoder.charset());
                Intrinsics.checkNotNullExpressionValue(bytes, "input as java.lang.String).getBytes(charset())");
                return bytes;
            }
            String strSubstring = ((String) input).substring(0, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Intrinsics.d(strSubstring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes2 = strSubstring.getBytes(charsetEncoder.charset());
            Intrinsics.checkNotNullExpressionValue(bytes2, "input.substring(fromInde…ring).getBytes(charset())");
            return bytes2;
        }
        ByteBuffer byteBufferEncode = charsetEncoder.encode(CharBuffer.wrap(input, 0, i2));
        byte[] bArr = null;
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            byte[] bArrArray = byteBufferEncode.array();
            if (bArrArray.length == byteBufferEncode.remaining()) {
                bArr = bArrArray;
            }
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr2);
        return bArr2;
    }

    public static final String d(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        String strName = charset.name();
        Intrinsics.checkNotNullExpressionValue(strName, "name()");
        return strName;
    }

    public static final void e(CoderResult coderResult) throws CharacterCodingException {
        try {
            coderResult.throwException();
        } catch (java.nio.charset.MalformedInputException e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new MalformedInputException(message);
        }
    }
}
