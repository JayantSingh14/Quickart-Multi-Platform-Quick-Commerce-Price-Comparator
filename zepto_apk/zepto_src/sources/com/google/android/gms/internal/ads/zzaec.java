package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzaec implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final int f22856a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f22857b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f22858c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f22859d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f22860e;

    /* renamed from: f, reason: collision with root package name */
    public final long f22861f;

    public zzaec(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f22857b = iArr;
        this.f22858c = jArr;
        this.f22859d = jArr2;
        this.f22860e = jArr3;
        int length = iArr.length;
        this.f22856a = length;
        if (length <= 0) {
            this.f22861f = 0L;
        } else {
            int i2 = length - 1;
            this.f22861f = jArr2[i2] + jArr3[i2];
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        long[] jArr = this.f22860e;
        int iQ = zzfj.q(jArr, j2, true);
        long j3 = jArr[iQ];
        long[] jArr2 = this.f22858c;
        zzafs zzafsVar = new zzafs(j3, jArr2[iQ]);
        if (j3 >= j2 || iQ == this.f22856a - 1) {
            return new zzafp(zzafsVar, zzafsVar);
        }
        int i2 = iQ + 1;
        return new zzafp(zzafsVar, new zzafs(jArr[i2], jArr2[i2]));
    }

    public final String toString() {
        String string = Arrays.toString(this.f22857b);
        String string2 = Arrays.toString(this.f22858c);
        String string3 = Arrays.toString(this.f22860e);
        String string4 = Arrays.toString(this.f22859d);
        int i2 = this.f22856a;
        int length = String.valueOf(i2).length();
        int length2 = String.valueOf(string).length();
        int length3 = String.valueOf(string2).length();
        StringBuilder sb = new StringBuilder(length + 26 + length2 + 10 + length3 + 9 + String.valueOf(string3).length() + 14 + String.valueOf(string4).length() + 1);
        sb.append("ChunkIndex(length=");
        sb.append(i2);
        sb.append(", sizes=");
        sb.append(string);
        android.support.v4.media.b.B(sb, ", offsets=", string2, ", timeUs=", string3);
        return android.support.v4.media.b.s(sb, ", durationsUs=", string4, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f22861f;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return true;
    }
}
