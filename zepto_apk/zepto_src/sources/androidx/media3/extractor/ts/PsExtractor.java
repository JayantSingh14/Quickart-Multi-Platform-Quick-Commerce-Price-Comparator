package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ts.PsBinarySearchSeeker;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.io.EOFException;
import java.io.InterruptedIOException;

@UnstableApi
/* loaded from: classes3.dex */
public final class PsExtractor implements Extractor {

    /* renamed from: e, reason: collision with root package name */
    public boolean f9750e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9751f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9752g;

    /* renamed from: h, reason: collision with root package name */
    public long f9753h;

    /* renamed from: i, reason: collision with root package name */
    public PsBinarySearchSeeker f9754i;

    /* renamed from: j, reason: collision with root package name */
    public ExtractorOutput f9755j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9756k;

    /* renamed from: a, reason: collision with root package name */
    public final TimestampAdjuster f9746a = new TimestampAdjuster(0);

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f9748c = new ParsableByteArray(4096);

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f9747b = new SparseArray();

    /* renamed from: d, reason: collision with root package name */
    public final PsDurationReader f9749d = new PsDurationReader();

    public static final class PesReader {

        /* renamed from: a, reason: collision with root package name */
        public final ElementaryStreamReader f9757a;

        /* renamed from: b, reason: collision with root package name */
        public final TimestampAdjuster f9758b;

        /* renamed from: c, reason: collision with root package name */
        public final ParsableBitArray f9759c = new ParsableBitArray(new byte[64], 64);

        /* renamed from: d, reason: collision with root package name */
        public boolean f9760d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f9761e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f9762f;

        /* renamed from: g, reason: collision with root package name */
        public long f9763g;

