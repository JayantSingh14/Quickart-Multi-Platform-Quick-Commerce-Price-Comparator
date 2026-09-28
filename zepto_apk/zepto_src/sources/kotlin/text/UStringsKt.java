package kotlin.text;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JvmName
/* loaded from: classes.dex */
public final class UStringsKt {
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final byte a(java.lang.String r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.UInt r0 = c(r3)
            r1 = 0
            if (r0 == 0) goto L22
            int r0 = r0.f53557a
            int r2 = com.google.android.gms.internal.pal.a.w(r0)
            if (r2 <= 0) goto L1b
            goto L22
        L1b:
            byte r0 = (byte) r0
            kotlin.UByte r2 = new kotlin.UByte
            r2.<init>(r0)
            goto L23
        L22:
            r2 = r1
        L23:
            if (r2 == 0) goto L28
            byte r3 = r2.f53552a
            return r3
        L28:
            kotlin.text.StringsKt__StringNumberConversionsKt.a(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.UStringsKt.a(java.lang.String):byte");
    }

    public static final int b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntC = c(str);
        if (uIntC != null) {
            return uIntC.f53557a;
        }
        StringsKt__StringNumberConversionsKt.a(str);
        throw null;
    }

    public static final UInt c(String str) {
        int i2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.e(cCharAt, 48) >= 0) {
            i2 = 0;
        } else {
            if (length == 1 || cCharAt != '+') {
                return null;
            }
            i2 = 1;
        }
        UInt.Companion companion = UInt.f53556b;
        int iA = 119304647;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Integer.compare(i3 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                if (iA != 119304647) {
                    return null;
                }
                iA = com.google.android.gms.internal.pal.a.a();
                if (Integer.compare(i3 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                    return null;
                }
            }
            int i4 = i3 * 10;
            int i5 = iDigit + i4;
            if (Integer.compare(i5 ^ Integer.MIN_VALUE, i4 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i2++;
            i3 = i5;
        }
        return new UInt(i3);
    }

    public static final long d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong uLongE = e(str);
        if (uLongE != null) {
            return uLongE.f53562a;
        }
        StringsKt__StringNumberConversionsKt.a(str);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00aa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.ULong e(java.lang.String r23) {
        /*
            r0 = r23
            r1 = 1
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = 10
            kotlin.text.CharsKt__CharJVMKt.checkRadix(r2)
            int r3 = r0.length()
            if (r3 != 0) goto L18
            goto Laa
        L18:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.Intrinsics.e(r5, r6)
            if (r6 >= 0) goto L2f
            if (r3 == r1) goto Laa
            r6 = 43
            if (r5 == r6) goto L2d
            goto Laa
        L2d:
            r5 = r1
            goto L30
        L2f:
            r5 = r4
        L30:
            long r6 = (long) r2
            kotlin.ULong$Companion r8 = kotlin.ULong.f53561b
            r8 = 0
            r10 = 512409557603043100(0x71c71c71c71c71c, double:2.0539100454284282E-274)
            r12 = r8
            r14 = r10
        L3c:
            if (r5 >= r3) goto Lb7
            r16 = r1
            char r1 = r0.charAt(r5)
            int r1 = java.lang.Character.digit(r1, r2)
            if (r1 >= 0) goto L4b
            goto Laa
        L4b:
            r17 = -9223372036854775808
            r19 = r3
            long r2 = r12 ^ r17
            r20 = r5
            long r4 = r14 ^ r17
            int r4 = java.lang.Long.compare(r2, r4)
            if (r4 <= 0) goto L95
            int r4 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r4 != 0) goto Laa
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r4 >= 0) goto L74
            long r4 = r6 ^ r17
            int r4 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r4 >= 0) goto L70
            r14 = r8
            goto L8c
        L70:
            r4 = 1
        L72:
            r14 = r4
            goto L8c
        L74:
            long r14 = r14 / r6
            long r4 = r14 << r16
            long r14 = r4 * r6
            r21 = -1
            long r21 = r21 - r14
            long r14 = r21 ^ r17
            long r21 = r6 ^ r17
            int r14 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r14 < 0) goto L88
            r14 = r16
            goto L89
        L88:
            r14 = 0
        L89:
            long r14 = (long) r14
            long r4 = r4 + r14
            goto L72
        L8c:
            long r4 = r14 ^ r17
            int r2 = java.lang.Long.compare(r2, r4)
            if (r2 <= 0) goto L95
            goto Laa
        L95:
            long r12 = r12 * r6
            kotlin.UInt$Companion r2 = kotlin.UInt.f53556b
            long r1 = (long) r1
            r3 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r1 = r1 & r3
            long r1 = r1 + r12
            long r3 = r1 ^ r17
            long r12 = r12 ^ r17
            int r3 = java.lang.Long.compare(r3, r12)
            if (r3 >= 0) goto Lac
        Laa:
            r0 = 0
            return r0
        Lac:
            int r5 = r20 + 1
            r12 = r1
            r1 = r16
            r3 = r19
            r2 = 10
            r4 = 0
            goto L3c
        Lb7:
            kotlin.ULong r0 = new kotlin.ULong
            r0.<init>(r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.UStringsKt.e(java.lang.String):kotlin.ULong");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final short f(java.lang.String r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.UInt r0 = c(r3)
            r1 = 0
            if (r0 == 0) goto L22
            int r0 = r0.f53557a
            int r2 = com.google.android.gms.internal.pal.a.b(r0)
            if (r2 <= 0) goto L1b
            goto L22
        L1b:
            short r0 = (short) r0
            kotlin.UShort r2 = new kotlin.UShort
            r2.<init>(r0)
            goto L23
        L22:
            r2 = r1
        L23:
            if (r2 == 0) goto L28
            short r3 = r2.f53568a
            return r3
        L28:
            kotlin.text.StringsKt__StringNumberConversionsKt.a(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.UStringsKt.f(java.lang.String):short");
    }
}
