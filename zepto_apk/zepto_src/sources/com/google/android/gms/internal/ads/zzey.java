package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzey {

    /* renamed from: a, reason: collision with root package name */
    public final int f30558a;

    /* renamed from: b, reason: collision with root package name */
    public Object f30559b;

    /* renamed from: c, reason: collision with root package name */
    public int f30560c;

    /* renamed from: d, reason: collision with root package name */
    public int f30561d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f30562e;

    /* renamed from: f, reason: collision with root package name */
    public long f30563f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzfa f30564g;

    public zzey(zzfa zzfaVar, int i2) {
        Objects.requireNonNull(zzfaVar);
        this.f30564g = zzfaVar;
        this.f30558a = i2;
    }

    public final void a() {
        long jR;
        zzfa zzfaVar = this.f30564g;
        zzbf zzbfVarZzq = ((zzkp) zzfaVar.f30705a).zzq();
        boolean zG = zzbfVarZzq.g();
        zzbb zzbbVar = zzfaVar.f30705a;
        Object objF = zG ? null : zzbfVarZzq.f(((zzkp) zzbbVar).q());
        zzkp zzkpVar = (zzkp) zzbbVar;
        int iW = zzkpVar.w();
        int iX = zzkpVar.x();
        long jS = zzkpVar.s();
        if (objF == null || iW != -1) {
            jR = iW != -1 ? zzkpVar.r() : -9223372036854775807L;
        } else {
            zzbd zzbdVar = zzfaVar.f30708d;
            zzbfVarZzq.o(objF, zzbdVar);
            jS -= zzfj.r(0L);
            jR = zzfj.r(zzbdVar.f24740d);
            iW = -1;
        }
        boolean zA = ((zzf) zzbbVar).a();
        zzdx zzdxVar = zzfaVar.f30709e;
        if (!zA || jR == -9223372036854775807L || jS < jR) {
            zzdxVar.r(3);
            if (zA && jR != -9223372036854775807L) {
                zzkpVar.o();
                zzdxVar.zzi(3, (int) Math.ceil((jR - jS) / zzkpVar.X.o.f24412a));
            }
            this.f30562e = false;
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = this.f30562e;
        int i2 = this.f30558a;
        if (z && Objects.equals(objF, this.f30559b) && iW == this.f30560c && iX == this.f30561d) {
            if (jElapsedRealtime - this.f30563f >= i2) {
                zzfaVar.f30707c.a(new zzfb(3, i2));
                return;
            }
            return;
        }
        this.f30562e = true;
        this.f30563f = jElapsedRealtime;
        this.f30559b = objF;
        this.f30560c = iW;
        this.f30561d = iX;
        zzdxVar.r(3);
        zzdxVar.zzi(3, i2);
    }
}
