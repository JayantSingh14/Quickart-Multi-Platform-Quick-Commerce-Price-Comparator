package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class CeaUtil {
    public static void a(long j2, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        int i2;
        while (true) {
            if (parsableByteArray.a() <= 1) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (parsableByteArray.a() == 0) {
                    i2 = -1;
                    break;
                }
                int iX = parsableByteArray.x();
                i3 += iX;
                if (iX != 255) {
                    i2 = i3;
                    break;
                }
            }
            int i4 = 0;
            while (true) {
                if (parsableByteArray.a() == 0) {
                    i4 = -1;
                    break;
                }
                int iX2 = parsableByteArray.x();
                i4 += iX2;
                if (iX2 != 255) {
                    break;
                }
            }
            int i5 = parsableByteArray.f5724b + i4;
            if (i4 == -1 || i4 > parsableByteArray.a()) {
                Log.h("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                i5 = parsableByteArray.f5725c;
            } else if (i2 == 4 && i4 >= 8) {
                int iX3 = parsableByteArray.x();
                int iD = parsableByteArray.D();
                int iJ = iD == 49 ? parsableByteArray.j() : 0;
                int iX4 = parsableByteArray.x();
                if (iD == 47) {
                    parsableByteArray.K(1);
                }
                boolean z = iX3 == 181 && (iD == 49 || iD == 47) && iX4 == 3;
                if (iD == 49) {
                    z &= iJ == 1195456820;
                }
                if (z) {
                    b(j2, parsableByteArray, trackOutputArr);
                }
            }
            parsableByteArray.J(i5);
        }
    }

    public static void b(long j2, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        int iX = parsableByteArray.x();
        if ((iX & 64) != 0) {
            parsableByteArray.K(1);
            int i2 = (iX & 31) * 3;
            int i3 = parsableByteArray.f5724b;
            for (TrackOutput trackOutput : trackOutputArr) {
                parsableByteArray.J(i3);
                trackOutput.e(i2, parsableByteArray);
                Assertions.g(j2 != -9223372036854775807L);
                trackOutput.f(j2, 1, i2, 0, null);
            }
        }
    }
}
