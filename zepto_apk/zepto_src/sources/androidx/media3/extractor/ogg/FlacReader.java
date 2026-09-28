package androidx.media3.extractor.ogg;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacMetadataReader;
import androidx.media3.extractor.FlacSeekTableSeekMap;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ogg.StreamReader;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class FlacReader extends StreamReader {
    public FlacStreamMetadata n;
    public FlacOggSeeker o;

    public static final class FlacOggSeeker implements OggSeeker {

        /* renamed from: a, reason: collision with root package name */
        public FlacStreamMetadata f9115a;

        /* renamed from: b, reason: collision with root package name */
        public FlacStreamMetadata.SeekTable f9116b;

        /* renamed from: c, reason: collision with root package name */
        public long f9117c;

        /* renamed from: d, reason: collision with root package name */
        public long f9118d;

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public final long a(DefaultExtractorInput defaultExtractorInput) {
            long j2 = this.f9118d;
            if (j2 < 0) {
                return -1L;
            }
            long j3 = -(j2 + 2);
            this.f9118d = -1L;
            return j3;
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public final SeekMap b() {
            Assertions.g(this.f9117c != -1);
            return new FlacSeekTableSeekMap(this.f9115a, this.f9117c);
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public final void c(long j2) {
            long[] jArr = this.f9116b.f8563a;
            this.f9118d = jArr[Util.f(jArr, j2, true)];
        }
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final long b(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.f5723a;
        if (bArr[0] != -1) {
            return -1L;
        }
        int i2 = (bArr[2] & 255) >> 4;
        if (i2 == 6 || i2 == 7) {
            parsableByteArray.K(4);
            parsableByteArray.E();
        }
        int iB = FlacFrameReader.b(i2, parsableByteArray);
        parsableByteArray.J(0);
        return iB;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final boolean c(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) {
        byte[] bArr = parsableByteArray.f5723a;
        FlacStreamMetadata flacStreamMetadata = this.n;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(bArr, 17);
            this.n = flacStreamMetadata2;
            setupData.f9147a = flacStreamMetadata2.c(Arrays.copyOfRange(bArr, 9, parsableByteArray.f5725c), null);
            return true;
        }
        byte b2 = bArr[0];
        if ((b2 & 127) != 3) {
            if (b2 != -1) {
                return true;
            }
            FlacOggSeeker flacOggSeeker = this.o;
            if (flacOggSeeker != null) {
                flacOggSeeker.f9117c = j2;
                setupData.f9148b = flacOggSeeker;
            }
            setupData.f9147a.getClass();
            return false;
        }
        FlacStreamMetadata.SeekTable seekTableA = FlacMetadataReader.a(parsableByteArray);
        FlacStreamMetadata flacStreamMetadata3 = new FlacStreamMetadata(flacStreamMetadata.f8551a, flacStreamMetadata.f8552b, flacStreamMetadata.f8553c, flacStreamMetadata.f8554d, flacStreamMetadata.f8555e, flacStreamMetadata.f8557g, flacStreamMetadata.f8558h, flacStreamMetadata.f8560j, seekTableA, flacStreamMetadata.f8562l);
        this.n = flacStreamMetadata3;
        FlacOggSeeker flacOggSeeker2 = new FlacOggSeeker();
        flacOggSeeker2.f9115a = flacStreamMetadata3;
        flacOggSeeker2.f9116b = seekTableA;
        flacOggSeeker2.f9117c = -1L;
        flacOggSeeker2.f9118d = -1L;
        this.o = flacOggSeeker2;
        return true;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final void d(boolean z) {
        super.d(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }
}
