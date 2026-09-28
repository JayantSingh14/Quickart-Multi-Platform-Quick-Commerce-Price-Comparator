package com.google.common.net;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.ClassUtils;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class InetAddresses {

    /* renamed from: a, reason: collision with root package name */
    public static final CharMatcher f43269a = CharMatcher.j(ClassUtils.PACKAGE_SEPARATOR_CHAR);

    /* renamed from: b, reason: collision with root package name */
    public static final CharMatcher f43270b = CharMatcher.j(':');

    public static final class TeredoInfo {
    }

    static {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if (r3 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r2 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        r2 = r14.lastIndexOf(58) + 1;
        r10 = r14.substring(0, r2);
        r2 = c(r14.substring(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        if (r2 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        r2 = androidx.fragment.app.e.D(r10, java.lang.Integer.toHexString(((r2[0] & 255) << 8) | (r2[1] & 255)), ":", java.lang.Integer.toHexString((r2[3] & 255) | ((r2[2] & 255) << 8)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
    
        if (r2 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0077, code lost:
    
        r2 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        if (r1 == (-1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        r2 = r2.substring(0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
    
        r1 = com.google.common.net.InetAddresses.f43270b.f(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        if (r1 < 2) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        if (r1 <= 8) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
    
        r1 = r1 + 1;
        r10 = 8 - r1;
        r11 = 0;
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0094, code lost:
    
        if (r11 >= (r2.length() - 1)) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
    
        if (r2.charAt(r11) != ':') goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a2, code lost:
    
        if (r2.charAt(r11 + 1) != ':') goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a4, code lost:
    
        if (r12 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a8, code lost:
    
        r12 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00aa, code lost:
    
        if (r11 != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ac, code lost:
    
        r12 = r10 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b3, code lost:
    
        if (r11 != (r2.length() - 2)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b5, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b7, code lost:
    
        r10 = r12;
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b9, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c0, code lost:
    
        if (r2.charAt(0) != ':') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c6, code lost:
    
        if (r2.charAt(1) == ':') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d3, code lost:
    
        if (r2.charAt(r2.length() - 1) != ':') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00de, code lost:
    
        if (r2.charAt(r2.length() - 2) == ':') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e2, code lost:
    
        if (r12 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e4, code lost:
    
        if (r10 > 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e8, code lost:
    
        if (r12 != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ea, code lost:
    
        if (r1 == 8) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ed, code lost:
    
        r1 = java.nio.ByteBuffer.allocate(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f5, code lost:
    
        if (r2.charAt(0) != ':') goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f8, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fd, code lost:
    
        if (r5 >= r2.length()) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00ff, code lost:
    
        r3 = r2.indexOf(58, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0103, code lost:
    
        if (r3 != (-1)) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0105, code lost:
    
        r3 = r2.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x010d, code lost:
    
        if (r2.charAt(r5) != ':') goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x010f, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0110, code lost:
    
        if (r4 >= r10) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0112, code lost:
    
        r1.putShort(0);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0118, code lost:
    
        r4 = r3 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x011a, code lost:
    
        if (r4 <= 0) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x011d, code lost:
    
        if (r4 > 4) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x011f, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0120, code lost:
    
        if (r5 >= r3) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0122, code lost:
    
        r4 = (r4 << 4) | java.lang.Character.digit(r2.charAt(r5), 16);
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0130, code lost:
    
        r1.putShort((short) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0134, code lost:
    
        r5 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x013c, code lost:
    
        throw new java.lang.NumberFormatException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x013d, code lost:
    
        r8 = r1.array();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0142, code lost:
    
        if (r2 == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0144, code lost:
    
        if (r1 == (-1)) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0147, code lost:
    
        r8 = c(r14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.net.InetAddress a(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.InetAddresses.a(java.lang.String):java.net.InetAddress");
    }

    public static byte b(int i2, int i3, String str) {
        int i4 = i3 - i2;
        if (i4 <= 0 || i4 > 3) {
            throw new NumberFormatException();
        }
        if (i4 > 1 && str.charAt(i2) == '0') {
            throw new NumberFormatException();
        }
        int i5 = 0;
        while (i2 < i3) {
            int i6 = i5 * 10;
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (iDigit < 0) {
                throw new NumberFormatException();
            }
            i5 = i6 + iDigit;
            i2++;
        }
        if (i5 <= 255) {
            return (byte) i5;
        }
        throw new NumberFormatException();
    }

    public static byte[] c(String str) {
        if (f43269a.f(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int iIndexOf = str.indexOf(46, i2);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            try {
                bArr[i3] = b(i2, iIndexOf, str);
                i2 = iIndexOf + 1;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }
}
