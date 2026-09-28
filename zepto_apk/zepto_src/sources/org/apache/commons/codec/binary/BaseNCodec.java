package org.apache.commons.codec.binary;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.util.Arrays;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes5.dex */
public abstract class BaseNCodec implements BinaryEncoder, BinaryDecoder {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    private static final int MAX_BUFFER_SIZE = 2147483639;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;

    @Deprecated
    protected final byte PAD;
    private final int chunkSeparatorLength;
    private final int encodedBlockSize;
    protected final int lineLength;
    protected final byte pad;
    private final int unencodedBlockSize;

    public static class Context {
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        public String toString() {
            String simpleName = getClass().getSimpleName();
            String string = Arrays.toString(this.buffer);
            int i2 = this.currentLinePos;
            boolean z = this.eof;
            int i3 = this.ibitWorkArea;
            long j2 = this.lbitWorkArea;
            int i4 = this.modulus;
            int i5 = this.pos;
            int i6 = this.readPos;
            StringBuilder sb = new StringBuilder();
            sb.append(simpleName);
            sb.append("[buffer=");
            sb.append(string);
            sb.append(", currentLinePos=");
            sb.append(i2);
            sb.append(", eof=");
            sb.append(z);
            sb.append(", ibitWorkArea=");
            sb.append(i3);
            e.A(sb, ", lbitWorkArea=", j2, ", modulus=");
            a.q(i4, i5, ", pos=", ", readPos=", sb);
            return b.o(sb, i6, "]");
        }
    }

    public BaseNCodec(int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5, PAD_DEFAULT);
    }

    private static int compareUnsigned(int i2, int i3) {
        return Integer.compare(i2 - Integer.MIN_VALUE, i3 - Integer.MIN_VALUE);
    }

    private static int createPositiveCapacity(int i2) {
        if (i2 >= 0) {
            return i2 > MAX_BUFFER_SIZE ? i2 : MAX_BUFFER_SIZE;
        }
        throw new OutOfMemoryError("Unable to allocate array size: " + (i2 & 4294967295L));
    }

    public static boolean isWhiteSpace(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private static byte[] resizeBuffer(Context context, int i2) {
        int length = context.buffer.length * 2;
        if (compareUnsigned(length, i2) < 0) {
            length = i2;
        }
        if (compareUnsigned(length, MAX_BUFFER_SIZE) > 0) {
            length = createPositiveCapacity(i2);
        }
        byte[] bArr = new byte[length];
        byte[] bArr2 = context.buffer;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        context.buffer = bArr;
        return bArr;
    }

    public int available(Context context) {
        if (context.buffer != null) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    public boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (this.pad == b2 || isInAlphabet(b2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public abstract void decode(byte[] bArr, int i2, int i3, Context context);

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public abstract void encode(byte[] bArr, int i2, int i3, Context context);

    public String encodeAsString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public byte[] ensureBufferSize(int i2, Context context) {
        byte[] bArr = context.buffer;
        if (bArr == null) {
            context.buffer = new byte[getDefaultBufferSize()];
            context.pos = 0;
            context.readPos = 0;
        } else {
            int i3 = context.pos;
            if ((i3 + i2) - bArr.length > 0) {
                return resizeBuffer(context, i3 + i2);
            }
        }
        return context.buffer;
    }

    public int getDefaultBufferSize() {
        return 8192;
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.unencodedBlockSize;
        long j2 = (((length + i2) - 1) / i2) * this.encodedBlockSize;
        int i3 = this.lineLength;
        return i3 > 0 ? ((((i3 + j2) - 1) / i3) * this.chunkSeparatorLength) + j2 : j2;
    }

    public boolean hasData(Context context) {
        return context.buffer != null;
    }

    public abstract boolean isInAlphabet(byte b2);

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        for (byte b2 : bArr) {
            if (!isInAlphabet(b2) && (!z || (b2 != this.pad && !isWhiteSpace(b2)))) {
                return false;
            }
        }
        return true;
    }

    public int readResults(byte[] bArr, int i2, int i3, Context context) {
        if (context.buffer == null) {
            return context.eof ? -1 : 0;
        }
        int iMin = Math.min(available(context), i3);
        System.arraycopy(context.buffer, context.readPos, bArr, i2, iMin);
        int i4 = context.readPos + iMin;
        context.readPos = i4;
        if (i4 >= context.pos) {
            context.buffer = null;
        }
        return iMin;
    }

    public BaseNCodec(int i2, int i3, int i4, int i5, byte b2) {
        this.PAD = PAD_DEFAULT;
        this.unencodedBlockSize = i2;
        this.encodedBlockSize = i3;
        this.lineLength = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.chunkSeparatorLength = i5;
        this.pad = b2;
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : encode(bArr, 0, bArr.length);
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(StringUtils.getBytesUtf8(str), true);
    }

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    public byte[] encode(byte[] bArr, int i2, int i3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        encode(bArr, i2, i3, context);
        encode(bArr, i2, -1, context);
        int i4 = context.pos - context.readPos;
        byte[] bArr2 = new byte[i4];
        readResults(bArr2, 0, i4, context);
        return bArr2;
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        decode(bArr, 0, bArr.length, context);
        decode(bArr, 0, -1, context);
        int i2 = context.pos;
        byte[] bArr2 = new byte[i2];
        readResults(bArr2, 0, i2, context);
        return bArr2;
    }
}
