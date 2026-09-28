package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzakn implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final long f23377a;

    /* renamed from: b, reason: collision with root package name */
    public final zzako[] f23378b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23379c;

    public zzakn(long j2, zzako[] zzakoVarArr, int i2) {
        this.f23377a = j2;
        this.f23378b = zzakoVarArr;
        this.f23379c = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9  */
    @Override // com.google.android.gms.internal.ads.zzafr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzafp b(long r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            com.google.android.gms.internal.ads.zzako[] r3 = r0.f23378b
            int r4 = r3.length
            com.google.android.gms.internal.ads.zzafs r5 = com.google.android.gms.internal.ads.zzafs.f22959c
            if (r4 != 0) goto L11
            com.google.android.gms.internal.ads.zzafp r1 = new com.google.android.gms.internal.ads.zzafp
            r1.<init>(r5, r5)
            return r1
        L11:
            r4 = -1
            int r10 = r0.f23379c
            if (r10 == r4) goto L51
            r11 = r3[r10]
            com.google.android.gms.internal.ads.zzaky r11 = r11.f23381b
            int r12 = com.google.android.gms.internal.ads.zzakp.z
            int r12 = r11.a(r1)
            if (r12 != r4) goto L26
            int r12 = r11.b(r1)
        L26:
            if (r12 != r4) goto L2e
            com.google.android.gms.internal.ads.zzafp r1 = new com.google.android.gms.internal.ads.zzafp
            r1.<init>(r5, r5)
            return r1
        L2e:
            long[] r5 = r11.f23444f
            r13 = r5[r12]
            long[] r15 = r11.f23441c
            r16 = r15[r12]
            int r18 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r18 >= 0) goto L57
            int r6 = r11.f23440b
            int r6 = r6 + r4
            if (r12 >= r6) goto L57
            int r1 = r11.b(r1)
            if (r1 == r4) goto L57
            if (r1 == r12) goto L57
            r6 = r5[r1]
            r1 = r15[r1]
            r20 = r6
            r6 = r1
            r1 = r20
            goto L5e
        L51:
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r13 = r1
        L57:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = -1
        L5e:
            r5 = 0
            r11 = r16
        L61:
            int r15 = r3.length
            if (r5 >= r15) goto Lb5
            if (r5 == r10) goto La5
            r15 = r3[r5]
            com.google.android.gms.internal.ads.zzaky r15 = r15.f23381b
            int r16 = com.google.android.gms.internal.ads.zzakp.z
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = r15.a(r13)
            if (r8 != r4) goto L7b
            int r8 = r15.b(r13)
        L7b:
            long[] r9 = r15.f23441c
            if (r8 != r4) goto L82
            r19 = r5
            goto L8a
        L82:
            r19 = r5
            r4 = r9[r8]
            long r11 = java.lang.Math.min(r4, r11)
        L8a:
            int r4 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r4 == 0) goto La3
            int r4 = r15.a(r1)
            r5 = -1
            if (r4 != r5) goto L99
            int r4 = r15.b(r1)
        L99:
            if (r4 != r5) goto L9c
            goto Lad
        L9c:
            r8 = r9[r4]
            long r6 = java.lang.Math.min(r8, r6)
            goto Lad
        La3:
            r5 = -1
            goto Lad
        La5:
            r19 = r5
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r4
        Lad:
            int r4 = r19 + 1
            r20 = r5
            r5 = r4
            r4 = r20
            goto L61
        Lb5:
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            com.google.android.gms.internal.ads.zzafs r3 = new com.google.android.gms.internal.ads.zzafs
            r3.<init>(r13, r11)
            int r4 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r4 != 0) goto Lc9
            com.google.android.gms.internal.ads.zzafp r1 = new com.google.android.gms.internal.ads.zzafp
            r1.<init>(r3, r3)
            return r1
        Lc9:
            com.google.android.gms.internal.ads.zzafs r4 = new com.google.android.gms.internal.ads.zzafs
            r4.<init>(r1, r6)
            com.google.android.gms.internal.ads.zzafp r1 = new com.google.android.gms.internal.ads.zzafp
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakn.b(long):com.google.android.gms.internal.ads.zzafp");
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f23377a;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return true;
    }
}
