package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfiw implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfix f31240a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f31241b;

    public zzfiw(zzfix zzfixVar, int i2) {
        this.f31241b = i2;
        Objects.requireNonNull(zzfixVar);
        this.f31240a = zzfixVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.C.f21684h.d("BufferingUrlPinger.attributionReportingManager", th);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        String str = (String) obj;
        zzfix zzfixVar = this.f31240a;
        zzfhr zzfhrVar = zzfixVar.f31242a;
        if (!zzfhrVar.i0) {
            zzfixVar.f31244c.b(str, zzfhrVar.x0, zzfixVar.f31246e, null);
            return;
        }
        String str2 = zzfixVar.f31243b.f31167b;
        zzfpa zzfpaVar = zzfixVar.f31245d;
        zzfpaVar.getClass();
        zzehw zzehwVar = new zzehw(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis(), str2, str, this.f31241b);
        zzehu zzehuVar = zzfpaVar.f31533a;
        zzehuVar.getClass();
        zzehuVar.a(new zzehr(zzehuVar, zzehwVar));
    }
}
