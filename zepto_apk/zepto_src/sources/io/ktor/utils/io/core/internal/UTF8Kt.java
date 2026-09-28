package io.ktor.utils.io.core.internal;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UTF8Kt {
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0201, code lost:
    
        r8.f53798a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x024d, code lost:
    
        r8.f53798a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0259, code lost:
    
        r8.f53798a = true;
        r2.f53799a = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0262, code lost:
    
        r8.f53798a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0281, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0282, code lost:
    
        r8.f53798a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x028a, code lost:
    
        r8.f53798a = true;
        r2.f53799a = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0293, code lost:
    
        r8.f53798a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0127, code lost:
    
        r8.f53798a = true;
        r28 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0141, code lost:
    
        r8.f53798a = true;
        r2.f53799a = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014d, code lost:
    
        r8.f53798a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01bb, code lost:
    
        r5.c(r21 - r15);
        r0 = r7.f53799a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e7, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e8, code lost:
    
        r8.f53798a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f8, code lost:
    
        r8.f53798a = true;
        r2.f53799a = 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:133:0x027d A[Catch: all -> 0x01ef, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x01ef, blocks: (B:89:0x01e3, B:115:0x0248, B:133:0x027d), top: B:227:0x01e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x030c A[Catch: all -> 0x0146, TryCatch #2 {all -> 0x0146, blocks: (B:60:0x014f, B:156:0x02fd, B:158:0x0303, B:159:0x0306, B:166:0x0313, B:162:0x030c, B:154:0x02e3, B:54:0x0141, B:57:0x0149, B:59:0x014d, B:63:0x0159, B:65:0x015d, B:67:0x0168, B:68:0x017f, B:69:0x0180, B:70:0x0185, B:71:0x0186, B:73:0x018c, B:76:0x0194, B:78:0x019a, B:79:0x01ab, B:81:0x01bb, B:82:0x01c3, B:84:0x01d4, B:86:0x01dc, B:92:0x01e8, B:102:0x0203, B:93:0x01eb, B:147:0x02aa, B:98:0x01f8, B:99:0x01fd, B:101:0x0201, B:103:0x020e, B:105:0x0212, B:106:0x0216, B:108:0x021d, B:109:0x0234, B:110:0x0235, B:112:0x023d, B:118:0x024d, B:143:0x0295, B:119:0x0250, B:130:0x0272, B:136:0x0282, B:139:0x028a, B:140:0x028f, B:142:0x0293, B:144:0x02a0, B:146:0x02a4, B:148:0x02ad, B:149:0x02c4, B:122:0x0259, B:123:0x025e, B:125:0x0262, B:127:0x0266, B:129:0x026a, B:150:0x02c5, B:151:0x02dc, B:152:0x02dd, B:153:0x02e2, B:155:0x02f0), top: B:220:0x0303 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0303 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x035f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Appendable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009b -> B:23:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(java.lang.StringBuilder r30, int r31, kotlin.jvm.functions.Function2 r32, kotlin.jvm.functions.Function1 r33, kotlin.coroutines.jvm.internal.ContinuationImpl r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 965
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.a(java.lang.StringBuilder, int, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0118, code lost:
    
        if (r9 != r11) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011a, code lost:
    
        r11 = r8 - r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011c, code lost:
    
        if (r11 <= 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011e, code lost:
    
        if (r10 < r7) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0122, code lost:
    
        r12 = r10 + 1;
        r21 = r24.charAt(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012c, code lost:
    
        if (java.lang.Character.isHighSurrogate(r21) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012e, code lost:
    
        r10 = r12;
        r21 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012f, code lost:
    
        r12 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0132, code lost:
    
        if (r12 == r7) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013c, code lost:
    
        if (java.lang.Character.isLowSurrogate(r24.charAt(r12)) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013f, code lost:
    
        r10 = r10 + 2;
        r21 = ((r21 - 55232) << 10) | (r24.charAt(r12) - 56320);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014d, code lost:
    
        r10 = r12;
        r12 = 63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0150, code lost:
    
        if (r5 > r12) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0152, code lost:
    
        if (r12 >= 128) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0154, code lost:
    
        r21 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0157, code lost:
    
        if (128 > r12) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0159, code lost:
    
        if (r12 >= 2048) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015b, code lost:
    
        r21 = r5;
        r5 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0160, code lost:
    
        if (2048 > r12) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0162, code lost:
    
        if (r12 >= 65536) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0164, code lost:
    
        r21 = r5;
        r5 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0169, code lost:
    
        if (65536 > r12) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016b, code lost:
    
        if (r12 >= 1114112) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016d, code lost:
    
        r21 = r5;
        r5 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0171, code lost:
    
        if (r5 <= r11) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0173, code lost:
    
        r10 = r10 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0177, code lost:
    
        if (r12 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0179, code lost:
    
        if (r12 >= 128) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x017b, code lost:
    
        r23.put(r9, (byte) r12);
        r5 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0182, code lost:
    
        if (128 > r12) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0184, code lost:
    
        if (r12 >= 2048) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0186, code lost:
    
        r23.put(r9, (byte) (((r12 >> 6) & 31) | 192));
        r23.put(r9 + 1, (byte) ((r12 & 63) | 128));
        r5 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x019c, code lost:
    
        if (2048 > r12) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x019e, code lost:
    
        if (r12 >= 65536) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a0, code lost:
    
        r23.put(r9, (byte) (((r12 >> 12) & 15) | 224));
        r23.put(r9 + 1, (byte) (((r12 >> 6) & 63) | 128));
        r23.put(r9 + 2, (byte) ((r12 & 63) | 128));
        r5 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01c1, code lost:
    
        if (65536 > r12) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01c3, code lost:
    
        if (r12 >= 1114112) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01c5, code lost:
    
        r23.put(r9, (byte) (((r12 >> 18) & 7) | 240));
        r23.put(r9 + 1, (byte) (((r12 >> 12) & 63) | 128));
        r23.put(r9 + 2, (byte) (((r12 >> 6) & 63) | 128));
        r23.put(r9 + 3, (byte) ((r12 & 63) | 128));
        r5 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01f0, code lost:
    
        r9 = r9 + r5;
        r5 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01f5, code lost:
    
        h(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01f8, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01f9, code lost:
    
        h(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01fc, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01fd, code lost:
    
        r0 = (short) (r10 - r25);
        r1 = kotlin.UShort.f53567b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x020d, code lost:
    
        r0 = (short) (r10 - r25);
        r1 = kotlin.UShort.f53567b;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00df  */
    /* JADX WARN: Type inference failed for: r21v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int b(java.nio.ByteBuffer r23, java.lang.CharSequence r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.b(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int):int");
    }

    public static final int c(int i2) {
        return (i2 >>> 10) + 55232;
    }

    public static final boolean d(int i2) {
        return (i2 >>> 16) == 0;
    }

    public static final boolean e(int i2) {
        return i2 <= 1114111;
    }

    public static final int f(int i2) {
        return (i2 & 1023) + 56320;
    }

    public static final void g(int i2) throws MalformedUTF8InputException {
        throw new MalformedUTF8InputException(b.g(i2, "Expected ", " more character bytes"));
    }

    public static final void h(int i2) {
        throw new IllegalArgumentException(b.g(i2, "Malformed code-point ", " found"));
    }
}
