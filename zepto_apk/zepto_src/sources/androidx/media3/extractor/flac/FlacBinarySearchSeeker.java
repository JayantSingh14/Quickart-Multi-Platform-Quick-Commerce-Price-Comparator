package androidx.media3.extractor.flac;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacStreamMetadata;
import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes3.dex */
final class FlacBinarySearchSeeker extends BinarySearchSeeker {

    public static final class FlacTimestampSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* renamed from: a, reason: collision with root package name */
        public final FlacStreamMetadata f8696a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8697b;

        /* renamed from: c, reason: collision with root package name */
        public final FlacFrameReader.SampleNumberHolder f8698c = new FlacFrameReader.SampleNumberHolder();

        public FlacTimestampSeeker(FlacStreamMetadata flacStreamMetadata, int i2) {
            this.f8696a = flacStreamMetadata;
            this.f8697b = i2;
        }

        @Override // androidx.media3.extractor.BinarySearchSeeker.TimestampSeeker
        public final BinarySearchSeeker.TimestampSearchResult a(DefaultExtractorInput defaultExtractorInput, long j2) throws EOFException, InterruptedIOException {
            long j3 = defaultExtractorInput.f8519d;
            long jC = c(defaultExtractorInput);
            long jG = defaultExtractorInput.g();
            defaultExtractorInput.l(Math.max(6, this.f8696a.f8553c), false);
            long jC2 = c(defaultExtractorInput);
            return (jC > j2 || jC2 <= j2) ? jC2 <= j2 ? new BinarySearchSeeker.TimestampSearchResult(jC2, defaultExtractorInput.g(), -2) : new BinarySearchSeeker.TimestampSearchResult(jC, j3, -1) : new BinarySearchSeeker.TimestampSearchResult(-9223372036854775807L, jG, 0);
        }

        public final long c(DefaultExtractorInput defaultExtractorInput) throws EOFException, InterruptedIOException {
            long j2;
            FlacFrameReader.SampleNumberHolder sampleNumberHolder;
            FlacStreamMetadata flacStreamMetadata;
            long j3;
            boolean zA;
            int iN;
            while (true) {
                long jG = defaultExtractorInput.g();
                j2 = defaultExtractorInput.f8518c;
                long j4 = j2 - 6;
                sampleNumberHolder = this.f8698c;
                flacStreamMetadata = this.f8696a;
                if (jG >= j4) {
                    j3 = 6;
                    break;
                }
                long jG2 = defaultExtractorInput.g();
                byte[] bArr = new byte[2];
                defaultExtractorInput.b(bArr, 0, 2, false);
                int i2 = ((bArr[0] & 255) << 8) | (bArr[1] & 255);
                int i3 = this.f8697b;
                if (i2 != i3) {
                    defaultExtractorInput.f8521f = 0;
                    defaultExtractorInput.l((int) (jG2 - defaultExtractorInput.f8519d), false);
                    zA = false;
                    j3 = 6;
                } else {
                    j3 = 6;
                    ParsableByteArray parsableByteArray = new ParsableByteArray(16);
                    System.arraycopy(bArr, 0, parsableByteArray.f5723a, 0, 2);
                    byte[] bArr2 = parsableByteArray.f5723a;
                    int i4 = 0;
                    for (int i5 = 2; i4 < 14 && (iN = defaultExtractorInput.n(i5 + i4, bArr2, 14 - i4)) != -1; i5 = 2) {
                        i4 += iN;
                    }
                    parsableByteArray.I(i4);
                    defaultExtractorInput.f8521f = 0;
                    defaultExtractorInput.l((int) (jG2 - defaultExtractorInput.f8519d), false);
                    zA = FlacFrameReader.a(parsableByteArray, flacStreamMetadata, i3, sampleNumberHolder);
                }
                if (zA) {
                    break;
                }
                defaultExtractorInput.l(1, false);
            }
            if (defaultExtractorInput.g() < j2 - j3) {
                return sampleNumberHolder.f8547a;
            }
            defaultExtractorInput.l((int) (j2 - defaultExtractorInput.g()), false);
            return flacStreamMetadata.f8560j;
        }
    }
}
