package androidx.media3.common.util;

import java.util.Locale;

@UnstableApi
/* loaded from: classes3.dex */
public final class CodecSpecificDataUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f5663a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f5664b = {"", "A", "B", "C"};

    public static String a(int i2, boolean z, int i3, int i4, int[] iArr, int i5) {
        Object[] objArr = {f5664b[i2], Integer.valueOf(i3), Integer.valueOf(i4), Character.valueOf(z ? 'H' : 'L'), Integer.valueOf(i5)};
        int i6 = Util.f5744a;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i7 = 0; i7 < length; i7++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i7])));
        }
        return sb.toString();
    }
}
