package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class TsUtil {
    public static long a(ParsableByteArray parsableByteArray, int i2, int i3) {
        parsableByteArray.J(i2);
        if (parsableByteArray.a() < 5) {
            return -9223372036854775807L;
        }
        int iJ = parsableByteArray.j();
        if ((8388608 & iJ) != 0 || ((2096896 & iJ) >> 8) != i3 || (iJ & 32) == 0 || parsableByteArray.x() < 7 || parsableByteArray.a() < 7 || (parsableByteArray.x() & 16) != 16) {
            return -9223372036854775807L;
        }
        parsableByteArray.h(0, new byte[6], 6);
        return ((r0[0] & 255) << 25) | ((r0[1] & 255) << 17) | ((r0[2] & 255) << 9) | ((r0[3] & 255) << 1) | ((r0[4] & 255) >> 7);
    }
}
