package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzaif {

    /* renamed from: a, reason: collision with root package name */
    public static final zzaic f23183a = null;

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0006, B:7:0x0013, B:20:0x003e, B:23:0x0049, B:25:0x006b, B:29:0x0071, B:41:0x008d, B:42:0x008f, B:45:0x0095, B:48:0x009f, B:31:0x007b, B:35:0x0082, B:10:0x0023), top: B:54:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0006, B:7:0x0013, B:20:0x003e, B:23:0x0049, B:25:0x006b, B:29:0x0071, B:41:0x008d, B:42:0x008f, B:45:0x0095, B:48:0x009f, B:31:0x007b, B:35:0x0082, B:10:0x0023), top: B:54:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(com.google.android.gms.internal.ads.zzer r21, int r22, int r23, boolean r24) {
        /*
            r1 = r21
            r0 = r22
            int r2 = r1.f30145b
        L6:
            int r3 = r1.B()     // Catch: java.lang.Throwable -> L20
            r4 = 1
            r5 = r23
            if (r3 < r5) goto La5
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L23
            int r7 = r1.b()     // Catch: java.lang.Throwable -> L20
            long r8 = r1.P()     // Catch: java.lang.Throwable -> L20
            int r10 = r1.L()     // Catch: java.lang.Throwable -> L20
            goto L2d
        L20:
            r0 = move-exception
            goto La9
        L23:
            int r7 = r1.O()     // Catch: java.lang.Throwable -> L20
            int r8 = r1.O()     // Catch: java.lang.Throwable -> L20
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L20
            r10 = r6
        L2d:
            r11 = 0
            if (r7 != 0) goto L39
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L39
            if (r10 != 0) goto L39
            goto La5
        L39:
            r7 = 4
            if (r0 != r7) goto L69
            if (r24 != 0) goto L69
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L49
        L46:
            r4 = r6
            goto La5
        L49:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            r17 = 16
            long r17 = r8 >> r17
            r19 = 24
            long r8 = r8 >> r19
            long r15 = r15 & r11
            long r11 = r17 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
        L69:
            if (r0 != r7) goto L79
            r3 = r10 & 64
            if (r3 == 0) goto L70
            goto L71
        L70:
            r4 = r6
        L71:
            r3 = r10 & 1
            r20 = r4
            r4 = r3
            r3 = r20
            goto L8b
        L79:
            if (r0 != r3) goto L89
            r3 = r10 & 32
            if (r3 == 0) goto L81
            r3 = r4
            goto L82
        L81:
            r3 = r6
        L82:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L87
            goto L8b
        L87:
            r4 = r6
            goto L8b
        L89:
            r3 = r6
            r4 = r3
        L8b:
            if (r4 == 0) goto L8f
            int r3 = r3 + 4
        L8f:
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L20
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L95
            goto L46
        L95:
            int r3 = r1.B()     // Catch: java.lang.Throwable -> L20
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L20
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto L9f
            goto L46
        L9f:
            int r3 = (int) r8     // Catch: java.lang.Throwable -> L20
            r1.G(r3)     // Catch: java.lang.Throwable -> L20
            goto L6
        La5:
            r1.E(r2)
            return r4
        La9:
            r1.E(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.a(com.google.android.gms.internal.ads.zzer, int, int, boolean):boolean");
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:153:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0297 A[Catch: all -> 0x0130, Exception -> 0x0255, OutOfMemoryError -> 0x025a, TRY_LEAVE, TryCatch #0 {all -> 0x0130, blocks: (B:83:0x0105, B:92:0x013e, B:95:0x0145, B:106:0x016f, B:109:0x01a1, B:117:0x01cc, B:119:0x01e0, B:121:0x01e7, B:120:0x01e3, B:135:0x0206, B:137:0x021d, B:139:0x0244, B:141:0x024b, B:140:0x0247, B:164:0x0284, B:166:0x0297, B:168:0x02a0, B:180:0x02e4, B:182:0x0301, B:184:0x0308, B:183:0x0304, B:176:0x02c2, B:178:0x02de, B:196:0x0326, B:202:0x0367, B:206:0x03a1, B:210:0x03ae, B:211:0x03b4, B:213:0x03ba, B:215:0x03c1, B:216:0x03c5, B:224:0x03e6, B:228:0x0411, B:230:0x041c, B:231:0x044e, B:232:0x0459, B:234:0x045f, B:236:0x0466, B:237:0x046a, B:242:0x0483, B:249:0x0494, B:251:0x04be, B:252:0x04cd, B:253:0x04d8), top: B:265:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02c2 A[Catch: all -> 0x0130, Exception -> 0x02bc, OutOfMemoryError -> 0x02bf, TryCatch #0 {all -> 0x0130, blocks: (B:83:0x0105, B:92:0x013e, B:95:0x0145, B:106:0x016f, B:109:0x01a1, B:117:0x01cc, B:119:0x01e0, B:121:0x01e7, B:120:0x01e3, B:135:0x0206, B:137:0x021d, B:139:0x0244, B:141:0x024b, B:140:0x0247, B:164:0x0284, B:166:0x0297, B:168:0x02a0, B:180:0x02e4, B:182:0x0301, B:184:0x0308, B:183:0x0304, B:176:0x02c2, B:178:0x02de, B:196:0x0326, B:202:0x0367, B:206:0x03a1, B:210:0x03ae, B:211:0x03b4, B:213:0x03ba, B:215:0x03c1, B:216:0x03c5, B:224:0x03e6, B:228:0x0411, B:230:0x041c, B:231:0x044e, B:232:0x0459, B:234:0x045f, B:236:0x0466, B:237:0x046a, B:242:0x0483, B:249:0x0494, B:251:0x04be, B:252:0x04cd, B:253:0x04d8), top: B:265:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0301 A[Catch: all -> 0x0130, Exception -> 0x02bc, OutOfMemoryError -> 0x02bf, TryCatch #0 {all -> 0x0130, blocks: (B:83:0x0105, B:92:0x013e, B:95:0x0145, B:106:0x016f, B:109:0x01a1, B:117:0x01cc, B:119:0x01e0, B:121:0x01e7, B:120:0x01e3, B:135:0x0206, B:137:0x021d, B:139:0x0244, B:141:0x024b, B:140:0x0247, B:164:0x0284, B:166:0x0297, B:168:0x02a0, B:180:0x02e4, B:182:0x0301, B:184:0x0308, B:183:0x0304, B:176:0x02c2, B:178:0x02de, B:196:0x0326, B:202:0x0367, B:206:0x03a1, B:210:0x03ae, B:211:0x03b4, B:213:0x03ba, B:215:0x03c1, B:216:0x03c5, B:224:0x03e6, B:228:0x0411, B:230:0x041c, B:231:0x044e, B:232:0x0459, B:234:0x045f, B:236:0x0466, B:237:0x046a, B:242:0x0483, B:249:0x0494, B:251:0x04be, B:252:0x04cd, B:253:0x04d8), top: B:265:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0304 A[Catch: all -> 0x0130, Exception -> 0x02bc, OutOfMemoryError -> 0x02bf, TryCatch #0 {all -> 0x0130, blocks: (B:83:0x0105, B:92:0x013e, B:95:0x0145, B:106:0x016f, B:109:0x01a1, B:117:0x01cc, B:119:0x01e0, B:121:0x01e7, B:120:0x01e3, B:135:0x0206, B:137:0x021d, B:139:0x0244, B:141:0x024b, B:140:0x0247, B:164:0x0284, B:166:0x0297, B:168:0x02a0, B:180:0x02e4, B:182:0x0301, B:184:0x0308, B:183:0x0304, B:176:0x02c2, B:178:0x02de, B:196:0x0326, B:202:0x0367, B:206:0x03a1, B:210:0x03ae, B:211:0x03b4, B:213:0x03ba, B:215:0x03c1, B:216:0x03c5, B:224:0x03e6, B:228:0x0411, B:230:0x041c, B:231:0x044e, B:232:0x0459, B:234:0x045f, B:236:0x0466, B:237:0x046a, B:242:0x0483, B:249:0x0494, B:251:0x04be, B:252:0x04cd, B:253:0x04d8), top: B:265:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x04f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzaig b(int r33, com.google.android.gms.internal.ads.zzer r34, boolean r35, com.google.android.gms.internal.ads.zzaic r36) {
        /*
            Method dump skipped, instructions count: 1340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.b(int, com.google.android.gms.internal.ads.zzer, boolean, com.google.android.gms.internal.ads.zzaic):com.google.android.gms.internal.ads.zzaig");
    }

    public static zzgtd c(int i2, byte[] bArr, int i3) {
        if (i3 >= bArr.length) {
            return zzgtd.n("");
        }
        zzgvs zzgvsVar = zzgtd.f33183b;
        zzgta zzgtaVar = new zzgta();
        int iG = g(i3, bArr, i2);
        while (i3 < iG) {
            zzgtaVar.c(new String(bArr, i3, iG - i3, e(i2)));
            i3 = i(i2) + iG;
            iG = g(i3, bArr, i2);
        }
        zzgtd zzgtdVarF = zzgtaVar.f();
        return zzgtdVarF.isEmpty() ? zzgtd.n("") : zzgtdVarF;
    }

    public static int d(int i2, zzer zzerVar) {
        byte[] bArr = zzerVar.f30144a;
        int i3 = zzerVar.f30145b;
        int i4 = i3;
        while (true) {
            int i5 = i4 + 1;
            if (i5 >= i3 + i2) {
                return i2;
            }
            if ((bArr[i4] & 255) == 255 && bArr[i5] == 0) {
                System.arraycopy(bArr, i4 + 2, bArr, i5, (i2 - (i4 - i3)) - 2);
                i2--;
            }
            i4 = i5;
        }
    }

    public static Charset e(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }

    public static String f(int i2, int i3, int i4, int i5, int i6) {
        return i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static int g(int i2, byte[] bArr, int i3) {
        int iH = h(i2, bArr);
        if (i3 == 0 || i3 == 3) {
            return iH;
        }
        while (true) {
            int length = bArr.length;
            if (iH >= length - 1) {
                return length;
            }
            int i4 = iH + 1;
            if ((iH - i2) % 2 == 0 && bArr[i4] == 0) {
                return iH;
            }
            iH = h(i4, bArr);
        }
    }

    public static int h(int i2, byte[] bArr) {
        while (true) {
            int length = bArr.length;
            if (i2 >= length) {
                return length;
            }
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
    }

    public static int i(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    public static String j(byte[] bArr, int i2, int i3, Charset charset) {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, charset);
    }
}
