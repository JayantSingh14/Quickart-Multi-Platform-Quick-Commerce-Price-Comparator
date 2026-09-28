package androidx.media3.extractor;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class FlacFrameReader {

    public static final class SampleNumberHolder {

        /* renamed from: a, reason: collision with root package name */
        public long f8547a;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(androidx.media3.common.util.ParsableByteArray r21, androidx.media3.extractor.FlacStreamMetadata r22, int r23, androidx.media3.extractor.FlacFrameReader.SampleNumberHolder r24) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.FlacFrameReader.a(androidx.media3.common.util.ParsableByteArray, androidx.media3.extractor.FlacStreamMetadata, int, androidx.media3.extractor.FlacFrameReader$SampleNumberHolder):boolean");
    }

    public static int b(int i2, ParsableByteArray parsableByteArray) {
        switch (i2) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i2 - 2);
            case 6:
                return parsableByteArray.x() + 1;
            case 7:
                return parsableByteArray.D() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i2 - 8);
            default:
                return -1;
        }
    }
}
