package kotlin.text;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ranges.IntRange;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: classes.dex */
public class CharsKt__CharJVMKt {
    @PublishedApi
    public static int checkRadix(int i2) {
        if (2 <= i2 && i2 < 37) {
            return i2;
        }
        StringBuilder sbU = android.support.v4.media.b.u(i2, "radix ", " was not in valid range ");
        sbU.append(new IntRange(2, 36, 1));
        throw new IllegalArgumentException(sbU.toString());
    }
}
