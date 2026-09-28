package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public class zzaea {

    /* renamed from: a, reason: collision with root package name */
    public final zzadu f22852a;

    /* renamed from: b, reason: collision with root package name */
    public final zzadz f22853b;

    /* renamed from: c, reason: collision with root package name */
    public zzadw f22854c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22855d;

    public zzaea(zzadx zzadxVar, zzadz zzadzVar, long j2, long j3, long j4, long j5, long j6, int i2) {
        this.f22853b = zzadzVar;
        this.f22855d = i2;
        this.f22852a = new zzadu(zzadxVar, j2, j3, j4, j5, j6);
    }

    public static final int c(zzaef zzaefVar, long j2, zzafo zzafoVar) {
        if (j2 == zzaefVar.f22872d) {
            return 0;
        }
        zzafoVar.f22954a = j2;
        return 1;
    }

    public final void a(long j2) {
        zzadw zzadwVar = this.f22854c;
        if (zzadwVar == null || zzadwVar.f22840a != j2) {
            zzadu zzaduVar = this.f22852a;
            this.f22854c = new zzadw(j2, zzaduVar.f22834a.a(j2), zzaduVar.f22836c, zzaduVar.f22837d, zzaduVar.f22838e, zzaduVar.f22839f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c0, code lost:
    
        return c(r30, r8, r31);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(com.google.android.gms.internal.ads.zzaef r30, com.google.android.gms.internal.ads.zzafo r31) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
        L6:
            com.google.android.gms.internal.ads.zzadw r3 = r0.f22854c
            r3.getClass()
            long r4 = r3.f22845f
            long r6 = r3.f22846g
            long r8 = r3.f22847h
            long r6 = r6 - r4
            int r10 = r0.f22855d
            long r10 = (long) r10
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            r7 = 0
            com.google.android.gms.internal.ads.zzadz r10 = r0.f22853b
            if (r6 > 0) goto L26
            r0.f22854c = r7
            r10.zzb()
            int r1 = c(r1, r4, r2)
            return r1
        L26:
            long r4 = r1.f22872d
            long r4 = r8 - r4
            r11 = 0
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 < 0) goto Lbc
            r13 = 262144(0x40000, double:1.295163E-318)
            int r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r6 > 0) goto Lbc
            int r4 = (int) r4
            r5 = 0
            r1.d(r4, r5)
            r1.f22874f = r5
            r15 = r11
            long r11 = r3.f22841b
            com.google.android.gms.internal.ads.zzady r4 = r10.a(r1, r11)
            r6 = -3
            int r11 = r4.f22849a
            if (r11 == r6) goto Lb2
            r6 = -2
            long r8 = r4.f22850b
            r17 = r13
            long r13 = r4.f22851c
            if (r11 == r6) goto L90
            r4 = -1
            if (r11 == r4) goto L70
            long r3 = r1.f22872d
            long r3 = r13 - r3
            int r6 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r6 < 0) goto L66
            int r6 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r6 > 0) goto L66
            int r3 = (int) r3
            r1.d(r3, r5)
        L66:
            r0.f22854c = r7
            r10.zzb()
            int r1 = c(r1, r13, r2)
            return r1
        L70:
            r3.f22844e = r8
            r3.f22846g = r13
            long r4 = r3.f22843d
            long r6 = r3.f22845f
            long r10 = r3.f22842c
            r19 = r4
            long r4 = r3.f22841b
            r17 = r4
            r23 = r6
            r21 = r8
            r27 = r10
            r25 = r13
            long r4 = com.google.android.gms.internal.ads.zzadw.a(r17, r19, r21, r23, r25, r27)
            r3.f22847h = r4
            goto L6
        L90:
            r4 = r8
            r6 = r13
            r3.f22843d = r4
            r3.f22845f = r6
            long r8 = r3.f22844e
            long r10 = r3.f22846g
            long r12 = r3.f22842c
            long r14 = r3.f22841b
            r19 = r4
            r23 = r6
            r21 = r8
            r25 = r10
            r27 = r12
            r17 = r14
            long r4 = com.google.android.gms.internal.ads.zzadw.a(r17, r19, r21, r23, r25, r27)
            r3.f22847h = r4
            goto L6
        Lb2:
            r0.f22854c = r7
            r10.zzb()
            int r1 = c(r1, r8, r2)
            return r1
        Lbc:
            int r1 = c(r1, r8, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaea.b(com.google.android.gms.internal.ads.zzaef, com.google.android.gms.internal.ads.zzafo):int");
    }
}
