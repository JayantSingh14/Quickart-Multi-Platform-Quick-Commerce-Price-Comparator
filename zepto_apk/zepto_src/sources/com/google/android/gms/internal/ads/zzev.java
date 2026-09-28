package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzev {

    /* renamed from: a, reason: collision with root package name */
    public final int f30387a;

    /* renamed from: b, reason: collision with root package name */
    public Object f30388b;

    /* renamed from: c, reason: collision with root package name */
    public int f30389c;

    /* renamed from: d, reason: collision with root package name */
    public int f30390d;

    /* renamed from: e, reason: collision with root package name */
    public long f30391e;

    /* renamed from: f, reason: collision with root package name */
    public long f30392f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f30393g;

    /* renamed from: h, reason: collision with root package name */
    public long f30394h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ zzfa f30395i;

    public zzev(zzfa zzfaVar, int i2) {
        Objects.requireNonNull(zzfaVar);
        this.f30395i = zzfaVar;
        this.f30387a = i2;
    }

    public final void a() {
        zzdx zzdxVar;
        zzfa zzfaVar = this.f30395i;
        int iZzh = ((zzkp) zzfaVar.f30705a).zzh();
        zzdx zzdxVar2 = zzfaVar.f30709e;
        if (iZzh == 2) {
            zzkp zzkpVar = (zzkp) zzfaVar.f30705a;
            if (zzkpVar.zzk() && zzkpVar.zzi() == 0) {
                zzbf zzbfVarZzq = zzkpVar.zzq();
                Object objF = zzbfVarZzq.g() ? null : zzbfVarZzq.f(zzkpVar.q());
                int iW = zzkpVar.w();
                int iX = zzkpVar.x();
                long jT = zzkpVar.t();
                long jMax = Math.max(0L, zzkpVar.u() - Math.max(0L, jT - zzkpVar.s()));
                if (objF != null && iW == -1) {
                    zzbfVarZzq.o(objF, zzfaVar.f30708d);
                    jT -= zzfj.r(0L);
                    iW = -1;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                boolean z = this.f30393g;
                int i2 = this.f30387a;
                if (z && Objects.equals(objF, this.f30388b) && iW == this.f30389c && iX == this.f30390d) {
                    zzdxVar = zzdxVar2;
                    if (jT == this.f30391e && jMax == this.f30392f) {
                        if (jElapsedRealtime - this.f30394h >= i2) {
                            zzfaVar.f30707c.a(new zzfb(1, i2));
                            return;
                        }
                        return;
                    }
                } else {
                    zzdxVar = zzdxVar2;
                }
                this.f30393g = true;
                this.f30394h = jElapsedRealtime;
                this.f30388b = objF;
                this.f30389c = iW;
                this.f30390d = iX;
                this.f30391e = jT;
                this.f30392f = jMax;
                zzdxVar.r(1);
                zzdxVar.zzi(1, i2);
                return;
            }
        }
        if (this.f30393g) {
            zzdxVar2.r(1);
        }
        this.f30393g = false;
    }
}
