package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HexExtensionsKt {
    static {
        int[] iArr = new int[256];
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            iArr[i3] = "0123456789abcdef".charAt(i3 & 15) | ("0123456789abcdef".charAt(i3 >> 4) << '\b');
        }
        int[] iArr2 = new int[256];
        for (int i4 = 0; i4 < 256; i4++) {
            iArr2[i4] = "0123456789ABCDEF".charAt(i4 & 15) | ("0123456789ABCDEF".charAt(i4 >> 4) << '\b');
        }
        int[] iArr3 = new int[256];
        for (int i5 = 0; i5 < 256; i5++) {
            iArr3[i5] = -1;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i6)] = i7;
            i6++;
            i7++;
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i8)] = i9;
            i8++;
            i9++;
        }
        long[] jArr = new long[256];
        for (int i10 = 0; i10 < 256; i10++) {
            jArr[i10] = -1;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i11)] = i12;
            i11++;
            i12++;
        }
        int i13 = 0;
        while (i2 < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i2)] = i13;
            i2++;
            i13++;
        }
    }
}
