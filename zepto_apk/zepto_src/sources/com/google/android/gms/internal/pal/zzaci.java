package com.google.android.gms.internal.pal;

import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes4.dex */
final class zzaci implements zzaga {

    /* renamed from: a, reason: collision with root package name */
    public final zzach f37383a;

    public zzaci(zzach zzachVar) {
        Charset charset = zzadg.f37410a;
        this.f37383a = zzachVar;
        zzachVar.f37382a = this;
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void Q(int i2) {
        this.f37383a.m(i2, 3);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void a(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.n(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int iA = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iA += zzach.a(((Integer) list.get(i4)).intValue());
        }
        zzachVar.o(iA);
        while (i3 < list.size()) {
            zzachVar.o(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void b(int i2, Object obj, zzaer zzaerVar) throws zzacf {
        Object obj2 = (zzaef) obj;
        zzace zzaceVar = (zzace) this.f37383a;
        zzaceVar.o((i2 << 3) | 2);
        zzabi zzabiVar = (zzabi) obj2;
        int iB = zzabiVar.b();
        if (iB == -1) {
            iB = zzaerVar.zza(zzabiVar);
            zzabiVar.c(iB);
        }
        zzaceVar.o(iB);
        zzaerVar.c(obj2, zzaceVar.f37382a);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void c(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.p(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int iB = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iB += zzach.b(((Long) list.get(i4)).longValue());
        }
        zzachVar.o(iB);
        while (i3 < list.size()) {
            zzachVar.q(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void d(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.h(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Long) list.get(i5)).getClass();
            i4 += 8;
        }
        zzachVar.o(i4);
        while (i3 < list.size()) {
            zzachVar.i(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void e(int i2, List list) {
        boolean z = list instanceof zzadn;
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.l(i2, (String) list.get(i3));
                i3++;
            }
            return;
        }
        zzadn zzadnVar = (zzadn) list;
        while (i3 < list.size()) {
            Object objZzf = zzadnVar.zzf(i3);
            if (objZzf instanceof String) {
                zzachVar.l(i2, (String) objZzf);
            } else {
                zzachVar.e(i2, (zzaby) objZzf);
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void f(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                zzachVar.n(i2, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int iA = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int iIntValue2 = ((Integer) list.get(i4)).intValue();
            iA += zzach.a((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        zzachVar.o(iA);
        while (i3 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i3)).intValue();
            zzachVar.o((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void g(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.f(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Integer) list.get(i5)).getClass();
            i4 += 4;
        }
        zzachVar.o(i4);
        while (i3 < list.size()) {
            zzachVar.g(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void h(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                zzachVar.p(i2, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int iB = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            long jLongValue2 = ((Long) list.get(i4)).longValue();
            iB += zzach.b((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        zzachVar.o(iB);
        while (i3 < list.size()) {
            long jLongValue3 = ((Long) list.get(i3)).longValue();
            zzachVar.q((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void i(int i2, int i3) {
        this.f37383a.n(i2, (i3 >> 31) ^ (i3 + i3));
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void j(int i2, String str) {
        this.f37383a.l(i2, str);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void k(int i2, int i3) {
        this.f37383a.f(i2, i3);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void l(int i2, Object obj, zzaer zzaerVar) {
        zzach zzachVar = this.f37383a;
        zzachVar.m(i2, 3);
        zzaerVar.c((zzaef) obj, zzachVar.f37382a);
        zzachVar.m(i2, 4);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void m(int i2, zzaby zzabyVar) {
        this.f37383a.e(i2, zzabyVar);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void n(int i2, long j2) {
        this.f37383a.p(i2, (j2 >> 63) ^ (j2 + j2));
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void o(int i2, int i3) {
        this.f37383a.n(i2, i3);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void p(int i2, long j2) {
        this.f37383a.h(i2, j2);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void q(int i2, long j2) {
        this.f37383a.p(i2, j2);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzb(int i2, boolean z) {
        this.f37383a.d(i2, z);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzc(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.d(i2, ((Boolean) list.get(i3)).booleanValue());
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Boolean) list.get(i5)).getClass();
            i4++;
        }
        zzachVar.o(i4);
        while (i3 < list.size()) {
            zzachVar.c(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : (byte) 0);
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zze(int i2, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f37383a.e(i2, (zzaby) list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzf(int i2, double d2) {
        this.f37383a.h(i2, Double.doubleToRawLongBits(d2));
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzg(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.h(i2, Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Double) list.get(i5)).getClass();
            i4 += 8;
        }
        zzachVar.o(i4);
        while (i3 < list.size()) {
            zzachVar.i(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzh(int i2) {
        this.f37383a.m(i2, 4);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzi(int i2, int i3) {
        this.f37383a.j(i2, i3);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzj(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.j(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int iS = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iS += zzach.s(((Integer) list.get(i4)).intValue());
        }
        zzachVar.o(iS);
        while (i3 < list.size()) {
            zzachVar.k(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzk(int i2, int i3) {
        this.f37383a.f(i2, i3);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzl(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.f(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Integer) list.get(i5)).getClass();
            i4 += 4;
        }
        zzachVar.o(i4);
        while (i3 < list.size()) {
            zzachVar.g(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzm(int i2, long j2) {
        this.f37383a.h(i2, j2);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzn(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.h(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Long) list.get(i5)).getClass();
            i4 += 8;
        }
        zzachVar.o(i4);
        while (i3 < list.size()) {
            zzachVar.i(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzo(int i2, float f2) {
        this.f37383a.f(i2, Float.floatToRawIntBits(f2));
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzp(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.f(i2, Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Float) list.get(i5)).getClass();
            i4 += 4;
        }
        zzachVar.o(i4);
        while (i3 < list.size()) {
            zzachVar.g(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzr(int i2, int i3) {
        this.f37383a.j(i2, i3);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzs(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.j(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int iS = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iS += zzach.s(((Integer) list.get(i4)).intValue());
        }
        zzachVar.o(iS);
        while (i3 < list.size()) {
            zzachVar.k(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzt(int i2, long j2) {
        this.f37383a.p(i2, j2);
    }

    @Override // com.google.android.gms.internal.pal.zzaga
    public final void zzu(int i2, List list, boolean z) {
        zzach zzachVar = this.f37383a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzachVar.p(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzachVar.m(i2, 2);
        int iB = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iB += zzach.b(((Long) list.get(i4)).longValue());
        }
        zzachVar.o(iB);
        while (i3 < list.size()) {
            zzachVar.q(((Long) list.get(i3)).longValue());
            i3++;
        }
    }
}
