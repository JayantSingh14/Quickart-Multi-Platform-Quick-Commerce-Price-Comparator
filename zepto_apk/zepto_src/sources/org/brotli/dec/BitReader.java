package org.brotli.dec;

import okio.RealBufferedSource$inputStream$1;

/* loaded from: classes5.dex */
final class BitReader {

    /* renamed from: d, reason: collision with root package name */
    public RealBufferedSource$inputStream$1 f57398d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f57399e;

    /* renamed from: f, reason: collision with root package name */
    public long f57400f;

    /* renamed from: g, reason: collision with root package name */
    public int f57401g;

    /* renamed from: h, reason: collision with root package name */
    public int f57402h;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f57395a = new byte[4160];

    /* renamed from: b, reason: collision with root package name */
    public final int[] f57396b = new int[1040];

    /* renamed from: c, reason: collision with root package name */
    public final IntReader f57397c = new IntReader();

    /* renamed from: i, reason: collision with root package name */
    public int f57403i = 0;

    public static void a(BitReader bitReader, boolean z) {
        if (bitReader.f57399e) {
            int i2 = ((bitReader.f57402h << 2) + ((bitReader.f57401g + 7) >> 3)) - 8;
            int i3 = bitReader.f57403i;
            if (i2 > i3) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i2 != i3) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(BitReader bitReader) {
        int i2 = bitReader.f57401g;
        if (i2 >= 32) {
            bitReader.f57402h = bitReader.f57402h + 1;
            bitReader.f57400f = (bitReader.f57396b[r2] << 32) | (bitReader.f57400f >>> 32);
            bitReader.f57401g = i2 - 32;
        }
    }

    public static int c(BitReader bitReader) {
        return (bitReader.f57399e ? (bitReader.f57403i + 3) >> 2 : 1024) - bitReader.f57402h;
    }

    public static int d(BitReader bitReader, int i2) {
        b(bitReader);
        long j2 = bitReader.f57400f;
        int i3 = bitReader.f57401g;
        int i4 = ((int) (j2 >>> i3)) & ((1 << i2) - 1);
        bitReader.f57401g = i3 + i2;
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        r7.f57399e = true;
        r7.f57403i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
    
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(org.brotli.dec.BitReader r7) {
        /*
            int r0 = r7.f57402h
            r1 = 1015(0x3f7, float:1.422E-42)
            if (r0 > r1) goto L8
            goto L79
        L8:
            boolean r1 = r7.f57399e
            if (r1 == 0) goto L1c
            int r7 = c(r7)
            r0 = -2
            if (r7 < r0) goto L14
            goto L79
        L14:
            org.brotli.dec.BrotliRuntimeException r7 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r0 = "No more input"
            r7.<init>(r0)
            throw r7
        L1c:
            int r0 = r0 << 2
            int r1 = 4096 - r0
            byte[] r2 = r7.f57395a
            r3 = 0
            java.lang.System.arraycopy(r2, r0, r2, r3, r1)
            r7.f57402h = r3
        L28:
            r0 = 4096(0x1000, float:5.74E-42)
            if (r1 >= r0) goto L49
            okio.RealBufferedSource$inputStream$1 r0 = r7.f57398d     // Catch: java.io.IOException -> L40
            int r4 = 4096 - r1
            int r0 = r0.read(r2, r1, r4)     // Catch: java.io.IOException -> L40
            if (r0 > 0) goto L3e
            r0 = 1
            r7.f57399e = r0     // Catch: java.io.IOException -> L40
            r7.f57403i = r1     // Catch: java.io.IOException -> L40
            int r1 = r1 + 3
            goto L49
        L3e:
            int r1 = r1 + r0
            goto L28
        L40:
            r7 = move-exception
            org.brotli.dec.BrotliRuntimeException r0 = new org.brotli.dec.BrotliRuntimeException
            java.lang.String r1 = "Failed to read input"
            r0.<init>(r1, r7)
            throw r0
        L49:
            int r0 = r1 >> 2
        L4b:
            if (r3 >= r0) goto L79
            org.brotli.dec.IntReader r1 = r7.f57397c
            int[] r2 = r1.f57421b
            byte[] r1 = r1.f57420a
            int r4 = r3 * 4
            r5 = r1[r4]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r6 = r4 + 1
            r6 = r1[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            r5 = r5 | r6
            int r6 = r4 + 2
            r6 = r1[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 16
            r5 = r5 | r6
            int r4 = r4 + 3
            r1 = r1[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 24
            r1 = r1 | r5
            r2[r3] = r1
            int r3 = r3 + 1
            goto L4b
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.brotli.dec.BitReader.e(org.brotli.dec.BitReader):void");
    }
}
