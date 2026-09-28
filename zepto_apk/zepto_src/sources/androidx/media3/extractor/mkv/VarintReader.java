package androidx.media3.extractor.mkv;

import androidx.media3.extractor.DefaultExtractorInput;
import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes3.dex */
final class VarintReader {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f8932d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8933a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public int f8934b;

    /* renamed from: c, reason: collision with root package name */
    public int f8935c;

    public static long a(byte[] bArr, int i2, boolean z) {
        long j2 = bArr[0] & 255;
        if (z) {
            j2 &= ~f8932d[i2 - 1];
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (bArr[i3] & 255);
        }
        return j2;
    }

    public static int b(int i2) {
        for (int i3 = 0; i3 < 8; i3++) {
            if ((f8932d[i3] & i2) != 0) {
                return i3 + 1;
            }
        }
        return -1;
    }

    public final long c(DefaultExtractorInput defaultExtractorInput, boolean z, boolean z2, int i2) throws EOFException, InterruptedIOException {
        int i3 = this.f8934b;
        byte[] bArr = this.f8933a;
        if (i3 == 0) {
            if (!defaultExtractorInput.e(bArr, 0, 1, z)) {
                return -1L;
            }
            int iB = b(bArr[0] & 255);
            this.f8935c = iB;
            if (iB == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f8934b = 1;
        }
        int i4 = this.f8935c;
        if (i4 > i2) {
            this.f8934b = 0;
            return -2L;
        }
        if (i4 != 1) {
            defaultExtractorInput.e(bArr, 1, i4 - 1, false);
        }
        this.f8934b = 0;
        return a(bArr, this.f8935c, z2);
    }
}
