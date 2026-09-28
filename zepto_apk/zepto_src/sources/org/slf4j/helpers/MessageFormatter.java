package org.slf4j.helpers;

import java.util.HashMap;

/* loaded from: classes5.dex */
public final class MessageFormatter {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.slf4j.helpers.FormattingTuple a(java.lang.String r7, java.lang.Object[] r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L13
            int r1 = r8.length
            if (r1 != 0) goto L7
            goto L13
        L7:
            int r1 = r8.length
            int r1 = r1 + (-1)
            r1 = r8[r1]
            boolean r2 = r1 instanceof java.lang.Throwable
            if (r2 == 0) goto L13
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            goto L14
        L13:
            r1 = r0
        L14:
            r2 = 0
            if (r1 == 0) goto L30
            if (r8 == 0) goto L28
            int r1 = r8.length
            if (r1 == 0) goto L28
            int r1 = r8.length
            int r1 = r1 + (-1)
            java.lang.Object[] r3 = new java.lang.Object[r1]
            if (r1 <= 0) goto L26
            java.lang.System.arraycopy(r8, r2, r3, r2, r1)
        L26:
            r8 = r3
            goto L30
        L28:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "non-sensical empty or null argument array"
            r7.<init>(r8)
            throw r7
        L30:
            if (r7 != 0) goto L38
            org.slf4j.helpers.FormattingTuple r7 = new org.slf4j.helpers.FormattingTuple
            r7.<init>(r0, r8)
            return r7
        L38:
            if (r8 != 0) goto L40
            org.slf4j.helpers.FormattingTuple r8 = new org.slf4j.helpers.FormattingTuple
            r8.<init>(r7, r0)
            return r8
        L40:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r7.length()
            int r1 = r1 + 50
            r0.<init>(r1)
            r1 = r2
        L4c:
            int r3 = r8.length
            if (r2 >= r3) goto Lb8
            java.lang.String r3 = "{}"
            int r3 = r7.indexOf(r3, r1)
            r4 = -1
            if (r3 != r4) goto L71
            if (r1 != 0) goto L60
            org.slf4j.helpers.FormattingTuple r0 = new org.slf4j.helpers.FormattingTuple
            r0.<init>(r7, r8)
            return r0
        L60:
            int r2 = r7.length()
            r0.append(r7, r1, r2)
            org.slf4j.helpers.FormattingTuple r7 = new org.slf4j.helpers.FormattingTuple
            java.lang.String r0 = r0.toString()
            r7.<init>(r0, r8)
            return r7
        L71:
            if (r3 != 0) goto L74
            goto La7
        L74:
            int r4 = r3 + (-1)
            char r5 = r7.charAt(r4)
            r6 = 92
            if (r5 != r6) goto La7
            r5 = 2
            if (r3 < r5) goto L9a
            int r5 = r3 + (-2)
            char r5 = r7.charAt(r5)
            if (r5 != r6) goto L9a
            r0.append(r7, r1, r4)
            r1 = r8[r2]
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            b(r0, r1, r4)
        L96:
            int r3 = r3 + 2
        L98:
            r1 = r3
            goto Lb5
        L9a:
            int r2 = r2 + (-1)
            r0.append(r7, r1, r4)
            r1 = 123(0x7b, float:1.72E-43)
            r0.append(r1)
            int r3 = r3 + 1
            goto L98
        La7:
            r0.append(r7, r1, r3)
            r1 = r8[r2]
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            b(r0, r1, r4)
            goto L96
        Lb5:
            int r2 = r2 + 1
            goto L4c
        Lb8:
            int r2 = r7.length()
            r0.append(r7, r1, r2)
            org.slf4j.helpers.FormattingTuple r7 = new org.slf4j.helpers.FormattingTuple
            java.lang.String r0 = r0.toString()
            r7.<init>(r0, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.slf4j.helpers.MessageFormatter.a(java.lang.String, java.lang.Object[]):org.slf4j.helpers.FormattingTuple");
    }

    public static void b(StringBuilder sb, Object obj, HashMap map) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        if (!obj.getClass().isArray()) {
            try {
                sb.append(obj.toString());
                return;
            } catch (Throwable th) {
                Util.c("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
                sb.append("[FAILED toString()]");
                return;
            }
        }
        int i2 = 0;
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            sb.append('[');
            int length = zArr.length;
            while (i2 < length) {
                sb.append(zArr[i2]);
                if (i2 != length - 1) {
                    sb.append(", ");
                }
                i2++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            sb.append('[');
            int length2 = bArr.length;
            while (i2 < length2) {
                sb.append((int) bArr[i2]);
                if (i2 != length2 - 1) {
                    sb.append(", ");
                }
                i2++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            sb.append('[');
            int length3 = cArr.length;
            while (i2 < length3) {
                sb.append(cArr[i2]);
                if (i2 != length3 - 1) {
                    sb.append(", ");
                }
                i2++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            sb.append('[');
            int length4 = sArr.length;
            while (i2 < length4) {
                sb.append((int) sArr[i2]);
                if (i2 != length4 - 1) {
                    sb.append(", ");
                }
                i2++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            sb.append('[');
            int length5 = iArr.length;
            while (i2 < length5) {
                sb.append(iArr[i2]);
                if (i2 != length5 - 1) {
                    sb.append(", ");
                }
                i2++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            sb.append('[');
            int length6 = jArr.length;
            while (i2 < length6) {
                sb.append(jArr[i2]);
                if (i2 != length6 - 1) {
                    sb.append(", ");
                }
                i2++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            sb.append('[');
            int length7 = fArr.length;
            while (i2 < length7) {
                sb.append(fArr[i2]);
                if (i2 != length7 - 1) {
                    sb.append(", ");
                }
                i2++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            sb.append('[');
            int length8 = dArr.length;
            while (i2 < length8) {
                sb.append(dArr[i2]);
                if (i2 != length8 - 1) {
                    sb.append(", ");
                }
                i2++;
            }
            sb.append(']');
            return;
        }
        Object[] objArr = (Object[]) obj;
        sb.append('[');
        if (map.containsKey(objArr)) {
            sb.append("...");
        } else {
            map.put(objArr, null);
            int length9 = objArr.length;
            while (i2 < length9) {
                b(sb, objArr[i2], map);
                if (i2 != length9 - 1) {
                    sb.append(", ");
                }
                i2++;
            }
            map.remove(objArr);
        }
        sb.append(']');
    }
}
