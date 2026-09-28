package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import org.xbill.DNS.WKSRecord;

@Metadata
/* loaded from: classes.dex */
public final class CharMappings {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f56029a = new char[WKSRecord.Service.UUCP_PATH];

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f56030b = new byte[126];

    static {
        int i2 = 0;
        for (int i3 = 0; i3 < 32; i3++) {
        }
        a('b', 8);
        a('t', 9);
        a('n', 10);
        a('f', 12);
        a('r', 13);
        a('/', 47);
        a('\"', 34);
        a('\\', 92);
        while (true) {
            byte[] bArr = f56030b;
            if (i2 >= 33) {
                bArr[9] = 3;
                bArr[10] = 3;
                bArr[13] = 3;
                bArr[32] = 3;
                bArr[44] = 4;
                bArr[58] = 5;
                bArr[123] = 6;
                bArr[125] = 7;
                bArr[91] = 8;
                bArr[93] = 9;
                bArr[34] = 1;
                bArr[92] = 2;
                return;
            }
            bArr[i2] = 127;
            i2++;
        }
    }

    public static void a(char c2, int i2) {
        if (c2 != 'u') {
            f56029a[c2] = (char) i2;
        }
    }
}
