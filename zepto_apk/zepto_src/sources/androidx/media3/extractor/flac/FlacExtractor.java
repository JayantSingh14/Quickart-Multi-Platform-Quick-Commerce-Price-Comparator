package androidx.media3.extractor.flac;

import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.l;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacMetadataReader;
import androidx.media3.extractor.FlacSeekTableSeekMap;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.Id3Peeker;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.flac.FlacBinarySearchSeeker;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class FlacExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8699a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f8700b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8701c;

    /* renamed from: d, reason: collision with root package name */
    public final FlacFrameReader.SampleNumberHolder f8702d;

    /* renamed from: e, reason: collision with root package name */
    public ExtractorOutput f8703e;

    /* renamed from: f, reason: collision with root package name */
    public TrackOutput f8704f;

    /* renamed from: g, reason: collision with root package name */
    public int f8705g;

    /* renamed from: h, reason: collision with root package name */
    public Metadata f8706h;

    /* renamed from: i, reason: collision with root package name */
    public FlacStreamMetadata f8707i;

    /* renamed from: j, reason: collision with root package name */
    public int f8708j;

    /* renamed from: k, reason: collision with root package name */
    public int f8709k;

    /* renamed from: l, reason: collision with root package name */
    public FlacBinarySearchSeeker f8710l;

    /* renamed from: m, reason: collision with root package name */
    public int f8711m;
    public long n;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public FlacExtractor() {
        this(0);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        if (j2 == 0) {
            this.f8705g = 0;
        } else {
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.f8710l;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.c(j3);
            }
        }
        this.n = j3 != 0 ? -1L : 0L;
        this.f8711m = 0;
        this.f8700b.G(0);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f8703e = extractorOutput;
        this.f8704f = extractorOutput.n(0, 1);
        extractorOutput.m();
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) throws Throwable {
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        Metadata metadataA = new Id3Peeker().a(defaultExtractorInput, Id3Decoder.f8823b);
        if (metadataA != null) {
            int length = metadataA.f5405a.length;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        defaultExtractorInput.b(parsableByteArray.f5723a, 0, 4, false);
        return parsableByteArray.z() == 1716281667;
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws Throwable {
        int i2;
        SeekMap unseekable;
        long j2;
        boolean z;
        long j3;
        boolean zA;
        int i3 = this.f8705g;
        Metadata metadata = null;
        if (i3 == 0) {
            ((DefaultExtractorInput) extractorInput).f8521f = 0;
            DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
            long jG = defaultExtractorInput.g();
            Metadata metadataA = new Id3Peeker().a(defaultExtractorInput, !this.f8701c ? null : Id3Decoder.f8823b);
            if (metadataA != null && metadataA.f5405a.length != 0) {
                metadata = metadataA;
            }
            defaultExtractorInput.i((int) (defaultExtractorInput.g() - jG));
            this.f8706h = metadata;
            this.f8705g = 1;
            return 0;
        }
        byte[] bArr = this.f8699a;
        if (i3 == 1) {
            ((DefaultExtractorInput) extractorInput).b(bArr, 0, bArr.length, false);
            ((DefaultExtractorInput) extractorInput).f8521f = 0;
            this.f8705g = 2;
            return 0;
        }
        int i4 = 3;
        if (i3 == 2) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(4);
            ((DefaultExtractorInput) extractorInput).e(parsableByteArray.f5723a, 0, 4, false);
            if (parsableByteArray.z() != 1716281667) {
                throw ParserException.a(null, "Failed to read FLAC stream marker.");
            }
            this.f8705g = 3;
            return 0;
        }
        if (i3 == 3) {
            FlacStreamMetadata flacStreamMetadata = this.f8707i;
            FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new FlacMetadataReader.FlacStreamMetadataHolder();
            flacStreamMetadataHolder.f8548a = flacStreamMetadata;
            boolean z2 = false;
            while (!z2) {
                ((DefaultExtractorInput) extractorInput).f8521f = 0;
                byte[] bArr2 = new byte[4];
                ParsableBitArray parsableBitArray = new ParsableBitArray(bArr2, 4);
                DefaultExtractorInput defaultExtractorInput2 = (DefaultExtractorInput) extractorInput;
                defaultExtractorInput2.b(bArr2, 0, 4, false);
                boolean zF = parsableBitArray.f();
                int iG = parsableBitArray.g(i);
                int iG2 = parsableBitArray.g(24) + 4;
                if (iG == 0) {
                    byte[] bArr3 = new byte[38];
                    defaultExtractorInput2.e(bArr3, 0, 38, false);
                    flacStreamMetadataHolder.f8548a = new FlacStreamMetadata(bArr3, 4);
                } else {
                    FlacStreamMetadata flacStreamMetadata2 = flacStreamMetadataHolder.f8548a;
                    if (flacStreamMetadata2 == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iG == i4) {
                        ParsableByteArray parsableByteArray2 = new ParsableByteArray(iG2);
                        defaultExtractorInput2.e(parsableByteArray2.f5723a, 0, iG2, false);
                        flacStreamMetadataHolder.f8548a = new FlacStreamMetadata(flacStreamMetadata2.f8551a, flacStreamMetadata2.f8552b, flacStreamMetadata2.f8553c, flacStreamMetadata2.f8554d, flacStreamMetadata2.f8555e, flacStreamMetadata2.f8557g, flacStreamMetadata2.f8558h, flacStreamMetadata2.f8560j, FlacMetadataReader.a(parsableByteArray2), flacStreamMetadata2.f8562l);
                    } else {
                        Metadata metadata2 = flacStreamMetadata2.f8562l;
                        if (iG == 4) {
                            ParsableByteArray parsableByteArray3 = new ParsableByteArray(iG2);
                            defaultExtractorInput2.e(parsableByteArray3.f5723a, 0, iG2, false);
                            parsableByteArray3.K(4);
                            Metadata metadataB = VorbisUtil.b(Arrays.asList(VorbisUtil.c(parsableByteArray3, false, false).f8629a));
                            if (metadata2 != null) {
                                metadataB = metadata2.b(metadataB);
                            }
                            flacStreamMetadataHolder.f8548a = new FlacStreamMetadata(flacStreamMetadata2.f8551a, flacStreamMetadata2.f8552b, flacStreamMetadata2.f8553c, flacStreamMetadata2.f8554d, flacStreamMetadata2.f8555e, flacStreamMetadata2.f8557g, flacStreamMetadata2.f8558h, flacStreamMetadata2.f8560j, flacStreamMetadata2.f8561k, metadataB);
                        } else if (iG == 6) {
                            ParsableByteArray parsableByteArray4 = new ParsableByteArray(iG2);
                            defaultExtractorInput2.e(parsableByteArray4.f5723a, 0, iG2, false);
                            parsableByteArray4.K(4);
                            Metadata metadata3 = new Metadata(ImmutableList.t(PictureFrame.a(parsableByteArray4)));
                            if (metadata2 != null) {
                                metadata3 = metadata2.b(metadata3);
                            }
                            flacStreamMetadataHolder.f8548a = new FlacStreamMetadata(flacStreamMetadata2.f8551a, flacStreamMetadata2.f8552b, flacStreamMetadata2.f8553c, flacStreamMetadata2.f8554d, flacStreamMetadata2.f8555e, flacStreamMetadata2.f8557g, flacStreamMetadata2.f8558h, flacStreamMetadata2.f8560j, flacStreamMetadata2.f8561k, metadata3);
                        } else {
                            defaultExtractorInput2.i(iG2);
                        }
                    }
                }
                FlacStreamMetadata flacStreamMetadata3 = flacStreamMetadataHolder.f8548a;
                int i5 = Util.f5744a;
                this.f8707i = flacStreamMetadata3;
                z2 = zF;
                i4 = 3;
                i = 7;
            }
            this.f8707i.getClass();
            this.f8708j = Math.max(this.f8707i.f8553c, 6);
            TrackOutput trackOutput = this.f8704f;
            int i6 = Util.f5744a;
            trackOutput.b(this.f8707i.c(bArr, this.f8706h));
            this.f8705g = 4;
            return 0;
        }
        if (i3 == 4) {
            ((DefaultExtractorInput) extractorInput).f8521f = 0;
            ParsableByteArray parsableByteArray5 = new ParsableByteArray(2);
            DefaultExtractorInput defaultExtractorInput3 = (DefaultExtractorInput) extractorInput;
            defaultExtractorInput3.b(parsableByteArray5.f5723a, 0, 2, false);
            int iD = parsableByteArray5.D();
            if ((iD >> 2) != 16382) {
                defaultExtractorInput3.f8521f = 0;
                throw ParserException.a(null, "First frame does not start with sync code.");
            }
            defaultExtractorInput3.f8521f = 0;
            this.f8709k = iD;
            ExtractorOutput extractorOutput = this.f8703e;
            int i7 = Util.f5744a;
            long j4 = defaultExtractorInput3.f8519d;
            this.f8707i.getClass();
            FlacStreamMetadata flacStreamMetadata4 = this.f8707i;
            if (flacStreamMetadata4.f8561k != null) {
                unseekable = new FlacSeekTableSeekMap(flacStreamMetadata4, j4);
                i2 = 0;
            } else {
                long j5 = defaultExtractorInput3.f8518c;
                if (j5 == -1 || flacStreamMetadata4.f8560j <= 0) {
                    i2 = 0;
                    unseekable = new SeekMap.Unseekable(flacStreamMetadata4.b());
                } else {
                    int i8 = this.f8709k;
                    l lVar = new l(flacStreamMetadata4, 1);
                    FlacBinarySearchSeeker.FlacTimestampSeeker flacTimestampSeeker = new FlacBinarySearchSeeker.FlacTimestampSeeker(flacStreamMetadata4, i8);
                    long jB = flacStreamMetadata4.b();
                    int i9 = flacStreamMetadata4.f8553c;
                    int i10 = flacStreamMetadata4.f8554d;
                    if (i10 > 0) {
                        i2 = 0;
                        j2 = ((i10 + i9) / 2) + 1;
                    } else {
                        i2 = 0;
                        int i11 = flacStreamMetadata4.f8552b;
                        int i12 = flacStreamMetadata4.f8551a;
                        j2 = 64 + (((((i12 != i11 || i12 <= 0) ? 4096L : i12) * flacStreamMetadata4.f8557g) * flacStreamMetadata4.f8558h) / 8);
                    }
                    FlacBinarySearchSeeker flacBinarySearchSeeker = new FlacBinarySearchSeeker(lVar, flacTimestampSeeker, jB, flacStreamMetadata4.f8560j, j4, j5, j2, Math.max(6, i9));
                    this.f8710l = flacBinarySearchSeeker;
                    unseekable = flacBinarySearchSeeker.f8481a;
                }
            }
            extractorOutput.c(unseekable);
            this.f8705g = 5;
            return i2;
        }
        if (i3 != 5) {
            throw new IllegalStateException();
        }
        this.f8704f.getClass();
        this.f8707i.getClass();
        FlacBinarySearchSeeker flacBinarySearchSeeker2 = this.f8710l;
        if (flacBinarySearchSeeker2 != null && flacBinarySearchSeeker2.f8483c != null) {
            return flacBinarySearchSeeker2.a((DefaultExtractorInput) extractorInput, positionHolder);
        }
        if (this.n == -1) {
            FlacStreamMetadata flacStreamMetadata5 = this.f8707i;
            ((DefaultExtractorInput) extractorInput).f8521f = 0;
            DefaultExtractorInput defaultExtractorInput4 = (DefaultExtractorInput) extractorInput;
            defaultExtractorInput4.l(1, false);
            byte[] bArr4 = new byte[1];
            defaultExtractorInput4.b(bArr4, 0, 1, false);
            boolean z3 = (bArr4[0] & 1) == 1;
            defaultExtractorInput4.l(2, false);
            i = z3 ? 7 : 6;
            ParsableByteArray parsableByteArray6 = new ParsableByteArray(i);
            byte[] bArr5 = parsableByteArray6.f5723a;
            int i13 = 0;
            while (i13 < i) {
                int iN = defaultExtractorInput4.n(i13, bArr5, i - i13);
                if (iN == -1) {
                    break;
                }
                i13 += iN;
            }
            parsableByteArray6.I(i13);
            defaultExtractorInput4.f8521f = 0;
            FlacFrameReader.SampleNumberHolder sampleNumberHolder = new FlacFrameReader.SampleNumberHolder();
            try {
                long jE = parsableByteArray6.E();
                if (!z3) {
                    jE *= flacStreamMetadata5.f8552b;
                }
                sampleNumberHolder.f8547a = jE;
                this.n = jE;
                return 0;
            } catch (NumberFormatException unused) {
                throw ParserException.a(null, null);
            }
        }
        ParsableByteArray parsableByteArray7 = this.f8700b;
        int i14 = parsableByteArray7.f5725c;
        if (i14 < 32768) {
            int i15 = ((DefaultExtractorInput) extractorInput).read(parsableByteArray7.f5723a, i14, 32768 - i14);
            z = i15 == -1;
            if (!z) {
                parsableByteArray7.I(i14 + i15);
            } else if (parsableByteArray7.a() == 0) {
                long j6 = this.n * 1000000;
                FlacStreamMetadata flacStreamMetadata6 = this.f8707i;
                int i16 = Util.f5744a;
                this.f8704f.f(j6 / flacStreamMetadata6.f8555e, 1, this.f8711m, 0, null);
                return -1;
            }
        } else {
            z = false;
        }
        int i17 = parsableByteArray7.f5724b;
        int i18 = this.f8711m;
        int i19 = this.f8708j;
        if (i18 < i19) {
            parsableByteArray7.K(Math.min(i19 - i18, parsableByteArray7.a()));
        }
        this.f8707i.getClass();
        int i20 = parsableByteArray7.f5724b;
        while (true) {
            int i21 = parsableByteArray7.f5725c - 16;
            FlacFrameReader.SampleNumberHolder sampleNumberHolder2 = this.f8702d;
            if (i20 <= i21) {
                parsableByteArray7.J(i20);
                if (FlacFrameReader.a(parsableByteArray7, this.f8707i, this.f8709k, sampleNumberHolder2)) {
                    parsableByteArray7.J(i20);
                    j3 = sampleNumberHolder2.f8547a;
                    break;
                }
                i20++;
            } else {
                if (z) {
                    while (true) {
                        int i22 = parsableByteArray7.f5725c;
                        if (i20 > i22 - this.f8708j) {
                            parsableByteArray7.J(i22);
                            break;
                        }
                        parsableByteArray7.J(i20);
                        try {
                            zA = FlacFrameReader.a(parsableByteArray7, this.f8707i, this.f8709k, sampleNumberHolder2);
                        } catch (IndexOutOfBoundsException unused2) {
                            zA = false;
                        }
                        if (parsableByteArray7.f5724b > parsableByteArray7.f5725c) {
                            zA = false;
                        }
                        if (zA) {
                            parsableByteArray7.J(i20);
                            j3 = sampleNumberHolder2.f8547a;
                            break;
                        }
                        i20++;
                    }
                } else {
                    parsableByteArray7.J(i20);
                }
                j3 = -1;
            }
        }
        int i23 = parsableByteArray7.f5724b - i17;
        parsableByteArray7.J(i17);
        this.f8704f.e(i23, parsableByteArray7);
        int i24 = this.f8711m + i23;
        this.f8711m = i24;
        if (j3 != -1) {
            long j7 = this.n * 1000000;
            FlacStreamMetadata flacStreamMetadata7 = this.f8707i;
            int i25 = Util.f5744a;
            this.f8704f.f(j7 / flacStreamMetadata7.f8555e, 1, i24, 0, null);
            this.f8711m = 0;
            this.n = j3;
        }
        if (parsableByteArray7.a() < 16) {
            int iA = parsableByteArray7.a();
            byte[] bArr6 = parsableByteArray7.f5723a;
            System.arraycopy(bArr6, parsableByteArray7.f5724b, bArr6, 0, iA);
            parsableByteArray7.J(0);
            parsableByteArray7.I(iA);
        }
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }

    public FlacExtractor(int i2) {
        this.f8699a = new byte[42];
        this.f8700b = new ParsableByteArray(new byte[32768], 0);
        this.f8701c = false;
        this.f8702d = new FlacFrameReader.SampleNumberHolder();
        this.f8705g = 0;
    }
}
