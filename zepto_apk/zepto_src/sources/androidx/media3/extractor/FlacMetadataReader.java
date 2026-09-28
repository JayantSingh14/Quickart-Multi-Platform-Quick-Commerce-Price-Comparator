package androidx.media3.extractor;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.FlacStreamMetadata;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class FlacMetadataReader {

    public static final class FlacStreamMetadataHolder {

        /* renamed from: a, reason: collision with root package name */
        public FlacStreamMetadata f8548a;
    }

    public static FlacStreamMetadata.SeekTable a(ParsableByteArray parsableByteArray) {
        parsableByteArray.K(1);
        int iA = parsableByteArray.A();
        long j2 = parsableByteArray.f5724b + iA;
        int i2 = iA / 18;
        long[] jArrCopyOf = new long[i2];
        long[] jArrCopyOf2 = new long[i2];
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            long jR = parsableByteArray.r();
            if (jR == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i3);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i3);
                break;
            }
            jArrCopyOf[i3] = jR;
            jArrCopyOf2[i3] = parsableByteArray.r();
            parsableByteArray.K(2);
            i3++;
        }
        parsableByteArray.K((int) (j2 - parsableByteArray.f5724b));
        return new FlacStreamMetadata.SeekTable(jArrCopyOf, jArrCopyOf2);
    }
}
