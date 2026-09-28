package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Collections;

@UnstableApi
/* loaded from: classes3.dex */
public final class LatmReader implements ElementaryStreamReader {

    /* renamed from: a, reason: collision with root package name */
    public final String f9674a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9675b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f9676c;

    /* renamed from: d, reason: collision with root package name */
    public final ParsableBitArray f9677d;

    /* renamed from: e, reason: collision with root package name */
    public TrackOutput f9678e;

    /* renamed from: f, reason: collision with root package name */
    public String f9679f;

    /* renamed from: g, reason: collision with root package name */
    public Format f9680g;

    /* renamed from: h, reason: collision with root package name */
    public int f9681h;

    /* renamed from: i, reason: collision with root package name */
    public int f9682i;

    /* renamed from: j, reason: collision with root package name */
    public int f9683j;

    /* renamed from: k, reason: collision with root package name */
    public int f9684k;

    /* renamed from: l, reason: collision with root package name */
    public long f9685l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9686m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public long r;
    public int s;
    public long t;
    public int u;
    public String v;

    public LatmReader(String str, int i2) {
        this.f9674a = str;
        this.f9675b = i2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.f9676c = parsableByteArray;
        byte[] bArr = parsableByteArray.f5723a;
        this.f9677d = new ParsableBitArray(bArr, bArr.length);
        this.f9685l = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void a(ParsableByteArray parsableByteArray) throws ParserException {
        int iG;
        boolean zF;
        Assertions.h(this.f9678e);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f9681h;
            if (i2 != 0) {
                if (i2 != 1) {
                    ParsableByteArray parsableByteArray2 = this.f9676c;
                    ParsableBitArray parsableBitArray = this.f9677d;
                    if (i2 == 2) {
                        int iX = ((this.f9684k & (-225)) << 8) | parsableByteArray.x();
                        this.f9683j = iX;
                        if (iX > parsableByteArray2.f5723a.length) {
                            parsableByteArray2.G(iX);
                            byte[] bArr = parsableByteArray2.f5723a;
                            parsableBitArray.getClass();
                            parsableBitArray.k(bArr.length, bArr);
                        }
                        this.f9682i = 0;
                        this.f9681h = 3;
                    } else {
                        if (i2 != 3) {
                            throw new IllegalStateException();
                        }
                        int iMin = Math.min(parsableByteArray.a(), this.f9683j - this.f9682i);
                        parsableByteArray.h(this.f9682i, parsableBitArray.f5716a, iMin);
                        int i3 = this.f9682i + iMin;
                        this.f9682i = i3;
                        if (i3 == this.f9683j) {
                            parsableBitArray.m(0);
                            if (parsableBitArray.f()) {
                                if (this.f9686m) {
                                }
                                this.f9681h = 0;
                            } else {
                                this.f9686m = true;
                                int iG2 = parsableBitArray.g(1);
                                int iG3 = iG2 == 1 ? parsableBitArray.g(1) : 0;
                                this.n = iG3;
                                if (iG3 != 0) {
                                    throw ParserException.a(null, null);
                                }
                                if (iG2 == 1) {
                                    parsableBitArray.g((parsableBitArray.g(2) + 1) * 8);
                                }
                                if (!parsableBitArray.f()) {
                                    throw ParserException.a(null, null);
                                }
                                this.o = parsableBitArray.g(6);
                                int iG4 = parsableBitArray.g(4);
                                int iG5 = parsableBitArray.g(3);
                                if (iG4 != 0 || iG5 != 0) {
                                    throw ParserException.a(null, null);
                                }
                                if (iG2 == 0) {
                                    int iE = parsableBitArray.e();
                                    int iB = parsableBitArray.b();
                                    AacUtil.Config configC = AacUtil.c(parsableBitArray, true);
                                    this.v = configC.f8458c;
                                    this.s = configC.f8456a;
                                    this.u = configC.f8457b;
                                    int iB2 = iB - parsableBitArray.b();
                                    parsableBitArray.m(iE);
                                    byte[] bArr2 = new byte[(iB2 + 7) / 8];
                                    parsableBitArray.h(iB2, bArr2);
                                    Format.Builder builder = new Format.Builder();
                                    builder.f5226a = this.f9679f;
                                    builder.f5237l = MimeTypes.p("audio/mp4a-latm");
                                    builder.f5234i = this.v;
                                    builder.z = this.u;
                                    builder.A = this.s;
                                    builder.o = Collections.singletonList(bArr2);
                                    builder.f5229d = this.f9674a;
                                    builder.f5231f = this.f9675b;
                                    Format format = new Format(builder);
                                    if (!format.equals(this.f9680g)) {
                                        this.f9680g = format;
                                        this.t = 1024000000 / format.B;
                                        this.f9678e.b(format);
                                    }
                                } else {
                                    int iB3 = parsableBitArray.b();
                                    AacUtil.Config configC2 = AacUtil.c(parsableBitArray, true);
                                    this.v = configC2.f8458c;
                                    this.s = configC2.f8456a;
                                    this.u = configC2.f8457b;
                                    parsableBitArray.o(parsableBitArray.g((parsableBitArray.g(2) + 1) * 8) - (iB3 - parsableBitArray.b()));
                                }
                                int iG6 = parsableBitArray.g(3);
                                this.p = iG6;
                                if (iG6 == 0) {
                                    parsableBitArray.o(8);
                                } else if (iG6 == 1) {
                                    parsableBitArray.o(9);
                                } else if (iG6 == 3 || iG6 == 4 || iG6 == 5) {
                                    parsableBitArray.o(6);
                                } else {
                                    if (iG6 != 6 && iG6 != 7) {
                                        throw new IllegalStateException();
                                    }
                                    parsableBitArray.o(1);
                                }
                                boolean zF2 = parsableBitArray.f();
                                this.q = zF2;
                                this.r = 0L;
                                if (zF2) {
                                    if (iG2 == 1) {
                                        this.r = parsableBitArray.g((parsableBitArray.g(2) + 1) * 8);
                                    } else {
                                        do {
                                            zF = parsableBitArray.f();
                                            this.r = (this.r << 8) + parsableBitArray.g(8);
                                        } while (zF);
                                    }
                                }
                                if (parsableBitArray.f()) {
                                    parsableBitArray.o(8);
                                }
                            }
                            if (this.n != 0) {
                                throw ParserException.a(null, null);
                            }
                            if (this.o != 0) {
                                throw ParserException.a(null, null);
                            }
                            if (this.p != 0) {
                                throw ParserException.a(null, null);
                            }
                            int i4 = 0;
                            do {
                                iG = parsableBitArray.g(8);
                                i4 += iG;
                            } while (iG == 255);
                            int iE2 = parsableBitArray.e();
                            if ((iE2 & 7) == 0) {
                                parsableByteArray2.J(iE2 >> 3);
                            } else {
                                parsableBitArray.h(i4 * 8, parsableByteArray2.f5723a);
                                parsableByteArray2.J(0);
                            }
                            this.f9678e.e(i4, parsableByteArray2);
                            Assertions.g(this.f9685l != -9223372036854775807L);
                            this.f9678e.f(this.f9685l, 1, i4, 0, null);
                            this.f9685l += this.t;
                            if (this.q) {
                                parsableBitArray.o((int) this.r);
                            }
                            this.f9681h = 0;
                        } else {
                            continue;
                        }
                    }
                } else {
                    int iX2 = parsableByteArray.x();
                    if ((iX2 & 224) == 224) {
                        this.f9684k = iX2;
                        this.f9681h = 2;
                    } else if (iX2 != 86) {
                        this.f9681h = 0;
                    }
                }
            } else if (parsableByteArray.x() == 86) {
                this.f9681h = 1;
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.f9681h = 0;
        this.f9685l = -9223372036854775807L;
        this.f9686m = false;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9678e = extractorOutput.n(trackIdGenerator.f9813d, 1);
        trackIdGenerator.b();
        this.f9679f = trackIdGenerator.f9814e;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.f9685l = j2;
    }
}
