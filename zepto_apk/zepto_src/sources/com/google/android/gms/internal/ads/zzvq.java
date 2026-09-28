package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzvq implements zzxy {

    /* renamed from: a, reason: collision with root package name */
    public final zzgtd f35729a;

    /* renamed from: b, reason: collision with root package name */
    public long f35730b;

    public zzvq(List list, List list2) {
        zzgvs zzgvsVar = zzgtd.f33183b;
        zzgta zzgtaVar = new zzgta();
        zzgqa.a(list.size() == list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzgtaVar.c(new zzvp((zzxy) list.get(i2), (List) list2.get(i2)));
        }
        this.f35729a = zzgtaVar.f();
        this.f35730b = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean b(zzli zzliVar) {
        boolean zB;
        boolean z = false;
        do {
            long jZzl = zzl();
            if (jZzl == Long.MIN_VALUE) {
                break;
            }
            int i2 = 0;
            zB = false;
            while (true) {
                zzguy zzguyVar = (zzguy) this.f35729a;
                if (i2 >= zzguyVar.f33234d) {
                    break;
                }
                long jZzl2 = ((zzvp) zzguyVar.get(i2)).f35727a.zzl();
                boolean z2 = jZzl2 != Long.MIN_VALUE && jZzl2 <= zzliVar.f35093a;
                if (jZzl2 == jZzl || z2) {
                    zB |= ((zzvp) zzguyVar.get(i2)).f35727a.b(zzliVar);
                }
                i2++;
            }
            z |= zB;
        } while (zB);
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final void g(long j2) {
        int i2 = 0;
        while (true) {
            zzgtd zzgtdVar = this.f35729a;
            if (i2 >= ((zzguy) zzgtdVar).f33234d) {
                return;
            }
            ((zzvp) ((zzguy) zzgtdVar).get(i2)).g(j2);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzi() {
        int i2 = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            zzgtd zzgtdVar = this.f35729a;
            if (i2 >= ((zzguy) zzgtdVar).f33234d) {
                break;
            }
            zzvp zzvpVar = (zzvp) ((zzguy) zzgtdVar).get(i2);
            long jZzi = zzvpVar.zzi();
            zzgtd zzgtdVar2 = zzvpVar.f35728b;
            if ((zzgtdVar2.contains(1) || zzgtdVar2.contains(2) || zzgtdVar2.contains(4)) && jZzi != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzi);
            }
            if (jZzi != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jZzi);
            }
            i2++;
        }
        if (jMin != Long.MAX_VALUE) {
            this.f35730b = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j2 = this.f35730b;
        return j2 != -9223372036854775807L ? j2 : jMin2;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzl() {
        int i2 = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            zzgtd zzgtdVar = this.f35729a;
            if (i2 >= ((zzguy) zzgtdVar).f33234d) {
                break;
            }
            long jZzl = ((zzvp) ((zzguy) zzgtdVar).get(i2)).zzl();
            if (jZzl != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzl);
            }
            i2++;
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean zzn() {
        int i2 = 0;
        while (true) {
            zzgtd zzgtdVar = this.f35729a;
            if (i2 >= ((zzguy) zzgtdVar).f33234d) {
                return false;
            }
            if (((zzvp) ((zzguy) zzgtdVar).get(i2)).zzn()) {
                return true;
            }
            i2++;
        }
    }
}
