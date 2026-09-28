package androidx.media3.extractor.wav;

import android.support.v4.media.a;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DefaultExtractorInput;
import java.io.EOFException;
import java.io.InterruptedIOException;
import org.xbill.DNS.TTL;

/* loaded from: classes3.dex */
final class WavHeaderReader {

    public static final class ChunkHeader {

        /* renamed from: a, reason: collision with root package name */
        public final int f9850a;

        /* renamed from: b, reason: collision with root package name */
        public final long f9851b;

        public ChunkHeader(int i2, long j2) {
            this.f9850a = i2;
            this.f9851b = j2;
        }

        public static ChunkHeader a(DefaultExtractorInput defaultExtractorInput, ParsableByteArray parsableByteArray) {
            defaultExtractorInput.b(parsableByteArray.f5723a, 0, 8, false);
            parsableByteArray.J(0);
            return new ChunkHeader(parsableByteArray.j(), parsableByteArray.o());
        }
    }

    public static boolean a(DefaultExtractorInput defaultExtractorInput) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        int i2 = ChunkHeader.a(defaultExtractorInput, parsableByteArray).f9850a;
        if (i2 != 1380533830 && i2 != 1380333108) {
            return false;
        }
        defaultExtractorInput.b(parsableByteArray.f5723a, 0, 4, false);
        parsableByteArray.J(0);
        int iJ = parsableByteArray.j();
        if (iJ == 1463899717) {
            return true;
        }
        Log.d("WavHeaderReader", "Unsupported form type: " + iJ);
        return false;
    }

    public static ChunkHeader b(int i2, DefaultExtractorInput defaultExtractorInput, ParsableByteArray parsableByteArray) throws ParserException, EOFException, InterruptedIOException {
        ChunkHeader chunkHeaderA = ChunkHeader.a(defaultExtractorInput, parsableByteArray);
        while (true) {
            int i3 = chunkHeaderA.f9850a;
            if (i3 == i2) {
                return chunkHeaderA;
            }
            a.r(i3, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
            long j2 = chunkHeaderA.f9851b;
            long j3 = 8 + j2;
            if (j2 % 2 != 0) {
                j3 = 9 + j2;
            }
            if (j3 > TTL.MAX_VALUE) {
                throw ParserException.c("Chunk is too large (~2GB+) to skip; id: " + i3);
            }
            defaultExtractorInput.i((int) j3);
            chunkHeaderA = ChunkHeader.a(defaultExtractorInput, parsableByteArray);
        }
    }
}
