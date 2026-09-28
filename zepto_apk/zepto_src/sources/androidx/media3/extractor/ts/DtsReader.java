package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicInteger;
import org.xbill.DNS.Message;

@UnstableApi
/* loaded from: classes3.dex */
public final class DtsReader implements ElementaryStreamReader {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f9540a;

    /* renamed from: c, reason: collision with root package name */
    public final String f9542c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9543d;

    /* renamed from: e, reason: collision with root package name */
    public String f9544e;

    /* renamed from: f, reason: collision with root package name */
    public TrackOutput f9545f;

    /* renamed from: h, reason: collision with root package name */
    public int f9547h;

    /* renamed from: i, reason: collision with root package name */
    public int f9548i;

    /* renamed from: j, reason: collision with root package name */
    public long f9549j;

    /* renamed from: k, reason: collision with root package name */
    public Format f9550k;

    /* renamed from: l, reason: collision with root package name */
    public int f9551l;

    /* renamed from: m, reason: collision with root package name */
    public int f9552m;

    /* renamed from: g, reason: collision with root package name */
    public int f9546g = 0;
    public long p = -9223372036854775807L;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f9541b = new AtomicInteger();
    public int n = -1;
    public int o = -1;

    public DtsReader(String str, int i2, int i3) {
        this.f9540a = new ParsableByteArray(new byte[i3]);
        this.f9542c = str;
        this.f9543d = i2;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void a(ParsableByteArray parsableByteArray) throws ParserException {
        int i2;
        boolean z;
        int i3;
        byte b2;
        int i4;
        byte b3;
        int i5;
        byte b4;
        int i6;
        int i7;
        int iG;
        int iG2;
        int iG3;
        int i8;
        long jB0;
        int i9;
        int i10;
        long jB02;
        int iG4;
        int i11;
        int i12;
        int i13;
        int i14 = 4;
        Assertions.h(this.f9545f);
        while (parsableByteArray.a() > 0) {
            int i15 = this.f9546g;
            int i16 = 8;
            ParsableByteArray parsableByteArray2 = this.f9540a;
            switch (i15) {
                case 0:
                    while (parsableByteArray.a() > 0) {
                        int i17 = this.f9548i << 8;
                        this.f9548i = i17;
                        int iX = i17 | parsableByteArray.x();
                        this.f9548i = iX;
                        int i18 = (iX == 2147385345 || iX == -25230976 || iX == 536864768 || iX == -14745368) ? 1 : (iX == 1683496997 || iX == 622876772) ? 2 : (iX == 1078008818 || iX == -233094848) ? 3 : (iX == 1908687592 || iX == -398277519) ? 4 : 0;
                        this.f9552m = i18;
                        if (i18 != 0) {
                            byte[] bArr = parsableByteArray2.f5723a;
                            bArr[0] = (byte) ((iX >> 24) & 255);
                            bArr[1] = (byte) ((iX >> 16) & 255);
                            bArr[2] = (byte) ((iX >> 8) & 255);
                            bArr[3] = (byte) (iX & 255);
                            this.f9547h = 4;
                            this.f9548i = 0;
                            if (i18 == 3 || i18 == 4) {
                                this.f9546g = 4;
                            } else if (i18 == 1) {
                                this.f9546g = 1;
                            } else {
                                this.f9546g = 2;
                            }
                            i14 = 4;
                        }
                    }
                    i14 = 4;
                    break;
                case 1:
                    if (b(parsableByteArray, parsableByteArray2.f5723a, 18)) {
                        byte[] bArr2 = parsableByteArray2.f5723a;
                        if (this.f9550k == null) {
                            String str = this.f9544e;
                            ParsableBitArray parsableBitArrayA = DtsUtil.a(bArr2);
                            parsableBitArrayA.o(60);
                            int i19 = DtsUtil.f8534a[parsableBitArrayA.g(6)];
                            int i20 = DtsUtil.f8535b[parsableBitArrayA.g(4)];
                            int iG5 = parsableBitArrayA.g(5);
                            int i21 = iG5 >= 29 ? -1 : (DtsUtil.f8536c[iG5] * 1000) / 2;
                            parsableBitArrayA.o(10);
                            int i22 = i19 + (parsableBitArrayA.g(2) > 0 ? 1 : 0);
                            Format.Builder builder = new Format.Builder();
                            builder.f5226a = str;
                            builder.f5237l = MimeTypes.p("audio/vnd.dts");
                            builder.f5232g = i21;
                            builder.z = i22;
                            builder.A = i20;
                            builder.p = null;
                            builder.f5229d = this.f9542c;
                            builder.f5231f = this.f9543d;
                            Format format = new Format(builder);
                            this.f9550k = format;
                            this.f9545f.b(format);
                        }
                        byte b5 = bArr2[0];
                        if (b5 != -2) {
                            if (b5 == -1) {
                                i5 = ((bArr2[7] & 3) << 12) | ((bArr2[6] & 255) << 4);
                                b4 = bArr2[9];
                            } else if (b5 != 31) {
                                i2 = (((bArr2[5] & 3) << 12) | ((bArr2[6] & 255) << 4) | ((bArr2[7] & 240) >> 4)) + 1;
                                z = false;
                            } else {
                                i5 = ((bArr2[6] & 3) << 12) | ((bArr2[7] & 255) << 4);
                                b4 = bArr2[8];
                            }
                            i2 = (i5 | ((b4 & 60) >> 2)) + 1;
                            z = true;
                        } else {
                            i2 = (((bArr2[4] & 3) << 12) | ((bArr2[7] & 255) << 4) | ((bArr2[6] & 240) >> 4)) + 1;
                            z = false;
                        }
                        if (z) {
                            i2 = (i2 * 16) / 14;
                        }
                        this.f9551l = i2;
                        if (b5 != -2) {
                            if (b5 == -1) {
                                i3 = (bArr2[4] & 7) << 4;
                                b3 = bArr2[7];
                            } else if (b5 != 31) {
                                i3 = (bArr2[4] & 1) << 6;
                                b2 = bArr2[5];
                            } else {
                                i3 = (bArr2[5] & 7) << 4;
                                b3 = bArr2[6];
                            }
                            i4 = b3 & 60;
                            this.f9549j = Ints.b(Util.Z(this.f9550k.B, (((i4 >> 2) | i3) + 1) * 32));
                            parsableByteArray2.J(0);
                            this.f9545f.e(18, parsableByteArray2);
                            this.f9546g = 6;
                        } else {
                            i3 = (bArr2[5] & 1) << 6;
                            b2 = bArr2[4];
                        }
                        i4 = b2 & 252;
                        this.f9549j = Ints.b(Util.Z(this.f9550k.B, (((i4 >> 2) | i3) + 1) * 32));
                        parsableByteArray2.J(0);
                        this.f9545f.e(18, parsableByteArray2);
                        this.f9546g = 6;
                    }
                    i14 = 4;
                case 2:
                    if (b(parsableByteArray, parsableByteArray2.f5723a, 7)) {
                        ParsableBitArray parsableBitArrayA2 = DtsUtil.a(parsableByteArray2.f5723a);
                        parsableBitArrayA2.o(42);
                        this.n = parsableBitArrayA2.g(parsableBitArrayA2.f() ? 12 : 8) + 1;
                        this.f9546g = 3;
                    }
                    i14 = 4;
                case 3:
                    int i23 = i14;
                    if (b(parsableByteArray, parsableByteArray2.f5723a, this.n)) {
                        ParsableBitArray parsableBitArrayA3 = DtsUtil.a(parsableByteArray2.f5723a);
                        parsableBitArrayA3.o(40);
                        int iG6 = parsableBitArrayA3.g(2);
                        if (parsableBitArrayA3.f()) {
                            i6 = 20;
                            i7 = 12;
                        } else {
                            i6 = 16;
                            i7 = 8;
                        }
                        parsableBitArrayA3.o(i7);
                        int iG7 = parsableBitArrayA3.g(i6) + 1;
                        boolean zF = parsableBitArrayA3.f();
                        if (zF) {
                            iG = parsableBitArrayA3.g(2);
                            iG2 = (parsableBitArrayA3.g(3) + 1) * 512;
                            if (parsableBitArrayA3.f()) {
                                parsableBitArrayA3.o(36);
                            }
                            int iG8 = parsableBitArrayA3.g(3) + 1;
                            int iG9 = parsableBitArrayA3.g(3) + 1;
                            if (iG8 != 1 || iG9 != 1) {
                                throw ParserException.c("Multiple audio presentations or assets not supported");
                            }
                            int i24 = iG6 + 1;
                            int iG10 = parsableBitArrayA3.g(i24);
                            int i25 = 0;
                            while (i25 < i24) {
                                if (((iG10 >> i25) & 1) == 1) {
                                    parsableBitArrayA3.o(i16);
                                }
                                i25++;
                                i16 = 8;
                            }
                            if (parsableBitArrayA3.f()) {
                                parsableBitArrayA3.o(2);
                                int iG11 = (parsableBitArrayA3.g(2) + 1) << 2;
                                int iG12 = parsableBitArrayA3.g(2) + 1;
                                for (int i26 = 0; i26 < iG12; i26++) {
                                    parsableBitArrayA3.o(iG11);
                                }
                            }
                        } else {
                            iG = -1;
                            iG2 = 0;
                        }
                        parsableBitArrayA3.o(i6);
                        parsableBitArrayA3.o(12);
                        if (zF) {
                            if (parsableBitArrayA3.f()) {
                                parsableBitArrayA3.o(i23);
                            }
                            if (parsableBitArrayA3.f()) {
                                parsableBitArrayA3.o(24);
                            }
                            if (parsableBitArrayA3.f()) {
                                parsableBitArrayA3.p(parsableBitArrayA3.g(10) + 1);
                            }
                            parsableBitArrayA3.o(5);
                            int i27 = DtsUtil.f8537d[parsableBitArrayA3.g(4)];
                            iG3 = parsableBitArrayA3.g(8) + 1;
                            i8 = i27;
                        } else {
                            iG3 = -1;
                            i8 = -2147483647;
                        }
                        if (zF) {
                            if (iG == 0) {
                                i9 = 32000;
                            } else if (iG == 1) {
                                i9 = 44100;
                            } else {
                                if (iG != 2) {
                                    throw ParserException.a(null, "Unsupported reference clock code in DTS HD header: " + iG);
                                }
                                i9 = 48000;
                            }
                            int i28 = Util.f5744a;
                            jB0 = Util.b0(iG2, 1000000L, i9, RoundingMode.FLOOR);
                        } else {
                            jB0 = -9223372036854775807L;
                        }
                        g(new DtsUtil.DtsHeader(jB0, iG3, "audio/vnd.dts.hd;profile=lbr", i8, iG7));
                        this.f9551l = iG7;
                        this.f9549j = jB0 == -9223372036854775807L ? 0L : jB0;
                        parsableByteArray2.J(0);
                        this.f9545f.e(this.n, parsableByteArray2);
                        this.f9546g = 6;
                    }
                    i14 = 4;
                    break;
                case 4:
                    i10 = i14;
                    if (b(parsableByteArray, parsableByteArray2.f5723a, 6)) {
                        ParsableBitArray parsableBitArrayA4 = DtsUtil.a(parsableByteArray2.f5723a);
                        parsableBitArrayA4.o(32);
                        int iB = DtsUtil.b(parsableBitArrayA4, DtsUtil.f8542i) + 1;
                        this.o = iB;
                        int i29 = this.f9547h;
                        if (i29 > iB) {
                            int i30 = i29 - iB;
                            this.f9547h = i29 - i30;
                            parsableByteArray.J(parsableByteArray.f5724b - i30);
                        }
                        this.f9546g = 5;
                    }
                    i14 = i10;
                case 5:
                    if (b(parsableByteArray, parsableByteArray2.f5723a, this.o)) {
                        byte[] bArr3 = parsableByteArray2.f5723a;
                        AtomicInteger atomicInteger = this.f9541b;
                        i10 = i14;
                        ParsableBitArray parsableBitArrayA5 = DtsUtil.a(bArr3);
                        int i31 = parsableBitArrayA5.g(32) == 1078008818 ? 1 : 0;
                        int iB2 = DtsUtil.b(parsableBitArrayA5, DtsUtil.f8538e);
                        int i32 = iB2 + 1;
                        if (i31 == 0) {
                            jB02 = -9223372036854775807L;
                            iG4 = -2147483647;
                        } else {
                            if (!parsableBitArrayA5.f()) {
                                throw ParserException.c("Only supports full channel mask-based audio presentation");
                            }
                            int i33 = iB2 - 1;
                            int i34 = ((bArr3[i33] << 8) & Message.MAXLENGTH) | (bArr3[iB2] & 255);
                            int i35 = Util.f5744a;
                            int i36 = 65535;
                            for (int i37 = 0; i37 < i33; i37++) {
                                byte b6 = bArr3[i37];
                                int i38 = (((b6 & 255) >> 4) ^ ((i36 >> 12) & 255)) & 255;
                                int i39 = (i36 << 4) & Message.MAXLENGTH;
                                int[] iArr = Util.p;
                                int i40 = (iArr[i38] ^ i39) & Message.MAXLENGTH;
                                i36 = (((i40 << 4) & Message.MAXLENGTH) ^ iArr[((b6 & 15) ^ ((i40 >> 12) & 255)) & 255]) & Message.MAXLENGTH;
                            }
                            if (i34 != i36) {
                                throw ParserException.a(null, "CRC check failed");
                            }
                            int iG13 = parsableBitArrayA5.g(2);
                            if (iG13 != 0) {
                                if (iG13 == 1) {
                                    i12 = 480;
                                } else {
                                    if (iG13 != 2) {
                                        throw ParserException.a(null, "Unsupported base duration index in DTS UHD header: " + iG13);
                                    }
                                    i12 = 384;
                                }
                                i11 = 3;
                            } else {
                                i11 = 3;
                                i12 = 512;
                            }
                            int iG14 = (parsableBitArrayA5.g(i11) + 1) * i12;
                            int iG15 = parsableBitArrayA5.g(2);
                            if (iG15 == 0) {
                                i13 = 32000;
                            } else if (iG15 == 1) {
                                i13 = 44100;
                            } else {
                                if (iG15 != 2) {
                                    throw ParserException.a(null, "Unsupported clock rate index in DTS UHD header: " + iG15);
                                }
                                i13 = 48000;
                            }
                            if (parsableBitArrayA5.f()) {
                                parsableBitArrayA5.o(36);
                            }
                            iG4 = i13 * (1 << parsableBitArrayA5.g(2));
                            jB02 = Util.b0(iG14, 1000000L, i13, RoundingMode.FLOOR);
                        }
                        int iB3 = 0;
                        for (int i41 = 0; i41 < i31; i41++) {
                            iB3 += DtsUtil.b(parsableBitArrayA5, DtsUtil.f8539f);
                        }
                        if (i31 != 0) {
                            atomicInteger.set(DtsUtil.b(parsableBitArrayA5, DtsUtil.f8540g));
                        }
                        int iB4 = iB3 + (atomicInteger.get() != 0 ? DtsUtil.b(parsableBitArrayA5, DtsUtil.f8541h) : 0) + i32;
                        DtsUtil.DtsHeader dtsHeader = new DtsUtil.DtsHeader(jB02, 2, "audio/vnd.dts.uhd;profile=p2", iG4, iB4);
                        if (this.f9552m == 3) {
                            g(dtsHeader);
                        }
                        this.f9551l = iB4;
                        this.f9549j = jB02 == -9223372036854775807L ? 0L : jB02;
                        parsableByteArray2.J(0);
                        this.f9545f.e(this.o, parsableByteArray2);
                        this.f9546g = 6;
                        i14 = i10;
                    } else {
                        continue;
                    }
                case 6:
                    int iMin = Math.min(parsableByteArray.a(), this.f9551l - this.f9547h);
                    this.f9545f.e(iMin, parsableByteArray);
                    int i42 = this.f9547h + iMin;
                    this.f9547h = i42;
                    if (i42 == this.f9551l) {
                        Assertions.g(this.p != -9223372036854775807L);
                        this.f9545f.f(this.p, this.f9552m == i14 ? 0 : 1, this.f9551l, 0, null);
                        this.p += this.f9549j;
                        this.f9546g = 0;
                    }
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public final boolean b(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int iMin = Math.min(parsableByteArray.a(), i2 - this.f9547h);
        parsableByteArray.h(this.f9547h, bArr, iMin);
        int i3 = this.f9547h + iMin;
        this.f9547h = i3;
        return i3 == i2;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.f9546g = 0;
        this.f9547h = 0;
        this.f9548i = 0;
        this.p = -9223372036854775807L;
        this.f9541b.set(0);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9544e = trackIdGenerator.f9814e;
        trackIdGenerator.b();
        this.f9545f = extractorOutput.n(trackIdGenerator.f9813d, 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.p = j2;
    }

    public final void g(DtsUtil.DtsHeader dtsHeader) {
        int i2;
        int i3 = dtsHeader.f8544b;
        if (i3 == -2147483647 || (i2 = dtsHeader.f8545c) == -1) {
            return;
        }
        Format format = this.f9550k;
        String str = dtsHeader.f8543a;
        if (format != null && i2 == format.A && i3 == format.B && str.equals(format.f5225m)) {
            return;
        }
        Format format2 = this.f9550k;
        Format.Builder builder = format2 == null ? new Format.Builder() : format2.a();
        builder.f5226a = this.f9544e;
        builder.f5237l = MimeTypes.p(str);
        builder.z = i2;
        builder.A = i3;
        builder.f5229d = this.f9542c;
        builder.f5231f = this.f9543d;
        Format format3 = new Format(builder);
        this.f9550k = format3;
        this.f9545f.b(format3);
    }
}
