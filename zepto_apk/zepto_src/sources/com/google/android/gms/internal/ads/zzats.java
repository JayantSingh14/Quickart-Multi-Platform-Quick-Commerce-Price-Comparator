package com.google.android.gms.internal.ads;

import java.util.Optional;

/* loaded from: classes4.dex */
public final class zzats {
    public static zzaus a(final long j2) {
        return zzaus.f(new zzauk() { // from class: com.google.android.gms.internal.ads.zzatr
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                try {
                    ((zzaun) obj).f24398b.b(zzaus.b(j2));
                    return Optional.empty();
                } catch (zzaui unused) {
                    return Optional.of(zzatc.f24293b);
                }
            }
        });
    }

    public static void b(long j2, zzaur zzaurVar, boolean z) {
        long[] jArr = {2000490107, 1476547902, 1834034217, 268849430, 1839467528, 4368198174L, 449620248, 1652701270, 1629190168};
        long j3 = jArr[0];
        long j4 = jArr[1];
        long j5 = jArr[2];
        long j6 = jArr[3];
        long j7 = jArr[4];
        long j8 = jArr[5];
        long j9 = jArr[6];
        long j10 = jArr[7];
        long j11 = (((((~j3) & j4) | j5) + ((j3 & j6) | j7)) - j8) + j9;
        long j12 = j10 % 1629190168;
        long j13 = z ? (j2 + j2) ^ (j2 >> 63) : j2;
        int i2 = 1;
        while (true) {
            long j14 = j11 ^ j12;
            long j15 = j13 >>> 7;
            boolean z2 = j15 != 0 || i2 < 0;
            int i3 = (int) (j13 & j14);
            if (z2) {
                i3 = ((i3 | 128) << 24) >> 24;
            }
            zzaurVar.f24402a.write((byte) i3);
            if (!z2) {
                return;
            }
            i2++;
            j13 = j15;
        }
    }
}
