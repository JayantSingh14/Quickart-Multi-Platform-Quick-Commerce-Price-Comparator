package com.google.android.gms.internal.ads;

import java.io.File;

/* loaded from: classes4.dex */
public final class zzfvo {

    /* renamed from: a, reason: collision with root package name */
    public final zzbby f31932a;

    /* renamed from: b, reason: collision with root package name */
    public final File f31933b;

    /* renamed from: c, reason: collision with root package name */
    public final File f31934c;

    /* renamed from: d, reason: collision with root package name */
    public final File f31935d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f31936e;

    public zzfvo(zzbby zzbbyVar, File file, File file2, File file3) {
        this.f31932a = zzbbyVar;
        this.f31933b = file;
        this.f31934c = file3;
        this.f31935d = file2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] a() throws java.lang.Throwable {
        /*
            r9 = this;
            byte[] r0 = r9.f31936e
            r1 = 0
            if (r0 != 0) goto L58
            java.io.File r0 = r9.f31935d
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L51
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L51
            com.google.android.gms.internal.ads.zzhzl r0 = com.google.android.gms.internal.ads.zzhzl.f34557b     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L52
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L52
            r0.<init>()     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L52
            r3 = 256(0x100, float:3.59E-43)
        L15:
            byte[] r4 = new byte[r3]     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L52
            r5 = 0
            r6 = r5
        L19:
            if (r6 >= r3) goto L29
            int r7 = r3 - r6
            int r7 = r2.read(r4, r6, r7)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L52
            r8 = -1
            if (r7 != r8) goto L25
            goto L29
        L25:
            int r6 = r6 + r7
            goto L19
        L27:
            r0 = move-exception
            goto L4a
        L29:
            if (r6 != 0) goto L2d
            r4 = r1
            goto L31
        L2d:
            com.google.android.gms.internal.ads.zzhzl r4 = com.google.android.gms.internal.ads.zzhzl.v(r5, r4, r6)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L52
        L31:
            if (r4 != 0) goto L3f
            com.google.android.gms.internal.ads.zzhzl r0 = com.google.android.gms.internal.ads.zzhzl.y(r0)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L52
            byte[] r0 = r0.z()     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L52
            com.google.android.gms.common.util.IOUtils.closeQuietly(r2)
            goto L56
        L3f:
            r0.add(r4)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L52
            int r3 = r3 + r3
            r4 = 8192(0x2000, float:1.14794E-41)
            int r3 = java.lang.Math.min(r3, r4)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L52
            goto L15
        L4a:
            r1 = r2
            goto L4d
        L4c:
            r0 = move-exception
        L4d:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r1)
            throw r0
        L51:
            r2 = r1
        L52:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r2)
            r0 = r1
        L56:
            r9.f31936e = r0
        L58:
            byte[] r0 = r9.f31936e
            if (r0 != 0) goto L5d
            return r1
        L5d:
            int r1 = r0.length
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfvo.a():byte[]");
    }
}
