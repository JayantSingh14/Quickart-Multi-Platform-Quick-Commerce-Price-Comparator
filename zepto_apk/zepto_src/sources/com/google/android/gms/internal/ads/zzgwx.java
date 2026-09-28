package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.xbill.DNS.TTL;

/* loaded from: classes4.dex */
public final class zzgwx extends zzgwy {
    public static int a(long j2) {
        int i2 = (int) j2;
        zzgqa.d(j2, "Out of range: %s", ((long) i2) == j2);
        return i2;
    }

    public static int b(long j2) {
        if (j2 > TTL.MAX_VALUE) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }

    public static int c(byte b2, byte b3, byte b4, byte b5) {
        return (b2 << 24) | ((b3 & 255) << 16) | ((b4 & 255) << 8) | (b5 & 255);
    }

    public static int[] d(AbstractCollection abstractCollection) {
        if (abstractCollection instanceof zzgww) {
            zzgww zzgwwVar = (zzgww) abstractCollection;
            return Arrays.copyOfRange(zzgwwVar.f33300a, zzgwwVar.f33301b, zzgwwVar.f33302c);
        }
        Object[] array = abstractCollection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = array[i2];
            obj.getClass();
            iArr[i2] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static List e(int... iArr) {
        int length = iArr.length;
        return length == 0 ? Collections.EMPTY_LIST : new zzgww(0, length, iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer f(java.lang.String r15) {
        /*
            r0 = 1
            r15.getClass()
            boolean r1 = r15.isEmpty()
            r2 = 0
            if (r1 == 0) goto Le
        Lb:
            r15 = r2
            goto L7f
        Le:
            r1 = 0
            char r3 = r15.charAt(r1)
            r4 = 45
            if (r3 != r4) goto L18
            r1 = r0
        L18:
            int r5 = r15.length()
            if (r1 != r5) goto L1f
            goto Lb
        L1f:
            int r5 = r1 + 1
            char r1 = r15.charAt(r1)
            r6 = -1
            r7 = 128(0x80, float:1.794E-43)
            if (r1 >= r7) goto L2f
            byte[] r8 = com.google.android.gms.internal.ads.zzgwz.f33303a
            r1 = r8[r1]
            goto L32
        L2f:
            byte[] r1 = com.google.android.gms.internal.ads.zzgwz.f33303a
            r1 = r6
        L32:
            if (r1 < 0) goto Lb
            r8 = 10
            if (r1 < r8) goto L39
            goto Lb
        L39:
            int r1 = -r1
            long r9 = (long) r1
        L3b:
            int r1 = r15.length()
            r11 = -9223372036854775808
            if (r5 >= r1) goto L6e
            int r1 = r5 + 1
            char r5 = r15.charAt(r5)
            if (r5 >= r7) goto L50
            byte[] r13 = com.google.android.gms.internal.ads.zzgwz.f33303a
            r5 = r13[r5]
            goto L53
        L50:
            byte[] r5 = com.google.android.gms.internal.ads.zzgwz.f33303a
            r5 = r6
        L53:
            if (r5 < 0) goto Lb
            if (r5 >= r8) goto Lb
            r13 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r13 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r13 >= 0) goto L61
            goto Lb
        L61:
            r13 = 10
            long r9 = r9 * r13
            long r13 = (long) r5
            long r11 = r11 + r13
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 >= 0) goto L6b
            goto Lb
        L6b:
            long r9 = r9 - r13
            r5 = r1
            goto L3b
        L6e:
            if (r3 != r4) goto L75
            java.lang.Long r15 = java.lang.Long.valueOf(r9)
            goto L7f
        L75:
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L7a
            goto Lb
        L7a:
            long r0 = -r9
            java.lang.Long r15 = java.lang.Long.valueOf(r0)
        L7f:
            if (r15 == 0) goto L98
            long r0 = r15.longValue()
            int r3 = r15.intValue()
            long r3 = (long) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L8f
            goto L98
        L8f:
            int r15 = r15.intValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            return r15
        L98:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgwx.f(java.lang.String):java.lang.Integer");
    }
}
