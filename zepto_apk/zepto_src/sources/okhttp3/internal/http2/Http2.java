package okhttp3.internal.http2;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.ByteString;

@Metadata
/* loaded from: classes.dex */
public final class Http2 {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f56653a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f56654b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f56655c;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f56656d;

    static {
        ByteString byteString = ByteString.f56924d;
        f56653a = ByteString.Companion.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f56654b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f56655c = new String[64];
        String[] strArr = new String[256];
        for (int i2 = 0; i2 < 256; i2++) {
            String binaryString = Integer.toBinaryString(i2);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(it)");
            strArr[i2] = StringsKt.J(Util.i("%8s", binaryString), ' ', '0');
        }
        f56656d = strArr;
        String[] strArr2 = f56655c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i3 = iArr[0];
        strArr2[i3 | 8] = b.r(new StringBuilder(), strArr2[i3], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            int i6 = iArr[0];
            String[] strArr3 = f56655c;
            int i7 = i6 | i5;
            strArr3[i7] = strArr3[i6] + '|' + strArr3[i5];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i6]);
            sb.append('|');
            strArr3[i7 | 8] = b.r(sb, strArr3[i5], "|PADDED");
        }
        int length = f56655c.length;
        for (int i8 = 0; i8 < length; i8++) {
            String[] strArr4 = f56655c;
            if (strArr4[i8] == null) {
                strArr4[i8] = f56656d[i8];
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            java.lang.String[] r0 = okhttp3.internal.http2.Http2.f56654b
            int r1 = r0.length
            if (r7 >= r1) goto L8
            r0 = r0[r7]
            goto L16
        L8:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r1 = "0x%02x"
            java.lang.String r0 = okhttp3.internal.Util.i(r1, r0)
        L16:
            if (r8 != 0) goto L1b
            java.lang.String r7 = ""
            goto L69
        L1b:
            r1 = 2
            java.lang.String[] r2 = okhttp3.internal.http2.Http2.f56656d
            if (r7 == r1) goto L67
            r1 = 3
            if (r7 == r1) goto L67
            r1 = 4
            if (r7 == r1) goto L5e
            r1 = 6
            if (r7 == r1) goto L5e
            r1 = 7
            if (r7 == r1) goto L67
            r1 = 8
            if (r7 == r1) goto L67
            java.lang.String[] r1 = okhttp3.internal.http2.Http2.f56655c
            int r3 = r1.length
            if (r8 >= r3) goto L3b
            r1 = r1[r8]
            kotlin.jvm.internal.Intrinsics.c(r1)
            goto L3d
        L3b:
            r1 = r2[r8]
        L3d:
            r2 = 5
            if (r7 != r2) goto L4d
            r2 = r8 & 4
            if (r2 == 0) goto L4d
            java.lang.String r7 = "PUSH_PROMISE"
            java.lang.String r8 = "HEADERS"
            java.lang.String r7 = kotlin.text.StringsKt.K(r1, r8, r7)
            goto L69
        L4d:
            if (r7 != 0) goto L5c
            r7 = r8 & 32
            if (r7 == 0) goto L5c
            java.lang.String r7 = "COMPRESSED"
            java.lang.String r8 = "PRIORITY"
            java.lang.String r7 = kotlin.text.StringsKt.K(r1, r8, r7)
            goto L69
        L5c:
            r7 = r1
            goto L69
        L5e:
            r7 = 1
            if (r8 != r7) goto L64
            java.lang.String r7 = "ACK"
            goto L69
        L64:
            r7 = r2[r8]
            goto L69
        L67:
            r7 = r2[r8]
        L69:
            if (r4 == 0) goto L6e
            java.lang.String r4 = "<<"
            goto L70
        L6e:
            java.lang.String r4 = ">>"
        L70:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r4 = new java.lang.Object[]{r4, r5, r6, r0, r7}
            java.lang.String r5 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r4 = okhttp3.internal.Util.i(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2.a(boolean, int, int, int, int):java.lang.String");
    }
}
