package com.bumptech.glide.load.resource.bitmap;

import android.support.v4.media.b;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f16262a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f16263b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static final class ByteBufferReader implements Reader {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f16264a;

        public ByteBufferReader(ByteBuffer byteBuffer) {
            this.f16264a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final int a() {
            return (b() << 8) | b();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final short b() throws Reader.EndOfFileException {
            ByteBuffer byteBuffer = this.f16264a;
            if (byteBuffer.remaining() >= 1) {
                return (short) (byteBuffer.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final long skip(long j2) {
            ByteBuffer byteBuffer = this.f16264a;
            int iMin = (int) Math.min(byteBuffer.remaining(), j2);
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    public static final class RandomAccessReader {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f16265a;

        public RandomAccessReader(byte[] bArr, int i2) {
            this.f16265a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        public final short a(int i2) {
            ByteBuffer byteBuffer = this.f16265a;
            if (byteBuffer.remaining() - i2 >= 2) {
                return byteBuffer.getShort(i2);
            }
            return (short) -1;
        }
    }

    public interface Reader {

        public static final class EndOfFileException extends IOException {
            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a();

        short b();

        long skip(long j2);
    }

    public static final class StreamReader implements Reader {

        /* renamed from: a, reason: collision with root package name */
        public final InputStream f16266a;

        public StreamReader(InputStream inputStream) {
            this.f16266a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final int a() {
            return (b() << 8) | b();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final short b() throws IOException {
            int i2 = this.f16266a.read();
            if (i2 != -1) {
                return (short) i2;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public final long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                InputStream inputStream = this.f16266a;
                long jSkip = inputStream.skip(j3);
                if (jSkip > 0) {
                    j3 -= jSkip;
                } else {
                    if (inputStream.read() == -1) {
                        break;
                    }
                    j3--;
                }
            }
            return j2 - j3;
        }
    }

    public static ImageHeaderParser.ImageType d(Reader reader) {
        try {
            int iA = reader.a();
            if (iA == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iB = (iA << 8) | reader.b();
            if (iB == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iB2 = (iB << 8) | reader.b();
            if (iB2 == -1991225785) {
                reader.skip(21L);
                try {
                    return reader.b() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iB2 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            reader.skip(4L);
            if (((reader.a() << 16) | reader.a()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iA2 = (reader.a() << 16) | reader.a();
            if ((iA2 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = iA2 & 255;
            if (i2 == 88) {
                reader.skip(4L);
                return (reader.b() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i2 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            }
            reader.skip(4L);
            return (reader.b() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.StreamReader r9) throws java.io.IOException {
        /*
        L0:
            short r0 = r9.b()
            r1 = 255(0xff, float:3.57E-43)
            r2 = 3
            r3 = -1
            java.lang.String r4 = "DfltImageHeaderParser"
            if (r0 == r1) goto L24
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L6a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown segmentId="
            r9.<init>(r1)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
            return r3
        L24:
            short r0 = r9.b()
            r1 = 218(0xda, float:3.05E-43)
            if (r0 != r1) goto L2d
            goto L6a
        L2d:
            r1 = 217(0xd9, float:3.04E-43)
            if (r0 != r1) goto L3d
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L6a
            java.lang.String r9 = "Found MARKER_EOI in exif segment"
            android.util.Log.d(r4, r9)
            return r3
        L3d:
            int r1 = r9.a()
            int r1 = r1 + (-2)
            r5 = 225(0xe1, float:3.15E-43)
            if (r0 == r5) goto L6b
            long r5 = (long) r1
            long r7 = r9.skip(r5)
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 == 0) goto L0
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L6a
            java.lang.String r9 = "Unable to skip enough data, type: "
            java.lang.String r2 = ", wanted to skip: "
            java.lang.String r5 = ", but actually skipped: "
            java.lang.StringBuilder r9 = android.support.v4.media.b.t(r0, r1, r9, r2, r5)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
        L6a:
            return r3
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.e(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$StreamReader):int");
    }

    public static int f(StreamReader streamReader, byte[] bArr, int i2) throws Reader.EndOfFileException {
        ByteOrder byteOrder;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2 && (i5 = streamReader.f16266a.read(bArr, i4, i2 - i4)) != -1) {
            i4 += i5;
        }
        if (i4 == 0 && i5 == -1) {
            throw new Reader.EndOfFileException();
        }
        if (i4 == i2) {
            short s = 1;
            byte[] bArr2 = f16262a;
            boolean z = bArr != null && i2 > bArr2.length;
            if (z) {
                int i6 = 0;
                while (true) {
                    if (i6 >= bArr2.length) {
                        break;
                    }
                    if (bArr[i6] != bArr2[i6]) {
                        z = false;
                        break;
                    }
                    i6++;
                }
            }
            if (z) {
                RandomAccessReader randomAccessReader = new RandomAccessReader(bArr, i2);
                short sA = randomAccessReader.a(6);
                if (sA != 18761) {
                    if (sA != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sA));
                    }
                    byteOrder = ByteOrder.BIG_ENDIAN;
                } else {
                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                }
                ByteBuffer byteBuffer = randomAccessReader.f16265a;
                byteBuffer.order(byteOrder);
                int i7 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
                short sA2 = randomAccessReader.a(i7 + 6);
                while (i3 < sA2) {
                    int i8 = (i3 * 12) + i7 + 8;
                    short sA3 = randomAccessReader.a(i8);
                    if (sA3 == 274) {
                        short sA4 = randomAccessReader.a(i8 + 2);
                        if (sA4 >= s && sA4 <= 12) {
                            int i9 = i8 + 4;
                            int i10 = byteBuffer.remaining() - i9 >= 4 ? byteBuffer.getInt(i9) : -1;
                            if (i10 >= 0) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    StringBuilder sbT = b.t(i3, sA3, "Got tagIndex=", " tagType=", " formatCode=");
                                    sbT.append((int) sA4);
                                    sbT.append(" componentCount=");
                                    sbT.append(i10);
                                    Log.d("DfltImageHeaderParser", sbT.toString());
                                }
                                int i11 = i10 + f16263b[sA4];
                                if (i11 <= 4) {
                                    int i12 = i8 + 8;
                                    if (i12 < 0 || i12 > byteBuffer.remaining()) {
                                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                            Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i12 + " tagType=" + ((int) sA3));
                                        }
                                    } else {
                                        if (i11 >= 0 && i11 + i12 <= byteBuffer.remaining()) {
                                            return randomAccessReader.a(i12);
                                        }
                                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                            Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                        }
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Negative tiff component count");
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sA4));
                        }
                    }
                    i3++;
                    s = 1;
                }
            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i2 + ", actually read: " + i4);
            return -1;
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final int a(InputStream inputStream, LruArrayPool lruArrayPool) throws IOException {
        StreamReader streamReader = new StreamReader(inputStream);
        Preconditions.c(lruArrayPool, "Argument must not be null");
        try {
            int iA = streamReader.a();
            if ((iA & 65496) == 65496 || iA == 19789 || iA == 18761) {
                int iE = e(streamReader);
                if (iE != -1) {
                    byte[] bArr = (byte[]) lruArrayPool.d(byte[].class, iE);
                    try {
                        return f(streamReader, bArr, iE);
                    } finally {
                        lruArrayPool.i(bArr);
                    }
                }
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                    return -1;
                }
            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iA);
                return -1;
            }
        } catch (Reader.EndOfFileException unused) {
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType b(ByteBuffer byteBuffer) {
        Preconditions.c(byteBuffer, "Argument must not be null");
        return d(new ByteBufferReader(byteBuffer));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType c(InputStream inputStream) {
        return d(new StreamReader(inputStream));
    }
}
