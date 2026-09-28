package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class zzant implements zzalt {

    /* renamed from: a, reason: collision with root package name */
    public final List f23791a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f23792b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f23793c;

    public zzant(ArrayList arrayList) {
        this.f23791a = Collections.unmodifiableList(new ArrayList(arrayList));
        int size = arrayList.size();
        this.f23792b = new long[size + size];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            zzanj zzanjVar = (zzanj) arrayList.get(i2);
            long[] jArr = this.f23792b;
            int i3 = i2 + i2;
            jArr[i3] = zzanjVar.f23761b;
            jArr[i3 + 1] = zzanjVar.f23762c;
        }
        long[] jArr2 = this.f23792b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f23793c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.gms.internal.ads.zzalt
    public final ArrayList b(long j2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (true) {
            List list = this.f23791a;
            if (i2 >= list.size()) {
                break;
            }
            int i3 = i2 + i2;
            long[] jArr = this.f23792b;
            if (jArr[i3] <= j2 && j2 < jArr[i3 + 1]) {
                zzanj zzanjVar = (zzanj) list.get(i2);
                zzcx zzcxVar = zzanjVar.f23760a;
                if (zzcxVar.f27326e == -3.4028235E38f) {
                    arrayList2.add(zzanjVar);
                } else {
                    arrayList.add(zzcxVar);
                }
            }
            i2++;
        }
        Collections.sort(arrayList2, zzans.f23790a);
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            zzcx zzcxVar2 = ((zzanj) arrayList2.get(i4)).f23760a;
            zzcw zzcwVar = new zzcw();
            zzcwVar.f27256a = zzcxVar2.f27322a;
            zzcwVar.f27257b = zzcxVar2.f27325d;
            zzcwVar.f27258c = zzcxVar2.f27323b;
            zzcwVar.f27259d = zzcxVar2.f27324c;
            zzcwVar.f27262g = zzcxVar2.f27328g;
            zzcwVar.f27263h = zzcxVar2.f27329h;
            zzcwVar.f27264i = zzcxVar2.f27330i;
            zzcwVar.f27265j = zzcxVar2.f27333l;
            zzcwVar.f27266k = zzcxVar2.f27334m;
            zzcwVar.f27267l = zzcxVar2.f27331j;
            zzcwVar.f27268m = zzcxVar2.f27332k;
            zzcwVar.n = zzcxVar2.n;
            zzcwVar.o = zzcxVar2.o;
            zzcwVar.p = zzcxVar2.p;
            zzcwVar.f27260e = (-1) - i4;
            zzcwVar.f27261f = 1;
            arrayList.add(zzcwVar.b());
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzalt
    public final int zza() {
        return this.f23793c.length;
    }

    @Override // com.google.android.gms.internal.ads.zzalt
    public final long zzb(int i2) {
        zzgqa.a(i2 >= 0);
        long[] jArr = this.f23793c;
        zzgqa.a(i2 < jArr.length);
        return jArr[i2];
    }
}
