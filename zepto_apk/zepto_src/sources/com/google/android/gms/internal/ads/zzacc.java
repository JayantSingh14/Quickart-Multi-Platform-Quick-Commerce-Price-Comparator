package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Pair;
import android.util.Range;
import android.view.Surface;
import java.util.List;

/* loaded from: classes4.dex */
final class zzacc implements zzadl {

    /* renamed from: a, reason: collision with root package name */
    public zzgtd f22705a;

    /* renamed from: b, reason: collision with root package name */
    public zzv f22706b;

    /* renamed from: c, reason: collision with root package name */
    public long f22707c;

    /* renamed from: d, reason: collision with root package name */
    public long f22708d;

    /* renamed from: e, reason: collision with root package name */
    public int f22709e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzaci f22710f;

    public zzacc(zzaci zzaciVar, Context context) {
        this.f22710f = zzaciVar;
        zzfj.j(context);
        zzgvs zzgvsVar = zzgtd.f33183b;
        this.f22705a = zzguy.f33232e;
        this.f22708d = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final boolean B0(boolean z) {
        return ((zzabn) this.f22710f.f22719e).f22650a.e(false);
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void N0(boolean z) {
        this.f22708d = -9223372036854775807L;
        final zzaci zzaciVar = this.f22710f;
        if (zzaciVar.n == 1) {
            zzaciVar.f22727m++;
            ((zzabn) zzaciVar.f22719e).N0(z);
            while (zzaciVar.f22724j.b() > 1) {
                zzaciVar.f22724j.c();
            }
            if (zzaciVar.f22724j.b() == 1) {
                ((zzach) zzaciVar.f22724j.c()).getClass();
                zzgvs zzgvsVar = zzgtd.f33183b;
                zzgtd zzgtdVar = zzguy.f33232e;
                throw null;
            }
            zzaciVar.o = -9223372036854775807L;
            zzdx zzdxVar = zzaciVar.f22725k;
            zzdxVar.getClass();
            zzdxVar.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacd
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzaci zzaciVar2 = zzaciVar;
                    zzaciVar2.f22727m--;
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void P(boolean z) {
        zzaci zzaciVar = this.f22710f;
        if (zzaciVar.f22718d) {
            ((zzabn) zzaciVar.f22719e).P(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void Q0(float f2) {
        zzaci zzaciVar = this.f22710f;
        zzacn zzacnVar = zzaciVar.f22723i;
        zzacnVar.getClass();
        zzgqa.a(f2 > 0.0f);
        zzacnVar.f22746d = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d / f2));
        zzacnVar.a();
        ((zzabn) zzaciVar.f22719e).Q0(f2);
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void f() {
        zzaci zzaciVar = this.f22710f;
        if (zzaciVar.f22724j.b() == 0) {
            ((zzabn) zzaciVar.f22719e).f();
            return;
        }
        zzff zzffVar = new zzff(0);
        if (zzaciVar.f22724j.b() <= 0) {
            zzaciVar.f22724j = zzffVar;
        } else {
            ((zzach) zzaciVar.f22724j.c()).getClass();
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void f1(int i2) {
        ((zzabn) this.f22710f.f22719e).f1(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void g1(long j2, long j3) {
        ((zzabn) this.f22710f.f22719e).g1(j2 + this.f22707c, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void h1(Surface surface, zzes zzesVar) {
        zzaci zzaciVar = this.f22710f;
        Pair pair = zzaciVar.f22726l;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzes) zzaciVar.f22726l.second).equals(zzesVar)) {
            return;
        }
        zzaciVar.f22726l = Pair.create(surface, zzesVar);
        zzesVar.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final boolean i1(long j2, zzadj zzadjVar) {
        int i2;
        zzgqa.f(false);
        long j3 = j2 + this.f22707c;
        zzaci zzaciVar = this.f22710f;
        zzacn zzacnVar = zzaciVar.f22723i;
        long j4 = zzacnVar.f22743a == -9223372036854775807L ? -9223372036854775807L : (long) (((j3 - r3) * zzacnVar.f22745c) + zzacnVar.f22744b);
        if (j4 != -9223372036854775807L) {
            long j5 = zzaciVar.f22722h;
            if (j5 != -9223372036854775807L && j4 < j5 && (i2 = this.f22709e) < 2) {
                this.f22709e = i2 + 1;
                ((zzabs) zzadjVar).zzb();
                return true;
            }
        }
        int i3 = zzaciVar.p;
        if (i3 == -1 || i3 != 0) {
            return false;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[Catch: zzdu -> 0x005c, TryCatch #0 {zzdu -> 0x005c, blocks: (B:12:0x001d, B:15:0x0027, B:18:0x002f, B:24:0x003c, B:28:0x0061, B:30:0x0065, B:37:0x0078, B:40:0x007f, B:45:0x00a3, B:35:0x0070), top: B:54:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a3 A[Catch: zzdu -> 0x005c, TRY_LEAVE, TryCatch #0 {zzdu -> 0x005c, blocks: (B:12:0x001d, B:15:0x0027, B:18:0x002f, B:24:0x003c, B:28:0x0061, B:30:0x0065, B:37:0x0078, B:40:0x007f, B:45:0x00a3, B:35:0x0070), top: B:54:0x001d }] */
    @Override // com.google.android.gms.internal.ads.zzadl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j1(com.google.android.gms.internal.ads.zzv r12) throws com.google.android.gms.internal.ads.zzadk {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacc.j1(com.google.android.gms.internal.ads.zzv):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void l1(List list) {
        if (this.f22705a.equals(list)) {
            return;
        }
        this.f22705a = zzgtd.r(list);
        zzv zzvVar = this.f22706b;
        if (zzvVar == null) {
            return;
        }
        zzt zztVar = new zzt(zzvVar);
        zzi zziVar = zzvVar.C;
        if (zziVar == null || !zziVar.d()) {
            zziVar = zzi.f34610h;
        }
        zztVar.B = zziVar;
        zztVar.b();
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void m1(long j2) {
        this.f22707c = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void n1(zzv zzvVar, long j2, int i2, List list) {
        zzgqa.f(false);
        this.f22705a = zzgtd.r(list);
        this.f22706b = zzvVar;
        this.f22710f.getClass();
        zzt zztVar = new zzt(zzvVar);
        zzi zziVar = zzvVar.C;
        if (zziVar == null || !zziVar.d()) {
            zziVar = zzi.f34610h;
        }
        zztVar.B = zziVar;
        zztVar.b();
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void o1(zzacj zzacjVar) {
        ((zzabn) this.f22710f.f22719e).f22659j = zzacjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void y() {
        zzaci zzaciVar = this.f22710f;
        if (zzaciVar.n == 2) {
            return;
        }
        zzdx zzdxVar = zzaciVar.f22725k;
        if (zzdxVar != null) {
            zzdxVar.zzm();
        }
        zzaciVar.f22726l = null;
        zzaciVar.n = 2;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zza() {
        zzaci zzaciVar = this.f22710f;
        if (zzaciVar.f22718d) {
            ((zzabn) zzaciVar.f22719e).zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zzb() {
        zzaci zzaciVar = this.f22710f;
        if (zzaciVar.f22718d) {
            ((zzabn) zzaciVar.f22719e).zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zzi() {
        long j2 = this.f22708d;
        zzaci zzaciVar = this.f22710f;
        zzaciVar.getClass();
        if (zzaciVar.o >= j2) {
            ((zzabn) zzaciVar.f22719e).zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final boolean zzj() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final Surface zzk() {
        zzgqa.f(false);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zzq() {
        zzaci zzaciVar = this.f22710f;
        zzaciVar.getClass();
        zzes.f30200c.getClass();
        zzaciVar.f22726l = null;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void k1(zzadi zzadiVar) {
    }
}
