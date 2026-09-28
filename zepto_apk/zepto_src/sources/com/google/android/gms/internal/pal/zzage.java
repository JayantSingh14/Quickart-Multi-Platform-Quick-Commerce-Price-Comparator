package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public abstract class zzage implements zzagd {
    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j2 = ((zzagf) this).f37520a;
        long jZzd = ((zzagd) obj).zzd();
        if (j2 < jZzd) {
            return -1;
        }
        return j2 > jZzd ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzagd) && ((zzagf) this).f37520a == ((zzagd) obj).zzd();
    }

    public final int hashCode() {
        long j2 = ((zzagf) this).f37520a;
        return (int) (j2 ^ (j2 >>> 32));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r8 = this;
            r0 = 3
            r1 = r8
            com.google.android.gms.internal.pal.zzagf r1 = (com.google.android.gms.internal.pal.zzagf) r1
            long r1 = r1.f37520a
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            java.lang.String r4 = "PT"
            r3.append(r4)
            int r4 = com.google.android.gms.internal.pal.zzagh.f37521a
            int r4 = (int) r1
            long r5 = (long) r4
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L5c
            if (r4 >= 0) goto L2b
            r5 = 45
            r3.append(r5)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 == r5) goto L25
            int r4 = -r4
            goto L2b
        L25:
            java.lang.String r4 = "2147483648"
            r3.append(r4)
            goto L63
        L2b:
            r5 = 10
            if (r4 >= r5) goto L36
            int r4 = r4 + 48
            char r4 = (char) r4
            r3.append(r4)
            goto L63
        L36:
            r5 = 100
            if (r4 >= r5) goto L54
            int r5 = r4 + 1
            r6 = 13421772(0xcccccc, float:1.8807908E-38)
            int r5 = r5 * r6
            int r5 = r5 >> 27
            int r6 = r5 + 48
            char r6 = (char) r6
            r3.append(r6)
            int r6 = r5 << 3
            int r4 = r4 - r6
            int r5 = r5 + r5
            int r4 = r4 - r5
            int r4 = r4 + 48
            char r4 = (char) r4
            r3.append(r4)
            goto L63
        L54:
            java.lang.String r4 = java.lang.Integer.toString(r4)
            r3.append(r4)
            goto L63
        L5c:
            java.lang.String r4 = java.lang.Long.toString(r1)
            r3.append(r4)
        L63:
            int r4 = r3.length()
            r5 = 0
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 >= 0) goto L6f
            r6 = 7
            goto L70
        L6f:
            r6 = 6
        L70:
            if (r4 >= r6) goto L7d
            if (r5 >= 0) goto L76
            r4 = r0
            goto L77
        L76:
            r4 = 2
        L77:
            java.lang.String r5 = "0"
            r3.insert(r4, r5)
            goto L63
        L7d:
            r4 = 1000(0x3e8, double:4.94E-321)
            long r6 = r1 / r4
            long r6 = r6 * r4
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r0 != 0) goto L90
            int r0 = r3.length()
            int r0 = r0 + (-3)
            r3.setLength(r0)
            goto L9b
        L90:
            int r0 = r3.length()
            int r0 = r0 + (-3)
            java.lang.String r1 = "."
            r3.insert(r0, r1)
        L9b:
            r0 = 83
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzage.toString():java.lang.String");
    }
}
