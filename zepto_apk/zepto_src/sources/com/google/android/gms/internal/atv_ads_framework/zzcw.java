package com.google.android.gms.internal.atv_ads_framework;

import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes4.dex */
final class zzcw implements zzgg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcv f36104a;

    public zzcw(zzcv zzcvVar) {
        Charset charset = zzdp.f36125a;
        this.f36104a = zzcvVar;
        zzcvVar.f36103a = this;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void A(int i2, int i3) {
        this.f36104a.h(i2, i3);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void B(int i2, int i3) {
        this.f36104a.l(i2, i3);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void C(int i2, int i3) {
        this.f36104a.l(i2, (i3 >> 31) ^ (i3 + i3));
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void D(int i2, zzcn zzcnVar) {
        this.f36104a.c(i2, zzcnVar);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void E(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.d(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Integer) list.get(i5)).getClass();
            i4 += 4;
        }
        zzcvVar.m(i4);
        while (i3 < list.size()) {
            zzcvVar.e(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void F(int i2, long j2) {
        this.f36104a.f(i2, j2);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void G(int i2, String str) {
        this.f36104a.j(i2, str);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void a(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.n(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int iT = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iT += zzcv.t(((Long) list.get(i4)).longValue());
        }
        zzcvVar.m(iT);
        while (i3 < list.size()) {
            zzcvVar.o(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void i(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.d(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Integer) list.get(i5)).getClass();
            i4 += 4;
        }
        zzcvVar.m(i4);
        while (i3 < list.size()) {
            zzcvVar.e(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void j(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.h(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int iQ = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iQ += zzcv.q(((Integer) list.get(i4)).intValue());
        }
        zzcvVar.m(iQ);
        while (i3 < list.size()) {
            zzcvVar.i(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void k(int i2, long j2) {
        this.f36104a.n(i2, j2);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void l(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.n(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int iT = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iT += zzcv.t(((Long) list.get(i4)).longValue());
        }
        zzcvVar.m(iT);
        while (i3 < list.size()) {
            zzcvVar.o(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void m(int i2, List list) {
        boolean z = list instanceof zzdw;
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.j(i2, (String) list.get(i3));
                i3++;
            }
            return;
        }
        zzdw zzdwVar = (zzdw) list;
        while (i3 < list.size()) {
            Object objC = zzdwVar.c(i3);
            if (objC instanceof String) {
                zzcvVar.j(i2, (String) objC);
            } else {
                zzcvVar.c(i2, (zzcn) objC);
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void n(int i2, int i3) {
        this.f36104a.h(i2, i3);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void o(int i2, Object obj, zzey zzeyVar) {
        zzcv zzcvVar = this.f36104a;
        zzcvVar.k(i2, 3);
        zzeyVar.b((zzeo) obj, zzcvVar.f36103a);
        zzcvVar.k(i2, 4);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void p(int i2, long j2) {
        this.f36104a.f(i2, j2);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void q(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.f(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Long) list.get(i5)).getClass();
            i4 += 8;
        }
        zzcvVar.m(i4);
        while (i3 < list.size()) {
            zzcvVar.g(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void r(int i2, long j2) {
        this.f36104a.n(i2, (j2 >> 63) ^ (j2 + j2));
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void s(int i2, int i3) {
        this.f36104a.d(i2, i3);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void t(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.d(i2, Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Float) list.get(i5)).getClass();
            i4 += 4;
        }
        zzcvVar.m(i4);
        while (i3 < list.size()) {
            zzcvVar.e(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void u(int i2, Object obj, zzey zzeyVar) throws zzct {
        zzeo zzeoVar = (zzeo) obj;
        zzcs zzcsVar = (zzcs) this.f36104a;
        zzcsVar.m((i2 << 3) | 2);
        zzcsVar.m(((zzca) zzeoVar).a(zzeyVar));
        zzeyVar.b(zzeoVar, zzcsVar.f36103a);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void v(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.l(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int iS = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iS += zzcv.s(((Integer) list.get(i4)).intValue());
        }
        zzcvVar.m(iS);
        while (i3 < list.size()) {
            zzcvVar.m(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void w(int i2, long j2) {
        this.f36104a.n(i2, j2);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void x(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.h(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int iQ = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iQ += zzcv.q(((Integer) list.get(i4)).intValue());
        }
        zzcvVar.m(iQ);
        while (i3 < list.size()) {
            zzcvVar.i(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void y(int i2, int i3) {
        this.f36104a.d(i2, i3);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void z(float f2, int i2) {
        this.f36104a.d(i2, Float.floatToRawIntBits(f2));
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void zzA(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                zzcvVar.l(i2, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int iS = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int iIntValue2 = ((Integer) list.get(i4)).intValue();
            iS += zzcv.s((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        zzcvVar.m(iS);
        while (i3 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i3)).intValue();
            zzcvVar.m((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void zzC(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                zzcvVar.n(i2, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int iT = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            long jLongValue2 = ((Long) list.get(i4)).longValue();
            iT += zzcv.t((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        zzcvVar.m(iT);
        while (i3 < list.size()) {
            long jLongValue3 = ((Long) list.get(i3)).longValue();
            zzcvVar.o((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void zzb(int i2, boolean z) {
        this.f36104a.b(i2, z);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void zzc(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.b(i2, ((Boolean) list.get(i3)).booleanValue());
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Boolean) list.get(i5)).getClass();
            i4++;
        }
        zzcvVar.m(i4);
        while (i3 < list.size()) {
            zzcvVar.a(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : (byte) 0);
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void zze(int i2, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f36104a.c(i2, (zzcn) list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void zzf(int i2, double d2) {
        this.f36104a.f(i2, Double.doubleToRawLongBits(d2));
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void zzg(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.f(i2, Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Double) list.get(i5)).getClass();
            i4 += 8;
        }
        zzcvVar.m(i4);
        while (i3 < list.size()) {
            zzcvVar.g(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzgg
    public final void zzy(int i2, List list, boolean z) {
        zzcv zzcvVar = this.f36104a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzcvVar.f(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzcvVar.k(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Long) list.get(i5)).getClass();
            i4 += 8;
        }
        zzcvVar.m(i4);
        while (i3 < list.size()) {
            zzcvVar.g(((Long) list.get(i3)).longValue());
            i3++;
        }
    }
}
