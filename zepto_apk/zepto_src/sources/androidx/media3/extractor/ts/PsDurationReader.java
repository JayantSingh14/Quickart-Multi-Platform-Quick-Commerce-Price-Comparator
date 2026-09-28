package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DefaultExtractorInput;

/* loaded from: classes3.dex */
final class PsDurationReader {

    /* renamed from: c, reason: collision with root package name */
    public boolean f9740c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9741d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9742e;

    /* renamed from: a, reason: collision with root package name */
    public final TimestampAdjuster f9738a = new TimestampAdjuster(0);

    /* renamed from: f, reason: collision with root package name */
    public long f9743f = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    public long f9744g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f9745h = -9223372036854775807L;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9739b = new ParsableByteArray();

    public static int b(int i2, byte[] bArr) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    public static long c(ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.f5724b;
        if (parsableByteArray.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        parsableByteArray.h(0, bArr, 9);
        parsableByteArray.J(i2);
        byte b2 = bArr[0];
        if ((b2 & 196) == 68) {
            byte b3 = bArr[2];
            if ((b3 & 4) == 4) {
                byte b4 = bArr[4];
                if ((b4 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j2 = b2;
                    long j3 = b3;
                    return ((j3 & 3) << 13) | ((j2 & 3) << 28) | (((56 & j2) >> 3) << 30) | ((bArr[1] & 255) << 20) | (((j3 & 248) >> 3) << 15) | ((bArr[3] & 255) << 5) | ((b4 & 248) >> 3);
                }
            }
        }
        return -9223372036854775807L;
    }

    public final void a(DefaultExtractorInput defaultExtractorInput) {
        byte[] bArr = Util.f5749f;
        ParsableByteArray parsableByteArray = this.f9739b;
        parsableByteArray.getClass();
        parsableByteArray.H(bArr.length, bArr);
        this.f9740c = true;
        defaultExtractorInput.f8521f = 0;
    }
}
