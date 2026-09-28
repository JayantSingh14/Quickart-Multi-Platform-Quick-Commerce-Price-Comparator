package okhttp3;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class CipherSuite$Companion$ORDER_BY_NAME$1 implements Comparator<String> {
    @Override // java.util.Comparator
    public final int compare(String str, String str2) {
        String a2 = str;
        String b2 = str2;
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        int iMin = Math.min(a2.length(), b2.length());
        for (int i2 = 4; i2 < iMin; i2++) {
            char cCharAt = a2.charAt(i2);
            char cCharAt2 = b2.charAt(i2);
            if (cCharAt != cCharAt2) {
                return Intrinsics.e(cCharAt, cCharAt2) < 0 ? -1 : 1;
            }
        }
        int length = a2.length();
        int length2 = b2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }
}
