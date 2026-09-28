package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
final class zzaiy implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final zzaec f23224a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f23225b;

    /* renamed from: c, reason: collision with root package name */
    public final long f23226c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23227d;

    public zzaiy(SparseArray sparseArray, long j2, int i2, long j3, long j4) {
        int i3;
        this.f23225b = sparseArray;
        this.f23226c = j2;
        this.f23227d = i2;
        List list = (List) sparseArray.get(i2);
        zzaec zzaecVar = null;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            int[] iArrCopyOf = new int[size];
            long[] jArrCopyOf = new long[size];
            long[] jArrCopyOf2 = new long[size];
            long[] jArrCopyOf3 = new long[size];
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                zzaix zzaixVar = (zzaix) list.get(i5);
                jArrCopyOf3[i5] = zzaixVar.f23221a;
                jArrCopyOf[i5] = zzaixVar.f23222b;
            }
            while (true) {
                i3 = size - 1;
                if (i4 >= i3) {
                    break;
                }
                int i6 = i4 + 1;
                iArrCopyOf[i4] = (int) (jArrCopyOf[i6] - jArrCopyOf[i4]);
                jArrCopyOf2[i4] = jArrCopyOf3[i6] - jArrCopyOf3[i4];
                i4 = i6;
            }
            int i7 = i3;
            while (i7 > 0 && jArrCopyOf3[i7] >= j2) {
                i7--;
            }
            iArrCopyOf[i7] = (int) ((j3 + j4) - jArrCopyOf[i7]);
            jArrCopyOf2[i7] = j2 - jArrCopyOf3[i7];
            if (i7 < i3) {
                zzee.c("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration.");
                int i8 = i7 + 1;
                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i8);
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i8);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i8);
                jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i8);
            }
            zzaecVar = new zzaec(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
        }
        this.f23224a = zzaecVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        zzaec zzaecVar = this.f23224a;
        if (zzaecVar != null) {
            return zzaecVar.b(j2);
        }
        zzafs zzafsVar = zzafs.f22959c;
        return new zzafp(zzafsVar, zzafsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f23226c;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        List list = (List) this.f23225b.get(this.f23227d);
        return (list == null || list.isEmpty()) ? false : true;
    }
}
