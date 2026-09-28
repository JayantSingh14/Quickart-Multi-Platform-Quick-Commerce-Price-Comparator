package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class zzlm implements zzou {

    /* renamed from: a, reason: collision with root package name */
    public final zzll f37082a;

    public zzlm(zzll zzllVar) {
        Charset charset = zzmo.f37112a;
        this.f37082a = zzllVar;
        zzllVar.f37081a = this;
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void A(int i2, boolean z) {
        this.f37082a.j(i2, z);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void a(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmf;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.g(i2, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Integer) list.get(i5)).getClass();
                i4 += 4;
            }
            zzllVar.q(i4);
            while (i3 < list.size()) {
                zzllVar.r(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i3 < zzmfVar.f37111c) {
                zzllVar.g(i2, zzmfVar.d(i3));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzmfVar.f37111c; i7++) {
            zzmfVar.d(i7);
            i6 += 4;
        }
        zzllVar.q(i6);
        while (i3 < zzmfVar.f37111c) {
            zzllVar.r(zzmfVar.d(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void b(int i2, long j2) {
        this.f37082a.h(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void b0(int i2, long j2) {
        this.f37082a.i(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void c(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmf;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    int iIntValue = ((Integer) list.get(i3)).intValue();
                    zzllVar.f(i2, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int iW = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int iIntValue2 = ((Integer) list.get(i4)).intValue();
                iW += zzll.w((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzllVar.q(iW);
            while (i3 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i3)).intValue();
                zzllVar.q((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i3++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i3 < zzmfVar.f37111c) {
                int iD = zzmfVar.d(i3);
                zzllVar.f(i2, (iD >> 31) ^ (iD + iD));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int iW2 = 0;
        for (int i5 = 0; i5 < zzmfVar.f37111c; i5++) {
            int iD2 = zzmfVar.d(i5);
            iW2 += zzll.w((iD2 >> 31) ^ (iD2 + iD2));
        }
        zzllVar.q(iW2);
        while (i3 < zzmfVar.f37111c) {
            int iD3 = zzmfVar.d(i3);
            zzllVar.q((iD3 >> 31) ^ (iD3 + iD3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void d(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmz;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.h(i2, ((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int iA = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iA += zzll.a(((Long) list.get(i4)).longValue());
            }
            zzllVar.q(iA);
            while (i3 < list.size()) {
                zzllVar.s(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z) {
            while (i3 < zzmzVar.size()) {
                zzllVar.h(i2, zzmzVar.l(i3));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int iA2 = 0;
        for (int i5 = 0; i5 < zzmzVar.size(); i5++) {
            iA2 += zzll.a(zzmzVar.l(i5));
        }
        zzllVar.q(iA2);
        while (i3 < zzmzVar.size()) {
            zzllVar.s(zzmzVar.l(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void e(int i2, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f37082a.l(i2, (zzlg) list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void f(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzlx;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.g(i2, Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Float) list.get(i5)).getClass();
                i4 += 4;
            }
            zzllVar.q(i4);
            while (i3 < list.size()) {
                zzllVar.r(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                i3++;
            }
            return;
        }
        zzlx zzlxVar = (zzlx) list;
        if (!z) {
            while (i3 < zzlxVar.size()) {
                zzllVar.g(i2, Float.floatToRawIntBits(zzlxVar.d(i3)));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzlxVar.size(); i7++) {
            zzlxVar.d(i7);
            i6 += 4;
        }
        zzllVar.q(i6);
        while (i3 < zzlxVar.size()) {
            zzllVar.r(Float.floatToRawIntBits(zzlxVar.d(i3)));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void g(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmf;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.g(i2, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Integer) list.get(i5)).getClass();
                i4 += 4;
            }
            zzllVar.q(i4);
            while (i3 < list.size()) {
                zzllVar.r(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i3 < zzmfVar.f37111c) {
                zzllVar.g(i2, zzmfVar.d(i3));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzmfVar.f37111c; i7++) {
            zzmfVar.d(i7);
            i6 += 4;
        }
        zzllVar.q(i6);
        while (i3 < zzmfVar.f37111c) {
            zzllVar.r(zzmfVar.d(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void h(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmf;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.e(i2, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int iA = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iA += zzll.a(((Integer) list.get(i4)).intValue());
            }
            zzllVar.q(iA);
            while (i3 < list.size()) {
                zzllVar.p(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i3 < zzmfVar.f37111c) {
                zzllVar.e(i2, zzmfVar.d(i3));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int iA2 = 0;
        for (int i5 = 0; i5 < zzmfVar.f37111c; i5++) {
            iA2 += zzll.a(zzmfVar.d(i5));
        }
        zzllVar.q(iA2);
        while (i3 < zzmfVar.f37111c) {
            zzllVar.p(zzmfVar.d(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void i(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmf;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.e(i2, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int iA = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iA += zzll.a(((Integer) list.get(i4)).intValue());
            }
            zzllVar.q(iA);
            while (i3 < list.size()) {
                zzllVar.p(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i3 < zzmfVar.f37111c) {
                zzllVar.e(i2, zzmfVar.d(i3));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int iA2 = 0;
        for (int i5 = 0; i5 < zzmfVar.f37111c; i5++) {
            iA2 += zzll.a(zzmfVar.d(i5));
        }
        zzllVar.q(iA2);
        while (i3 < zzmfVar.f37111c) {
            zzllVar.p(zzmfVar.d(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void j(int i2, Object obj, zznw zznwVar) {
        zznl zznlVar = (zznl) obj;
        zzlj zzljVar = (zzlj) this.f37082a;
        zzljVar.q((i2 << 3) | 2);
        zzljVar.q(((zzkr) zznlVar).g(zznwVar));
        zznwVar.e(zznlVar, zzljVar.f37081a);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void k(float f2, int i2) {
        this.f37082a.g(i2, Float.floatToRawIntBits(f2));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void l(int i2, int i3) {
        this.f37082a.g(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void m(int i2, Object obj, zznw zznwVar) {
        zzll zzllVar = this.f37082a;
        zzllVar.d(i2, 3);
        zznwVar.e((zznl) obj, zzllVar.f37081a);
        zzllVar.d(i2, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void n(int i2, long j2) {
        this.f37082a.h(i2, (j2 >> 63) ^ (j2 + j2));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void o(int i2) {
        this.f37082a.d(i2, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void p(int i2, String str) {
        this.f37082a.k(i2, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void q(int i2, int i3) {
        this.f37082a.e(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void r(int i2, zznd zzndVar, zznf zznfVar) {
        for (Map.Entry entry : zznfVar.entrySet()) {
            zzll zzllVar = this.f37082a;
            zzllVar.d(i2, 2);
            zzllVar.q(zzne.b(zzndVar, entry.getKey(), entry.getValue()));
            zzne.a(zzllVar, zzndVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void s(int i2, long j2) {
        this.f37082a.i(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void t(int i2, zzlg zzlgVar) {
        this.f37082a.l(i2, zzlgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void u(int i2, long j2) {
        this.f37082a.h(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void v(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmf;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.f(i2, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int iW = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iW += zzll.w(((Integer) list.get(i4)).intValue());
            }
            zzllVar.q(iW);
            while (i3 < list.size()) {
                zzllVar.q(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i3 < zzmfVar.f37111c) {
                zzllVar.f(i2, zzmfVar.d(i3));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int iW2 = 0;
        for (int i5 = 0; i5 < zzmfVar.f37111c; i5++) {
            iW2 += zzll.w(zzmfVar.d(i5));
        }
        zzllVar.q(iW2);
        while (i3 < zzmfVar.f37111c) {
            zzllVar.q(zzmfVar.d(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void w(int i2, int i3) {
        this.f37082a.f(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void x(int i2, List list) {
        boolean z = list instanceof zzmw;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzllVar.k(i2, (String) list.get(i3));
                i3++;
            }
            return;
        }
        zzmw zzmwVar = (zzmw) list;
        while (i3 < list.size()) {
            Object objZzc = zzmwVar.zzc();
            if (objZzc instanceof String) {
                zzllVar.k(i2, (String) objZzc);
            } else {
                zzllVar.l(i2, (zzlg) objZzc);
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void y(int i2, int i3) {
        this.f37082a.f(i2, (i3 >> 31) ^ (i3 + i3));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void y0(int i2) {
        this.f37082a.d(i2, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void z(int i2, Object obj) {
        boolean z = obj instanceof zzlg;
        zzll zzllVar = this.f37082a;
        if (z) {
            zzlj zzljVar = (zzlj) zzllVar;
            zzljVar.q(11);
            zzljVar.f(2, i2);
            zzljVar.l(3, (zzlg) obj);
            zzljVar.q(12);
            return;
        }
        zzlj zzljVar2 = (zzlj) zzllVar;
        zzljVar2.q(11);
        zzljVar2.f(2, i2);
        zzljVar2.q(26);
        zzljVar2.n((zznl) obj);
        zzljVar2.q(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzA(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmz;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.i(i2, ((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Long) list.get(i5)).getClass();
                i4 += 8;
            }
            zzllVar.q(i4);
            while (i3 < list.size()) {
                zzllVar.t(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z) {
            while (i3 < zzmzVar.size()) {
                zzllVar.i(i2, zzmzVar.l(i3));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzmzVar.size(); i7++) {
            zzmzVar.l(i7);
            i6 += 8;
        }
        zzllVar.q(i6);
        while (i3 < zzmzVar.size()) {
            zzllVar.t(zzmzVar.l(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzC(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzln;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.i(i2, Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Double) list.get(i5)).getClass();
                i4 += 8;
            }
            zzllVar.q(i4);
            while (i3 < list.size()) {
                zzllVar.t(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                i3++;
            }
            return;
        }
        zzln zzlnVar = (zzln) list;
        if (!z) {
            while (i3 < zzlnVar.size()) {
                zzllVar.i(i2, Double.doubleToRawLongBits(zzlnVar.d(i3)));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzlnVar.size(); i7++) {
            zzlnVar.d(i7);
            i6 += 8;
        }
        zzllVar.q(i6);
        while (i3 < zzlnVar.size()) {
            zzllVar.t(Double.doubleToRawLongBits(zzlnVar.d(i3)));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzE(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzkx;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.j(i2, ((Boolean) list.get(i3)).booleanValue());
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Boolean) list.get(i5)).getClass();
                i4++;
            }
            zzllVar.q(i4);
            while (i3 < list.size()) {
                zzllVar.o(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : (byte) 0);
                i3++;
            }
            return;
        }
        zzkx zzkxVar = (zzkx) list;
        if (!z) {
            while (i3 < zzkxVar.size()) {
                zzllVar.j(i2, zzkxVar.d(i3));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzkxVar.size(); i7++) {
            zzkxVar.d(i7);
            i6++;
        }
        zzllVar.q(i6);
        while (i3 < zzkxVar.size()) {
            zzllVar.o(zzkxVar.d(i3) ? (byte) 1 : (byte) 0);
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzJ(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmz;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.i(i2, ((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Long) list.get(i5)).getClass();
                i4 += 8;
            }
            zzllVar.q(i4);
            while (i3 < list.size()) {
                zzllVar.t(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z) {
            while (i3 < zzmzVar.size()) {
                zzllVar.i(i2, zzmzVar.l(i3));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < zzmzVar.size(); i7++) {
            zzmzVar.l(i7);
            i6 += 8;
        }
        zzllVar.q(i6);
        while (i3 < zzmzVar.size()) {
            zzllVar.t(zzmzVar.l(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzL(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmz;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    long jLongValue = ((Long) list.get(i3)).longValue();
                    zzllVar.h(i2, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int iA = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long jLongValue2 = ((Long) list.get(i4)).longValue();
                iA += zzll.a((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzllVar.q(iA);
            while (i3 < list.size()) {
                long jLongValue3 = ((Long) list.get(i3)).longValue();
                zzllVar.s((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i3++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z) {
            while (i3 < zzmzVar.size()) {
                long jL = zzmzVar.l(i3);
                zzllVar.h(i2, (jL >> 63) ^ (jL + jL));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int iA2 = 0;
        for (int i5 = 0; i5 < zzmzVar.size(); i5++) {
            long jL2 = zzmzVar.l(i5);
            iA2 += zzll.a((jL2 >> 63) ^ (jL2 + jL2));
        }
        zzllVar.q(iA2);
        while (i3 < zzmzVar.size()) {
            long jL3 = zzmzVar.l(i3);
            zzllVar.s((jL3 >> 63) ^ (jL3 + jL3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzf(int i2, double d2) {
        this.f37082a.i(i2, Double.doubleToRawLongBits(d2));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzi(int i2, int i3) {
        this.f37082a.e(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzk(int i2, int i3) {
        this.f37082a.g(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzy(int i2, List list, boolean z) {
        boolean z2 = list instanceof zzmz;
        zzll zzllVar = this.f37082a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    zzllVar.h(i2, ((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            zzllVar.d(i2, 2);
            int iA = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iA += zzll.a(((Long) list.get(i4)).longValue());
            }
            zzllVar.q(iA);
            while (i3 < list.size()) {
                zzllVar.s(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z) {
            while (i3 < zzmzVar.size()) {
                zzllVar.h(i2, zzmzVar.l(i3));
                i3++;
            }
            return;
        }
        zzllVar.d(i2, 2);
        int iA2 = 0;
        for (int i5 = 0; i5 < zzmzVar.size(); i5++) {
            iA2 += zzll.a(zzmzVar.l(i5));
        }
        zzllVar.q(iA2);
        while (i3 < zzmzVar.size()) {
            zzllVar.s(zzmzVar.l(i3));
            i3++;
        }
    }
}
