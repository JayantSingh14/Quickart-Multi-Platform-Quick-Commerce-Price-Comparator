package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzvj implements zzxw {

    /* renamed from: a, reason: collision with root package name */
    public final zzxw f35707a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f35708b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzvk f35709c;

    public zzvj(zzvk zzvkVar, zzxw zzxwVar) {
        Objects.requireNonNull(zzvkVar);
        this.f35709c = zzvkVar;
        this.f35707a = zzxwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final int a(long j2) {
        if (this.f35709c.h()) {
            return -3;
        }
        return this.f35707a.a(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final int b(zzle zzleVar, zzih zzihVar, int i2) {
        zzvk zzvkVar = this.f35709c;
        if (zzvkVar.h()) {
            return -3;
        }
        if (this.f35708b) {
            zzihVar.f34703a = 4;
            return -4;
        }
        long jZzi = zzvkVar.zzi();
        int iB = this.f35707a.b(zzleVar, zzihVar, i2);
        if (iB != -5) {
            long j2 = zzvkVar.f35714e;
            if (j2 == Long.MIN_VALUE || ((iB != -4 || zzihVar.f34831f < j2) && !(iB == -3 && jZzi == Long.MIN_VALUE && !zzihVar.f34830e))) {
                return iB;
            }
            zzihVar.c();
            zzihVar.f34703a = 4;
            this.f35708b = true;
            return -4;
        }
        zzv zzvVar = zzleVar.f35082b;
        zzvVar.getClass();
        int i3 = zzvVar.I;
        int i4 = zzvVar.H;
        if (i4 == 0) {
            if (i3 == 0) {
                return -5;
            }
            i4 = 0;
        }
        int i5 = zzvkVar.f35714e == Long.MIN_VALUE ? i3 : 0;
        zzt zztVar = new zzt(zzvVar);
        zztVar.G = i4;
        zztVar.H = i5;
        zzleVar.f35082b = new zzv(zztVar);
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final boolean zzb() {
        return !this.f35709c.h() && this.f35707a.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void zzc() {
        this.f35707a.zzc();
    }
}