        public PesReader(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.f9757a = elementaryStreamReader;
            this.f9758b = timestampAdjuster;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        long j4;
        TimestampAdjuster timestampAdjuster = this.f9746a;
        synchronized (timestampAdjuster) {
            j4 = timestampAdjuster.f5741b;
        }
        boolean z = j4 == -9223372036854775807L;
        if (!z) {
            long jD = timestampAdjuster.d();
            z = (jD == -9223372036854775807L || jD == 0 || jD == j3) ? false : true;
        }
        if (z) {
            timestampAdjuster.f(j3);
        }
        PsBinarySearchSeeker psBinarySearchSeeker = this.f9754i;
        if (psBinarySearchSeeker != null) {
            psBinarySearchSeeker.c(j3);
        }
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.f9747b;
            if (i2 >= sparseArray.size()) {
                return;
            }
            PesReader pesReader = (PesReader) sparseArray.valueAt(i2);
            pesReader.f9762f = false;
            pesReader.f9757a.c();
            i2++;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f9755j = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) throws EOFException, InterruptedIOException {
        byte[] bArr = new byte[14];
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        defaultExtractorInput.b(bArr, 0, 14, false);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            defaultExtractorInput.l(bArr[13] & 7, false);
            defaultExtractorInput.b(bArr, 0, 3, false);
            if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean, int] */
    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws EOFException, InterruptedIOException {
        int i2;
        ?? r2;
        ParsableByteArray parsableByteArray;
        ElementaryStreamReader h262Reader;
        Assertions.h(this.f9755j);
        long j2 = ((DefaultExtractorInput) extractorInput).f8518c;
        int i3 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
        long j3 = -9223372036854775807L;
        PsDurationReader psDurationReader = this.f9749d;
        if (i3 != 0 && !psDurationReader.f9740c) {
            boolean z = psDurationReader.f9742e;
            ParsableByteArray parsableByteArray2 = psDurationReader.f9739b;
            if (!z) {
                DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
                long j4 = defaultExtractorInput.f8518c;
                int iMin = (int) Math.min(20000L, j4);
                long j5 = j4 - iMin;
                if (defaultExtractorInput.f8519d != j5) {
                    positionHolder.f8599a = j5;
                    return 1;
                }
                parsableByteArray2.G(iMin);
                defaultExtractorInput.f8521f = 0;
                defaultExtractorInput.b(parsableByteArray2.f5723a, 0, iMin, false);
                int i4 = parsableByteArray2.f5724b;
                int i5 = parsableByteArray2.f5725c - 4;
                while (true) {
                    if (i5 < i4) {
                        break;
                    }
                    if (PsDurationReader.b(i5, parsableByteArray2.f5723a) == 442) {
                        parsableByteArray2.J(i5 + 4);
                        long jC = PsDurationReader.c(parsableByteArray2);
                        if (jC != -9223372036854775807L) {
                            j3 = jC;
                            break;
                        }
                    }
                    i5--;
                }
                psDurationReader.f9744g = j3;
                psDurationReader.f9742e = true;
                return 0;
            }
            if (psDurationReader.f9744g == -9223372036854775807L) {
                psDurationReader.a((DefaultExtractorInput) extractorInput);
                return 0;
            }
            if (psDurationReader.f9741d) {
                long j6 = psDurationReader.f9743f;
                if (j6 == -9223372036854775807L) {
                    psDurationReader.a((DefaultExtractorInput) extractorInput);
                    return 0;
                }
                TimestampAdjuster timestampAdjuster = psDurationReader.f9738a;
                psDurationReader.f9745h = timestampAdjuster.c(psDurationReader.f9744g) - timestampAdjuster.b(j6);
                psDurationReader.a((DefaultExtractorInput) extractorInput);
                return 0;
            }
            DefaultExtractorInput defaultExtractorInput2 = (DefaultExtractorInput) extractorInput;
            int iMin2 = (int) Math.min(20000L, defaultExtractorInput2.f8518c);
            long j7 = 0;
            if (defaultExtractorInput2.f8519d != j7) {
                positionHolder.f8599a = j7;
                return 1;
            }
            parsableByteArray2.G(iMin2);
            defaultExtractorInput2.f8521f = 0;
            defaultExtractorInput2.b(parsableByteArray2.f5723a, 0, iMin2, false);
            int i6 = parsableByteArray2.f5724b;
            int i7 = parsableByteArray2.f5725c;
            while (true) {
                if (i6 >= i7 - 3) {
                    break;
                }
                if (PsDurationReader.b(i6, parsableByteArray2.f5723a) == 442) {
                    parsableByteArray2.J(i6 + 4);
                    long jC2 = PsDurationReader.c(parsableByteArray2);
                    if (jC2 != -9223372036854775807L) {
                        j3 = jC2;
                        break;
                    }
                }
                i6++;
            }
            psDurationReader.f9743f = j3;
            psDurationReader.f9741d = true;
            return 0;
        }
        if (this.f9756k) {
            i2 = i3;
            r2 = 0;
        } else {
            this.f9756k = true;
            long j8 = psDurationReader.f9745h;
            if (j8 != -9223372036854775807L) {
                i2 = i3;
                r2 = 0;
                PsBinarySearchSeeker psBinarySearchSeeker = new PsBinarySearchSeeker(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new PsBinarySearchSeeker.PsScrSeeker(psDurationReader.f9738a), j8, j8 + 1, 0L, j2, 188L, 1000);
                this.f9754i = psBinarySearchSeeker;
                this.f9755j.c(psBinarySearchSeeker.f8481a);
            } else {
                i2 = i3;
                r2 = 0;
                this.f9755j.c(new SeekMap.Unseekable(j8));
            }
        }
        PsBinarySearchSeeker psBinarySearchSeeker2 = this.f9754i;
        if (psBinarySearchSeeker2 != null && psBinarySearchSeeker2.f8483c != null) {
            return psBinarySearchSeeker2.a((DefaultExtractorInput) extractorInput, positionHolder);
        }
        DefaultExtractorInput defaultExtractorInput3 = (DefaultExtractorInput) extractorInput;
        defaultExtractorInput3.f8521f = r2;
        long jG = i2 != 0 ? j2 - defaultExtractorInput3.g() : -1L;
        if (jG != -1 && jG < 4) {
            return -1;
        }
        ParsableByteArray parsableByteArray3 = this.f9748c;
        if (!defaultExtractorInput3.b(parsableByteArray3.f5723a, r2, 4, true)) {
            return -1;
        }
        parsableByteArray3.J(r2);
        int iJ = parsableByteArray3.j();
        if (iJ == 441) {
            return -1;
        }
        if (iJ == 442) {
            defaultExtractorInput3.b(parsableByteArray3.f5723a, r2, 10, r2);
            parsableByteArray3.J(9);
            defaultExtractorInput3.i((parsableByteArray3.x() & 7) + 14);
            return r2;
        }
        if (iJ == 443) {
            defaultExtractorInput3.b(parsableByteArray3.f5723a, r2, 2, r2);
            parsableByteArray3.J(r2);
            defaultExtractorInput3.i(parsableByteArray3.D() + 6);
            return r2;
        }
        if (((iJ & (-256)) >> 8) != 1) {
            defaultExtractorInput3.i(1);
            return r2;
        }
        int i8 = iJ & 255;
        SparseArray sparseArray = this.f9747b;
        PesReader pesReader = (PesReader) sparseArray.get(i8);
        if (!this.f9750e) {
            if (pesReader == null) {
                if (i8 == 189) {
                    h262Reader = new Ac3Reader();
                    this.f9751f = true;
                    this.f9753h = defaultExtractorInput3.f8519d;
                } else if ((iJ & 224) == 192) {
                    h262Reader = new MpegAudioReader();
                    this.f9751f = true;
                    this.f9753h = defaultExtractorInput3.f8519d;
                } else if ((iJ & 240) == 224) {
                    h262Reader = new H262Reader();
                    this.f9752g = true;
                    this.f9753h = defaultExtractorInput3.f8519d;
                } else {
                    h262Reader = null;
                }
                if (h262Reader != null) {
                    h262Reader.e(this.f9755j, new TsPayloadReader.TrackIdGenerator(i8, 256));
                    pesReader = new PesReader(h262Reader, this.f9746a);
                    sparseArray.put(i8, pesReader);
                }
            }
            if (defaultExtractorInput3.f8519d > ((this.f9751f && this.f9752g) ? this.f9753h + 8192 : 1048576L)) {
                this.f9750e = true;
                this.f9755j.m();
            }
        }
        defaultExtractorInput3.b(parsableByteArray3.f5723a, r2, 2, r2);
        parsableByteArray3.J(r2);
        int iD = parsableByteArray3.D() + 6;
        if (pesReader == null) {
            defaultExtractorInput3.i(iD);
            return r2;
        }
        parsableByteArray3.G(iD);
        defaultExtractorInput3.e(parsableByteArray3.f5723a, r2, iD, r2);
        parsableByteArray3.J(6);
        ParsableBitArray parsableBitArray = pesReader.f9759c;
        parsableByteArray3.h(r2, parsableBitArray.f5716a, 3);
        parsableBitArray.m(r2);
        parsableBitArray.o(8);
        pesReader.f9760d = parsableBitArray.f();
        pesReader.f9761e = parsableBitArray.f();
        parsableBitArray.o(6);
        parsableByteArray3.h(r2, parsableBitArray.f5716a, parsableBitArray.g(8));
        parsableBitArray.m(r2);
        pesReader.f9763g = 0L;
        if (pesReader.f9760d) {
            parsableBitArray.o(4);
            parsableBitArray.o(1);
            parsableBitArray.o(1);
            long jG2 = (parsableBitArray.g(3) << 30) | (parsableBitArray.g(15) << 15) | parsableBitArray.g(15);
            parsableBitArray.o(1);
            boolean z2 = pesReader.f9762f;
            TimestampAdjuster timestampAdjuster2 = pesReader.f9758b;
            if (z2 || !pesReader.f9761e) {
                parsableByteArray = parsableByteArray3;
            } else {
                parsableBitArray.o(4);
                parsableBitArray.o(1);
                parsableByteArray = parsableByteArray3;
                parsableBitArray.o(1);
                parsableBitArray.o(1);
                timestampAdjuster2.b((parsableBitArray.g(15) << 15) | (parsableBitArray.g(3) << 30) | parsableBitArray.g(15));
                pesReader.f9762f = true;
            }
            pesReader.f9763g = timestampAdjuster2.b(jG2);
        } else {
            parsableByteArray = parsableByteArray3;
        }
        long j9 = pesReader.f9763g;
        ElementaryStreamReader elementaryStreamReader = pesReader.f9757a;
        elementaryStreamReader.f(4, j9);
        elementaryStreamReader.a(parsableByteArray);
        elementaryStreamReader.d(false);
        parsableByteArray.I(parsableByteArray.f5723a.length);
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
