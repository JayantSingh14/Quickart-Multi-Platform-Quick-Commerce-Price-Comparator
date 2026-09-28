package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzfs implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final String f31762a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f31763b;

    /* renamed from: c, reason: collision with root package name */
    public final int f31764c;

    /* renamed from: d, reason: collision with root package name */
    public final int f31765d;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzfs(java.lang.String r7, byte[] r8, int r9, int r10) {
        /*
            r6 = this;
            r6.<init>()
            int r0 = r7.hashCode()
            r1 = 2
            r2 = 3
            r3 = 4
            r4 = 1
            r5 = 0
            switch(r0) {
                case -1949883051: goto L38;
                case -269399509: goto L2e;
                case 1011693540: goto L24;
                case 1098277265: goto L1a;
                case 2002123038: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L42
        L10:
            java.lang.String r0 = "auxiliary.tracks.map"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L42
            r0 = r2
            goto L43
        L1a:
            java.lang.String r0 = "auxiliary.tracks.offset"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L42
            r0 = r4
            goto L43
        L24:
            java.lang.String r0 = "auxiliary.tracks.length"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L42
            r0 = r1
            goto L43
        L2e:
            java.lang.String r0 = "auxiliary.tracks.interleaved"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L42
            r0 = r3
            goto L43
        L38:
            java.lang.String r0 = "com.android.capture.fps"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L42
            r0 = r5
            goto L43
        L42:
            r0 = -1
        L43:
            if (r0 == 0) goto L7c
            if (r0 == r4) goto L6b
            if (r0 == r1) goto L6b
            if (r0 == r2) goto L63
            if (r0 == r3) goto L4e
            goto L8a
        L4e:
            r0 = 75
            if (r10 != r0) goto L5e
            int r10 = r8.length
            if (r10 != r4) goto L5d
            r10 = r8[r5]
            if (r10 == 0) goto L5b
            if (r10 != r4) goto L5d
        L5b:
            r10 = r0
            goto L5f
        L5d:
            r10 = r0
        L5e:
            r4 = r5
        L5f:
            com.google.android.gms.internal.ads.zzgqa.a(r4)
            goto L8a
        L63:
            if (r10 != 0) goto L66
            goto L67
        L66:
            r4 = r5
        L67:
            com.google.android.gms.internal.ads.zzgqa.a(r4)
            goto L8a
        L6b:
            r0 = 78
            if (r10 != r0) goto L77
            int r10 = r8.length
            r1 = 8
            if (r10 != r1) goto L76
            r10 = r0
            goto L78
        L76:
            r10 = r0
        L77:
            r4 = r5
        L78:
            com.google.android.gms.internal.ads.zzgqa.a(r4)
            goto L8a
        L7c:
            r0 = 23
            if (r10 != r0) goto L86
            int r10 = r8.length
            if (r10 != r3) goto L85
            r10 = r0
            goto L87
        L85:
            r10 = r0
        L86:
            r4 = r5
        L87:
            com.google.android.gms.internal.ads.zzgqa.a(r4)
        L8a:
            r6.f31762a = r7
            r6.f31763b = r8
            r6.f31764c = r9
            r6.f31765d = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfs.<init>(java.lang.String, byte[], int, int):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfs.class == obj.getClass()) {
            zzfs zzfsVar = (zzfs) obj;
            if (this.f31762a.equals(zzfsVar.f31762a) && Arrays.equals(this.f31763b, zzfsVar.f31763b) && this.f31764c == zzfsVar.f31764c && this.f31765d == zzfsVar.f31765d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f31763b) + ((this.f31762a.hashCode() + 527) * 31)) * 31) + this.f31764c) * 31) + this.f31765d;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfs.toString():java.lang.String");
    }
}
