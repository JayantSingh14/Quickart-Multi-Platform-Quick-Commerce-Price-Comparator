package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.SparseArray;
import java.io.IOException;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public final class zzoz implements zzmu {

    /* renamed from: a, reason: collision with root package name */
    public final zzdn f35268a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbd f35269b;

    /* renamed from: c, reason: collision with root package name */
    public final zzbe f35270c;

    /* renamed from: d, reason: collision with root package name */
    public final zzoy f35271d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray f35272e;

    /* renamed from: f, reason: collision with root package name */
    public zzed f35273f;

    /* renamed from: g, reason: collision with root package name */
    public zzms f35274g;

    /* renamed from: h, reason: collision with root package name */
    public zzdx f35275h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f35276i;

    public zzoz(zzdn zzdnVar) {
        zzdnVar.getClass();
        this.f35268a = zzdnVar;
        String str = zzfj.f31254a;
        Looper looperMyLooper = Looper.myLooper();
        this.f35273f = new zzed(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper, zzdnVar);
        zzbd zzbdVar = new zzbd();
        this.f35269b = zzbdVar;
        this.f35270c = new zzbe();
        this.f35271d = new zzoy(zzbdVar);
        this.f35272e = new SparseArray();
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void a(final zzbv zzbvVar) {
        final zzmv zzmvVarO = o();
        k(zzmvVarO, 25, new zzdy(zzmvVarO, zzbvVar) { // from class: com.google.android.gms.internal.ads.zzoo

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ zzbv f35255a;

            {
                this.f35255a = zzbvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdy
            public final /* synthetic */ void zza(Object obj) {
                zzbv zzbvVar2 = this.f35255a;
                ((zzmx) obj).b(zzbvVar2);
                int i2 = zzbvVar2.f25578a;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void b(final int i2, final zzba zzbaVar, final zzba zzbaVar2) {
        if (i2 == 1) {
            this.f35276i = false;
            i2 = 1;
        }
        zzms zzmsVar = this.f35274g;
        zzmsVar.getClass();
        zzoy zzoyVar = this.f35271d;
        zzoyVar.f35265d = zzoy.c(zzmsVar, zzoyVar.f35263b, zzoyVar.f35266e, zzoyVar.f35262a);
        final zzmv zzmvVarL = l();
        k(zzmvVarL, 11, new zzdy(zzmvVarL, i2, zzbaVar, zzbaVar2) { // from class: com.google.android.gms.internal.ads.zzoj

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f35254a;

            {
                this.f35254a = i2;
            }

            @Override // com.google.android.gms.internal.ads.zzdy
            public final /* synthetic */ void zza(Object obj) {
                ((zzmx) obj).i(this.f35254a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void c() {
        k(o(), 24, new zznp());
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void d(int i2, zzwg zzwgVar, zzvx zzvxVar, zzwc zzwcVar, int i3) {
        k(p(i2, zzwgVar), 1000, new zznq());
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void e(int i2, zzwg zzwgVar, final zzwc zzwcVar) {
        final zzmv zzmvVarP = p(i2, zzwgVar);
        k(zzmvVarP, 1004, new zzdy() { // from class: com.google.android.gms.internal.ads.zznv
            @Override // com.google.android.gms.internal.ads.zzdy
            public final /* synthetic */ void zza(Object obj) {
                ((zzmx) obj).e(zzmvVarP, zzwcVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void f(zzau zzauVar) {
        zzwg zzwgVar;
        k((!(zzauVar instanceof zzit) || (zzwgVar = ((zzit) zzauVar).f34972h) == null) ? l() : n(zzwgVar), 10, new zzoi());
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void g(int i2, zzwg zzwgVar, final zzvx zzvxVar, final zzwc zzwcVar, final IOException iOException, final boolean z) {
        final zzmv zzmvVarP = p(i2, zzwgVar);
        k(zzmvVarP, 1003, new zzdy(zzmvVarP, zzvxVar, zzwcVar, iOException, z) { // from class: com.google.android.gms.internal.ads.zznt

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IOException f35249a;

            {
                this.f35249a = iOException;
            }

            @Override // com.google.android.gms.internal.ads.zzdy
            public final /* synthetic */ void zza(Object obj) {
                ((zzmx) obj).h(this.f35249a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void h(final zzau zzauVar) {
        zzwg zzwgVar;
        final zzmv zzmvVarL = (!(zzauVar instanceof zzit) || (zzwgVar = ((zzit) zzauVar).f34972h) == null) ? l() : n(zzwgVar);
        k(zzmvVarL, 10, new zzdy(zzmvVarL, zzauVar) { // from class: com.google.android.gms.internal.ads.zzoh

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ zzau f35253a;

            {
                this.f35253a = zzauVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdy
            public final /* synthetic */ void zza(Object obj) {
                ((zzmx) obj).n(this.f35253a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void i(int i2, zzwg zzwgVar, zzvx zzvxVar, zzwc zzwcVar) {
        k(p(i2, zzwgVar), 1002, new zzns());
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void j(int i2, zzwg zzwgVar, zzvx zzvxVar, zzwc zzwcVar) {
        k(p(i2, zzwgVar), DateUtils.SEMI_MONTH, new zznr());
    }

    public final void k(zzmv zzmvVar, int i2, zzdy zzdyVar) {
        this.f35272e.put(i2, zzmvVar);
        zzed zzedVar = this.f35273f;
        zzedVar.c(i2, zzdyVar);
        zzedVar.d();
    }

    public final zzmv l() {
        return n(this.f35271d.f35265d);
    }

    public final zzmv m(zzbf zzbfVar, int i2, zzwg zzwgVar) {
        zzwg zzwgVar2 = true == zzbfVar.g() ? null : zzwgVar;
        long jZzb = this.f35268a.zzb();
        boolean z = zzbfVar.equals(this.f35274g.zzq()) && i2 == this.f35274g.zzs();
        long jR = 0;
        if (zzwgVar2 == null || !zzwgVar2.b()) {
            if (z) {
                zzms zzmsVar = this.f35274g;
                zzmsVar.f35227c.b();
                zzkp zzkpVar = zzmsVar.f35226b;
                zzkpVar.o();
                jR = zzkpVar.f(zzkpVar.X);
            } else if (!zzbfVar.g()) {
                zzbfVar.b(i2, this.f35270c, 0L).getClass();
                jR = zzfj.r(0L);
            }
        } else if (z && this.f35274g.g() == zzwgVar2.f35759b && this.f35274g.h() == zzwgVar2.f35760c) {
            jR = this.f35274g.d();
        }
        zzwg zzwgVar3 = this.f35271d.f35265d;
        zzbf zzbfVarZzq = this.f35274g.zzq();
        int iZzs = this.f35274g.zzs();
        long jD = this.f35274g.d();
        zzms zzmsVar2 = this.f35274g;
        zzmsVar2.f35227c.b();
        return new zzmv(jZzb, zzbfVar, i2, zzwgVar2, jR, zzbfVarZzq, iZzs, zzwgVar3, jD, zzmsVar2.f35226b.u());
    }

    public final zzmv n(zzwg zzwgVar) {
        this.f35274g.getClass();
        zzbf zzbfVar = zzwgVar == null ? null : (zzbf) this.f35271d.f35264c.get(zzwgVar);
        if (zzwgVar != null && zzbfVar != null) {
            return m(zzbfVar, zzbfVar.o(zzwgVar.f35758a, this.f35269b).f24739c, zzwgVar);
        }
        int iZzs = this.f35274g.zzs();
        zzbf zzbfVarZzq = this.f35274g.zzq();
        if (iZzs >= zzbfVarZzq.a()) {
            zzbfVarZzq = zzbf.f24868a;
        }
        return m(zzbfVarZzq, iZzs, null);
    }

    public final zzmv o() {
        return n(this.f35271d.f35267f);
    }

    public final zzmv p(int i2, zzwg zzwgVar) {
        zzms zzmsVar = this.f35274g;
        zzmsVar.getClass();
        if (zzwgVar != null) {
            return ((zzbf) this.f35271d.f35264c.get(zzwgVar)) != null ? n(zzwgVar) : m(zzbf.f24868a, i2, zzwgVar);
        }
        zzbf zzbfVarZzq = zzmsVar.zzq();
        if (i2 >= zzbfVarZzq.a()) {
            zzbfVarZzq = zzbf.f24868a;
        }
        return m(zzbfVarZzq, i2, null);
    }

    public final void q(final zzms zzmsVar, Looper looper) {
        boolean z = true;
        if (this.f35274g != null && !this.f35271d.f35263b.isEmpty()) {
            z = false;
        }
        zzgqa.f(z);
        zzmsVar.getClass();
        this.f35274g = zzmsVar;
        this.f35275h = this.f35268a.a(looper, null);
        zzed zzedVar = this.f35273f;
        this.f35273f = new zzed(zzedVar.f29100d, looper, zzedVar.f29097a, new zzdz() { // from class: com.google.android.gms.internal.ads.zzox
            @Override // com.google.android.gms.internal.ads.zzdz
            public final /* synthetic */ void a(Object obj, zzs zzsVar) {
                ((zzmx) obj).a(zzmsVar, new zzmw(zzsVar, this.f35260a.f35272e));
            }
        }, zzedVar.f29105i);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzb() {
        zzms zzmsVar = this.f35274g;
        zzmsVar.getClass();
        zzoy zzoyVar = this.f35271d;
        zzoyVar.f35265d = zzoy.c(zzmsVar, zzoyVar.f35263b, zzoyVar.f35266e, zzoyVar.f35262a);
        zzoyVar.a(zzmsVar.zzq());
        k(l(), 0, new zznw());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzc() {
        k(l(), 1, new zznx());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzd() {
        k(l(), 2, new zzny());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zze() {
        k(l(), 14, new zzol());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzf() {
        k(l(), 3, new zznz());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzg() {
        k(l(), 13, new zzoa());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzh() {
        k(l(), -1, new zzob());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzi(final int i2) {
        final zzmv zzmvVarL = l();
        k(zzmvVarL, 4, new zzdy(zzmvVarL, i2) { // from class: com.google.android.gms.internal.ads.zzoc

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f35252a;

            {
                this.f35252a = i2;
            }

            @Override // com.google.android.gms.internal.ads.zzdy
            public final /* synthetic */ void zza(Object obj) {
                ((zzmx) obj).c(this.f35252a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzj() {
        k(l(), 5, new zzod());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzk() {
        k(l(), 6, new zzoe());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzl() {
        k(l(), 7, new zzog());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzp() {
        k(l(), 12, new zzok());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzq() {
        k(o(), 21, new zzon());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzr() {
        k(o(), 22, new zznd());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzs() {
        k(o(), 23, new zzom());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zza() {
    }
}
