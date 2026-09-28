package com.google.android.gms.internal.ads;

import android.view.Surface;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzabn implements zzadl {

    /* renamed from: a, reason: collision with root package name */
    public final zzacm f22650a;

    /* renamed from: b, reason: collision with root package name */
    public final zzacn f22651b;

    /* renamed from: c, reason: collision with root package name */
    public final zzacu f22652c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f22653d;

    /* renamed from: e, reason: collision with root package name */
    public Surface f22654e;

    /* renamed from: f, reason: collision with root package name */
    public zzv f22655f;

    /* renamed from: g, reason: collision with root package name */
    public long f22656g;

    /* renamed from: h, reason: collision with root package name */
    public zzadi f22657h;

    /* renamed from: i, reason: collision with root package name */
    public Executor f22658i;

    /* renamed from: j, reason: collision with root package name */
    public zzacj f22659j;

    public zzabn(zzacm zzacmVar, zzacn zzacnVar, zzfc zzfcVar) {
        this.f22650a = zzacmVar;
        this.f22651b = zzacnVar;
        zzacmVar.f22740k = zzfcVar;
        this.f22652c = new zzacu(new zzabm(this), zzacmVar, zzacnVar);
        this.f22653d = new ArrayDeque();
        this.f22655f = new zzv(new zzt());
        this.f22656g = -9223372036854775807L;
        this.f22657h = zzadi.f22798a;
        this.f22658i = zzabi.f22644a;
        this.f22659j = zzabg.f22642a;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final boolean B0(boolean z) {
        return this.f22650a.e(z);
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void N0(boolean z) {
        if (z) {
            zzacm zzacmVar = this.f22650a;
            zzacmVar.f22731b.a();
            zzacmVar.f22736g = -9223372036854775807L;
            zzacmVar.f22734e = -9223372036854775807L;
            zzacmVar.f22733d = Math.min(zzacmVar.f22733d, 1);
            zzacmVar.f22737h = -9223372036854775807L;
        }
        this.f22651b.a();
        zzacu zzacuVar = this.f22652c;
        zzeg zzegVar = zzacuVar.f22770e;
        zzegVar.f29264a = 0;
        zzegVar.f29265b = -1;
        zzegVar.f29266c = 0;
        zzacuVar.f22772g = -9223372036854775807L;
        zzacuVar.f22773h = -9223372036854775807L;
        zzacuVar.f22774i = -9223372036854775807L;
        zzff zzffVar = zzacuVar.f22769d;
        if (zzffVar.b() > 0) {
            zzgqa.a(zzffVar.b() > 0);
            while (zzffVar.b() > 1) {
                zzffVar.c();
            }
            Object objC = zzffVar.c();
            objC.getClass();
            zzacuVar.f22776k = ((Long) objC).longValue();
        }
        zzff zzffVar2 = zzacuVar.f22768c;
        if (zzffVar2.b() > 0) {
            zzgqa.a(zzffVar2.b() > 0);
            while (zzffVar2.b() > 1) {
                zzffVar2.c();
            }
            Object objC2 = zzffVar2.c();
            objC2.getClass();
            zzffVar2.a(0L, (zzbv) objC2);
        }
        this.f22653d.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void P(boolean z) {
        zzacm zzacmVar = this.f22650a;
        zzacmVar.f22738i = z;
        zzacmVar.f22737h = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void Q0(float f2) {
        this.f22650a.g(f2);
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void f() {
        zzacm zzacmVar = this.f22650a;
        if (zzacmVar.f22733d == 0) {
            zzacmVar.f22733d = 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void f1(int i2) {
        zzact zzactVar = this.f22650a.f22731b;
        if (zzactVar.f22762j == i2) {
            return;
        }
        zzactVar.f22762j = i2;
        zzactVar.c(true);
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void g1(long j2, long j3) {
        try {
            this.f22652c.a(j2, j3);
        } catch (zzit e2) {
            throw new zzadk(e2, this.f22655f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void h1(Surface surface, zzes zzesVar) {
        this.f22654e = surface;
        this.f22650a.c(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final boolean i1(long j2, zzadj zzadjVar) {
        this.f22653d.add(zzadjVar);
        zzacu zzacuVar = this.f22652c;
        zzeg zzegVar = zzacuVar.f22770e;
        int i2 = zzegVar.f29266c;
        long[] jArr = zzegVar.f29267d;
        int length = jArr.length;
        if (i2 == length) {
            int i3 = length + length;
            if (i3 < 0) {
                throw new IllegalStateException();
            }
            long[] jArr2 = new long[i3];
            int i4 = zzegVar.f29264a;
            int i5 = length - i4;
            System.arraycopy(jArr, i4, jArr2, 0, i5);
            System.arraycopy(zzegVar.f29267d, 0, jArr2, i5, i4);
            zzegVar.f29264a = 0;
            zzegVar.f29265b = zzegVar.f29266c - 1;
            zzegVar.f29267d = jArr2;
            zzegVar.f29268e = i3 - 1;
            jArr = jArr2;
        }
        int i6 = (zzegVar.f29265b + 1) & zzegVar.f29268e;
        zzegVar.f29265b = i6;
        jArr[i6] = j2;
        zzegVar.f29266c++;
        zzacuVar.f22772g = j2;
        zzacuVar.f22774i = -9223372036854775807L;
        this.f22658i.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f22643a.f22657h.zza();
            }
        });
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final boolean j1(zzv zzvVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void k1(zzadi zzadiVar) {
        zzgyb zzgybVar = zzgyb.f33369a;
        this.f22657h = zzadiVar;
        this.f22658i = zzgybVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void l1(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void m1(long j2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void n1(zzv zzvVar, long j2, int i2, List list) {
        zzgqa.f(list.isEmpty());
        int i3 = zzvVar.t;
        zzv zzvVar2 = this.f22655f;
        int i4 = zzvVar2.t;
        zzacu zzacuVar = this.f22652c;
        int i5 = zzvVar.u;
        if (i3 != i4 || i5 != zzvVar2.u) {
            long j3 = zzacuVar.f22772g;
            zzacuVar.f22768c.a(j3 == -9223372036854775807L ? 0L : j3 + 1, new zzbv(1.0f, i3, i5));
        }
        float f2 = this.f22655f.x;
        float f3 = zzvVar.x;
        if (f3 != f2) {
            this.f22650a.d(f3);
        }
        this.f22655f = zzvVar;
        if (j2 != this.f22656g) {
            if (zzacuVar.f22770e.f29266c == 0) {
                zzacuVar.f22766a.a(i2);
                zzacuVar.f22776k = j2;
            } else {
                long j4 = zzacuVar.f22772g;
                zzacuVar.f22769d.a(j4 == -9223372036854775807L ? -4611686018427387904L : j4 + 1, Long.valueOf(j2));
            }
            this.f22656g = j2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void o1(zzacj zzacjVar) {
        this.f22659j = zzacjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void y() {
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zza() {
        this.f22651b.a();
        this.f22650a.b();
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zzb() {
        this.f22651b.a();
        zzacm zzacmVar = this.f22650a;
        zzacmVar.f22732c = false;
        zzacmVar.f22737h = -9223372036854775807L;
        zzact zzactVar = zzacmVar.f22731b;
        zzactVar.f22756d = false;
        zzacp zzacpVar = zzactVar.f22755c;
        if (zzacpVar != null) {
            zzacpVar.b();
        }
        zzactVar.d();
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zzf() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zzi() {
        zzacu zzacuVar = this.f22652c;
        long j2 = zzacuVar.f22772g;
        if (j2 == -9223372036854775807L) {
            j2 = Long.MIN_VALUE;
            zzacuVar.f22772g = Long.MIN_VALUE;
            zzacuVar.f22773h = Long.MIN_VALUE;
        }
        zzacuVar.f22774i = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final boolean zzj() {
        zzacu zzacuVar = this.f22652c;
        long j2 = zzacuVar.f22774i;
        return j2 != -9223372036854775807L && zzacuVar.f22773h == j2;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final Surface zzk() {
        Surface surface = this.f22654e;
        surface.getClass();
        return surface;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zzq() {
        this.f22654e = null;
        this.f22650a.c(null);
    }
}
