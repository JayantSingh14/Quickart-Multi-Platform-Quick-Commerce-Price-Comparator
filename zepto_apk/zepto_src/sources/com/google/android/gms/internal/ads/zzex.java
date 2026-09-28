package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzex {

    /* renamed from: a, reason: collision with root package name */
    public final int f30505a;

    /* renamed from: b, reason: collision with root package name */
    public Object f30506b;

    /* renamed from: c, reason: collision with root package name */
    public int f30507c;

    /* renamed from: d, reason: collision with root package name */
    public int f30508d;

    /* renamed from: e, reason: collision with root package name */
    public long f30509e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f30510f;

    /* renamed from: g, reason: collision with root package name */
    public long f30511g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzfa f30512h;

    public zzex(zzfa zzfaVar, int i2) {
        Objects.requireNonNull(zzfaVar);
        this.f30512h = zzfaVar;
        this.f30505a = i2;
    }

    public final void a() {
        zzfa zzfaVar = this.f30512h;
        boolean zA = ((zzf) zzfaVar.f30705a).a();
        zzdx zzdxVar = zzfaVar.f30709e;
        if (!zA) {
            if (this.f30510f) {
                zzdxVar.r(2);
            }
            this.f30510f = false;
            return;
        }
        zzkp zzkpVar = (zzkp) zzfaVar.f30705a;
        zzbf zzbfVarZzq = zzkpVar.zzq();
        Object objF = zzbfVarZzq.g() ? null : zzbfVarZzq.f(zzkpVar.q());
        int iW = zzkpVar.w();
        int iX = zzkpVar.x();
        long jS = zzkpVar.s();
        if (objF != null && iW == -1) {
            zzbfVarZzq.o(objF, zzfaVar.f30708d);
            jS -= zzfj.r(0L);
            iW = -1;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = this.f30510f;
        int i2 = this.f30505a;
        if (z && Objects.equals(objF, this.f30506b) && iW == this.f30507c && iX == this.f30508d && jS == this.f30509e) {
            if (jElapsedRealtime - this.f30511g >= i2) {
                zzfaVar.f30707c.a(new zzfb(2, i2));
                return;
            }
            return;
        }
        this.f30510f = true;
        this.f30511g = jElapsedRealtime;
        this.f30506b = objF;
        this.f30507c = iW;
        this.f30508d = iX;
        this.f30509e = jS;
        zzdxVar.r(2);
        zzdxVar.zzi(2, i2);
    }
}
